package org.chromium.mojo.system;

import android.os.ParcelFileDescriptor;

public interface Core {
  public static final long DEADLINE_INFINITE = -1;

  UntypedHandle acquireNativeHandle(long j);

  Pair<DataPipe.ProducerHandle, DataPipe.ConsumerHandle> createDataPipe(
      DataPipe.CreateOptions createOptions);

  RunLoop createDefaultRunLoop();

  Pair<MessagePipeHandle, MessagePipeHandle> createMessagePipe(
      MessagePipeHandle.CreateOptions createOptions);

  SharedBufferHandle createSharedBuffer(SharedBufferHandle.CreateOptions createOptions, long j);

  RunLoop getCurrentRunLoop();

  long getTimeTicksNow();

  Watcher getWatcher();

  UntypedHandle wrapFileDescriptor(ParcelFileDescriptor parcelFileDescriptor);

  public static class HandleSignals extends Flags<HandleSignals> {
    private static final int FLAG_NONE = 0;
    private static final int FLAG_PEER_CLOSED = 4;
    private static final int FLAG_READABLE = 1;
    private static final int FLAG_WRITABLE = 2;
    public static final HandleSignals NONE = none().immutable();
    public static final HandleSignals READABLE = none().setReadable(true).immutable();
    public static final HandleSignals WRITABLE = none().setWritable(true).immutable();

    public HandleSignals(int signals) {
      super(signals);
    }

    public HandleSignals setReadable(boolean readable) {
      return setFlag(1, readable);
    }

    public HandleSignals setWritable(boolean writable) {
      return setFlag(2, writable);
    }

    public HandleSignals setPeerClosed(boolean peerClosed) {
      return setFlag(4, peerClosed);
    }

    public static HandleSignals none() {
      return new HandleSignals(0);
    }
  }

  public static class HandleSignalsState {
    private final HandleSignals mSatisfiableSignals;
    private final HandleSignals mSatisfiedSignals;

    public HandleSignalsState(HandleSignals satisfiedSignals, HandleSignals satisfiableSignals) {
      this.mSatisfiedSignals = satisfiedSignals;
      this.mSatisfiableSignals = satisfiableSignals;
    }

    public HandleSignals getSatisfiedSignals() {
      return this.mSatisfiedSignals;
    }

    public HandleSignals getSatisfiableSignals() {
      return this.mSatisfiableSignals;
    }
  }
}
