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
import org.chromium.mojo_base.mojom.UnguessableToken;

class VideoCaptureHost_Internal {
  private static final int GET_DEVICE_FORMATS_IN_USE_ORDINAL = 7;
  private static final int GET_DEVICE_SUPPORTED_FORMATS_ORDINAL = 6;
  public static final Interface.Manager<VideoCaptureHost, VideoCaptureHost.Proxy> MANAGER =
      new Interface.Manager<VideoCaptureHost, VideoCaptureHost.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.VideoCaptureHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public VideoCaptureHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, VideoCaptureHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public VideoCaptureHost[] buildArray(int size) {
          return new VideoCaptureHost[size];
        }
      };
  private static final int ON_LOG_ORDINAL = 8;
  private static final int PAUSE_ORDINAL = 2;
  private static final int RELEASE_BUFFER_ORDINAL = 5;
  private static final int REQUEST_REFRESH_FRAME_ORDINAL = 4;
  private static final int RESUME_ORDINAL = 3;
  private static final int START_ORDINAL = 0;
  private static final int STOP_ORDINAL = 1;

  VideoCaptureHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements VideoCaptureHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void start(
        UnguessableToken deviceId,
        UnguessableToken sessionId,
        VideoCaptureParams params,
        VideoCaptureObserver observer) {
      VideoCaptureHostStartParams _message = new VideoCaptureHostStartParams();
      _message.deviceId = deviceId;
      _message.sessionId = sessionId;
      _message.params = params;
      _message.observer = observer;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void stop(UnguessableToken deviceId) {
      VideoCaptureHostStopParams _message = new VideoCaptureHostStopParams();
      _message.deviceId = deviceId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void pause(UnguessableToken deviceId) {
      VideoCaptureHostPauseParams _message = new VideoCaptureHostPauseParams();
      _message.deviceId = deviceId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void resume(
        UnguessableToken deviceId, UnguessableToken sessionId, VideoCaptureParams params) {
      VideoCaptureHostResumeParams _message = new VideoCaptureHostResumeParams();
      _message.deviceId = deviceId;
      _message.sessionId = sessionId;
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void requestRefreshFrame(UnguessableToken deviceId) {
      VideoCaptureHostRequestRefreshFrameParams _message =
          new VideoCaptureHostRequestRefreshFrameParams();
      _message.deviceId = deviceId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void releaseBuffer(
        UnguessableToken deviceId, int bufferId, VideoCaptureFeedback feedback) {
      VideoCaptureHostReleaseBufferParams _message = new VideoCaptureHostReleaseBufferParams();
      _message.deviceId = deviceId;
      _message.bufferId = bufferId;
      _message.feedback = feedback;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void getDeviceSupportedFormats(
        UnguessableToken deviceId,
        UnguessableToken sessionId,
        GetDeviceSupportedFormats_Response callback) {
      VideoCaptureHostGetDeviceSupportedFormatsParams _message =
          new VideoCaptureHostGetDeviceSupportedFormatsParams();
      _message.deviceId = deviceId;
      _message.sessionId = sessionId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new VideoCaptureHostGetDeviceSupportedFormatsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getDeviceFormatsInUse(
        UnguessableToken deviceId,
        UnguessableToken sessionId,
        GetDeviceFormatsInUse_Response callback) {
      VideoCaptureHostGetDeviceFormatsInUseParams _message =
          new VideoCaptureHostGetDeviceFormatsInUseParams();
      _message.deviceId = deviceId;
      _message.sessionId = sessionId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new VideoCaptureHostGetDeviceFormatsInUseResponseParamsForwardToCallback(callback));
    }

    @Override
    public void onLog(UnguessableToken deviceId, String message) {
      VideoCaptureHostOnLogParams _message = new VideoCaptureHostOnLogParams();
      _message.deviceId = deviceId;
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }
  }

  public static final class Stub extends Interface.Stub<VideoCaptureHost> {
    Stub(Core core, VideoCaptureHost impl) {
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
                VideoCaptureHost_Internal.MANAGER, messageWithHeader);
          case -1:
          case 6:
          case 7:
          default:
            return false;
          case 0:
            VideoCaptureHostStartParams data =
                VideoCaptureHostStartParams.deserialize(messageWithHeader.getPayload());
            getImpl().start(data.deviceId, data.sessionId, data.params, data.observer);
            return true;
          case 1:
            getImpl()
                .stop(
                    VideoCaptureHostStopParams.deserialize(messageWithHeader.getPayload())
                        .deviceId);
            return true;
          case 2:
            getImpl()
                .pause(
                    VideoCaptureHostPauseParams.deserialize(messageWithHeader.getPayload())
                        .deviceId);
            return true;
          case 3:
            VideoCaptureHostResumeParams data2 =
                VideoCaptureHostResumeParams.deserialize(messageWithHeader.getPayload());
            getImpl().resume(data2.deviceId, data2.sessionId, data2.params);
            return true;
          case 4:
            getImpl()
                .requestRefreshFrame(
                    VideoCaptureHostRequestRefreshFrameParams.deserialize(
                            messageWithHeader.getPayload())
                        .deviceId);
            return true;
          case 5:
            VideoCaptureHostReleaseBufferParams data3 =
                VideoCaptureHostReleaseBufferParams.deserialize(messageWithHeader.getPayload());
            getImpl().releaseBuffer(data3.deviceId, data3.bufferId, data3.feedback);
            return true;
          case 8:
            VideoCaptureHostOnLogParams data4 =
                VideoCaptureHostOnLogParams.deserialize(messageWithHeader.getPayload());
            getImpl().onLog(data4.deviceId, data4.message);
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
                getCore(), VideoCaptureHost_Internal.MANAGER, messageWithHeader, receiver);
          case 6:
            VideoCaptureHostGetDeviceSupportedFormatsParams data =
                VideoCaptureHostGetDeviceSupportedFormatsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getDeviceSupportedFormats(
                    data.deviceId,
                    data.sessionId,
                    new VideoCaptureHostGetDeviceSupportedFormatsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            VideoCaptureHostGetDeviceFormatsInUseParams data2 =
                VideoCaptureHostGetDeviceFormatsInUseParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getDeviceFormatsInUse(
                    data2.deviceId,
                    data2.sessionId,
                    new VideoCaptureHostGetDeviceFormatsInUseResponseParamsProxyToResponder(
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

  static final class VideoCaptureHostStartParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken deviceId;
    public VideoCaptureObserver observer;
    public VideoCaptureParams params;
    public UnguessableToken sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoCaptureHostStartParams(int version) {
      super(40, version);
    }

    public VideoCaptureHostStartParams() {
      this(0);
    }

    public static VideoCaptureHostStartParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoCaptureHostStartParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureHostStartParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoCaptureHostStartParams result = new VideoCaptureHostStartParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.sessionId = UnguessableToken.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.params = VideoCaptureParams.decode(decoder13);
        result.observer =
            (VideoCaptureObserver)
                decoder0.readServiceInterface(32, false, VideoCaptureObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.deviceId, 8, false);
      encoder0.encode((Struct) this.sessionId, 16, false);
      encoder0.encode((Struct) this.params, 24, false);
      encoder0.encode(this.observer, 32, false, VideoCaptureObserver.MANAGER);
    }
  }

  static final class VideoCaptureHostStopParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken deviceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoCaptureHostStopParams(int version) {
      super(16, version);
    }

    public VideoCaptureHostStopParams() {
      this(0);
    }

    public static VideoCaptureHostStopParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoCaptureHostStopParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureHostStopParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoCaptureHostStopParams result = new VideoCaptureHostStopParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceId = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.deviceId, 8, false);
    }
  }

  static final class VideoCaptureHostPauseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken deviceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoCaptureHostPauseParams(int version) {
      super(16, version);
    }

    public VideoCaptureHostPauseParams() {
      this(0);
    }

    public static VideoCaptureHostPauseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoCaptureHostPauseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureHostPauseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoCaptureHostPauseParams result = new VideoCaptureHostPauseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceId = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.deviceId, 8, false);
    }
  }

  static final class VideoCaptureHostResumeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken deviceId;
    public VideoCaptureParams params;
    public UnguessableToken sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoCaptureHostResumeParams(int version) {
      super(32, version);
    }

    public VideoCaptureHostResumeParams() {
      this(0);
    }

    public static VideoCaptureHostResumeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoCaptureHostResumeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureHostResumeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoCaptureHostResumeParams result = new VideoCaptureHostResumeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.sessionId = UnguessableToken.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.params = VideoCaptureParams.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.deviceId, 8, false);
      encoder0.encode((Struct) this.sessionId, 16, false);
      encoder0.encode((Struct) this.params, 24, false);
    }
  }

  static final class VideoCaptureHostRequestRefreshFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken deviceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoCaptureHostRequestRefreshFrameParams(int version) {
      super(16, version);
    }

    public VideoCaptureHostRequestRefreshFrameParams() {
      this(0);
    }

    public static VideoCaptureHostRequestRefreshFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoCaptureHostRequestRefreshFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureHostRequestRefreshFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoCaptureHostRequestRefreshFrameParams result =
            new VideoCaptureHostRequestRefreshFrameParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceId = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.deviceId, 8, false);
    }
  }

  static final class VideoCaptureHostReleaseBufferParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int bufferId;
    public UnguessableToken deviceId;
    public VideoCaptureFeedback feedback;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoCaptureHostReleaseBufferParams(int version) {
      super(32, version);
    }

    public VideoCaptureHostReleaseBufferParams() {
      this(0);
    }

    public static VideoCaptureHostReleaseBufferParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoCaptureHostReleaseBufferParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureHostReleaseBufferParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoCaptureHostReleaseBufferParams result =
            new VideoCaptureHostReleaseBufferParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceId = UnguessableToken.decode(decoder1);
        result.bufferId = decoder0.readInt(16);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.feedback = VideoCaptureFeedback.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.deviceId, 8, false);
      encoder0.encode(this.bufferId, 16);
      encoder0.encode((Struct) this.feedback, 24, false);
    }
  }

  static final class VideoCaptureHostGetDeviceSupportedFormatsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken deviceId;
    public UnguessableToken sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoCaptureHostGetDeviceSupportedFormatsParams(int version) {
      super(24, version);
    }

    public VideoCaptureHostGetDeviceSupportedFormatsParams() {
      this(0);
    }

    public static VideoCaptureHostGetDeviceSupportedFormatsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoCaptureHostGetDeviceSupportedFormatsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureHostGetDeviceSupportedFormatsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoCaptureHostGetDeviceSupportedFormatsParams result =
            new VideoCaptureHostGetDeviceSupportedFormatsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.sessionId = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.deviceId, 8, false);
      encoder0.encode((Struct) this.sessionId, 16, false);
    }
  }

  static final class VideoCaptureHostGetDeviceSupportedFormatsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public VideoCaptureFormat[] formatsSupported;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoCaptureHostGetDeviceSupportedFormatsResponseParams(int version) {
      super(16, version);
    }

    public VideoCaptureHostGetDeviceSupportedFormatsResponseParams() {
      this(0);
    }

    public static VideoCaptureHostGetDeviceSupportedFormatsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static VideoCaptureHostGetDeviceSupportedFormatsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureHostGetDeviceSupportedFormatsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoCaptureHostGetDeviceSupportedFormatsResponseParams result =
            new VideoCaptureHostGetDeviceSupportedFormatsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.formatsSupported = new VideoCaptureFormat[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.formatsSupported[i1] = VideoCaptureFormat.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      VideoCaptureFormat[] videoCaptureFormatArr = this.formatsSupported;
      if (videoCaptureFormatArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(videoCaptureFormatArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        VideoCaptureFormat[] videoCaptureFormatArr2 = this.formatsSupported;
        if (i0 < videoCaptureFormatArr2.length) {
          encoder1.encode((Struct) videoCaptureFormatArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class VideoCaptureHostGetDeviceSupportedFormatsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VideoCaptureHost.GetDeviceSupportedFormats_Response mCallback;

    VideoCaptureHostGetDeviceSupportedFormatsResponseParamsForwardToCallback(
        VideoCaptureHost.GetDeviceSupportedFormats_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 2)) {
          return false;
        }
        VideoCaptureHostGetDeviceSupportedFormatsResponseParams response =
            VideoCaptureHostGetDeviceSupportedFormatsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.formatsSupported);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VideoCaptureHostGetDeviceSupportedFormatsResponseParamsProxyToResponder
      implements VideoCaptureHost.GetDeviceSupportedFormats_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoCaptureHostGetDeviceSupportedFormatsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(VideoCaptureFormat[] formatsSupported) {
      VideoCaptureHostGetDeviceSupportedFormatsResponseParams _response =
          new VideoCaptureHostGetDeviceSupportedFormatsResponseParams();
      _response.formatsSupported = formatsSupported;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VideoCaptureHostGetDeviceFormatsInUseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken deviceId;
    public UnguessableToken sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoCaptureHostGetDeviceFormatsInUseParams(int version) {
      super(24, version);
    }

    public VideoCaptureHostGetDeviceFormatsInUseParams() {
      this(0);
    }

    public static VideoCaptureHostGetDeviceFormatsInUseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoCaptureHostGetDeviceFormatsInUseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureHostGetDeviceFormatsInUseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoCaptureHostGetDeviceFormatsInUseParams result =
            new VideoCaptureHostGetDeviceFormatsInUseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.sessionId = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.deviceId, 8, false);
      encoder0.encode((Struct) this.sessionId, 16, false);
    }
  }

  static final class VideoCaptureHostGetDeviceFormatsInUseResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public VideoCaptureFormat[] formatsInUse;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoCaptureHostGetDeviceFormatsInUseResponseParams(int version) {
      super(16, version);
    }

    public VideoCaptureHostGetDeviceFormatsInUseResponseParams() {
      this(0);
    }

    public static VideoCaptureHostGetDeviceFormatsInUseResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoCaptureHostGetDeviceFormatsInUseResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureHostGetDeviceFormatsInUseResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoCaptureHostGetDeviceFormatsInUseResponseParams result =
            new VideoCaptureHostGetDeviceFormatsInUseResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.formatsInUse = new VideoCaptureFormat[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.formatsInUse[i1] = VideoCaptureFormat.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      VideoCaptureFormat[] videoCaptureFormatArr = this.formatsInUse;
      if (videoCaptureFormatArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(videoCaptureFormatArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        VideoCaptureFormat[] videoCaptureFormatArr2 = this.formatsInUse;
        if (i0 < videoCaptureFormatArr2.length) {
          encoder1.encode((Struct) videoCaptureFormatArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class VideoCaptureHostGetDeviceFormatsInUseResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final VideoCaptureHost.GetDeviceFormatsInUse_Response mCallback;

    VideoCaptureHostGetDeviceFormatsInUseResponseParamsForwardToCallback(
        VideoCaptureHost.GetDeviceFormatsInUse_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(7, 2)) {
          return false;
        }
        VideoCaptureHostGetDeviceFormatsInUseResponseParams response =
            VideoCaptureHostGetDeviceFormatsInUseResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.formatsInUse);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class VideoCaptureHostGetDeviceFormatsInUseResponseParamsProxyToResponder
      implements VideoCaptureHost.GetDeviceFormatsInUse_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    VideoCaptureHostGetDeviceFormatsInUseResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(VideoCaptureFormat[] formatsInUse) {
      VideoCaptureHostGetDeviceFormatsInUseResponseParams _response =
          new VideoCaptureHostGetDeviceFormatsInUseResponseParams();
      _response.formatsInUse = formatsInUse;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class VideoCaptureHostOnLogParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken deviceId;
    public String message;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private VideoCaptureHostOnLogParams(int version) {
      super(24, version);
    }

    public VideoCaptureHostOnLogParams() {
      this(0);
    }

    public static VideoCaptureHostOnLogParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static VideoCaptureHostOnLogParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureHostOnLogParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        VideoCaptureHostOnLogParams result = new VideoCaptureHostOnLogParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.deviceId = UnguessableToken.decode(decoder1);
        result.message = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.deviceId, 8, false);
      encoder0.encode(this.message, 16, false);
    }
  }
}
