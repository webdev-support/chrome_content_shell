package org.chromium.mojo.system.impl;

import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.Pair;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.RunLoop;
import org.chromium.mojo.system.SharedBufferHandle;
import org.chromium.mojo.system.UntypedHandle;
import org.chromium.mojo.system.Watcher;
import org.jni_zero.JNINamespace;

@JNINamespace("mojo::android")
public class CoreImpl implements Core {
  private static final int FLAG_SIZE = 4;
  private static final int HANDLE_SIZE = 8;
  static final long INVALID_HANDLE = 0;
  private static final int MOJO_READ_DATA_FLAG_DISCARD = 2;
  private final int mByteBufferOffset;
  private final ThreadLocal<BaseRunLoop> mCurrentRunLoop;

  public interface Natives {
    ResultAnd<ByteBuffer> beginReadData(CoreImpl coreImpl, long j, int i, int i2);

    ResultAnd<ByteBuffer> beginWriteData(CoreImpl coreImpl, long j, int i, int i2);

    int close(CoreImpl coreImpl, long j);

    ResultAnd<RawHandlePair> createDataPipe(CoreImpl coreImpl, ByteBuffer byteBuffer);

    ResultAnd<RawHandlePair> createMessagePipe(CoreImpl coreImpl, ByteBuffer byteBuffer);

    long createPlatformHandle(int i);

    ResultAnd<Long> createSharedBuffer(CoreImpl coreImpl, ByteBuffer byteBuffer, long j);

    ResultAnd<Long> duplicate(CoreImpl coreImpl, long j, ByteBuffer byteBuffer);

    int endReadData(CoreImpl coreImpl, long j, int i);

    int endWriteData(CoreImpl coreImpl, long j, int i);

    int getNativeBufferOffset(CoreImpl coreImpl, ByteBuffer byteBuffer, int i);

    long getTimeTicksNow(CoreImpl coreImpl);

    ResultAnd<ByteBuffer> map(CoreImpl coreImpl, long j, long j2, long j3, int i);

    int queryHandleSignalsState(CoreImpl coreImpl, long j, ByteBuffer byteBuffer);

    ResultAnd<Integer> readData(CoreImpl coreImpl, long j, ByteBuffer byteBuffer, int i, int i2);

    ResultAnd<MessagePipeHandle.ReadMessageResult> readMessage(CoreImpl coreImpl, long j, int i);

    int unmap(CoreImpl coreImpl, ByteBuffer byteBuffer);

    ResultAnd<Integer> writeData(CoreImpl coreImpl, long j, ByteBuffer byteBuffer, int i, int i2);

    int writeMessage(
        CoreImpl coreImpl, long j, ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2);
  }

  private static class LazyHolder {
    private static final Core INSTANCE = new CoreImpl();

    private LazyHolder() {}
  }

  public static Core getInstance() {
    return LazyHolder.INSTANCE;
  }

  private CoreImpl() {
    this.mCurrentRunLoop = new ThreadLocal<>();
    this.mByteBufferOffset =
        CoreImplJni.get().getNativeBufferOffset(this, ByteBuffer.allocateDirect(8), 8);
  }

  @Override
  public long getTimeTicksNow() {
    return CoreImplJni.get().getTimeTicksNow(this);
  }

  @Override
  public Pair<MessagePipeHandle, MessagePipeHandle> createMessagePipe(
      MessagePipeHandle.CreateOptions options) {
    ByteBuffer optionsBuffer = null;
    if (options != null) {
      optionsBuffer = allocateDirectBuffer(8);
      optionsBuffer.putInt(0, 8);
      optionsBuffer.putInt(4, options.getFlags().getFlags());
    }
    ResultAnd<RawHandlePair> result = CoreImplJni.get().createMessagePipe(this, optionsBuffer);
    if (result.getMojoResult() != 0) {
      throw new MojoException(result.getMojoResult());
    }
    return Pair.create(
        new MessagePipeHandleImpl(this, ((Long) result.getValue().first).longValue()),
        new MessagePipeHandleImpl(this, ((Long) result.getValue().second).longValue()));
  }

