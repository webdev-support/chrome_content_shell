package org.chromium.blink.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class InnerTextAgent_Internal {
  private static final int GET_INNER_TEXT_ORDINAL = 0;
  public static final Interface.Manager<InnerTextAgent, InnerTextAgent.Proxy> MANAGER =
      new Interface.Manager<InnerTextAgent, InnerTextAgent.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.InnerTextAgent";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public InnerTextAgent.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, InnerTextAgent impl) {
          return new Stub(core, impl);
        }

        @Override
        public InnerTextAgent[] buildArray(int size) {
          return new InnerTextAgent[size];
        }
      };

  InnerTextAgent_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements InnerTextAgent.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getInnerText(InnerTextParams params, GetInnerText_Response callback) {
      InnerTextAgentGetInnerTextParams _message = new InnerTextAgentGetInnerTextParams();
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new InnerTextAgentGetInnerTextResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<InnerTextAgent> {
    Stub(Core core, InnerTextAgent impl) {
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
                InnerTextAgent_Internal.MANAGER, messageWithHeader);
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
                getCore(), InnerTextAgent_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            InnerTextAgentGetInnerTextParams data =
                InnerTextAgentGetInnerTextParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getInnerText(
                    data.params,
                    new InnerTextAgentGetInnerTextResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class InnerTextAgentGetInnerTextParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InnerTextParams params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private InnerTextAgentGetInnerTextParams(int version) {
      super(16, version);
    }

    public InnerTextAgentGetInnerTextParams() {
      this(0);
    }

    public static InnerTextAgentGetInnerTextParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static InnerTextAgentGetInnerTextParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static InnerTextAgentGetInnerTextParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        InnerTextAgentGetInnerTextParams result =
            new InnerTextAgentGetInnerTextParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = InnerTextParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.params, 8, false);
    }
  }

  static final class InnerTextAgentGetInnerTextResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InnerTextFrame frame;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private InnerTextAgentGetInnerTextResponseParams(int version) {
      super(16, version);
    }

    public InnerTextAgentGetInnerTextResponseParams() {
      this(0);
    }

    public static InnerTextAgentGetInnerTextResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static InnerTextAgentGetInnerTextResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static InnerTextAgentGetInnerTextResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        InnerTextAgentGetInnerTextResponseParams result =
            new InnerTextAgentGetInnerTextResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.frame = InnerTextFrame.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.frame, 8, false);
    }
  }

  static class InnerTextAgentGetInnerTextResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final InnerTextAgent.GetInnerText_Response mCallback;

    InnerTextAgentGetInnerTextResponseParamsForwardToCallback(
        InnerTextAgent.GetInnerText_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 2)) {
          return false;
        }
        InnerTextAgentGetInnerTextResponseParams response =
            InnerTextAgentGetInnerTextResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.frame);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class InnerTextAgentGetInnerTextResponseParamsProxyToResponder
      implements InnerTextAgent.GetInnerText_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    InnerTextAgentGetInnerTextResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(InnerTextFrame frame) {
      InnerTextAgentGetInnerTextResponseParams _response =
          new InnerTextAgentGetInnerTextResponseParams();
      _response.frame = frame;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
