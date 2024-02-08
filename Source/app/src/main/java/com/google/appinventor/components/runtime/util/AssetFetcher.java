package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.ReplForm;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class AssetFetcher {
    private static Context context = ReplForm.getActiveForm();
    private static HashDatabase db = new HashDatabase(context);
    private static final String LOG_TAG = AssetFetcher.class.getSimpleName();
    private static ExecutorService background = Executors.newSingleThreadExecutor();
    private static volatile boolean inError = false;
    private static final Object semaphore = new Object();

    private AssetFetcher() {
    }

    public static void fetchAssets(final String cookieValue, final String projectId, final String uri, final String asset) {
        background.submit(new Runnable() { // from class: com.google.appinventor.components.runtime.util.AssetFetcher.1
            @Override // java.lang.Runnable
            public void run() {
                String fileName = uri + "/ode/download/file/" + projectId + "/" + asset;
                if (AssetFetcher.getFile(fileName, cookieValue, asset, 0) != null) {
                    RetValManager.assetTransferred(asset);
                }
            }
        });
    }

    public static void upgradeCompanion(final String cookieValue, final String inputUri) {
        background.submit(new Runnable() { // from class: com.google.appinventor.components.runtime.util.AssetFetcher.2
            @Override // java.lang.Runnable
            public void run() {
                String[] parts = inputUri.split("/", 0);
                String asset = parts[parts.length - 1];
                File assetFile = AssetFetcher.getFile(inputUri, cookieValue, asset, 0);
                if (assetFile != null) {
                    try {
                        Form form = Form.getActiveForm();
                        Intent intent = new Intent("android.intent.action.VIEW");
                        Uri packageuri = NougatUtil.getPackageUri(form, assetFile);
                        intent.setDataAndType(packageuri, "application/vnd.android.package-archive");
                        intent.setFlags(1);
                        form.startActivity(intent);
                    } catch (Exception e) {
                        Log.e(AssetFetcher.LOG_TAG, "ERROR_UNABLE_TO_GET", e);
                        RetValManager.sendError("Unable to Install new Companion Package.");
                    }
                }
            }
        });
    }

    public static void loadExtensions(String jsonString) {
        Log.d(LOG_TAG, "loadExtensions called jsonString = " + jsonString);
        try {
            ReplForm form = (ReplForm) Form.getActiveForm();
            JSONArray array = new JSONArray(jsonString);
            List<String> extensionsToLoad = new ArrayList<>();
            if (array.length() == 0) {
                Log.d(LOG_TAG, "loadExtensions: No Extensions");
                RetValManager.extensionsLoaded();
                return;
            }
            for (int i = 0; i < array.length(); i++) {
                String extensionName = array.optString(i);
                if (extensionName != null) {
                    Log.d(LOG_TAG, "loadExtensions, extensionName = " + extensionName);
                    extensionsToLoad.add(extensionName);
                } else {
                    Log.e(LOG_TAG, "extensionName was null");
                    return;
                }
            }
            try {
                form.loadComponents(extensionsToLoad);
                RetValManager.extensionsLoaded();
            } catch (Exception e) {
                Log.e(LOG_TAG, "Error in form.loadComponents", e);
            }
        } catch (JSONException e2) {
            Log.e(LOG_TAG, "JSON Exception parsing extension string", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File getFile(final String fileName, String cookieValue, String asset, int depth) {
        File file;
        Form form = Form.getActiveForm();
        if (depth > 1) {
            synchronized (semaphore) {
                if (inError) {
                    file = null;
                } else {
                    inError = true;
                    form.runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.util.AssetFetcher.3
                        @Override // java.lang.Runnable
                        public void run() {
                            RuntimeErrorAlert.alert(Form.getActiveForm(), "Unable to load file: " + fileName, "Error!", "End Application");
                        }
                    });
                    file = null;
                }
            }
            return file;
        }
        int responseCode = 0;
        File outFile = new File(QUtil.getReplAssetPath(form, true), asset.substring("assets/".length()));
        Log.d(LOG_TAG, "target file = " + outFile);
        String fileHash = null;
        boolean error = false;
        try {
            URL url = new URL(fileName);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection != null) {
                connection.addRequestProperty("Cookie", "AppInventor = " + cookieValue);
                HashFile hashFile = db.getHashFile(asset);
                if (hashFile != null) {
                    connection.addRequestProperty("If-None-Match", hashFile.getHash());
                }
                connection.setRequestMethod("GET");
                responseCode = connection.getResponseCode();
                Log.d(LOG_TAG, "asset = " + asset + " responseCode = " + responseCode);
                File parentOutFile = outFile.getParentFile();
                fileHash = connection.getHeaderField("ETag");
                if (responseCode != 304) {
                    if (!parentOutFile.exists() && !parentOutFile.mkdirs()) {
                        throw new IOException("Unable to create assets directory " + parentOutFile);
                    }
                    BufferedInputStream in = new BufferedInputStream(connection.getInputStream(), 4096);
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile), 4096);
                    while (true) {
                        try {
                            int b = in.read();
                            if (b == -1) {
                                break;
                            }
                            out.write(b);
                        } catch (IOException e) {
                            Log.e(LOG_TAG, "copying assets", e);
                            error = true;
                            out.close();
                        }
                    }
                    out.flush();
                    out.close();
                    connection.disconnect();
                } else {
                    return outFile;
                }
            } else {
                error = true;
            }
            if (error) {
                return getFile(fileName, cookieValue, asset, depth + 1);
            }
            if (responseCode == 200) {
                Date timeStamp = new Date();
                HashFile file2 = new HashFile(asset, fileHash, timeStamp);
                if (db.getHashFile(asset) == null) {
                    db.insertHashFile(file2);
                    return outFile;
                }
                db.updateHashFile(file2);
                return outFile;
            }
            return null;
        } catch (Exception e2) {
            Log.e(LOG_TAG, "Exception while fetching " + fileName, e2);
            return getFile(fileName, cookieValue, asset, depth + 1);
        }
    }

    private static String byteArray2Hex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", Byte.valueOf(b));
        }
        return formatter.toString();
    }
}
