package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ModelStreamingResponder extends Interface {
  public static final Interface.Manager<ModelStreamingResponder, Proxy> MANAGER =
      ModelStreamingResponder_Internal.MANAGER;

  public interface Proxy extends ModelStreamingResponder, Interface.Proxy {}

  void onResponse(int i, String str);
}
