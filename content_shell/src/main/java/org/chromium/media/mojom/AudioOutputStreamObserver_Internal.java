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

class AudioOutputStreamObserver_Internal {
  private static final int DID_CHANGE_AUDIBLE_STATE_ORDINAL = 2;
  private static final int DID_START_PLAYING_ORDINAL = 0;
  private static final int DID_STOP_PLAYING_ORDINAL = 1;
  public static final Interface.Manager<AudioOutputStreamObserver, AudioOutputStreamObserver.Proxy>
      MANAGER =
          new Interface.Manager<AudioOutputStreamObserver, AudioOutputStreamObserver.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.AudioOutputStreamObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AudioOutputStreamObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AudioOutputStreamObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public AudioOutputStreamObserver[] buildArray(int size) {
              return new AudioOutputStreamObserver[size];
            }
          };

  AudioOutputStreamObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AudioOutputStreamObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void didStartPlaying() {
      AudioOutputStreamObserverDidStartPlayingParams _message =
          new AudioOutputStreamObserverDidStartPlayingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void didStopPlaying() {
      AudioOutputStreamObserverDidStopPlayingParams _message =
          new AudioOutputStreamObserverDidStopPlayingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void didChangeAudibleState(boolean isAudible) {
      AudioOutputStreamObserverDidChangeAudibleStateParams _message =
          new AudioOutputStreamObserverDidChangeAudibleStateParams();
      _message.isAudible = isAudible;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioOutputStreamObserver> {
    Stub(Core core, AudioOutputStreamObserver impl) {
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
                AudioOutputStreamObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AudioOutputStreamObserverDidStartPlayingParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().didStartPlaying();
            return true;
          case 1:
            AudioOutputStreamObserverDidStopPlayingParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().didStopPlaying();
            return true;
          case 2:
            AudioOutputStreamObserverDidChangeAudibleStateParams data =
                AudioOutputStreamObserverDidChangeAudibleStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didChangeAudibleState(data.isAudible);
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
                getCore(), AudioOutputStreamObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioOutputStreamObserverDidStartPlayingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioOutputStreamObserverDidStartPlayingParams(int version) {
      super(8, version);
    }

    public AudioOutputStreamObserverDidStartPlayingParams() {
      this(0);
    }

    public static AudioOutputStreamObserverDidStartPlayingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioOutputStreamObserverDidStartPlayingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioOutputStreamObserverDidStartPlayingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioOutputStreamObserverDidStartPlayingParams result =
            new AudioOutputStreamObserverDidStartPlayingParams(elementsOrVersion);
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

  static final class AudioOutputStreamObserverDidStopPlayingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioOutputStreamObserverDidStopPlayingParams(int version) {
      super(8, version);
    }

    public AudioOutputStreamObserverDidStopPlayingParams() {
      this(0);
    }

    public static AudioOutputStreamObserverDidStopPlayingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioOutputStreamObserverDidStopPlayingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioOutputStreamObserverDidStopPlayingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioOutputStreamObserverDidStopPlayingParams result =
            new AudioOutputStreamObserverDidStopPlayingParams(elementsOrVersion);
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

  static final class AudioOutputStreamObserverDidChangeAudibleStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isAudible;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioOutputStreamObserverDidChangeAudibleStateParams(int version) {
      super(16, version);
    }

    public AudioOutputStreamObserverDidChangeAudibleStateParams() {
      this(0);
    }

    public static AudioOutputStreamObserverDidChangeAudibleStateParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AudioOutputStreamObserverDidChangeAudibleStateParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioOutputStreamObserverDidChangeAudibleStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioOutputStreamObserverDidChangeAudibleStateParams result =
            new AudioOutputStreamObserverDidChangeAudibleStateParams(elementsOrVersion);
        result.isAudible = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isAudible, 8, 0);
    }
  }
}
