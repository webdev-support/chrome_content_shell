package org.chromium.media_session.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnguessableToken;

class AudioFocusManager_Internal {
  private static final int ADD_OBSERVER_ORDINAL = 2;
  private static final int ADD_SOURCE_OBSERVER_ORDINAL = 7;
  private static final int GET_FOCUS_REQUESTS_ORDINAL = 1;
  private static final int GET_SOURCE_FOCUS_REQUESTS_ORDINAL = 8;
  public static final Interface.Manager<AudioFocusManager, AudioFocusManager.Proxy> MANAGER =
      new Interface.Manager<AudioFocusManager, AudioFocusManager.Proxy>() {
        @Override
        public String getName() {
          return "media_session.mojom.AudioFocusManager";
        }

        @Override
        public int getVersion() {
          return 8;
        }

        @Override
        public AudioFocusManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AudioFocusManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public AudioFocusManager[] buildArray(int size) {
          return new AudioFocusManager[size];
        }
      };
  private static final int REQUEST_AUDIO_FOCUS_ORDINAL = 0;
  private static final int REQUEST_GROUPED_AUDIO_FOCUS_ORDINAL = 4;
  private static final int REQUEST_ID_RELEASED_ORDINAL = 9;
  private static final int SET_ENFORCEMENT_MODE_ORDINAL = 5;
  private static final int SET_SOURCE_ORDINAL = 6;

  AudioFocusManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AudioFocusManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestAudioFocus(
        InterfaceRequest<AudioFocusRequestClient> client,
        MediaSession session,
        MediaSessionInfo sessionInfo,
        int type,
        RequestAudioFocus_Response callback) {
      AudioFocusManagerRequestAudioFocusParams _message =
          new AudioFocusManagerRequestAudioFocusParams();
      _message.client = client;
      _message.session = session;
      _message.sessionInfo = sessionInfo;
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new AudioFocusManagerRequestAudioFocusResponseParamsForwardToCallback(callback));
    }

    @Override
    public void requestGroupedAudioFocus(
        UnguessableToken requestId,
        InterfaceRequest<AudioFocusRequestClient> client,
        MediaSession session,
        MediaSessionInfo sessionInfo,
        int type,
        UnguessableToken groupId,
        RequestGroupedAudioFocus_Response callback) {
      AudioFocusManagerRequestGroupedAudioFocusParams _message =
          new AudioFocusManagerRequestGroupedAudioFocusParams();
      _message.requestId = requestId;
      _message.client = client;
      _message.session = session;
      _message.sessionInfo = sessionInfo;
      _message.type = type;
      _message.groupId = groupId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new AudioFocusManagerRequestGroupedAudioFocusResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getFocusRequests(GetFocusRequests_Response callback) {
      AudioFocusManagerGetFocusRequestsParams _message =
          new AudioFocusManagerGetFocusRequestsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new AudioFocusManagerGetFocusRequestsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void addObserver(AudioFocusObserver observer) {
      AudioFocusManagerAddObserverParams _message = new AudioFocusManagerAddObserverParams();
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void setSource(UnguessableToken identity, String name) {
      AudioFocusManagerSetSourceParams _message = new AudioFocusManagerSetSourceParams();
      _message.identity = identity;
      _message.name = name;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void setEnforcementMode(int mode) {
      AudioFocusManagerSetEnforcementModeParams _message =
          new AudioFocusManagerSetEnforcementModeParams();
      _message.mode = mode;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void addSourceObserver(UnguessableToken sourceId, AudioFocusObserver observer) {
      AudioFocusManagerAddSourceObserverParams _message =
          new AudioFocusManagerAddSourceObserverParams();
      _message.sourceId = sourceId;
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void getSourceFocusRequests(
        UnguessableToken sourceId, GetSourceFocusRequests_Response callback) {
      AudioFocusManagerGetSourceFocusRequestsParams _message =
          new AudioFocusManagerGetSourceFocusRequestsParams();
      _message.sourceId = sourceId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new AudioFocusManagerGetSourceFocusRequestsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void requestIdReleased(UnguessableToken requestId) {
      AudioFocusManagerRequestIdReleasedParams _message =
          new AudioFocusManagerRequestIdReleasedParams();
      _message.requestId = requestId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }
  }

  public static final class Stub extends Interface.Stub<AudioFocusManager> {
    Stub(Core core, AudioFocusManager impl) {
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
                AudioFocusManager_Internal.MANAGER, messageWithHeader);
          case 2:
            AudioFocusManagerAddObserverParams data =
                AudioFocusManagerAddObserverParams.deserialize(messageWithHeader.getPayload());
            getImpl().addObserver(data.observer);
            return true;
          case 5:
            AudioFocusManagerSetEnforcementModeParams data2 =
                AudioFocusManagerSetEnforcementModeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setEnforcementMode(data2.mode);
            return true;
          case 6:
            AudioFocusManagerSetSourceParams data3 =
                AudioFocusManagerSetSourceParams.deserialize(messageWithHeader.getPayload());
            getImpl().setSource(data3.identity, data3.name);
            return true;
          case 7:
            AudioFocusManagerAddSourceObserverParams data4 =
                AudioFocusManagerAddSourceObserverParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().addSourceObserver(data4.sourceId, data4.observer);
            return true;
          case 9:
            AudioFocusManagerRequestIdReleasedParams data5 =
                AudioFocusManagerRequestIdReleasedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().requestIdReleased(data5.requestId);
            return true;
          default:
            return false;
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
                getCore(), AudioFocusManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            AudioFocusManagerRequestAudioFocusParams data =
                AudioFocusManagerRequestAudioFocusParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .requestAudioFocus(
                    data.client,
                    data.session,
                    data.sessionInfo,
                    data.type,
                    new AudioFocusManagerRequestAudioFocusResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            AudioFocusManagerGetFocusRequestsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getFocusRequests(
                    new AudioFocusManagerGetFocusRequestsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            AudioFocusManagerRequestGroupedAudioFocusParams data2 =
                AudioFocusManagerRequestGroupedAudioFocusParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .requestGroupedAudioFocus(
                    data2.requestId,
                    data2.client,
                    data2.session,
                    data2.sessionInfo,
                    data2.type,
                    data2.groupId,
                    new AudioFocusManagerRequestGroupedAudioFocusResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            getImpl()
                .getSourceFocusRequests(
                    AudioFocusManagerGetSourceFocusRequestsParams.deserialize(
                            messageWithHeader.getPayload())
                        .sourceId,
                    new AudioFocusManagerGetSourceFocusRequestsResponseParamsProxyToResponder(
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

  static final class AudioFocusManagerRequestAudioFocusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<AudioFocusRequestClient> client;
    public MediaSession session;
    public MediaSessionInfo sessionInfo;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerRequestAudioFocusParams(int version) {
      super(32, version);
    }

    public AudioFocusManagerRequestAudioFocusParams() {
      this(0);
    }

    public static AudioFocusManagerRequestAudioFocusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerRequestAudioFocusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerRequestAudioFocusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerRequestAudioFocusParams result =
            new AudioFocusManagerRequestAudioFocusParams(elementsOrVersion);
        result.client = decoder0.readInterfaceRequest(8, false);
        result.session =
            (MediaSession) decoder0.readServiceInterface(12, false, MediaSession.MANAGER);
        int readInt = decoder0.readInt(20);
        result.type = readInt;
        AudioFocusType.validate(readInt);
        result.type = AudioFocusType.toKnownValue(result.type);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.sessionInfo = MediaSessionInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.client, 8, false);
      encoder0.encode(this.session, 12, false, MediaSession.MANAGER);
      encoder0.encode(this.type, 20);
      encoder0.encode((Struct) this.sessionInfo, 24, false);
    }
  }

  static final class AudioFocusManagerRequestAudioFocusResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerRequestAudioFocusResponseParams(int version) {
      super(16, version);
    }

    public AudioFocusManagerRequestAudioFocusResponseParams() {
      this(0);
    }

    public static AudioFocusManagerRequestAudioFocusResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerRequestAudioFocusResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerRequestAudioFocusResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerRequestAudioFocusResponseParams result =
            new AudioFocusManagerRequestAudioFocusResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.requestId = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.requestId, 8, false);
    }
  }

  static class AudioFocusManagerRequestAudioFocusResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AudioFocusManager.RequestAudioFocus_Response mCallback;

    AudioFocusManagerRequestAudioFocusResponseParamsForwardToCallback(
        AudioFocusManager.RequestAudioFocus_Response callback) {
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
        AudioFocusManagerRequestAudioFocusResponseParams response =
            AudioFocusManagerRequestAudioFocusResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.requestId);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AudioFocusManagerRequestAudioFocusResponseParamsProxyToResponder
      implements AudioFocusManager.RequestAudioFocus_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioFocusManagerRequestAudioFocusResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(UnguessableToken requestId) {
      AudioFocusManagerRequestAudioFocusResponseParams _response =
          new AudioFocusManagerRequestAudioFocusResponseParams();
      _response.requestId = requestId;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AudioFocusManagerRequestGroupedAudioFocusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<AudioFocusRequestClient> client;
    public UnguessableToken groupId;
    public UnguessableToken requestId;
    public MediaSession session;
    public MediaSessionInfo sessionInfo;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerRequestGroupedAudioFocusParams(int version) {
      super(48, version);
    }

    public AudioFocusManagerRequestGroupedAudioFocusParams() {
      this(0);
    }

    public static AudioFocusManagerRequestGroupedAudioFocusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerRequestGroupedAudioFocusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerRequestGroupedAudioFocusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerRequestGroupedAudioFocusParams result =
            new AudioFocusManagerRequestGroupedAudioFocusParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.requestId = UnguessableToken.decode(decoder1);
        result.client = decoder0.readInterfaceRequest(16, false);
        result.session =
            (MediaSession) decoder0.readServiceInterface(20, false, MediaSession.MANAGER);
        int readInt = decoder0.readInt(28);
        result.type = readInt;
        AudioFocusType.validate(readInt);
        result.type = AudioFocusType.toKnownValue(result.type);
        Decoder decoder12 = decoder0.readPointer(32, false);
        result.sessionInfo = MediaSessionInfo.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(40, false);
        result.groupId = UnguessableToken.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.requestId, 8, false);
      encoder0.encode((InterfaceRequest) this.client, 16, false);
      encoder0.encode(this.session, 20, false, MediaSession.MANAGER);
      encoder0.encode(this.type, 28);
      encoder0.encode((Struct) this.sessionInfo, 32, false);
      encoder0.encode((Struct) this.groupId, 40, false);
    }
  }

  static final class AudioFocusManagerRequestGroupedAudioFocusResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerRequestGroupedAudioFocusResponseParams(int version) {
      super(16, version);
    }

    public AudioFocusManagerRequestGroupedAudioFocusResponseParams() {
      this(0);
    }

    public static AudioFocusManagerRequestGroupedAudioFocusResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerRequestGroupedAudioFocusResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerRequestGroupedAudioFocusResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerRequestGroupedAudioFocusResponseParams result =
            new AudioFocusManagerRequestGroupedAudioFocusResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class AudioFocusManagerRequestGroupedAudioFocusResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AudioFocusManager.RequestGroupedAudioFocus_Response mCallback;

    AudioFocusManagerRequestGroupedAudioFocusResponseParamsForwardToCallback(
        AudioFocusManager.RequestGroupedAudioFocus_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        AudioFocusManagerRequestGroupedAudioFocusResponseParams response =
            AudioFocusManagerRequestGroupedAudioFocusResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AudioFocusManagerRequestGroupedAudioFocusResponseParamsProxyToResponder
      implements AudioFocusManager.RequestGroupedAudioFocus_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioFocusManagerRequestGroupedAudioFocusResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      AudioFocusManagerRequestGroupedAudioFocusResponseParams _response =
          new AudioFocusManagerRequestGroupedAudioFocusResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AudioFocusManagerGetFocusRequestsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerGetFocusRequestsParams(int version) {
      super(8, version);
    }

    public AudioFocusManagerGetFocusRequestsParams() {
      this(0);
    }

    public static AudioFocusManagerGetFocusRequestsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerGetFocusRequestsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerGetFocusRequestsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerGetFocusRequestsParams result =
            new AudioFocusManagerGetFocusRequestsParams(elementsOrVersion);
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

  static final class AudioFocusManagerGetFocusRequestsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioFocusRequestState[] requests;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerGetFocusRequestsResponseParams(int version) {
      super(16, version);
    }

    public AudioFocusManagerGetFocusRequestsResponseParams() {
      this(0);
    }

    public static AudioFocusManagerGetFocusRequestsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerGetFocusRequestsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerGetFocusRequestsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerGetFocusRequestsResponseParams result =
            new AudioFocusManagerGetFocusRequestsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.requests = new AudioFocusRequestState[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.requests[i1] = AudioFocusRequestState.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      AudioFocusRequestState[] audioFocusRequestStateArr = this.requests;
      if (audioFocusRequestStateArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(audioFocusRequestStateArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        AudioFocusRequestState[] audioFocusRequestStateArr2 = this.requests;
        if (i0 < audioFocusRequestStateArr2.length) {
          encoder1.encode((Struct) audioFocusRequestStateArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class AudioFocusManagerGetFocusRequestsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AudioFocusManager.GetFocusRequests_Response mCallback;

    AudioFocusManagerGetFocusRequestsResponseParamsForwardToCallback(
        AudioFocusManager.GetFocusRequests_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        AudioFocusManagerGetFocusRequestsResponseParams response =
            AudioFocusManagerGetFocusRequestsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.requests);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AudioFocusManagerGetFocusRequestsResponseParamsProxyToResponder
      implements AudioFocusManager.GetFocusRequests_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioFocusManagerGetFocusRequestsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(AudioFocusRequestState[] requests) {
      AudioFocusManagerGetFocusRequestsResponseParams _response =
          new AudioFocusManagerGetFocusRequestsResponseParams();
      _response.requests = requests;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AudioFocusManagerAddObserverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioFocusObserver observer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerAddObserverParams(int version) {
      super(16, version);
    }

    public AudioFocusManagerAddObserverParams() {
      this(0);
    }

    public static AudioFocusManagerAddObserverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerAddObserverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerAddObserverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerAddObserverParams result =
            new AudioFocusManagerAddObserverParams(elementsOrVersion);
        result.observer =
            (AudioFocusObserver)
                decoder0.readServiceInterface(8, false, AudioFocusObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.observer, 8, false, AudioFocusObserver.MANAGER);
    }
  }

  static final class AudioFocusManagerSetSourceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken identity;
    public String name;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerSetSourceParams(int version) {
      super(24, version);
    }

    public AudioFocusManagerSetSourceParams() {
      this(0);
    }

    public static AudioFocusManagerSetSourceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerSetSourceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerSetSourceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerSetSourceParams result =
            new AudioFocusManagerSetSourceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.identity = UnguessableToken.decode(decoder1);
        result.name = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.identity, 8, false);
      encoder0.encode(this.name, 16, false);
    }
  }

  static final class AudioFocusManagerSetEnforcementModeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int mode;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerSetEnforcementModeParams(int version) {
      super(16, version);
    }

    public AudioFocusManagerSetEnforcementModeParams() {
      this(0);
    }

    public static AudioFocusManagerSetEnforcementModeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerSetEnforcementModeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerSetEnforcementModeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerSetEnforcementModeParams result =
            new AudioFocusManagerSetEnforcementModeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.mode = readInt;
        EnforcementMode.validate(readInt);
        result.mode = EnforcementMode.toKnownValue(result.mode);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.mode, 8);
    }
  }

  static final class AudioFocusManagerAddSourceObserverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioFocusObserver observer;
    public UnguessableToken sourceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerAddSourceObserverParams(int version) {
      super(24, version);
    }

    public AudioFocusManagerAddSourceObserverParams() {
      this(0);
    }

    public static AudioFocusManagerAddSourceObserverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerAddSourceObserverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerAddSourceObserverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerAddSourceObserverParams result =
            new AudioFocusManagerAddSourceObserverParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.sourceId = UnguessableToken.decode(decoder1);
        result.observer =
            (AudioFocusObserver)
                decoder0.readServiceInterface(16, false, AudioFocusObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sourceId, 8, false);
      encoder0.encode(this.observer, 16, false, AudioFocusObserver.MANAGER);
    }
  }

  static final class AudioFocusManagerGetSourceFocusRequestsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken sourceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerGetSourceFocusRequestsParams(int version) {
      super(16, version);
    }

    public AudioFocusManagerGetSourceFocusRequestsParams() {
      this(0);
    }

    public static AudioFocusManagerGetSourceFocusRequestsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerGetSourceFocusRequestsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerGetSourceFocusRequestsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerGetSourceFocusRequestsParams result =
            new AudioFocusManagerGetSourceFocusRequestsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.sourceId = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sourceId, 8, false);
    }
  }

  static final class AudioFocusManagerGetSourceFocusRequestsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AudioFocusRequestState[] requests;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerGetSourceFocusRequestsResponseParams(int version) {
      super(16, version);
    }

    public AudioFocusManagerGetSourceFocusRequestsResponseParams() {
      this(0);
    }

    public static AudioFocusManagerGetSourceFocusRequestsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerGetSourceFocusRequestsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerGetSourceFocusRequestsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerGetSourceFocusRequestsResponseParams result =
            new AudioFocusManagerGetSourceFocusRequestsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.requests = new AudioFocusRequestState[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.requests[i1] = AudioFocusRequestState.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      AudioFocusRequestState[] audioFocusRequestStateArr = this.requests;
      if (audioFocusRequestStateArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(audioFocusRequestStateArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        AudioFocusRequestState[] audioFocusRequestStateArr2 = this.requests;
        if (i0 < audioFocusRequestStateArr2.length) {
          encoder1.encode((Struct) audioFocusRequestStateArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class AudioFocusManagerGetSourceFocusRequestsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final AudioFocusManager.GetSourceFocusRequests_Response mCallback;

    AudioFocusManagerGetSourceFocusRequestsResponseParamsForwardToCallback(
        AudioFocusManager.GetSourceFocusRequests_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(8, 2)) {
          return false;
        }
        AudioFocusManagerGetSourceFocusRequestsResponseParams response =
            AudioFocusManagerGetSourceFocusRequestsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.requests);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class AudioFocusManagerGetSourceFocusRequestsResponseParamsProxyToResponder
      implements AudioFocusManager.GetSourceFocusRequests_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    AudioFocusManagerGetSourceFocusRequestsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(AudioFocusRequestState[] requests) {
      AudioFocusManagerGetSourceFocusRequestsResponseParams _response =
          new AudioFocusManagerGetSourceFocusRequestsResponseParams();
      _response.requests = requests;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class AudioFocusManagerRequestIdReleasedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AudioFocusManagerRequestIdReleasedParams(int version) {
      super(16, version);
    }

    public AudioFocusManagerRequestIdReleasedParams() {
      this(0);
    }

    public static AudioFocusManagerRequestIdReleasedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AudioFocusManagerRequestIdReleasedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusManagerRequestIdReleasedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AudioFocusManagerRequestIdReleasedParams result =
            new AudioFocusManagerRequestIdReleasedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.requestId = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.requestId, 8, false);
    }
  }
}
