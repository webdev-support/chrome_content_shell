package org.chromium.ui.permissions;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.TimeUtils;

public class PermissionPrefs {
  private static final String ANDROID_PERMISSION_REQUEST_TIMESTAMP_KEY_PREFIX =
      "AndroidPermissionRequestTimestamp::";
  private static final String PERMISSION_WAS_DENIED_KEY_PREFIX = "HasRequestedAndroidPermission::";

  public static String normalizePermissionName(String permission) {
    return permission;
  }

  public static boolean wasPermissionDenied(String permission) {
    SharedPreferences prefs = ContextUtils.getAppSharedPreferences();
    return prefs.getBoolean(getPermissionWasDeniedKey(permission), false);
  }

  public static void clearPermissionWasDenied(String permission) {
    SharedPreferences prefs = ContextUtils.getAppSharedPreferences();
    SharedPreferences.Editor editor = prefs.edit();
    editor.remove(getPermissionWasDeniedKey(permission));
    editor.apply();
  }

  public static void editPermissionsPref(
      List<String> permissionsGranted, List<String> permissionsDenied) {
    SharedPreferences prefs = ContextUtils.getAppSharedPreferences();
    SharedPreferences.Editor editor = prefs.edit();
    for (String permission : permissionsGranted) {
      editor.remove(getPermissionWasDeniedKey(permission));
    }
    for (String permission2 : permissionsDenied) {
      editor.putBoolean(getPermissionWasDeniedKey(permission2), true);
    }
    editor.apply();
  }

  public static long getAndroidNotificationPermissionRequestTimestamp() {
    String prefName =
        ANDROID_PERMISSION_REQUEST_TIMESTAMP_KEY_PREFIX
            + normalizePermissionName("android.permission.POST_NOTIFICATIONS");
    SharedPreferences prefs = ContextUtils.getAppSharedPreferences();
    return prefs.getLong(prefName, 0L);
  }

  public static void onAndroidPermissionRequestUiShown(String[] permissions) {
    boolean isNotification = false;
    int length = permissions.length;
    int i = 0;
    while (true) {
      if (i >= length) {
        break;
      }
      String permission = permissions[i];
      if (!TextUtils.equals(permission, "android.permission.POST_NOTIFICATIONS")) {
        i++;
      } else {
        isNotification = true;
        break;
      }
    }
    if (isNotification) {
      String prefName =
          ANDROID_PERMISSION_REQUEST_TIMESTAMP_KEY_PREFIX
              + normalizePermissionName("android.permission.POST_NOTIFICATIONS");
      SharedPreferences prefs = ContextUtils.getAppSharedPreferences();
      prefs.edit().putLong(prefName, TimeUtils.currentTimeMillis()).apply();
    }
  }

  private static String getPermissionWasDeniedKey(String permission) {
    return PERMISSION_WAS_DENIED_KEY_PREFIX + normalizePermissionName(permission);
  }
}
