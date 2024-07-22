package org.chromium.blink.mojom;

import org.chromium.filesystem.mojom.DirectoryEntry;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.FileInfo;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public interface FileSystemManager extends Interface {
  public static final Interface.Manager<FileSystemManager, Proxy> MANAGER =
      FileSystemManager_Internal.MANAGER;

  public interface Copy_Response {
    void call(int i);
  }

  public interface CreateSnapshotFile_Response {
    void call(
        FileInfo fileInfo,
        FilePath filePath,
        int i,
        ReceivedSnapshotListener receivedSnapshotListener);
  }

  public interface Create_Response {
    void call(int i);
  }

  public interface Exists_Response {
    void call(int i);
  }

  public interface GetPlatformPath_Response {
    void call(FilePath filePath);
  }

  public interface Move_Response {
    void call(int i);
  }

  public interface Open_Response {
    void call(String str, Url url, int i);
  }

  public interface Proxy extends FileSystemManager, Interface.Proxy {}

  public interface ReadDirectorySync_Response {
    void call(DirectoryEntry[] directoryEntryArr, int i);
  }

  public interface ReadMetadata_Response {
    void call(FileInfo fileInfo, int i);
  }

  public interface RegisterBlob_Response {
    void call(SerializedBlob serializedBlob);
  }

  public interface Remove_Response {
    void call(int i);
  }

  public interface ResolveUrl_Response {
    void call(FileSystemInfo fileSystemInfo, FilePath filePath, boolean z, int i);
  }

  public interface TruncateSync_Response {
    void call(int i);
  }

  public interface Truncate_Response {
    void call(int i);
  }

  public interface WriteSync_Response {
    void call(long j, int i);
  }

  void copy(Url url, Url url2, Copy_Response copy_Response);

  void create(Url url, boolean z, boolean z2, boolean z3, Create_Response create_Response);

  void createSnapshotFile(Url url, CreateSnapshotFile_Response createSnapshotFile_Response);

  void exists(Url url, boolean z, Exists_Response exists_Response);

  void getPlatformPath(Url url, GetPlatformPath_Response getPlatformPath_Response);

  void move(Url url, Url url2, Move_Response move_Response);

  void open(Origin origin, int i, Open_Response open_Response);

  void readDirectory(Url url, FileSystemOperationListener fileSystemOperationListener);

  void readDirectorySync(Url url, ReadDirectorySync_Response readDirectorySync_Response);

  void readMetadata(Url url, ReadMetadata_Response readMetadata_Response);

  void registerBlob(
      String str, Url url, long j, Time time, RegisterBlob_Response registerBlob_Response);

  void remove(Url url, boolean z, Remove_Response remove_Response);

  void resolveUrl(Url url, ResolveUrl_Response resolveUrl_Response);

  void truncate(
      Url url,
      long j,
      InterfaceRequest<FileSystemCancellableOperation> interfaceRequest,
      Truncate_Response truncate_Response);

  void truncateSync(Url url, long j, TruncateSync_Response truncateSync_Response);

  void write(
      Url url,
      Blob blob,
      long j,
      InterfaceRequest<FileSystemCancellableOperation> interfaceRequest,
      FileSystemOperationListener fileSystemOperationListener);

  void writeSync(Url url, Blob blob, long j, WriteSync_Response writeSync_Response);
}
