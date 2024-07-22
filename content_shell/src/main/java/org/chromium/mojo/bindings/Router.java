package org.chromium.mojo.bindings;

import org.chromium.mojo.system.MessagePipeHandle;

public interface Router extends MessageReceiverWithResponder, HandleOwner<MessagePipeHandle> {
  void setErrorHandler(ConnectionErrorHandler connectionErrorHandler);

  void setIncomingMessageReceiver(MessageReceiverWithResponder messageReceiverWithResponder);

  void start();
}
