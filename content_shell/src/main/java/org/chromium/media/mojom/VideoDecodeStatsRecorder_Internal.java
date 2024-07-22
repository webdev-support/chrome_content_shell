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

class VideoDecodeStatsRecorder_Internal {
  public static final Interface.Manager<VideoDecodeStatsRecorder, VideoDecodeStatsRecorder.Proxy>
      MANAGER =
          new Interface.Manager<VideoDecodeStatsRecorder, VideoDecodeStatsRecorder.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.VideoDecodeStatsRecorder";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public VideoDecodeStatsRecorder.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, VideoDecodeStatsRecorder impl) {
              return new Stub(core, impl);
            }

            @Override
            public VideoDecodeStatsRecorder[] buildArray(int size) {
              return new VideoDecodeStatsRecorder[size];
            }
          };
  private static final int START_NEW_RECORD_ORDINAL = 0;
  private static final int UPDATE_RECORD_ORDINAL = 1;

  VideoDecodeStatsRecorder_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements VideoDecodeStatsRecorder.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void startNewRecord(PredictionFeatures features) {
      VideoDecodeStatsRecorderStartNewRecordParams _message =
          new VideoDecodeStatsRecorderStartNewRecordParams();
      _message.features = features;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void updateRecord(PredictionTargets targets) {
      VideoDecodeStatsRecorderUpdateRecordParams _message =
          new VideoDecodeStatsRecorderUpdateRecordParams();
      _message.targets = targets;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<VideoDecodeStatsRecorder> {
    Stub(Core core, VideoDecodeStatsRecorder impl) {
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
                VideoDecodeStatsRecorder_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            VideoDecodeStatsRecorderStartNewRecordParams data =
                VideoDecodeStatsRecorderStartNewRecordParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().startNewRecord(data.features);
            return true;
          case 1:
            VideoDecodeStatsRecorderUpdateRecordParams data2 =
                VideoDecodeStatsRecorderUpdateRecordParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateRecord(data2.targets);
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
                getCore(), VideoDecodeStatsRecorder_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class VideoDecodeStatsRecorderStartNewRecordParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PredictionFeatures features;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecodeStatsRecorderStartNewRecordParams(int version) {
      super(16, version);
    }

    public VideoDecodeStatsRecorderStartNewRecordParams() {
      this(0);
    }

    public static VideoDecodeStatsRecorderStartNewRecordParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecodeStatsRecorderStartNewRecordParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecodeStatsRecorderStartNewRecordParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecodeStatsRecorderStartNewRecordParams result =
            new VideoDecodeStatsRecorderStartNewRecordParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.features = PredictionFeatures.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.features, 8, false);
    }
  }

  static final class VideoDecodeStatsRecorderUpdateRecordParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PredictionTargets targets;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecodeStatsRecorderUpdateRecordParams(int version) {
      super(16, version);
    }

    public VideoDecodeStatsRecorderUpdateRecordParams() {
      this(0);
    }

    public static VideoDecodeStatsRecorderUpdateRecordParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecodeStatsRecorderUpdateRecordParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecodeStatsRecorderUpdateRecordParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecodeStatsRecorderUpdateRecordParams result =
            new VideoDecodeStatsRecorderUpdateRecordParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.targets = PredictionTargets.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.targets, 8, false);
    }
  }
}
