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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class ModelStreamingResponder_Internal {
  public static final Interface.Manager<ModelStreamingResponder, ModelStreamingResponder.Proxy>
      MANAGER =
          new Interface.Manager<ModelStreamingResponder, ModelStreamingResponder.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ModelStreamingResponder";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ModelStreamingResponder.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ModelStreamingResponder impl) {
              return new Stub(core, impl);
            }

            @Override
            public ModelStreamingResponder[] buildArray(int size) {
              return new ModelStreamingResponder[size];
            }
          };
  private static final int ON_RESPONSE_ORDINAL = 0;

  ModelStreamingResponder_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ModelStreamingResponder.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onResponse(int status, String text) {
      ModelStreamingResponderOnResponseParams _message =
          new ModelStreamingResponderOnResponseParams();
      _message.status = status;
      _message.text = text;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<ModelStreamingResponder> {
    Stub(Core core, ModelStreamingResponder impl) {
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
                ModelStreamingResponder_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ModelStreamingResponderOnResponseParams data =
                ModelStreamingResponderOnResponseParams.deserialize(messageWithHeader.getPayload());
            getImpl().onResponse(data.status, data.text);
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
                getCore(), ModelStreamingResponder_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ModelStreamingResponderOnResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;
    public String text;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ModelStreamingResponderOnResponseParams(int version) {
      super(24, version);
    }

    public ModelStreamingResponderOnResponseParams() {
      this(0);
    }

    public static ModelStreamingResponderOnResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ModelStreamingResponderOnResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ModelStreamingResponderOnResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ModelStreamingResponderOnResponseParams result =
            new ModelStreamingResponderOnResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        ModelStreamingResponseStatus.validate(readInt);
        result.status = ModelStreamingResponseStatus.toKnownValue(result.status);
        result.text = decoder0.readString(16, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode(this.text, 16, true);
    }
  }
}
