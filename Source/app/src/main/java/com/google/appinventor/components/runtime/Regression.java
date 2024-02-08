package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.Options;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.LOBFValues;
import com.google.appinventor.components.runtime.util.YailDictionary;
import com.google.appinventor.components.runtime.util.YailList;
import gnu.lists.LList;
import java.util.ArrayList;
import java.util.List;
import kawa.lang.SyntaxForms;

@DesignerComponent(category = ComponentCategory.DATASCIENCE, description = "A component that contains regression models", iconName = "images/regression.png", nonVisible = SyntaxForms.DEBUGGING, version = 2)
@SimpleObject
/* loaded from: classes.dex */
public final class Regression extends DataCollection<ComponentContainer, DataModel<?>> {
    public Regression(ComponentContainer container) {
        super(container);
    }

    public static YailDictionary computeLineOfBestFit(YailList xEntries, YailList yEntries) {
        LList xValues = (LList) xEntries.getCdr();
        List<Double> x = castToDouble(xValues);
        LList yValues = (LList) yEntries.getCdr();
        List<Double> y = castToDouble(yValues);
        if (xValues.size() != yValues.size()) {
            throw new IllegalStateException("Must have equal X and Y data points");
        }
        if (xValues.isEmpty() || xValues.isEmpty()) {
            throw new IllegalStateException("List must have at least one element");
        }
        int n = xValues.size();
        double sumx = 0.0d;
        double sumy = 0.0d;
        double sumXY = 0.0d;
        double squareSumX = 0.0d;
        double squareSumY = 0.0d;
        for (int i = 0; i < n; i++) {
            sumx += x.get(i).doubleValue();
            sumXY += y.get(i).doubleValue() * x.get(i).doubleValue();
            sumy += y.get(i).doubleValue();
            squareSumX += x.get(i).doubleValue() * x.get(i).doubleValue();
            squareSumY += y.get(i).doubleValue() * y.get(i).doubleValue();
        }
        double xmean = sumx / n;
        double ymean = sumy / n;
        double xxmean = 0.0d;
        double xymean = 0.0d;
        List<Double> predictions = new ArrayList<>();
        for (int i2 = 0; i2 < n; i2++) {
            xxmean += (x.get(i2).doubleValue() - xmean) * (x.get(i2).doubleValue() - xmean);
            xymean += (y.get(i2).doubleValue() - ymean) * (x.get(i2).doubleValue() - xmean);
        }
        double slope = xymean / xxmean;
        double intercept = ymean - (slope * xmean);
        for (int i3 = 0; i3 < n; i3++) {
            double prediction = (x.get(i3).doubleValue() * slope) + intercept;
            predictions.add(Double.valueOf(prediction));
        }
        double corr = ((n * sumXY) - (sumx * sumy)) / Math.sqrt(((n * squareSumX) - (sumx * sumx)) * ((n * squareSumY) - (sumy * sumy)));
        YailDictionary resultDic = new YailDictionary();
        resultDic.put("slope", Double.valueOf(slope));
        resultDic.put("Yintercept", Double.valueOf(intercept));
        resultDic.put("correlation coefficient", Double.valueOf(corr));
        resultDic.put("predictions", predictions);
        return resultDic;
    }

    @SimpleFunction(description = "Returns one of the Line of Best Fit values. A value could be\"slope\", \"Yintercept\", \"correlation coefficient\"or \"predictions\". The block returns the complete dictionary with all values if no specific value string is provided")
    public Object CalculateLineOfBestFitValue(YailList xList, YailList yList, @Options(LOBFValues.class) String value) {
        YailDictionary result = computeLineOfBestFit(xList, yList);
        if (result.containsKey(value)) {
            return result.get(value);
        }
        return result;
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void ElementsFromPairs(String elements) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void SpreadsheetUseHeaders(boolean useHeaders) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void DataFileXColumn(String column) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void WebXColumn(String column) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void SpreadsheetXColumn(String column) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void DataFileYColumn(String column) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void WebYColumn(String column) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void SpreadsheetYColumn(String column) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void DataSourceKey(String key) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public <K, V> void Source(DataSource<K, V> dataSource) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void ImportFromList(YailList list) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void Clear() {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public <K, V> void ChangeDataSource(DataSource<K, V> source, String keyValue) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void RemoveDataSource() {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public YailList GetEntriesWithXValue(String x) {
        return YailList.makeEmptyList();
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public YailList GetEntriesWithYValue(String y) {
        return YailList.makeEmptyList();
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public YailList GetAllEntries() {
        return YailList.makeEmptyList();
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void ImportFromTinyDB(TinyDB tinyDB, String tag) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void ImportFromCloudDB(CloudDB cloudDB, String tag) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void ImportFromDataFile(DataFile dataFile, String xValueColumn, String yValueColumn) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void ImportFromSpreadsheet(Spreadsheet spreadsheet, String xColumn, String yColumn, boolean useHeaders) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void ImportFromWeb(Web web, String xValueColumn, String yValueColumn) {
    }

    @Override // com.google.appinventor.components.runtime.DataCollection
    public void onDataChange() {
    }
}
