package org.chromium.media.mojom;

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

class AudioLogFactory_Internal {
  private static final int CREATE_AUDIO_LOG_ORDINAL = 0;
  public static final Interface.Manager<AudioLogFactory, AudioLogFactory.Proxy> MANAGER =
      new Interface.Manager<AudioLogFactory, AudioLogFactory.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.AudioLogFactory";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AudioLogFactory.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AudioLogFactory impl) {
          return new Stub(core, impl);
        }

        @Override
        public AudioLogFactory[] buildArray(int size) {
          return new AudioLogFactory[size];
        }
      };

  AudioLogFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements AudioLogFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createAudioLog(
        int component, int componentId, InterfaceRequest<AudioLog> audioLogReceiver) {
      AudioLogFactoryCreateAudioLogParams _message = new AudioLogFactoryCreateAudioLogParams();
      _message.component = component;
      _message.componentId = componentId;
      _message.audioLogReceiver = audioLogReceiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioLogFactory> {
    Stub(Core core, AudioLogFactory impl) {
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
                AudioLogFactory_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AudioLogFactoryCreateAudioLogParams data =
                AudioLogFactoryCreateAudioLogParams.deserialize(messageWithHeader.getPayload());
            getImpl().createAudioLog(data.component, data.componentId, data.audioLogReceiver);
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
                getCore(), AudioLogFactory_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioLogFactoryCreateAudioLogParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<AudioLog> audioLogReceiver;
    public int component;
    public int componentId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioLogFactoryCreateAudioLogParams(int version) {
      super(24, version);
    }

    public AudioLogFactoryCreateAudioLogParams() {
      this(0);
    }

    public static AudioLogFactoryCreateAudioLogParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioLogFactoryCreateAudioLogParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioLogFactoryCreateAudioLogParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioLogFactoryCreateAudioLogParams result =
            new AudioLogFactoryCreateAudioLogParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.component = readInt;
        AudioLogComponent.validate(readInt);
        result.component = AudioLogComponent.toKnownValue(result.component);
        result.componentId = decoder0.readInt(12);
        result.audioLogReceiver = decoder0.readInterfaceRequest(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.component, 8);
      encoder0.encode(this.componentId, 12);
      encoder0.encode((InterfaceRequest) this.audioLogReceiver, 16, false);
    }
  }
}
