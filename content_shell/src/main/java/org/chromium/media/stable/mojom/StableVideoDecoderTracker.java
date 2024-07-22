package org.chromium.media.stable.mojom;

import org.chromium.mojo.bindings.Interface;

public interface StableVideoDecoderTracker extends Interface {
  public static final Interface.Manager<StableVideoDecoderTracker, Proxy> MANAGER =
      StableVideoDecoderTracker_Internal.MANAGER;

  public interface Proxy extends StableVideoDecoderTracker, Interface.Proxy {}
}
