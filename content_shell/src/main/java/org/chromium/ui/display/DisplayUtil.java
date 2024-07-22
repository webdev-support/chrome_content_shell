package org.chromium.ui.display;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.example.chromium_content_view.R;
import org.chromium.base.compat.ApiHelperForR;

public abstract class DisplayUtil {

  private static final float UI_SCALING_FACTOR_FOR_AUTOMOTIVE = 1.34f;
  private static Float sUiScalingFactorForAutomotiveOverride;

  public static void setUiScalingFactorForAutomotiveForTesting(float scalingFactor) {
    sUiScalingFactorForAutomotiveOverride = Float.valueOf(scalingFactor);
  }

  public static void resetUiScalingFactorForAutomotiveForTesting() {
    sUiScalingFactorForAutomotiveOverride = null;
  }

  @Deprecated
  public static float getUiScalingFactorForAutomotive() {
    return sUiScalingFactorForAutomotiveOverride.floatValue();
  }

  public static int getUiDensityForAutomotive(Context context, int baseDensity) {
    float uiScalingFactor;
    TypedValue automotiveUiScaleFactor = new TypedValue();
    context
        .getResources()
        .getValue(R.dimen.automotive_ui_scale_factor, automotiveUiScaleFactor, true);
    Float f = sUiScalingFactorForAutomotiveOverride;
    if (f != null) {
      uiScalingFactor = f.floatValue();
    } else {
      uiScalingFactor = automotiveUiScaleFactor.getFloat();
    }
    int rawScaledDensity = (int) (baseDensity * uiScalingFactor);
    return ((int) Math.ceil(rawScaledDensity / 20.0f)) * 20;
  }

  public static int getSmallestWidth(DisplayAndroid display) {
    int width = display.getDisplayWidth();
    int height = display.getDisplayHeight();
    return width < height ? width : height;
  }

  public static int pxToDp(DisplayAndroid display, int value) {
    return (int) ((value / display.getDipScale()) + 0.5f);
  }

  public static int dpToPx(DisplayAndroid display, int value) {
    return (int) ((value * display.getDipScale()) + 0.5f);
  }

  public static DisplayMetrics scaleUpDisplayMetricsForAutomotive(
      Context context, DisplayMetrics displayMetrics) {
    int adjustedDensity = getUiDensityForAutomotive(context, displayMetrics.densityDpi);
    float scaling = adjustedDensity / displayMetrics.densityDpi;
    displayMetrics.density *= scaling;
    displayMetrics.densityDpi = adjustedDensity;
    displayMetrics.xdpi *= scaling;
    displayMetrics.ydpi *= scaling;
    return displayMetrics;
  }

  public static void scaleUpConfigurationForAutomotive(
      Context context, Configuration configuration) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    WindowManager windowManager = (WindowManager) context.getSystemService("window");
    if (windowManager == null) {
      throw new AssertionError();
    }
    windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
    int adjustedDensity = getUiDensityForAutomotive(context, displayMetrics.densityDpi);
    float scaling = adjustedDensity / displayMetrics.densityDpi;
    int screenWidthDp = displayMetrics.widthPixels;
    int screenHeightDp = displayMetrics.heightPixels;
    if (Build.VERSION.SDK_INT >= 30) {
      Insets systemBarInsets =
          windowManager
              .getCurrentWindowMetrics()
              .getWindowInsets()
              .getInsets(WindowInsets.Type.systemBars());
      screenHeightDp = (screenHeightDp - systemBarInsets.top) - systemBarInsets.bottom;
      screenWidthDp = (screenWidthDp - systemBarInsets.left) - systemBarInsets.right;
    }
    configuration.densityDpi = adjustedDensity;
    configuration.screenWidthDp = Math.round(screenWidthDp / (displayMetrics.density * scaling));
    configuration.screenHeightDp = Math.round(screenHeightDp / (displayMetrics.density * scaling));
    configuration.smallestScreenWidthDp =
        Math.min(configuration.screenWidthDp, configuration.screenHeightDp);
  }

  public static int getCurrentSmallestScreenWidth(Context context) {
    DisplayAndroid display = DisplayAndroid.getNonMultiDisplay(context);
    Context windowManagerContext =
        (Build.VERSION.SDK_INT < 30
                || Build.VERSION.SDK_INT >= 33
                || display.getWindowContext() == null)
            ? context
            : display.getWindowContext();
    if (Build.VERSION.SDK_INT >= 30) {
      WindowManager manager = (WindowManager) windowManagerContext.getSystemService("window");
      if (manager == null) {
        throw new AssertionError();
      }
      Rect bounds = ApiHelperForR.getMaximumWindowMetricsBounds(manager);
      return pxToDp(display, Math.min(bounds.right - bounds.left, bounds.bottom - bounds.top));
    }
    return pxToDp(display, getSmallestWidth(display));
  }
}
