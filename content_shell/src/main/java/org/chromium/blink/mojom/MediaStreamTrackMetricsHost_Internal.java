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

class MediaStreamTrackMetricsHost_Internal {
  private static final int ADD_TRACK_ORDINAL = 0;
  public static final Interface.Manager<
          MediaStreamTrackMetricsHost, MediaStreamTrackMetricsHost.Proxy>
      MANAGER =
          new Interface.Manager<MediaStreamTrackMetricsHost, MediaStreamTrackMetricsHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.MediaStreamTrackMetricsHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public MediaStreamTrackMetricsHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, MediaStreamTrackMetricsHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public MediaStreamTrackMetricsHost[] buildArray(int size) {
              return new MediaStreamTrackMetricsHost[size];
            }
          };
  private static final int REMOVE_TRACK_ORDINAL = 1;

  MediaStreamTrackMetricsHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements MediaStreamTrackMetricsHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addTrack(long id, boolean isAudio, boolean isRemote) {
      MediaStreamTrackMetricsHostAddTrackParams _message =
          new MediaStreamTrackMetricsHostAddTrackParams();
      _message.id = id;
      _message.isAudio = isAudio;
      _message.isRemote = isRemote;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void removeTrack(long id) {
      MediaStreamTrackMetricsHostRemoveTrackParams _message =
          new MediaStreamTrackMetricsHostRemoveTrackParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<MediaStreamTrackMetricsHost> {
    Stub(Core core, MediaStreamTrackMetricsHost impl) {
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
                MediaStreamTrackMetricsHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MediaStreamTrackMetricsHostAddTrackParams data =
                MediaStreamTrackMetricsHostAddTrackParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().addTrack(data.id, data.isAudio, data.isRemote);
            return true;
          case 1:
            getImpl()
                .removeTrack(
                    MediaStreamTrackMetricsHostRemoveTrackParams.deserialize(
                            messageWithHeader.getPayload())
                        .id);
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
                getCore(),
                MediaStreamTrackMetricsHost_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MediaStreamTrackMetricsHostAddTrackParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public long id;
    public boolean isAudio;
    public boolean isRemote;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamTrackMetricsHostAddTrackParams(int version) {
      super(24, version);
    }

    public MediaStreamTrackMetricsHostAddTrackParams() {
      this(0);
    }

    public static MediaStreamTrackMetricsHostAddTrackParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamTrackMetricsHostAddTrackParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamTrackMetricsHostAddTrackParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamTrackMetricsHostAddTrackParams result =
            new MediaStreamTrackMetricsHostAddTrackParams(elementsOrVersion);
        result.id = decoder0.readLong(8);
        result.isAudio = decoder0.readBoolean(16, 0);
        result.isRemote = decoder0.readBoolean(16, 1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.id, 8);
      encoder0.encode(this.isAudio, 16, 0);
      encoder0.encode(this.isRemote, 16, 1);
    }
  }

  static final class MediaStreamTrackMetricsHostRemoveTrackParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public long id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamTrackMetricsHostRemoveTrackParams(int version) {
      super(16, version);
    }

    public MediaStreamTrackMetricsHostRemoveTrackParams() {
      this(0);
    }

    public static MediaStreamTrackMetricsHostRemoveTrackParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamTrackMetricsHostRemoveTrackParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamTrackMetricsHostRemoveTrackParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamTrackMetricsHostRemoveTrackParams result =
            new MediaStreamTrackMetricsHostRemoveTrackParams(elementsOrVersion);
        result.id = decoder0.readLong(8);
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
