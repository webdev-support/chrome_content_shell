package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface FileSystemAccessDirectoryHandle extends Interface {
  public static final Interface.Manager<FileSystemAccessDirectoryHandle, Proxy> MANAGER =
      FileSystemAccessDirectoryHandle_Internal.MANAGER;

  public interface GetCloudIdentifiers_Response {
    void call(
        FileSystemAccessError fileSystemAccessError,
        FileSystemAccessCloudIdentifier[] fileSystemAccessCloudIdentifierArr);
  }

  public interface GetDirectory_Response {
    void call(
        FileSystemAccessError fileSystemAccessError,
        FileSystemAccessDirectoryHandle fileSystemAccessDirectoryHandle);
  }

  public interface GetFile_Response {
    void call(
        FileSystemAccessError fileSystemAccessError,
        FileSystemAccessFileHandle fileSystemAccessFileHandle);
  }

  public interface GetPermissionStatus_Response {
    void call(int i);
  }

  public interface GetUniqueId_Response {
    void call(FileSystemAccessError fileSystemAccessError, String str);
  }

  public interface Move_Response {
    void call(FileSystemAccessError fileSystemAccessError);
  }

  public interface Proxy extends FileSystemAccessDirectoryHandle, Interface.Proxy {}

  public interface RemoveEntry_Response {
    void call(FileSystemAccessError fileSystemAccessError);
  }

  public interface Remove_Response {
    void call(FileSystemAccessError fileSystemAccessError);
  }

  public interface Rename_Response {
    void call(FileSystemAccessError fileSystemAccessError);
  }

  public interface RequestPermission_Response {
    void call(FileSystemAccessError fileSystemAccessError, int i);
  }

  public interface Resolve_Response {
    void call(FileSystemAccessError fileSystemAccessError, String[] strArr);
  }

  void getCloudIdentifiers(GetCloudIdentifiers_Response getCloudIdentifiers_Response);

  void getDirectory(String str, boolean z, GetDirectory_Response getDirectory_Response);

  void getEntries(
      FileSystemAccessDirectoryEntriesListener fileSystemAccessDirectoryEntriesListener);

  void getFile(String str, boolean z, GetFile_Response getFile_Response);

  void getPermissionStatus(boolean z, GetPermissionStatus_Response getPermissionStatus_Response);

  void getUniqueId(GetUniqueId_Response getUniqueId_Response);

  void move(
      FileSystemAccessTransferToken fileSystemAccessTransferToken,
      String str,
      Move_Response move_Response);

  void remove(boolean z, Remove_Response remove_Response);

  void removeEntry(String str, boolean z, RemoveEntry_Response removeEntry_Response);

  void rename(String str, Rename_Response rename_Response);

  void requestPermission(boolean z, RequestPermission_Response requestPermission_Response);

  void resolve(
      FileSystemAccessTransferToken fileSystemAccessTransferToken,
      Resolve_Response resolve_Response);

  void transfer(InterfaceRequest<FileSystemAccessTransferToken> interfaceRequest);
}
