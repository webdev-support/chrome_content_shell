package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.ResultAnd;

class DataPipeConsumerHandleImpl extends HandleBase implements DataPipe.ConsumerHandle {

  public DataPipeConsumerHandleImpl(CoreImpl core, long mojoHandle) {
    super(core, mojoHandle);
  }

  public DataPipeConsumerHandleImpl(HandleBase other) {
    super(other);
  }

  @Override
  public DataPipe.ConsumerHandle pass() {
    return new DataPipeConsumerHandleImpl(this);
  }

  @Override
  public int discardData(int numBytes, DataPipe.ReadFlags flags) {
    return this.mCore.discardData(this, numBytes, flags);
  }

  @Override
  public ResultAnd<Integer> readData(ByteBuffer elements, DataPipe.ReadFlags flags) {
    return this.mCore.readData(this, elements, flags);
  }

  @Override
  public ByteBuffer beginReadData(int numBytes, DataPipe.ReadFlags flags) {
    return this.mCore.beginReadData(this, numBytes, flags);
  }

  @Override
  public void endReadData(int numBytesRead) {
    this.mCore.endReadData(this, numBytesRead);
  }
}
