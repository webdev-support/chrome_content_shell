package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface VideoEncodeAcceleratorProvider extends Interface {
  public static final Interface.Manager<VideoEncodeAcceleratorProvider, Proxy> MANAGER =
      VideoEncodeAcceleratorProvider_Internal.MANAGER;

  public interface GetVideoEncodeAcceleratorSupportedProfiles_Response {
    void call(VideoEncodeAcceleratorSupportedProfile[] videoEncodeAcceleratorSupportedProfileArr);
  }

  public interface Proxy extends VideoEncodeAcceleratorProvider, Interface.Proxy {}

  void createVideoEncodeAccelerator(InterfaceRequest<VideoEncodeAccelerator> interfaceRequest);

  void getVideoEncodeAcceleratorSupportedProfiles(
      GetVideoEncodeAcceleratorSupportedProfiles_Response
          getVideoEncodeAcceleratorSupportedProfiles_Response);
}
