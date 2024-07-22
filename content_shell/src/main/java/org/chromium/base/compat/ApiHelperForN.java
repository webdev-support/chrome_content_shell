package org.chromium.base.compat;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.net.ConnectivityManager;
import android.os.Process;
import android.security.NetworkSecurityPolicy;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;

public final class ApiHelperForN {
  private ApiHelperForN() {}

  public static boolean startDragAndDrop(
      View view,
      ClipData data,
      View.DragShadowBuilder shadowBuilder,
      Object myLocalState,
      int flags) {
    return view.startDragAndDrop(data, shadowBuilder, myLocalState, flags);
  }

  public static void setCryptoInfoPattern(MediaCodec.CryptoInfo cryptoInfo, int encrypt, int skip) {
    cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(encrypt, skip));
  }

  public static void setVrModeEnabled(
      Activity activity, boolean enabled, ComponentName requestedComponent)
      throws PackageManager.NameNotFoundException {
    activity.setVrModeEnabled(enabled, requestedComponent);
  }

  public static boolean isCleartextTrafficPermitted(String host) {
    return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(host);
  }

  public static PointerIcon onResolvePointerIcon(View view, MotionEvent event, int pointerIndex) {
    return view.onResolvePointerIcon(event, pointerIndex);
  }

  public static long getStartUptimeMillis() {
    return Process.getStartUptimeMillis();
  }

  public static int getRestrictBackgroundStatus(ConnectivityManager cm) {
    return cm.getRestrictBackgroundStatus();
  }
}
