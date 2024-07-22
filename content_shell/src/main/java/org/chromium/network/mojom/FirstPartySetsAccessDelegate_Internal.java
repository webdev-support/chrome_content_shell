package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class FirstPartySetsAccessDelegate_Internal {
  public static final Interface.Manager<
          FirstPartySetsAccessDelegate, FirstPartySetsAccessDelegate.Proxy>
      MANAGER =
          new Interface.Manager<
              FirstPartySetsAccessDelegate, FirstPartySetsAccessDelegate.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.FirstPartySetsAccessDelegate";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FirstPartySetsAccessDelegate.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FirstPartySetsAccessDelegate impl) {
              return new Stub(core, impl);
            }

            @Override
            public FirstPartySetsAccessDelegate[] buildArray(int size) {
              return new FirstPartySetsAccessDelegate[size];
            }
          };
  private static final int NOTIFY_READY_ORDINAL = 0;
  private static final int SET_ENABLED_ORDINAL = 1;

  FirstPartySetsAccessDelegate_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FirstPartySetsAccessDelegate.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void notifyReady(FirstPartySetsReadyEvent readyEvent) {
      FirstPartySetsAccessDelegateNotifyReadyParams _message =
          new FirstPartySetsAccessDelegateNotifyReadyParams();
      _message.readyEvent = readyEvent;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setEnabled(boolean enabled) {
      FirstPartySetsAccessDelegateSetEnabledParams _message =
          new FirstPartySetsAccessDelegateSetEnabledParams();
      _message.enabled = enabled;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<FirstPartySetsAccessDelegate> {
    Stub(Core core, FirstPartySetsAccessDelegate impl) {
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
                FirstPartySetsAccessDelegate_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            FirstPartySetsAccessDelegateNotifyReadyParams data =
                FirstPartySetsAccessDelegateNotifyReadyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().notifyReady(data.readyEvent);
            return true;
          case 1:
            FirstPartySetsAccessDelegateSetEnabledParams data2 =
                FirstPartySetsAccessDelegateSetEnabledParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setEnabled(data2.enabled);
            return true;
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
                getCore(),
                FirstPartySetsAccessDelegate_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FirstPartySetsAccessDelegateNotifyReadyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FirstPartySetsReadyEvent readyEvent;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FirstPartySetsAccessDelegateNotifyReadyParams(int version) {
      super(16, version);
    }

    public FirstPartySetsAccessDelegateNotifyReadyParams() {
      this(0);
    }

    public static FirstPartySetsAccessDelegateNotifyReadyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FirstPartySetsAccessDelegateNotifyReadyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FirstPartySetsAccessDelegateNotifyReadyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FirstPartySetsAccessDelegateNotifyReadyParams result =
            new FirstPartySetsAccessDelegateNotifyReadyParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.readyEvent = FirstPartySetsReadyEvent.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.readyEvent, 8, false);
    }
  }

  static final class FirstPartySetsAccessDelegateSetEnabledParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean enabled;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FirstPartySetsAccessDelegateSetEnabledParams(int version) {
      super(16, version);
    }

    public FirstPartySetsAccessDelegateSetEnabledParams() {
      this(0);
    }

    public static FirstPartySetsAccessDelegateSetEnabledParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FirstPartySetsAccessDelegateSetEnabledParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FirstPartySetsAccessDelegateSetEnabledParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FirstPartySetsAccessDelegateSetEnabledParams result =
            new FirstPartySetsAccessDelegateSetEnabledParams(elementsOrVersion);
        result.enabled = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.enabled, 8, 0);
    }
  }
}
