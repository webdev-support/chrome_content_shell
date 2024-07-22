package org.chromium.ui.permissions;

import android.app.Activity;
import java.lang.ref.WeakReference;
import org.chromium.base.compat.ApiHelperForM;

public class ActivityAndroidPermissionDelegate extends AndroidPermissionDelegateWithRequester {
  private WeakReference<Activity> mActivity;

  public ActivityAndroidPermissionDelegate(WeakReference<Activity> activity) {
    this.mActivity = activity;
  }

  @Override
  public final boolean shouldShowRequestPermissionRationale(String permission) {
    Activity activity = this.mActivity.get();
    if (activity == null) {
      return false;
    }
    return ApiHelperForM.shouldShowRequestPermissionRationale(activity, permission);
  }

  @Override
  protected final boolean isPermissionRevokedByPolicyInternal(String permission) {
    Activity activity = this.mActivity.get();
    if (activity == null) {
      return false;
    }
    return ApiHelperForM.isPermissionRevokedByPolicy(activity, permission);
  }

  @Override
  protected boolean requestPermissionsFromRequester(String[] permissions, int requestCode) {
    Activity activity = this.mActivity.get();
    if (activity == null) {
      return false;
    }
    ApiHelperForM.requestActivityPermissions(activity, permissions, requestCode);
    return true;
  }
}
