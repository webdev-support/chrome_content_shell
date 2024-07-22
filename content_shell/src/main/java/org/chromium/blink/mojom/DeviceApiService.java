package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DeviceApiService extends Interface {
  public static final Interface.Manager<DeviceApiService, Proxy> MANAGER =
      DeviceApiService_Internal.MANAGER;

  public interface GetAnnotatedAssetId_Response {
    void call(DeviceAttributeResult deviceAttributeResult);
  }

  public interface GetAnnotatedLocation_Response {
    void call(DeviceAttributeResult deviceAttributeResult);
  }

  public interface GetDirectoryId_Response {
    void call(DeviceAttributeResult deviceAttributeResult);
  }

  public interface GetHostname_Response {
    void call(DeviceAttributeResult deviceAttributeResult);
  }

  public interface GetSerialNumber_Response {
    void call(DeviceAttributeResult deviceAttributeResult);
  }

  public interface Proxy extends DeviceApiService, Interface.Proxy {}

  void getAnnotatedAssetId(GetAnnotatedAssetId_Response getAnnotatedAssetId_Response);

  void getAnnotatedLocation(GetAnnotatedLocation_Response getAnnotatedLocation_Response);

  void getDirectoryId(GetDirectoryId_Response getDirectoryId_Response);

  void getHostname(GetHostname_Response getHostname_Response);

  void getSerialNumber(GetSerialNumber_Response getSerialNumber_Response);
}
