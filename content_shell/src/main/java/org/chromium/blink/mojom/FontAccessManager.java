package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

public interface FontAccessManager extends Interface {
  public static final Interface.Manager<FontAccessManager, Proxy> MANAGER =
      FontAccessManager_Internal.MANAGER;

  public interface EnumerateLocalFonts_Response {
    void call(int i, ReadOnlySharedMemoryRegion readOnlySharedMemoryRegion);
  }

  public interface Proxy extends FontAccessManager, Interface.Proxy {}

  void enumerateLocalFonts(EnumerateLocalFonts_Response enumerateLocalFonts_Response);
}
