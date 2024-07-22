package org.chromium.base.memory;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import org.chromium.base.ContextUtils;

public class MemoryInfoBridge {
  public static Debug.MemoryInfo getActivityManagerMemoryInfoForSelf() {
    ActivityManager activityManager =
        (ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity");
    int pid = Process.myPid();
    try {
      Debug.MemoryInfo[] infos = activityManager.getProcessMemoryInfo(new int[] {pid});
      if (infos == null) {
        return null;
      }
      return infos[0];
    } catch (SecurityException e) {
      return null;
    }
  }
}
