package org.chromium.base.compat;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.autofill.AutofillManager;
import org.chromium.base.StrictModeContext;

public final class ApiHelperForO {
  private ApiHelperForO() {}

  public static boolean isWideColorGamut(Display display) {
    return display.isWideColorGamut();
  }

  public static void setColorMode(Window window, int colorMode) {
    window.setColorMode(colorMode);
  }

  public static boolean isScreenWideColorGamut(Configuration configuration) {
    return configuration.isScreenWideColorGamut();
  }

  public static boolean isInstantApp(PackageManager packageManager) {
    return packageManager.isInstantApp();
  }

  public static void setDefaultFocusHighlightEnabled(View view, boolean enabled) {
    view.setDefaultFocusHighlightEnabled(enabled);
  }

  public static long getTimestamp(ClipDescription clipDescription) {
    return clipDescription.getTimestamp();
  }

  public static Context createContextForSplit(Context context, String name)
      throws PackageManager.NameNotFoundException {
    StrictModeContext ignored = StrictModeContext.allowDiskReads();
    try {
      Context createContextForSplit = context.createContextForSplit(name);
      if (ignored != null) {
        ignored.close();
      }
      return createContextForSplit;
    } catch (Throwable th) {
      if (ignored != null) {
        try {
          ignored.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  public static void cancelAutofillSession(Activity activity) {
    AutofillManager afm = (AutofillManager) activity.getSystemService(AutofillManager.class);
    if (afm != null) {
      afm.cancel();
    }
  }

  public static void notifyValueChangedForAutofill(View view) {
    AutofillManager afm =
        (AutofillManager) view.getContext().getSystemService(AutofillManager.class);
    if (afm != null) {
      afm.notifyValueChanged(view);
    }
  }

  public static boolean areAnimatorsEnabled() {
    return ValueAnimator.areAnimatorsEnabled();
  }

  public static Notification.Builder setChannelId(Notification.Builder builder, String channelId) {
    return builder.setChannelId(channelId);
  }

  public static Notification.Builder setTimeoutAfter(Notification.Builder builder, long ms) {
    return builder.setTimeoutAfter(ms);
  }

  public static void registerDefaultNetworkCallback(
      ConnectivityManager connectivityManager,
      ConnectivityManager.NetworkCallback networkCallback,
      Handler handler) {
    connectivityManager.registerDefaultNetworkCallback(networkCallback, handler);
  }

  public static String getNotificationChannelId(Notification notification) {
    return notification.getChannelId();
  }

  public static Intent registerReceiver(
      Context context,
      BroadcastReceiver receiver,
      IntentFilter filter,
      String permission,
      Handler scheduler,
      int flags) {
    return context.registerReceiver(receiver, filter, permission, scheduler, flags);
  }

  public static void addItem(
      ClipData clipData, ContentResolver contentResolver, ClipData.Item item) {
    clipData.addItem(contentResolver, item);
  }
}
