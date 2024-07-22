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

class AudioOutputStream_Internal {
  private static final int FLUSH_ORDINAL = 2;
  public static final Interface.Manager<AudioOutputStream, AudioOutputStream.Proxy> MANAGER =
      new Interface.Manager<AudioOutputStream, AudioOutputStream.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.AudioOutputStream";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AudioOutputStream.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AudioOutputStream impl) {
          return new Stub(core, impl);
        }

        @Override
        public AudioOutputStream[] buildArray(int size) {
          return new AudioOutputStream[size];
        }
      };
  private static final int PAUSE_ORDINAL = 1;
  private static final int PLAY_ORDINAL = 0;
  private static final int SET_VOLUME_ORDINAL = 3;

  AudioOutputStream_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AudioOutputStream.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void play() {
      AudioOutputStreamPlayParams _message = new AudioOutputStreamPlayParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void pause() {
      AudioOutputStreamPauseParams _message = new AudioOutputStreamPauseParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void flush() {
      AudioOutputStreamFlushParams _message = new AudioOutputStreamFlushParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void setVolume(double volume) {
      AudioOutputStreamSetVolumeParams _message = new AudioOutputStreamSetVolumeParams();
      _message.volume = volume;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioOutputStream> {
    Stub(Core core, AudioOutputStream impl) {
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
                AudioOutputStream_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AudioOutputStreamPlayParams.deserialize(messageWithHeader.getPayload());
            getImpl().play();
            return true;
          case 1:
            AudioOutputStreamPauseParams.deserialize(messageWithHeader.getPayload());
            getImpl().pause();
            return true;
          case 2:
            AudioOutputStreamFlushParams.deserialize(messageWithHeader.getPayload());
            getImpl().flush();
            return true;
          case 3:
            AudioOutputStreamSetVolumeParams data =
                AudioOutputStreamSetVolumeParams.deserialize(messageWithHeader.getPayload());
            getImpl().setVolume(data.volume);
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
                getCore(), AudioOutputStream_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioOutputStreamPlayParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioOutputStreamPlayParams(int version) {
      super(8, version);
    }

    public AudioOutputStreamPlayParams() {
      this(0);
    }

    public static AudioOutputStreamPlayParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioOutputStreamPlayParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioOutputStreamPlayParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioOutputStreamPlayParams result = new AudioOutputStreamPlayParams(elementsOrVersion);
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

  static final class AudioOutputStreamPauseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioOutputStreamPauseParams(int version) {
      super(8, version);
    }

    public AudioOutputStreamPauseParams() {
      this(0);
    }

    public static AudioOutputStreamPauseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioOutputStreamPauseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioOutputStreamPauseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioOutputStreamPauseParams result = new AudioOutputStreamPauseParams(elementsOrVersion);
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

  static final class AudioOutputStreamFlushParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioOutputStreamFlushParams(int version) {
      super(8, version);
    }

    public AudioOutputStreamFlushParams() {
      this(0);
    }

    public static AudioOutputStreamFlushParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioOutputStreamFlushParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioOutputStreamFlushParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioOutputStreamFlushParams result = new AudioOutputStreamFlushParams(elementsOrVersion);
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

  static final class AudioOutputStreamSetVolumeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public double volume;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioOutputStreamSetVolumeParams(int version) {
      super(16, version);
    }

    public AudioOutputStreamSetVolumeParams() {
      this(0);
    }

    public static AudioOutputStreamSetVolumeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioOutputStreamSetVolumeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioOutputStreamSetVolumeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioOutputStreamSetVolumeParams result =
            new AudioOutputStreamSetVolumeParams(elementsOrVersion);
        result.volume = decoder0.readDouble(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.volume, 8);
    }
  }
}
