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

class AudioContextManager_Internal {
  private static final int AUDIO_CONTEXT_AUDIBLE_PLAYBACK_STARTED_ORDINAL = 0;
  private static final int AUDIO_CONTEXT_AUDIBLE_PLAYBACK_STOPPED_ORDINAL = 1;
  public static final Interface.Manager<AudioContextManager, AudioContextManager.Proxy> MANAGER =
      new Interface.Manager<AudioContextManager, AudioContextManager.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.AudioContextManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AudioContextManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AudioContextManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public AudioContextManager[] buildArray(int size) {
          return new AudioContextManager[size];
        }
      };

  AudioContextManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AudioContextManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void audioContextAudiblePlaybackStarted(int id) {
      AudioContextManagerAudioContextAudiblePlaybackStartedParams _message =
          new AudioContextManagerAudioContextAudiblePlaybackStartedParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void audioContextAudiblePlaybackStopped(int id) {
      AudioContextManagerAudioContextAudiblePlaybackStoppedParams _message =
          new AudioContextManagerAudioContextAudiblePlaybackStoppedParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioContextManager> {
    Stub(Core core, AudioContextManager impl) {
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
                AudioContextManager_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AudioContextManagerAudioContextAudiblePlaybackStartedParams data =
                AudioContextManagerAudioContextAudiblePlaybackStartedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().audioContextAudiblePlaybackStarted(data.id);
            return true;
          case 1:
            AudioContextManagerAudioContextAudiblePlaybackStoppedParams data2 =
                AudioContextManagerAudioContextAudiblePlaybackStoppedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().audioContextAudiblePlaybackStopped(data2.id);
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
                getCore(), AudioContextManager_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioContextManagerAudioContextAudiblePlaybackStartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioContextManagerAudioContextAudiblePlaybackStartedParams(int version) {
      super(16, version);
    }

    public AudioContextManagerAudioContextAudiblePlaybackStartedParams() {
      this(0);
    }

    public static AudioContextManagerAudioContextAudiblePlaybackStartedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AudioContextManagerAudioContextAudiblePlaybackStartedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioContextManagerAudioContextAudiblePlaybackStartedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioContextManagerAudioContextAudiblePlaybackStartedParams result =
            new AudioContextManagerAudioContextAudiblePlaybackStartedParams(elementsOrVersion);
        result.id = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.id, 8);
    }
  }

  static final class AudioContextManagerAudioContextAudiblePlaybackStoppedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioContextManagerAudioContextAudiblePlaybackStoppedParams(int version) {
      super(16, version);
    }

    public AudioContextManagerAudioContextAudiblePlaybackStoppedParams() {
      this(0);
    }

    public static AudioContextManagerAudioContextAudiblePlaybackStoppedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AudioContextManagerAudioContextAudiblePlaybackStoppedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioContextManagerAudioContextAudiblePlaybackStoppedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioContextManagerAudioContextAudiblePlaybackStoppedParams result =
            new AudioContextManagerAudioContextAudiblePlaybackStoppedParams(elementsOrVersion);
        result.id = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.id, 8);
    }
  }
}
