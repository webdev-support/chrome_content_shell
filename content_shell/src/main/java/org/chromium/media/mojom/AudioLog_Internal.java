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

class AudioLog_Internal {
  public static final Interface.Manager<AudioLog, AudioLog.Proxy> MANAGER =
      new Interface.Manager<AudioLog, AudioLog.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.AudioLog";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AudioLog.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AudioLog impl) {
          return new Stub(core, impl);
        }

        @Override
        public AudioLog[] buildArray(int size) {
          return new AudioLog[size];
        }
      };
  private static final int ON_CLOSED_ORDINAL = 3;
  private static final int ON_CREATED_ORDINAL = 0;
  private static final int ON_ERROR_ORDINAL = 4;
  private static final int ON_LOG_MESSAGE_ORDINAL = 7;
  private static final int ON_PROCESSING_STATE_CHANGED_ORDINAL = 6;
  private static final int ON_SET_VOLUME_ORDINAL = 5;
  private static final int ON_STARTED_ORDINAL = 1;
  private static final int ON_STOPPED_ORDINAL = 2;

  AudioLog_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements AudioLog.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onCreated(AudioParameters params, String deviceId) {
      AudioLogOnCreatedParams _message = new AudioLogOnCreatedParams();
      _message.params = params;
      _message.deviceId = deviceId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onStarted() {
      AudioLogOnStartedParams _message = new AudioLogOnStartedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onStopped() {
      AudioLogOnStoppedParams _message = new AudioLogOnStoppedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onClosed() {
      AudioLogOnClosedParams _message = new AudioLogOnClosedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onError() {
      AudioLogOnErrorParams _message = new AudioLogOnErrorParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onSetVolume(double volume) {
      AudioLogOnSetVolumeParams _message = new AudioLogOnSetVolumeParams();
      _message.volume = volume;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void onProcessingStateChanged(String message) {
      AudioLogOnProcessingStateChangedParams _message =
          new AudioLogOnProcessingStateChangedParams();
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void onLogMessage(String message) {
      AudioLogOnLogMessageParams _message = new AudioLogOnLogMessageParams();
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioLog> {
    Stub(Core core, AudioLog impl) {
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
                AudioLog_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AudioLogOnCreatedParams data =
                AudioLogOnCreatedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onCreated(data.params, data.deviceId);
            return true;
          case 1:
            AudioLogOnStartedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onStarted();
            return true;
          case 2:
            AudioLogOnStoppedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onStopped();
            return true;
          case 3:
            AudioLogOnClosedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onClosed();
            return true;
          case 4:
            AudioLogOnErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().onError();
            return true;
          case 5:
            getImpl()
                .onSetVolume(
                    AudioLogOnSetVolumeParams.deserialize(messageWithHeader.getPayload()).volume);
            return true;
          case 6:
            getImpl()
                .onProcessingStateChanged(
                    AudioLogOnProcessingStateChangedParams.deserialize(
                            messageWithHeader.getPayload())
                        .message);
            return true;
          case 7:
            getImpl()
                .onLogMessage(
                    AudioLogOnLogMessageParams.deserialize(messageWithHeader.getPayload()).message);
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
                getCore(), AudioLog_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioLogOnCreatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String deviceId;
    public AudioParameters params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioLogOnCreatedParams(int version) {
      super(24, version);
    }

    public AudioLogOnCreatedParams() {
      this(0);
    }

    public static AudioLogOnCreatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioLogOnCreatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioLogOnCreatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioLogOnCreatedParams result = new AudioLogOnCreatedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = AudioParameters.decode(decoder1);
        result.deviceId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.params, 8, false);
      encoder0.encode(this.deviceId, 16, false);
    }
  }

  static final class AudioLogOnStartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioLogOnStartedParams(int version) {
      super(8, version);
    }

    public AudioLogOnStartedParams() {
      this(0);
    }

    public static AudioLogOnStartedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioLogOnStartedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioLogOnStartedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioLogOnStartedParams result = new AudioLogOnStartedParams(elementsOrVersion);
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

  static final class AudioLogOnStoppedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioLogOnStoppedParams(int version) {
      super(8, version);
    }

    public AudioLogOnStoppedParams() {
      this(0);
    }

    public static AudioLogOnStoppedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioLogOnStoppedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioLogOnStoppedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioLogOnStoppedParams result = new AudioLogOnStoppedParams(elementsOrVersion);
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

  static final class AudioLogOnClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioLogOnClosedParams(int version) {
      super(8, version);
    }

    public AudioLogOnClosedParams() {
      this(0);
    }

    public static AudioLogOnClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioLogOnClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioLogOnClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioLogOnClosedParams result = new AudioLogOnClosedParams(elementsOrVersion);
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

  static final class AudioLogOnErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioLogOnErrorParams(int version) {
      super(8, version);
    }

    public AudioLogOnErrorParams() {
      this(0);
    }

    public static AudioLogOnErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioLogOnErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioLogOnErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioLogOnErrorParams result = new AudioLogOnErrorParams(elementsOrVersion);
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

  static final class AudioLogOnSetVolumeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public double volume;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioLogOnSetVolumeParams(int version) {
      super(16, version);
    }

    public AudioLogOnSetVolumeParams() {
      this(0);
    }

    public static AudioLogOnSetVolumeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioLogOnSetVolumeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioLogOnSetVolumeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioLogOnSetVolumeParams result = new AudioLogOnSetVolumeParams(elementsOrVersion);
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

  static final class AudioLogOnProcessingStateChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String message;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioLogOnProcessingStateChangedParams(int version) {
      super(16, version);
    }

    public AudioLogOnProcessingStateChangedParams() {
      this(0);
    }

    public static AudioLogOnProcessingStateChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioLogOnProcessingStateChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioLogOnProcessingStateChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioLogOnProcessingStateChangedParams result =
            new AudioLogOnProcessingStateChangedParams(elementsOrVersion);
        result.message = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.message, 8, false);
    }
  }

  static final class AudioLogOnLogMessageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String message;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioLogOnLogMessageParams(int version) {
      super(16, version);
    }

    public AudioLogOnLogMessageParams() {
      this(0);
    }

    public static AudioLogOnLogMessageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioLogOnLogMessageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioLogOnLogMessageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioLogOnLogMessageParams result = new AudioLogOnLogMessageParams(elementsOrVersion);
        result.message = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.message, 8, false);
    }
  }
}
