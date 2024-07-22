package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnsafeSharedMemoryRegion;

public interface CrashMemoryMetricsReporter extends Interface {
  public static final Interface.Manager<CrashMemoryMetricsReporter, Proxy> MANAGER =
      CrashMemoryMetricsReporter_Internal.MANAGER;

  public interface Proxy extends CrashMemoryMetricsReporter, Interface.Proxy {}

  void setSharedMemory(UnsafeSharedMemoryRegion unsafeSharedMemoryRegion);
}
