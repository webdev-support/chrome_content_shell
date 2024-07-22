package org.chromium.components.crash.browser;

import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;

public class ChildProcessCrashObserver {

  private static final String TAG = "ChildCrashObserver";
  private static ChildCrashedCallback sCallback;

  public interface ChildCrashedCallback {
    void childCrashed(int i);
  }

  public static void registerCrashCallback(ChildCrashedCallback callback) {
    ThreadUtils.assertOnUiThread();
    if (sCallback != null) {
      throw new AssertionError();
    }
    sCallback = callback;
  }

  public static void childCrashed(int pid) {
    ChildCrashedCallback childCrashedCallback = sCallback;
    if (childCrashedCallback == null) {
      Log.w(TAG, "Ignoring crash observed before a callback was registered...");
    } else {
      childCrashedCallback.childCrashed(pid);
    }
  }
}
