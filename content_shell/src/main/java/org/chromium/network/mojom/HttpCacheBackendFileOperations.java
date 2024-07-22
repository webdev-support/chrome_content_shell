package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.FileInfo;
import org.chromium.mojo_base.mojom.FilePath;

public interface HttpCacheBackendFileOperations extends Interface {
  public static final Interface.Manager<HttpCacheBackendFileOperations, Proxy> MANAGER =
      HttpCacheBackendFileOperations_Internal.MANAGER;

  public interface CleanupDirectory_Response {
    void call(boolean z);
  }

  public interface CreateDirectory_Response {
    void call(boolean z);
  }

  public interface DeleteFile_Response {
    void call(boolean z);
  }

  public interface DirectoryExists_Response {
    void call(boolean z);
  }

  public interface GetFileInfo_Response {
    void call(FileInfo fileInfo);
  }

  public interface OpenFile_Response {
    void call(File file, int i);
  }

  public interface PathExists_Response {
    void call(boolean z);
  }

  public interface Proxy extends HttpCacheBackendFileOperations, Interface.Proxy {}

  public interface RenameFile_Response {
    void call(int i);
  }

  void cleanupDirectory(FilePath filePath, CleanupDirectory_Response cleanupDirectory_Response);

  void createDirectory(FilePath filePath, CreateDirectory_Response createDirectory_Response);

  void deleteFile(FilePath filePath, int i, DeleteFile_Response deleteFile_Response);

  void directoryExists(FilePath filePath, DirectoryExists_Response directoryExists_Response);

  void enumerateFiles(FilePath filePath, InterfaceRequest<FileEnumerator> interfaceRequest);

  void getFileInfo(FilePath filePath, GetFileInfo_Response getFileInfo_Response);

  void openFile(FilePath filePath, int i, OpenFile_Response openFile_Response);

  void pathExists(FilePath filePath, PathExists_Response pathExists_Response);

  void renameFile(FilePath filePath, FilePath filePath2, RenameFile_Response renameFile_Response);
}
