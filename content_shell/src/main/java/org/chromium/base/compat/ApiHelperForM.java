package org.chromium.base.compat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.security.NetworkSecurityPolicy;
import android.view.ActionMode;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public final class ApiHelperForM {
  private ApiHelperForM() {}

  public static void onPageCommitVisible(WebViewClient webViewClient, WebView webView, String url) {
    webViewClient.onPageCommitVisible(webView, url);
  }

  public static boolean isProcess64Bit() {
    return Process.is64Bit();
  }

  public static Network getBoundNetworkForProcess(ConnectivityManager connectivityManager) {
    return connectivityManager.getBoundNetworkForProcess();
  }

  public static long getNetworkHandle(Network network) {
    return network.getNetworkHandle();
  }

  public static Network getActiveNetwork(ConnectivityManager connectivityManager) {
    return connectivityManager.getActiveNetwork();
  }

  public static NetworkInfo getNetworkInfo(
      ConnectivityManager connectivityManager, Network network) {
    return connectivityManager.getNetworkInfo(network);
  }

  public static void requestActivityPermissions(
      Activity activity, String[] permissions, int requestCode) {
    activity.requestPermissions(permissions, requestCode);
  }

  public static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
    return activity.shouldShowRequestPermissionRationale(permission);
  }

  public static boolean isPermissionRevokedByPolicy(Activity activity, String permission) {
    return activity
        .getPackageManager()
        .isPermissionRevokedByPolicy(permission, activity.getPackageName());
  }

  public static boolean isCleartextTrafficPermitted() {
    return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
  }

  public static boolean isSystemUser(UserManager userManager) {
    return userManager.isSystemUser();
  }

  public static void invalidateContentRectOnActionMode(ActionMode actionMode) {
    actionMode.invalidateContentRect();
  }

  public static void onWindowFocusChangedOnActionMode(ActionMode actionMode, boolean gainFocus) {
    actionMode.onWindowFocusChanged(gainFocus);
  }

  public static int getActionModeType(ActionMode actionMode) {
    return actionMode.getType();
  }

  public static long getDefaultActionModeHideDuration() {
    return ViewConfiguration.getDefaultActionModeHideDuration();
  }

  public static void hideActionMode(ActionMode actionMode, long duration) {
    actionMode.hide(duration);
  }

  public static int getPendingIntentImmutableFlag() {
    return 67108864;
  }

  public static void reportNetworkConnectivity(
      ConnectivityManager connectivityManager, Network network, boolean hasConnectivity) {
    connectivityManager.reportNetworkConnectivity(network, hasConnectivity);
  }

  public static int getActionButton(MotionEvent event) {
    return event.getActionButton();
  }

  public static int getModePhysicalWidth(Display.Mode mode) {
    return mode.getPhysicalWidth();
  }

  public static int getModePhysicalHeight(Display.Mode mode) {
    return mode.getPhysicalHeight();
  }

  public static Icon createIconWithBitmap(Bitmap bitmap) {
    return Icon.createWithBitmap(bitmap);
  }

  public static boolean isDeviceIdleMode(PowerManager powerManager) {
    return powerManager.isDeviceIdleMode();
  }

  public static <T> T getSystemService(Context context, Class<T> serviceClass) {
    return (T) context.getSystemService(serviceClass);
  }
}
