package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface Sensor extends Interface {
  public static final Interface.Manager<Sensor, Proxy> MANAGER = Sensor_Internal.MANAGER;

  public interface AddConfiguration_Response {
    void call(boolean z);
  }

  public interface GetDefaultConfiguration_Response {
    void call(SensorConfiguration sensorConfiguration);
  }

  public interface Proxy extends Sensor, Interface.Proxy {}

  void addConfiguration(
      SensorConfiguration sensorConfiguration, AddConfiguration_Response addConfiguration_Response);

  void configureReadingChangeNotifications(boolean z);

  void getDefaultConfiguration(GetDefaultConfiguration_Response getDefaultConfiguration_Response);

  void removeConfiguration(SensorConfiguration sensorConfiguration);

  void resume();

  void suspend();
}
