package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gpu.mojom.Mailbox;
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
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

class CompositorFrameSink_Internal {
  private static final int BIND_LAYER_CONTEXT_ORDINAL = 10;
  private static final int DID_ALLOCATE_SHARED_BITMAP_ORDINAL = 7;
  private static final int DID_DELETE_SHARED_BITMAP_ORDINAL = 8;
  private static final int DID_NOT_PRODUCE_FRAME_ORDINAL = 6;
  private static final int INITIALIZE_COMPOSITOR_FRAME_SINK_TYPE_ORDINAL = 9;
  public static final Interface.Manager<CompositorFrameSink, CompositorFrameSink.Proxy> MANAGER =
      new Interface.Manager<CompositorFrameSink, CompositorFrameSink.Proxy>() {
        @Override
        public String getName() {
          return "viz.mojom.CompositorFrameSink";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CompositorFrameSink.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CompositorFrameSink impl) {
          return new Stub(core, impl);
        }

        @Override
        public CompositorFrameSink[] buildArray(int size) {
          return new CompositorFrameSink[size];
        }
      };
  private static final int SET_AUTO_NEEDS_BEGIN_FRAME_ORDINAL = 3;
  private static final int SET_NEEDS_BEGIN_FRAME_ORDINAL = 0;
  private static final int SET_THREAD_IDS_ORDINAL = 11;
  private static final int SET_WANTS_ANIMATE_ONLY_BEGIN_FRAMES_ORDINAL = 1;
  private static final int SET_WANTS_BEGIN_FRAME_ACKS_ORDINAL = 2;
  private static final int SUBMIT_COMPOSITOR_FRAME_ORDINAL = 4;
  private static final int SUBMIT_COMPOSITOR_FRAME_SYNC_ORDINAL = 5;

