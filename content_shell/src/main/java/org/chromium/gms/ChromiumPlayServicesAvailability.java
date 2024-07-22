package org.chromium.gms;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;

public final class ChromiumPlayServicesAvailability {
  public static final int GMS_VERSION_NUMBER = 20415000;

  public static boolean isGooglePlayServicesAvailable(Context context) {
    return GoogleApiAvailability.getInstance()
            .isGooglePlayServicesAvailable(context, GMS_VERSION_NUMBER)
        == 0;
  }

  public static int getGooglePlayServicesConnectionResult(Context context) {
    return GoogleApiAvailability.getInstance()
        .isGooglePlayServicesAvailable(context, GMS_VERSION_NUMBER);
  }
}
