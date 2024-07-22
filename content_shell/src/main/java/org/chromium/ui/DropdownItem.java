package org.chromium.ui;

import android.graphics.drawable.Drawable;
import org.chromium.url.GURL;

public interface DropdownItem {
  public static final int NO_ICON = 0;

  GURL getCustomIconUrl();

  Drawable getIconDrawable();

  int getIconId();

  int getIconMarginResId();

  int getIconSizeResId();

  String getItemTag();

  String getLabel();

  int getLabelFontColorResId();

  int getLabelFontSizeResId();

  String getSecondaryLabel();

  String getSecondarySublabel();

  String getSublabel();

  int getSublabelFontColorResId();

  int getSublabelFontSizeResId();

  boolean isBoldLabel();

  boolean isEnabled();

  boolean isGroupHeader();

  boolean isIconAtStart();

  boolean isMultilineLabel();
}
