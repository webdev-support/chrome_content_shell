package org.chromium.device.time_zone_monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
class TimeZoneMonitor {
  private static final String TAG = "TimeZoneMonitor";
  private final BroadcastReceiver mBroadcastReceiver;
  private final IntentFilter mFilter;
  private long mNativePtr;

  public interface Natives {
    void timeZoneChangedFromJava(long j, TimeZoneMonitor timeZoneMonitor);
  }

  private TimeZoneMonitor(long nativePtr) {
    IntentFilter intentFilter = new IntentFilter("android.intent.action.TIMEZONE_CHANGED");
    this.mFilter = intentFilter;
    BroadcastReceiver broadcastReceiver =
        new BroadcastReceiver() {
          @Override // android.content.BroadcastReceiver
          public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
              Log.e(TimeZoneMonitor.TAG, "unexpected intent");
            } else {
              TimeZoneMonitorJni.get()
                  .timeZoneChangedFromJava(TimeZoneMonitor.this.mNativePtr, TimeZoneMonitor.this);
            }
          }
        };
    this.mBroadcastReceiver = broadcastReceiver;
    this.mNativePtr = nativePtr;
    ContextUtils.registerProtectedBroadcastReceiver(
        ContextUtils.getApplicationContext(), broadcastReceiver, intentFilter);
  }

  static TimeZoneMonitor getInstance(long nativePtr) {
    return new TimeZoneMonitor(nativePtr);
  }

  void stop() {
    ContextUtils.getApplicationContext().unregisterReceiver(this.mBroadcastReceiver);
    this.mNativePtr = 0L;
  }
}
