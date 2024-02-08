package com.google.appinventor.components.runtime;

import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.SUtil;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import kawa.lang.SyntaxForms;

@UsesPermissions({"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.BLUETOOTH_ADVERTISE"})
@DesignerComponent(category = ComponentCategory.CONNECTIVITY, description = "Bluetooth server component", iconName = "images/bluetooth.png", nonVisible = SyntaxForms.DEBUGGING, version = 5)
@SimpleObject
/* loaded from: classes.dex */
public final class BluetoothServer extends BluetoothConnectionBase {
    private static final String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB";
    private final Handler androidUIHandler;
    private final AtomicReference<BluetoothServerSocket> arBluetoothServerSocket;

    public BluetoothServer(ComponentContainer container) {
        super(container, "BluetoothServer");
        this.androidUIHandler = new Handler(Looper.getMainLooper());
        this.arBluetoothServerSocket = new AtomicReference<>();
    }

    @SimpleFunction(description = "Accept an incoming connection with the Serial Port Profile (SPP).")
    public void AcceptConnection(String serviceName) {
        accept("AcceptConnection", serviceName, SPP_UUID);
    }

    @SimpleFunction(description = "Accept an incoming connection with a specific UUID.")
    public void AcceptConnectionWithUUID(String serviceName, String uuid) {
        accept("AcceptConnectionWithUUID", serviceName, uuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void accept(final String functionName, final String name, final String uuidString) {
        BluetoothServerSocket socket;
        if (!SUtil.requestPermissionsForAdvertising(this.form, this, functionName, new PermissionResultHandler() { // from class: com.google.appinventor.components.runtime.BluetoothServer.1
            @Override // com.google.appinventor.components.runtime.PermissionResultHandler
            public void HandlePermissionResponse(String permission, boolean granted) {
                BluetoothServer.this.accept(functionName, name, uuidString);
            }
        })) {
            if (this.adapter == null) {
                this.form.dispatchErrorOccurredEvent(this, functionName, ErrorMessages.ERROR_BLUETOOTH_NOT_AVAILABLE, new Object[0]);
            } else if (!this.adapter.isEnabled()) {
                this.form.dispatchErrorOccurredEvent(this, functionName, ErrorMessages.ERROR_BLUETOOTH_NOT_ENABLED, new Object[0]);
            } else {
                try {
                    UUID uuid = UUID.fromString(uuidString);
                    try {
                        if (!this.secure && Build.VERSION.SDK_INT >= 10) {
                            socket = this.adapter.listenUsingInsecureRfcommWithServiceRecord(name, uuid);
                        } else {
                            socket = this.adapter.listenUsingRfcommWithServiceRecord(name, uuid);
                        }
                        this.arBluetoothServerSocket.set(socket);
                        AsynchUtil.runAsynchronously(new Runnable() { // from class: com.google.appinventor.components.runtime.BluetoothServer.2
                            @Override // java.lang.Runnable
                            public void run() {
                                BluetoothSocket acceptedSocket = null;
                                BluetoothServerSocket serverSocket = (BluetoothServerSocket) BluetoothServer.this.arBluetoothServerSocket.get();
                                if (serverSocket != null) {
                                    try {
                                        acceptedSocket = serverSocket.accept();
                                    } catch (IOException e) {
                                        BluetoothServer.this.androidUIHandler.post(new Runnable() { // from class: com.google.appinventor.components.runtime.BluetoothServer.2.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                BluetoothServer.this.form.dispatchErrorOccurredEvent(BluetoothServer.this, functionName, ErrorMessages.ERROR_BLUETOOTH_UNABLE_TO_ACCEPT, new Object[0]);
                                            }
                                        });
                                        return;
                                    } finally {
                                        BluetoothServer.this.StopAccepting();
                                    }
                                }
                                if (acceptedSocket != null) {
                                    final BluetoothSocket bluetoothSocket = acceptedSocket;
                                    BluetoothServer.this.androidUIHandler.post(new Runnable() { // from class: com.google.appinventor.components.runtime.BluetoothServer.2.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                BluetoothServer.this.setConnection(bluetoothSocket);
                                                BluetoothServer.this.ConnectionAccepted();
                                            } catch (IOException e2) {
                                                BluetoothServer.this.Disconnect();
                                                BluetoothServer.this.form.dispatchErrorOccurredEvent(BluetoothServer.this, functionName, ErrorMessages.ERROR_BLUETOOTH_UNABLE_TO_ACCEPT, new Object[0]);
                                            }
                                        }
                                    });
                                }
                            }
                        });
                    } catch (IOException e) {
                        this.form.dispatchErrorOccurredEvent(this, functionName, ErrorMessages.ERROR_BLUETOOTH_UNABLE_TO_LISTEN, new Object[0]);
                    }
                } catch (IllegalArgumentException e2) {
                    this.form.dispatchErrorOccurredEvent(this, functionName, ErrorMessages.ERROR_BLUETOOTH_INVALID_UUID, uuidString);
                }
            }
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public final boolean IsAccepting() {
        return this.arBluetoothServerSocket.get() != null;
    }

    @SimpleFunction(description = "Stop accepting an incoming connection.")
    public void StopAccepting() {
        BluetoothServerSocket serverSocket = this.arBluetoothServerSocket.getAndSet(null);
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                Log.w(this.logTag, "Error while closing bluetooth server socket: " + e.getMessage());
            }
        }
    }

    @SimpleEvent(description = "Indicates that a bluetooth connection has been accepted.")
    public void ConnectionAccepted() {
        Log.i(this.logTag, "Successfullly accepted bluetooth connection.");
        EventDispatcher.dispatchEvent(this, "ConnectionAccepted", new Object[0]);
    }
}
