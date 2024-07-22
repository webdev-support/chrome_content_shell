package org.chromium.media.mojom;

import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface VideoDecoder extends Interface {
  public static final Interface.Manager<VideoDecoder, Proxy> MANAGER =
      VideoDecoder_Internal.MANAGER;

  public interface Decode_Response {
    void call(DecoderStatus decoderStatus);
  }

  public interface GetSupportedConfigs_Response {
    void call(SupportedVideoDecoderConfig[] supportedVideoDecoderConfigArr, int i);
  }

  public interface Initialize_Response {
    void call(DecoderStatus decoderStatus, boolean z, int i, int i2);
  }

  public interface Proxy extends VideoDecoder, Interface.Proxy {}

  public interface Reset_Response {
    void call();
  }

  void construct(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      MediaLog mediaLog,
      InterfaceRequest<VideoFrameHandleReleaser> interfaceRequest,
      DataPipe.ConsumerHandle consumerHandle,
      CommandBufferId commandBufferId,
      ColorSpace colorSpace);

  void decode(DecoderBuffer decoderBuffer, Decode_Response decode_Response);

  void getSupportedConfigs(GetSupportedConfigs_Response getSupportedConfigs_Response);

  void initialize(
      VideoDecoderConfig videoDecoderConfig,
      boolean z,
      UnguessableToken unguessableToken,
      Initialize_Response initialize_Response);

  void onOverlayInfoChanged(OverlayInfo overlayInfo);

  void reset(Reset_Response reset_Response);
}
