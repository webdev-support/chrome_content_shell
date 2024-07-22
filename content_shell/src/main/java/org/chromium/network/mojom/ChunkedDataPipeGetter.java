package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

public interface ChunkedDataPipeGetter extends Interface {
  public static final Interface.Manager<ChunkedDataPipeGetter, Proxy> MANAGER =
      ChunkedDataPipeGetter_Internal.MANAGER;

  public interface GetSize_Response {
    void call(int i, long j);
  }

  public interface Proxy extends ChunkedDataPipeGetter, Interface.Proxy {}

  void getSize(GetSize_Response getSize_Response);

  void startReading(DataPipe.ProducerHandle producerHandle);
}
