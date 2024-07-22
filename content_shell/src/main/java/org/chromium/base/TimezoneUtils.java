package org.chromium.base;

import android.os.StrictMode;
import java.util.TimeZone;
import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
class TimezoneUtils {
  private TimezoneUtils() {}

  private static String getDefaultTimeZoneId() {
    StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
    String timezoneID = TimeZone.getDefault().getID();
    StrictMode.setThreadPolicy(oldPolicy);
    return timezoneID;
  }
}
