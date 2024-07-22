package org.chromium.blink.mojom;

import org.chromium.device.mojom.SensorInitParams;
import org.chromium.mojo.bindings.Interface;

public interface WebSensorProvider extends Interface {
  public static final Interface.Manager<WebSensorProvider, Proxy> MANAGER =
      WebSensorProvider_Internal.MANAGER;

  public interface GetSensor_Response {
    void call(int i, SensorInitParams sensorInitParams);
  }

  public interface Proxy extends WebSensorProvider, Interface.Proxy {}

  void getSensor(int i, GetSensor_Response getSensor_Response);
}
