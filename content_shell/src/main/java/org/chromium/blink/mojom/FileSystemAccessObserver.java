package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FileSystemAccessObserver extends Interface {
  public static final Interface.Manager<FileSystemAccessObserver, Proxy> MANAGER =
      FileSystemAccessObserver_Internal.MANAGER;

  public interface Proxy extends FileSystemAccessObserver, Interface.Proxy {}

  void onFileChanges(FileSystemAccessChange[] fileSystemAccessChangeArr);
}
