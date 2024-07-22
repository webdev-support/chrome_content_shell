package org.chromium.components.crash.browser;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.metrics.RecordHistogram;

public class ProcessExitReasonFromSystem {
  private static ActivityManager sActivityManager;

  @Retention(RetentionPolicy.SOURCE)
  public @interface ExitReason {
    public static final int NUM_ENTRIES = 14;
    public static final int REASON_ANR = 0;
    public static final int REASON_CRASH = 1;
    public static final int REASON_CRASH_NATIVE = 2;
    public static final int REASON_DEPENDENCY_DIED = 3;
    public static final int REASON_EXCESSIVE_RESOURCE_USAGE = 4;
    public static final int REASON_EXIT_SELF = 5;
    public static final int REASON_INITIALIZATION_FAILURE = 6;
    public static final int REASON_LOW_MEMORY = 7;
    public static final int REASON_OTHER = 8;
    public static final int REASON_PERMISSION_CHANGE = 9;
    public static final int REASON_SIGNALED = 10;
    public static final int REASON_UNKNOWN = 11;
    public static final int REASON_USER_REQUESTED = 12;
    public static final int REASON_USER_STOPPED = 13;
  }

  public static int getExitReason(int pid) {
    if (Build.VERSION.SDK_INT < 30) {
      return -1;
    }
    ActivityManager am = sActivityManager;
    if (am == null) {
      am = (ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity");
    }
    List<ApplicationExitInfo> reasons = am.getHistoricalProcessExitReasons(null, pid, 1);
    if (reasons.isEmpty() || reasons.get(0) == null || reasons.get(0).getPid() != pid) {
      return -1;
    }
    return reasons.get(0).getReason();
  }

  private static void recordExitReasonToUma(int pid, String umaName) {
    recordAsEnumHistogram(umaName, getExitReason(pid));
  }

  public static void recordAsEnumHistogram(String umaName, int systemReason) {
    Integer exitReason = convertApplicationExitInfoToExitReason(systemReason);
    if (exitReason != null) {
      RecordHistogram.recordEnumeratedHistogram(umaName, exitReason.intValue(), 14);
    }
  }

  public static Integer convertApplicationExitInfoToExitReason(int systemReason) {
    switch (systemReason) {
      case 0:
        return 11;
      case 1:
        return 5;
      case 2:
        return 10;
      case 3:
        return 7;
      case 4:
        return 1;
      case 5:
        return 2;
      case 6:
        return 0;
      case 7:
        return 6;
      case 8:
        return 9;
      case 9:
        return 4;
      case 10:
        return 12;
      case 11:
        return 13;
      case 12:
        return 3;
      case 13:
        return 8;
      default:
        return null;
    }
  }

  public static void setActivityManagerForTest(ActivityManager am) {
    sActivityManager = am;
  }
}
