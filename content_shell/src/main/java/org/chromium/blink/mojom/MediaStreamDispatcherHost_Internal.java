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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnguessableToken;

class MediaStreamDispatcherHost_Internal {
  private static final int CANCEL_REQUEST_ORDINAL = 1;
  private static final int CLOSE_DEVICE_ORDINAL = 4;
  private static final int GENERATE_STREAMS_ORDINAL = 0;
  private static final int GET_OPEN_DEVICE_ORDINAL = 7;
  private static final int KEEP_DEVICE_ALIVE_FOR_TRANSFER_ORDINAL = 8;
  public static final Interface.Manager<MediaStreamDispatcherHost, MediaStreamDispatcherHost.Proxy>
      MANAGER =
          new Interface.Manager<MediaStreamDispatcherHost, MediaStreamDispatcherHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.MediaStreamDispatcherHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public MediaStreamDispatcherHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, MediaStreamDispatcherHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public MediaStreamDispatcherHost[] buildArray(int size) {
              return new MediaStreamDispatcherHost[size];
            }
          };
  private static final int ON_STREAM_STARTED_ORDINAL = 6;
  private static final int OPEN_DEVICE_ORDINAL = 3;
  private static final int SET_CAPTURING_LINK_SECURED_ORDINAL = 5;
  private static final int STOP_STREAM_DEVICE_ORDINAL = 2;

  MediaStreamDispatcherHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements MediaStreamDispatcherHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void generateStreams(
        int requestId,
        StreamControls controls,
        boolean userGesture,
        StreamSelectionInfo audioStreamSelectionInfo,
        GenerateStreams_Response callback) {
      MediaStreamDispatcherHostGenerateStreamsParams _message =
          new MediaStreamDispatcherHostGenerateStreamsParams();
      _message.requestId = requestId;
      _message.controls = controls;
      _message.userGesture = userGesture;
      _message.audioStreamSelectionInfo = audioStreamSelectionInfo;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new MediaStreamDispatcherHostGenerateStreamsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void cancelRequest(int requestId) {
      MediaStreamDispatcherHostCancelRequestParams _message =
          new MediaStreamDispatcherHostCancelRequestParams();
      _message.requestId = requestId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void stopStreamDevice(String deviceId, UnguessableToken sessionId) {
      MediaStreamDispatcherHostStopStreamDeviceParams _message =
          new MediaStreamDispatcherHostStopStreamDeviceParams();
      _message.deviceId = deviceId;
      _message.sessionId = sessionId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void openDevice(int requestId, String deviceId, int type, OpenDevice_Response callback) {
      MediaStreamDispatcherHostOpenDeviceParams _message =
          new MediaStreamDispatcherHostOpenDeviceParams();
      _message.requestId = requestId;
      _message.deviceId = deviceId;
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new MediaStreamDispatcherHostOpenDeviceResponseParamsForwardToCallback(callback));
    }

    @Override
    public void closeDevice(String label) {
      MediaStreamDispatcherHostCloseDeviceParams _message =
          new MediaStreamDispatcherHostCloseDeviceParams();
      _message.label = label;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void setCapturingLinkSecured(UnguessableToken sessionId, int type, boolean isSecure) {
      MediaStreamDispatcherHostSetCapturingLinkSecuredParams _message =
          new MediaStreamDispatcherHostSetCapturingLinkSecuredParams();
      _message.sessionId = sessionId;
      _message.type = type;
      _message.isSecure = isSecure;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void onStreamStarted(String label) {
      MediaStreamDispatcherHostOnStreamStartedParams _message =
          new MediaStreamDispatcherHostOnStreamStartedParams();
      _message.label = label;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void getOpenDevice(
        int requestId,
        UnguessableToken sessionId,
        UnguessableToken transferId,
        GetOpenDevice_Response callback) {
      MediaStreamDispatcherHostGetOpenDeviceParams _message =
          new MediaStreamDispatcherHostGetOpenDeviceParams();
      _message.requestId = requestId;
      _message.sessionId = sessionId;
      _message.transferId = transferId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new MediaStreamDispatcherHostGetOpenDeviceResponseParamsForwardToCallback(callback));
    }

    @Override
    public void keepDeviceAliveForTransfer(
        UnguessableToken sessionId,
        UnguessableToken transferId,
        KeepDeviceAliveForTransfer_Response callback) {
      MediaStreamDispatcherHostKeepDeviceAliveForTransferParams _message =
          new MediaStreamDispatcherHostKeepDeviceAliveForTransferParams();
      _message.sessionId = sessionId;
      _message.transferId = transferId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<MediaStreamDispatcherHost> {
    Stub(Core core, MediaStreamDispatcherHost impl) {
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
                MediaStreamDispatcherHost_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          case 3:
          default:
            return false;
          case 1:
            getImpl()
                .cancelRequest(
                    MediaStreamDispatcherHostCancelRequestParams.deserialize(
                            messageWithHeader.getPayload())
                        .requestId);
            return true;
          case 2:
            MediaStreamDispatcherHostStopStreamDeviceParams data =
                MediaStreamDispatcherHostStopStreamDeviceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().stopStreamDevice(data.deviceId, data.sessionId);
            return true;
          case 4:
            MediaStreamDispatcherHostCloseDeviceParams data2 =
                MediaStreamDispatcherHostCloseDeviceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().closeDevice(data2.label);
            return true;
          case 5:
            MediaStreamDispatcherHostSetCapturingLinkSecuredParams data3 =
                MediaStreamDispatcherHostSetCapturingLinkSecuredParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setCapturingLinkSecured(data3.sessionId, data3.type, data3.isSecure);
            return true;
          case 6:
            MediaStreamDispatcherHostOnStreamStartedParams data4 =
                MediaStreamDispatcherHostOnStreamStartedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onStreamStarted(data4.label);
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
                getCore(), MediaStreamDispatcherHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            MediaStreamDispatcherHostGenerateStreamsParams data =
                MediaStreamDispatcherHostGenerateStreamsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .generateStreams(
                    data.requestId,
                    data.controls,
                    data.userGesture,
                    data.audioStreamSelectionInfo,
                    new MediaStreamDispatcherHostGenerateStreamsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            MediaStreamDispatcherHostOpenDeviceParams data2 =
                MediaStreamDispatcherHostOpenDeviceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .openDevice(
                    data2.requestId,
                    data2.deviceId,
                    data2.type,
                    new MediaStreamDispatcherHostOpenDeviceResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            MediaStreamDispatcherHostGetOpenDeviceParams data3 =
                MediaStreamDispatcherHostGetOpenDeviceParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getOpenDevice(
                    data3.requestId,
                    data3.sessionId,
                    data3.transferId,
                    new MediaStreamDispatcherHostGetOpenDeviceResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            MediaStreamDispatcherHostKeepDeviceAliveForTransferParams data4 =
                MediaStreamDispatcherHostKeepDeviceAliveForTransferParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .keepDeviceAliveForTransfer(
                    data4.sessionId,
                    data4.transferId,
                    new MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParamsProxyToResponder(
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

  static final class MediaStreamDispatcherHostGenerateStreamsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public StreamSelectionInfo audioStreamSelectionInfo;
    public StreamControls controls;
    public int requestId;
    public boolean userGesture;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostGenerateStreamsParams(int version) {
      super(32, version);
    }

    public MediaStreamDispatcherHostGenerateStreamsParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostGenerateStreamsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostGenerateStreamsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostGenerateStreamsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostGenerateStreamsParams result =
            new MediaStreamDispatcherHostGenerateStreamsParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        result.userGesture = decoder0.readBoolean(12, 0);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.controls = StreamControls.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.audioStreamSelectionInfo = StreamSelectionInfo.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.userGesture, 12, 0);
      encoder0.encode((Struct) this.controls, 16, false);
      encoder0.encode((Struct) this.audioStreamSelectionInfo, 24, false);
    }
  }

  static final class MediaStreamDispatcherHostGenerateStreamsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String label;
    public boolean panTiltZoomAllowed;
    public int result;
    public StreamDevicesSet streamDevices;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostGenerateStreamsResponseParams(int version) {
      super(32, version);
    }

    public MediaStreamDispatcherHostGenerateStreamsResponseParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostGenerateStreamsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostGenerateStreamsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostGenerateStreamsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostGenerateStreamsResponseParams result =
            new MediaStreamDispatcherHostGenerateStreamsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        MediaStreamRequestResult.validate(readInt);
        result.result = MediaStreamRequestResult.toKnownValue(result.result);
        result.panTiltZoomAllowed = decoder0.readBoolean(12, 0);
        result.label = decoder0.readString(16, false);
        Decoder decoder1 = decoder0.readPointer(24, true);
        result.streamDevices = StreamDevicesSet.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode(this.panTiltZoomAllowed, 12, 0);
      encoder0.encode(this.label, 16, false);
      encoder0.encode((Struct) this.streamDevices, 24, true);
    }
  }

  static class MediaStreamDispatcherHostGenerateStreamsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final MediaStreamDispatcherHost.GenerateStreams_Response mCallback;

    MediaStreamDispatcherHostGenerateStreamsResponseParamsForwardToCallback(
        MediaStreamDispatcherHost.GenerateStreams_Response callback) {
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
        MediaStreamDispatcherHostGenerateStreamsResponseParams response =
            MediaStreamDispatcherHostGenerateStreamsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(
            response.result, response.label, response.streamDevices, response.panTiltZoomAllowed);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class MediaStreamDispatcherHostGenerateStreamsResponseParamsProxyToResponder
      implements MediaStreamDispatcherHost.GenerateStreams_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    MediaStreamDispatcherHostGenerateStreamsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        int result, String label, StreamDevicesSet streamDevices, boolean panTiltZoomAllowed) {
      MediaStreamDispatcherHostGenerateStreamsResponseParams _response =
          new MediaStreamDispatcherHostGenerateStreamsResponseParams();
      _response.result = result;
      _response.label = label;
      _response.streamDevices = streamDevices;
      _response.panTiltZoomAllowed = panTiltZoomAllowed;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class MediaStreamDispatcherHostCancelRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostCancelRequestParams(int version) {
      super(16, version);
    }

    public MediaStreamDispatcherHostCancelRequestParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostCancelRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostCancelRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostCancelRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostCancelRequestParams result =
            new MediaStreamDispatcherHostCancelRequestParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
    }
  }

  static final class MediaStreamDispatcherHostStopStreamDeviceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String deviceId;
    public UnguessableToken sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostStopStreamDeviceParams(int version) {
      super(24, version);
    }

    public MediaStreamDispatcherHostStopStreamDeviceParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostStopStreamDeviceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostStopStreamDeviceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostStopStreamDeviceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostStopStreamDeviceParams result =
            new MediaStreamDispatcherHostStopStreamDeviceParams(elementsOrVersion);
        result.deviceId = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.sessionId = UnguessableToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.deviceId, 8, false);
      encoder0.encode((Struct) this.sessionId, 16, true);
    }
  }

  static final class MediaStreamDispatcherHostOpenDeviceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String deviceId;
    public int requestId;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostOpenDeviceParams(int version) {
      super(24, version);
    }

    public MediaStreamDispatcherHostOpenDeviceParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostOpenDeviceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostOpenDeviceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostOpenDeviceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostOpenDeviceParams result =
            new MediaStreamDispatcherHostOpenDeviceParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        int readInt = decoder0.readInt(12);
        result.type = readInt;
        MediaStreamType.validate(readInt);
        result.type = MediaStreamType.toKnownValue(result.type);
        result.deviceId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.type, 12);
      encoder0.encode(this.deviceId, 16, false);
    }
  }

  static final class MediaStreamDispatcherHostOpenDeviceResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaStreamDevice device;
    public String label;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostOpenDeviceResponseParams(int version) {
      super(32, version);
    }

    public MediaStreamDispatcherHostOpenDeviceResponseParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostOpenDeviceResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostOpenDeviceResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostOpenDeviceResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostOpenDeviceResponseParams result =
            new MediaStreamDispatcherHostOpenDeviceResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        result.label = decoder0.readString(16, false);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.device = MediaStreamDevice.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
      encoder0.encode(this.label, 16, false);
      encoder0.encode((Struct) this.device, 24, false);
    }
  }

  static class MediaStreamDispatcherHostOpenDeviceResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final MediaStreamDispatcherHost.OpenDevice_Response mCallback;

    MediaStreamDispatcherHostOpenDeviceResponseParamsForwardToCallback(
        MediaStreamDispatcherHost.OpenDevice_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        MediaStreamDispatcherHostOpenDeviceResponseParams response =
            MediaStreamDispatcherHostOpenDeviceResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success, response.label, response.device);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class MediaStreamDispatcherHostOpenDeviceResponseParamsProxyToResponder
      implements MediaStreamDispatcherHost.OpenDevice_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    MediaStreamDispatcherHostOpenDeviceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success, String label, MediaStreamDevice device) {
      MediaStreamDispatcherHostOpenDeviceResponseParams _response =
          new MediaStreamDispatcherHostOpenDeviceResponseParams();
      _response.success = success;
      _response.label = label;
      _response.device = device;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class MediaStreamDispatcherHostCloseDeviceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String label;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostCloseDeviceParams(int version) {
      super(16, version);
    }

    public MediaStreamDispatcherHostCloseDeviceParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostCloseDeviceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostCloseDeviceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostCloseDeviceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostCloseDeviceParams result =
            new MediaStreamDispatcherHostCloseDeviceParams(elementsOrVersion);
        result.label = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.label, 8, false);
    }
  }

  static final class MediaStreamDispatcherHostSetCapturingLinkSecuredParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isSecure;
    public UnguessableToken sessionId;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostSetCapturingLinkSecuredParams(int version) {
      super(24, version);
    }

    public MediaStreamDispatcherHostSetCapturingLinkSecuredParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostSetCapturingLinkSecuredParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostSetCapturingLinkSecuredParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostSetCapturingLinkSecuredParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostSetCapturingLinkSecuredParams result =
            new MediaStreamDispatcherHostSetCapturingLinkSecuredParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.sessionId = UnguessableToken.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.type = readInt;
        MediaStreamType.validate(readInt);
        result.type = MediaStreamType.toKnownValue(result.type);
        result.isSecure = decoder0.readBoolean(20, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sessionId, 8, true);
      encoder0.encode(this.type, 16);
      encoder0.encode(this.isSecure, 20, 0);
    }
  }

  static final class MediaStreamDispatcherHostOnStreamStartedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String label;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostOnStreamStartedParams(int version) {
      super(16, version);
    }

    public MediaStreamDispatcherHostOnStreamStartedParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostOnStreamStartedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostOnStreamStartedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostOnStreamStartedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostOnStreamStartedParams result =
            new MediaStreamDispatcherHostOnStreamStartedParams(elementsOrVersion);
        result.label = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.label, 8, false);
    }
  }

  static final class MediaStreamDispatcherHostGetOpenDeviceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int requestId;
    public UnguessableToken sessionId;
    public UnguessableToken transferId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostGetOpenDeviceParams(int version) {
      super(32, version);
    }

    public MediaStreamDispatcherHostGetOpenDeviceParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostGetOpenDeviceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostGetOpenDeviceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostGetOpenDeviceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostGetOpenDeviceParams result =
            new MediaStreamDispatcherHostGetOpenDeviceParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.sessionId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.transferId = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode((Struct) this.sessionId, 16, false);
      encoder0.encode((Struct) this.transferId, 24, false);
    }
  }

  static final class MediaStreamDispatcherHostGetOpenDeviceResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public GetOpenDeviceResponse response;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostGetOpenDeviceResponseParams(int version) {
      super(24, version);
    }

    public MediaStreamDispatcherHostGetOpenDeviceResponseParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostGetOpenDeviceResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostGetOpenDeviceResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostGetOpenDeviceResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostGetOpenDeviceResponseParams result =
            new MediaStreamDispatcherHostGetOpenDeviceResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.result = readInt;
        MediaStreamRequestResult.validate(readInt);
        result.result = MediaStreamRequestResult.toKnownValue(result.result);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.response = GetOpenDeviceResponse.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Struct) this.response, 16, true);
    }
  }

  static class MediaStreamDispatcherHostGetOpenDeviceResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final MediaStreamDispatcherHost.GetOpenDevice_Response mCallback;

    MediaStreamDispatcherHostGetOpenDeviceResponseParamsForwardToCallback(
        MediaStreamDispatcherHost.GetOpenDevice_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(7, 6)) {
          return false;
        }
        MediaStreamDispatcherHostGetOpenDeviceResponseParams response =
            MediaStreamDispatcherHostGetOpenDeviceResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.response);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class MediaStreamDispatcherHostGetOpenDeviceResponseParamsProxyToResponder
      implements MediaStreamDispatcherHost.GetOpenDevice_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    MediaStreamDispatcherHostGetOpenDeviceResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int result, GetOpenDeviceResponse response) {
      MediaStreamDispatcherHostGetOpenDeviceResponseParams _response =
          new MediaStreamDispatcherHostGetOpenDeviceResponseParams();
      _response.result = result;
      _response.response = response;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class MediaStreamDispatcherHostKeepDeviceAliveForTransferParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken sessionId;
    public UnguessableToken transferId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostKeepDeviceAliveForTransferParams(int version) {
      super(24, version);
    }

    public MediaStreamDispatcherHostKeepDeviceAliveForTransferParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostKeepDeviceAliveForTransferParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostKeepDeviceAliveForTransferParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostKeepDeviceAliveForTransferParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostKeepDeviceAliveForTransferParams result =
            new MediaStreamDispatcherHostKeepDeviceAliveForTransferParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.sessionId = UnguessableToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.transferId = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sessionId, 8, false);
      encoder0.encode((Struct) this.transferId, 16, false);
    }
  }

  static final class MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean deviceFound;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams(int version) {
      super(16, version);
    }

    public MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams() {
      this(0);
    }

    public static MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams result =
            new MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams(
                elementsOrVersion);
        result.deviceFound = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.deviceFound, 8, 0);
    }
  }

  static class MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final MediaStreamDispatcherHost.KeepDeviceAliveForTransfer_Response mCallback;

    MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParamsForwardToCallback(
        MediaStreamDispatcherHost.KeepDeviceAliveForTransfer_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(8, 2)) {
          return false;
        }
        MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams response =
            MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.deviceFound);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParamsProxyToResponder
      implements MediaStreamDispatcherHost.KeepDeviceAliveForTransfer_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean deviceFound) {
      MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams _response =
          new MediaStreamDispatcherHostKeepDeviceAliveForTransferResponseParams();
      _response.deviceFound = deviceFound;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
