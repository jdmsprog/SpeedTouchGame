package com.google.appinventor.components.runtime;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.documentfile.provider.DocumentFile;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.FileScope;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.errors.StopBlocksExecution;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.Continuation;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.FileAccessMode;
import com.google.appinventor.components.runtime.util.FileOperation;
import com.google.appinventor.components.runtime.util.FileStreamWriteOperation;
import com.google.appinventor.components.runtime.util.FileUtil;
import com.google.appinventor.components.runtime.util.FileWriteOperation;
import com.google.appinventor.components.runtime.util.IOUtils;
import com.google.appinventor.components.runtime.util.ScopedFile;
import com.google.appinventor.components.runtime.util.SingleFileOperation;
import com.google.appinventor.components.runtime.util.Synchronizer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kawa.lang.SyntaxForms;

@DesignerComponent(category = ComponentCategory.STORAGE, description = "Non-visible component for storing and retrieving files. Use this component to write or read files on your device. The default behaviour is to write files to the private data directory associated with your App. The Companion is special cased to write files to a public directory for debugging. Use the More information link to read more about how the File component uses paths and scopes to manage access to files.", iconName = "images/file.png", nonVisible = SyntaxForms.DEBUGGING, version = 4)
@SimpleObject
@SuppressLint({"InlinedApi", "SdCardPath"})
/* loaded from: classes.dex */
public class File extends FileBase implements Component {
    private static final String LOG_TAG = "FileComponent";

    public File(ComponentContainer container) {
        super(container.$form());
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, userVisible = false)
    @UsesPermissions({"android.permission.READ_EXTERNAL_STORAGE"})
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void ReadPermission(boolean required) {
    }

    @SimpleProperty
    public void Scope(FileScope scope) {
        this.scope = scope;
    }

    @SimpleProperty
    public FileScope Scope() {
        return this.scope;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, userVisible = false)
    @UsesPermissions({"android.permission.WRITE_EXTERNAL_STORAGE"})
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void WritePermission(boolean required) {
    }

