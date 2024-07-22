package org.chromium.base;

import android.os.PowerManager;

public final class PowerMonitorForQ {
  private PowerMonitorForQ() {}

  public static void addThermalStatusListener(PowerManager powerManager) {
    powerManager.addThermalStatusListener(
        new PowerManager.OnThermalStatusChangedListener() {
          @Override
          public void onThermalStatusChanged(int status) {
            PowerMonitorJni.get().onThermalStatusChanged(status);
          }
        });
  }
}
