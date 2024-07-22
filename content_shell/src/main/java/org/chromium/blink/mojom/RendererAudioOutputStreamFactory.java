package org.chromium.blink.mojom;

import org.chromium.media.mojom.AudioOutputStreamProvider;
import org.chromium.media.mojom.AudioParameters;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface RendererAudioOutputStreamFactory extends Interface {
  public static final Interface.Manager<RendererAudioOutputStreamFactory, Proxy> MANAGER =
      RendererAudioOutputStreamFactory_Internal.MANAGER;

  public interface Proxy extends RendererAudioOutputStreamFactory, Interface.Proxy {}

  public interface RequestDeviceAuthorization_Response {
    void call(int i, AudioParameters audioParameters, String str);
  }

  void requestDeviceAuthorization(
      InterfaceRequest<AudioOutputStreamProvider> interfaceRequest,
      UnguessableToken unguessableToken,
      String str,
      RequestDeviceAuthorization_Response requestDeviceAuthorization_Response);
}
