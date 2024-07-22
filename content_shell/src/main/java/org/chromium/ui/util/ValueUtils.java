package org.chromium.ui.util;

import android.content.res.Resources;
import android.util.TypedValue;

public final class ValueUtils {
  private ValueUtils() {}

  public static float getFloat(Resources resources, int dimenRes) {
    TypedValue typedValue = new TypedValue();
    resources.getValue(dimenRes, typedValue, true);
    return typedValue.getFloat();
  }
}
