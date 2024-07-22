package org.chromium.cc.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class RenderFrameMetadataObserverClient_Internal {
  public static final Interface.Manager<
          RenderFrameMetadataObserverClient, RenderFrameMetadataObserverClient.Proxy>
      MANAGER =
          new Interface.Manager<
              RenderFrameMetadataObserverClient, RenderFrameMetadataObserverClient.Proxy>() {
            @Override
            public String getName() {
              return "cc.mojom.RenderFrameMetadataObserverClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public RenderFrameMetadataObserverClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, RenderFrameMetadataObserverClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public RenderFrameMetadataObserverClient[] buildArray(int size) {
              return new RenderFrameMetadataObserverClient[size];
            }
          };
  private static final int ON_FRAME_SUBMISSION_FOR_TESTING_ORDINAL = 1;
  private static final int ON_RENDER_FRAME_METADATA_CHANGED_ORDINAL = 0;
  private static final int ON_ROOT_SCROLL_OFFSET_CHANGED_ORDINAL = 2;

  RenderFrameMetadataObserverClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements RenderFrameMetadataObserverClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onRenderFrameMetadataChanged(int frameToken, RenderFrameMetadata metadata) {
      RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams _message =
          new RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams();
      _message.frameToken = frameToken;
      _message.metadata = metadata;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onFrameSubmissionForTesting(int frameToken) {
      RenderFrameMetadataObserverClientOnFrameSubmissionForTestingParams _message =
          new RenderFrameMetadataObserverClientOnFrameSubmissionForTestingParams();
      _message.frameToken = frameToken;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onRootScrollOffsetChanged(PointF rootScrollOffset) {
      RenderFrameMetadataObserverClientOnRootScrollOffsetChangedParams _message =
          new RenderFrameMetadataObserverClientOnRootScrollOffsetChangedParams();
      _message.rootScrollOffset = rootScrollOffset;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<RenderFrameMetadataObserverClient> {
    Stub(Core core, RenderFrameMetadataObserverClient impl) {
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
                RenderFrameMetadataObserverClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams data =
                RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onRenderFrameMetadataChanged(data.frameToken, data.metadata);
            return true;
          case 1:
            getImpl()
                .onFrameSubmissionForTesting(
                    RenderFrameMetadataObserverClientOnFrameSubmissionForTestingParams.deserialize(
                            messageWithHeader.getPayload())
                        .frameToken);
            return true;
          case 2:
            getImpl()
                .onRootScrollOffsetChanged(
                    RenderFrameMetadataObserverClientOnRootScrollOffsetChangedParams.deserialize(
                            messageWithHeader.getPayload())
                        .rootScrollOffset);
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
                RenderFrameMetadataObserverClient_Internal.MANAGER,
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

  static final class RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int frameToken;
    public RenderFrameMetadata metadata;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams(int version) {
      super(24, version);
    }

    public RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams() {
      this(0);
    }

    public static RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams result =
            new RenderFrameMetadataObserverClientOnRenderFrameMetadataChangedParams(
                elementsOrVersion);
        result.frameToken = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.metadata = RenderFrameMetadata.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.frameToken, 8);
      encoder0.encode((Struct) this.metadata, 16, false);
    }
  }

  static final class RenderFrameMetadataObserverClientOnFrameSubmissionForTestingParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int frameToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderFrameMetadataObserverClientOnFrameSubmissionForTestingParams(int version) {
      super(16, version);
    }

    public RenderFrameMetadataObserverClientOnFrameSubmissionForTestingParams() {
      this(0);
    }

    public static RenderFrameMetadataObserverClientOnFrameSubmissionForTestingParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static RenderFrameMetadataObserverClientOnFrameSubmissionForTestingParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderFrameMetadataObserverClientOnFrameSubmissionForTestingParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderFrameMetadataObserverClientOnFrameSubmissionForTestingParams result =
            new RenderFrameMetadataObserverClientOnFrameSubmissionForTestingParams(
                elementsOrVersion);
        result.frameToken = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.frameToken, 8);
    }
  }

  static final class RenderFrameMetadataObserverClientOnRootScrollOffsetChangedParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PointF rootScrollOffset;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RenderFrameMetadataObserverClientOnRootScrollOffsetChangedParams(int version) {
      super(16, version);
    }

    public RenderFrameMetadataObserverClientOnRootScrollOffsetChangedParams() {
      this(0);
    }

    public static RenderFrameMetadataObserverClientOnRootScrollOffsetChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static RenderFrameMetadataObserverClientOnRootScrollOffsetChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderFrameMetadataObserverClientOnRootScrollOffsetChangedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RenderFrameMetadataObserverClientOnRootScrollOffsetChangedParams result =
            new RenderFrameMetadataObserverClientOnRootScrollOffsetChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.rootScrollOffset = PointF.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.rootScrollOffset, 8, false);
    }
  }
}
