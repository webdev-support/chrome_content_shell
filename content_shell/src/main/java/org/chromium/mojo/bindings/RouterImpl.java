package org.chromium.mojo.bindings;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.Watcher;

public class RouterImpl implements Router {

  private final Connector mConnector;
  private final Executor mExecutor;
  private MessageReceiverWithResponder mIncomingMessageReceiver;
  private long mNextRequestId;
  private Map<Long, MessageReceiver> mResponders;

  private class HandleIncomingMessageThunk implements MessageReceiver {
    private HandleIncomingMessageThunk() {}

    @Override
    public boolean accept(Message message) {
      return RouterImpl.this.handleIncomingMessage(message);
    }

    @Override
    public void close() {
      RouterImpl.this.handleConnectorClose();
    }
  }

  public class ResponderThunk implements MessageReceiver {
    private boolean mAcceptWasInvoked;

    ResponderThunk() {}

    @Override
    public boolean accept(Message message) {
      this.mAcceptWasInvoked = true;
      return RouterImpl.this.accept(message);
    }

    @Override
    public void close() {
      RouterImpl.this.close();
    }

    protected void finalize() throws Throwable {
      if (!this.mAcceptWasInvoked) {
        RouterImpl.this.closeOnHandleThread();
      }
      super.finalize();
    }
  }

  public RouterImpl(MessagePipeHandle messagePipeHandle) {
    this(messagePipeHandle, BindingsHelper.getWatcherForHandle(messagePipeHandle));
  }

  public RouterImpl(MessagePipeHandle messagePipeHandle, Watcher watcher) {
    this.mNextRequestId = 1L;
    this.mResponders = new HashMap();
    Connector connector = new Connector(messagePipeHandle, watcher);
    this.mConnector = connector;
    connector.setIncomingMessageReceiver(new HandleIncomingMessageThunk());
    Core core = messagePipeHandle.getCore();
    if (core != null) {
      this.mExecutor = ExecutorFactory.getExecutorForCurrentThread(core);
    } else {
      this.mExecutor = null;
    }
  }

  @Override
  public void start() {
    this.mConnector.start();
  }

  @Override
  public void setIncomingMessageReceiver(MessageReceiverWithResponder incomingMessageReceiver) {
    this.mIncomingMessageReceiver = incomingMessageReceiver;
  }

  @Override
  public boolean accept(Message message) {
    return this.mConnector.accept(message);
  }

  @Override
  public boolean acceptWithResponder(Message message, MessageReceiver responder) {
    ServiceMessage messageWithHeader = message.asServiceMessage();
    if (!messageWithHeader.getHeader().hasFlag(1)) {
      throw new AssertionError();
    }
    long requestId = this.mNextRequestId;
    long j = requestId + 1;
    this.mNextRequestId = j;
    if (requestId == 0) {
      this.mNextRequestId = 1 + j;
      requestId = j;
    }
    if (this.mResponders.containsKey(Long.valueOf(requestId))) {
      throw new IllegalStateException("Unable to find a new request identifier.");
    }
    messageWithHeader.setRequestId(requestId);
    if (!this.mConnector.accept(messageWithHeader)) {
      return false;
    }
    this.mResponders.put(Long.valueOf(requestId), responder);
    return true;
  }

  @Override
  public MessagePipeHandle passHandle() {
    return this.mConnector.passHandle();
  }

  @Override
  public void close() {
    this.mConnector.close();
  }

  @Override
  public void setErrorHandler(ConnectionErrorHandler errorHandler) {
    this.mConnector.setErrorHandler(errorHandler);
  }

  public boolean handleIncomingMessage(Message message) {
    MessageHeader header = message.asServiceMessage().getHeader();
    if (header.hasFlag(1)) {
      MessageReceiverWithResponder messageReceiverWithResponder = this.mIncomingMessageReceiver;
      if (messageReceiverWithResponder != null) {
        return messageReceiverWithResponder.acceptWithResponder(message, new ResponderThunk());
      }
      close();
      return false;
    } else if (header.hasFlag(2)) {
      long requestId = header.getRequestId();
      MessageReceiver responder = this.mResponders.get(Long.valueOf(requestId));
      if (responder == null) {
        return false;
      }
      this.mResponders.remove(Long.valueOf(requestId));
      return responder.accept(message);
    } else {
      MessageReceiver responder2 = this.mIncomingMessageReceiver;
      if (responder2 != null) {
        return responder2.accept(message);
      }
      return false;
    }
  }

  public void handleConnectorClose() {
    MessageReceiverWithResponder messageReceiverWithResponder = this.mIncomingMessageReceiver;
    if (messageReceiverWithResponder != null) {
      messageReceiverWithResponder.close();
    }
  }

  public void closeOnHandleThread() {
    Executor executor = this.mExecutor;
    if (executor != null) {
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              RouterImpl.this.close();
            }
          });
    }
  }
}
