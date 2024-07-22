package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.FileInfo;
import org.chromium.mojo_base.mojom.FilePath;

public interface FileUtilitiesHost extends Interface {
  public static final Interface.Manager<FileUtilitiesHost, Proxy> MANAGER =
      FileUtilitiesHost_Internal.MANAGER;

  public interface GetFileInfo_Response {
    void call(FileInfo fileInfo);
  }

  public interface Proxy extends FileUtilitiesHost, Interface.Proxy {}

  void getFileInfo(FilePath filePath, GetFileInfo_Response getFileInfo_Response);
}
