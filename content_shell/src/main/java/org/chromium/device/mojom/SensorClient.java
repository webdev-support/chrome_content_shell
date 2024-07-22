package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SensorClient extends Interface {
  public static final Interface.Manager<SensorClient, Proxy> MANAGER =
      SensorClient_Internal.MANAGER;

  public interface Proxy extends SensorClient, Interface.Proxy {}

  void raiseError();

  void sensorReadingChanged();
}