  CompositorFrameSink_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CompositorFrameSink.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setNeedsBeginFrame(boolean needsBeginFrame) {
      CompositorFrameSinkSetNeedsBeginFrameParams _message =
          new CompositorFrameSinkSetNeedsBeginFrameParams();
      _message.needsBeginFrame = needsBeginFrame;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setWantsAnimateOnlyBeginFrames() {
      CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams _message =
          new CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setWantsBeginFrameAcks() {
      CompositorFrameSinkSetWantsBeginFrameAcksParams _message =
          new CompositorFrameSinkSetWantsBeginFrameAcksParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void setAutoNeedsBeginFrame() {
      CompositorFrameSinkSetAutoNeedsBeginFrameParams _message =
          new CompositorFrameSinkSetAutoNeedsBeginFrameParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void submitCompositorFrame(
        LocalSurfaceId localSurfaceId,
        CompositorFrame frame,
        HitTestRegionList hitTestRegionList,
        long submitTime) {
      CompositorFrameSinkSubmitCompositorFrameParams _message =
          new CompositorFrameSinkSubmitCompositorFrameParams();
      _message.localSurfaceId = localSurfaceId;
      _message.frame = frame;
      _message.hitTestRegionList = hitTestRegionList;
      _message.submitTime = submitTime;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void submitCompositorFrameSync(
        LocalSurfaceId localSurfaceId,
        CompositorFrame frame,
        HitTestRegionList hitTestRegionList,
        long submitTime,
        SubmitCompositorFrameSync_Response callback) {
      CompositorFrameSinkSubmitCompositorFrameSyncParams _message =
          new CompositorFrameSinkSubmitCompositorFrameSyncParams();
      _message.localSurfaceId = localSurfaceId;
      _message.frame = frame;
      _message.hitTestRegionList = hitTestRegionList;
      _message.submitTime = submitTime;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void didNotProduceFrame(BeginFrameAck ack) {
      CompositorFrameSinkDidNotProduceFrameParams _message =
          new CompositorFrameSinkDidNotProduceFrameParams();
      _message.ack = ack;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void didAllocateSharedBitmap(ReadOnlySharedMemoryRegion region, Mailbox id) {
      CompositorFrameSinkDidAllocateSharedBitmapParams _message =
          new CompositorFrameSinkDidAllocateSharedBitmapParams();
      _message.region = region;
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void didDeleteSharedBitmap(Mailbox id) {
      CompositorFrameSinkDidDeleteSharedBitmapParams _message =
          new CompositorFrameSinkDidDeleteSharedBitmapParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void initializeCompositorFrameSinkType(int type) {
      CompositorFrameSinkInitializeCompositorFrameSinkTypeParams _message =
          new CompositorFrameSinkInitializeCompositorFrameSinkTypeParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void bindLayerContext(PendingLayerContext context) {
      CompositorFrameSinkBindLayerContextParams _message =
          new CompositorFrameSinkBindLayerContextParams();
      _message.context = context;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void setThreadIds(int[] threadIds) {
      CompositorFrameSinkSetThreadIdsParams _message = new CompositorFrameSinkSetThreadIdsParams();
      _message.threadIds = threadIds;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }
  }

  public static final class Stub extends Interface.Stub<CompositorFrameSink> {
    Stub(Core core, CompositorFrameSink impl) {
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
                CompositorFrameSink_Internal.MANAGER, messageWithHeader);
          case -1:
          case 5:
          default:
            return false;
          case 0:
            getImpl()
                .setNeedsBeginFrame(
                    CompositorFrameSinkSetNeedsBeginFrameParams.deserialize(
                            messageWithHeader.getPayload())
                        .needsBeginFrame);
            return true;
          case 1:
            CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().setWantsAnimateOnlyBeginFrames();
            return true;
          case 2:
            CompositorFrameSinkSetWantsBeginFrameAcksParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().setWantsBeginFrameAcks();
            return true;
          case 3:
            CompositorFrameSinkSetAutoNeedsBeginFrameParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().setAutoNeedsBeginFrame();
            return true;
          case 4:
            CompositorFrameSinkSubmitCompositorFrameParams data =
                CompositorFrameSinkSubmitCompositorFrameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .submitCompositorFrame(
                    data.localSurfaceId, data.frame, data.hitTestRegionList, data.submitTime);
            return true;
          case 6:
            CompositorFrameSinkDidNotProduceFrameParams data2 =
                CompositorFrameSinkDidNotProduceFrameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didNotProduceFrame(data2.ack);
            return true;
          case 7:
            CompositorFrameSinkDidAllocateSharedBitmapParams data3 =
                CompositorFrameSinkDidAllocateSharedBitmapParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didAllocateSharedBitmap(data3.region, data3.id);
            return true;
          case 8:
            CompositorFrameSinkDidDeleteSharedBitmapParams data4 =
                CompositorFrameSinkDidDeleteSharedBitmapParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didDeleteSharedBitmap(data4.id);
            return true;
          case 9:
            CompositorFrameSinkInitializeCompositorFrameSinkTypeParams data5 =
                CompositorFrameSinkInitializeCompositorFrameSinkTypeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().initializeCompositorFrameSinkType(data5.type);
            return true;
          case 10:
            CompositorFrameSinkBindLayerContextParams data6 =
                CompositorFrameSinkBindLayerContextParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().bindLayerContext(data6.context);
            return true;
          case 11:
            CompositorFrameSinkSetThreadIdsParams data7 =
                CompositorFrameSinkSetThreadIdsParams.deserialize(messageWithHeader.getPayload());
            getImpl().setThreadIds(data7.threadIds);
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
                getCore(), CompositorFrameSink_Internal.MANAGER, messageWithHeader, receiver);
          case 5:
            CompositorFrameSinkSubmitCompositorFrameSyncParams data =
                CompositorFrameSinkSubmitCompositorFrameSyncParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .submitCompositorFrameSync(
                    data.localSurfaceId,
                    data.frame,
                    data.hitTestRegionList,
                    data.submitTime,
                    new CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsProxyToResponder(
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

  static final class CompositorFrameSinkSetNeedsBeginFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean needsBeginFrame;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkSetNeedsBeginFrameParams(int version) {
      super(16, version);
    }

    public CompositorFrameSinkSetNeedsBeginFrameParams() {
      this(0);
    }

    public static CompositorFrameSinkSetNeedsBeginFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkSetNeedsBeginFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkSetNeedsBeginFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkSetNeedsBeginFrameParams result =
            new CompositorFrameSinkSetNeedsBeginFrameParams(elementsOrVersion);
        result.needsBeginFrame = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.needsBeginFrame, 8, 0);
    }
  }

  static final class CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams(int version) {
      super(8, version);
    }

    public CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams() {
      this(0);
    }

    public static CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams result =
            new CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class CompositorFrameSinkSetWantsBeginFrameAcksParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkSetWantsBeginFrameAcksParams(int version) {
      super(8, version);
    }

    public CompositorFrameSinkSetWantsBeginFrameAcksParams() {
      this(0);
    }

    public static CompositorFrameSinkSetWantsBeginFrameAcksParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkSetWantsBeginFrameAcksParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkSetWantsBeginFrameAcksParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkSetWantsBeginFrameAcksParams result =
            new CompositorFrameSinkSetWantsBeginFrameAcksParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class CompositorFrameSinkSetAutoNeedsBeginFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkSetAutoNeedsBeginFrameParams(int version) {
      super(8, version);
    }

    public CompositorFrameSinkSetAutoNeedsBeginFrameParams() {
      this(0);
    }

    public static CompositorFrameSinkSetAutoNeedsBeginFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkSetAutoNeedsBeginFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkSetAutoNeedsBeginFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkSetAutoNeedsBeginFrameParams result =
            new CompositorFrameSinkSetAutoNeedsBeginFrameParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class CompositorFrameSinkSubmitCompositorFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public CompositorFrame frame;
    public HitTestRegionList hitTestRegionList;
    public LocalSurfaceId localSurfaceId;
    public long submitTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkSubmitCompositorFrameParams(int version) {
      super(40, version);
    }

    public CompositorFrameSinkSubmitCompositorFrameParams() {
      this(0);
    }

    public static CompositorFrameSinkSubmitCompositorFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkSubmitCompositorFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkSubmitCompositorFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkSubmitCompositorFrameParams result =
            new CompositorFrameSinkSubmitCompositorFrameParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.localSurfaceId = LocalSurfaceId.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.frame = CompositorFrame.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, true);
        result.hitTestRegionList = HitTestRegionList.decode(decoder13);
        result.submitTime = decoder0.readLong(32);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.localSurfaceId, 8, false);
      encoder0.encode((Struct) this.frame, 16, false);
      encoder0.encode((Struct) this.hitTestRegionList, 24, true);
      encoder0.encode(this.submitTime, 32);
    }
  }

  static final class CompositorFrameSinkSubmitCompositorFrameSyncParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public CompositorFrame frame;
    public HitTestRegionList hitTestRegionList;
    public LocalSurfaceId localSurfaceId;
    public long submitTime;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkSubmitCompositorFrameSyncParams(int version) {
      super(40, version);
    }

    public CompositorFrameSinkSubmitCompositorFrameSyncParams() {
      this(0);
    }

    public static CompositorFrameSinkSubmitCompositorFrameSyncParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkSubmitCompositorFrameSyncParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkSubmitCompositorFrameSyncParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkSubmitCompositorFrameSyncParams result =
            new CompositorFrameSinkSubmitCompositorFrameSyncParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.localSurfaceId = LocalSurfaceId.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.frame = CompositorFrame.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, true);
        result.hitTestRegionList = HitTestRegionList.decode(decoder13);
        result.submitTime = decoder0.readLong(32);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.localSurfaceId, 8, false);
      encoder0.encode((Struct) this.frame, 16, false);
      encoder0.encode((Struct) this.hitTestRegionList, 24, true);
      encoder0.encode(this.submitTime, 32);
    }
  }

  static final class CompositorFrameSinkSubmitCompositorFrameSyncResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReturnedResource[] resources;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkSubmitCompositorFrameSyncResponseParams(int version) {
      super(16, version);
    }

    public CompositorFrameSinkSubmitCompositorFrameSyncResponseParams() {
      this(0);
    }

    public static CompositorFrameSinkSubmitCompositorFrameSyncResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkSubmitCompositorFrameSyncResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkSubmitCompositorFrameSyncResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkSubmitCompositorFrameSyncResponseParams result =
            new CompositorFrameSinkSubmitCompositorFrameSyncResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.resources = new ReturnedResource[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.resources[i1] = ReturnedResource.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      ReturnedResource[] returnedResourceArr = this.resources;
      if (returnedResourceArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(returnedResourceArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ReturnedResource[] returnedResourceArr2 = this.resources;
        if (i0 < returnedResourceArr2.length) {
          encoder1.encode((Struct) returnedResourceArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final CompositorFrameSink.SubmitCompositorFrameSync_Response mCallback;

    CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsForwardToCallback(
        CompositorFrameSink.SubmitCompositorFrameSync_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 6)) {
          return false;
        }
        CompositorFrameSinkSubmitCompositorFrameSyncResponseParams response =
            CompositorFrameSinkSubmitCompositorFrameSyncResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.resources);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsProxyToResponder
      implements CompositorFrameSink.SubmitCompositorFrameSync_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ReturnedResource[] resources) {
      CompositorFrameSinkSubmitCompositorFrameSyncResponseParams _response =
          new CompositorFrameSinkSubmitCompositorFrameSyncResponseParams();
      _response.resources = resources;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class CompositorFrameSinkDidNotProduceFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BeginFrameAck ack;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkDidNotProduceFrameParams(int version) {
      super(16, version);
    }

    public CompositorFrameSinkDidNotProduceFrameParams() {
      this(0);
    }

    public static CompositorFrameSinkDidNotProduceFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkDidNotProduceFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkDidNotProduceFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkDidNotProduceFrameParams result =
            new CompositorFrameSinkDidNotProduceFrameParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.ack = BeginFrameAck.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.ack, 8, false);
    }
  }

  static final class CompositorFrameSinkDidAllocateSharedBitmapParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Mailbox id;
    public ReadOnlySharedMemoryRegion region;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkDidAllocateSharedBitmapParams(int version) {
      super(24, version);
    }

    public CompositorFrameSinkDidAllocateSharedBitmapParams() {
      this(0);
    }

    public static CompositorFrameSinkDidAllocateSharedBitmapParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkDidAllocateSharedBitmapParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkDidAllocateSharedBitmapParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkDidAllocateSharedBitmapParams result =
            new CompositorFrameSinkDidAllocateSharedBitmapParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.region = ReadOnlySharedMemoryRegion.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.id = Mailbox.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.region, 8, false);
      encoder0.encode((Struct) this.id, 16, false);
    }
  }

  static final class CompositorFrameSinkDidDeleteSharedBitmapParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Mailbox id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkDidDeleteSharedBitmapParams(int version) {
      super(16, version);
    }

    public CompositorFrameSinkDidDeleteSharedBitmapParams() {
      this(0);
    }

    public static CompositorFrameSinkDidDeleteSharedBitmapParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkDidDeleteSharedBitmapParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkDidDeleteSharedBitmapParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkDidDeleteSharedBitmapParams result =
            new CompositorFrameSinkDidDeleteSharedBitmapParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.id = Mailbox.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.id, 8, false);
    }
  }

  static final class CompositorFrameSinkInitializeCompositorFrameSinkTypeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkInitializeCompositorFrameSinkTypeParams(int version) {
      super(16, version);
    }

    public CompositorFrameSinkInitializeCompositorFrameSinkTypeParams() {
      this(0);
    }

    public static CompositorFrameSinkInitializeCompositorFrameSinkTypeParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkInitializeCompositorFrameSinkTypeParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkInitializeCompositorFrameSinkTypeParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkInitializeCompositorFrameSinkTypeParams result =
            new CompositorFrameSinkInitializeCompositorFrameSinkTypeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        CompositorFrameSinkType.validate(readInt);
        result.type = CompositorFrameSinkType.toKnownValue(result.type);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
    }
  }

  static final class CompositorFrameSinkBindLayerContextParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PendingLayerContext context;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkBindLayerContextParams(int version) {
      super(16, version);
    }

    public CompositorFrameSinkBindLayerContextParams() {
      this(0);
    }

    public static CompositorFrameSinkBindLayerContextParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkBindLayerContextParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkBindLayerContextParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkBindLayerContextParams result =
            new CompositorFrameSinkBindLayerContextParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.context = PendingLayerContext.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.context, 8, false);
    }
  }

  static final class CompositorFrameSinkSetThreadIdsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] threadIds;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkSetThreadIdsParams(int version) {
      super(16, version);
    }

    public CompositorFrameSinkSetThreadIdsParams() {
      this(0);
    }

    public static CompositorFrameSinkSetThreadIdsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkSetThreadIdsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkSetThreadIdsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkSetThreadIdsParams result =
            new CompositorFrameSinkSetThreadIdsParams(elementsOrVersion);
        result.threadIds = decoder0.readInts(8, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.threadIds, 8, 0, -1);
    }
  }
}
