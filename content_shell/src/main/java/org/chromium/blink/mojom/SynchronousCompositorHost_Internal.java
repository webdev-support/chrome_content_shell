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

class SynchronousCompositorHost_Internal {
  private static final int LAYER_TREE_FRAME_SINK_CREATED_ORDINAL = 0;
  public static final Interface.Manager<SynchronousCompositorHost, SynchronousCompositorHost.Proxy>
      MANAGER =
          new Interface.Manager<SynchronousCompositorHost, SynchronousCompositorHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.SynchronousCompositorHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public SynchronousCompositorHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, SynchronousCompositorHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public SynchronousCompositorHost[] buildArray(int size) {
              return new SynchronousCompositorHost[size];
            }
          };
  private static final int SET_NEEDS_BEGIN_FRAMES_ORDINAL = 2;
  private static final int UPDATE_STATE_ORDINAL = 1;

  SynchronousCompositorHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements SynchronousCompositorHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void layerTreeFrameSinkCreated() {
      SynchronousCompositorHostLayerTreeFrameSinkCreatedParams _message =
          new SynchronousCompositorHostLayerTreeFrameSinkCreatedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void updateState(SyncCompositorCommonRendererParams params) {
      SynchronousCompositorHostUpdateStateParams _message =
          new SynchronousCompositorHostUpdateStateParams();
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setNeedsBeginFrames(boolean needsBeginFrames) {
      SynchronousCompositorHostSetNeedsBeginFramesParams _message =
          new SynchronousCompositorHostSetNeedsBeginFramesParams();
      _message.needsBeginFrames = needsBeginFrames;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<SynchronousCompositorHost> {
    Stub(Core core, SynchronousCompositorHost impl) {
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
                SynchronousCompositorHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            SynchronousCompositorHostLayerTreeFrameSinkCreatedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().layerTreeFrameSinkCreated();
            return true;
          case 1:
            SynchronousCompositorHostUpdateStateParams data =
                SynchronousCompositorHostUpdateStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateState(data.params);
            return true;
          case 2:
            SynchronousCompositorHostSetNeedsBeginFramesParams data2 =
                SynchronousCompositorHostSetNeedsBeginFramesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setNeedsBeginFrames(data2.needsBeginFrames);
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
                getCore(), SynchronousCompositorHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class SynchronousCompositorHostLayerTreeFrameSinkCreatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorHostLayerTreeFrameSinkCreatedParams(int version) {
      super(8, version);
    }

    public SynchronousCompositorHostLayerTreeFrameSinkCreatedParams() {
      this(0);
    }

    public static SynchronousCompositorHostLayerTreeFrameSinkCreatedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorHostLayerTreeFrameSinkCreatedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorHostLayerTreeFrameSinkCreatedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorHostLayerTreeFrameSinkCreatedParams result =
            new SynchronousCompositorHostLayerTreeFrameSinkCreatedParams(elementsOrVersion);
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

  static final class SynchronousCompositorHostUpdateStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SyncCompositorCommonRendererParams params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorHostUpdateStateParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorHostUpdateStateParams() {
      this(0);
    }

    public static SynchronousCompositorHostUpdateStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorHostUpdateStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorHostUpdateStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorHostUpdateStateParams result =
            new SynchronousCompositorHostUpdateStateParams(elementsOrVersion);
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

  static final class SynchronousCompositorHostSetNeedsBeginFramesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean needsBeginFrames;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SynchronousCompositorHostSetNeedsBeginFramesParams(int version) {
      super(16, version);
    }

    public SynchronousCompositorHostSetNeedsBeginFramesParams() {
      this(0);
    }

    public static SynchronousCompositorHostSetNeedsBeginFramesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SynchronousCompositorHostSetNeedsBeginFramesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SynchronousCompositorHostSetNeedsBeginFramesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SynchronousCompositorHostSetNeedsBeginFramesParams result =
            new SynchronousCompositorHostSetNeedsBeginFramesParams(elementsOrVersion);
        result.needsBeginFrames = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.needsBeginFrames, 8, 0);
    }
  }
}
