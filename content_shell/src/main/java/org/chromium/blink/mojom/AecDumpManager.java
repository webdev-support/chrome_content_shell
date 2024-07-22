package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AecDumpManager extends Interface {
  public static final Interface.Manager<AecDumpManager, Proxy> MANAGER =
      AecDumpManager_Internal.MANAGER;

  public interface Proxy extends AecDumpManager, Interface.Proxy {}

  void add(AecDumpAgent aecDumpAgent);
}
