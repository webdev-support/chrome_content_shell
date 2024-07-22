package org.chromium.content.app;

import android.os.Process;
import org.chromium.base.BuildInfo;

class KillChildUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
  private boolean mCrashing;

  KillChildUncaughtExceptionHandler() {}

  public static void maybeInstallHandler() {
    if (BuildInfo.isDebugAndroid()) {
      return;
    }
    Thread.setDefaultUncaughtExceptionHandler(new KillChildUncaughtExceptionHandler());
  }

  @Override   public void uncaughtException(Thread t, Throwable e) {
    if (this.mCrashing) {
      return;
    }
    this.mCrashing = true;
    Process.killProcess(Process.myPid());
    System.exit(10);
  }
}
