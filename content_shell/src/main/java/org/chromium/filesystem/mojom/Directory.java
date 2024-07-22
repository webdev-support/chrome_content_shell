package org.chromium.filesystem.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.File;

public interface Directory extends Interface {
  public static final Interface.Manager<Directory, Proxy> MANAGER = Directory_Internal.MANAGER;

  public interface Delete_Response {
    void call(int i);
  }

  public interface Exists_Response {
    void call(int i, boolean z);
  }

  public interface Flush_Response {
    void call(int i);
  }

  public interface IsWritable_Response {
    void call(int i, boolean z);
  }

  public interface OpenDirectory_Response {
    void call(int i);
  }

  public interface OpenFileHandle_Response {
    void call(int i, File file);
  }

  public interface OpenFileHandles_Response {
    void call(FileOpenResult[] fileOpenResultArr);
  }

  public interface Proxy extends Directory, Interface.Proxy {}

  public interface ReadEntireFile_Response {
    void call(int i, byte[] bArr);
  }

  public interface Read_Response {
    void call(int i, DirectoryEntry[] directoryEntryArr);
  }

  public interface Rename_Response {
    void call(int i);
  }

  public interface Replace_Response {
    void call(int i);
  }

  public interface StatFile_Response {
    void call(int i, FileInformation fileInformation);
  }

  public interface WriteFile_Response {
    void call(int i);
  }

  void clone(InterfaceRequest<Directory> interfaceRequest);

  void delete(String str, int i, Delete_Response delete_Response);

  void exists(String str, Exists_Response exists_Response);

  void flush(Flush_Response flush_Response);

  void isWritable(String str, IsWritable_Response isWritable_Response);

  void openDirectory(
      String str,
      InterfaceRequest<Directory> interfaceRequest,
      int i,
      OpenDirectory_Response openDirectory_Response);

  void openFileHandle(String str, int i, OpenFileHandle_Response openFileHandle_Response);

  void openFileHandles(
      FileOpenDetails[] fileOpenDetailsArr, OpenFileHandles_Response openFileHandles_Response);

  void read(Read_Response read_Response);

  void readEntireFile(String str, ReadEntireFile_Response readEntireFile_Response);

  void rename(String str, String str2, Rename_Response rename_Response);

  void replace(String str, String str2, Replace_Response replace_Response);

  void statFile(String str, StatFile_Response statFile_Response);

  void writeFile(String str, byte[] bArr, WriteFile_Response writeFile_Response);
}
