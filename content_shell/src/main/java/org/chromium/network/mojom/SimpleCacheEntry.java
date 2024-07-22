package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SimpleCacheEntry extends Interface {
  public static final Interface.Manager<SimpleCacheEntry, Proxy> MANAGER =
      SimpleCacheEntry_Internal.MANAGER;

  public interface Close_Response {
    void call();
  }

  public interface Proxy extends SimpleCacheEntry, Interface.Proxy {}

  public interface ReadData_Response {
    void call(byte[] bArr, int i);
  }

  public interface ReadSparseData_Response {
    void call(byte[] bArr, int i);
  }

  public interface WriteData_Response {
    void call(int i);
  }

  public interface WriteSparseData_Response {
    void call(int i);
  }

  void close(Close_Response close_Response);

  void readData(int i, int i2, int i3, ReadData_Response readData_Response);

  void readSparseData(int i, int i2, ReadSparseData_Response readSparseData_Response);

  void writeData(int i, int i2, byte[] bArr, boolean z, WriteData_Response writeData_Response);

  void writeSparseData(int i, byte[] bArr, WriteSparseData_Response writeSparseData_Response);
}
