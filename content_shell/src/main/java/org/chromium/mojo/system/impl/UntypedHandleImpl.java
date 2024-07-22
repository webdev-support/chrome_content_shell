package org.chromium.mojo.system.impl;

import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.SharedBufferHandle;
import org.chromium.mojo.system.UntypedHandle;

public class UntypedHandleImpl extends HandleBase implements UntypedHandle {

  public UntypedHandleImpl(CoreImpl core, long mojoHandle) {
    super(core, mojoHandle);
  }

  public UntypedHandleImpl(HandleBase handle) {
    super(handle);
  }

  @Override
  public UntypedHandle pass() {
    return new UntypedHandleImpl(this);
  }

  @Override
  public MessagePipeHandle toMessagePipeHandle() {
    return new MessagePipeHandleImpl(this);
  }

  @Override
  public DataPipe.ConsumerHandle toDataPipeConsumerHandle() {
    return new DataPipeConsumerHandleImpl(this);
  }

  @Override
  public DataPipe.ProducerHandle toDataPipeProducerHandle() {
    return new DataPipeProducerHandleImpl(this);
  }

  @Override
  public SharedBufferHandle toSharedBufferHandle() {
    return new SharedBufferHandleImpl(this);
  }
}
