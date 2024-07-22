package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DiskAllocator extends Interface {
  public static final Interface.Manager<DiskAllocator, Proxy> MANAGER =
      DiskAllocator_Internal.MANAGER;

  public interface Proxy extends DiskAllocator, Interface.Proxy {}

  void provideTemporaryFile(org.chromium.mojo_base.mojom.File file);
}
