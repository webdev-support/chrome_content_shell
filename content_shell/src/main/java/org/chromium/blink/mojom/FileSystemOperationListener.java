package org.chromium.blink.mojom;

import org.chromium.filesystem.mojom.DirectoryEntry;
import org.chromium.mojo.bindings.Interface;

public interface FileSystemOperationListener extends Interface {
  public static final Interface.Manager<FileSystemOperationListener, Proxy> MANAGER =
      FileSystemOperationListener_Internal.MANAGER;

  public interface Proxy extends FileSystemOperationListener, Interface.Proxy {}

  void didWrite(long j, boolean z);

  void errorOccurred(int i);

  void resultsRetrieved(DirectoryEntry[] directoryEntryArr, boolean z);
}
