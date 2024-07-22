package org.chromium.device.mojom;

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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

class SmartCardContextFactory_Internal {
  private static final int CREATE_CONTEXT_ORDINAL = 0;
  public static final Interface.Manager<SmartCardContextFactory, SmartCardContextFactory.Proxy>
      MANAGER =
          new Interface.Manager<SmartCardContextFactory, SmartCardContextFactory.Proxy>() {
            @Override
            public String getName() {
              return "device.mojom.SmartCardContextFactory";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SmartCardContextFactory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SmartCardContextFactory impl) {
              return new Stub(core, impl);
            }

            @Override
            public SmartCardContextFactory[] buildArray(int size) {
              return new SmartCardContextFactory[size];
            }
          };

  SmartCardContextFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SmartCardContextFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createContext(CreateContext_Response callback) {
      SmartCardContextFactoryCreateContextParams _message =
          new SmartCardContextFactoryCreateContextParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SmartCardContextFactoryCreateContextResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SmartCardContextFactory> {
    Stub(Core core, SmartCardContextFactory impl) {
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
                SmartCardContextFactory_Internal.MANAGER, messageWithHeader);
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
                getCore(), SmartCardContextFactory_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            SmartCardContextFactoryCreateContextParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createContext(
                    new SmartCardContextFactoryCreateContextResponseParamsProxyToResponder(
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

  static final class SmartCardContextFactoryCreateContextParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardContextFactoryCreateContextParams(int version) {
      super(8, version);
    }

    public SmartCardContextFactoryCreateContextParams() {
      this(0);
    }

    public static SmartCardContextFactoryCreateContextParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardContextFactoryCreateContextParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardContextFactoryCreateContextParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardContextFactoryCreateContextParams result =
            new SmartCardContextFactoryCreateContextParams(elementsOrVersion);
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

  static final class SmartCardContextFactoryCreateContextResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SmartCardCreateContextResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SmartCardContextFactoryCreateContextResponseParams(int version) {
      super(24, version);
    }

    public SmartCardContextFactoryCreateContextResponseParams() {
      this(0);
    }

    public static SmartCardContextFactoryCreateContextResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SmartCardContextFactoryCreateContextResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SmartCardContextFactoryCreateContextResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SmartCardContextFactoryCreateContextResponseParams result =
            new SmartCardContextFactoryCreateContextResponseParams(elementsOrVersion);
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

  static class SmartCardContextFactoryCreateContextResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SmartCardContextFactory.CreateContext_Response mCallback;

    SmartCardContextFactoryCreateContextResponseParamsForwardToCallback(
        SmartCardContextFactory.CreateContext_Response callback) {
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
        SmartCardContextFactoryCreateContextResponseParams response =
            SmartCardContextFactoryCreateContextResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SmartCardContextFactoryCreateContextResponseParamsProxyToResponder
      implements SmartCardContextFactory.CreateContext_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SmartCardContextFactoryCreateContextResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SmartCardCreateContextResult result) {
      SmartCardContextFactoryCreateContextResponseParams _response =
          new SmartCardContextFactoryCreateContextResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
