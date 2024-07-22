package org.chromium.media.stable.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CdmContextEventCallback extends Interface {
  public static final Interface.Manager<CdmContextEventCallback, Proxy> MANAGER =
      CdmContextEventCallback_Internal.MANAGER;

  public interface Proxy extends CdmContextEventCallback, Interface.Proxy {}

  void eventCallback(int i);
}
