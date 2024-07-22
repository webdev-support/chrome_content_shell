package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AecDumpAgent extends Interface {
  public static final Interface.Manager<AecDumpAgent, Proxy> MANAGER =
      AecDumpAgent_Internal.MANAGER;

  public interface Proxy extends AecDumpAgent, Interface.Proxy {}

  void start(org.chromium.mojo_base.mojom.File file);

  void stop();
}
