package org.chromium.ui.permissions;

public interface AndroidPermissionDelegate {
  boolean canRequestPermission(String str);

  boolean handlePermissionResult(int i, String[] strArr, int[] iArr);

  boolean hasPermission(String str);

  boolean isPermissionRevokedByPolicy(String str);

  void requestPermissions(String[] strArr, PermissionCallback permissionCallback);

  default boolean shouldShowRequestPermissionRationale(String permission) {
    return false;
  }
}
