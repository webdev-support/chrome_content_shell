package org.chromium.mojo.bindings;

public interface MessageReceiverWithResponder extends MessageReceiver {
  boolean acceptWithResponder(Message message, MessageReceiver messageReceiver);
}
