package com.google.appinventor.components.runtime;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.google.appinventor.components.runtime.ChartView;
import com.google.appinventor.components.runtime.DataModel;
import com.google.appinventor.components.runtime.util.YailList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ChartDataModel<E extends Entry, T extends IDataSet<E>, D extends ChartData<T>, C extends com.github.mikephil.charting.charts.Chart<D>, V extends ChartView<E, T, D, C, V>> extends DataModel<E> {
    protected D data;
    protected T dataset;
    protected V view;

    @Override // com.google.appinventor.components.runtime.DataModel
    protected abstract int getTupleSize();

    /* JADX INFO: Access modifiers changed from: protected */
    public ChartDataModel(D data, V view) {
        this.data = data;
        this.view = view;
        this.entries = new ArrayList();
    }

    public T getDataset() {
        return this.dataset;
    }

    public D getData() {
        return this.data;
    }

    public void setColor(int argb) {
        if (this.dataset instanceof DataSet) {
            this.dataset.setColor(argb);
        }
    }

    public void setColors(List<Integer> colors) {
        if (this.dataset instanceof DataSet) {
            this.dataset.setColors(colors);
        }
    }

    public void setLabel(String text) {
        getDataset().setLabel(text);
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public void setElements(String elements) {
        int tupleSize = getTupleSize();
        String[] entries = elements.split(",");
        for (int i = tupleSize - 1; i < entries.length; i += tupleSize) {
            List<String> tupleEntries = new ArrayList<>();
            for (int j = tupleSize - 1; j >= 0; j--) {
                int index = i - j;
                tupleEntries.add(entries[index]);
            }
            addEntryFromTuple(YailList.makeList((List) tupleEntries));
        }
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public void removeEntryFromTuple(YailList tuple) {
        Entry entry = getEntryFromTuple(tuple);
        if (entry != null) {
            int index = findEntryIndex(entry);
            removeEntry(index);
        }
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public void removeEntry(int index) {
        if (index >= 0) {
            this.entries.remove(index);
        }
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public boolean doesEntryExist(YailList tuple) {
        Entry entry = getEntryFromTuple(tuple);
        int index = findEntryIndex(entry);
        return index >= 0;
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public YailList findEntriesByCriterion(String value, DataModel.EntryCriterion criterion) {
        List<YailList> entries = new ArrayList<>();
        for (E entry : this.entries) {
            if (isEntryCriterionSatisfied(entry, criterion, value)) {
                entries.add(getTupleFromEntry(entry));
            }
        }
        return YailList.makeList((List) entries);
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public YailList getEntriesAsTuples() {
        return findEntriesByCriterion(Component.TYPEFACE_DEFAULT, DataModel.EntryCriterion.All);
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    protected boolean isEntryCriterionSatisfied(Entry entry, DataModel.EntryCriterion criterion, String value) {
        switch (criterion) {
            case All:
                return true;
            case XValue:
                if (entry instanceof PieEntry) {
                    PieEntry pieEntry = (PieEntry) entry;
                    boolean criterionSatisfied = pieEntry.getLabel().equals(value);
                    return criterionSatisfied;
                }
                try {
                    float xValue = Float.parseFloat(value);
                    float compareValue = entry.getX();
                    if (entry instanceof BarEntry) {
                        compareValue = (float) Math.floor(compareValue);
                    }
                    return compareValue == xValue;
                } catch (NumberFormatException e) {
                    return false;
                }
            case YValue:
                try {
                    float yValue = Float.parseFloat(value);
                    return entry.getY() == yValue;
                } catch (NumberFormatException e2) {
                    return false;
                }
            default:
                throw new IllegalArgumentException("Unknown criterion: " + criterion);
        }
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public int findEntryIndex(Entry entry) {
        for (int i = 0; i < this.entries.size(); i++) {
            Entry currentEntry = (Entry) this.entries.get(i);
            if (areEntriesEqual(currentEntry, entry)) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public void clearEntries() {
        this.entries.clear();
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public void addTimeEntry(YailList tuple) {
        if (this.entries.size() >= this.maximumTimeEntries) {
            this.entries.remove(0);
        }
        addEntryFromTuple(tuple);
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public void setMaximumTimeEntries(int entries) {
        this.maximumTimeEntries = entries;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.appinventor.components.runtime.DataModel
    public void setDefaultStylingProperties() {
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    protected String getDefaultValue(int index) {
        return index + "";
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    protected boolean areEntriesEqual(Entry e1, Entry e2) {
        return e1.equalTo(e2);
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public List<E> getEntries() {
        return Collections.unmodifiableList(this.entries);
    }
}
