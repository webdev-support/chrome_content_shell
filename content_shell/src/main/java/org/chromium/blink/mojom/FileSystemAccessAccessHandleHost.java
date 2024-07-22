package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FileSystemAccessAccessHandleHost extends Interface {
  public static final Interface.Manager<FileSystemAccessAccessHandleHost, Proxy> MANAGER =
      FileSystemAccessAccessHandleHost_Internal.MANAGER;

  public interface Close_Response {
    void call();
  }

  public interface Proxy extends FileSystemAccessAccessHandleHost, Interface.Proxy {}

  void close(Close_Response close_Response);
}
