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
import org.chromium.mojo_base.mojom.TimeDelta;

class WatchTimeRecorder_Internal {
  private static final int FINALIZE_WATCH_TIME_ORDINAL = 1;
  public static final Interface.Manager<WatchTimeRecorder, WatchTimeRecorder.Proxy> MANAGER =
      new Interface.Manager<WatchTimeRecorder, WatchTimeRecorder.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.WatchTimeRecorder";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WatchTimeRecorder.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WatchTimeRecorder impl) {
          return new Stub(core, impl);
        }

        @Override
        public WatchTimeRecorder[] buildArray(int size) {
          return new WatchTimeRecorder[size];
        }
      };
  private static final int ON_DURATION_CHANGED_ORDINAL = 5;
  private static final int ON_ERROR_ORDINAL = 2;
  private static final int RECORD_WATCH_TIME_ORDINAL = 0;
  private static final int SET_AUTOPLAY_INITIATED_ORDINAL = 4;
  private static final int UPDATE_SECONDARY_PROPERTIES_ORDINAL = 3;
  private static final int UPDATE_UNDERFLOW_COUNT_ORDINAL = 7;
  private static final int UPDATE_UNDERFLOW_DURATION_ORDINAL = 8;
  private static final int UPDATE_VIDEO_DECODE_STATS_ORDINAL = 6;

  WatchTimeRecorder_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WatchTimeRecorder.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void recordWatchTime(int key, TimeDelta watchTime) {
      WatchTimeRecorderRecordWatchTimeParams _message =
          new WatchTimeRecorderRecordWatchTimeParams();
      _message.key = key;
      _message.watchTime = watchTime;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void finalizeWatchTime(int[] watchTimeKeys) {
      WatchTimeRecorderFinalizeWatchTimeParams _message =
          new WatchTimeRecorderFinalizeWatchTimeParams();
      _message.watchTimeKeys = watchTimeKeys;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onError(PipelineStatus status) {
      WatchTimeRecorderOnErrorParams _message = new WatchTimeRecorderOnErrorParams();
      _message.status = status;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void updateSecondaryProperties(SecondaryPlaybackProperties secondaryProperties) {
      WatchTimeRecorderUpdateSecondaryPropertiesParams _message =
          new WatchTimeRecorderUpdateSecondaryPropertiesParams();
      _message.secondaryProperties = secondaryProperties;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void setAutoplayInitiated(boolean value) {
      WatchTimeRecorderSetAutoplayInitiatedParams _message =
          new WatchTimeRecorderSetAutoplayInitiatedParams();
      _message.value = value;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onDurationChanged(TimeDelta duration) {
      WatchTimeRecorderOnDurationChangedParams _message =
          new WatchTimeRecorderOnDurationChangedParams();
      _message.duration = duration;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void updateVideoDecodeStats(int framesDecoded, int framesDropped) {
      WatchTimeRecorderUpdateVideoDecodeStatsParams _message =
          new WatchTimeRecorderUpdateVideoDecodeStatsParams();
      _message.framesDecoded = framesDecoded;
      _message.framesDropped = framesDropped;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void updateUnderflowCount(int totalCount) {
      WatchTimeRecorderUpdateUnderflowCountParams _message =
          new WatchTimeRecorderUpdateUnderflowCountParams();
      _message.totalCount = totalCount;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void updateUnderflowDuration(int totalCompletedCount, TimeDelta totalDuration) {
      WatchTimeRecorderUpdateUnderflowDurationParams _message =
          new WatchTimeRecorderUpdateUnderflowDurationParams();
      _message.totalCompletedCount = totalCompletedCount;
      _message.totalDuration = totalDuration;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }
  }

  public static final class Stub extends Interface.Stub<WatchTimeRecorder> {
    Stub(Core core, WatchTimeRecorder impl) {
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
                WatchTimeRecorder_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WatchTimeRecorderRecordWatchTimeParams data =
                WatchTimeRecorderRecordWatchTimeParams.deserialize(messageWithHeader.getPayload());
            getImpl().recordWatchTime(data.key, data.watchTime);
            return true;
          case 1:
            getImpl()
                .finalizeWatchTime(
                    WatchTimeRecorderFinalizeWatchTimeParams.deserialize(
                            messageWithHeader.getPayload())
                        .watchTimeKeys);
            return true;
          case 2:
            getImpl()
                .onError(
                    WatchTimeRecorderOnErrorParams.deserialize(messageWithHeader.getPayload())
                        .status);
            return true;
          case 3:
            getImpl()
                .updateSecondaryProperties(
                    WatchTimeRecorderUpdateSecondaryPropertiesParams.deserialize(
                            messageWithHeader.getPayload())
                        .secondaryProperties);
            return true;
          case 4:
            getImpl()
                .setAutoplayInitiated(
                    WatchTimeRecorderSetAutoplayInitiatedParams.deserialize(
                            messageWithHeader.getPayload())
                        .value);
            return true;
          case 5:
            getImpl()
                .onDurationChanged(
                    WatchTimeRecorderOnDurationChangedParams.deserialize(
                            messageWithHeader.getPayload())
                        .duration);
            return true;
          case 6:
            WatchTimeRecorderUpdateVideoDecodeStatsParams data2 =
                WatchTimeRecorderUpdateVideoDecodeStatsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateVideoDecodeStats(data2.framesDecoded, data2.framesDropped);
            return true;
          case 7:
            getImpl()
                .updateUnderflowCount(
                    WatchTimeRecorderUpdateUnderflowCountParams.deserialize(
                            messageWithHeader.getPayload())
                        .totalCount);
            return true;
          case 8:
            WatchTimeRecorderUpdateUnderflowDurationParams data3 =
                WatchTimeRecorderUpdateUnderflowDurationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateUnderflowDuration(data3.totalCompletedCount, data3.totalDuration);
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
                getCore(), WatchTimeRecorder_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WatchTimeRecorderRecordWatchTimeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int key;
    public TimeDelta watchTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WatchTimeRecorderRecordWatchTimeParams(int version) {
      super(24, version);
    }

    public WatchTimeRecorderRecordWatchTimeParams() {
      this(0);
    }

    public static WatchTimeRecorderRecordWatchTimeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WatchTimeRecorderRecordWatchTimeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WatchTimeRecorderRecordWatchTimeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WatchTimeRecorderRecordWatchTimeParams result =
            new WatchTimeRecorderRecordWatchTimeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.key = readInt;
        WatchTimeKey.validate(readInt);
        result.key = WatchTimeKey.toKnownValue(result.key);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.watchTime = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.key, 8);
      encoder0.encode((Struct) this.watchTime, 16, false);
    }
  }

  static final class WatchTimeRecorderFinalizeWatchTimeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] watchTimeKeys;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WatchTimeRecorderFinalizeWatchTimeParams(int version) {
      super(16, version);
    }

    public WatchTimeRecorderFinalizeWatchTimeParams() {
      this(0);
    }

    public static WatchTimeRecorderFinalizeWatchTimeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WatchTimeRecorderFinalizeWatchTimeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WatchTimeRecorderFinalizeWatchTimeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WatchTimeRecorderFinalizeWatchTimeParams result =
            new WatchTimeRecorderFinalizeWatchTimeParams(elementsOrVersion);
        result.watchTimeKeys = decoder0.readInts(8, 0, -1);
        int i1 = 0;
        while (true) {
          int[] iArr = result.watchTimeKeys;
          if (i1 < iArr.length) {
            WatchTimeKey.validate(iArr[i1]);
            i1++;
          } else {
            return result;
          }
        }
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.watchTimeKeys, 8, 0, -1);
    }
  }

  static final class WatchTimeRecorderOnErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PipelineStatus status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WatchTimeRecorderOnErrorParams(int version) {
      super(16, version);
    }

    public WatchTimeRecorderOnErrorParams() {
      this(0);
    }

    public static WatchTimeRecorderOnErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WatchTimeRecorderOnErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WatchTimeRecorderOnErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WatchTimeRecorderOnErrorParams result =
            new WatchTimeRecorderOnErrorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.status = PipelineStatus.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.status, 8, false);
    }
  }

  static final class WatchTimeRecorderUpdateSecondaryPropertiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SecondaryPlaybackProperties secondaryProperties;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WatchTimeRecorderUpdateSecondaryPropertiesParams(int version) {
      super(16, version);
    }

    public WatchTimeRecorderUpdateSecondaryPropertiesParams() {
      this(0);
    }

    public static WatchTimeRecorderUpdateSecondaryPropertiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WatchTimeRecorderUpdateSecondaryPropertiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WatchTimeRecorderUpdateSecondaryPropertiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WatchTimeRecorderUpdateSecondaryPropertiesParams result =
            new WatchTimeRecorderUpdateSecondaryPropertiesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.secondaryProperties = SecondaryPlaybackProperties.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.secondaryProperties, 8, false);
    }
  }

  static final class WatchTimeRecorderSetAutoplayInitiatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WatchTimeRecorderSetAutoplayInitiatedParams(int version) {
      super(16, version);
    }

    public WatchTimeRecorderSetAutoplayInitiatedParams() {
      this(0);
    }

    public static WatchTimeRecorderSetAutoplayInitiatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WatchTimeRecorderSetAutoplayInitiatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WatchTimeRecorderSetAutoplayInitiatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WatchTimeRecorderSetAutoplayInitiatedParams result =
            new WatchTimeRecorderSetAutoplayInitiatedParams(elementsOrVersion);
        result.value = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.value, 8, 0);
    }
  }

  static final class WatchTimeRecorderOnDurationChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TimeDelta duration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WatchTimeRecorderOnDurationChangedParams(int version) {
      super(16, version);
    }

    public WatchTimeRecorderOnDurationChangedParams() {
      this(0);
    }

    public static WatchTimeRecorderOnDurationChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WatchTimeRecorderOnDurationChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WatchTimeRecorderOnDurationChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WatchTimeRecorderOnDurationChangedParams result =
            new WatchTimeRecorderOnDurationChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.duration = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.duration, 8, false);
    }
  }

  static final class WatchTimeRecorderUpdateVideoDecodeStatsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int framesDecoded;
    public int framesDropped;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WatchTimeRecorderUpdateVideoDecodeStatsParams(int version) {
      super(16, version);
    }

    public WatchTimeRecorderUpdateVideoDecodeStatsParams() {
      this(0);
    }

    public static WatchTimeRecorderUpdateVideoDecodeStatsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WatchTimeRecorderUpdateVideoDecodeStatsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WatchTimeRecorderUpdateVideoDecodeStatsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WatchTimeRecorderUpdateVideoDecodeStatsParams result =
            new WatchTimeRecorderUpdateVideoDecodeStatsParams(elementsOrVersion);
        result.framesDecoded = decoder0.readInt(8);
        result.framesDropped = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.framesDecoded, 8);
      encoder0.encode(this.framesDropped, 12);
    }
  }

  static final class WatchTimeRecorderUpdateUnderflowCountParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int totalCount;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WatchTimeRecorderUpdateUnderflowCountParams(int version) {
      super(16, version);
    }

    public WatchTimeRecorderUpdateUnderflowCountParams() {
      this(0);
    }

    public static WatchTimeRecorderUpdateUnderflowCountParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WatchTimeRecorderUpdateUnderflowCountParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WatchTimeRecorderUpdateUnderflowCountParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WatchTimeRecorderUpdateUnderflowCountParams result =
            new WatchTimeRecorderUpdateUnderflowCountParams(elementsOrVersion);
        result.totalCount = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.totalCount, 8);
    }
  }

  static final class WatchTimeRecorderUpdateUnderflowDurationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int totalCompletedCount;
    public TimeDelta totalDuration;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WatchTimeRecorderUpdateUnderflowDurationParams(int version) {
      super(24, version);
    }

    public WatchTimeRecorderUpdateUnderflowDurationParams() {
      this(0);
    }

    public static WatchTimeRecorderUpdateUnderflowDurationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WatchTimeRecorderUpdateUnderflowDurationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WatchTimeRecorderUpdateUnderflowDurationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WatchTimeRecorderUpdateUnderflowDurationParams result =
            new WatchTimeRecorderUpdateUnderflowDurationParams(elementsOrVersion);
        result.totalCompletedCount = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.totalDuration = TimeDelta.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.totalCompletedCount, 8);
      encoder0.encode((Struct) this.totalDuration, 16, false);
    }
  }
}
