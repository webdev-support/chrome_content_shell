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

class WebrtcVideoPerfHistory_Internal {
  private static final int GET_PERF_INFO_ORDINAL = 0;
  public static final Interface.Manager<WebrtcVideoPerfHistory, WebrtcVideoPerfHistory.Proxy>
      MANAGER =
          new Interface.Manager<WebrtcVideoPerfHistory, WebrtcVideoPerfHistory.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.WebrtcVideoPerfHistory";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public WebrtcVideoPerfHistory.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, WebrtcVideoPerfHistory impl) {
              return new Stub(core, impl);
            }

            @Override
            public WebrtcVideoPerfHistory[] buildArray(int size) {
              return new WebrtcVideoPerfHistory[size];
            }
          };

  WebrtcVideoPerfHistory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WebrtcVideoPerfHistory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getPerfInfo(
        WebrtcPredictionFeatures features, int framesPerSecond, GetPerfInfo_Response callback) {
      WebrtcVideoPerfHistoryGetPerfInfoParams _message =
          new WebrtcVideoPerfHistoryGetPerfInfoParams();
      _message.features = features;
      _message.framesPerSecond = framesPerSecond;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new WebrtcVideoPerfHistoryGetPerfInfoResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<WebrtcVideoPerfHistory> {
    Stub(Core core, WebrtcVideoPerfHistory impl) {
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
                WebrtcVideoPerfHistory_Internal.MANAGER, messageWithHeader);
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
                getCore(), WebrtcVideoPerfHistory_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            WebrtcVideoPerfHistoryGetPerfInfoParams data =
                WebrtcVideoPerfHistoryGetPerfInfoParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getPerfInfo(
                    data.features,
                    data.framesPerSecond,
                    new WebrtcVideoPerfHistoryGetPerfInfoResponseParamsProxyToResponder(
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

  static final class WebrtcVideoPerfHistoryGetPerfInfoParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public WebrtcPredictionFeatures features;
    public int framesPerSecond;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebrtcVideoPerfHistoryGetPerfInfoParams(int version) {
      super(24, version);
    }

    public WebrtcVideoPerfHistoryGetPerfInfoParams() {
      this(0);
    }

    public static WebrtcVideoPerfHistoryGetPerfInfoParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebrtcVideoPerfHistoryGetPerfInfoParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebrtcVideoPerfHistoryGetPerfInfoParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebrtcVideoPerfHistoryGetPerfInfoParams result =
            new WebrtcVideoPerfHistoryGetPerfInfoParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.features = WebrtcPredictionFeatures.decode(decoder1);
        result.framesPerSecond = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.features, 8, false);
      encoder0.encode(this.framesPerSecond, 16);
    }
  }

  static final class WebrtcVideoPerfHistoryGetPerfInfoResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isSmooth;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebrtcVideoPerfHistoryGetPerfInfoResponseParams(int version) {
      super(16, version);
    }

    public WebrtcVideoPerfHistoryGetPerfInfoResponseParams() {
      this(0);
    }

    public static WebrtcVideoPerfHistoryGetPerfInfoResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebrtcVideoPerfHistoryGetPerfInfoResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebrtcVideoPerfHistoryGetPerfInfoResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebrtcVideoPerfHistoryGetPerfInfoResponseParams result =
            new WebrtcVideoPerfHistoryGetPerfInfoResponseParams(elementsOrVersion);
        result.isSmooth = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isSmooth, 8, 0);
    }
  }

  static class WebrtcVideoPerfHistoryGetPerfInfoResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WebrtcVideoPerfHistory.GetPerfInfo_Response mCallback;

    WebrtcVideoPerfHistoryGetPerfInfoResponseParamsForwardToCallback(
        WebrtcVideoPerfHistory.GetPerfInfo_Response callback) {
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
        WebrtcVideoPerfHistoryGetPerfInfoResponseParams response =
            WebrtcVideoPerfHistoryGetPerfInfoResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.isSmooth);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebrtcVideoPerfHistoryGetPerfInfoResponseParamsProxyToResponder
      implements WebrtcVideoPerfHistory.GetPerfInfo_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebrtcVideoPerfHistoryGetPerfInfoResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean isSmooth) {
      WebrtcVideoPerfHistoryGetPerfInfoResponseParams _response =
          new WebrtcVideoPerfHistoryGetPerfInfoResponseParams();
      _response.isSmooth = isSmooth;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
