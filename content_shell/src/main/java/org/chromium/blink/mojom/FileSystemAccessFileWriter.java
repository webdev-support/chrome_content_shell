package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

public interface FileSystemAccessFileWriter extends Interface {
  public static final Interface.Manager<FileSystemAccessFileWriter, Proxy> MANAGER =
      FileSystemAccessFileWriter_Internal.MANAGER;

  public interface Abort_Response {
    void call(FileSystemAccessError fileSystemAccessError);
  }

  public interface Close_Response {
    void call(FileSystemAccessError fileSystemAccessError);
  }

  public interface Proxy extends FileSystemAccessFileWriter, Interface.Proxy {}

  public interface Truncate_Response {
    void call(FileSystemAccessError fileSystemAccessError);
  }

  public interface Write_Response {
    void call(FileSystemAccessError fileSystemAccessError, long j);
  }

  void abort(Abort_Response abort_Response);

  void close(Close_Response close_Response);

  void truncate(long j, Truncate_Response truncate_Response);

  void write(long j, DataPipe.ConsumerHandle consumerHandle, Write_Response write_Response);
}