    @SimpleFunction
    public void MakeDirectory(FileScope scope, String directoryName, final Continuation<Boolean> continuation) {
        if (scope == FileScope.Asset) {
            this.form.dispatchErrorOccurredEvent(this, "MakeDirectory", ErrorMessages.ERROR_CANNOT_MAKE_DIRECTORY, directoryName);
        } else {
            new SingleFileOperation(this.form, this, "MakeDirectory", directoryName, scope, FileAccessMode.WRITE, false) { // from class: com.google.appinventor.components.runtime.File.1
                @Override // com.google.appinventor.components.runtime.util.SingleFileOperation
                public void processFile(ScopedFile scopedFile) {
                    java.io.File file = scopedFile.resolve(this.form);
                    if (file.exists()) {
                        if (file.isDirectory()) {
                            onSuccess();
                        } else {
                            reportError(ErrorMessages.ERROR_FILE_EXISTS_AT_PATH, file.getAbsolutePath());
                        }
                    } else if (file.mkdirs()) {
                        onSuccess();
                    } else {
                        reportError(ErrorMessages.ERROR_CANNOT_MAKE_DIRECTORY, file.getAbsolutePath());
                    }
                }

                public void onSuccess() {
                    this.form.runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.File.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            continuation.call(true);
                        }
                    });
                }
            }.run();
        }
    }

    @SimpleFunction
    public void RemoveDirectory(FileScope scope, String directoryName, final boolean recursive, Continuation<Boolean> continuation) {
        if (scope == FileScope.Asset) {
            this.form.dispatchErrorOccurredEvent(this, "RemoveDirectory", ErrorMessages.ERROR_CANNOT_REMOVE_DIRECTORY, directoryName);
            return;
        }
        final Synchronizer<Boolean> result = new Synchronizer<>();
        new FileOperation.Builder(this.form, this, "RemoveDirectory").addFile(scope, directoryName, FileAccessMode.WRITE).addCommand(new FileOperation.FileInvocation() { // from class: com.google.appinventor.components.runtime.File.2
            @Override // com.google.appinventor.components.runtime.util.FileOperation.FileInvocation
            public void call(ScopedFile[] files) {
                try {
                    ScopedFile file = files[0];
                    result.wakeup(Boolean.valueOf(FileUtil.removeDirectory(file.resolve(File.this.form), recursive)));
                } catch (Exception e) {
                    result.caught(e);
                }
            }
        }).build().run();
        AsynchUtil.finish(result, continuation);
    }

    @SimpleFunction
    public void ListDirectory(FileScope scope, String directoryName, Continuation<List<String>> continuation) {
        if (scope == FileScope.Asset && !this.form.isRepl()) {
            try {
                continuation.call(FileUtil.listDirectory(this.form, new ScopedFile(scope, directoryName)));
            } catch (IOException e) {
                this.form.dispatchErrorOccurredEvent(this, "ListDirectory", ErrorMessages.ERROR_CANNOT_LIST_DIRECTORY, directoryName);
            }
        } else if (scope == FileScope.Shared && directoryName.startsWith("content:") && Build.VERSION.SDK_INT >= 19) {
            DocumentFile dir = DocumentFile.fromTreeUri(this.form, Uri.parse(directoryName));
            DocumentFile[] files = dir.listFiles();
            List<String> result = new ArrayList<>();
            for (DocumentFile file : files) {
                result.add(file.getName());
            }
            continuation.call(result);
        } else {
            if (!directoryName.contains("/")) {
                directoryName = directoryName + "/";
            }
            final Synchronizer<List<String>> result2 = new Synchronizer<>();
            new FileOperation.Builder(this.form, this, "ListDirectory").setAskPermission(true).setAsynchronous(true).addFile(scope, directoryName, FileAccessMode.READ).addCommand(new FileOperation.FileInvocation() { // from class: com.google.appinventor.components.runtime.File.3
                @Override // com.google.appinventor.components.runtime.util.FileOperation.FileInvocation
                public void call(ScopedFile[] files2) throws IOException {
                    Log.d(File.LOG_TAG, "Listing directory " + files2[0]);
                    List<String> items = FileUtil.listDirectory(File.this.form, files2[0]);
                    if (items == null) {
                        items = Collections.emptyList();
                    }
                    result2.wakeup(items);
                }
            }).build().run();
            AsynchUtil.finish(result2, continuation);
        }
    }

    @SimpleFunction
    public void IsDirectory(FileScope scope, String path, Continuation<Boolean> continuation) {
        if (scope == FileScope.Asset && !this.form.isRepl()) {
            AssetManager manager = this.form.getAssets();
            try {
                String[] files = manager.list(path);
                Log.d(LOG_TAG, "contents of " + path + " = " + Arrays.toString(files));
                continuation.call(Boolean.valueOf(files != null && files.length > 0));
                return;
            } catch (IOException e) {
                this.form.dispatchErrorOccurredEvent(this, "IsDirectory", ErrorMessages.ERROR_DIRECTORY_DOES_NOT_EXIST, path);
                return;
            }
        }
        final Synchronizer<Boolean> result = new Synchronizer<>();
        new FileOperation.Builder(this.form, this, "IsDirectory").addFile(scope, path, FileAccessMode.READ).addCommand(new FileOperation.FileInvocation() { // from class: com.google.appinventor.components.runtime.File.4
            @Override // com.google.appinventor.components.runtime.util.FileOperation.FileInvocation
            public void call(ScopedFile[] files2) {
                Log.d(File.LOG_TAG, "IsDirectory " + files2[0]);
                result.wakeup(Boolean.valueOf(files2[0].resolve(File.this.form).isDirectory()));
            }
        }).build().run();
        AsynchUtil.finish(result, continuation);
    }

    @SimpleFunction
    public void CopyFile(FileScope fromScope, String fromFileName, FileScope toScope, String toFileName, Continuation<Boolean> continuation) {
        if (toScope == FileScope.Asset) {
            this.form.dispatchErrorOccurredEvent(this, "CopyFile", ErrorMessages.ERROR_CANNOT_WRITE_ASSET, toFileName);
            throw new StopBlocksExecution();
        }
        final Synchronizer<Boolean> result = new Synchronizer<>();
        new FileOperation.Builder(this.form, this, "CopyFile").addFile(fromScope, fromFileName, FileAccessMode.READ).addFile(toScope, toFileName, FileAccessMode.WRITE).addCommand(new FileOperation.FileInvocation() { // from class: com.google.appinventor.components.runtime.File.5
            @Override // com.google.appinventor.components.runtime.util.FileOperation.FileInvocation
            public void call(ScopedFile[] files) {
                InputStream in = null;
                OutputStream out = null;
                if (!files[1].getFileName().startsWith("content:")) {
                    java.io.File parent = files[1].resolve(File.this.form).getParentFile();
                    if (!parent.exists() && !parent.mkdirs()) {
                        File.this.form.dispatchErrorOccurredEvent(File.this, "CopyFile", ErrorMessages.ERROR_CANNOT_MAKE_DIRECTORY, parent.getAbsolutePath());
                        result.caught(new IOException());
                        return;
                    }
                }
                try {
                    try {
                        in = FileUtil.openForReading(File.this.form, files[0]);
                        out = FileUtil.openForWriting(File.this.form, files[1]);
                        FileUtil.copy(in, out);
                        IOUtils.closeQuietly(File.LOG_TAG, in);
                        IOUtils.closeQuietly(File.LOG_TAG, out);
                        result.wakeup(true);
                    } catch (IOException e) {
                        Log.w(File.LOG_TAG, "Unable to copy file", e);
                        File.this.form.dispatchErrorOccurredEvent(File.this, "CopyFile", ErrorMessages.ERROR_CANNOT_COPY_MEDIA, files[0].getFileName());
                        result.caught(e);
                        IOUtils.closeQuietly(File.LOG_TAG, in);
                        IOUtils.closeQuietly(File.LOG_TAG, out);
                    }
                } catch (Throwable th) {
                    IOUtils.closeQuietly(File.LOG_TAG, in);
                    IOUtils.closeQuietly(File.LOG_TAG, out);
                    throw th;
                }
            }
        }).build().run();
        AsynchUtil.finish(result, continuation);
    }

    @SimpleFunction
    public void MoveFile(FileScope fromScope, String fromFileName, FileScope toScope, String toFileName, Continuation<Boolean> continuation) {
        if (fromScope == FileScope.Asset) {
            this.form.dispatchErrorOccurredEvent(this, "MoveFile", ErrorMessages.ERROR_CANNOT_DELETE_ASSET, fromFileName);
        } else if (toScope == FileScope.Asset) {
            this.form.dispatchErrorOccurredEvent(this, "MoveFile", ErrorMessages.ERROR_CANNOT_WRITE_ASSET, toFileName);
        } else {
            final Synchronizer<Boolean> result = new Synchronizer<>();
            new FileOperation.Builder(this.form, this, "MoveFile").addFile(fromScope, fromFileName, FileAccessMode.READ).addFile(toScope, toFileName, FileAccessMode.WRITE).addCommand(new FileOperation.FileInvocation() { // from class: com.google.appinventor.components.runtime.File.6
                @Override // com.google.appinventor.components.runtime.util.FileOperation.FileInvocation
                public void call(ScopedFile[] files) {
                    try {
                        result.wakeup(Boolean.valueOf(FileUtil.moveFile(File.this.form, files[0], files[1])));
                    } catch (IOException e) {
                        result.wakeup(false);
                    }
                }
            }).build().run();
            AsynchUtil.finish(result, continuation);
        }
    }

    @SimpleFunction
    public void Exists(FileScope scope, String path, Continuation<Boolean> continuation) {
        final Synchronizer<Boolean> result = new Synchronizer<>();
        new FileOperation.Builder(this.form, this, "Exists").addFile(scope, path, FileAccessMode.READ).addCommand(new FileOperation.FileInvocation() { // from class: com.google.appinventor.components.runtime.File.7
            @Override // com.google.appinventor.components.runtime.util.FileOperation.FileInvocation
            public void call(ScopedFile[] files) {
                int i = 0;
                if (files[0].getScope() == FileScope.Asset && !File.this.form.isRepl()) {
                    boolean success = false;
                    try {
                        String[] items = File.this.form.getAssets().list("");
                        if (items != null) {
                            int length = items.length;
                            while (true) {
                                if (i >= length) {
                                    break;
                                }
                                String item = items[i];
                                if (!item.equals(files[0].getFileName())) {
                                    i++;
                                } else {
                                    success = true;
                                    break;
                                }
                            }
                        }
                    } catch (IOException e) {
                    }
                    result.wakeup(Boolean.valueOf(success));
                    return;
                }
                result.wakeup(Boolean.valueOf(files[0].resolve(File.this.form).exists()));
            }
        }).build().run();
        AsynchUtil.finish(result, continuation);
    }

    @SimpleFunction
    public String MakeFullPath(FileScope scope, String path) {
        return FileUtil.resolveFileName(this.form, path, scope);
    }

    @SimpleFunction(description = "Saves text to a file. If the filename begins with a slash (/) the file is written to the sdcard. For example writing to /myFile.txt will write the file to /sdcard/myFile.txt. If the filename does not start with a slash, it will be written in the programs private data directory where it will not be accessible to other programs on the phone. There is a special exception for the AI Companion where these files are written to /sdcard/AppInventor/data to facilitate debugging. Note that this block will overwrite a file if it already exists.\n\nIf you want to add content to a file use the append block.")
    public void SaveFile(String text, String fileName) {
        write(fileName, "SaveFile", text, false);
    }

    @SimpleFunction(description = "Appends text to the end of a file storage, creating the file if it does not exist. See the help text under SaveFile for information about where files are written.")
    public void AppendToFile(String text, String fileName) {
        write(fileName, "AppendToFile", text, true);
    }

    @SimpleFunction(description = "Reads text from a file in storage. Prefix the filename with / to read from a specific file on the SD card. for instance /myFile.txt will read the file /sdcard/myFile.txt. To read assets packaged with an application (also works for the Companion) start the filename with // (two slashes). If a filename does not start with a slash, it will be read from the applications private storage (for packaged apps) and from /sdcard/AppInventor/data for the Companion.")
    public void ReadFrom(String fileName) {
        readFromFile(fileName);
    }

    @SimpleFunction(description = "Deletes a file from storage. Prefix the filename with / to delete a specific file in the SD card, for instance /myFile.txt. will delete the file /sdcard/myFile.txt. If the file does not begin with a /, then the file located in the programs private storage will be deleted. Starting the file with // is an error because assets files cannot be deleted.")
    public void Delete(String fileName) {
        if (fileName.startsWith("//")) {
            this.form.dispatchErrorOccurredEvent(this, "Delete", ErrorMessages.ERROR_CANNOT_DELETE_ASSET, fileName);
            return;
        }
        try {
            new FileWriteOperation(this.form, this, "Delete", fileName, this.scope, false, true) { // from class: com.google.appinventor.components.runtime.File.8
                @Override // com.google.appinventor.components.runtime.util.FileStreamOperation, com.google.appinventor.components.runtime.util.SingleFileOperation
                public void processFile(ScopedFile scopedFile) {
                    java.io.File file = scopedFile.resolve(this.form);
                    if (file.exists() && !file.delete()) {
                        this.form.dispatchErrorOccurredEvent(File.this, "Delete", ErrorMessages.ERROR_CANNOT_DELETE_FILE, this.fileName);
                    }
                }
            }.run();
        } catch (StopBlocksExecution e) {
        }
    }

    private void write(final String filename, String method, final String text, boolean append) {
        if (filename.startsWith("//")) {
            this.form.dispatchErrorOccurredEvent(this, method, ErrorMessages.ERROR_CANNOT_WRITE_ASSET, filename);
            return;
        }
        if (filename.startsWith("/")) {
            FileUtil.checkExternalStorageWriteable();
        }
        try {
            new FileStreamWriteOperation(this.form, this, method, filename, this.scope, append, true) { // from class: com.google.appinventor.components.runtime.File.9
                @Override // com.google.appinventor.components.runtime.util.FileStreamOperation, com.google.appinventor.components.runtime.util.SingleFileOperation
                public void processFile(ScopedFile scopedFile) {
                    java.io.File file = scopedFile.resolve(this.form);
                    if (!file.exists()) {
                        boolean success = false;
                        try {
                            IOUtils.mkdirs(file);
                            success = file.createNewFile();
                        } catch (IOException e) {
                            Log.e(File.LOG_TAG, "Unable to create file " + file.getAbsolutePath());
                        }
                        if (!success) {
                            this.form.dispatchErrorOccurredEvent(File.this, this.method, ErrorMessages.ERROR_CANNOT_CREATE_FILE, file.getAbsolutePath());
                            return;
                        }
                    }
                    super.processFile(scopedFile);
                }

                @Override // com.google.appinventor.components.runtime.util.FileStreamWriteOperation
                public boolean process(OutputStreamWriter out) throws IOException {
                    out.write(text);
                    out.flush();
                    this.form.runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.File.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            File.this.AfterFileSaved(filename);
                        }
                    });
                    return true;
                }

                @Override // com.google.appinventor.components.runtime.util.FileStreamOperation
                public void onError(IOException e) {
                    String fileName;
                    super.onError(e);
                    if (getFile() == null) {
                        fileName = getScopedFile().getFileName();
                    } else {
                        fileName = getFile().getAbsolutePath();
                    }
                    this.form.dispatchErrorOccurredEvent(File.this, this.method, ErrorMessages.ERROR_CANNOT_WRITE_TO_FILE, fileName);
                }
            }.run();
        } catch (StopBlocksExecution e) {
        }
    }

    @SimpleEvent(description = "Event indicating that the contents from the file have been read.")
    public void GotText(String text) {
        EventDispatcher.dispatchEvent(this, "GotText", text);
    }

    @SimpleEvent(description = "Event indicating that the contents of the file have been written.")
    public void AfterFileSaved(String fileName) {
        EventDispatcher.dispatchEvent(this, "AfterFileSaved", fileName);
    }

    @Override // com.google.appinventor.components.runtime.FileBase
    protected void afterRead(final String result) {
        this.form.runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.File.10
            @Override // java.lang.Runnable
            public void run() {
                File.this.GotText(result);
            }
        });
    }
}
