package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AudioDecoderClient extends Interface {
  public static final Manager<AudioDecoderClient, Proxy> MANAGER =
      AudioDecoderClient_Internal.MANAGER;

  public interface Proxy extends AudioDecoderClient, Interface.Proxy {}

  void onBufferDecoded(AudioBuffer audioBuffer);

  void onWaiting(int i);
}
