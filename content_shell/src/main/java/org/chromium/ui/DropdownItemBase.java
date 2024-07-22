package org.chromium.ui;

import android.graphics.drawable.Drawable;
import com.example.chromium_content_view.R;
import org.chromium.url.GURL;

public class DropdownItemBase implements DropdownItem {
  @Override
  public String getLabel() {
    return null;
  }

  @Override
  public String getSecondaryLabel() {
    return null;
  }

  @Override
  public String getSublabel() {
    return null;
  }

  @Override
  public String getSecondarySublabel() {
    return null;
  }

  @Override
  public String getItemTag() {
    return null;
  }

  @Override
  public int getIconId() {
    return 0;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean isGroupHeader() {
    return false;
  }

  @Override
  public boolean isMultilineLabel() {
    return false;
  }

  @Override
  public boolean isBoldLabel() {
    return false;
  }

  @Override
  public int getLabelFontColorResId() {
    return R.color.default_text_color_list_baseline;
  }

  @Override
  public int getLabelFontSizeResId() {
    return R.dimen.text_size_large;
  }

  @Override
  public int getSublabelFontColorResId() {
    return R.color.default_text_color_secondary_list_baseline;
  }

  @Override
  public int getSublabelFontSizeResId() {
    return R.dimen.text_size_small;
  }

  @Override
  public boolean isIconAtStart() {
    return false;
  }

  @Override
  public int getIconSizeResId() {
    return 0;
  }

  @Override
  public int getIconMarginResId() {
    return R.dimen.dropdown_icon_margin;
  }

  @Override
  public GURL getCustomIconUrl() {
    return null;
  }

  @Override
  public Drawable getIconDrawable() {
    return null;
  }
}
