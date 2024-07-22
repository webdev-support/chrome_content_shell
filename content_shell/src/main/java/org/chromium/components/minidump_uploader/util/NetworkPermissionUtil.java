package org.chromium.components.minidump_uploader.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkPermissionUtil {
  public static boolean isNetworkUnmetered(ConnectivityManager connectivityManager) {
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    if (networkInfo == null || !networkInfo.isConnected()) {
      return false;
    }
    return !connectivityManager.isActiveNetworkMetered();
  }
}