  @Override
  public Pair<DataPipe.ProducerHandle, DataPipe.ConsumerHandle> createDataPipe(
      DataPipe.CreateOptions options) {
    ByteBuffer optionsBuffer = null;
    if (options != null) {
      optionsBuffer = allocateDirectBuffer(16);
      optionsBuffer.putInt(0, 16);
      optionsBuffer.putInt(4, options.getFlags().getFlags());
      optionsBuffer.putInt(8, options.getElementNumBytes());
      optionsBuffer.putInt(12, options.getCapacityNumBytes());
    }
    ResultAnd<RawHandlePair> result = CoreImplJni.get().createDataPipe(this, optionsBuffer);
    if (result.getMojoResult() != 0) {
      throw new MojoException(result.getMojoResult());
    }
    return Pair.create(
        new DataPipeProducerHandleImpl(this, ((Long) result.getValue().first).longValue()),
        new DataPipeConsumerHandleImpl(this, ((Long) result.getValue().second).longValue()));
  }

  @Override
  public SharedBufferHandle createSharedBuffer(
      SharedBufferHandle.CreateOptions options, long numBytes) {
    ByteBuffer optionsBuffer = null;
    if (options != null) {
      optionsBuffer = allocateDirectBuffer(8);
      optionsBuffer.putInt(0, 8);
      optionsBuffer.putInt(4, options.getFlags().getFlags());
    }
    ResultAnd<Long> result = CoreImplJni.get().createSharedBuffer(this, optionsBuffer, numBytes);
    if (result.getMojoResult() != 0) {
      throw new MojoException(result.getMojoResult());
    }
    return new SharedBufferHandleImpl(this, result.getValue().longValue());
  }

  @Override
  public UntypedHandle acquireNativeHandle(long handle) {
    return new UntypedHandleImpl(this, handle);
  }

  @Override
  public UntypedHandle wrapFileDescriptor(ParcelFileDescriptor fd) {
    long releasedHandle = CoreImplJni.get().createPlatformHandle(fd.detachFd());
    return acquireNativeHandle(releasedHandle);
  }

  @Override
  public Watcher getWatcher() {
    return new WatcherImpl();
  }

  @Override
  public RunLoop createDefaultRunLoop() {
    if (this.mCurrentRunLoop.get() != null) {
      throw new MojoException(9);
    }
    BaseRunLoop runLoop = new BaseRunLoop(this);
    this.mCurrentRunLoop.set(runLoop);
    return runLoop;
  }

  @Override
  public RunLoop getCurrentRunLoop() {
    return this.mCurrentRunLoop.get();
  }

  public void clearCurrentRunLoop() {
    this.mCurrentRunLoop.remove();
  }

  public int closeWithResult(long mojoHandle) {
    return CoreImplJni.get().close(this, mojoHandle);
  }

  public void close(long mojoHandle) {
    int mojoResult = CoreImplJni.get().close(this, mojoHandle);
    if (mojoResult != 0) {
      throw new MojoException(mojoResult);
    }
  }

  public Core.HandleSignalsState queryHandleSignalsState(long mojoHandle) {
    ByteBuffer buffer = allocateDirectBuffer(8);
    int result = CoreImplJni.get().queryHandleSignalsState(this, mojoHandle, buffer);
    if (result != 0) {
      throw new MojoException(result);
    }
    return new Core.HandleSignalsState(
        new Core.HandleSignals(buffer.getInt(0)), new Core.HandleSignals(buffer.getInt(4)));
  }

  public void writeMessage(
      MessagePipeHandleImpl pipeHandle,
      ByteBuffer bytes,
      List<? extends Handle> handles,
      MessagePipeHandle.WriteFlags flags) {
    ByteBuffer handlesBuffer = null;
    if (handles != null && !handles.isEmpty()) {
      handlesBuffer = allocateDirectBuffer(handles.size() * 8);
      for (Handle handle : handles) {
        handlesBuffer.putLong(handle.releaseNativeHandle());
      }
      ByteBuffer byteBuffer = (ByteBuffer) handlesBuffer.position(0);
    }
    int mojoResult =
        CoreImplJni.get()
            .writeMessage(
                this,
                pipeHandle.getMojoHandle(),
                bytes,
                bytes != null ? bytes.limit() : 0,
                handlesBuffer,
                flags.getFlags());
    if (mojoResult != 0) {
      throw new MojoException(mojoResult);
    }
  }

