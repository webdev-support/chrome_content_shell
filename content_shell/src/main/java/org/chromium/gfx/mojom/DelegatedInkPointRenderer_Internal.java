package org.chromium.gfx.mojom;

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

class DelegatedInkPointRenderer_Internal {
  public static final Interface.Manager<DelegatedInkPointRenderer, DelegatedInkPointRenderer.Proxy>
      MANAGER =
          new Interface.Manager<DelegatedInkPointRenderer, DelegatedInkPointRenderer.Proxy>() {
            @Override
            public String getName() {
              return "gfx.mojom.DelegatedInkPointRenderer";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public DelegatedInkPointRenderer.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, DelegatedInkPointRenderer impl) {
              return new Stub(core, impl);
            }

            @Override
            public DelegatedInkPointRenderer[] buildArray(int size) {
              return new DelegatedInkPointRenderer[size];
            }
          };
  private static final int RESET_PREDICTION_ORDINAL = 1;
  private static final int STORE_DELEGATED_INK_POINT_ORDINAL = 0;

  DelegatedInkPointRenderer_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements DelegatedInkPointRenderer.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void storeDelegatedInkPoint(DelegatedInkPoint point) {
      DelegatedInkPointRendererStoreDelegatedInkPointParams _message =
          new DelegatedInkPointRendererStoreDelegatedInkPointParams();
      _message.point = point;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void resetPrediction() {
      DelegatedInkPointRendererResetPredictionParams _message =
          new DelegatedInkPointRendererResetPredictionParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<DelegatedInkPointRenderer> {
    Stub(Core core, DelegatedInkPointRenderer impl) {
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
                DelegatedInkPointRenderer_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            DelegatedInkPointRendererStoreDelegatedInkPointParams data =
                DelegatedInkPointRendererStoreDelegatedInkPointParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().storeDelegatedInkPoint(data.point);
            return true;
          case 1:
            DelegatedInkPointRendererResetPredictionParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().resetPrediction();
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
                getCore(), DelegatedInkPointRenderer_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class DelegatedInkPointRendererStoreDelegatedInkPointParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DelegatedInkPoint point;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DelegatedInkPointRendererStoreDelegatedInkPointParams(int version) {
      super(16, version);
    }

    public DelegatedInkPointRendererStoreDelegatedInkPointParams() {
      this(0);
    }

    public static DelegatedInkPointRendererStoreDelegatedInkPointParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static DelegatedInkPointRendererStoreDelegatedInkPointParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DelegatedInkPointRendererStoreDelegatedInkPointParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DelegatedInkPointRendererStoreDelegatedInkPointParams result =
            new DelegatedInkPointRendererStoreDelegatedInkPointParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.point = DelegatedInkPoint.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.point, 8, false);
    }
  }

  static final class DelegatedInkPointRendererResetPredictionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DelegatedInkPointRendererResetPredictionParams(int version) {
      super(8, version);
    }

    public DelegatedInkPointRendererResetPredictionParams() {
      this(0);
    }

    public static DelegatedInkPointRendererResetPredictionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DelegatedInkPointRendererResetPredictionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DelegatedInkPointRendererResetPredictionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DelegatedInkPointRendererResetPredictionParams result =
            new DelegatedInkPointRendererResetPredictionParams(elementsOrVersion);
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
}
