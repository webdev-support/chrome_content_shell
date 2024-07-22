package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.Watcher;

public class Connector implements MessageReceiver, HandleOwner<MessagePipeHandle> {

  private ConnectionErrorHandler mErrorHandler;
  private MessageReceiver mIncomingMessageReceiver;
  private final MessagePipeHandle mMessagePipeHandle;
  private final Watcher mWatcher;
  private final WatcherCallback mWatcherCallback;

  public Connector(MessagePipeHandle messagePipeHandle) {
    this(messagePipeHandle, BindingsHelper.getWatcherForHandle(messagePipeHandle));
  }

  public Connector(MessagePipeHandle messagePipeHandle, Watcher watcher) {
    this.mWatcherCallback = new WatcherCallback();
    this.mMessagePipeHandle = messagePipeHandle;
    this.mWatcher = watcher;
  }

  public void setIncomingMessageReceiver(MessageReceiver incomingMessageReceiver) {
    this.mIncomingMessageReceiver = incomingMessageReceiver;
  }

  public void setErrorHandler(ConnectionErrorHandler errorHandler) {
    this.mErrorHandler = errorHandler;
  }

  public void start() {
    this.mWatcher.start(
        this.mMessagePipeHandle, Core.HandleSignals.READABLE, this.mWatcherCallback);
  }

  @Override
  public boolean accept(Message message) {
    try {
      this.mMessagePipeHandle.writeMessage(
          message.getData(), message.getHandles(), MessagePipeHandle.WriteFlags.NONE);
      return true;
    } catch (MojoException e) {
      onError(e);
      return false;
    }
  }

  @Override
  public MessagePipeHandle passHandle() {
    cancelIfActive();
    MessagePipeHandle handle = this.mMessagePipeHandle.pass();
    MessageReceiver messageReceiver = this.mIncomingMessageReceiver;
    if (messageReceiver != null) {
      messageReceiver.close();
    }
    return handle;
  }

  @Override
  public void close() {
    cancelIfActive();
    this.mMessagePipeHandle.close();
    if (this.mIncomingMessageReceiver != null) {
      MessageReceiver incomingMessageReceiver = this.mIncomingMessageReceiver;
      this.mIncomingMessageReceiver = null;
      incomingMessageReceiver.close();
    }
  }

  public class WatcherCallback implements Watcher.Callback {
    private WatcherCallback() {}

    @Override
    public void onResult(int result) {
      Connector.this.onWatcherResult(result);
    }
  }

  public void onWatcherResult(int result) {
    if (result == 0) {
      readOutstandingMessages();
    } else {
      onError(new MojoException(result));
    }
  }

  private void onError(MojoException exception) {
    close();
    ConnectionErrorHandler connectionErrorHandler = this.mErrorHandler;
    if (connectionErrorHandler != null) {
      try {
        connectionErrorHandler.onConnectionError(exception);
      } catch (RuntimeException e) {
        ExceptionHandler.DefaultExceptionHandler.getInstance().handleException(e);
      }
    }
  }

  private void readOutstandingMessages() {
    ResultAnd<Boolean> result;
    do {
      try {
        result = readAndDispatchMessage(this.mMessagePipeHandle, this.mIncomingMessageReceiver);
      } catch (MojoException e) {
        onError(e);
        return;
      }
    } while (result.getValue().booleanValue());
    if (result.getMojoResult() != 17) {
      onError(new MojoException(result.getMojoResult()));
    }
  }

  private void cancelIfActive() {
    this.mWatcher.cancel();
    this.mWatcher.destroy();
  }

  static ResultAnd<Boolean> readAndDispatchMessage(
      MessagePipeHandle handle, MessageReceiver receiver) {
    boolean accepted;
    ResultAnd<MessagePipeHandle.ReadMessageResult> result =
        handle.readMessage(MessagePipeHandle.ReadFlags.NONE);
    if (result.getMojoResult() != 0) {
      return new ResultAnd<>(result.getMojoResult(), false);
    }
    MessagePipeHandle.ReadMessageResult readResult = result.getValue();
    if (readResult == null) {
      throw new AssertionError();
    }
    if (receiver != null) {
      try {
        accepted =
            receiver.accept(new Message(ByteBuffer.wrap(readResult.mData), readResult.mHandles));
      } catch (RuntimeException e) {
        accepted = ExceptionHandler.DefaultExceptionHandler.getInstance().handleException(e);
      }
      return new ResultAnd<>(result.getMojoResult(), Boolean.valueOf(accepted));
    }
    return new ResultAnd<>(result.getMojoResult(), false);
  }
}
