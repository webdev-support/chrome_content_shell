package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.PointF;
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
import org.chromium.mojo_base.mojom.WritableSharedMemoryRegion;
import org.chromium.viz.mojom.BeginFrameArgs;
import org.chromium.viz.mojom.CompositorFrame;
import org.chromium.viz.mojom.CompositorFrameMetadata;
import org.chromium.viz.mojom.FrameTimingDetails;
import org.chromium.viz.mojom.HitTestRegionList;
import org.chromium.viz.mojom.LocalSurfaceId;
import org.chromium.viz.mojom.ReturnedResource;

class SynchronousCompositor_Internal {
  private static final int BEGIN_FRAME_ORDINAL = 11;
  private static final int DEMAND_DRAW_HW_ASYNC_ORDINAL = 0;
  private static final int DEMAND_DRAW_HW_ORDINAL = 1;
  private static final int DEMAND_DRAW_SW_ORDINAL = 3;
  public static final Interface.Manager<SynchronousCompositor, SynchronousCompositor.Proxy>
      MANAGER =
          new Interface.Manager<SynchronousCompositor, SynchronousCompositor.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.SynchronousCompositor";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SynchronousCompositor.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SynchronousCompositor impl) {
              return new Stub(core, impl);
            }

            @Override
            public SynchronousCompositor[] buildArray(int size) {
              return new SynchronousCompositor[size];
            }
          };
  private static final int ON_COMPOSITOR_FRAME_TRANSITION_DIRECTIVE_PROCESSED_ORDINAL = 9;
  private static final int RECLAIM_RESOURCES_ORDINAL = 8;
  private static final int SET_BEGIN_FRAME_SOURCE_PAUSED_ORDINAL = 12;
  private static final int SET_MEMORY_POLICY_ORDINAL = 7;
  private static final int SET_SCROLL_ORDINAL = 10;
  private static final int SET_SHARED_MEMORY_ORDINAL = 2;
  private static final int WILL_SKIP_DRAW_ORDINAL = 4;
  private static final int ZERO_SHARED_MEMORY_ORDINAL = 5;
  private static final int ZOOM_BY_ORDINAL = 6;

  SynchronousCompositor_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SynchronousCompositor.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void demandDrawHwAsync(SyncCompositorDemandDrawHwParams drawParams) {
      SynchronousCompositorDemandDrawHwAsyncParams _message =
          new SynchronousCompositorDemandDrawHwAsyncParams();
      _message.drawParams = drawParams;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void demandDrawHw(
        SyncCompositorDemandDrawHwParams drawParams, DemandDrawHw_Response callback) {
      SynchronousCompositorDemandDrawHwParams _message =
          new SynchronousCompositorDemandDrawHwParams();
      _message.drawParams = drawParams;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new SynchronousCompositorDemandDrawHwResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setSharedMemory(
        WritableSharedMemoryRegion shmRegion, SetSharedMemory_Response callback) {
      SynchronousCompositorSetSharedMemoryParams _message =
          new SynchronousCompositorSetSharedMemoryParams();
      _message.shmRegion = shmRegion;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new SynchronousCompositorSetSharedMemoryResponseParamsForwardToCallback(callback));
    }

    @Override
    public void demandDrawSw(
        SyncCompositorDemandDrawSwParams drawParams, DemandDrawSw_Response callback) {
      SynchronousCompositorDemandDrawSwParams _message =
          new SynchronousCompositorDemandDrawSwParams();
      _message.drawParams = drawParams;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new SynchronousCompositorDemandDrawSwResponseParamsForwardToCallback(callback));
    }

    @Override
    public void willSkipDraw() {
      SynchronousCompositorWillSkipDrawParams _message =
          new SynchronousCompositorWillSkipDrawParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void zeroSharedMemory() {
      SynchronousCompositorZeroSharedMemoryParams _message =
          new SynchronousCompositorZeroSharedMemoryParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void zoomBy(float delta, Point anchor, ZoomBy_Response callback) {
      SynchronousCompositorZoomByParams _message = new SynchronousCompositorZoomByParams();
      _message.delta = delta;
      _message.anchor = anchor;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new SynchronousCompositorZoomByResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setMemoryPolicy(int bytesLimit) {
      SynchronousCompositorSetMemoryPolicyParams _message =
          new SynchronousCompositorSetMemoryPolicyParams();
      _message.bytesLimit = bytesLimit;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void reclaimResources(int layerTreeFrameSinkId, ReturnedResource[] resources) {
      SynchronousCompositorReclaimResourcesParams _message =
          new SynchronousCompositorReclaimResourcesParams();
      _message.layerTreeFrameSinkId = layerTreeFrameSinkId;
      _message.resources = resources;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void onCompositorFrameTransitionDirectiveProcessed(
        int layerTreeFrameSinkId, int sequenceId) {
      SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams _message =
          new SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams();
      _message.layerTreeFrameSinkId = layerTreeFrameSinkId;
      _message.sequenceId = sequenceId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void setScroll(PointF offset) {
      SynchronousCompositorSetScrollParams _message = new SynchronousCompositorSetScrollParams();
      _message.offset = offset;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void beginFrame(BeginFrameArgs args, Map<Integer, FrameTimingDetails> timingDetails) {
      SynchronousCompositorBeginFrameParams _message = new SynchronousCompositorBeginFrameParams();
      _message.args = args;
      _message.timingDetails = timingDetails;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }

    @Override
    public void setBeginFrameSourcePaused(boolean paused) {
      SynchronousCompositorSetBeginFrameSourcePausedParams _message =
          new SynchronousCompositorSetBeginFrameSourcePausedParams();
      _message.paused = paused;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }
  }

  public static final class Stub extends Interface.Stub<SynchronousCompositor> {
    Stub(Core core, SynchronousCompositor impl) {
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
                SynchronousCompositor_Internal.MANAGER, messageWithHeader);
          case -1:
          case 1:
          case 2:
          case 3:
          case 6:
          default:
            return false;
          case 0:
            SynchronousCompositorDemandDrawHwAsyncParams data =
                SynchronousCompositorDemandDrawHwAsyncParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().demandDrawHwAsync(data.drawParams);
            return true;
          case 4:
            SynchronousCompositorWillSkipDrawParams.deserialize(messageWithHeader.getPayload());
            getImpl().willSkipDraw();
            return true;
          case 5:
            SynchronousCompositorZeroSharedMemoryParams.deserialize(messageWithHeader.getPayload());
            getImpl().zeroSharedMemory();
            return true;
          case 7:
            SynchronousCompositorSetMemoryPolicyParams data2 =
                SynchronousCompositorSetMemoryPolicyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setMemoryPolicy(data2.bytesLimit);
            return true;
          case 8:
            SynchronousCompositorReclaimResourcesParams data3 =
                SynchronousCompositorReclaimResourcesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().reclaimResources(data3.layerTreeFrameSinkId, data3.resources);
            return true;
          case 9:
            SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams data4 =
                SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams
                    .deserialize(messageWithHeader.getPayload());
            getImpl()
                .onCompositorFrameTransitionDirectiveProcessed(
                    data4.layerTreeFrameSinkId, data4.sequenceId);
            return true;
          case 10:
            SynchronousCompositorSetScrollParams data5 =
                SynchronousCompositorSetScrollParams.deserialize(messageWithHeader.getPayload());
            getImpl().setScroll(data5.offset);
            return true;
          case 11:
            SynchronousCompositorBeginFrameParams data6 =
                SynchronousCompositorBeginFrameParams.deserialize(messageWithHeader.getPayload());
            getImpl().beginFrame(data6.args, data6.timingDetails);
            return true;
          case 12:
            SynchronousCompositorSetBeginFrameSourcePausedParams data7 =
                SynchronousCompositorSetBeginFrameSourcePausedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setBeginFrameSourcePaused(data7.paused);
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
                getCore(), SynchronousCompositor_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          case 4:
          case 5:
          default:
            return false;
          case 1:
            SynchronousCompositorDemandDrawHwParams data =
                SynchronousCompositorDemandDrawHwParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .demandDrawHw(
                    data.drawParams,
                    new SynchronousCompositorDemandDrawHwResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            SynchronousCompositorSetSharedMemoryParams data2 =
                SynchronousCompositorSetSharedMemoryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setSharedMemory(
                    data2.shmRegion,
                    new SynchronousCompositorSetSharedMemoryResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            SynchronousCompositorDemandDrawSwParams data3 =
                SynchronousCompositorDemandDrawSwParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .demandDrawSw(
                    data3.drawParams,
                    new SynchronousCompositorDemandDrawSwResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            SynchronousCompositorZoomByParams data4 =
                SynchronousCompositorZoomByParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .zoomBy(
                    data4.delta,
                    data4.anchor,
                    new SynchronousCompositorZoomByResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SynchronousCompositorDemandDrawHwAsyncParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SyncCompositorDemandDrawHwParams drawParams;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorDemandDrawHwAsyncParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorDemandDrawHwAsyncParams() {
      this(0);
    }

    public static SynchronousCompositorDemandDrawHwAsyncParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorDemandDrawHwAsyncParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorDemandDrawHwAsyncParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorDemandDrawHwAsyncParams result =
            new SynchronousCompositorDemandDrawHwAsyncParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.drawParams = SyncCompositorDemandDrawHwParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.drawParams, 8, false);
    }
  }

  static final class SynchronousCompositorDemandDrawHwParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SyncCompositorDemandDrawHwParams drawParams;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorDemandDrawHwParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorDemandDrawHwParams() {
      this(0);
    }

    public static SynchronousCompositorDemandDrawHwParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorDemandDrawHwParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorDemandDrawHwParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorDemandDrawHwParams result =
            new SynchronousCompositorDemandDrawHwParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.drawParams = SyncCompositorDemandDrawHwParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.drawParams, 8, false);
    }
  }

  static final class SynchronousCompositorDemandDrawHwResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public CompositorFrame frame;
    public HitTestRegionList hitTestRegionList;
    public int layerTreeFrameSinkId;
    public LocalSurfaceId localSurfaceId;
    public int metadataVersion;
    public SyncCompositorCommonRendererParams result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorDemandDrawHwResponseParams(int version) {
      super(48, version);
    }

    public SynchronousCompositorDemandDrawHwResponseParams() {
      this(0);
    }

    public static SynchronousCompositorDemandDrawHwResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorDemandDrawHwResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorDemandDrawHwResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorDemandDrawHwResponseParams result =
            new SynchronousCompositorDemandDrawHwResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = SyncCompositorCommonRendererParams.decode(decoder1);
        result.layerTreeFrameSinkId = decoder0.readInt(16);
        result.metadataVersion = decoder0.readInt(20);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.localSurfaceId = LocalSurfaceId.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, true);
        result.frame = CompositorFrame.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(40, true);
        result.hitTestRegionList = HitTestRegionList.decode(decoder14);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.layerTreeFrameSinkId, 16);
      encoder0.encode(this.metadataVersion, 20);
      encoder0.encode((Struct) this.localSurfaceId, 24, true);
      encoder0.encode((Struct) this.frame, 32, true);
      encoder0.encode((Struct) this.hitTestRegionList, 40, true);
    }
  }

  static class SynchronousCompositorDemandDrawHwResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SynchronousCompositor.DemandDrawHw_Response mCallback;

    SynchronousCompositorDemandDrawHwResponseParamsForwardToCallback(
        SynchronousCompositor.DemandDrawHw_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 6)) {
          return false;
        }
        SynchronousCompositorDemandDrawHwResponseParams response =
            SynchronousCompositorDemandDrawHwResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(
            response.result,
            response.layerTreeFrameSinkId,
            response.metadataVersion,
            response.localSurfaceId,
            response.frame,
            response.hitTestRegionList);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SynchronousCompositorDemandDrawHwResponseParamsProxyToResponder
      implements SynchronousCompositor.DemandDrawHw_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SynchronousCompositorDemandDrawHwResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        SyncCompositorCommonRendererParams result,
        int layerTreeFrameSinkId,
        int metadataVersion,
        LocalSurfaceId localSurfaceId,
        CompositorFrame frame,
        HitTestRegionList hitTestRegionList) {
      SynchronousCompositorDemandDrawHwResponseParams _response =
          new SynchronousCompositorDemandDrawHwResponseParams();
      _response.result = result;
      _response.layerTreeFrameSinkId = layerTreeFrameSinkId;
      _response.metadataVersion = metadataVersion;
      _response.localSurfaceId = localSurfaceId;
      _response.frame = frame;
      _response.hitTestRegionList = hitTestRegionList;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SynchronousCompositorSetSharedMemoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public WritableSharedMemoryRegion shmRegion;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorSetSharedMemoryParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorSetSharedMemoryParams() {
      this(0);
    }

    public static SynchronousCompositorSetSharedMemoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorSetSharedMemoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorSetSharedMemoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorSetSharedMemoryParams result =
            new SynchronousCompositorSetSharedMemoryParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.shmRegion = WritableSharedMemoryRegion.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.shmRegion, 8, false);
    }
  }

  static final class SynchronousCompositorSetSharedMemoryResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SyncCompositorCommonRendererParams result;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorSetSharedMemoryResponseParams(int version) {
      super(24, version);
    }

    public SynchronousCompositorSetSharedMemoryResponseParams() {
      this(0);
    }

    public static SynchronousCompositorSetSharedMemoryResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorSetSharedMemoryResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorSetSharedMemoryResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorSetSharedMemoryResponseParams result =
            new SynchronousCompositorSetSharedMemoryResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.result = SyncCompositorCommonRendererParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
      encoder0.encode((Struct) this.result, 16, false);
    }
  }

  static class SynchronousCompositorSetSharedMemoryResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SynchronousCompositor.SetSharedMemory_Response mCallback;

    SynchronousCompositorSetSharedMemoryResponseParamsForwardToCallback(
        SynchronousCompositor.SetSharedMemory_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 6)) {
          return false;
        }
        SynchronousCompositorSetSharedMemoryResponseParams response =
            SynchronousCompositorSetSharedMemoryResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success, response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SynchronousCompositorSetSharedMemoryResponseParamsProxyToResponder
      implements SynchronousCompositor.SetSharedMemory_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SynchronousCompositorSetSharedMemoryResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success, SyncCompositorCommonRendererParams result) {
      SynchronousCompositorSetSharedMemoryResponseParams _response =
          new SynchronousCompositorSetSharedMemoryResponseParams();
      _response.success = success;
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SynchronousCompositorDemandDrawSwParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SyncCompositorDemandDrawSwParams drawParams;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorDemandDrawSwParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorDemandDrawSwParams() {
      this(0);
    }

    public static SynchronousCompositorDemandDrawSwParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorDemandDrawSwParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorDemandDrawSwParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorDemandDrawSwParams result =
            new SynchronousCompositorDemandDrawSwParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.drawParams = SyncCompositorDemandDrawSwParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.drawParams, 8, false);
    }
  }

  static final class SynchronousCompositorDemandDrawSwResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public CompositorFrameMetadata metaData;
    public int metadataVersion;
    public SyncCompositorCommonRendererParams result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorDemandDrawSwResponseParams(int version) {
      super(32, version);
    }

    public SynchronousCompositorDemandDrawSwResponseParams() {
      this(0);
    }

    public static SynchronousCompositorDemandDrawSwResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorDemandDrawSwResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorDemandDrawSwResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorDemandDrawSwResponseParams result =
            new SynchronousCompositorDemandDrawSwResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = SyncCompositorCommonRendererParams.decode(decoder1);
        result.metadataVersion = decoder0.readInt(16);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.metaData = CompositorFrameMetadata.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.metadataVersion, 16);
      encoder0.encode((Struct) this.metaData, 24, true);
    }
  }

  static class SynchronousCompositorDemandDrawSwResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SynchronousCompositor.DemandDrawSw_Response mCallback;

    SynchronousCompositorDemandDrawSwResponseParamsForwardToCallback(
        SynchronousCompositor.DemandDrawSw_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 6)) {
          return false;
        }
        SynchronousCompositorDemandDrawSwResponseParams response =
            SynchronousCompositorDemandDrawSwResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.metadataVersion, response.metaData);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SynchronousCompositorDemandDrawSwResponseParamsProxyToResponder
      implements SynchronousCompositor.DemandDrawSw_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SynchronousCompositorDemandDrawSwResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        SyncCompositorCommonRendererParams result,
        int metadataVersion,
        CompositorFrameMetadata metaData) {
      SynchronousCompositorDemandDrawSwResponseParams _response =
          new SynchronousCompositorDemandDrawSwResponseParams();
      _response.result = result;
      _response.metadataVersion = metadataVersion;
      _response.metaData = metaData;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SynchronousCompositorWillSkipDrawParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorWillSkipDrawParams(int version) {
      super(8, version);
    }

    public SynchronousCompositorWillSkipDrawParams() {
      this(0);
    }

    public static SynchronousCompositorWillSkipDrawParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorWillSkipDrawParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorWillSkipDrawParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorWillSkipDrawParams result =
            new SynchronousCompositorWillSkipDrawParams(elementsOrVersion);
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

  static final class SynchronousCompositorZeroSharedMemoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorZeroSharedMemoryParams(int version) {
      super(8, version);
    }

    public SynchronousCompositorZeroSharedMemoryParams() {
      this(0);
    }

    public static SynchronousCompositorZeroSharedMemoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorZeroSharedMemoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorZeroSharedMemoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorZeroSharedMemoryParams result =
            new SynchronousCompositorZeroSharedMemoryParams(elementsOrVersion);
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

  static final class SynchronousCompositorZoomByParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Point anchor;
    public float delta;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorZoomByParams(int version) {
      super(24, version);
    }

    public SynchronousCompositorZoomByParams() {
      this(0);
    }

    public static SynchronousCompositorZoomByParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorZoomByParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorZoomByParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorZoomByParams result =
            new SynchronousCompositorZoomByParams(elementsOrVersion);
        result.delta = decoder0.readFloat(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.anchor = Point.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.delta, 8);
      encoder0.encode((Struct) this.anchor, 16, false);
    }
  }

  static final class SynchronousCompositorZoomByResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SyncCompositorCommonRendererParams result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorZoomByResponseParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorZoomByResponseParams() {
      this(0);
    }

    public static SynchronousCompositorZoomByResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorZoomByResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorZoomByResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorZoomByResponseParams result =
            new SynchronousCompositorZoomByResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = SyncCompositorCommonRendererParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
    }
  }

  static class SynchronousCompositorZoomByResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final SynchronousCompositor.ZoomBy_Response mCallback;

    SynchronousCompositorZoomByResponseParamsForwardToCallback(
        SynchronousCompositor.ZoomBy_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 6)) {
          return false;
        }
        SynchronousCompositorZoomByResponseParams response =
            SynchronousCompositorZoomByResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SynchronousCompositorZoomByResponseParamsProxyToResponder
      implements SynchronousCompositor.ZoomBy_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SynchronousCompositorZoomByResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SyncCompositorCommonRendererParams result) {
      SynchronousCompositorZoomByResponseParams _response =
          new SynchronousCompositorZoomByResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SynchronousCompositorSetMemoryPolicyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int bytesLimit;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorSetMemoryPolicyParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorSetMemoryPolicyParams() {
      this(0);
    }

    public static SynchronousCompositorSetMemoryPolicyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorSetMemoryPolicyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorSetMemoryPolicyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorSetMemoryPolicyParams result =
            new SynchronousCompositorSetMemoryPolicyParams(elementsOrVersion);
        result.bytesLimit = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.bytesLimit, 8);
    }
  }

  static final class SynchronousCompositorReclaimResourcesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int layerTreeFrameSinkId;
    public ReturnedResource[] resources;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorReclaimResourcesParams(int version) {
      super(24, version);
    }

    public SynchronousCompositorReclaimResourcesParams() {
      this(0);
    }

    public static SynchronousCompositorReclaimResourcesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorReclaimResourcesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorReclaimResourcesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorReclaimResourcesParams result =
            new SynchronousCompositorReclaimResourcesParams(elementsOrVersion);
        result.layerTreeFrameSinkId = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
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
      encoder0.encode(this.layerTreeFrameSinkId, 8);
      ReturnedResource[] returnedResourceArr = this.resources;
      if (returnedResourceArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(returnedResourceArr.length, 16, -1);
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

  static final class SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int layerTreeFrameSinkId;
    public int sequenceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams() {
      this(0);
    }

    public static SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams result =
            new SynchronousCompositorOnCompositorFrameTransitionDirectiveProcessedParams(
                elementsOrVersion);
        result.layerTreeFrameSinkId = decoder0.readInt(8);
        result.sequenceId = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.layerTreeFrameSinkId, 8);
      encoder0.encode(this.sequenceId, 12);
    }
  }

  static final class SynchronousCompositorSetScrollParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PointF offset;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorSetScrollParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorSetScrollParams() {
      this(0);
    }

    public static SynchronousCompositorSetScrollParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorSetScrollParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorSetScrollParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorSetScrollParams result =
            new SynchronousCompositorSetScrollParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.offset = PointF.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.offset, 8, false);
    }
  }

  static final class SynchronousCompositorBeginFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BeginFrameArgs args;
    public Map<Integer, FrameTimingDetails> timingDetails;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorBeginFrameParams(int version) {
      super(24, version);
    }

    public SynchronousCompositorBeginFrameParams() {
      this(0);
    }

    public static SynchronousCompositorBeginFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorBeginFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorBeginFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorBeginFrameParams result =
            new SynchronousCompositorBeginFrameParams(elementsOrVersion);
        result.args = BeginFrameArgs.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        decoder1.readDataHeaderForMap();
        int[] keys0 = decoder1.readInts(8, 0, -1);
        Decoder decoder2 = decoder1.readPointer(16, false);
        DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
        FrameTimingDetails[] values0 = new FrameTimingDetails[si2.elementsOrVersion];
        for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
          Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
          values0[i2] = FrameTimingDetails.decode(decoder3);
        }
        result.timingDetails = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.timingDetails.put(Integer.valueOf(keys0[index0]), values0[index0]);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.args, 8, false);
      if (this.timingDetails == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encoderForMap(16);
      int size0 = this.timingDetails.size();
      int[] keys0 = new int[size0];
      FrameTimingDetails[] values0 = new FrameTimingDetails[size0];
      int index0 = 0;
      for (Map.Entry<Integer, FrameTimingDetails> entry0 : this.timingDetails.entrySet()) {
        keys0[index0] = entry0.getKey().intValue();
        values0[index0] = entry0.getValue();
        index0++;
      }
      encoder1.encode(keys0, 8, 0, -1);
      Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i1 = 0; i1 < values0.length; i1++) {
        encoder2.encode((Struct) values0[i1], (i1 * 8) + 8, false);
      }
    }
  }

  static final class SynchronousCompositorSetBeginFrameSourcePausedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean paused;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorSetBeginFrameSourcePausedParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorSetBeginFrameSourcePausedParams() {
      this(0);
    }

    public static SynchronousCompositorSetBeginFrameSourcePausedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorSetBeginFrameSourcePausedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorSetBeginFrameSourcePausedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorSetBeginFrameSourcePausedParams result =
            new SynchronousCompositorSetBeginFrameSourcePausedParams(elementsOrVersion);
        result.paused = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.paused, 8, 0);
    }
  }
}
