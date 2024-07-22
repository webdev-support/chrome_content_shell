package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.ResultAnd;

class DataPipeProducerHandleImpl extends HandleBase implements DataPipe.ProducerHandle {

  public DataPipeProducerHandleImpl(CoreImpl core, long mojoHandle) {
    super(core, mojoHandle);
  }

  public DataPipeProducerHandleImpl(HandleBase handle) {
    super(handle);
  }

  @Override
  public DataPipe.ProducerHandle pass() {
    return new DataPipeProducerHandleImpl(this);
  }

  @Override
  public ResultAnd<Integer> writeData(ByteBuffer elements, DataPipe.WriteFlags flags) {
    return this.mCore.writeData(this, elements, flags);
  }

  @Override
  public ByteBuffer beginWriteData(int numBytes, DataPipe.WriteFlags flags) {
    return this.mCore.beginWriteData(this, numBytes, flags);
  }

  @Override
  public void endWriteData(int numBytesWritten) {
    this.mCore.endWriteData(this, numBytesWritten);
  }
}
