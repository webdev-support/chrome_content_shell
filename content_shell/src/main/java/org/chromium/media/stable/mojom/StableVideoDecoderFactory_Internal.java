package org.chromium.media.stable.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class StableVideoDecoderFactory_Internal {
  private static final int CREATE_STABLE_VIDEO_DECODER_ORDINAL = 0;
  public static final Interface.Manager<StableVideoDecoderFactory, StableVideoDecoderFactory.Proxy>
      MANAGER =
          new Interface.Manager<StableVideoDecoderFactory, StableVideoDecoderFactory.Proxy>() {
            @Override
            public String getName() {
              return "media.stable.mojom.StableVideoDecoderFactory";
            }

            @Override
            public int getVersion() {
              return 1;
            }

            @Override
            public StableVideoDecoderFactory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, StableVideoDecoderFactory impl) {
              return new Stub(core, impl);
            }

            @Override
            public StableVideoDecoderFactory[] buildArray(int size) {
              return new StableVideoDecoderFactory[size];
            }
          };

  StableVideoDecoderFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements StableVideoDecoderFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createStableVideoDecoder(
        InterfaceRequest<StableVideoDecoder> receiver, StableVideoDecoderTracker tracker) {
      StableVideoDecoderFactoryCreateStableVideoDecoderParams _message =
          new StableVideoDecoderFactoryCreateStableVideoDecoderParams();
      _message.receiver = receiver;
      _message.tracker = tracker;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<StableVideoDecoderFactory> {
    Stub(Core core, StableVideoDecoderFactory impl) {
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
                StableVideoDecoderFactory_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            StableVideoDecoderFactoryCreateStableVideoDecoderParams data =
                StableVideoDecoderFactoryCreateStableVideoDecoderParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createStableVideoDecoder(data.receiver, data.tracker);
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
                getCore(), StableVideoDecoderFactory_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class StableVideoDecoderFactoryCreateStableVideoDecoderParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<StableVideoDecoder> receiver;
    public StableVideoDecoderTracker tracker;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0), new DataHeader(24, 1)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[1];
    }

    private StableVideoDecoderFactoryCreateStableVideoDecoderParams(int version) {
      super(24, version);
    }

    public StableVideoDecoderFactoryCreateStableVideoDecoderParams() {
      this(1);
    }

    public static StableVideoDecoderFactoryCreateStableVideoDecoderParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static StableVideoDecoderFactoryCreateStableVideoDecoderParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static StableVideoDecoderFactoryCreateStableVideoDecoderParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        StableVideoDecoderFactoryCreateStableVideoDecoderParams result =
            new StableVideoDecoderFactoryCreateStableVideoDecoderParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        if (elementsOrVersion >= 1) {
          result.tracker =
              (StableVideoDecoderTracker)
                  decoder0.readServiceInterface(12, true, StableVideoDecoderTracker.MANAGER);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
      encoder0.encode(this.tracker, 12, true, StableVideoDecoderTracker.MANAGER);
    }
  }
}
