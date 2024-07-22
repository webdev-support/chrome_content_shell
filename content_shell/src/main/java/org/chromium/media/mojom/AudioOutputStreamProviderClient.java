package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AudioOutputStreamProviderClient extends Interface {
  public static final Interface.Manager<AudioOutputStreamProviderClient, Proxy> MANAGER =
      AudioOutputStreamProviderClient_Internal.MANAGER;

  public interface Proxy extends AudioOutputStreamProviderClient, Interface.Proxy {}

  void created(AudioOutputStream audioOutputStream, ReadWriteAudioDataPipe readWriteAudioDataPipe);
}
