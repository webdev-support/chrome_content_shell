package org.chromium.media.mojom;

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

class AudioEncoderClient_Internal {
  public static final Interface.Manager<AudioEncoderClient, AudioEncoderClient.Proxy> MANAGER =
      new Interface.Manager<AudioEncoderClient, AudioEncoderClient.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.AudioEncoderClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AudioEncoderClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AudioEncoderClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public AudioEncoderClient[] buildArray(int size) {
          return new AudioEncoderClient[size];
        }
      };
  private static final int ON_ENCODED_BUFFER_READY_ORDINAL = 0;

  AudioEncoderClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AudioEncoderClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onEncodedBufferReady(EncodedAudioBuffer buffer, byte[] description) {
      AudioEncoderClientOnEncodedBufferReadyParams _message =
          new AudioEncoderClientOnEncodedBufferReadyParams();
      _message.buffer = buffer;
      _message.description = description;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioEncoderClient> {
    Stub(Core core, AudioEncoderClient impl) {
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
                AudioEncoderClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AudioEncoderClientOnEncodedBufferReadyParams data =
                AudioEncoderClientOnEncodedBufferReadyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onEncodedBufferReady(data.buffer, data.description);
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
                getCore(), AudioEncoderClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioEncoderClientOnEncodedBufferReadyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public EncodedAudioBuffer buffer;
    public byte[] description;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioEncoderClientOnEncodedBufferReadyParams(int version) {
      super(24, version);
    }

    public AudioEncoderClientOnEncodedBufferReadyParams() {
      this(0);
    }

    public static AudioEncoderClientOnEncodedBufferReadyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioEncoderClientOnEncodedBufferReadyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioEncoderClientOnEncodedBufferReadyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioEncoderClientOnEncodedBufferReadyParams result =
            new AudioEncoderClientOnEncodedBufferReadyParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.buffer = EncodedAudioBuffer.decode(decoder1);
        result.description = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.buffer, 8, false);
      encoder0.encode(this.description, 16, 0, -1);
    }
  }
}
