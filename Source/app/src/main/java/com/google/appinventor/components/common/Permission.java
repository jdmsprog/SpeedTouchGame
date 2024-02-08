package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum Permission implements OptionList<String> {
    CoarseLocation("ACCESS_COARSE_LOCATION"),
    FineLocation("ACCESS_FINE_LOCATION"),
    MockLocation("ACCESS_MOCK_LOCATION"),
    LocationExtraCommands("ACCESS_LOCATION_EXTRA_COMMANDS"),
    ReadExternalStorage("READ_EXTERNAL_STORAGE"),
    WriteExternalStorage("WRITE_EXTERNAL_STORAGE"),
    Camera("CAMERA"),
    Audio("RECORD_AUDIO"),
    Vibrate("VIBRATE"),
    Internet("INTERNET"),
    NearFieldCommunication("NFC"),
    Bluetooth("BLUETOOTH"),
    BluetoothAdmin("BLUETOOTH_ADMIN"),
    WifiState("ACCESS_WIFI_STATE"),
    NetworkState("ACCESS_NETWORK_STATE"),
    AccountManager("ACCOUNT_MANAGER"),
    ManageAccounts("MANAGE_ACCOUNTS"),
    GetAccounts("GET_ACCOUNTS"),
    ReadContacts("READ_CONTACTS"),
    UseCredentials("USE_CREDENTIALS"),
    BluetoothAdvertise("BLUETOOTH_ADVERTISE"),
    BluetoothConnect("BLUETOOTH_CONNECT"),
    BluetoothScan("BLUETOOTH_SCAN"),
    ReadMediaImages("READ_MEDIA_IMAGES"),
    ReadMediaVideo("READ_MEDIA_VIDEO"),
    ReadMediaAudio("READ_MEDIA_AUDIO");
    
    private static final Map<String, Permission> lookup = new HashMap();
    private final String value;

    static {
        Permission[] values;
        for (Permission perm : values()) {
            lookup.put(perm.toUnderlyingValue(), perm);
        }
    }

    Permission(String perm) {
        this.value = perm;
    }

    @Override // com.google.appinventor.components.common.OptionList
    public String toUnderlyingValue() {
        return this.value;
    }

    public static Permission fromUnderlyingValue(String perm) {
        return lookup.get(perm);
    }
}
