package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.Time;

public interface BytesProvider extends Interface {
  public static final Interface.Manager<BytesProvider, Proxy> MANAGER =
      BytesProvider_Internal.MANAGER;

  public interface Proxy extends BytesProvider, Interface.Proxy {}

  public interface RequestAsFile_Response {
    void call(Time time);
  }

  public interface RequestAsReply_Response {
    void call(byte[] bArr);
  }

  void requestAsFile(
      long j,
      long j2,
      org.chromium.mojo_base.mojom.File file,
      long j3,
      RequestAsFile_Response requestAsFile_Response);

  void requestAsReply(RequestAsReply_Response requestAsReply_Response);

  void requestAsStream(DataPipe.ProducerHandle producerHandle);
}
