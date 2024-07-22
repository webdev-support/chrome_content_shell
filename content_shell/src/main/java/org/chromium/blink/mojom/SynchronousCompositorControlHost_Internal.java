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
import org.chromium.viz.mojom.CompositorFrame;
import org.chromium.viz.mojom.HitTestRegionList;
import org.chromium.viz.mojom.LocalSurfaceId;

class SynchronousCompositorControlHost_Internal {
  private static final int BEGIN_FRAME_RESPONSE_ORDINAL = 1;
  public static final Interface.Manager<
          SynchronousCompositorControlHost, SynchronousCompositorControlHost.Proxy>
      MANAGER =
          new Interface.Manager<
              SynchronousCompositorControlHost, SynchronousCompositorControlHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.SynchronousCompositorControlHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SynchronousCompositorControlHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SynchronousCompositorControlHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public SynchronousCompositorControlHost[] buildArray(int size) {
              return new SynchronousCompositorControlHost[size];
            }
          };
  private static final int RETURN_FRAME_ORDINAL = 0;

  SynchronousCompositorControlHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SynchronousCompositorControlHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void returnFrame(
        int layerTreeFrameSinkId,
        int metadataVersion,
        LocalSurfaceId localSurfaceId,
        CompositorFrame frame,
        HitTestRegionList hitTestRegionList) {
      SynchronousCompositorControlHostReturnFrameParams _message =
          new SynchronousCompositorControlHostReturnFrameParams();
      _message.layerTreeFrameSinkId = layerTreeFrameSinkId;
      _message.metadataVersion = metadataVersion;
      _message.localSurfaceId = localSurfaceId;
      _message.frame = frame;
      _message.hitTestRegionList = hitTestRegionList;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void beginFrameResponse(SyncCompositorCommonRendererParams params) {
      SynchronousCompositorControlHostBeginFrameResponseParams _message =
          new SynchronousCompositorControlHostBeginFrameResponseParams();
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<SynchronousCompositorControlHost> {
    Stub(Core core, SynchronousCompositorControlHost impl) {
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
                SynchronousCompositorControlHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SynchronousCompositorControlHostReturnFrameParams data =
                SynchronousCompositorControlHostReturnFrameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .returnFrame(
                    data.layerTreeFrameSinkId,
                    data.metadataVersion,
                    data.localSurfaceId,
                    data.frame,
                    data.hitTestRegionList);
            return true;
          case 1:
            getImpl()
                .beginFrameResponse(
                    SynchronousCompositorControlHostBeginFrameResponseParams.deserialize(
                            messageWithHeader.getPayload())
                        .params);
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
                getCore(),
                SynchronousCompositorControlHost_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SynchronousCompositorControlHostReturnFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public CompositorFrame frame;
    public HitTestRegionList hitTestRegionList;
    public int layerTreeFrameSinkId;
    public LocalSurfaceId localSurfaceId;
    public int metadataVersion;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorControlHostReturnFrameParams(int version) {
      super(40, version);
    }

    public SynchronousCompositorControlHostReturnFrameParams() {
      this(0);
    }

    public static SynchronousCompositorControlHostReturnFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorControlHostReturnFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorControlHostReturnFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorControlHostReturnFrameParams result =
            new SynchronousCompositorControlHostReturnFrameParams(elementsOrVersion);
        result.layerTreeFrameSinkId = decoder0.readInt(8);
        result.metadataVersion = decoder0.readInt(12);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.localSurfaceId = LocalSurfaceId.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.frame = CompositorFrame.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, true);
        result.hitTestRegionList = HitTestRegionList.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.layerTreeFrameSinkId, 8);
      encoder0.encode(this.metadataVersion, 12);
      encoder0.encode((Struct) this.localSurfaceId, 16, true);
      encoder0.encode((Struct) this.frame, 24, true);
      encoder0.encode((Struct) this.hitTestRegionList, 32, true);
    }
  }

  static final class SynchronousCompositorControlHostBeginFrameResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SyncCompositorCommonRendererParams params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorControlHostBeginFrameResponseParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorControlHostBeginFrameResponseParams() {
      this(0);
    }

    public static SynchronousCompositorControlHostBeginFrameResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorControlHostBeginFrameResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorControlHostBeginFrameResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorControlHostBeginFrameResponseParams result =
            new SynchronousCompositorControlHostBeginFrameResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = SyncCompositorCommonRendererParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.params, 8, false);
    }
  }
}
