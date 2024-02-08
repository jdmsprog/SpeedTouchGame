package com.google.appinventor.components.runtime;

import android.content.Intent;
import android.net.Uri;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.Options;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.FileAction;
import com.google.appinventor.components.common.FileType;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.util.ErrorMessages;

@DesignerComponent(androidMinSdk = 19, category = ComponentCategory.MEDIA, iconName = "images/filepicker.png", version = 1)
@SimpleObject
/* loaded from: classes.dex */
public class FilePicker extends Picker {
    private FileAction action;
    private String mimeType;
    private String selection;

    public FilePicker(ComponentContainer container) {
        super(container);
        this.action = FileAction.PickExistingFile;
        this.selection = "";
        this.mimeType = "*/*";
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "Pick Existing File", editorArgs = {"Pick Existing File", "Pick New File", "Pick Directory"}, editorType = PropertyTypeConstants.PROPERTY_TYPE_CHOICES)
    public void Action(FileAction action) {
        this.action = action;
    }

    public void Action(String action) {
        Action(FileAction.fromUnderlyingValue(action));
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public FileAction Action() {
        return this.action;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "*/*", editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING)
    public void MimeType(@Options(FileType.class) String mimeType) {
        this.mimeType = mimeType;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String MimeType() {
        return this.mimeType;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String Selection() {
        return this.selection;
    }

    @Override // com.google.appinventor.components.runtime.ActivityResultListener
    public void resultReturned(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Uri uri = data.getData();
            int takeFlags = data.getFlags() & 3;
            this.container.$form().getContentResolver().takePersistableUriPermission(uri, takeFlags);
            this.selection = uri.toString();
            AfterPicking();
            return;
        }
        this.container.$form().dispatchErrorOccurredEvent(this, "Open", ErrorMessages.ERROR_FILEPICKER_NO_URI_RETURNED, new Object[0]);
    }

    @Override // com.google.appinventor.components.runtime.Picker
    protected Intent getIntent() {
        Intent intent = new Intent(actionToIntent(this.action));
        if (this.action == FileAction.PickExistingFile) {
            intent.addCategory("android.intent.category.OPENABLE");
        }
        if (this.action == FileAction.PickDirectory) {
            return Intent.createChooser(intent, "Test");
        }
        intent.setType(this.mimeType);
        int flags = 65;
        if (this.action == FileAction.PickExistingFile) {
            flags = 65 | 2;
        }
        intent.setFlags(flags);
        return intent;
    }

    private static String actionToIntent(FileAction action) {
        switch (action) {
            case PickExistingFile:
                return "android.intent.action.OPEN_DOCUMENT";
            case PickDirectory:
                return "android.intent.action.OPEN_DOCUMENT_TREE";
            case PickNewFile:
                return "android.intent.action.CREATE_DOCUMENT";
            default:
                throw new IllegalArgumentException("Unknown file action: " + action);
        }
    }
}
