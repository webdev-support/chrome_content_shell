package org.chromium.media.stable.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface StableVideoDecoderFactory extends Interface {
  public static final Interface.Manager<StableVideoDecoderFactory, Proxy> MANAGER =
      StableVideoDecoderFactory_Internal.MANAGER;

  public interface Proxy extends StableVideoDecoderFactory, Interface.Proxy {}

  void createStableVideoDecoder(
      InterfaceRequest<StableVideoDecoder> interfaceRequest,
      StableVideoDecoderTracker stableVideoDecoderTracker);
}
