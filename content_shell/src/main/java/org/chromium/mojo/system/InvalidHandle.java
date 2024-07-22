package org.chromium.mojo.system;

import java.nio.ByteBuffer;
import java.util.List;

public class InvalidHandle
    implements UntypedHandle,
        MessagePipeHandle,
        DataPipe.ConsumerHandle,
        DataPipe.ProducerHandle,
        SharedBufferHandle {
  public static final InvalidHandle INSTANCE = new InvalidHandle();

  private InvalidHandle() {}

  @Override
  public void close() {}

  @Override
  public Core.HandleSignalsState querySignalsState() {
    throw new MojoException(3);
  }

  @Override
  public boolean isValid() {
    return false;
  }

  @Override
  public Core getCore() {
    return null;
  }

  @Override
  public InvalidHandle pass() {
    return this;
  }

  @Override
  public UntypedHandle toUntypedHandle() {
    return this;
  }

  @Override
  public long releaseNativeHandle() {
    return 0L;
  }

  @Override
  public MessagePipeHandle toMessagePipeHandle() {
    return this;
  }

  @Override
  public DataPipe.ConsumerHandle toDataPipeConsumerHandle() {
    return this;
  }

  @Override
  public DataPipe.ProducerHandle toDataPipeProducerHandle() {
    return this;
  }

  @Override
  public SharedBufferHandle toSharedBufferHandle() {
    return this;
  }

  @Override
  public SharedBufferHandle duplicate(SharedBufferHandle.DuplicateOptions options) {
    throw new MojoException(3);
  }

  @Override
  public ByteBuffer map(long offset, long numBytes, SharedBufferHandle.MapFlags flags) {
    throw new MojoException(3);
  }

  @Override
  public void unmap(ByteBuffer buffer) {
    throw new MojoException(3);
  }

  @Override
  public ResultAnd<Integer> writeData(ByteBuffer elements, DataPipe.WriteFlags flags) {
    throw new MojoException(3);
  }

  @Override
  public ByteBuffer beginWriteData(int numBytes, DataPipe.WriteFlags flags) {
    throw new MojoException(3);
  }

  @Override
  public void endWriteData(int numBytesWritten) {
    throw new MojoException(3);
  }

  @Override
  public int discardData(int numBytes, DataPipe.ReadFlags flags) {
    throw new MojoException(3);
  }

  @Override
  public ResultAnd<Integer> readData(ByteBuffer elements, DataPipe.ReadFlags flags) {
    throw new MojoException(3);
  }

  @Override
  public ByteBuffer beginReadData(int numBytes, DataPipe.ReadFlags flags) {
    throw new MojoException(3);
  }

  @Override
  public void endReadData(int numBytesRead) {
    throw new MojoException(3);
  }

  @Override
  public void writeMessage(
      ByteBuffer bytes, List<? extends Handle> handles, MessagePipeHandle.WriteFlags flags) {
    throw new MojoException(3);
  }

  @Override
  public ResultAnd<MessagePipeHandle.ReadMessageResult> readMessage(
      MessagePipeHandle.ReadFlags flags) {
    throw new MojoException(3);
  }
}
