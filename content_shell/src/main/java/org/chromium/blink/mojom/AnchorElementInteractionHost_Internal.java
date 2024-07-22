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
import org.chromium.url.mojom.Url;

class AnchorElementInteractionHost_Internal {
  public static final Interface.Manager<
          AnchorElementInteractionHost, AnchorElementInteractionHost.Proxy>
      MANAGER =
          new Interface.Manager<
              AnchorElementInteractionHost, AnchorElementInteractionHost.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.AnchorElementInteractionHost";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public AnchorElementInteractionHost.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, AnchorElementInteractionHost impl) {
              return new Stub(core, impl);
            }

            @Override
            public AnchorElementInteractionHost[] buildArray(int size) {
              return new AnchorElementInteractionHost[size];
            }
          };
  private static final int ON_POINTER_DOWN_ORDINAL = 0;
  private static final int ON_POINTER_HOVER_ORDINAL = 1;

  AnchorElementInteractionHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AnchorElementInteractionHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onPointerDown(Url target) {
      AnchorElementInteractionHostOnPointerDownParams _message =
          new AnchorElementInteractionHostOnPointerDownParams();
      _message.target = target;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onPointerHover(Url target, AnchorElementPointerData mouseData) {
      AnchorElementInteractionHostOnPointerHoverParams _message =
          new AnchorElementInteractionHostOnPointerHoverParams();
      _message.target = target;
      _message.mouseData = mouseData;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<AnchorElementInteractionHost> {
    Stub(Core core, AnchorElementInteractionHost impl) {
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
                AnchorElementInteractionHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .onPointerDown(
                    AnchorElementInteractionHostOnPointerDownParams.deserialize(
                            messageWithHeader.getPayload())
                        .target);
            return true;
          case 1:
            AnchorElementInteractionHostOnPointerHoverParams data =
                AnchorElementInteractionHostOnPointerHoverParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onPointerHover(data.target, data.mouseData);
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
                AnchorElementInteractionHost_Internal.MANAGER,
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

  static final class AnchorElementInteractionHostOnPointerDownParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url target;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementInteractionHostOnPointerDownParams(int version) {
      super(16, version);
    }

    public AnchorElementInteractionHostOnPointerDownParams() {
      this(0);
    }

    public static AnchorElementInteractionHostOnPointerDownParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementInteractionHostOnPointerDownParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementInteractionHostOnPointerDownParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementInteractionHostOnPointerDownParams result =
            new AnchorElementInteractionHostOnPointerDownParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.target = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.target, 8, false);
    }
  }

  static final class AnchorElementInteractionHostOnPointerHoverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AnchorElementPointerData mouseData;
    public Url target;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AnchorElementInteractionHostOnPointerHoverParams(int version) {
      super(24, version);
    }

    public AnchorElementInteractionHostOnPointerHoverParams() {
      this(0);
    }

    public static AnchorElementInteractionHostOnPointerHoverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AnchorElementInteractionHostOnPointerHoverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementInteractionHostOnPointerHoverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AnchorElementInteractionHostOnPointerHoverParams result =
            new AnchorElementInteractionHostOnPointerHoverParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.target = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.mouseData = AnchorElementPointerData.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.target, 8, false);
      encoder0.encode((Struct) this.mouseData, 16, false);
    }
  }
}
