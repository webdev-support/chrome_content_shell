package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AudioOutputStreamProvider extends Interface {
  public static final Interface.Manager<AudioOutputStreamProvider, Proxy> MANAGER =
      AudioOutputStreamProvider_Internal.MANAGER;

  public interface Proxy extends AudioOutputStreamProvider, Interface.Proxy {}

  void acquire(
      AudioParameters audioParameters,
      AudioOutputStreamProviderClient audioOutputStreamProviderClient);
}
