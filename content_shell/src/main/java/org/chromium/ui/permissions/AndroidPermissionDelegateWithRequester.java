package org.chromium.ui.permissions;

import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;

public abstract class AndroidPermissionDelegateWithRequester implements AndroidPermissionDelegate {
  private static final int REQUEST_CODE_PREFIX = 1000;
  private static final int REQUEST_CODE_RANGE_SIZE = 100;
  private int mNextRequestCode;
  private Handler mHandler = new Handler();
  private SparseArray<PermissionRequestInfo> mOutstandingPermissionRequests = new SparseArray<>();

  protected abstract boolean isPermissionRevokedByPolicyInternal(String str);

  protected abstract boolean requestPermissionsFromRequester(String[] strArr, int i);

  @Override
  public final boolean hasPermission(String permission) {
    boolean isGranted =
        ApiCompatibilityUtils.checkPermission(
                ContextUtils.getApplicationContext(), permission, Process.myPid(), Process.myUid())
            == 0;
    if (isGranted) {
      PermissionPrefs.clearPermissionWasDenied(permission);
    }
    return isGranted;
  }

  @Override
  public final boolean canRequestPermission(String permission) {
    if (hasPermission(permission)) {
      return true;
    }
    if (isPermissionRevokedByPolicy(permission)) {
      return false;
    }
    if (shouldShowRequestPermissionRationale(permission)) {
      PermissionPrefs.clearPermissionWasDenied(permission);
      return true;
    }
    return !PermissionPrefs.wasPermissionDenied(permission);
  }

  @Override
  public final boolean isPermissionRevokedByPolicy(String permission) {
    return isPermissionRevokedByPolicyInternal(permission);
  }

  @Override
  public final void requestPermissions(
      final String[] permissions, final PermissionCallback callback) {
    if (requestPermissionsInternal(permissions, callback)) {
      PermissionPrefs.onAndroidPermissionRequestUiShown(permissions);
    } else {
      this.mHandler.post(
          new Runnable() {
            @Override
            public void run() {
              int i;
              int[] results = new int[permissions.length];
              int i2 = 0;
              while (true) {
                String[] strArr = permissions;
                if (i2 < strArr.length) {
                  if (AndroidPermissionDelegateWithRequester.this.hasPermission(strArr[i2])) {
                    i = 0;
                  } else {
                    i = -1;
                  }
                  results[i2] = i;
                  i2++;
                } else {
                  callback.onRequestPermissionsResult(strArr, results);
                  return;
                }
              }
            }
          });
    }
  }

  @Override
  public final boolean handlePermissionResult(
      int requestCode, String[] permissions, int[] grantResults) {
    PermissionRequestInfo requestInfo = this.mOutstandingPermissionRequests.get(requestCode);
    this.mOutstandingPermissionRequests.delete(requestCode);
    List<String> permissionsGranted = new ArrayList<>();
    List<String> permissionsDenied = new ArrayList<>();
    for (int i = 0; i < permissions.length; i++) {
      if (grantResults[i] == 0) {
        permissionsGranted.add(permissions[i]);
      } else if (shouldPersistDenial(requestInfo, permissions[i])) {
        permissionsDenied.add(permissions[i]);
      }
    }
    PermissionPrefs.editPermissionsPref(permissionsGranted, permissionsDenied);
    if (requestInfo == null || requestInfo.callback == null) {
      return false;
    }
    requestInfo.callback.onRequestPermissionsResult(permissions, grantResults);
    return true;
  }

  private boolean shouldPersistDenial(PermissionRequestInfo requestInfo, String permission) {
    if (Build.VERSION.SDK_INT < 30) {
      return true;
    }
    boolean initialShowRationaleState = false;
    if (requestInfo != null) {
      initialShowRationaleState = requestInfo.getInitialShowRationaleStateFor(permission);
    }
    return initialShowRationaleState || shouldShowRequestPermissionRationale(permission);
  }

  private boolean requestPermissionsInternal(String[] permissions, PermissionCallback callback) {
    int i = this.mNextRequestCode;
    int requestCode = i + 1000;
    this.mNextRequestCode = (i + 1) % 100;
    this.mOutstandingPermissionRequests.put(
        requestCode, new PermissionRequestInfo(permissions, callback));
    if (requestPermissionsFromRequester(permissions, requestCode)) {
      return true;
    }
    this.mOutstandingPermissionRequests.delete(requestCode);
    return false;
  }

  public class PermissionRequestInfo {

    public final PermissionCallback callback;
    public final Map<String, Boolean> initialShowRationaleState = new HashMap();

    public PermissionRequestInfo(String[] permissions, PermissionCallback callback) {
      if (Build.VERSION.SDK_INT >= 30) {
        for (String permission : permissions) {
          this.initialShowRationaleState.put(
              permission,
              Boolean.valueOf(
                  AndroidPermissionDelegateWithRequester.this.shouldShowRequestPermissionRationale(
                      permission)));
        }
      }
      this.callback = callback;
    }

    public boolean getInitialShowRationaleStateFor(String permission) {
      if (this.initialShowRationaleState.get(permission) == null) {
        throw new AssertionError();
      }
      if (this.initialShowRationaleState.get(permission) != null) {
        return this.initialShowRationaleState.get(permission).booleanValue();
      }
      return false;
    }
  }
}
