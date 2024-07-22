package org.chromium.media.stable.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

class StableVideoDecoderTracker_Internal {
  public static final Interface.Manager<StableVideoDecoderTracker, StableVideoDecoderTracker.Proxy>
      MANAGER =
          new Interface.Manager<StableVideoDecoderTracker, StableVideoDecoderTracker.Proxy>() {
            @Override
            public String getName() {
              return "media.stable.mojom.StableVideoDecoderTracker";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public StableVideoDecoderTracker.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, StableVideoDecoderTracker impl) {
              return new Stub(core, impl);
            }

            @Override
            public StableVideoDecoderTracker[] buildArray(int size) {
              return new StableVideoDecoderTracker[size];
            }
          };

  StableVideoDecoderTracker_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements StableVideoDecoderTracker.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }
  }

  public static final class Stub extends Interface.Stub<StableVideoDecoderTracker> {
    Stub(Core core, StableVideoDecoderTracker impl) {
      super(core, impl);
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 0;
        if (header.hasFlag(4)) {
          flags = 0 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -2:
            return InterfaceControlMessagesHelper.handleRunOrClosePipe(
                StableVideoDecoderTracker_Internal.MANAGER, messageWithHeader);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }

    @Override
    public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 1;
        if (header.hasFlag(4)) {
          flags = 1 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -1:
            return InterfaceControlMessagesHelper.handleRun(
                getCore(), StableVideoDecoderTracker_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }
}
