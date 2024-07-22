package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import java.util.List;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.ResultAnd;

class MessagePipeHandleImpl extends HandleBase implements MessagePipeHandle {

  public MessagePipeHandleImpl(CoreImpl core, long mojoHandle) {
    super(core, mojoHandle);
  }

  public MessagePipeHandleImpl(HandleBase handle) {
    super(handle);
  }

  @Override
  public MessagePipeHandle pass() {
    return new MessagePipeHandleImpl(this);
  }

  @Override
  public void writeMessage(
      ByteBuffer bytes, List<? extends Handle> handles, MessagePipeHandle.WriteFlags flags) {
    this.mCore.writeMessage(this, bytes, handles, flags);
  }

  @Override
  public ResultAnd<MessagePipeHandle.ReadMessageResult> readMessage(
      MessagePipeHandle.ReadFlags flags) {
    return this.mCore.readMessage(this, flags);
  }
}
