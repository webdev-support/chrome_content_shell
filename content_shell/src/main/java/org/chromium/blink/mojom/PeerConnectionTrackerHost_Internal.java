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
import org.chromium.mojo_base.mojom.ListValue;

class PeerConnectionTrackerHost_Internal {
  private static final int ADD_LEGACY_STATS_ORDINAL = 12;
  private static final int ADD_PEER_CONNECTION_ORDINAL = 0;
  private static final int ADD_STANDARD_STATS_ORDINAL = 11;
  private static final int GET_DISPLAY_MEDIA_FAILURE_ORDINAL = 9;
  private static final int GET_DISPLAY_MEDIA_ORDINAL = 7;
  private static final int GET_DISPLAY_MEDIA_SUCCESS_ORDINAL = 8;
  private static final int GET_USER_MEDIA_FAILURE_ORDINAL = 6;
  private static final int GET_USER_MEDIA_ORDINAL = 4;
  private static final int GET_USER_MEDIA_SUCCESS_ORDINAL = 5;
  public static final Interface.Manager<PeerConnectionTrackerHost, PeerConnectionTrackerHost.Proxy>
      MANAGER =
          new Interface.Manager<PeerConnectionTrackerHost, PeerConnectionTrackerHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.PeerConnectionTrackerHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public PeerConnectionTrackerHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, PeerConnectionTrackerHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public PeerConnectionTrackerHost[] buildArray(int size) {
              return new PeerConnectionTrackerHost[size];
            }
          };
  private static final int ON_PEER_CONNECTION_SESSION_ID_SET_ORDINAL = 3;
  private static final int REMOVE_PEER_CONNECTION_ORDINAL = 1;
  private static final int UPDATE_PEER_CONNECTION_ORDINAL = 2;
  private static final int WEB_RTC_EVENT_LOG_WRITE_ORDINAL = 10;

  PeerConnectionTrackerHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements PeerConnectionTrackerHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void addPeerConnection(PeerConnectionInfo info) {
      PeerConnectionTrackerHostAddPeerConnectionParams _message =
          new PeerConnectionTrackerHostAddPeerConnectionParams();
      _message.info = info;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void removePeerConnection(int lid) {
      PeerConnectionTrackerHostRemovePeerConnectionParams _message =
          new PeerConnectionTrackerHostRemovePeerConnectionParams();
      _message.lid = lid;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void updatePeerConnection(int lid, String type, String value) {
      PeerConnectionTrackerHostUpdatePeerConnectionParams _message =
          new PeerConnectionTrackerHostUpdatePeerConnectionParams();
      _message.lid = lid;
      _message.type = type;
      _message.value = value;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onPeerConnectionSessionIdSet(int lid, String sessionId) {
      PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams _message =
          new PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams();
      _message.lid = lid;
      _message.sessionId = sessionId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void getUserMedia(
        int requestId,
        boolean audio,
        boolean video,
        String audioConstraints,
        String videoConstraints) {
      PeerConnectionTrackerHostGetUserMediaParams _message =
          new PeerConnectionTrackerHostGetUserMediaParams();
      _message.requestId = requestId;
      _message.audio = audio;
      _message.video = video;
      _message.audioConstraints = audioConstraints;
      _message.videoConstraints = videoConstraints;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void getUserMediaSuccess(
        int requestId, String streamId, String audioTrackInfo, String videoTrackInfo) {
      PeerConnectionTrackerHostGetUserMediaSuccessParams _message =
          new PeerConnectionTrackerHostGetUserMediaSuccessParams();
      _message.requestId = requestId;
      _message.streamId = streamId;
      _message.audioTrackInfo = audioTrackInfo;
      _message.videoTrackInfo = videoTrackInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void getUserMediaFailure(int requestId, String error, String errorMessage) {
      PeerConnectionTrackerHostGetUserMediaFailureParams _message =
          new PeerConnectionTrackerHostGetUserMediaFailureParams();
      _message.requestId = requestId;
      _message.error = error;
      _message.errorMessage = errorMessage;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void getDisplayMedia(
        int requestId,
        boolean audio,
        boolean video,
        String audioConstraints,
        String videoConstraints) {
      PeerConnectionTrackerHostGetDisplayMediaParams _message =
          new PeerConnectionTrackerHostGetDisplayMediaParams();
      _message.requestId = requestId;
      _message.audio = audio;
      _message.video = video;
      _message.audioConstraints = audioConstraints;
      _message.videoConstraints = videoConstraints;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void getDisplayMediaSuccess(
        int requestId, String streamId, String audioTrackInfo, String videoTrackInfo) {
      PeerConnectionTrackerHostGetDisplayMediaSuccessParams _message =
          new PeerConnectionTrackerHostGetDisplayMediaSuccessParams();
      _message.requestId = requestId;
      _message.streamId = streamId;
      _message.audioTrackInfo = audioTrackInfo;
      _message.videoTrackInfo = videoTrackInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void getDisplayMediaFailure(int requestId, String error, String errorMessage) {
      PeerConnectionTrackerHostGetDisplayMediaFailureParams _message =
          new PeerConnectionTrackerHostGetDisplayMediaFailureParams();
      _message.requestId = requestId;
      _message.error = error;
      _message.errorMessage = errorMessage;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void webRtcEventLogWrite(int lid, byte[] output) {
      PeerConnectionTrackerHostWebRtcEventLogWriteParams _message =
          new PeerConnectionTrackerHostWebRtcEventLogWriteParams();
      _message.lid = lid;
      _message.output = output;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void addStandardStats(int lid, ListValue value) {
      PeerConnectionTrackerHostAddStandardStatsParams _message =
          new PeerConnectionTrackerHostAddStandardStatsParams();
      _message.lid = lid;
      _message.value = value;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }

    @Override
    public void addLegacyStats(int lid, ListValue value) {
      PeerConnectionTrackerHostAddLegacyStatsParams _message =
          new PeerConnectionTrackerHostAddLegacyStatsParams();
      _message.lid = lid;
      _message.value = value;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }
  }

  public static final class Stub extends Interface.Stub<PeerConnectionTrackerHost> {
    Stub(Core core, PeerConnectionTrackerHost impl) {
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
                PeerConnectionTrackerHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PeerConnectionTrackerHostAddPeerConnectionParams data =
                PeerConnectionTrackerHostAddPeerConnectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().addPeerConnection(data.info);
            return true;
          case 1:
            PeerConnectionTrackerHostRemovePeerConnectionParams data2 =
                PeerConnectionTrackerHostRemovePeerConnectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().removePeerConnection(data2.lid);
            return true;
          case 2:
            PeerConnectionTrackerHostUpdatePeerConnectionParams data3 =
                PeerConnectionTrackerHostUpdatePeerConnectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updatePeerConnection(data3.lid, data3.type, data3.value);
            return true;
          case 3:
            PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams data4 =
                PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onPeerConnectionSessionIdSet(data4.lid, data4.sessionId);
            return true;
          case 4:
            PeerConnectionTrackerHostGetUserMediaParams data5 =
                PeerConnectionTrackerHostGetUserMediaParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getUserMedia(
                    data5.requestId,
                    data5.audio,
                    data5.video,
                    data5.audioConstraints,
                    data5.videoConstraints);
            return true;
          case 5:
            PeerConnectionTrackerHostGetUserMediaSuccessParams data6 =
                PeerConnectionTrackerHostGetUserMediaSuccessParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getUserMediaSuccess(
                    data6.requestId, data6.streamId, data6.audioTrackInfo, data6.videoTrackInfo);
            return true;
          case 6:
            PeerConnectionTrackerHostGetUserMediaFailureParams data7 =
                PeerConnectionTrackerHostGetUserMediaFailureParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().getUserMediaFailure(data7.requestId, data7.error, data7.errorMessage);
            return true;
          case 7:
            PeerConnectionTrackerHostGetDisplayMediaParams data8 =
                PeerConnectionTrackerHostGetDisplayMediaParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getDisplayMedia(
                    data8.requestId,
                    data8.audio,
                    data8.video,
                    data8.audioConstraints,
                    data8.videoConstraints);
            return true;
          case 8:
            PeerConnectionTrackerHostGetDisplayMediaSuccessParams data9 =
                PeerConnectionTrackerHostGetDisplayMediaSuccessParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getDisplayMediaSuccess(
                    data9.requestId, data9.streamId, data9.audioTrackInfo, data9.videoTrackInfo);
            return true;
          case 9:
            PeerConnectionTrackerHostGetDisplayMediaFailureParams data10 =
                PeerConnectionTrackerHostGetDisplayMediaFailureParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().getDisplayMediaFailure(data10.requestId, data10.error, data10.errorMessage);
            return true;
          case 10:
            PeerConnectionTrackerHostWebRtcEventLogWriteParams data11 =
                PeerConnectionTrackerHostWebRtcEventLogWriteParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().webRtcEventLogWrite(data11.lid, data11.output);
            return true;
          case 11:
            PeerConnectionTrackerHostAddStandardStatsParams data12 =
                PeerConnectionTrackerHostAddStandardStatsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().addStandardStats(data12.lid, data12.value);
            return true;
          case 12:
            PeerConnectionTrackerHostAddLegacyStatsParams data13 =
                PeerConnectionTrackerHostAddLegacyStatsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().addLegacyStats(data13.lid, data13.value);
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
                getCore(), PeerConnectionTrackerHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PeerConnectionTrackerHostAddPeerConnectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PeerConnectionInfo info;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostAddPeerConnectionParams(int version) {
      super(16, version);
    }

    public PeerConnectionTrackerHostAddPeerConnectionParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostAddPeerConnectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostAddPeerConnectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostAddPeerConnectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostAddPeerConnectionParams result =
            new PeerConnectionTrackerHostAddPeerConnectionParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.info = PeerConnectionInfo.decode(decoder1);
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

  static final class PeerConnectionTrackerHostRemovePeerConnectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int lid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostRemovePeerConnectionParams(int version) {
      super(16, version);
    }

    public PeerConnectionTrackerHostRemovePeerConnectionParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostRemovePeerConnectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostRemovePeerConnectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostRemovePeerConnectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostRemovePeerConnectionParams result =
            new PeerConnectionTrackerHostRemovePeerConnectionParams(elementsOrVersion);
        result.lid = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.lid, 8);
    }
  }

  static final class PeerConnectionTrackerHostUpdatePeerConnectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int lid;
    public String type;
    public String value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostUpdatePeerConnectionParams(int version) {
      super(32, version);
    }

    public PeerConnectionTrackerHostUpdatePeerConnectionParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostUpdatePeerConnectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostUpdatePeerConnectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostUpdatePeerConnectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostUpdatePeerConnectionParams result =
            new PeerConnectionTrackerHostUpdatePeerConnectionParams(elementsOrVersion);
        result.lid = decoder0.readInt(8);
        result.type = decoder0.readString(16, false);
        result.value = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.lid, 8);
      encoder0.encode(this.type, 16, false);
      encoder0.encode(this.value, 24, false);
    }
  }

  static final class PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int lid;
    public String sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams(int version) {
      super(24, version);
    }

    public PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams result =
            new PeerConnectionTrackerHostOnPeerConnectionSessionIdSetParams(elementsOrVersion);
        result.lid = decoder0.readInt(8);
        result.sessionId = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.lid, 8);
      encoder0.encode(this.sessionId, 16, false);
    }
  }

  static final class PeerConnectionTrackerHostGetUserMediaParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean audio;
    public String audioConstraints;
    public int requestId;
    public boolean video;
    public String videoConstraints;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostGetUserMediaParams(int version) {
      super(32, version);
    }

    public PeerConnectionTrackerHostGetUserMediaParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostGetUserMediaParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostGetUserMediaParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostGetUserMediaParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostGetUserMediaParams result =
            new PeerConnectionTrackerHostGetUserMediaParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        result.audio = decoder0.readBoolean(12, 0);
        result.video = decoder0.readBoolean(12, 1);
        result.audioConstraints = decoder0.readString(16, false);
        result.videoConstraints = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.audio, 12, 0);
      encoder0.encode(this.video, 12, 1);
      encoder0.encode(this.audioConstraints, 16, false);
      encoder0.encode(this.videoConstraints, 24, false);
    }
  }

  static final class PeerConnectionTrackerHostGetUserMediaSuccessParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public String audioTrackInfo;
    public int requestId;
    public String streamId;
    public String videoTrackInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostGetUserMediaSuccessParams(int version) {
      super(40, version);
    }

    public PeerConnectionTrackerHostGetUserMediaSuccessParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostGetUserMediaSuccessParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostGetUserMediaSuccessParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostGetUserMediaSuccessParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostGetUserMediaSuccessParams result =
            new PeerConnectionTrackerHostGetUserMediaSuccessParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        result.streamId = decoder0.readString(16, false);
        result.audioTrackInfo = decoder0.readString(24, false);
        result.videoTrackInfo = decoder0.readString(32, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.streamId, 16, false);
      encoder0.encode(this.audioTrackInfo, 24, false);
      encoder0.encode(this.videoTrackInfo, 32, false);
    }
  }

  static final class PeerConnectionTrackerHostGetUserMediaFailureParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String error;
    public String errorMessage;
    public int requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostGetUserMediaFailureParams(int version) {
      super(32, version);
    }

    public PeerConnectionTrackerHostGetUserMediaFailureParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostGetUserMediaFailureParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostGetUserMediaFailureParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostGetUserMediaFailureParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostGetUserMediaFailureParams result =
            new PeerConnectionTrackerHostGetUserMediaFailureParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        result.error = decoder0.readString(16, false);
        result.errorMessage = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.error, 16, false);
      encoder0.encode(this.errorMessage, 24, false);
    }
  }

  static final class PeerConnectionTrackerHostGetDisplayMediaParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean audio;
    public String audioConstraints;
    public int requestId;
    public boolean video;
    public String videoConstraints;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostGetDisplayMediaParams(int version) {
      super(32, version);
    }

    public PeerConnectionTrackerHostGetDisplayMediaParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostGetDisplayMediaParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostGetDisplayMediaParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostGetDisplayMediaParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostGetDisplayMediaParams result =
            new PeerConnectionTrackerHostGetDisplayMediaParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        result.audio = decoder0.readBoolean(12, 0);
        result.video = decoder0.readBoolean(12, 1);
        result.audioConstraints = decoder0.readString(16, false);
        result.videoConstraints = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.audio, 12, 0);
      encoder0.encode(this.video, 12, 1);
      encoder0.encode(this.audioConstraints, 16, false);
      encoder0.encode(this.videoConstraints, 24, false);
    }
  }

  static final class PeerConnectionTrackerHostGetDisplayMediaSuccessParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public String audioTrackInfo;
    public int requestId;
    public String streamId;
    public String videoTrackInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostGetDisplayMediaSuccessParams(int version) {
      super(40, version);
    }

    public PeerConnectionTrackerHostGetDisplayMediaSuccessParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostGetDisplayMediaSuccessParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostGetDisplayMediaSuccessParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostGetDisplayMediaSuccessParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostGetDisplayMediaSuccessParams result =
            new PeerConnectionTrackerHostGetDisplayMediaSuccessParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        result.streamId = decoder0.readString(16, false);
        result.audioTrackInfo = decoder0.readString(24, false);
        result.videoTrackInfo = decoder0.readString(32, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.streamId, 16, false);
      encoder0.encode(this.audioTrackInfo, 24, false);
      encoder0.encode(this.videoTrackInfo, 32, false);
    }
  }

  static final class PeerConnectionTrackerHostGetDisplayMediaFailureParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String error;
    public String errorMessage;
    public int requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostGetDisplayMediaFailureParams(int version) {
      super(32, version);
    }

    public PeerConnectionTrackerHostGetDisplayMediaFailureParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostGetDisplayMediaFailureParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostGetDisplayMediaFailureParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostGetDisplayMediaFailureParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostGetDisplayMediaFailureParams result =
            new PeerConnectionTrackerHostGetDisplayMediaFailureParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        result.error = decoder0.readString(16, false);
        result.errorMessage = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.error, 16, false);
      encoder0.encode(this.errorMessage, 24, false);
    }
  }

  static final class PeerConnectionTrackerHostWebRtcEventLogWriteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int lid;
    public byte[] output;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostWebRtcEventLogWriteParams(int version) {
      super(24, version);
    }

    public PeerConnectionTrackerHostWebRtcEventLogWriteParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostWebRtcEventLogWriteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostWebRtcEventLogWriteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostWebRtcEventLogWriteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostWebRtcEventLogWriteParams result =
            new PeerConnectionTrackerHostWebRtcEventLogWriteParams(elementsOrVersion);
        result.lid = decoder0.readInt(8);
        result.output = decoder0.readBytes(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.lid, 8);
      encoder0.encode(this.output, 16, 0, -1);
    }
  }

  static final class PeerConnectionTrackerHostAddStandardStatsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int lid;
    public ListValue value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostAddStandardStatsParams(int version) {
      super(24, version);
    }

    public PeerConnectionTrackerHostAddStandardStatsParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostAddStandardStatsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostAddStandardStatsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostAddStandardStatsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostAddStandardStatsParams result =
            new PeerConnectionTrackerHostAddStandardStatsParams(elementsOrVersion);
        result.lid = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.value = ListValue.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.lid, 8);
      encoder0.encode((Struct) this.value, 16, false);
    }
  }

  static final class PeerConnectionTrackerHostAddLegacyStatsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int lid;
    public ListValue value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PeerConnectionTrackerHostAddLegacyStatsParams(int version) {
      super(24, version);
    }

    public PeerConnectionTrackerHostAddLegacyStatsParams() {
      this(0);
    }

    public static PeerConnectionTrackerHostAddLegacyStatsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PeerConnectionTrackerHostAddLegacyStatsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PeerConnectionTrackerHostAddLegacyStatsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PeerConnectionTrackerHostAddLegacyStatsParams result =
            new PeerConnectionTrackerHostAddLegacyStatsParams(elementsOrVersion);
        result.lid = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.value = ListValue.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.lid, 8);
      encoder0.encode((Struct) this.value, 16, false);
    }
  }
}
