package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface FileSystemAccessManager extends Interface {
  public static final Interface.Manager<FileSystemAccessManager, Proxy> MANAGER =
      FileSystemAccessManager_Internal.MANAGER;

  public interface ChooseEntries_Response {
    void call(
        FileSystemAccessError fileSystemAccessError,
        FileSystemAccessEntry[] fileSystemAccessEntryArr);
  }

  public interface GetEntryFromDataTransferToken_Response {
    void call(
        FileSystemAccessError fileSystemAccessError, FileSystemAccessEntry fileSystemAccessEntry);
  }

  public interface GetSandboxedFileSystem_Response {
    void call(
        FileSystemAccessError fileSystemAccessError,
        FileSystemAccessDirectoryHandle fileSystemAccessDirectoryHandle);
  }

  public interface Proxy extends FileSystemAccessManager, Interface.Proxy {}

  void bindObserverHost(InterfaceRequest<FileSystemAccessObserverHost> interfaceRequest);

  void chooseEntries(
      FilePickerOptions filePickerOptions, ChooseEntries_Response chooseEntries_Response);

  void getDirectoryHandleFromToken(
      FileSystemAccessTransferToken fileSystemAccessTransferToken,
      InterfaceRequest<FileSystemAccessDirectoryHandle> interfaceRequest);

  void getEntryFromDataTransferToken(
      FileSystemAccessDataTransferToken fileSystemAccessDataTransferToken,
      GetEntryFromDataTransferToken_Response getEntryFromDataTransferToken_Response);

  void getFileHandleFromToken(
      FileSystemAccessTransferToken fileSystemAccessTransferToken,
      InterfaceRequest<FileSystemAccessFileHandle> interfaceRequest);

  void getSandboxedFileSystem(GetSandboxedFileSystem_Response getSandboxedFileSystem_Response);
}
