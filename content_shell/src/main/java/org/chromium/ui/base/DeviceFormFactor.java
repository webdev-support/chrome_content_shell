package org.chromium.ui.base;

import android.content.Context;
import com.example.chromium_content_view.R;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.ui.display.DisplayAndroid;
import org.chromium.ui.display.DisplayUtil;

public class DeviceFormFactor {
  public static final int MINIMUM_TABLET_WIDTH_DP = 600;
  private static final int SCREEN_BUCKET_LARGET_TABLET = 3;
  public static final int SCREEN_BUCKET_TABLET = 2;

  @Deprecated
  public static boolean isTablet() {
    return detectScreenWidthBucket(ContextUtils.getApplicationContext()) >= 2;
  }

  public static boolean isNonMultiDisplayContextOnTablet(Context context) {
    return detectScreenWidthBucket(context) >= 2;
  }

  public static boolean isWindowOnTablet(WindowAndroid windowAndroid) {
    return detectScreenWidthBucket(windowAndroid) >= 2;
  }

  public static boolean isNonMultiDisplayContextOnLargeTablet(Context context) {
    return detectScreenWidthBucket(context) == 3;
  }

  private static int detectScreenWidthBucket(Context context) {
    return context.getResources().getInteger(R.integer.min_screen_width_bucket);
  }

  private static int detectScreenWidthBucket(WindowAndroid windowAndroid) {
    ThreadUtils.assertOnUiThread();
    Context context = windowAndroid.getContext().get();
    if (context == null) {
      return 0;
    }
    return context.getResources().getInteger(R.integer.min_screen_width_bucket);
  }

  public static int getNonMultiDisplayMinimumTabletWidthPx(Context context) {
    return getMinimumTabletWidthPx(DisplayAndroid.getNonMultiDisplay(context));
  }

  public static int getMinimumTabletWidthPx(DisplayAndroid display) {
    return DisplayUtil.dpToPx(display, 600);
  }
}
