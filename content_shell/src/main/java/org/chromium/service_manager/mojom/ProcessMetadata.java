package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ProcessId;

public interface ProcessMetadata extends Interface {
  public static final Interface.Manager<ProcessMetadata, Proxy> MANAGER =
      ProcessMetadata_Internal.MANAGER;

  public interface Proxy extends ProcessMetadata, Interface.Proxy {}

  void setPid(ProcessId processId);
}
