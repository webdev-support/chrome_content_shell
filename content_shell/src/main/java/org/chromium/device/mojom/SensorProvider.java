package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SensorProvider extends Interface {
  public static final Interface.Manager<SensorProvider, Proxy> MANAGER =
      SensorProvider_Internal.MANAGER;

  public interface CreateVirtualSensor_Response {
    void call(int i);
  }

  public interface GetSensor_Response {
    void call(int i, SensorInitParams sensorInitParams);
  }

  public interface GetVirtualSensorInformation_Response {
    void call(GetVirtualSensorInformationResult getVirtualSensorInformationResult);
  }

  public interface Proxy extends SensorProvider, Interface.Proxy {}

  public interface RemoveVirtualSensor_Response {
    void call();
  }

  public interface UpdateVirtualSensor_Response {
    void call(int i);
  }

  void createVirtualSensor(
      int i,
      VirtualSensorMetadata virtualSensorMetadata,
      CreateVirtualSensor_Response createVirtualSensor_Response);

  void getSensor(int i, GetSensor_Response getSensor_Response);

  void getVirtualSensorInformation(
      int i, GetVirtualSensorInformation_Response getVirtualSensorInformation_Response);

  void removeVirtualSensor(int i, RemoveVirtualSensor_Response removeVirtualSensor_Response);

  void updateVirtualSensor(
      int i,
      SensorReadingRaw sensorReadingRaw,
      UpdateVirtualSensor_Response updateVirtualSensor_Response);
}
