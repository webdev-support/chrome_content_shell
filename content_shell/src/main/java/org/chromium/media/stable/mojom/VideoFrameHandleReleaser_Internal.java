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

class VideoFrameHandleReleaser_Internal {
  public static final Interface.Manager<VideoFrameHandleReleaser, VideoFrameHandleReleaser.Proxy>
      MANAGER =
          new Interface.Manager<VideoFrameHandleReleaser, VideoFrameHandleReleaser.Proxy>() {
            @Override
            public String getName() {
              return "media.stable.mojom.VideoFrameHandleReleaser";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public VideoFrameHandleReleaser.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, VideoFrameHandleReleaser impl) {
              return new Stub(core, impl);
            }

            @Override
            public VideoFrameHandleReleaser[] buildArray(int size) {
              return new VideoFrameHandleReleaser[size];
            }
          };
  private static final int RELEASE_VIDEO_FRAME_ORDINAL = 0;

  VideoFrameHandleReleaser_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements VideoFrameHandleReleaser.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void releaseVideoFrame(UnguessableToken releaseToken) {
      VideoFrameHandleReleaserReleaseVideoFrameParams _message =
          new VideoFrameHandleReleaserReleaseVideoFrameParams();
      _message.releaseToken = releaseToken;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<VideoFrameHandleReleaser> {
    Stub(Core core, VideoFrameHandleReleaser impl) {
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
                VideoFrameHandleReleaser_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            VideoFrameHandleReleaserReleaseVideoFrameParams data =
                VideoFrameHandleReleaserReleaseVideoFrameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().releaseVideoFrame(data.releaseToken);
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
                getCore(), VideoFrameHandleReleaser_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class VideoFrameHandleReleaserReleaseVideoFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken releaseToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoFrameHandleReleaserReleaseVideoFrameParams(int version) {
      super(16, version);
    }

    public VideoFrameHandleReleaserReleaseVideoFrameParams() {
      this(0);
    }

    public static VideoFrameHandleReleaserReleaseVideoFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoFrameHandleReleaserReleaseVideoFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoFrameHandleReleaserReleaseVideoFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoFrameHandleReleaserReleaseVideoFrameParams result =
            new VideoFrameHandleReleaserReleaseVideoFrameParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.releaseToken = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.releaseToken, 8, false);
    }
  }
}
