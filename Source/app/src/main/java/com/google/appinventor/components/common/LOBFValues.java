package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum LOBFValues implements OptionList<String> {
    CorrCoef("correlation coefficient"),
    Slope("slope"),
    Yintercept("Yintercept"),
    Predictions("predictions"),
    AllValues("all values");
    
    private static final Map<String, LOBFValues> lookup = new HashMap();
    private final String lobfValues;

    static {
        LOBFValues[] values;
        for (LOBFValues value : values()) {
            lookup.put(value.toUnderlyingValue(), value);
        }
    }

    LOBFValues(String lobfV) {
        this.lobfValues = lobfV;
    }

    @Override // com.google.appinventor.components.common.OptionList
    public String toUnderlyingValue() {
        return this.lobfValues;
    }

    public static LOBFValues fromUnderlyingValue(String value) {
        return lookup.get(value);
    }
}
