package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface WorkerContentSettingsProxy extends Interface {
  public static final Interface.Manager<WorkerContentSettingsProxy, Proxy> MANAGER =
      WorkerContentSettingsProxy_Internal.MANAGER;

  public interface AllowCacheStorage_Response {
    void call(boolean z);
  }

  public interface AllowIndexedDb_Response {
    void call(boolean z);
  }

  public interface AllowWebLocks_Response {
    void call(boolean z);
  }

  public interface Proxy extends WorkerContentSettingsProxy, Interface.Proxy {}

  public interface RequestFileSystemAccessSync_Response {
    void call(boolean z);
  }

  void allowCacheStorage(AllowCacheStorage_Response allowCacheStorage_Response);

  void allowIndexedDb(AllowIndexedDb_Response allowIndexedDb_Response);

  void allowWebLocks(AllowWebLocks_Response allowWebLocks_Response);

  void requestFileSystemAccessSync(
      RequestFileSystemAccessSync_Response requestFileSystemAccessSync_Response);
}
