package org.chromium.base;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.TransactionTooLargeException;
import java.util.Collections;
import java.util.List;
import org.chromium.content_public.common.ContentUrlConstants;

public class PackageManagerUtils {
  public static final Intent BROWSER_INTENT =
      new Intent()
          .setAction("android.intent.action.VIEW")
          .addCategory("android.intent.category.BROWSABLE")
          .setData(Uri.fromParts(ContentUrlConstants.HTTP_SCHEME, "", null));
  private static final String TAG = "PackageManagerUtils";

  public static ResolveInfo resolveActivity(Intent intent, int flags) {
    try {
      StrictModeContext ignored = StrictModeContext.allowDiskWrites();
      PackageManager pm = ContextUtils.getApplicationContext().getPackageManager();
      ResolveInfo resolveActivity = pm.resolveActivity(intent, flags);
      if (ignored != null) {
        ignored.close();
      }
      return resolveActivity;
    } catch (RuntimeException e) {
      handleExpectedExceptionsOrRethrow(e, intent);
      return null;
    }
  }

  public static List<ResolveInfo> queryIntentActivities(Intent intent, int flags) {
    try {
      StrictModeContext ignored = StrictModeContext.allowDiskReads();
      PackageManager pm = ContextUtils.getApplicationContext().getPackageManager();
      List<ResolveInfo> queryIntentActivities = pm.queryIntentActivities(intent, flags);
      if (ignored != null) {
        ignored.close();
      }
      return queryIntentActivities;
    } catch (RuntimeException e) {
      handleExpectedExceptionsOrRethrow(e, intent);
      return Collections.emptyList();
    }
  }

  public static boolean canResolveActivity(Intent intent, int flags) {
    return !queryIntentActivities(intent, flags).isEmpty();
  }

  public static boolean canResolveActivity(Intent intent) {
    return canResolveActivity(intent, 0);
  }

  public static Intent getQueryInstalledHomeLaunchersIntent() {
    return new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
  }

  public static ResolveInfo resolveDefaultWebBrowserActivity() {
    return resolveActivity(BROWSER_INTENT, 65536);
  }

  public static List<ResolveInfo> queryAllWebBrowsersInfo() {
    return queryIntentActivities(BROWSER_INTENT, 983040);
  }

  public static List<ResolveInfo> queryAllLaunchersInfo() {
    return queryIntentActivities(getQueryInstalledHomeLaunchersIntent(), 131072);
  }

  private static void handleExpectedExceptionsOrRethrow(RuntimeException e, Intent intent) {
    if ((e instanceof NullPointerException)
        || (e.getCause() instanceof TransactionTooLargeException)) {
      Log.e(TAG, "Could not resolve Activity for intent " + intent.toString(), (Throwable) e);
      return;
    }
    throw e;
  }
}
