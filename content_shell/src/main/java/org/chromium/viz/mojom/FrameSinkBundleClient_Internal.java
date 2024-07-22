package org.chromium.viz.mojom;

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

class FrameSinkBundleClient_Internal {
  private static final int FLUSH_NOTIFICATIONS_ORDINAL = 0;
  public static final Interface.Manager<FrameSinkBundleClient, FrameSinkBundleClient.Proxy>
      MANAGER =
          new Interface.Manager<FrameSinkBundleClient, FrameSinkBundleClient.Proxy>() {
            @Override
            public String getName() {
              return "viz.mojom.FrameSinkBundleClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FrameSinkBundleClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FrameSinkBundleClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public FrameSinkBundleClient[] buildArray(int size) {
              return new FrameSinkBundleClient[size];
            }
          };
  private static final int ON_BEGIN_FRAME_PAUSED_CHANGED_ORDINAL = 1;
  private static final int ON_COMPOSITOR_FRAME_TRANSITION_DIRECTIVE_PROCESSED_ORDINAL = 2;

  FrameSinkBundleClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FrameSinkBundleClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void flushNotifications(
        BundledReturnedResources[] acks,
        BeginFrameInfo[] beginFrames,
        BundledReturnedResources[] reclaimedResources) {
      FrameSinkBundleClientFlushNotificationsParams _message =
          new FrameSinkBundleClientFlushNotificationsParams();
      _message.acks = acks;
      _message.beginFrames = beginFrames;
      _message.reclaimedResources = reclaimedResources;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onBeginFramePausedChanged(int sinkId, boolean paused) {
      FrameSinkBundleClientOnBeginFramePausedChangedParams _message =
          new FrameSinkBundleClientOnBeginFramePausedChangedParams();
      _message.sinkId = sinkId;
      _message.paused = paused;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onCompositorFrameTransitionDirectiveProcessed(int sinkId, int sequenceId) {
      FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams _message =
          new FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams();
      _message.sinkId = sinkId;
      _message.sequenceId = sequenceId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<FrameSinkBundleClient> {
    Stub(Core core, FrameSinkBundleClient impl) {
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
                FrameSinkBundleClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            FrameSinkBundleClientFlushNotificationsParams data =
                FrameSinkBundleClientFlushNotificationsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().flushNotifications(data.acks, data.beginFrames, data.reclaimedResources);
            return true;
          case 1:
            FrameSinkBundleClientOnBeginFramePausedChangedParams data2 =
                FrameSinkBundleClientOnBeginFramePausedChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onBeginFramePausedChanged(data2.sinkId, data2.paused);
            return true;
          case 2:
            FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams data3 =
                FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams
                    .deserialize(messageWithHeader.getPayload());
            getImpl().onCompositorFrameTransitionDirectiveProcessed(data3.sinkId, data3.sequenceId);
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
                getCore(), FrameSinkBundleClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FrameSinkBundleClientFlushNotificationsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public BundledReturnedResources[] acks;
    public BeginFrameInfo[] beginFrames;
    public BundledReturnedResources[] reclaimedResources;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameSinkBundleClientFlushNotificationsParams(int version) {
      super(32, version);
    }

    public FrameSinkBundleClientFlushNotificationsParams() {
      this(0);
    }

    public static FrameSinkBundleClientFlushNotificationsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameSinkBundleClientFlushNotificationsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameSinkBundleClientFlushNotificationsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameSinkBundleClientFlushNotificationsParams result =
            new FrameSinkBundleClientFlushNotificationsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.acks = new BundledReturnedResources[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.acks[i1] = BundledReturnedResources.decode(decoder2);
        }
        Decoder decoder12 = decoder0.readPointer(16, false);
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.beginFrames = new BeginFrameInfo[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
          result.beginFrames[i12] = BeginFrameInfo.decode(decoder22);
        }
        Decoder decoder13 = decoder0.readPointer(24, false);
        DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
        result.reclaimedResources = new BundledReturnedResources[si13.elementsOrVersion];
        for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
          Decoder decoder23 = decoder13.readPointer((i13 * 8) + 8, false);
          result.reclaimedResources[i13] = BundledReturnedResources.decode(decoder23);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      BundledReturnedResources[] bundledReturnedResourcesArr = this.acks;
      if (bundledReturnedResourcesArr == null) {
        encoder0.encodeNullPointer(8, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(bundledReturnedResourcesArr.length, 8, -1);
        int i0 = 0;
        while (true) {
          BundledReturnedResources[] bundledReturnedResourcesArr2 = this.acks;
          if (i0 >= bundledReturnedResourcesArr2.length) {
            break;
          }
          encoder1.encode((Struct) bundledReturnedResourcesArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      BeginFrameInfo[] beginFrameInfoArr = this.beginFrames;
      if (beginFrameInfoArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder12 = encoder0.encodePointerArray(beginFrameInfoArr.length, 16, -1);
        int i02 = 0;
        while (true) {
          BeginFrameInfo[] beginFrameInfoArr2 = this.beginFrames;
          if (i02 >= beginFrameInfoArr2.length) {
            break;
          }
          encoder12.encode((Struct) beginFrameInfoArr2[i02], (i02 * 8) + 8, false);
          i02++;
        }
      }
      BundledReturnedResources[] bundledReturnedResourcesArr3 = this.reclaimedResources;
      if (bundledReturnedResourcesArr3 == null) {
        encoder0.encodeNullPointer(24, false);
        return;
      }
      Encoder encoder13 = encoder0.encodePointerArray(bundledReturnedResourcesArr3.length, 24, -1);
      int i03 = 0;
      while (true) {
        BundledReturnedResources[] bundledReturnedResourcesArr4 = this.reclaimedResources;
        if (i03 < bundledReturnedResourcesArr4.length) {
          encoder13.encode((Struct) bundledReturnedResourcesArr4[i03], (i03 * 8) + 8, false);
          i03++;
        } else {
          return;
        }
      }
    }
  }

  static final class FrameSinkBundleClientOnBeginFramePausedChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean paused;
    public int sinkId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameSinkBundleClientOnBeginFramePausedChangedParams(int version) {
      super(16, version);
    }

    public FrameSinkBundleClientOnBeginFramePausedChangedParams() {
      this(0);
    }

    public static FrameSinkBundleClientOnBeginFramePausedChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FrameSinkBundleClientOnBeginFramePausedChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameSinkBundleClientOnBeginFramePausedChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameSinkBundleClientOnBeginFramePausedChangedParams result =
            new FrameSinkBundleClientOnBeginFramePausedChangedParams(elementsOrVersion);
        result.sinkId = decoder0.readInt(8);
        result.paused = decoder0.readBoolean(12, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sinkId, 8);
      encoder0.encode(this.paused, 12, 0);
    }
  }

  static final class FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int sequenceId;
    public int sinkId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams(int version) {
      super(16, version);
    }

    public FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams() {
      this(0);
    }

    public static FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams result =
            new FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams(
                elementsOrVersion);
        result.sinkId = decoder0.readInt(8);
        result.sequenceId = decoder0.readInt(12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sinkId, 8);
      encoder0.encode(this.sequenceId, 12);
    }
  }
}
