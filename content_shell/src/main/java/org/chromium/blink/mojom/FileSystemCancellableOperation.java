package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FileSystemCancellableOperation extends Interface {
  public static final Interface.Manager<FileSystemCancellableOperation, Proxy> MANAGER =
      FileSystemCancellableOperation_Internal.MANAGER;

  public interface Cancel_Response {
    void call(int i);
  }

  public interface Proxy extends FileSystemCancellableOperation, Interface.Proxy {}

  void cancel(Cancel_Response cancel_Response);
}
