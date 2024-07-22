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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

class FrameSinkBundle_Internal {
  private static final int DID_ALLOCATE_SHARED_BITMAP_ORDINAL = 4;
  private static final int INITIALIZE_COMPOSITOR_FRAME_SINK_TYPE_ORDINAL = 0;
  public static final Interface.Manager<FrameSinkBundle, FrameSinkBundle.Proxy> MANAGER =
      new Interface.Manager<FrameSinkBundle, FrameSinkBundle.Proxy>() {
        @Override
        public String getName() {
          return "viz.mojom.FrameSinkBundle";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FrameSinkBundle.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FrameSinkBundle impl) {
          return new Stub(core, impl);
        }

        @Override
        public FrameSinkBundle[] buildArray(int size) {
          return new FrameSinkBundle[size];
        }
      };
  private static final int SET_NEEDS_BEGIN_FRAME_ORDINAL = 1;
  private static final int SET_THREAD_IDS_ORDINAL = 5;
  private static final int SET_WANTS_BEGIN_FRAME_ACKS_ORDINAL = 2;
  private static final int SUBMIT_ORDINAL = 3;

  FrameSinkBundle_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements FrameSinkBundle.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void initializeCompositorFrameSinkType(int sinkId, int type) {
      FrameSinkBundleInitializeCompositorFrameSinkTypeParams _message =
          new FrameSinkBundleInitializeCompositorFrameSinkTypeParams();
      _message.sinkId = sinkId;
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setNeedsBeginFrame(int sinkId, boolean needsBeginFrame) {
      FrameSinkBundleSetNeedsBeginFrameParams _message =
          new FrameSinkBundleSetNeedsBeginFrameParams();
      _message.sinkId = sinkId;
      _message.needsBeginFrame = needsBeginFrame;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setWantsBeginFrameAcks(int sinkId) {
      FrameSinkBundleSetWantsBeginFrameAcksParams _message =
          new FrameSinkBundleSetWantsBeginFrameAcksParams();
      _message.sinkId = sinkId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void submit(BundledFrameSubmission[] submissions) {
      FrameSinkBundleSubmitParams _message = new FrameSinkBundleSubmitParams();
      _message.submissions = submissions;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void didAllocateSharedBitmap(int sinkId, ReadOnlySharedMemoryRegion region, Mailbox id) {
      FrameSinkBundleDidAllocateSharedBitmapParams _message =
          new FrameSinkBundleDidAllocateSharedBitmapParams();
      _message.sinkId = sinkId;
      _message.region = region;
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void setThreadIds(int sinkId, int[] threadIds) {
      FrameSinkBundleSetThreadIdsParams _message = new FrameSinkBundleSetThreadIdsParams();
      _message.sinkId = sinkId;
      _message.threadIds = threadIds;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<FrameSinkBundle> {
    Stub(Core core, FrameSinkBundle impl) {
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
                FrameSinkBundle_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            FrameSinkBundleInitializeCompositorFrameSinkTypeParams data =
                FrameSinkBundleInitializeCompositorFrameSinkTypeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().initializeCompositorFrameSinkType(data.sinkId, data.type);
            return true;
          case 1:
            FrameSinkBundleSetNeedsBeginFrameParams data2 =
                FrameSinkBundleSetNeedsBeginFrameParams.deserialize(messageWithHeader.getPayload());
            getImpl().setNeedsBeginFrame(data2.sinkId, data2.needsBeginFrame);
            return true;
          case 2:
            getImpl()
                .setWantsBeginFrameAcks(
                    FrameSinkBundleSetWantsBeginFrameAcksParams.deserialize(
                            messageWithHeader.getPayload())
                        .sinkId);
            return true;
          case 3:
            getImpl()
                .submit(
                    FrameSinkBundleSubmitParams.deserialize(messageWithHeader.getPayload())
                        .submissions);
            return true;
          case 4:
            FrameSinkBundleDidAllocateSharedBitmapParams data3 =
                FrameSinkBundleDidAllocateSharedBitmapParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didAllocateSharedBitmap(data3.sinkId, data3.region, data3.id);
            return true;
          case 5:
            FrameSinkBundleSetThreadIdsParams data4 =
                FrameSinkBundleSetThreadIdsParams.deserialize(messageWithHeader.getPayload());
            getImpl().setThreadIds(data4.sinkId, data4.threadIds);
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
                getCore(), FrameSinkBundle_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FrameSinkBundleInitializeCompositorFrameSinkTypeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int sinkId;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameSinkBundleInitializeCompositorFrameSinkTypeParams(int version) {
      super(16, version);
    }

    public FrameSinkBundleInitializeCompositorFrameSinkTypeParams() {
      this(0);
    }

    public static FrameSinkBundleInitializeCompositorFrameSinkTypeParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FrameSinkBundleInitializeCompositorFrameSinkTypeParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameSinkBundleInitializeCompositorFrameSinkTypeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameSinkBundleInitializeCompositorFrameSinkTypeParams result =
            new FrameSinkBundleInitializeCompositorFrameSinkTypeParams(elementsOrVersion);
        result.sinkId = decoder0.readInt(8);
        int readInt = decoder0.readInt(12);
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
      encoder0.encode(this.sinkId, 8);
      encoder0.encode(this.type, 12);
    }
  }

  static final class FrameSinkBundleSetNeedsBeginFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean needsBeginFrame;
    public int sinkId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameSinkBundleSetNeedsBeginFrameParams(int version) {
      super(16, version);
    }

    public FrameSinkBundleSetNeedsBeginFrameParams() {
      this(0);
    }

    public static FrameSinkBundleSetNeedsBeginFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameSinkBundleSetNeedsBeginFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameSinkBundleSetNeedsBeginFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameSinkBundleSetNeedsBeginFrameParams result =
            new FrameSinkBundleSetNeedsBeginFrameParams(elementsOrVersion);
        result.sinkId = decoder0.readInt(8);
        result.needsBeginFrame = decoder0.readBoolean(12, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sinkId, 8);
      encoder0.encode(this.needsBeginFrame, 12, 0);
    }
  }

  static final class FrameSinkBundleSetWantsBeginFrameAcksParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int sinkId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameSinkBundleSetWantsBeginFrameAcksParams(int version) {
      super(16, version);
    }

    public FrameSinkBundleSetWantsBeginFrameAcksParams() {
      this(0);
    }

    public static FrameSinkBundleSetWantsBeginFrameAcksParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameSinkBundleSetWantsBeginFrameAcksParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameSinkBundleSetWantsBeginFrameAcksParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameSinkBundleSetWantsBeginFrameAcksParams result =
            new FrameSinkBundleSetWantsBeginFrameAcksParams(elementsOrVersion);
        result.sinkId = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sinkId, 8);
    }
  }

  static final class FrameSinkBundleSubmitParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BundledFrameSubmission[] submissions;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameSinkBundleSubmitParams(int version) {
      super(16, version);
    }

    public FrameSinkBundleSubmitParams() {
      this(0);
    }

    public static FrameSinkBundleSubmitParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameSinkBundleSubmitParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameSinkBundleSubmitParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameSinkBundleSubmitParams result = new FrameSinkBundleSubmitParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.submissions = new BundledFrameSubmission[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.submissions[i1] = BundledFrameSubmission.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      BundledFrameSubmission[] bundledFrameSubmissionArr = this.submissions;
      if (bundledFrameSubmissionArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(bundledFrameSubmissionArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        BundledFrameSubmission[] bundledFrameSubmissionArr2 = this.submissions;
        if (i0 < bundledFrameSubmissionArr2.length) {
          encoder1.encode((Struct) bundledFrameSubmissionArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class FrameSinkBundleDidAllocateSharedBitmapParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Mailbox id;
    public ReadOnlySharedMemoryRegion region;
    public int sinkId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameSinkBundleDidAllocateSharedBitmapParams(int version) {
      super(32, version);
    }

    public FrameSinkBundleDidAllocateSharedBitmapParams() {
      this(0);
    }

    public static FrameSinkBundleDidAllocateSharedBitmapParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameSinkBundleDidAllocateSharedBitmapParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameSinkBundleDidAllocateSharedBitmapParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameSinkBundleDidAllocateSharedBitmapParams result =
            new FrameSinkBundleDidAllocateSharedBitmapParams(elementsOrVersion);
        result.sinkId = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.region = ReadOnlySharedMemoryRegion.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.id = Mailbox.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sinkId, 8);
      encoder0.encode((Struct) this.region, 16, false);
      encoder0.encode((Struct) this.id, 24, false);
    }
  }

  static final class FrameSinkBundleSetThreadIdsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int sinkId;
    public int[] threadIds;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameSinkBundleSetThreadIdsParams(int version) {
      super(24, version);
    }

    public FrameSinkBundleSetThreadIdsParams() {
      this(0);
    }

    public static FrameSinkBundleSetThreadIdsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameSinkBundleSetThreadIdsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameSinkBundleSetThreadIdsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameSinkBundleSetThreadIdsParams result =
            new FrameSinkBundleSetThreadIdsParams(elementsOrVersion);
        result.sinkId = decoder0.readInt(8);
        result.threadIds = decoder0.readInts(16, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sinkId, 8);
      encoder0.encode(this.threadIds, 16, 0, -1);
    }
  }
}
