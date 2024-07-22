package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AudioEncoderClient extends Interface {
  public static final Interface.Manager<AudioEncoderClient, Proxy> MANAGER =
      AudioEncoderClient_Internal.MANAGER;

  public interface Proxy extends AudioEncoderClient, Interface.Proxy {}

  void onEncodedBufferReady(EncodedAudioBuffer encodedAudioBuffer, byte[] bArr);
}
