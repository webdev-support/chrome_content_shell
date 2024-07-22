package org.chromium.media.mojom;

import org.chromium.media.stable.mojom.StableVideoDecoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface InterfaceFactory extends Interface {
  public static final Interface.Manager<InterfaceFactory, Proxy> MANAGER =
      InterfaceFactory_Internal.MANAGER;

  public interface CreateCdm_Response {
    void call(ContentDecryptionModule contentDecryptionModule, CdmContext cdmContext, String str);
  }

  public interface Proxy extends InterfaceFactory, Interface.Proxy {}

  void createAudioDecoder(InterfaceRequest<AudioDecoder> interfaceRequest);

  void createAudioEncoder(InterfaceRequest<AudioEncoder> interfaceRequest);

  void createCdm(CdmConfig cdmConfig, CreateCdm_Response createCdm_Response);

  void createDefaultRenderer(String str, InterfaceRequest<Renderer> interfaceRequest);

  void createFlingingRenderer(
      String str,
      FlingingRendererClientExtension flingingRendererClientExtension,
      InterfaceRequest<Renderer> interfaceRequest);

  void createMediaPlayerRenderer(
      MediaPlayerRendererClientExtension mediaPlayerRendererClientExtension,
      InterfaceRequest<Renderer> interfaceRequest,
      InterfaceRequest<MediaPlayerRendererExtension> interfaceRequest2);

  void createVideoDecoder(
      InterfaceRequest<VideoDecoder> interfaceRequest, StableVideoDecoder stableVideoDecoder);
}
