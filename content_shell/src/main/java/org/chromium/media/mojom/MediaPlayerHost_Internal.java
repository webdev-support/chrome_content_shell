package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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

class MediaPlayerHost_Internal {
  public static final Interface.Manager<MediaPlayerHost, MediaPlayerHost.Proxy> MANAGER =
      new Interface.Manager<MediaPlayerHost, MediaPlayerHost.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.MediaPlayerHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public MediaPlayerHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, MediaPlayerHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public MediaPlayerHost[] buildArray(int size) {
          return new MediaPlayerHost[size];
        }
      };
  private static final int ON_MEDIA_PLAYER_ADDED_ORDINAL = 0;

  MediaPlayerHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements MediaPlayerHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onMediaPlayerAdded(
        AssociatedInterfaceNotSupported playerRemote,
        AssociatedInterfaceRequestNotSupported observer,
        int playerId) {
      MediaPlayerHostOnMediaPlayerAddedParams _message =
          new MediaPlayerHostOnMediaPlayerAddedParams();
      _message.playerRemote = playerRemote;
      _message.observer = observer;
      _message.playerId = playerId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaPlayerHost> {
    Stub(Core core, MediaPlayerHost impl) {
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
                MediaPlayerHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaPlayerHostOnMediaPlayerAddedParams data =
                MediaPlayerHostOnMediaPlayerAddedParams.deserialize(messageWithHeader.getPayload());
            getImpl().onMediaPlayerAdded(data.playerRemote, data.observer, data.playerId);
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
                getCore(), MediaPlayerHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MediaPlayerHostOnMediaPlayerAddedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceRequestNotSupported observer;
    public int playerId;
    public AssociatedInterfaceNotSupported playerRemote;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaPlayerHostOnMediaPlayerAddedParams(int version) {
      super(24, version);
    }

    public MediaPlayerHostOnMediaPlayerAddedParams() {
      this(0);
    }

    public static MediaPlayerHostOnMediaPlayerAddedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaPlayerHostOnMediaPlayerAddedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPlayerHostOnMediaPlayerAddedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaPlayerHostOnMediaPlayerAddedParams result =
            new MediaPlayerHostOnMediaPlayerAddedParams(elementsOrVersion);
        result.playerRemote = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
        result.observer = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
        result.playerId = decoder0.readInt(20);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.playerRemote, 8, false);
      encoder0.encode(this.observer, 16, false);
      encoder0.encode(this.playerId, 20);
    }
  }
}
