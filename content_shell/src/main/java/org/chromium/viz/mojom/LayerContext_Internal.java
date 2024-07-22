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

class LayerContext_Internal {
  private static final int COMMIT_ORDINAL = 2;
  public static final Interface.Manager<LayerContext, LayerContext.Proxy> MANAGER =
      new Interface.Manager<LayerContext, LayerContext.Proxy>() {
        @Override
        public String getName() {
          return "viz.mojom.LayerContext";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public LayerContext.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, LayerContext impl) {
          return new Stub(core, impl);
        }

        @Override
        public LayerContext[] buildArray(int size) {
          return new LayerContext[size];
        }
      };
  private static final int SET_TARGET_LOCAL_SURFACE_ID_ORDINAL = 0;
  private static final int SET_VISIBLE_ORDINAL = 1;

  LayerContext_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements LayerContext.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setTargetLocalSurfaceId(LocalSurfaceId id) {
      LayerContextSetTargetLocalSurfaceIdParams _message =
          new LayerContextSetTargetLocalSurfaceIdParams();
      _message.id = id;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setVisible(boolean visible) {
      LayerContextSetVisibleParams _message = new LayerContextSetVisibleParams();
      _message.visible = visible;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void commit(LayerTreeUpdate update) {
      LayerContextCommitParams _message = new LayerContextCommitParams();
      _message.update = update;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<LayerContext> {
    Stub(Core core, LayerContext impl) {
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
                LayerContext_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            LayerContextSetTargetLocalSurfaceIdParams data =
                LayerContextSetTargetLocalSurfaceIdParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setTargetLocalSurfaceId(data.id);
            return true;
          case 1:
            LayerContextSetVisibleParams data2 =
                LayerContextSetVisibleParams.deserialize(messageWithHeader.getPayload());
            getImpl().setVisible(data2.visible);
            return true;
          case 2:
            LayerContextCommitParams data3 =
                LayerContextCommitParams.deserialize(messageWithHeader.getPayload());
            getImpl().commit(data3.update);
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
                getCore(), LayerContext_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class LayerContextSetTargetLocalSurfaceIdParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public LocalSurfaceId id;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LayerContextSetTargetLocalSurfaceIdParams(int version) {
      super(16, version);
    }

    public LayerContextSetTargetLocalSurfaceIdParams() {
      this(0);
    }

    public static LayerContextSetTargetLocalSurfaceIdParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LayerContextSetTargetLocalSurfaceIdParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LayerContextSetTargetLocalSurfaceIdParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LayerContextSetTargetLocalSurfaceIdParams result =
            new LayerContextSetTargetLocalSurfaceIdParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.id = LocalSurfaceId.decode(decoder1);
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

  static final class LayerContextSetVisibleParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean visible;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LayerContextSetVisibleParams(int version) {
      super(16, version);
    }

    public LayerContextSetVisibleParams() {
      this(0);
    }

    public static LayerContextSetVisibleParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LayerContextSetVisibleParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LayerContextSetVisibleParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LayerContextSetVisibleParams result = new LayerContextSetVisibleParams(elementsOrVersion);
        result.visible = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.visible, 8, 0);
    }
  }

  static final class LayerContextCommitParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public LayerTreeUpdate update;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LayerContextCommitParams(int version) {
      super(16, version);
    }

    public LayerContextCommitParams() {
      this(0);
    }

    public static LayerContextCommitParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LayerContextCommitParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LayerContextCommitParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LayerContextCommitParams result = new LayerContextCommitParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.update = LayerTreeUpdate.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.update, 8, false);
    }
  }
}
