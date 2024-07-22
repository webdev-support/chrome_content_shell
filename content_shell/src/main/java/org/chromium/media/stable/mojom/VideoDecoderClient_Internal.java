package org.chromium.media.stable.mojom;

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

class VideoDecoderClient_Internal {
  public static final Interface.Manager<VideoDecoderClient, VideoDecoderClient.Proxy> MANAGER =
      new Interface.Manager<VideoDecoderClient, VideoDecoderClient.Proxy>() {
        @Override
        public String getName() {
          return "media.stable.mojom.VideoDecoderClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public VideoDecoderClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, VideoDecoderClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public VideoDecoderClient[] buildArray(int size) {
          return new VideoDecoderClient[size];
        }
      };
  private static final int ON_VIDEO_FRAME_DECODED_ORDINAL = 0;
  private static final int ON_WAITING_ORDINAL = 1;

  VideoDecoderClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements VideoDecoderClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onVideoFrameDecoded(
        VideoFrame frame, boolean canReadWithoutStalling, UnguessableToken releaseToken) {
      VideoDecoderClientOnVideoFrameDecodedParams _message =
          new VideoDecoderClientOnVideoFrameDecodedParams();
      _message.frame = frame;
      _message.canReadWithoutStalling = canReadWithoutStalling;
      _message.releaseToken = releaseToken;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onWaiting(int reason) {
      VideoDecoderClientOnWaitingParams _message = new VideoDecoderClientOnWaitingParams();
      _message.reason = reason;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<VideoDecoderClient> {
    Stub(Core core, VideoDecoderClient impl) {
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
                VideoDecoderClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            VideoDecoderClientOnVideoFrameDecodedParams data =
                VideoDecoderClientOnVideoFrameDecodedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onVideoFrameDecoded(data.frame, data.canReadWithoutStalling, data.releaseToken);
            return true;
          case 1:
            getImpl()
                .onWaiting(
                    VideoDecoderClientOnWaitingParams.deserialize(messageWithHeader.getPayload())
                        .reason);
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
                getCore(), VideoDecoderClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class VideoDecoderClientOnVideoFrameDecodedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean canReadWithoutStalling;
    public VideoFrame frame;
    public UnguessableToken releaseToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderClientOnVideoFrameDecodedParams(int version) {
      super(32, version);
    }

    public VideoDecoderClientOnVideoFrameDecodedParams() {
      this(0);
    }

    public static VideoDecoderClientOnVideoFrameDecodedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderClientOnVideoFrameDecodedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderClientOnVideoFrameDecodedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderClientOnVideoFrameDecodedParams result =
            new VideoDecoderClientOnVideoFrameDecodedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.frame = VideoFrame.decode(decoder1);
        result.canReadWithoutStalling = decoder0.readBoolean(16, 0);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.releaseToken = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.frame, 8, false);
      encoder0.encode(this.canReadWithoutStalling, 16, 0);
      encoder0.encode((Struct) this.releaseToken, 24, false);
    }
  }

  static final class VideoDecoderClientOnWaitingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int reason;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecoderClientOnWaitingParams(int version) {
      super(16, version);
    }

    public VideoDecoderClientOnWaitingParams() {
      this(0);
    }

    public static VideoDecoderClientOnWaitingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecoderClientOnWaitingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderClientOnWaitingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecoderClientOnWaitingParams result =
            new VideoDecoderClientOnWaitingParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.reason = readInt;
        WaitingReason.validate(readInt);
        result.reason = WaitingReason.toKnownValue(result.reason);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.reason, 8);
    }
  }
}
