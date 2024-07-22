package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

class CompositorFrameSinkClient_Internal {
  private static final int DID_RECEIVE_COMPOSITOR_FRAME_ACK_ORDINAL = 0;
  public static final Interface.Manager<CompositorFrameSinkClient, CompositorFrameSinkClient.Proxy>
      MANAGER =
          new Interface.Manager<CompositorFrameSinkClient, CompositorFrameSinkClient.Proxy>() {
            @Override
            public String getName() {
              return "viz.mojom.CompositorFrameSinkClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public CompositorFrameSinkClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, CompositorFrameSinkClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public CompositorFrameSinkClient[] buildArray(int size) {
              return new CompositorFrameSinkClient[size];
            }
          };
  private static final int ON_BEGIN_FRAME_ORDINAL = 1;
  private static final int ON_BEGIN_FRAME_PAUSED_CHANGED_ORDINAL = 2;
  private static final int ON_COMPOSITOR_FRAME_TRANSITION_DIRECTIVE_PROCESSED_ORDINAL = 4;
  private static final int ON_SURFACE_EVICTED_ORDINAL = 5;
  private static final int RECLAIM_RESOURCES_ORDINAL = 3;

  CompositorFrameSinkClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CompositorFrameSinkClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void didReceiveCompositorFrameAck(ReturnedResource[] resources) {
      CompositorFrameSinkClientDidReceiveCompositorFrameAckParams _message =
          new CompositorFrameSinkClientDidReceiveCompositorFrameAckParams();
      _message.resources = resources;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onBeginFrame(
        BeginFrameArgs args,
        Map<Integer, FrameTimingDetails> details,
        boolean frameAck,
        ReturnedResource[] resources) {
      CompositorFrameSinkClientOnBeginFrameParams _message =
          new CompositorFrameSinkClientOnBeginFrameParams();
      _message.args = args;
      _message.details = details;
      _message.frameAck = frameAck;
      _message.resources = resources;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onBeginFramePausedChanged(boolean paused) {
      CompositorFrameSinkClientOnBeginFramePausedChangedParams _message =
          new CompositorFrameSinkClientOnBeginFramePausedChangedParams();
      _message.paused = paused;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void reclaimResources(ReturnedResource[] resources) {
      CompositorFrameSinkClientReclaimResourcesParams _message =
          new CompositorFrameSinkClientReclaimResourcesParams();
      _message.resources = resources;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void onCompositorFrameTransitionDirectiveProcessed(int sequenceId) {
      CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams _message =
          new CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams();
      _message.sequenceId = sequenceId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void onSurfaceEvicted(LocalSurfaceId localSurfaceId) {
      CompositorFrameSinkClientOnSurfaceEvictedParams _message =
          new CompositorFrameSinkClientOnSurfaceEvictedParams();
      _message.localSurfaceId = localSurfaceId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }
  }

  public static final class Stub extends Interface.Stub<CompositorFrameSinkClient> {
    Stub(Core core, CompositorFrameSinkClient impl) {
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
                CompositorFrameSinkClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .didReceiveCompositorFrameAck(
                    CompositorFrameSinkClientDidReceiveCompositorFrameAckParams.deserialize(
                            messageWithHeader.getPayload())
                        .resources);
            return true;
          case 1:
            CompositorFrameSinkClientOnBeginFrameParams data =
                CompositorFrameSinkClientOnBeginFrameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onBeginFrame(data.args, data.details, data.frameAck, data.resources);
            return true;
          case 2:
            CompositorFrameSinkClientOnBeginFramePausedChangedParams data2 =
                CompositorFrameSinkClientOnBeginFramePausedChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onBeginFramePausedChanged(data2.paused);
            return true;
          case 3:
            CompositorFrameSinkClientReclaimResourcesParams data3 =
                CompositorFrameSinkClientReclaimResourcesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().reclaimResources(data3.resources);
            return true;
          case 4:
            CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams data4 =
                CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams
                    .deserialize(messageWithHeader.getPayload());
            getImpl().onCompositorFrameTransitionDirectiveProcessed(data4.sequenceId);
            return true;
          case 5:
            CompositorFrameSinkClientOnSurfaceEvictedParams data5 =
                CompositorFrameSinkClientOnSurfaceEvictedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onSurfaceEvicted(data5.localSurfaceId);
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
                getCore(), CompositorFrameSinkClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class CompositorFrameSinkClientDidReceiveCompositorFrameAckParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReturnedResource[] resources;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkClientDidReceiveCompositorFrameAckParams(int version) {
      super(16, version);
    }

    public CompositorFrameSinkClientDidReceiveCompositorFrameAckParams() {
      this(0);
    }

    public static CompositorFrameSinkClientDidReceiveCompositorFrameAckParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkClientDidReceiveCompositorFrameAckParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkClientDidReceiveCompositorFrameAckParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkClientDidReceiveCompositorFrameAckParams result =
            new CompositorFrameSinkClientDidReceiveCompositorFrameAckParams(elementsOrVersion);
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

  static final class CompositorFrameSinkClientOnBeginFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public BeginFrameArgs args;
    public Map<Integer, FrameTimingDetails> details;
    public boolean frameAck;
    public ReturnedResource[] resources;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkClientOnBeginFrameParams(int version) {
      super(40, version);
    }

    public CompositorFrameSinkClientOnBeginFrameParams() {
      this(0);
    }

    public static CompositorFrameSinkClientOnBeginFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkClientOnBeginFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkClientOnBeginFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkClientOnBeginFrameParams result =
            new CompositorFrameSinkClientOnBeginFrameParams(elementsOrVersion);
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
        result.details = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.details.put(Integer.valueOf(keys0[index0]), values0[index0]);
        }
        result.frameAck = decoder0.readBoolean(24, 0);
        Decoder decoder12 = decoder0.readPointer(32, false);
        DataHeader si1 = decoder12.readDataHeaderForPointerArray(-1);
        result.resources = new ReturnedResource[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.resources[i1] =
              ReturnedResource.decode(decoder12.readPointer((i1 * 8) + 8, false));
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
      if (this.details == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encoderForMap(16);
        int size0 = this.details.size();
        int[] keys0 = new int[size0];
        FrameTimingDetails[] values0 = new FrameTimingDetails[size0];
        int index0 = 0;
        for (Map.Entry<Integer, FrameTimingDetails> entry0 : this.details.entrySet()) {
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
      encoder0.encode(this.frameAck, 24, 0);
      ReturnedResource[] returnedResourceArr = this.resources;
      if (returnedResourceArr == null) {
        encoder0.encodeNullPointer(32, false);
        return;
      }
      Encoder encoder12 = encoder0.encodePointerArray(returnedResourceArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        ReturnedResource[] returnedResourceArr2 = this.resources;
        if (i0 < returnedResourceArr2.length) {
          encoder12.encode((Struct) returnedResourceArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class CompositorFrameSinkClientOnBeginFramePausedChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean paused;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkClientOnBeginFramePausedChangedParams(int version) {
      super(16, version);
    }

    public CompositorFrameSinkClientOnBeginFramePausedChangedParams() {
      this(0);
    }

    public static CompositorFrameSinkClientOnBeginFramePausedChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkClientOnBeginFramePausedChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkClientOnBeginFramePausedChangedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkClientOnBeginFramePausedChangedParams result =
            new CompositorFrameSinkClientOnBeginFramePausedChangedParams(elementsOrVersion);
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

  static final class CompositorFrameSinkClientReclaimResourcesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReturnedResource[] resources;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkClientReclaimResourcesParams(int version) {
      super(16, version);
    }

    public CompositorFrameSinkClientReclaimResourcesParams() {
      this(0);
    }

    public static CompositorFrameSinkClientReclaimResourcesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkClientReclaimResourcesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkClientReclaimResourcesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkClientReclaimResourcesParams result =
            new CompositorFrameSinkClientReclaimResourcesParams(elementsOrVersion);
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

  static final class CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int sequenceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams(
        int version) {
      super(16, version);
    }

    public CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams() {
      this(0);
    }

    public static CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams
        decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams result =
            new CompositorFrameSinkClientOnCompositorFrameTransitionDirectiveProcessedParams(
                elementsOrVersion);
        result.sequenceId = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sequenceId, 8);
    }
  }

  static final class CompositorFrameSinkClientOnSurfaceEvictedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public LocalSurfaceId localSurfaceId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CompositorFrameSinkClientOnSurfaceEvictedParams(int version) {
      super(16, version);
    }

    public CompositorFrameSinkClientOnSurfaceEvictedParams() {
      this(0);
    }

    public static CompositorFrameSinkClientOnSurfaceEvictedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CompositorFrameSinkClientOnSurfaceEvictedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameSinkClientOnSurfaceEvictedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CompositorFrameSinkClientOnSurfaceEvictedParams result =
            new CompositorFrameSinkClientOnSurfaceEvictedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.localSurfaceId = LocalSurfaceId.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.localSurfaceId, 8, false);
    }
  }
}
