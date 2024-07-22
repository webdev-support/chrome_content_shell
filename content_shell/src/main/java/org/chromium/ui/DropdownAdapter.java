package org.chromium.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.example.chromium_content_view.R;
import java.util.List;
import java.util.Set;

public class DropdownAdapter extends ArrayAdapter<DropdownItem> {
  private final boolean mAreAllItemsEnabled;
  private final Context mContext;
  private final int mLabelMargin;
  private final Set<Integer> mSeparators;

  public DropdownAdapter(
      Context context, List<? extends DropdownItem> items, Set<Integer> separators) {
    super(context, R.layout.dropdown_item);
    this.mContext = context;
    addAll(items);
    this.mSeparators = separators;
    this.mAreAllItemsEnabled = checkAreAllItemsEnabled();
    this.mLabelMargin =
        context.getResources().getDimensionPixelSize(R.dimen.dropdown_item_label_margin);
  }

  private boolean checkAreAllItemsEnabled() {
    for (int i = 0; i < getCount(); i++) {
      DropdownItem item = getItem(i);
      if (item.isEnabled() && !item.isGroupHeader()) {
        return false;
      }
    }
    return true;
  }

  @Override // android.widget.ArrayAdapter, android.widget.Adapter
  public View getView(int position, View convertView, ViewGroup parent) {
    int dividerColor;
    int iconSize;
    View layout = convertView;
    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
      layout = inflater.inflate(R.layout.dropdown_item, (ViewGroup) null);
      layout.setBackground(new DropdownDividerDrawable(null));
    }
    DropdownDividerDrawable divider = (DropdownDividerDrawable) layout.getBackground();
    int height = this.mContext.getResources().getDimensionPixelSize(R.dimen.dropdown_item_height);
    if (position == 0) {
      divider.setDividerColor(0);
    } else {
      int dividerHeight =
          this.mContext.getResources().getDimensionPixelSize(R.dimen.dropdown_item_divider_height);
      height += dividerHeight;
      divider.setHeight(dividerHeight);
      Set<Integer> set = this.mSeparators;
      if (set != null && set.contains(Integer.valueOf(position))) {
        dividerColor = this.mContext.getColor(R.color.dropdown_dark_divider_color);
      } else {
        dividerColor = this.mContext.getColor(R.color.dropdown_divider_color);
      }
      divider.setDividerColor(dividerColor);
    }
    DropdownItem item = getItem(position);
    LinearLayout wrapper = (LinearLayout) layout.findViewById(R.id.dropdown_label_wrapper);
    if (item.isMultilineLabel()) {
      height = -2;
    }
    wrapper.setOrientation(1);
    wrapper.setLayoutParams(new LinearLayout.LayoutParams(0, height, 1.0f));
    TextView labelView = (TextView) layout.findViewById(R.id.dropdown_label);
    labelView.setText(item.getLabel());
    labelView.setSingleLine(!item.isMultilineLabel());
    if (item.isMultilineLabel()) {
      int existingStart = ViewCompat.getPaddingStart(labelView);
      int existingEnd = ViewCompat.getPaddingEnd(labelView);
      int i = this.mLabelMargin;
      ViewCompat.setPaddingRelative(labelView, existingStart, i, existingEnd, i);
    }
    labelView.setEnabled(item.isEnabled());
    if (item.isGroupHeader() || item.isBoldLabel()) {
      labelView.setTypeface(null, 1);
    } else {
      labelView.setTypeface(null, 0);
    }
    labelView.setTextColor(this.mContext.getColor(item.getLabelFontColorResId()));
    labelView.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.text_size_large));
    TextView sublabelView = (TextView) layout.findViewById(R.id.dropdown_sublabel);
    CharSequence sublabel = item.getSublabel();
    if (TextUtils.isEmpty(sublabel)) {
      sublabelView.setVisibility(8);
    } else {
      sublabelView.setText(sublabel);
      sublabelView.setTextSize(
          0, this.mContext.getResources().getDimension(item.getSublabelFontSizeResId()));
      sublabelView.setVisibility(0);
    }
    ImageView iconViewStart = (ImageView) layout.findViewById(R.id.start_dropdown_icon);
    ImageView iconViewEnd = (ImageView) layout.findViewById(R.id.end_dropdown_icon);
    if (item.isIconAtStart()) {
      iconViewEnd.setVisibility(8);
    } else {
      iconViewStart.setVisibility(8);
    }
    ImageView iconView = item.isIconAtStart() ? iconViewStart : iconViewEnd;
    if (item.getIconId() == 0) {
      iconView.setVisibility(8);
    } else {
      int iconSizeResId = item.getIconSizeResId();
      if (iconSizeResId == 0) {
        iconSize = -2;
      } else {
        iconSize = this.mContext.getResources().getDimensionPixelSize(iconSizeResId);
      }
      ViewGroup.MarginLayoutParams iconLayoutParams =
          (ViewGroup.MarginLayoutParams) iconView.getLayoutParams();
      iconLayoutParams.width = iconSize;
      iconLayoutParams.height = iconSize;
      int iconMargin =
          this.mContext.getResources().getDimensionPixelSize(item.getIconMarginResId());
      MarginLayoutParamsCompat.setMarginStart(iconLayoutParams, iconMargin);
      MarginLayoutParamsCompat.setMarginEnd(iconLayoutParams, iconMargin);
      iconView.setLayoutParams(iconLayoutParams);
      iconView.setImageDrawable(AppCompatResources.getDrawable(this.mContext, item.getIconId()));
      iconView.setVisibility(0);
    }
    return layout;
  }

  @Override // android.widget.BaseAdapter, android.widget.ListAdapter
  public boolean areAllItemsEnabled() {
    return this.mAreAllItemsEnabled;
  }

  @Override // android.widget.BaseAdapter, android.widget.ListAdapter
  public boolean isEnabled(int position) {
    if (position < 0 || position >= getCount()) {
      return false;
    }
    DropdownItem item = getItem(position);
    return item.isEnabled() && !item.isGroupHeader();
  }
}
