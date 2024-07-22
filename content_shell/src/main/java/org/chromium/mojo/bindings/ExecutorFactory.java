package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.Pair;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.Watcher;

public class ExecutorFactory {
  private static final ByteBuffer NOTIFY_BUFFER = null;
  private static final ThreadLocal<Executor> EXECUTORS = new ThreadLocal<>();

  public static class PipedExecutor implements Executor, Watcher.Callback {

    private final Object mLock;
    private final List<Runnable> mPendingActions;
    private final MessagePipeHandle mReadHandle;
    private final Watcher mWatcher;
    private final MessagePipeHandle mWriteHandle;

    public PipedExecutor(Core core) {
      Watcher watcher = core.getWatcher();
      this.mWatcher = watcher;
      if (watcher == null) {
        throw new AssertionError();
      }
      this.mLock = new Object();
      Pair<MessagePipeHandle, MessagePipeHandle> handles =
          core.createMessagePipe(new MessagePipeHandle.CreateOptions());
      MessagePipeHandle messagePipeHandle = handles.first;
      this.mReadHandle = messagePipeHandle;
      this.mWriteHandle = handles.second;
      this.mPendingActions = new ArrayList();
      watcher.start(messagePipeHandle, Core.HandleSignals.READABLE, this);
    }

    @Override
    public void onResult(int result) {
      if (result == 0 && readNotifyBufferMessage()) {
        runNextAction();
      } else {
        close();
      }
    }

    private void close() {
      synchronized (this.mLock) {
        this.mWriteHandle.close();
        this.mPendingActions.clear();
      }
      this.mWatcher.cancel();
      this.mWatcher.destroy();
      this.mReadHandle.close();
    }

    private boolean readNotifyBufferMessage() {
      try {
        ResultAnd<MessagePipeHandle.ReadMessageResult> readMessageResult =
            this.mReadHandle.readMessage(MessagePipeHandle.ReadFlags.NONE);
        if (readMessageResult.getMojoResult() == 0) {
          return true;
        }
        return false;
      } catch (MojoException e) {
        return false;
      }
    }

    private void runNextAction() {
      Runnable toRun;
      synchronized (this.mLock) {
        toRun = this.mPendingActions.remove(0);
      }
      toRun.run();
    }

    @Override     public void execute(Runnable command) {
      synchronized (this.mLock) {
        if (!this.mWriteHandle.isValid()) {
          throw new IllegalStateException("Trying to execute an action on a closed executor.");
        }
        this.mPendingActions.add(command);
        this.mWriteHandle.writeMessage(
            ExecutorFactory.NOTIFY_BUFFER, null, MessagePipeHandle.WriteFlags.NONE);
      }
    }
  }

  public static Executor getExecutorForCurrentThread(Core core) {
    ThreadLocal<Executor> threadLocal = EXECUTORS;
    Executor executor = threadLocal.get();
    if (executor == null) {
      Executor executor2 = new PipedExecutor(core);
      threadLocal.set(executor2);
      return executor2;
    }
    return executor;
  }
}
