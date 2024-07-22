package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FileSystemAccessCapacityAllocationHost extends Interface {
  public static final Interface.Manager<FileSystemAccessCapacityAllocationHost, Proxy> MANAGER =
      FileSystemAccessCapacityAllocationHost_Internal.MANAGER;

  public interface Proxy extends FileSystemAccessCapacityAllocationHost, Interface.Proxy {}

  public interface RequestCapacityChange_Response {
    void call(long j);
  }

  void onContentsModified();

  void requestCapacityChange(long j, RequestCapacityChange_Response requestCapacityChange_Response);
}
