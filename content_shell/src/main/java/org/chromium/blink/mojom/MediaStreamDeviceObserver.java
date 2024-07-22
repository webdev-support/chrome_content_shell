package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface MediaStreamDeviceObserver extends Interface {
  public static final Interface.Manager<MediaStreamDeviceObserver, Proxy> MANAGER =
      MediaStreamDeviceObserver_Internal.MANAGER;

  public interface Proxy extends MediaStreamDeviceObserver, Interface.Proxy {}

  void onDeviceCaptureConfigurationChange(String str, MediaStreamDevice mediaStreamDevice);

  void onDeviceCaptureHandleChange(String str, MediaStreamDevice mediaStreamDevice);

  void onDeviceChanged(
      String str, MediaStreamDevice mediaStreamDevice, MediaStreamDevice mediaStreamDevice2);

  void onDeviceRequestStateChange(String str, MediaStreamDevice mediaStreamDevice, int i);

  void onDeviceStopped(String str, MediaStreamDevice mediaStreamDevice);

  void onZoomLevelChange(String str, MediaStreamDevice mediaStreamDevice, int i);
}
