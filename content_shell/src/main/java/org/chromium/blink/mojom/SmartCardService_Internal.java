package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.SmartCardCreateContextResult;
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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

class SmartCardService_Internal {
  private static final int CREATE_CONTEXT_ORDINAL = 0;
  public static final Interface.Manager<SmartCardService, SmartCardService.Proxy> MANAGER =
      new Interface.Manager<SmartCardService, SmartCardService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.SmartCardService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SmartCardService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SmartCardService impl) {
          return new Stub(core, impl);
        }

        @Override
        public SmartCardService[] buildArray(int size) {
          return new SmartCardService[size];
        }
      };

  SmartCardService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SmartCardService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createContext(CreateContext_Response callback) {
      SmartCardServiceCreateContextParams _message = new SmartCardServiceCreateContextParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SmartCardServiceCreateContextResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SmartCardService> {
    Stub(Core core, SmartCardService impl) {
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
                SmartCardService_Internal.MANAGER, messageWithHeader);
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
                getCore(), SmartCardService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            SmartCardServiceCreateContextParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createContext(
                    new SmartCardServiceCreateContextResponseParamsProxyToResponder(
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

  static final class SmartCardServiceCreateContextParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardServiceCreateContextParams(int version) {
      super(8, version);
    }

    public SmartCardServiceCreateContextParams() {
      this(0);
    }

    public static SmartCardServiceCreateContextParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardServiceCreateContextParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardServiceCreateContextParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardServiceCreateContextParams result =
            new SmartCardServiceCreateContextParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class SmartCardServiceCreateContextResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardCreateContextResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardServiceCreateContextResponseParams(int version) {
      super(24, version);
    }

    public SmartCardServiceCreateContextResponseParams() {
      this(0);
    }

    public static SmartCardServiceCreateContextResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardServiceCreateContextResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardServiceCreateContextResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardServiceCreateContextResponseParams result =
            new SmartCardServiceCreateContextResponseParams(elementsOrVersion);
        result.result = SmartCardCreateContextResult.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.result, 8, false);
    }
  }

  static class SmartCardServiceCreateContextResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardService.CreateContext_Response mCallback;

    SmartCardServiceCreateContextResponseParamsForwardToCallback(
        SmartCardService.CreateContext_Response callback) {
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
        SmartCardServiceCreateContextResponseParams response =
            SmartCardServiceCreateContextResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardServiceCreateContextResponseParamsProxyToResponder
      implements SmartCardService.CreateContext_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardServiceCreateContextResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardCreateContextResult result) {
      SmartCardServiceCreateContextResponseParams _response =
          new SmartCardServiceCreateContextResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
