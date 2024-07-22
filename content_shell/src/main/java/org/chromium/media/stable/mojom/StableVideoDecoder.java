package org.chromium.media.stable.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

public interface StableVideoDecoder extends Interface {
  public static final Interface.Manager<StableVideoDecoder, Proxy> MANAGER =
      StableVideoDecoder_Internal.MANAGER;

  public interface Decode_Response {
    void call(Status status);
  }

  public interface GetSupportedConfigs_Response {
    void call(SupportedVideoDecoderConfig[] supportedVideoDecoderConfigArr, int i);
  }

  public interface Initialize_Response {
    void call(Status status, boolean z, int i, int i2, boolean z2);
  }

  public interface Proxy extends StableVideoDecoder, Interface.Proxy {}

  public interface Reset_Response {
    void call();
  }

  void construct(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      MediaLog mediaLog,
      InterfaceRequest<VideoFrameHandleReleaser> interfaceRequest,
      DataPipe.ConsumerHandle consumerHandle,
      ColorSpace colorSpace);

  void decode(DecoderBuffer decoderBuffer, Decode_Response decode_Response);

  void getSupportedConfigs(GetSupportedConfigs_Response getSupportedConfigs_Response);

  void initialize(
      VideoDecoderConfig videoDecoderConfig,
      boolean z,
      StableCdmContext stableCdmContext,
      Initialize_Response initialize_Response);

  void reset(Reset_Response reset_Response);
}
