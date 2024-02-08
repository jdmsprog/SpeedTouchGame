package com.google.appinventor.common.version;

/* loaded from: classes.dex */
public final class GitBuildId {
    public static final String ACRA_URI = "${acra.uri}";
    public static final String ANT_BUILD_DATE = "November 27 2023";
    public static final String GIT_BUILD_FINGERPRINT = "be67c3f9d2ffbd057d8c2df089ec390621b26481";
    public static final String GIT_BUILD_VERSION = "nb195a";

    private GitBuildId() {
    }

    public static String getVersion() {
        if (GIT_BUILD_VERSION != "" && !GIT_BUILD_VERSION.contains(" ")) {
            return GIT_BUILD_VERSION;
        }
        return "none";
    }

    public static String getFingerprint() {
        return GIT_BUILD_FINGERPRINT;
    }

    public static String getDate() {
        return ANT_BUILD_DATE;
    }

    public static String getAcraUri() {
        return ACRA_URI.equals(ACRA_URI) ? "" : ACRA_URI.trim();
    }
}
