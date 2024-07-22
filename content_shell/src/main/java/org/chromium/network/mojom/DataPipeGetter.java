package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

public interface DataPipeGetter extends Interface {
  public static final Interface.Manager<DataPipeGetter, Proxy> MANAGER =
      DataPipeGetter_Internal.MANAGER;

  public interface Proxy extends DataPipeGetter, Interface.Proxy {}

  public interface Read_Response {
    void call(int i, long j);
  }

  void clone(InterfaceRequest<DataPipeGetter> interfaceRequest);

  void read(DataPipe.ProducerHandle producerHandle, Read_Response read_Response);
}
