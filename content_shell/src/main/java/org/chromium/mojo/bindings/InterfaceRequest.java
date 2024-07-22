package org.chromium.mojo.bindings;

import org.chromium.mojo.system.MessagePipeHandle;

public class InterfaceRequest<P extends Interface> implements HandleOwner<MessagePipeHandle> {
  private final MessagePipeHandle mHandle;

  public InterfaceRequest(MessagePipeHandle handle) {
    this.mHandle = handle;
  }

  @Override
  public MessagePipeHandle passHandle() {
    return this.mHandle.pass();
  }

  @Override
  public void close() {
    this.mHandle.close();
  }

  public static InterfaceRequest asInterfaceRequestUnsafe(MessagePipeHandle handle) {
    return new InterfaceRequest(handle);
  }
}
