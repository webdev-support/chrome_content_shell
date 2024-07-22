package org.chromium.base.compat;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.PictureInPictureParams;
import android.app.Service;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.view.Display;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextLinks;
import android.view.textclassifier.TextSelection;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;

public final class ApiHelperForS {
  private static final String TAG = "ApiHelperForS";

  private ApiHelperForS() {}

  public static boolean isStyleText(ClipDescription clipDescription) {
    return clipDescription.isStyledText();
  }

  public static float getConfidenceScore(ClipDescription clipDescription, String entityType) {
    return clipDescription.getConfidenceScore(entityType);
  }

  public static boolean isGetClassificationStatusIsComplete(ClipDescription clipDescription) {
    return clipDescription.getClassificationStatus() == 3;
  }

  public static TextLinks getTextLinks(ClipData.Item item) {
    return item.getTextLinks();
  }

  public static boolean hasBluetoothConnectPermission() {
    return ApiCompatibilityUtils.checkPermission(
            ContextUtils.getApplicationContext(),
            "android.permission.BLUETOOTH_CONNECT",
            Process.myPid(),
            Process.myUid())
        == 0;
  }

  public static void setAutoEnterEnabled(PictureInPictureParams.Builder builder, boolean enabled) {
    builder.setAutoEnterEnabled(enabled);
  }

  public static TextSelection.Request.Builder setIncludeTextClassification(
      TextSelection.Request.Builder builder, boolean includeTextClassification) {
    return builder.setIncludeTextClassification(includeTextClassification);
  }

  public static TextClassification getTextClassification(TextSelection textSelection) {
    return textSelection.getTextClassification();
  }

  public static Context createWindowContext(
      Context context, Display display, int type, Bundle options) {
    return context.createWindowContext(display, type, options);
  }

  public static int getPendingIntentMutableFlag() {
    return 33554432;
  }

  public static void startForeground(
      Service service, int id, Notification notification, int foregroundServiceType) {
    try {
      service.startForeground(id, notification, foregroundServiceType);
    } catch (ForegroundServiceStartNotAllowedException e) {
      Log.e(
          TAG,
          "Cannot run service as foreground: "
              + e
              + " for notification channel "
              + notification.getChannelId()
              + " notification id "
              + id);
    }
  }
}
