package org.chromium.device.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.task.AsyncTask;
import org.chromium.device.mojom.BatteryStatus;

public class BatteryStatusManager {
  private static final String TAG = "BatteryStatusManager";
  private AndroidBatteryManagerWrapper mAndroidBatteryManager;
  private final BatteryStatusCallback mCallback;
  private boolean mEnabled;
  private final IntentFilter mFilter;
  private final BroadcastReceiver mReceiver;

  public interface BatteryStatusCallback {
    void onBatteryStatusChanged(BatteryStatus batteryStatus);
  }

  public static class AndroidBatteryManagerWrapper {
    private final BatteryManager mBatteryManager;

    protected AndroidBatteryManagerWrapper(BatteryManager batteryManager) {
      this.mBatteryManager = batteryManager;
    }

    public int getIntProperty(int id) {
      return this.mBatteryManager.getIntProperty(id);
    }
  }

  private BatteryStatusManager(
      BatteryStatusCallback callback, AndroidBatteryManagerWrapper batteryManager) {
    this.mFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    this.mReceiver =
        new BroadcastReceiver() {
          @Override // android.content.BroadcastReceiver
          public void onReceive(Context context, Intent intent) {
            BatteryStatusManager.this.onReceive(intent);
          }
        };
    this.mCallback = callback;
    this.mAndroidBatteryManager = batteryManager;
  }

  public BatteryStatusManager(BatteryStatusCallback callback) {
    this(
        callback,
        new AndroidBatteryManagerWrapper(
            (BatteryManager)
                ContextUtils.getApplicationContext().getSystemService("batterymanager")));
  }

  static BatteryStatusManager createBatteryStatusManagerForTesting(
      BatteryStatusCallback callback, AndroidBatteryManagerWrapper batteryManager) {
    return new BatteryStatusManager(callback, batteryManager);
  }

  public boolean start() {
    if (!this.mEnabled
        && ContextUtils.registerProtectedBroadcastReceiver(
                ContextUtils.getApplicationContext(), this.mReceiver, this.mFilter)
            != null) {
      this.mEnabled = true;
    }
    return this.mEnabled;
  }

  public void stop() {
    if (this.mEnabled) {
      ContextUtils.getApplicationContext().unregisterReceiver(this.mReceiver);
      this.mEnabled = false;
    }
  }

  void onReceive(Intent intent) {
    if (!intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
      Log.e(TAG, "Unexpected intent.");
      return;
    }
    boolean present = intent.getBooleanExtra("present", false);
    int pluggedStatus = intent.getIntExtra("plugged", -1);
    if (present && pluggedStatus != -1) {
      int current = intent.getIntExtra("level", -1);
      int max = intent.getIntExtra("scale", -1);
      double level = current / max;
      double chargingTimeSeconds = 0.0d;
      level = (level < 0.0d || level > 1.0d) ? 1.0d : 1.0d;
      boolean charging = pluggedStatus != 0;
      int status = intent.getIntExtra("status", -1);
      boolean batteryFull = status == 5;
      chargingTimeSeconds =
          (charging && batteryFull) ? Double.POSITIVE_INFINITY : Double.POSITIVE_INFINITY;
      final BatteryStatus batteryStatus = new BatteryStatus();
      batteryStatus.charging = charging;
      batteryStatus.chargingTime = chargingTimeSeconds;
      batteryStatus.dischargingTime = Double.POSITIVE_INFINITY;
      batteryStatus.level = level;
      if (this.mAndroidBatteryManager == null) {
        this.mCallback.onBatteryStatusChanged(batteryStatus);
        return;
      } else {
        new AsyncTask<BatteryStatus>() {
          @Override
          public BatteryStatus doInBackground() {
            BatteryStatusManager.this.updateBatteryStatus(batteryStatus);
            return batteryStatus;
          }

          @Override
          public void onPostExecute(BatteryStatus batteryStatus2) {
            BatteryStatusManager.this.mCallback.onBatteryStatusChanged(batteryStatus2);
          }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        return;
      }
    }
    this.mCallback.onBatteryStatusChanged(new BatteryStatus());
  }

  public void updateBatteryStatus(BatteryStatus batteryStatus) {
    double remainingCapacityRatio = this.mAndroidBatteryManager.getIntProperty(4) / 100.0d;
    double batteryCapacityMicroAh = this.mAndroidBatteryManager.getIntProperty(1);
    double averageCurrentMicroA = this.mAndroidBatteryManager.getIntProperty(3);
    if (batteryStatus.charging) {
      if (batteryStatus.chargingTime == Double.POSITIVE_INFINITY && averageCurrentMicroA > 0.0d) {
        double chargeFromEmptyHours = batteryCapacityMicroAh / averageCurrentMicroA;
        batteryStatus.chargingTime =
            Math.ceil((1.0d - remainingCapacityRatio) * chargeFromEmptyHours * 3600.0d);
      }
    } else if (averageCurrentMicroA < 0.0d) {
      double dischargeFromFullHours = batteryCapacityMicroAh / (-averageCurrentMicroA);
      batteryStatus.dischargingTime =
          Math.floor(remainingCapacityRatio * dischargeFromFullHours * 3600.0d);
    }
  }
}
