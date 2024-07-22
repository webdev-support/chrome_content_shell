package org.chromium.blink.mojom;

import org.chromium.media.mojom.VideoCaptureFormat;
import org.chromium.mojo.bindings.Interface;

public interface MediaDevicesDispatcherHost extends Interface {
  public static final Interface.Manager<MediaDevicesDispatcherHost, Proxy> MANAGER =
      MediaDevicesDispatcherHost_Internal.MANAGER;

  public interface EnumerateDevices_Response {
    void call(
        MediaDeviceInfo[][] mediaDeviceInfoArr,
        VideoInputDeviceCapabilities[] videoInputDeviceCapabilitiesArr,
        AudioInputDeviceCapabilities[] audioInputDeviceCapabilitiesArr);
  }

  public interface GetAllVideoInputDeviceFormats_Response {
    void call(VideoCaptureFormat[] videoCaptureFormatArr);
  }

  public interface GetAudioInputCapabilities_Response {
    void call(AudioInputDeviceCapabilities[] audioInputDeviceCapabilitiesArr);
  }

  public interface GetAvailableVideoInputDeviceFormats_Response {
    void call(VideoCaptureFormat[] videoCaptureFormatArr);
  }

  public interface GetVideoInputCapabilities_Response {
    void call(VideoInputDeviceCapabilities[] videoInputDeviceCapabilitiesArr);
  }

  public interface Proxy extends MediaDevicesDispatcherHost, Interface.Proxy {}

  void addMediaDevicesListener(
      boolean z, boolean z2, boolean z3, MediaDevicesListener mediaDevicesListener);

  void enumerateDevices(
      boolean z,
      boolean z2,
      boolean z3,
      boolean z4,
      boolean z5,
      EnumerateDevices_Response enumerateDevices_Response);

  void getAllVideoInputDeviceFormats(
      String str, GetAllVideoInputDeviceFormats_Response getAllVideoInputDeviceFormats_Response);

  void getAudioInputCapabilities(
      GetAudioInputCapabilities_Response getAudioInputCapabilities_Response);

  void getAvailableVideoInputDeviceFormats(
      String str,
      GetAvailableVideoInputDeviceFormats_Response getAvailableVideoInputDeviceFormats_Response);

  void getVideoInputCapabilities(
      GetVideoInputCapabilities_Response getVideoInputCapabilities_Response);

  void setCaptureHandleConfig(CaptureHandleConfig captureHandleConfig);
}
