package com.google.appinventor.components.runtime;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.EntryXComparator;
import com.google.appinventor.components.common.LineType;
import com.google.appinventor.components.runtime.LineChartViewBase;
import com.google.appinventor.components.runtime.util.YailList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class LineChartBaseDataModel<V extends LineChartViewBase<V>> extends PointChartDataModel<Entry, ILineDataSet, LineData, LineChart, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    public LineChartBaseDataModel(LineData data, V view) {
        super(data, view);
        this.dataset = new LineDataSet(new ArrayList(), "");
        this.data.addDataSet(this.dataset);
        setDefaultStylingProperties();
    }

    @Override // com.google.appinventor.components.runtime.DataModel
    public void addEntryFromTuple(YailList tuple) {
        Entry entry = getEntryFromTuple(tuple);
        if (entry != null) {
            int index = Collections.binarySearch(this.entries, entry, new EntryXComparator());
            if (index < 0) {
                index = (-index) - 1;
            } else {
                int entryCount = this.entries.size();
                while (index < entryCount && ((Entry) this.entries.get(index)).getX() == entry.getX()) {
                    index++;
                }
            }
            this.entries.add(index, entry);
            List<Integer> defaultColors = this.dataset.getCircleColors();
            defaultColors.add(index, Integer.valueOf(this.dataset.getColor()));
            this.dataset.setCircleColors(defaultColors);
        }
    }

    @Override // com.google.appinventor.components.runtime.ChartDataModel
    public void setColor(int argb) {
        super.setColor(argb);
        if (this.dataset instanceof LineDataSet) {
            this.dataset.setCircleColor(argb);
        }
    }

    @Override // com.google.appinventor.components.runtime.ChartDataModel
    public void setColors(List<Integer> colors) {
        super.setColors(colors);
        if (this.dataset instanceof LineDataSet) {
            this.dataset.setCircleColors(colors);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.appinventor.components.runtime.ChartDataModel, com.google.appinventor.components.runtime.DataModel
    public void setDefaultStylingProperties() {
        if (this.dataset instanceof LineDataSet) {
            this.dataset.setDrawCircleHole(false);
        }
    }

    public void setLineType(LineType type) {
        if (this.dataset instanceof LineDataSet) {
            switch (type) {
                case Linear:
                    this.dataset.setMode(LineDataSet.Mode.LINEAR);
                    return;
                case Curved:
                    this.dataset.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                    return;
                case Stepped:
                    this.dataset.setMode(LineDataSet.Mode.STEPPED);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown line type: " + type);
            }
        }
    }
}
