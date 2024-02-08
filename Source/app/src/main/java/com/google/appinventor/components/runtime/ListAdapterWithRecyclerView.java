package com.google.appinventor.components.runtime;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.TextViewUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;
import com.google.appinventor.components.runtime.util.YailDictionary;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ListAdapterWithRecyclerView extends RecyclerView.Adapter<RvViewHolder> implements Filterable {
    private static final String LOG_TAG = "ListAdapterRecyclerView";
    private int backgroundColor;
    private ClickListener clickListener;
    protected final ComponentContainer container;
    protected final Filter filter;
    private List<YailDictionary> filterItems;
    private int idCard;
    private int idFirst;
    private int idImages;
    private int idSecond;
    private int imageHeight;
    private int imageWidth;
    public boolean isSelected;
    public Boolean[] isVisible;
    private CardView[] itemViews;
    private List<YailDictionary> items;
    private int layoutType;
    private boolean multiSelect;
    public Boolean[] selection;
    private int selectionColor;
    private int textDetailColor;
    private String textDetailFont;
    private float textDetailSize;
    private int textMainColor;
    private String textMainFont;
    private float textMainSize;

    /* loaded from: classes.dex */
    public interface ClickListener {
        void onItemClick(int i, View view);
    }

    public ListAdapterWithRecyclerView(ComponentContainer container, List<YailDictionary> items, int textMainColor, int textDetailColor, float textMainSize, float textDetailSize, String textMainFont, String textDetailFont, int layoutType, int backgroundColor, int selectionColor, int imageWidth, int imageHeight, boolean multiSelect) {
        this.filter = new Filter() { // from class: com.google.appinventor.components.runtime.ListAdapterWithRecyclerView.1
            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                String filterQuery = charSequence.toString().toLowerCase();
                Filter.FilterResults results = new Filter.FilterResults();
                List<YailDictionary> filteredList = new ArrayList<>();
                if (filterQuery != null && filterQuery.length() != 0) {
                    for (YailDictionary itemDict : ListAdapterWithRecyclerView.this.items) {
                        Object o = itemDict.get(Component.LISTVIEW_KEY_DESCRIPTION);
                        String filterString = itemDict.get(Component.LISTVIEW_KEY_MAIN_TEXT).toString();
                        if (o != null) {
                            filterString = filterString + " " + o.toString().toLowerCase();
                        }
                        if (filterString.toLowerCase().contains(filterQuery)) {
                            filteredList.add(itemDict);
                        }
                    }
                } else {
                    filteredList = new ArrayList<>(ListAdapterWithRecyclerView.this.items);
                }
                results.count = filteredList.size();
                results.values = filteredList;
                return results;
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                ListAdapterWithRecyclerView.this.filterItems = (List) filterResults.values;
                for (int i = 0; i < ListAdapterWithRecyclerView.this.items.size(); i++) {
                    if (ListAdapterWithRecyclerView.this.filterItems.size() > 0 && ListAdapterWithRecyclerView.this.filterItems.contains(ListAdapterWithRecyclerView.this.items.get(i))) {
                        ListAdapterWithRecyclerView.this.isVisible[i] = true;
                        if (ListAdapterWithRecyclerView.this.itemViews[i] != null) {
                            ListAdapterWithRecyclerView.this.itemViews[i].setVisibility(0);
                            ListAdapterWithRecyclerView.this.itemViews[i].getLayoutParams().height = -2;
                        }
                    } else {
                        ListAdapterWithRecyclerView.this.isVisible[i] = false;
                        if (ListAdapterWithRecyclerView.this.itemViews[i] != null) {
                            ListAdapterWithRecyclerView.this.itemViews[i].setVisibility(8);
                            ListAdapterWithRecyclerView.this.itemViews[i].getLayoutParams().height = 0;
                        }
                    }
                }
            }
        };
        this.isSelected = false;
        this.idFirst = -1;
        this.idSecond = -1;
        this.idImages = -1;
        this.idCard = 1;
        this.items = items;
        this.container = container;
        this.textMainSize = textMainSize;
        this.textMainColor = textMainColor;
        this.textDetailColor = textDetailColor;
        this.textDetailSize = textDetailSize;
        this.textMainFont = textMainFont;
        this.textDetailFont = textDetailFont;
        this.layoutType = layoutType;
        this.backgroundColor = backgroundColor;
        this.selectionColor = selectionColor;
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
        this.itemViews = new CardView[items.size()];
        this.multiSelect = multiSelect;
        this.selection = new Boolean[items.size()];
        Arrays.fill(this.selection, Boolean.FALSE);
        this.isVisible = new Boolean[items.size()];
        Arrays.fill(this.isVisible, Boolean.TRUE);
    }

    public ListAdapterWithRecyclerView(ComponentContainer container, List<String> stringItems, int textMainColor, float textMainSize, String textMainFont, int backgroundColor, int selectionColor) {
        this.filter = new Filter() { // from class: com.google.appinventor.components.runtime.ListAdapterWithRecyclerView.1
            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                String filterQuery = charSequence.toString().toLowerCase();
                Filter.FilterResults results = new Filter.FilterResults();
                List<YailDictionary> filteredList = new ArrayList<>();
                if (filterQuery != null && filterQuery.length() != 0) {
                    for (YailDictionary itemDict : ListAdapterWithRecyclerView.this.items) {
                        Object o = itemDict.get(Component.LISTVIEW_KEY_DESCRIPTION);
                        String filterString = itemDict.get(Component.LISTVIEW_KEY_MAIN_TEXT).toString();
                        if (o != null) {
                            filterString = filterString + " " + o.toString().toLowerCase();
                        }
                        if (filterString.toLowerCase().contains(filterQuery)) {
                            filteredList.add(itemDict);
                        }
                    }
                } else {
                    filteredList = new ArrayList<>(ListAdapterWithRecyclerView.this.items);
                }
                results.count = filteredList.size();
                results.values = filteredList;
                return results;
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                ListAdapterWithRecyclerView.this.filterItems = (List) filterResults.values;
                for (int i = 0; i < ListAdapterWithRecyclerView.this.items.size(); i++) {
                    if (ListAdapterWithRecyclerView.this.filterItems.size() > 0 && ListAdapterWithRecyclerView.this.filterItems.contains(ListAdapterWithRecyclerView.this.items.get(i))) {
                        ListAdapterWithRecyclerView.this.isVisible[i] = true;
                        if (ListAdapterWithRecyclerView.this.itemViews[i] != null) {
                            ListAdapterWithRecyclerView.this.itemViews[i].setVisibility(0);
                            ListAdapterWithRecyclerView.this.itemViews[i].getLayoutParams().height = -2;
                        }
                    } else {
                        ListAdapterWithRecyclerView.this.isVisible[i] = false;
                        if (ListAdapterWithRecyclerView.this.itemViews[i] != null) {
                            ListAdapterWithRecyclerView.this.itemViews[i].setVisibility(8);
                            ListAdapterWithRecyclerView.this.itemViews[i].getLayoutParams().height = 0;
                        }
                    }
                }
            }
        };
        this.isSelected = false;
        this.idFirst = -1;
        this.idSecond = -1;
        this.idImages = -1;
        this.idCard = 1;
        this.container = container;
        this.textMainSize = textMainSize;
        this.textMainColor = textMainColor;
        this.textMainFont = textMainFont;
        this.textDetailColor = textMainColor;
        this.textDetailSize = 0.0f;
        this.textDetailFont = Component.TYPEFACE_DEFAULT;
        this.layoutType = 0;
        this.backgroundColor = backgroundColor;
        this.selectionColor = selectionColor;
        this.imageHeight = 0;
        this.imageWidth = 0;
        this.multiSelect = false;
        this.itemViews = new CardView[stringItems.size()];
        this.selection = new Boolean[stringItems.size()];
        Arrays.fill(this.selection, Boolean.FALSE);
        this.isVisible = new Boolean[stringItems.size()];
        Arrays.fill(this.isVisible, Boolean.TRUE);
        this.items = new ArrayList();
        for (String itemString : stringItems) {
            YailDictionary itemDict = new YailDictionary();
            itemDict.put(Component.LISTVIEW_KEY_MAIN_TEXT, itemString);
            this.items.add(itemDict);
        }
    }

    public void clearSelections() {
        Arrays.fill(this.selection, Boolean.FALSE);
        for (int i = 0; i < this.itemViews.length; i++) {
            this.itemViews[i].setBackgroundColor(this.backgroundColor);
        }
    }

    public void toggleSelection(int pos) {
        Arrays.fill(this.selection, Boolean.FALSE);
        for (int i = 0; i < this.itemViews.length; i++) {
            if (this.itemViews[i] != null) {
                this.itemViews[i].setBackgroundColor(this.backgroundColor);
            }
        }
        if (pos >= 0) {
            this.selection[pos] = true;
            if (this.itemViews[pos] != null) {
                this.itemViews[pos].setBackgroundColor(this.selectionColor);
            }
        }
    }

    public void changeSelections(int pos) {
        this.selection[pos] = Boolean.valueOf(!this.selection[pos].booleanValue());
        if (this.selection[pos].booleanValue()) {
            this.itemViews[pos].setBackgroundColor(this.selectionColor);
        } else {
            this.itemViews[pos].setBackgroundColor(this.backgroundColor);
        }
    }

    public boolean hasVisibleItems() {
        return Arrays.asList(this.isVisible).contains(true);
    }

    public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = new CardView(this.container.$context());
        cardView.setUseCompatPadding(true);
        cardView.setContentPadding(10, 10, 10, 10);
        cardView.setPreventCornerOverlap(true);
        cardView.setCardElevation(2.1f);
        cardView.setRadius(0.0f);
        cardView.setMaxCardElevation(3.0f);
        cardView.setBackgroundColor(this.backgroundColor);
        cardView.setClickable(this.isSelected);
        this.idCard = ViewCompat.generateViewId();
        cardView.setId(this.idCard);
        FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(-1, -2);
        params1.setMargins(0, 0, 0, 0);
        ViewCompat.setElevation(cardView, 20.0f);
        TextView textViewFirst = new TextView(this.container.$context());
        this.idFirst = ViewCompat.generateViewId();
        textViewFirst.setId(this.idFirst);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams1.topMargin = 10;
        textViewFirst.setLayoutParams(layoutParams1);
        textViewFirst.setTextSize(this.textMainSize);
        textViewFirst.setTextColor(this.textMainColor);
        TextViewUtil.setFontTypeface(this.container.$form(), textViewFirst, this.textMainFont, false, false);
        android.widget.LinearLayout linearLayout1 = new android.widget.LinearLayout(this.container.$context());
        LinearLayout.LayoutParams layoutParamslinear1 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout1.setLayoutParams(layoutParamslinear1);
        linearLayout1.setOrientation(0);
        if (this.layoutType == 4 || this.layoutType == 3) {
            ImageView imageView = new ImageView(this.container.$context());
            this.idImages = ViewCompat.generateViewId();
            imageView.setId(this.idImages);
            LinearLayout.LayoutParams layoutParamsImage = new LinearLayout.LayoutParams(this.imageWidth, this.imageHeight);
            imageView.setLayoutParams(layoutParamsImage);
            linearLayout1.addView(imageView);
        }
        if (this.layoutType == 0 || this.layoutType == 3) {
            linearLayout1.addView(textViewFirst);
        } else {
            TextView textViewSecond = new TextView(this.container.$context());
            this.idSecond = ViewCompat.generateViewId();
            textViewSecond.setId(this.idSecond);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            textViewSecond.setTextSize(this.textDetailSize);
            TextViewUtil.setFontTypeface(this.container.$form(), textViewSecond, this.textDetailFont, false, false);
            textViewSecond.setTextColor(this.textDetailColor);
            if (this.layoutType == 1 || this.layoutType == 4) {
                layoutParams2.topMargin = 10;
                textViewSecond.setLayoutParams(layoutParams2);
                android.widget.LinearLayout linearLayout2 = new android.widget.LinearLayout(this.container.$context());
                LinearLayout.LayoutParams layoutParamslinear2 = new LinearLayout.LayoutParams(0, -2, 2.0f);
                linearLayout2.setLayoutParams(layoutParamslinear2);
                linearLayout2.setOrientation(1);
                linearLayout2.addView(textViewFirst);
                linearLayout2.addView(textViewSecond);
                linearLayout1.addView(linearLayout2);
            } else if (this.layoutType == 2) {
                layoutParams2.setMargins(50, 10, 0, 0);
                textViewSecond.setLayoutParams(layoutParams2);
                textViewSecond.setMaxLines(1);
                textViewSecond.setEllipsize(null);
                linearLayout1.addView(textViewFirst);
                linearLayout1.addView(textViewSecond);
            }
        }
        cardView.setLayoutParams(params1);
        cardView.addView(linearLayout1);
        return new RvViewHolder(cardView);
    }

    public void onBindViewHolder(final RvViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() { // from class: com.google.appinventor.components.runtime.ListAdapterWithRecyclerView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                holder.onClick(v);
            }
        });
        YailDictionary dictItem = this.items.get(position);
        String first = dictItem.get(Component.LISTVIEW_KEY_MAIN_TEXT).toString();
        String second = "";
        if (dictItem.containsKey(Component.LISTVIEW_KEY_DESCRIPTION)) {
            second = dictItem.get(Component.LISTVIEW_KEY_DESCRIPTION).toString();
        }
        if (this.layoutType == 0) {
            holder.textViewFirst.setText(first);
        } else if (this.layoutType == 1) {
            holder.textViewFirst.setText(first);
            holder.textViewSecond.setText(second);
        } else if (this.layoutType == 2) {
            holder.textViewFirst.setText(first);
            holder.textViewSecond.setText(second);
        } else if (this.layoutType == 3) {
            String imageName = dictItem.get(Component.LISTVIEW_KEY_IMAGE).toString();
            Drawable drawable = new BitmapDrawable();
            try {
                drawable = MediaUtil.getBitmapDrawable(this.container.$form(), imageName);
            } catch (IOException ioe) {
                Log.e(LOG_TAG, "onBindViewHolder Unable to load image " + imageName + ": " + ioe.getMessage());
            }
            holder.textViewFirst.setText(first);
            ViewUtil.setImage(holder.imageVieww, drawable);
        } else if (this.layoutType == 4) {
            String imageName2 = dictItem.get(Component.LISTVIEW_KEY_IMAGE).toString();
            Drawable drawable2 = new BitmapDrawable();
            try {
                drawable2 = MediaUtil.getBitmapDrawable(this.container.$form(), imageName2);
            } catch (IOException ioe2) {
                Log.e(LOG_TAG, "onBindViewHolder Unable to load image " + imageName2 + ": " + ioe2.getMessage());
            }
            holder.textViewFirst.setText(first);
            holder.textViewSecond.setText(second);
            ViewUtil.setImage(holder.imageVieww, drawable2);
        } else {
            Log.e(LOG_TAG, "onBindViewHolder Layout not recognized: " + this.layoutType);
        }
        if (this.selection[position].booleanValue()) {
            holder.cardView.setBackgroundColor(this.selectionColor);
        } else {
            holder.cardView.setBackgroundColor(this.backgroundColor);
        }
        if (!this.isVisible[position].booleanValue()) {
            holder.cardView.setVisibility(8);
            holder.cardView.getLayoutParams().height = 0;
        } else {
            holder.cardView.setVisibility(0);
            holder.cardView.getLayoutParams().height = -2;
        }
        this.itemViews[position] = holder.cardView;
    }

    public int getItemCount() {
        return this.itemViews.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class RvViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cardView;
        public ImageView imageVieww;
        public TextView textViewFirst;
        public TextView textViewSecond;

        public RvViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            this.cardView = view.findViewById(ListAdapterWithRecyclerView.this.idCard);
            this.textViewFirst = (TextView) view.findViewById(ListAdapterWithRecyclerView.this.idFirst);
            if (ListAdapterWithRecyclerView.this.idSecond != -1) {
                this.textViewSecond = (TextView) view.findViewById(ListAdapterWithRecyclerView.this.idSecond);
            }
            if (ListAdapterWithRecyclerView.this.idImages != -1) {
                this.imageVieww = (ImageView) view.findViewById(ListAdapterWithRecyclerView.this.idImages);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (ListAdapterWithRecyclerView.this.multiSelect) {
                ListAdapterWithRecyclerView.this.changeSelections(position);
            } else {
                ListAdapterWithRecyclerView.this.toggleSelection(position);
            }
            ListAdapterWithRecyclerView.this.clickListener.onItemClick(position, v);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public String getSelectedItems() {
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (int i = 0; i < this.selection.length; i++) {
            if (this.selection[i].booleanValue()) {
                YailDictionary dictItem = this.items.get(i);
                sb.append(sep);
                sb.append(dictItem.get(Component.LISTVIEW_KEY_MAIN_TEXT).toString());
                sep = ",";
            }
        }
        return sb.toString();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return this.filter;
    }
}
