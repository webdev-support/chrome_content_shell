package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.BigBuffer;

public interface FileSystemAccessFileDelegateHost extends Interface {
  public static final Interface.Manager<FileSystemAccessFileDelegateHost, Proxy> MANAGER =
      FileSystemAccessFileDelegateHost_Internal.MANAGER;

  public interface GetLength_Response {
    void call(int i, long j);
  }

  public interface Proxy extends FileSystemAccessFileDelegateHost, Interface.Proxy {}

  public interface Read_Response {
    void call(BigBuffer bigBuffer, int i, int i2);
  }

  public interface SetLength_Response {
    void call(int i);
  }

  public interface Write_Response {
    void call(int i, int i2);
  }

  void getLength(GetLength_Response getLength_Response);

  void read(long j, int i, Read_Response read_Response);

  void setLength(long j, SetLength_Response setLength_Response);

  void write(long j, DataPipe.ConsumerHandle consumerHandle, Write_Response write_Response);
}
