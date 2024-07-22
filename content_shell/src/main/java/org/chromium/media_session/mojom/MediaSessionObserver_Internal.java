package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

class MediaSessionObserver_Internal {
  public static final Interface.Manager<MediaSessionObserver, MediaSessionObserver.Proxy> MANAGER =
      new Interface.Manager<MediaSessionObserver, MediaSessionObserver.Proxy>() {
        @Override
        public String getName() {
          return "media_session.mojom.MediaSessionObserver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public MediaSessionObserver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, MediaSessionObserver impl) {
          return new Stub(core, impl);
        }

        @Override
        public MediaSessionObserver[] buildArray(int size) {
          return new MediaSessionObserver[size];
        }
      };
  private static final int MEDIA_SESSION_ACTIONS_CHANGED_ORDINAL = 2;
  private static final int MEDIA_SESSION_IMAGES_CHANGED_ORDINAL = 3;
  private static final int MEDIA_SESSION_INFO_CHANGED_ORDINAL = 0;
  private static final int MEDIA_SESSION_METADATA_CHANGED_ORDINAL = 1;
  private static final int MEDIA_SESSION_POSITION_CHANGED_ORDINAL = 4;

  MediaSessionObserver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements MediaSessionObserver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void mediaSessionInfoChanged(MediaSessionInfo info) {
      MediaSessionObserverMediaSessionInfoChangedParams _message =
          new MediaSessionObserverMediaSessionInfoChangedParams();
      _message.info = info;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void mediaSessionMetadataChanged(MediaMetadata metadata) {
      MediaSessionObserverMediaSessionMetadataChangedParams _message =
          new MediaSessionObserverMediaSessionMetadataChangedParams();
      _message.metadata = metadata;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void mediaSessionActionsChanged(int[] action) {
      MediaSessionObserverMediaSessionActionsChangedParams _message =
          new MediaSessionObserverMediaSessionActionsChangedParams();
      _message.action = action;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void mediaSessionImagesChanged(Map<Integer, MediaImage[]> images) {
      MediaSessionObserverMediaSessionImagesChangedParams _message =
          new MediaSessionObserverMediaSessionImagesChangedParams();
      _message.images = images;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void mediaSessionPositionChanged(MediaPosition position) {
      MediaSessionObserverMediaSessionPositionChangedParams _message =
          new MediaSessionObserverMediaSessionPositionChangedParams();
      _message.position = position;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaSessionObserver> {
    Stub(Core core, MediaSessionObserver impl) {
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
                MediaSessionObserver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaSessionObserverMediaSessionInfoChangedParams data =
                MediaSessionObserverMediaSessionInfoChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaSessionInfoChanged(data.info);
            return true;
          case 1:
            MediaSessionObserverMediaSessionMetadataChangedParams data2 =
                MediaSessionObserverMediaSessionMetadataChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaSessionMetadataChanged(data2.metadata);
            return true;
          case 2:
            MediaSessionObserverMediaSessionActionsChangedParams data3 =
                MediaSessionObserverMediaSessionActionsChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaSessionActionsChanged(data3.action);
            return true;
          case 3:
            MediaSessionObserverMediaSessionImagesChangedParams data4 =
                MediaSessionObserverMediaSessionImagesChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().mediaSessionImagesChanged(data4.images);
            return true;
          case 4:
            MediaSessionObserverMediaSessionPositionChangedParams data5 =
                MediaSessionObserverMediaSessionPositionChangedParams.deserialize(
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
                getCore(), MediaSessionObserver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MediaSessionObserverMediaSessionInfoChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaSessionInfo info;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionObserverMediaSessionInfoChangedParams(int version) {
      super(16, version);
    }

    public MediaSessionObserverMediaSessionInfoChangedParams() {
      this(0);
    }

    public static MediaSessionObserverMediaSessionInfoChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionObserverMediaSessionInfoChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionObserverMediaSessionInfoChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionObserverMediaSessionInfoChangedParams result =
            new MediaSessionObserverMediaSessionInfoChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.info = MediaSessionInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.info, 8, false);
    }
  }

  static final class MediaSessionObserverMediaSessionMetadataChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaMetadata metadata;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionObserverMediaSessionMetadataChangedParams(int version) {
      super(16, version);
    }

    public MediaSessionObserverMediaSessionMetadataChangedParams() {
      this(0);
    }

    public static MediaSessionObserverMediaSessionMetadataChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionObserverMediaSessionMetadataChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionObserverMediaSessionMetadataChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionObserverMediaSessionMetadataChangedParams result =
            new MediaSessionObserverMediaSessionMetadataChangedParams(elementsOrVersion);
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

  static final class MediaSessionObserverMediaSessionActionsChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] action;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionObserverMediaSessionActionsChangedParams(int version) {
      super(16, version);
    }

    public MediaSessionObserverMediaSessionActionsChangedParams() {
      this(0);
    }

    public static MediaSessionObserverMediaSessionActionsChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionObserverMediaSessionActionsChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionObserverMediaSessionActionsChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionObserverMediaSessionActionsChangedParams result =
            new MediaSessionObserverMediaSessionActionsChangedParams(elementsOrVersion);
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

  static final class MediaSessionObserverMediaSessionImagesChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Map<Integer, MediaImage[]> images;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionObserverMediaSessionImagesChangedParams(int version) {
      super(16, version);
    }

    public MediaSessionObserverMediaSessionImagesChangedParams() {
      this(0);
    }

    public static MediaSessionObserverMediaSessionImagesChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionObserverMediaSessionImagesChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionObserverMediaSessionImagesChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionObserverMediaSessionImagesChangedParams result =
            new MediaSessionObserverMediaSessionImagesChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        decoder1.readDataHeaderForMap();
        int i = -1;
        int[] keys0 = decoder1.readInts(8, 0, -1);
        for (int i2 : keys0) {
          MediaSessionImageType.validate(i2);
        }
        Decoder decoder2 = decoder1.readPointer(16, false);
        DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
        MediaImage[][] values0 = new MediaImage[si2.elementsOrVersion][];
        int i22 = 0;
        while (i22 < si2.elementsOrVersion) {
          Decoder decoder3 = decoder2.readPointer((i22 * 8) + 8, false);
          DataHeader si3 = decoder3.readDataHeaderForPointerArray(i);
          values0[i22] = new MediaImage[si3.elementsOrVersion];
          for (int i3 = 0; i3 < si3.elementsOrVersion; i3++) {
            Decoder decoder4 = decoder3.readPointer((i3 * 8) + 8, false);
            values0[i22][i3] = MediaImage.decode(decoder4);
          }
          i22++;
          i = -1;
        }
        result.images = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.images.put(Integer.valueOf(keys0[index0]), values0[index0]);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      if (this.images == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encoderForMap(8);
      int size0 = this.images.size();
      int[] keys0 = new int[size0];
      MediaImage[][] values0 = new MediaImage[size0][];
      int index0 = 0;
      for (Map.Entry<Integer, MediaImage[]> entry0 : this.images.entrySet()) {
        keys0[index0] = entry0.getKey().intValue();
        values0[index0] = entry0.getValue();
        index0++;
      }
      int i = -1;
      encoder1.encode(keys0, 8, 0, -1);
      Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
      int i1 = 0;
      while (i1 < values0.length) {
        if (values0[i1] == null) {
          encoder2.encodeNullPointer((i1 * 8) + 8, false);
        } else {
          Encoder encoder3 = encoder2.encodePointerArray(values0[i1].length, (i1 * 8) + 8, i);
          for (int i2 = 0; i2 < values0[i1].length; i2++) {
            encoder3.encode((Struct) values0[i1][i2], (i2 * 8) + 8, false);
          }
        }
        i1++;
        i = -1;
      }
    }
  }

  static final class MediaSessionObserverMediaSessionPositionChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaPosition position;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaSessionObserverMediaSessionPositionChangedParams(int version) {
      super(16, version);
    }

    public MediaSessionObserverMediaSessionPositionChangedParams() {
      this(0);
    }

    public static MediaSessionObserverMediaSessionPositionChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaSessionObserverMediaSessionPositionChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionObserverMediaSessionPositionChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaSessionObserverMediaSessionPositionChangedParams result =
            new MediaSessionObserverMediaSessionPositionChangedParams(elementsOrVersion);
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
