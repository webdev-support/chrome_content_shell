package org.chromium.base;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Process;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import org.chromium.base.compat.ApiHelperForM;
import org.chromium.base.compat.ApiHelperForP;
import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public class RadioUtils {

  private static Boolean sHaveAccessNetworkState;
  private static Boolean sHaveAccessWifiState;

  private RadioUtils() {}

  private static boolean isSupported() {
    return Build.VERSION.SDK_INT >= 28 && haveAccessNetworkState() && haveAccessWifiState();
  }

  private static boolean haveAccessNetworkState() {
    if (sHaveAccessNetworkState == null) {
      sHaveAccessNetworkState =
          Boolean.valueOf(
              ApiCompatibilityUtils.checkPermission(
                      ContextUtils.getApplicationContext(),
                      "android.permission.ACCESS_NETWORK_STATE",
                      Process.myPid(),
                      Process.myUid())
                  == 0);
    }
    return sHaveAccessNetworkState.booleanValue();
  }

  private static boolean haveAccessWifiState() {
    if (sHaveAccessWifiState == null) {
      sHaveAccessWifiState =
          Boolean.valueOf(
              ApiCompatibilityUtils.checkPermission(
                      ContextUtils.getApplicationContext(),
                      "android.permission.ACCESS_WIFI_STATE",
                      Process.myPid(),
                      Process.myUid())
                  == 0);
    }
    return sHaveAccessWifiState.booleanValue();
  }

  private static boolean isWifiConnected() {
    if (!isSupported()) {
      throw new AssertionError();
    }
    TraceEvent te = TraceEvent.scoped("RadioUtils::isWifiConnected");
    try {
      ConnectivityManager connectivityManager =
          (ConnectivityManager)
              ContextUtils.getApplicationContext().getSystemService("connectivity");
      Network network = ApiHelperForM.getActiveNetwork(connectivityManager);
      if (network != null) {
        NetworkCapabilities networkCapabilities =
            connectivityManager.getNetworkCapabilities(network);
        if (networkCapabilities != null) {
          boolean hasTransport = networkCapabilities.hasTransport(1);
          if (te != null) {
            te.close();
          }
          return hasTransport;
        }
        if (te != null) {
          te.close();
        }
        return false;
      }
      if (te != null) {
        te.close();
      }
      return false;
    } catch (Throwable th) {
      if (te != null) {
        try {
          te.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  private static int getCellSignalLevel() {
    if (!isSupported()) {
      throw new AssertionError();
    }
    TraceEvent te = TraceEvent.scoped("RadioUtils::getCellSignalLevel");
    try {
      TelephonyManager telephonyManager =
          (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
      int level = -1;
      try {
        SignalStrength signalStrength = ApiHelperForP.getSignalStrength(telephonyManager);
        if (signalStrength != null) {
          level = signalStrength.getLevel();
        }
      } catch (SecurityException e) {
      }
      if (te != null) {
        te.close();
      }
      return level;
    } catch (Throwable th) {
      if (te != null) {
        try {
          te.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  private static int getCellDataActivity() {
    if (!isSupported()) {
      throw new AssertionError();
    }
    TraceEvent te = TraceEvent.scoped("RadioUtils::getCellDataActivity");
    try {
      TelephonyManager telephonyManager =
          (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
      try {
        int dataActivity = telephonyManager.getDataActivity();
        if (te != null) {
          te.close();
        }
        return dataActivity;
      } catch (SecurityException e) {
        if (te != null) {
          te.close();
          return -1;
        }
        return -1;
      }
    } catch (Throwable th) {
      if (te != null) {
        try {
          te.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }
}
