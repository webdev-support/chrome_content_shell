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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class VideoDecodePerfHistory_Internal {
  private static final int GET_PERF_INFO_ORDINAL = 0;
  public static final Interface.Manager<VideoDecodePerfHistory, VideoDecodePerfHistory.Proxy>
      MANAGER =
          new Interface.Manager<VideoDecodePerfHistory, VideoDecodePerfHistory.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.VideoDecodePerfHistory";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public VideoDecodePerfHistory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, VideoDecodePerfHistory impl) {
              return new Stub(core, impl);
            }

            @Override
            public VideoDecodePerfHistory[] buildArray(int size) {
              return new VideoDecodePerfHistory[size];
            }
          };

  VideoDecodePerfHistory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements VideoDecodePerfHistory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getPerfInfo(PredictionFeatures features, GetPerfInfo_Response callback) {
      VideoDecodePerfHistoryGetPerfInfoParams _message =
          new VideoDecodePerfHistoryGetPerfInfoParams();
      _message.features = features;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new VideoDecodePerfHistoryGetPerfInfoResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<VideoDecodePerfHistory> {
    Stub(Core core, VideoDecodePerfHistory impl) {
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
                VideoDecodePerfHistory_Internal.MANAGER, messageWithHeader);
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
                getCore(), VideoDecodePerfHistory_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            VideoDecodePerfHistoryGetPerfInfoParams data =
                VideoDecodePerfHistoryGetPerfInfoParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getPerfInfo(
                    data.features,
                    new VideoDecodePerfHistoryGetPerfInfoResponseParamsProxyToResponder(
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

  static final class VideoDecodePerfHistoryGetPerfInfoParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PredictionFeatures features;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecodePerfHistoryGetPerfInfoParams(int version) {
      super(16, version);
    }

    public VideoDecodePerfHistoryGetPerfInfoParams() {
      this(0);
    }

    public static VideoDecodePerfHistoryGetPerfInfoParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecodePerfHistoryGetPerfInfoParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecodePerfHistoryGetPerfInfoParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecodePerfHistoryGetPerfInfoParams result =
            new VideoDecodePerfHistoryGetPerfInfoParams(elementsOrVersion);
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

  static final class VideoDecodePerfHistoryGetPerfInfoResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isPowerEfficient;
    public boolean isSmooth;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoDecodePerfHistoryGetPerfInfoResponseParams(int version) {
      super(16, version);
    }

    public VideoDecodePerfHistoryGetPerfInfoResponseParams() {
      this(0);
    }

    public static VideoDecodePerfHistoryGetPerfInfoResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoDecodePerfHistoryGetPerfInfoResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecodePerfHistoryGetPerfInfoResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoDecodePerfHistoryGetPerfInfoResponseParams result =
            new VideoDecodePerfHistoryGetPerfInfoResponseParams(elementsOrVersion);
        result.isSmooth = decoder0.readBoolean(8, 0);
        result.isPowerEfficient = decoder0.readBoolean(8, 1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isSmooth, 8, 0);
      encoder0.encode(this.isPowerEfficient, 8, 1);
    }
  }

  static class VideoDecodePerfHistoryGetPerfInfoResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VideoDecodePerfHistory.GetPerfInfo_Response mCallback;

    VideoDecodePerfHistoryGetPerfInfoResponseParamsForwardToCallback(
        VideoDecodePerfHistory.GetPerfInfo_Response callback) {
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
        VideoDecodePerfHistoryGetPerfInfoResponseParams response =
            VideoDecodePerfHistoryGetPerfInfoResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.isSmooth, response.isPowerEfficient);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VideoDecodePerfHistoryGetPerfInfoResponseParamsProxyToResponder
      implements VideoDecodePerfHistory.GetPerfInfo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoDecodePerfHistoryGetPerfInfoResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean isSmooth, boolean isPowerEfficient) {
      VideoDecodePerfHistoryGetPerfInfoResponseParams _response =
          new VideoDecodePerfHistoryGetPerfInfoResponseParams();
      _response.isSmooth = isSmooth;
      _response.isPowerEfficient = isPowerEfficient;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
