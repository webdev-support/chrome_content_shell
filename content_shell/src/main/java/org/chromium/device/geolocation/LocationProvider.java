package org.chromium.device.geolocation;

public interface LocationProvider {
  boolean isRunning();

  void start(boolean z);

  void stop();
}
