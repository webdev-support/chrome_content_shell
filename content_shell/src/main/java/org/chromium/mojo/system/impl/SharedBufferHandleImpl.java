package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.SharedBufferHandle;

public class SharedBufferHandleImpl extends HandleBase implements SharedBufferHandle {

  public SharedBufferHandleImpl(CoreImpl core, long mojoHandle) {
    super(core, mojoHandle);
  }

  public SharedBufferHandleImpl(HandleBase handle) {
    super(handle);
  }

  @Override
  public SharedBufferHandle pass() {
    return new SharedBufferHandleImpl(this);
  }

  @Override
  public SharedBufferHandle duplicate(SharedBufferHandle.DuplicateOptions options) {
    return this.mCore.duplicate(this, options);
  }

  @Override
  public ByteBuffer map(long offset, long numBytes, SharedBufferHandle.MapFlags flags) {
    return this.mCore.map(this, offset, numBytes, flags);
  }

  @Override
  public void unmap(ByteBuffer buffer) {
    this.mCore.unmap(buffer);
  }
}