  public ResultAnd<MessagePipeHandle.ReadMessageResult> readMessage(
      MessagePipeHandleImpl handle, MessagePipeHandle.ReadFlags flags) {
    ResultAnd<MessagePipeHandle.ReadMessageResult> result =
        CoreImplJni.get().readMessage(this, handle.getMojoHandle(), flags.getFlags());
    if (result.getMojoResult() != 0 && result.getMojoResult() != 17) {
      throw new MojoException(result.getMojoResult());
    }
    MessagePipeHandle.ReadMessageResult readResult = result.getValue();
    long[] rawHandles = readResult.mRawHandles;
    if (rawHandles != null && rawHandles.length != 0) {
      readResult.mHandles = new ArrayList(rawHandles.length);
      for (long rawHandle : rawHandles) {
        readResult.mHandles.add(new UntypedHandleImpl(this, rawHandle));
      }
    } else {
      readResult.mHandles = new ArrayList(0);
    }
    return result;
  }

  public int discardData(
      DataPipeConsumerHandleImpl handle, int numBytes, DataPipe.ReadFlags flags) {
    ResultAnd<Integer> result =
        CoreImplJni.get()
            .readData(this, handle.getMojoHandle(), null, numBytes, flags.getFlags() | 2);
    if (result.getMojoResult() != 0) {
      throw new MojoException(result.getMojoResult());
    }
    return result.getValue().intValue();
  }

  public ResultAnd<Integer> readData(
      DataPipeConsumerHandleImpl handle, ByteBuffer elements, DataPipe.ReadFlags flags) {
    ResultAnd<Integer> result =
        CoreImplJni.get()
            .readData(
                this,
                handle.getMojoHandle(),
                elements,
                elements == null ? 0 : elements.capacity(),
                flags.getFlags());
    if (result.getMojoResult() != 0 && result.getMojoResult() != 17) {
      throw new MojoException(result.getMojoResult());
    }
    if (result.getMojoResult() == 0 && elements != null) {
      ByteBuffer byteBuffer = (ByteBuffer) elements.limit(result.getValue().intValue());
    }
    return result;
  }

  public ByteBuffer beginReadData(
      DataPipeConsumerHandleImpl handle, int numBytes, DataPipe.ReadFlags flags) {
    ResultAnd<ByteBuffer> result =
        CoreImplJni.get().beginReadData(this, handle.getMojoHandle(), numBytes, flags.getFlags());
    if (result.getMojoResult() != 0) {
      throw new MojoException(result.getMojoResult());
    }
    return result.getValue().asReadOnlyBuffer();
  }

  public void endReadData(DataPipeConsumerHandleImpl handle, int numBytesRead) {
    int result = CoreImplJni.get().endReadData(this, handle.getMojoHandle(), numBytesRead);
    if (result != 0) {
      throw new MojoException(result);
    }
  }

  public ResultAnd<Integer> writeData(
      DataPipeProducerHandleImpl handle, ByteBuffer elements, DataPipe.WriteFlags flags) {
    return CoreImplJni.get()
        .writeData(this, handle.getMojoHandle(), elements, elements.limit(), flags.getFlags());
  }

  public ByteBuffer beginWriteData(
      DataPipeProducerHandleImpl handle, int numBytes, DataPipe.WriteFlags flags) {
    ResultAnd<ByteBuffer> result =
        CoreImplJni.get().beginWriteData(this, handle.getMojoHandle(), numBytes, flags.getFlags());
    if (result.getMojoResult() != 0) {
      throw new MojoException(result.getMojoResult());
    }
    return result.getValue();
  }

