package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface MediaStreamDispatcherHost extends Interface {
  public static final Interface.Manager<MediaStreamDispatcherHost, Proxy> MANAGER =
      MediaStreamDispatcherHost_Internal.MANAGER;

  public interface GenerateStreams_Response {
    void call(int i, String str, StreamDevicesSet streamDevicesSet, boolean z);
  }

  public interface GetOpenDevice_Response {
    void call(int i, GetOpenDeviceResponse getOpenDeviceResponse);
  }

  public interface KeepDeviceAliveForTransfer_Response {
    void call(boolean z);
  }

  public interface OpenDevice_Response {
    void call(boolean z, String str, MediaStreamDevice mediaStreamDevice);
  }

  public interface Proxy extends MediaStreamDispatcherHost, Interface.Proxy {}

  void cancelRequest(int i);

  void closeDevice(String str);

  void generateStreams(
      int i,
      StreamControls streamControls,
      boolean z,
      StreamSelectionInfo streamSelectionInfo,
      GenerateStreams_Response generateStreams_Response);

  void getOpenDevice(
      int i,
      UnguessableToken unguessableToken,
      UnguessableToken unguessableToken2,
      GetOpenDevice_Response getOpenDevice_Response);

  void keepDeviceAliveForTransfer(
      UnguessableToken unguessableToken,
      UnguessableToken unguessableToken2,
      KeepDeviceAliveForTransfer_Response keepDeviceAliveForTransfer_Response);

  void onStreamStarted(String str);

  void openDevice(int i, String str, int i2, OpenDevice_Response openDevice_Response);

  void setCapturingLinkSecured(UnguessableToken unguessableToken, int i, boolean z);

  void stopStreamDevice(String str, UnguessableToken unguessableToken);
}
