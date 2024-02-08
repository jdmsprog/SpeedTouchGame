package com.google.appinventor.components.runtime;

import android.util.Log;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.YailList;
import gnu.lists.LList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

@DesignerComponent(category = ComponentCategory.CHARTS, description = "A component that holds (x, y)-coordinate based data", iconName = "images/web.png", version = 1)
@SimpleObject
/* loaded from: classes.dex */
public final class ChartData2D extends ChartDataBase {
    public ChartData2D(Chart chartContainer) {
        super(chartContainer);
    }

    @SimpleFunction
    public void AddEntry(final String x, final String y) {
        this.threadRunner.execute(new Runnable() { // from class: com.google.appinventor.components.runtime.ChartData2D.1
            @Override // java.lang.Runnable
            public void run() {
                YailList pair = YailList.makeList(Arrays.asList(x, y));
                ((ChartDataModel) ChartData2D.this.dataModel).addEntryFromTuple(pair);
                ChartData2D.this.onDataChange();
            }
        });
    }

    @SimpleFunction
    public void RemoveEntry(final String x, final String y) {
        this.threadRunner.execute(new Runnable() { // from class: com.google.appinventor.components.runtime.ChartData2D.2
            @Override // java.lang.Runnable
            public void run() {
                YailList pair = YailList.makeList(Arrays.asList(x, y));
                float xValue = Float.parseFloat(x);
                float yValue = Float.parseFloat(y);
                Entry currEntry = new Entry(xValue, yValue);
                int index = ((ChartDataModel) ChartData2D.this.dataModel).findEntryIndex(currEntry);
                ((ChartDataModel) ChartData2D.this.dataModel).removeEntryFromTuple(pair);
                ChartData2D.this.resetHighlightAtIndex(index);
                ChartData2D.this.onDataChange();
            }
        });
    }

    @SimpleFunction(description = "Checks whether an (x, y) entry exists in the Coordinate Data.Returns true if the Entry exists, and false otherwise.")
    public boolean DoesEntryExist(final String x, final String y) {
        try {
            return ((Boolean) this.threadRunner.submit(new Callable<Boolean>() { // from class: com.google.appinventor.components.runtime.ChartData2D.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() {
                    YailList pair = YailList.makeList(Arrays.asList(x, y));
                    return Boolean.valueOf(((ChartDataModel) ChartData2D.this.dataModel).doesEntryExist(pair));
                }
            }).get()).booleanValue();
        } catch (InterruptedException e) {
            Log.e(getClass().getName(), e.getMessage());
            return false;
        } catch (ExecutionException e2) {
            Log.e(getClass().getName(), e2.getMessage());
            return false;
        }
    }

    @SimpleFunction(description = "Draws the corresponding line of best fit on the graph")
    public void DrawLineOfBestFit(YailList xList, YailList yList) {
        List<?> predictions = (List) Regression.computeLineOfBestFit(xList, yList).get("predictions");
        List<List<?>> predictionPairs = new ArrayList<>();
        List<?> xValues = (List) xList.getCdr();
        for (int i = 0; i < xValues.size(); i++) {
            predictionPairs.add(Arrays.asList(xValues.get(i), predictions.get(i)));
        }
        YailList predictionPairsList = YailList.makeList((List) predictionPairs);
        ((ChartDataModel) this.dataModel).importFromList(predictionPairsList);
        if (((ChartDataModel) this.dataModel).getDataset() instanceof LineDataSet) {
            ((ChartDataModel) this.dataModel).getDataset().setDrawCircles(false);
            ((ChartDataModel) this.dataModel).getDataset().setDrawValues(false);
        }
        onDataChange();
    }

    @SimpleFunction(description = "Highlights data points of choice on the Chart in the color of choice. This block expects a list of data points, each data point is an index, value pair")
    public void HighlightDataPoints(YailList dataPoints, int color) {
        List<?> dataPointsList = (LList) dataPoints.getCdr();
        if (!dataPoints.isEmpty()) {
            List<?> entries = ((ChartDataModel) this.dataModel).getEntries();
            int[] highlights = new int[entries.size()];
            Arrays.fill(highlights, ((ChartDataModel) this.dataModel).getDataset().getColor());
            for (Object dataPoint : dataPointsList) {
                if (dataPoint instanceof YailList) {
                    int dataPointIndex = (int) AnomalyDetection.getAnomalyIndex((YailList) dataPoint);
                    highlights[dataPointIndex - 1] = color;
                }
            }
            ((ChartDataModel) this.dataModel).getDataset().setCircleColors(highlights);
            onDataChange();
            return;
        }
        throw new IllegalStateException("Anomalies list is Empty. Nothing to highlight!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetHighlightAtIndex(int index) {
        List<Integer> defaultColors = ((ChartDataModel) this.dataModel).getDataset().getCircleColors();
        defaultColors.remove(index);
    }
}