  public void endWriteData(DataPipeProducerHandleImpl handle, int numBytesWritten) {
    int result = CoreImplJni.get().endWriteData(this, handle.getMojoHandle(), numBytesWritten);
    if (result != 0) {
      throw new MojoException(result);
    }
  }

  public SharedBufferHandle duplicate(
      SharedBufferHandleImpl handle, SharedBufferHandle.DuplicateOptions options) {
    ByteBuffer optionsBuffer = null;
    if (options != null) {
      optionsBuffer = allocateDirectBuffer(8);
      optionsBuffer.putInt(0, 8);
      optionsBuffer.putInt(4, options.getFlags().getFlags());
    }
    ResultAnd<Long> result =
        CoreImplJni.get().duplicate(this, handle.getMojoHandle(), optionsBuffer);
    if (result.getMojoResult() != 0) {
      throw new MojoException(result.getMojoResult());
    }
    return new SharedBufferHandleImpl(this, result.getValue().longValue());
  }

  public ByteBuffer map(
      SharedBufferHandleImpl handle,
      long offset,
      long numBytes,
      SharedBufferHandle.MapFlags flags) {
    ResultAnd<ByteBuffer> result =
        CoreImplJni.get().map(this, handle.getMojoHandle(), offset, numBytes, flags.getFlags());
    if (result.getMojoResult() != 0) {
      throw new MojoException(result.getMojoResult());
    }
    return result.getValue();
  }

  public void unmap(ByteBuffer buffer) {
    int result = CoreImplJni.get().unmap(this, buffer);
    if (result != 0) {
      throw new MojoException(result);
    }
  }

  private long getMojoHandle(Handle handle) {
    if (handle.isValid()) {
      return ((HandleBase) handle).getMojoHandle();
    }
    return 0L;
  }

  private static boolean isUnrecoverableError(int code) {
    switch (code) {
      case 0:
      case 1:
      case 4:
      case 9:
        return false;
      default:
        return true;
    }
  }

  private static int filterMojoResultForWait(int code) {
    if (isUnrecoverableError(code)) {
      throw new MojoException(code);
    }
    return code;
  }

  private ByteBuffer allocateDirectBuffer(int capacity) {
    ByteBuffer buffer = ByteBuffer.allocateDirect(this.mByteBufferOffset + capacity);
    int i = this.mByteBufferOffset;
    if (i != 0) {
      ByteBuffer byteBuffer = (ByteBuffer) buffer.position(i);
      buffer = buffer.slice();
    }
    return buffer.order(ByteOrder.nativeOrder());
  }

  private static ResultAnd<ByteBuffer> newResultAndBuffer(int mojoResult, ByteBuffer buffer) {
    return new ResultAnd<>(mojoResult, buffer);
  }

  static final class RawHandlePair extends Pair<Long, Long> {
    public RawHandlePair(Long first, Long second) {
      super(first, second);
    }
  }

  private static ResultAnd<MessagePipeHandle.ReadMessageResult> newReadMessageResult(
      int mojoResult, byte[] data, long[] rawHandles) {
    MessagePipeHandle.ReadMessageResult result = new MessagePipeHandle.ReadMessageResult();
    if (mojoResult == 0) {
      result.mData = data;
      result.mRawHandles = rawHandles;
    }
    return new ResultAnd<>(mojoResult, result);
  }

  private static ResultAnd<Integer> newResultAndInteger(int mojoResult, int numBytesRead) {
    return new ResultAnd<>(mojoResult, Integer.valueOf(numBytesRead));
  }

  private static ResultAnd<Long> newResultAndLong(int mojoResult, long value) {
    return new ResultAnd<>(mojoResult, Long.valueOf(value));
  }

  private static ResultAnd<RawHandlePair> newNativeCreationResult(
      int mojoResult, long mojoHandle1, long mojoHandle2) {
    return new ResultAnd<>(
        mojoResult, new RawHandlePair(Long.valueOf(mojoHandle1), Long.valueOf(mojoHandle2)));
  }
}
