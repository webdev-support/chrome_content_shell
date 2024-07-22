package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.internal.mojom.Origin;

public interface WebDatabaseHost extends Interface {
  public static final Interface.Manager<WebDatabaseHost, Proxy> MANAGER =
      WebDatabaseHost_Internal.MANAGER;

  public interface DeleteFile_Response {
    void call(int i);
  }

  public interface GetFileAttributes_Response {
    void call(int i);
  }

  public interface GetSpaceAvailable_Response {
    void call(long j);
  }

  public interface OpenFile_Response {
    void call(org.chromium.mojo_base.mojom.File file);
  }

  public interface Proxy extends WebDatabaseHost, Interface.Proxy {}

  public interface SetFileSize_Response {
    void call(boolean z);
  }

  void closed(Origin origin, String16 string16);

  void deleteFile(String16 string16, boolean z, DeleteFile_Response deleteFile_Response);

  void getFileAttributes(String16 string16, GetFileAttributes_Response getFileAttributes_Response);

  void getSpaceAvailable(Origin origin, GetSpaceAvailable_Response getSpaceAvailable_Response);

  void handleSqliteError(Origin origin, String16 string16, int i);

  void modified(Origin origin, String16 string16);

  void openFile(String16 string16, int i, OpenFile_Response openFile_Response);

  void opened(Origin origin, String16 string16, String16 string162);

  void setFileSize(String16 string16, long j, SetFileSize_Response setFileSize_Response);
}
