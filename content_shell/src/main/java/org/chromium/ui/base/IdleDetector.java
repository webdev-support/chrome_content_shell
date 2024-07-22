package org.chromium.ui.base;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
import org.chromium.base.ContextUtils;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class IdleDetector extends BroadcastReceiver {
  private static final String TAG = "IdleDetector";
  private boolean mIdle;
  private long mLast;

  private IdleDetector() {
    if (isScreenLocked()) {
      start();
    } else {
      reset();
    }
    IntentFilter filter = new IntentFilter();
    filter.addAction("android.intent.action.SCREEN_OFF");
    filter.addAction("android.intent.action.USER_PRESENT");
    ContextUtils.registerProtectedBroadcastReceiver(
        ContextUtils.getApplicationContext(), this, filter);
  }

  private static IdleDetector create() {
    return new IdleDetector();
  }

  @Override // android.content.BroadcastReceiver
  public void onReceive(Context context, Intent intent) {
    if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
      start();
    } else if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
      reset();
    }
  }

  private long now() {
    return SystemClock.elapsedRealtime();
  }

  private void start() {
    this.mIdle = true;
    this.mLast = now();
  }

  private void reset() {
    this.mIdle = false;
    this.mLast = 0L;
  }

  private long getIdleTime() {
    if (this.mIdle) {
      return TimeUnit.MILLISECONDS.toSeconds(now() - this.mLast);
    }
    return 0L;
  }

  private boolean isScreenLocked() {
    Context context = ContextUtils.getApplicationContext();
    KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
    if (keyguardManager.inKeyguardRestrictedInputMode()) {
      return true;
    }
    PowerManager powerManager = (PowerManager) context.getSystemService("power");
    if (powerManager == null) {
      return false;
    }
    return true ^ powerManager.isInteractive();
  }
}
