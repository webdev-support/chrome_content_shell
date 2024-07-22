package org.chromium.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.UserManager;
import android.provider.MediaStore;
import android.view.Display;
import android.view.View;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ApiCompatibilityUtils {
  private static final String TAG = "ApiCompatUtil";

  private ApiCompatibilityUtils() {}

  private static class ApisQ {
    private ApisQ() {}

    static boolean isRunningInUserTestHarness() {
      return ActivityManager.isRunningInUserTestHarness();
    }

    static List<Integer> getTargetableDisplayIds(Activity activity) {
      DisplayManager displayManager;
      List<Integer> displayList = new ArrayList<>();
      if (activity == null
          || (displayManager = (DisplayManager) activity.getSystemService("display")) == null) {
        return displayList;
      }
      Display[] displays = displayManager.getDisplays();
      ActivityManager am = (ActivityManager) activity.getSystemService("activity");
      for (Display display : displays) {
        if (display.getState() == 2
            && am.isActivityStartAllowedOnDisplay(
                activity, display.getDisplayId(), new Intent(activity, activity.getClass()))) {
          displayList.add(Integer.valueOf(display.getDisplayId()));
        }
      }
      return displayList;
    }
  }

  public static class ApisP {
    private ApisP() {}

    static String getProcessName() {
      return Application.getProcessName();
    }

    static Bitmap getBitmapByUri(ContentResolver cr, Uri uri) throws IOException {
      return ImageDecoder.decodeBitmap(ImageDecoder.createSource(cr, uri));
    }
  }

  private static class ApisO {
    private ApisO() {}

    static void initNotificationSettingsIntent(Intent intent, String packageName) {
      intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
    }

    static void disableSmartSelectionTextClassifier(TextView textView) {
      textView.setTextClassifier(TextClassifier.NO_OP);
    }

    static Bundle createLaunchDisplayIdActivityOptions(int displayId) {
      ActivityOptions options = ActivityOptions.makeBasic();
      options.setLaunchDisplayId(displayId);
      return options.toBundle();
    }
  }

  private static class ApisNMR1 {
    private ApisNMR1() {}

    static boolean isDemoUser() {
      UserManager userManager =
          (UserManager) ContextUtils.getApplicationContext().getSystemService("user");
      return userManager.isDemoUser();
    }
  }

  public static <T> T requireNonNull(T obj) {
    if (obj == null) {
      throw new NullPointerException();
    }
    return obj;
  }

  public static <T> T requireNonNull(T obj, String message) {
    if (obj == null) {
      throw new NullPointerException(message);
    }
    return obj;
  }

  public static byte[] getBytesUtf8(String str) {
    return str.getBytes(StandardCharsets.UTF_8);
  }

  public static Intent getNotificationSettingsIntent() {
    Intent intent = new Intent();
    String packageName = ContextUtils.getApplicationContext().getPackageName();
    ApisO.initNotificationSettingsIntent(intent, packageName);
    return intent;
  }

  public static Drawable getDrawable(Resources res, int id) throws Resources.NotFoundException {
    return getDrawableForDensity(res, id, 0);
  }

  public static Drawable getDrawableForDensity(Resources res, int id, int density) {
    StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
    try {
      if (density == 0) {
        return res.getDrawable(id, null);
      }
      return res.getDrawableForDensity(id, density, null);
    } finally {
      StrictMode.setThreadPolicy(oldPolicy);
    }
  }

  public static void setTextAppearance(TextView view, int id) {
    view.setTextAppearance(view.getContext(), id);
  }

  public static boolean isDemoUser() {
    return ApisNMR1.isDemoUser();
  }

  public static int checkPermission(Context context, String permission, int pid, int uid) {
    try {
      return context.checkPermission(permission, pid, uid);
    } catch (RuntimeException e) {
      return -1;
    }
  }

  public static boolean isInMultiWindowMode(Activity activity) {
    return activity.isInMultiWindowMode();
  }

  public static List<Integer> getTargetableDisplayIds(Activity activity) {
    if (Build.VERSION.SDK_INT >= 29) {
      return ApisQ.getTargetableDisplayIds(activity);
    }
    return new ArrayList();
  }

  public static void disableSmartSelectionTextClassifier(TextView textView) {
    ApisO.disableSmartSelectionTextClassifier(textView);
  }

  public static Bundle createLaunchDisplayIdActivityOptions(int displayId) {
    return ApisO.createLaunchDisplayIdActivityOptions(displayId);
  }

  public static void setActivityOptionsBackgroundActivityStartMode(ActivityOptions options) {
    if (Build.VERSION.SDK_INT < 34) {
      return;
    }
    options.setPendingIntentBackgroundActivityStartMode(1);
  }

  public static void clearHandwritingBoundsOffsetBottom(View view) {
    if (Build.VERSION.SDK_INT < 34) {
      return;
    }
    try {
      float offsetTop =
          ((Float)
                  View.class
                      .getMethod("getHandwritingBoundsOffsetTop", new Class[0])
                      .invoke(view, new Object[0]))
              .floatValue();
      float offsetLeft =
          ((Float)
                  View.class
                      .getMethod("getHandwritingBoundsOffsetLeft", new Class[0])
                      .invoke(view, new Object[0]))
              .floatValue();
      float offsetRight =
          ((Float)
                  View.class
                      .getMethod("getHandwritingBoundsOffsetRight", new Class[0])
                      .invoke(view, new Object[0]))
              .floatValue();
      Method setHandwritingBoundsOffsets =
          View.class.getMethod(
              "setHandwritingBoundsOffsets", Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
      setHandwritingBoundsOffsets.invoke(
          view, Float.valueOf(offsetLeft), Float.valueOf(offsetTop), Float.valueOf(offsetRight), 0);
    } catch (IllegalAccessException e) {
    } catch (NoSuchMethodException e2) {
    } catch (NullPointerException e3) {
    } catch (InvocationTargetException e4) {
    }
  }

  public static String getProcessName() {
    if (Build.VERSION.SDK_INT >= 28) {
      return ApisP.getProcessName();
    }
    try {
      Class<?> activityThreadClazz = Class.forName("android.app.ActivityThread");
      return (String)
          activityThreadClazz
              .getMethod("currentProcessName", new Class[0])
              .invoke(null, new Object[0]);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static boolean isRunningInUserTestHarness() {
    if (Build.VERSION.SDK_INT >= 29) {
      return ApisQ.isRunningInUserTestHarness();
    }
    return false;
  }

  public static Bitmap getBitmapByUri(ContentResolver cr, Uri uri) throws IOException {
    if (Build.VERSION.SDK_INT >= 28) {
      return ApisP.getBitmapByUri(cr, uri);
    }
    return MediaStore.Images.Media.getBitmap(cr, uri);
  }
}
