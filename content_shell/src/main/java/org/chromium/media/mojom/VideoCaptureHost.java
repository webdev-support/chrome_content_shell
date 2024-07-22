package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface VideoCaptureHost extends Interface {
  public static final Interface.Manager<VideoCaptureHost, Proxy> MANAGER =
      VideoCaptureHost_Internal.MANAGER;

  public interface GetDeviceFormatsInUse_Response {
    void call(VideoCaptureFormat[] videoCaptureFormatArr);
  }

  public interface GetDeviceSupportedFormats_Response {
    void call(VideoCaptureFormat[] videoCaptureFormatArr);
  }

  public interface Proxy extends VideoCaptureHost, Interface.Proxy {}

  void getDeviceFormatsInUse(
      UnguessableToken unguessableToken,
      UnguessableToken unguessableToken2,
      GetDeviceFormatsInUse_Response getDeviceFormatsInUse_Response);

  void getDeviceSupportedFormats(
      UnguessableToken unguessableToken,
      UnguessableToken unguessableToken2,
      GetDeviceSupportedFormats_Response getDeviceSupportedFormats_Response);

  void onLog(UnguessableToken unguessableToken, String str);

  void pause(UnguessableToken unguessableToken);

  void releaseBuffer(
      UnguessableToken unguessableToken, int i, VideoCaptureFeedback videoCaptureFeedback);

  void requestRefreshFrame(UnguessableToken unguessableToken);

  void resume(
      UnguessableToken unguessableToken,
      UnguessableToken unguessableToken2,
      VideoCaptureParams videoCaptureParams);

  void start(
      UnguessableToken unguessableToken,
      UnguessableToken unguessableToken2,
      VideoCaptureParams videoCaptureParams,
      VideoCaptureObserver videoCaptureObserver);

  void stop(UnguessableToken unguessableToken);
}
