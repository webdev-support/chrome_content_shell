package org.chromium.ui.util;

import android.content.res.Resources;
import android.util.TypedValue;

public final class AttrUtils {
  private AttrUtils() {}

  public static boolean resolveBoolean(Resources.Theme theme, int attrRes) {
    TypedValue typedValue = new TypedValue();
    theme.resolveAttribute(attrRes, typedValue, true);
    return typedValue.data != 0;
  }

  public static int resolveColor(Resources.Theme theme, int attrRes) {
    TypedValue typedValue = new TypedValue();
    theme.resolveAttribute(attrRes, typedValue, true);
    if (typedValue.resourceId != 0) {
      return theme.getResources().getColor(typedValue.resourceId, theme);
    }
    return typedValue.data;
  }

  public static int resolveColor(Resources.Theme theme, int attrRes, int defaultColorRes) {
    TypedValue typedValue = new TypedValue();
    if (theme.resolveAttribute(attrRes, typedValue, true)) {
      return typedValue.data;
    }
    return theme.getResources().getColor(defaultColorRes, theme);
  }
}
