package org.chromium.media_session.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class AudioFocusRequestClient_Internal {
  private static final int ABANDON_AUDIO_FOCUS_ORDINAL = 1;
  public static final Interface.Manager<AudioFocusRequestClient, AudioFocusRequestClient.Proxy>
      MANAGER =
          new Interface.Manager<AudioFocusRequestClient, AudioFocusRequestClient.Proxy>() {
            @Override
            public String getName() {
              return "media_session.mojom.AudioFocusRequestClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AudioFocusRequestClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AudioFocusRequestClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public AudioFocusRequestClient[] buildArray(int size) {
              return new AudioFocusRequestClient[size];
            }
          };
  private static final int MEDIA_SESSION_INFO_CHANGED_ORDINAL = 2;
  private static final int REQUEST_AUDIO_FOCUS_ORDINAL = 0;

  AudioFocusRequestClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AudioFocusRequestClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestAudioFocus(
        MediaSessionInfo sessionInfo, int type, RequestAudioFocus_Response callback) {
      AudioFocusRequestClientRequestAudioFocusParams _message =
          new AudioFocusRequestClientRequestAudioFocusParams();
      _message.sessionInfo = sessionInfo;
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new AudioFocusRequestClientRequestAudioFocusResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void abandonAudioFocus() {
      AudioFocusRequestClientAbandonAudioFocusParams _message =
          new AudioFocusRequestClientAbandonAudioFocusParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void mediaSessionInfoChanged(MediaSessionInfo sessionInfo) {
      AudioFocusRequestClientMediaSessionInfoChangedParams _message =
          new AudioFocusRequestClientMediaSessionInfoChangedParams();
      _message.sessionInfo = sessionInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioFocusRequestClient> {
    Stub(Core core, AudioFocusRequestClient impl) {
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
                AudioFocusRequestClient_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          default:
            return false;
          case 1:
            AudioFocusRequestClientAbandonAudioFocusParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().abandonAudioFocus();
            return true;
          case 2:
            AudioFocusRequestClientMediaSessionInfoChangedParams data =
                AudioFocusRequestClientMediaSessionInfoChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaSessionInfoChanged(data.sessionInfo);
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
                getCore(), AudioFocusRequestClient_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            AudioFocusRequestClientRequestAudioFocusParams data =
                AudioFocusRequestClientRequestAudioFocusParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .requestAudioFocus(
                    data.sessionInfo,
                    data.type,
                    new AudioFocusRequestClientRequestAudioFocusResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AudioFocusRequestClientRequestAudioFocusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaSessionInfo sessionInfo;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusRequestClientRequestAudioFocusParams(int version) {
      super(24, version);
    }

    public AudioFocusRequestClientRequestAudioFocusParams() {
      this(0);
    }

    public static AudioFocusRequestClientRequestAudioFocusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusRequestClientRequestAudioFocusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusRequestClientRequestAudioFocusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusRequestClientRequestAudioFocusParams result =
            new AudioFocusRequestClientRequestAudioFocusParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.sessionInfo = MediaSessionInfo.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.type = readInt;
        AudioFocusType.validate(readInt);
        result.type = AudioFocusType.toKnownValue(result.type);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sessionInfo, 8, false);
      encoder0.encode(this.type, 16);
    }
  }

  static final class AudioFocusRequestClientRequestAudioFocusResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusRequestClientRequestAudioFocusResponseParams(int version) {
      super(8, version);
    }

    public AudioFocusRequestClientRequestAudioFocusResponseParams() {
      this(0);
    }

    public static AudioFocusRequestClientRequestAudioFocusResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusRequestClientRequestAudioFocusResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusRequestClientRequestAudioFocusResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusRequestClientRequestAudioFocusResponseParams result =
            new AudioFocusRequestClientRequestAudioFocusResponseParams(elementsOrVersion);
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

  static class AudioFocusRequestClientRequestAudioFocusResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AudioFocusRequestClient.RequestAudioFocus_Response mCallback;

    AudioFocusRequestClientRequestAudioFocusResponseParamsForwardToCallback(
        AudioFocusRequestClient.RequestAudioFocus_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AudioFocusRequestClientRequestAudioFocusResponseParamsProxyToResponder
      implements AudioFocusRequestClient.RequestAudioFocus_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioFocusRequestClientRequestAudioFocusResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      AudioFocusRequestClientRequestAudioFocusResponseParams _response =
          new AudioFocusRequestClientRequestAudioFocusResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AudioFocusRequestClientAbandonAudioFocusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusRequestClientAbandonAudioFocusParams(int version) {
      super(8, version);
    }

    public AudioFocusRequestClientAbandonAudioFocusParams() {
      this(0);
    }

    public static AudioFocusRequestClientAbandonAudioFocusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusRequestClientAbandonAudioFocusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusRequestClientAbandonAudioFocusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusRequestClientAbandonAudioFocusParams result =
            new AudioFocusRequestClientAbandonAudioFocusParams(elementsOrVersion);
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

  static final class AudioFocusRequestClientMediaSessionInfoChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaSessionInfo sessionInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusRequestClientMediaSessionInfoChangedParams(int version) {
      super(16, version);
    }

    public AudioFocusRequestClientMediaSessionInfoChangedParams() {
      this(0);
    }

    public static AudioFocusRequestClientMediaSessionInfoChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusRequestClientMediaSessionInfoChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusRequestClientMediaSessionInfoChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusRequestClientMediaSessionInfoChangedParams result =
            new AudioFocusRequestClientMediaSessionInfoChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.sessionInfo = MediaSessionInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sessionInfo, 8, false);
    }
  }
}
