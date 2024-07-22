package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FileSystemAccessDirectoryEntriesListener extends Interface {
  public static final Interface.Manager<FileSystemAccessDirectoryEntriesListener, Proxy> MANAGER =
      FileSystemAccessDirectoryEntriesListener_Internal.MANAGER;

  public interface Proxy extends FileSystemAccessDirectoryEntriesListener, Interface.Proxy {}

  void didReadDirectory(
      FileSystemAccessError fileSystemAccessError,
      FileSystemAccessEntry[] fileSystemAccessEntryArr,
      boolean z);
}
