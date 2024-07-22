package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface FileSystemAccessObserverHost extends Interface {
  public static final Interface.Manager<FileSystemAccessObserverHost, Proxy> MANAGER =
      FileSystemAccessObserverHost_Internal.MANAGER;

  public interface Observe_Response {
    void call(
        FileSystemAccessError fileSystemAccessError,
        InterfaceRequest<FileSystemAccessObserver> interfaceRequest);
  }

  public interface Proxy extends FileSystemAccessObserverHost, Interface.Proxy {}

  void observe(
      FileSystemAccessTransferToken fileSystemAccessTransferToken,
      boolean z,
      Observe_Response observe_Response);

  void unobserve(FileSystemAccessTransferToken fileSystemAccessTransferToken);
}
