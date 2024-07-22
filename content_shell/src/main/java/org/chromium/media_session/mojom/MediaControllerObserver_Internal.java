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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnguessableToken;

class MediaControllerObserver_Internal {
  public static final Interface.Manager<MediaControllerObserver, MediaControllerObserver.Proxy>
      MANAGER =
          new Interface.Manager<MediaControllerObserver, MediaControllerObserver.Proxy>() {
            @Override
            public String getName() {
              return "media_session.mojom.MediaControllerObserver";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public MediaControllerObserver.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, MediaControllerObserver impl) {
              return new Stub(core, impl);
            }

            @Override
            public MediaControllerObserver[] buildArray(int size) {
              return new MediaControllerObserver[size];
            }
          };
  private static final int MEDIA_SESSION_ACTIONS_CHANGED_ORDINAL = 2;
  private static final int MEDIA_SESSION_CHANGED_ORDINAL = 3;
  private static final int MEDIA_SESSION_INFO_CHANGED_ORDINAL = 0;
  private static final int MEDIA_SESSION_METADATA_CHANGED_ORDINAL = 1;
  private static final int MEDIA_SESSION_POSITION_CHANGED_ORDINAL = 4;

  MediaControllerObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements MediaControllerObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void mediaSessionInfoChanged(MediaSessionInfo info) {
      MediaControllerObserverMediaSessionInfoChangedParams _message =
          new MediaControllerObserverMediaSessionInfoChangedParams();
      _message.info = info;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void mediaSessionMetadataChanged(MediaMetadata metadata) {
      MediaControllerObserverMediaSessionMetadataChangedParams _message =
          new MediaControllerObserverMediaSessionMetadataChangedParams();
      _message.metadata = metadata;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void mediaSessionActionsChanged(int[] action) {
      MediaControllerObserverMediaSessionActionsChangedParams _message =
          new MediaControllerObserverMediaSessionActionsChangedParams();
      _message.action = action;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void mediaSessionChanged(UnguessableToken requestId) {
      MediaControllerObserverMediaSessionChangedParams _message =
          new MediaControllerObserverMediaSessionChangedParams();
      _message.requestId = requestId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void mediaSessionPositionChanged(MediaPosition position) {
      MediaControllerObserverMediaSessionPositionChangedParams _message =
          new MediaControllerObserverMediaSessionPositionChangedParams();
      _message.position = position;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaControllerObserver> {
    Stub(Core core, MediaControllerObserver impl) {
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
                MediaControllerObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaControllerObserverMediaSessionInfoChangedParams data =
                MediaControllerObserverMediaSessionInfoChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaSessionInfoChanged(data.info);
            return true;
          case 1:
            MediaControllerObserverMediaSessionMetadataChangedParams data2 =
                MediaControllerObserverMediaSessionMetadataChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaSessionMetadataChanged(data2.metadata);
            return true;
          case 2:
            MediaControllerObserverMediaSessionActionsChangedParams data3 =
                MediaControllerObserverMediaSessionActionsChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaSessionActionsChanged(data3.action);
            return true;
          case 3:
            MediaControllerObserverMediaSessionChangedParams data4 =
                MediaControllerObserverMediaSessionChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaSessionChanged(data4.requestId);
            return true;
          case 4:
            MediaControllerObserverMediaSessionPositionChangedParams data5 =
                MediaControllerObserverMediaSessionPositionChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaSessionPositionChanged(data5.position);
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
                getCore(), MediaControllerObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MediaControllerObserverMediaSessionInfoChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaSessionInfo info;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaControllerObserverMediaSessionInfoChangedParams(int version) {
      super(16, version);
    }

    public MediaControllerObserverMediaSessionInfoChangedParams() {
      this(0);
    }

    public static MediaControllerObserverMediaSessionInfoChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaControllerObserverMediaSessionInfoChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaControllerObserverMediaSessionInfoChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaControllerObserverMediaSessionInfoChangedParams result =
            new MediaControllerObserverMediaSessionInfoChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.info = MediaSessionInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.info, 8, true);
    }
  }

  static final class MediaControllerObserverMediaSessionMetadataChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaMetadata metadata;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaControllerObserverMediaSessionMetadataChangedParams(int version) {
      super(16, version);
    }

    public MediaControllerObserverMediaSessionMetadataChangedParams() {
      this(0);
    }

    public static MediaControllerObserverMediaSessionMetadataChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaControllerObserverMediaSessionMetadataChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaControllerObserverMediaSessionMetadataChangedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaControllerObserverMediaSessionMetadataChangedParams result =
            new MediaControllerObserverMediaSessionMetadataChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.metadata = MediaMetadata.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.metadata, 8, true);
    }
  }

  static final class MediaControllerObserverMediaSessionActionsChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] action;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaControllerObserverMediaSessionActionsChangedParams(int version) {
      super(16, version);
    }

    public MediaControllerObserverMediaSessionActionsChangedParams() {
      this(0);
    }

    public static MediaControllerObserverMediaSessionActionsChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaControllerObserverMediaSessionActionsChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaControllerObserverMediaSessionActionsChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaControllerObserverMediaSessionActionsChangedParams result =
            new MediaControllerObserverMediaSessionActionsChangedParams(elementsOrVersion);
        result.action = decoder0.readInts(8, 0, -1);
        int i1 = 0;
        while (true) {
          int[] iArr = result.action;
          if (i1 < iArr.length) {
            MediaSessionAction.validate(iArr[i1]);
            i1++;
          } else {
            return result;
          }
        }
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.action, 8, 0, -1);
    }
  }

  static final class MediaControllerObserverMediaSessionChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaControllerObserverMediaSessionChangedParams(int version) {
      super(16, version);
    }

    public MediaControllerObserverMediaSessionChangedParams() {
      this(0);
    }

    public static MediaControllerObserverMediaSessionChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaControllerObserverMediaSessionChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaControllerObserverMediaSessionChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaControllerObserverMediaSessionChangedParams result =
            new MediaControllerObserverMediaSessionChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.requestId = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.requestId, 8, true);
    }
  }

  static final class MediaControllerObserverMediaSessionPositionChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaPosition position;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaControllerObserverMediaSessionPositionChangedParams(int version) {
      super(16, version);
    }

    public MediaControllerObserverMediaSessionPositionChangedParams() {
      this(0);
    }

    public static MediaControllerObserverMediaSessionPositionChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaControllerObserverMediaSessionPositionChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaControllerObserverMediaSessionPositionChangedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaControllerObserverMediaSessionPositionChangedParams result =
            new MediaControllerObserverMediaSessionPositionChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.position = MediaPosition.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.position, 8, true);
    }
  }
}
