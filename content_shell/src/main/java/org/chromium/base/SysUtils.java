package org.chromium.base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.StrictMode;
import com.example.chromium_content_view.BuildConfig;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public class SysUtils {

  private static final int ANDROID_LOW_MEMORY_DEVICE_THRESHOLD_MB = 512;
  private static final int ANDROID_O_LOW_MEMORY_DEVICE_THRESHOLD_MB = 1024;
  private static final int BYTES_PER_GIGABYTE = 1073741824;
  private static final long HIGH_END_DEVICE_DISK_CAPACITY_GB = 24;
  private static final String TAG = "SysUtils";
  private static Integer sAmountOfPhysicalMemoryKB;
  private static Boolean sHighEndDiskDevice;
  private static Boolean sLowEndDevice;

  public interface Natives {
    void logPageFaultCountToTracing();
  }

  private SysUtils() {}

  private static int detectAmountOfPhysicalMemoryKB() {
    Pattern pattern = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
    StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
    try {
      try {
        FileReader fileReader = new FileReader("/proc/meminfo");
        try {
          BufferedReader reader = new BufferedReader(fileReader);
          while (true) {
            String line = reader.readLine();
            if (line == null) {
              android.util.Log.w(TAG, "/proc/meminfo lacks a MemTotal entry?");
              break;
            }
            Matcher m = pattern.matcher(line);
            if (m.find()) {
              int totalMemoryKB = Integer.parseInt(m.group(1));
              if (totalMemoryKB > 1024) {
                reader.close();
                return totalMemoryKB;
              }
              android.util.Log.w(TAG, "Invalid /proc/meminfo total size in kB: " + m.group(1));
            }
          }
          reader.close();
        } finally {
          fileReader.close();
        }
      } catch (Exception e) {
        android.util.Log.w(TAG, "Cannot get total physical size from /proc/meminfo", e);
      }
      StrictMode.setThreadPolicy(oldPolicy);
      return 0;
    } finally {
      StrictMode.setThreadPolicy(oldPolicy);
    }
  }

  public static boolean isLowEndDevice() {
    if (sLowEndDevice == null || BuildConfig.IS_FOR_TEST) {
      sLowEndDevice = Boolean.valueOf(detectLowEndDevice());
    }
    return sLowEndDevice.booleanValue();
  }

  public static int amountOfPhysicalMemoryKB() {
    if (sAmountOfPhysicalMemoryKB == null) {
      sAmountOfPhysicalMemoryKB = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
    }
    return sAmountOfPhysicalMemoryKB.intValue();
  }

  public static boolean isCurrentlyLowMemory() {
    ActivityManager am =
        (ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity");
    ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
    try {
      am.getMemoryInfo(info);
      return info.lowMemory;
    } catch (SecurityException e) {
      return false;
    }
  }

  public static boolean hasCamera(Context context) {
    PackageManager pm = context.getPackageManager();
    return pm.hasSystemFeature("android.hardware.camera.any");
  }

  private static boolean detectLowEndDevice() {
    int physicalMemoryKb;
    if (!CommandLine.isInitialized()) {
      throw new AssertionError();
    }
    if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_LOW_END_DEVICE_MODE)) {
      return true;
    }
    return !CommandLine.getInstance().hasSwitch(BaseSwitches.DISABLE_LOW_END_DEVICE_MODE)
        && (physicalMemoryKb = amountOfPhysicalMemoryKB()) > 0
        && physicalMemoryKb / 1024 <= 1024;
  }

  public static void logPageFaultCountToTracing() {
    SysUtilsJni.get().logPageFaultCountToTracing();
  }

  public static boolean isHighEndDiskDevice() {
    if (sHighEndDiskDevice == null) {
      sHighEndDiskDevice = Boolean.valueOf(detectHighEndDiskDevice());
    }
    return sHighEndDiskDevice.booleanValue();
  }

  private static boolean detectHighEndDiskDevice() {
    try {
      StrictModeContext ignored = StrictModeContext.allowDiskReads();
      StatFs dataStats = new StatFs(Environment.getDataDirectory().getAbsolutePath());
      long totalGBytes = dataStats.getTotalBytes() / 1073741824;
      boolean z = totalGBytes >= HIGH_END_DEVICE_DISK_CAPACITY_GB;
      if (ignored != null) {
        ignored.close();
      }
      return z;
    } catch (IllegalArgumentException e) {
      android.util.Log.v(TAG, "Cannot get disk data capacity", e);
      return false;
    }
  }

  public static boolean isAndroidGo() {
    return isLowEndDevice();
  }
}
