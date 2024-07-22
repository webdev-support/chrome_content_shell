package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.AudioParameters;
import org.chromium.media.mojom.AudioProcessingConfig;
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
import org.chromium.mojo_base.mojom.UnguessableToken;

class RendererAudioInputStreamFactory_Internal {
  private static final int ASSOCIATE_INPUT_AND_OUTPUT_FOR_AEC_ORDINAL = 1;
  private static final int CREATE_STREAM_ORDINAL = 0;
  public static final Interface.Manager<
          RendererAudioInputStreamFactory, RendererAudioInputStreamFactory.Proxy>
      MANAGER =
          new Interface.Manager<
              RendererAudioInputStreamFactory, RendererAudioInputStreamFactory.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.RendererAudioInputStreamFactory";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public RendererAudioInputStreamFactory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, RendererAudioInputStreamFactory impl) {
              return new Stub(core, impl);
            }

            @Override
            public RendererAudioInputStreamFactory[] buildArray(int size) {
              return new RendererAudioInputStreamFactory[size];
            }
          };

  RendererAudioInputStreamFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements RendererAudioInputStreamFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createStream(
        RendererAudioInputStreamFactoryClient client,
        UnguessableToken sessionId,
        AudioParameters params,
        boolean automaticGainControl,
        int sharedMemoryCount,
        AudioProcessingConfig processingConfig) {
      RendererAudioInputStreamFactoryCreateStreamParams _message =
          new RendererAudioInputStreamFactoryCreateStreamParams();
      _message.client = client;
      _message.sessionId = sessionId;
      _message.params = params;
      _message.automaticGainControl = automaticGainControl;
      _message.sharedMemoryCount = sharedMemoryCount;
      _message.processingConfig = processingConfig;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void associateInputAndOutputForAec(
        UnguessableToken inputStreamId, String outputDeviceId) {
      RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams _message =
          new RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams();
      _message.inputStreamId = inputStreamId;
      _message.outputDeviceId = outputDeviceId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<RendererAudioInputStreamFactory> {
    Stub(Core core, RendererAudioInputStreamFactory impl) {
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
                RendererAudioInputStreamFactory_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            RendererAudioInputStreamFactoryCreateStreamParams data =
                RendererAudioInputStreamFactoryCreateStreamParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createStream(
                    data.client,
                    data.sessionId,
                    data.params,
                    data.automaticGainControl,
                    data.sharedMemoryCount,
                    data.processingConfig);
            return true;
          case 1:
            RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams data2 =
                RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().associateInputAndOutputForAec(data2.inputStreamId, data2.outputDeviceId);
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
                RendererAudioInputStreamFactory_Internal.MANAGER,
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

  static final class RendererAudioInputStreamFactoryCreateStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean automaticGainControl;
    public RendererAudioInputStreamFactoryClient client;
    public AudioParameters params;
    public AudioProcessingConfig processingConfig;
    public UnguessableToken sessionId;
    public int sharedMemoryCount;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RendererAudioInputStreamFactoryCreateStreamParams(int version) {
      super(48, version);
    }

    public RendererAudioInputStreamFactoryCreateStreamParams() {
      this(0);
    }

    public static RendererAudioInputStreamFactoryCreateStreamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RendererAudioInputStreamFactoryCreateStreamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RendererAudioInputStreamFactoryCreateStreamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RendererAudioInputStreamFactoryCreateStreamParams result =
            new RendererAudioInputStreamFactoryCreateStreamParams(elementsOrVersion);
        result.client =
            (RendererAudioInputStreamFactoryClient)
                decoder0.readServiceInterface(
                    8, false, RendererAudioInputStreamFactoryClient.MANAGER);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.sessionId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.params = AudioParameters.decode(decoder12);
        result.automaticGainControl = decoder0.readBoolean(32, 0);
        result.sharedMemoryCount = decoder0.readInt(36);
        Decoder decoder13 = decoder0.readPointer(40, true);
        result.processingConfig = AudioProcessingConfig.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false, RendererAudioInputStreamFactoryClient.MANAGER);
      encoder0.encode((Struct) this.sessionId, 16, false);
      encoder0.encode((Struct) this.params, 24, false);
      encoder0.encode(this.automaticGainControl, 32, 0);
      encoder0.encode(this.sharedMemoryCount, 36);
      encoder0.encode((Struct) this.processingConfig, 40, true);
    }
  }

  static final class RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken inputStreamId;
    public String outputDeviceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams(int version) {
      super(24, version);
    }

    public RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams() {
      this(0);
    }

    public static RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams result =
            new RendererAudioInputStreamFactoryAssociateInputAndOutputForAecParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.inputStreamId = UnguessableToken.decode(decoder1);
        result.outputDeviceId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.inputStreamId, 8, false);
      encoder0.encode(this.outputDeviceId, 16, false);
    }
  }
}
