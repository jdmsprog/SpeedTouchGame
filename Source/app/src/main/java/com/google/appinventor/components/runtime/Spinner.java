package com.google.appinventor.components.runtime;

import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.util.ElementsUtil;
import com.google.appinventor.components.runtime.util.HoneycombUtil;
import com.google.appinventor.components.runtime.util.YailList;

@DesignerComponent(category = ComponentCategory.USERINTERFACE, description = "<p>A spinner component that displays a pop-up with a list of elements. These elements can be set in the Designer or Blocks Editor by setting the<code>ElementsFromString</code> property to a string-separated concatenation (for example, <em>choice 1, choice 2, choice 3</em>) or by setting the <code>Elements</code> property to a List in the Blocks editor. Spinners are created with the first item already selected. So selecting  it does not generate an After Picking event. Consequently it's useful to make the  first Spinner item be a non-choice like \"Select from below...\". </p>", iconName = "images/spinner.png", nonVisible = false, version = 1)
@SimpleObject
/* loaded from: classes.dex */
public final class Spinner extends AndroidViewComponent implements AdapterView.OnItemSelectedListener {
    private ArrayAdapter<String> adapter;
    private YailList items;
    private int oldAdapterCount;
    private int oldSelectionIndex;
    private final android.widget.Spinner view;

    public Spinner(ComponentContainer container) {
        super(container);
        this.items = new YailList();
        if (Build.VERSION.SDK_INT < 11) {
            this.view = new android.widget.Spinner(container.$context());
        } else {
            this.view = HoneycombUtil.makeSpinner(container.$context());
        }
        this.adapter = new ArrayAdapter<>(container.$context(), 17367048);
        this.adapter.setDropDownViewResource(17367058);
        this.view.setAdapter((SpinnerAdapter) this.adapter);
        this.view.setOnItemSelectedListener(this);
        container.$add(this);
        Prompt("");
        this.oldSelectionIndex = SelectionIndex();
    }

    @Override // com.google.appinventor.components.runtime.AndroidViewComponent
    public View getView() {
        return this.view;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the current selected item in the spinner ")
    public String Selection() {
        return SelectionIndex() == 0 ? "" : (String) this.view.getItemAtPosition(SelectionIndex() - 1);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Set the selected item in the spinner")
    @DesignerProperty(defaultValue = "", editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING)
    public void Selection(String value) {
        SelectionIndex(ElementsUtil.setSelectedIndexFromValue(value, this.items));
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The index of the currently selected item, starting at 1. If no item is selected, the value will be 0.")
    public int SelectionIndex() {
        return ElementsUtil.selectionIndex(this.view.getSelectedItemPosition() + 1, this.items);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Set the spinner selection to the element at the given index.If an attempt is made to set this to a number less than 1 or greater than the number of items in the Spinner, SelectionIndex will be set to 0, and Selection will be set to empty.")
    public void SelectionIndex(int index) {
        this.oldSelectionIndex = SelectionIndex();
        this.view.setSelection(ElementsUtil.selectionIndex(index, this.items) - 1);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "returns a list of text elements to be picked from.")
    public YailList Elements() {
        return this.items;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Adds the passed text element to the Spinner list")
    public void Elements(YailList itemList) {
        if (itemList.size() == 0) {
            SelectionIndex(0);
        } else if (itemList.size() < this.items.size() && SelectionIndex() == this.items.size()) {
            SelectionIndex(itemList.size());
        }
        this.items = ElementsUtil.elements(itemList, "Spinner");
        setAdapterData(itemList.toStringArray());
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Sets the Spinner list to the elements passed in the comma-separated string")
    @DesignerProperty(defaultValue = "", editorType = PropertyTypeConstants.PROPERTY_TYPE_TEXTAREA)
    public void ElementsFromString(String itemstring) {
        Elements(ElementsUtil.elementsFromString(itemstring));
    }

    private void setAdapterData(String[] theItems) {
        this.oldAdapterCount = this.adapter.getCount();
        this.adapter.clear();
        for (String str : theItems) {
            this.adapter.add(str);
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Text with the current title for the Spinner window")
    public String Prompt() {
        return this.view.getPrompt().toString();
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Sets the Spinner window prompt to the given title")
    @DesignerProperty(defaultValue = "", editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING)
    public void Prompt(String str) {
        this.view.setPrompt(str);
    }

    @SimpleFunction(description = "Displays the dropdown list for selection, same action as when the user clicks on the spinner.")
    public void DisplayDropdown() {
        this.view.performClick();
    }

    @SimpleEvent(description = "Event called after the user selects an item from the dropdown list.")
    public void AfterSelecting(String selection) {
        EventDispatcher.dispatchEvent(this, "AfterSelecting", selection);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if ((this.oldAdapterCount == 0 && this.adapter.getCount() > 0 && this.oldSelectionIndex == 0) || (this.oldAdapterCount > this.adapter.getCount() && this.oldSelectionIndex > this.adapter.getCount())) {
            SelectionIndex(position + 1);
            this.oldAdapterCount = this.adapter.getCount();
            return;
        }
        SelectionIndex(position + 1);
        AfterSelecting(Selection());
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
        this.view.setSelection(0);
    }
}
