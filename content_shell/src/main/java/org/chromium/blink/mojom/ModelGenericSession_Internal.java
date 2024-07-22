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

class ModelGenericSession_Internal {
  private static final int EXECUTE_ORDINAL = 0;
  public static final Interface.Manager<ModelGenericSession, ModelGenericSession.Proxy> MANAGER =
      new Interface.Manager<ModelGenericSession, ModelGenericSession.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ModelGenericSession";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ModelGenericSession.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ModelGenericSession impl) {
          return new Stub(core, impl);
        }

        @Override
        public ModelGenericSession[] buildArray(int size) {
          return new ModelGenericSession[size];
        }
      };

  ModelGenericSession_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ModelGenericSession.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void execute(String input, ModelStreamingResponder responder) {
      ModelGenericSessionExecuteParams _message = new ModelGenericSessionExecuteParams();
      _message.input = input;
      _message.responder = responder;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<ModelGenericSession> {
    Stub(Core core, ModelGenericSession impl) {
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
                ModelGenericSession_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ModelGenericSessionExecuteParams data =
                ModelGenericSessionExecuteParams.deserialize(messageWithHeader.getPayload());
            getImpl().execute(data.input, data.responder);
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
                getCore(), ModelGenericSession_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ModelGenericSessionExecuteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String input;
    public ModelStreamingResponder responder;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ModelGenericSessionExecuteParams(int version) {
      super(24, version);
    }

    public ModelGenericSessionExecuteParams() {
      this(0);
    }

    public static ModelGenericSessionExecuteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ModelGenericSessionExecuteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ModelGenericSessionExecuteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ModelGenericSessionExecuteParams result =
            new ModelGenericSessionExecuteParams(elementsOrVersion);
        result.input = decoder0.readString(8, false);
        result.responder =
            (ModelStreamingResponder)
                decoder0.readServiceInterface(16, false, ModelStreamingResponder.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.input, 8, false);
      encoder0.encode(this.responder, 16, false, ModelStreamingResponder.MANAGER);
    }
  }
}
