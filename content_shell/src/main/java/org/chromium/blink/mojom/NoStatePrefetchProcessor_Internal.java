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

class NoStatePrefetchProcessor_Internal {
  private static final int CANCEL_ORDINAL = 1;
  public static final Interface.Manager<NoStatePrefetchProcessor, NoStatePrefetchProcessor.Proxy>
      MANAGER =
          new Interface.Manager<NoStatePrefetchProcessor, NoStatePrefetchProcessor.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.NoStatePrefetchProcessor";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public NoStatePrefetchProcessor.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, NoStatePrefetchProcessor impl) {
              return new Stub(core, impl);
            }

            @Override
            public NoStatePrefetchProcessor[] buildArray(int size) {
              return new NoStatePrefetchProcessor[size];
            }
          };
  private static final int START_ORDINAL = 0;

  NoStatePrefetchProcessor_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements NoStatePrefetchProcessor.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void start(PrerenderAttributes prerenderAttribute) {
      NoStatePrefetchProcessorStartParams _message = new NoStatePrefetchProcessorStartParams();
      _message.prerenderAttribute = prerenderAttribute;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void cancel() {
      NoStatePrefetchProcessorCancelParams _message = new NoStatePrefetchProcessorCancelParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<NoStatePrefetchProcessor> {
    Stub(Core core, NoStatePrefetchProcessor impl) {
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
                NoStatePrefetchProcessor_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            NoStatePrefetchProcessorStartParams data =
                NoStatePrefetchProcessorStartParams.deserialize(messageWithHeader.getPayload());
            getImpl().start(data.prerenderAttribute);
            return true;
          case 1:
            NoStatePrefetchProcessorCancelParams.deserialize(messageWithHeader.getPayload());
            getImpl().cancel();
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
                getCore(), NoStatePrefetchProcessor_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class NoStatePrefetchProcessorStartParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PrerenderAttributes prerenderAttribute;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NoStatePrefetchProcessorStartParams(int version) {
      super(16, version);
    }

    public NoStatePrefetchProcessorStartParams() {
      this(0);
    }

    public static NoStatePrefetchProcessorStartParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NoStatePrefetchProcessorStartParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NoStatePrefetchProcessorStartParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NoStatePrefetchProcessorStartParams result =
            new NoStatePrefetchProcessorStartParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.prerenderAttribute = PrerenderAttributes.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.prerenderAttribute, 8, false);
    }
  }

  static final class NoStatePrefetchProcessorCancelParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private NoStatePrefetchProcessorCancelParams(int version) {
      super(8, version);
    }

    public NoStatePrefetchProcessorCancelParams() {
      this(0);
    }

    public static NoStatePrefetchProcessorCancelParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static NoStatePrefetchProcessorCancelParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static NoStatePrefetchProcessorCancelParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        NoStatePrefetchProcessorCancelParams result =
            new NoStatePrefetchProcessorCancelParams(elementsOrVersion);
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
}
