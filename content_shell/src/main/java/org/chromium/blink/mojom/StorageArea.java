package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface StorageArea extends Interface {
  public static final Interface.Manager<StorageArea, Proxy> MANAGER = StorageArea_Internal.MANAGER;
  public static final int PER_STORAGE_AREA_OVER_QUOTA_ALLOWANCE = 102400;
  public static final int PER_STORAGE_AREA_QUOTA = 10485760;

  public interface DeleteAll_Response {
    void call(boolean z);
  }

  public interface Delete_Response {
    void call(boolean z);
  }

  public interface GetAll_Response {
    void call(KeyValue[] keyValueArr);
  }

  public interface Get_Response {
    void call(boolean z, byte[] bArr);
  }

  public interface Proxy extends StorageArea, Interface.Proxy {}

  public interface Put_Response {
    void call(boolean z);
  }

  void addObserver(StorageAreaObserver storageAreaObserver);

  void delete(byte[] bArr, byte[] bArr2, String str, Delete_Response delete_Response);

  void deleteAll(
      String str, StorageAreaObserver storageAreaObserver, DeleteAll_Response deleteAll_Response);

  void get(byte[] bArr, Get_Response get_Response);

  void getAll(StorageAreaObserver storageAreaObserver, GetAll_Response getAll_Response);

  void put(byte[] bArr, byte[] bArr2, byte[] bArr3, String str, Put_Response put_Response);
}
