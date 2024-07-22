package org.chromium.blink.test.mojom;

import org.chromium.device.mojom.GetVirtualSensorInformationResult;
import org.chromium.device.mojom.SensorReadingRaw;
import org.chromium.device.mojom.VirtualSensorMetadata;
import org.chromium.mojo.bindings.Interface;

public interface WebSensorProviderAutomation extends Interface {
  public static final Interface.Manager<WebSensorProviderAutomation, Proxy> MANAGER =
      WebSensorProviderAutomation_Internal.MANAGER;

  public interface CreateVirtualSensor_Response {
    void call(int i);
  }

  public interface GetVirtualSensorInformation_Response {
    void call(GetVirtualSensorInformationResult getVirtualSensorInformationResult);
  }

  public interface Proxy extends WebSensorProviderAutomation, Interface.Proxy {}

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

  void getVirtualSensorInformation(
      int i, GetVirtualSensorInformation_Response getVirtualSensorInformation_Response);

  void removeVirtualSensor(int i, RemoveVirtualSensor_Response removeVirtualSensor_Response);

  void updateVirtualSensor(
      int i,
      SensorReadingRaw sensorReadingRaw,
      UpdateVirtualSensor_Response updateVirtualSensor_Response);
}
