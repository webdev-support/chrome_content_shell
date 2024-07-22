package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.FileInfo;

public interface FileSystemAccessFileHandle extends Interface {
  public static final Interface.Manager<FileSystemAccessFileHandle, Proxy> MANAGER =
      FileSystemAccessFileHandle_Internal.MANAGER;

  public interface AsBlob_Response {
    void call(
        FileSystemAccessError fileSystemAccessError,
        FileInfo fileInfo,
        SerializedBlob serializedBlob);
  }

  public interface CreateFileWriter_Response {
    void call(
        FileSystemAccessError fileSystemAccessError,
        FileSystemAccessFileWriter fileSystemAccessFileWriter);
  }

  public interface GetCloudIdentifiers_Response {
    void call(
        FileSystemAccessError fileSystemAccessError,
        FileSystemAccessCloudIdentifier[] fileSystemAccessCloudIdentifierArr);
  }

  public interface GetPermissionStatus_Response {
    void call(int i);
  }

  public interface GetUniqueId_Response {
    void call(FileSystemAccessError fileSystemAccessError, String str);
  }

  public interface IsSameEntry_Response {
    void call(FileSystemAccessError fileSystemAccessError, boolean z);
  }

  public interface Move_Response {
    void call(FileSystemAccessError fileSystemAccessError);
  }

  public interface OpenAccessHandle_Response {
    void call(
        FileSystemAccessError fileSystemAccessError,
        FileSystemAccessAccessHandleFile fileSystemAccessAccessHandleFile,
        FileSystemAccessAccessHandleHost fileSystemAccessAccessHandleHost);
  }

  public interface Proxy extends FileSystemAccessFileHandle, Interface.Proxy {}

  public interface Remove_Response {
    void call(FileSystemAccessError fileSystemAccessError);
  }

  public interface Rename_Response {
    void call(FileSystemAccessError fileSystemAccessError);
  }

  public interface RequestPermission_Response {
    void call(FileSystemAccessError fileSystemAccessError, int i);
  }

  void asBlob(AsBlob_Response asBlob_Response);

  void createFileWriter(
      boolean z, boolean z2, int i, CreateFileWriter_Response createFileWriter_Response);

  void getCloudIdentifiers(GetCloudIdentifiers_Response getCloudIdentifiers_Response);

  void getPermissionStatus(boolean z, GetPermissionStatus_Response getPermissionStatus_Response);

  void getUniqueId(GetUniqueId_Response getUniqueId_Response);

  void isSameEntry(
      FileSystemAccessTransferToken fileSystemAccessTransferToken,
      IsSameEntry_Response isSameEntry_Response);

  void move(
      FileSystemAccessTransferToken fileSystemAccessTransferToken,
      String str,
      Move_Response move_Response);

  void openAccessHandle(int i, OpenAccessHandle_Response openAccessHandle_Response);

  void remove(Remove_Response remove_Response);

  void rename(String str, Rename_Response rename_Response);

  void requestPermission(boolean z, RequestPermission_Response requestPermission_Response);

  void transfer(InterfaceRequest<FileSystemAccessTransferToken> interfaceRequest);
}
