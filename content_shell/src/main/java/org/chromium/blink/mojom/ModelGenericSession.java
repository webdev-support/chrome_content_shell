package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ModelGenericSession extends Interface {
  public static final Interface.Manager<ModelGenericSession, Proxy> MANAGER =
      ModelGenericSession_Internal.MANAGER;

  public interface Proxy extends ModelGenericSession, Interface.Proxy {}

  void execute(String str, ModelStreamingResponder modelStreamingResponder);
}
