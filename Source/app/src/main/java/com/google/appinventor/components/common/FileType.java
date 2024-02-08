package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum FileType implements OptionList<String> {
    Any("*/*"),
    Audio("audio/*"),
    Image("image/*"),
    Video("video/*");
    
    private static final Map<String, FileType> LOOKUP = new HashMap();
    private final String mimeType;

    static {
        FileType[] values;
        for (FileType type : values()) {
            LOOKUP.put(type.toUnderlyingValue(), type);
        }
    }

    FileType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override // com.google.appinventor.components.common.OptionList
    public String toUnderlyingValue() {
        return this.mimeType;
    }

    public static FileType fromUnderlyingValue(String value) {
        return LOOKUP.get(value);
    }
}
