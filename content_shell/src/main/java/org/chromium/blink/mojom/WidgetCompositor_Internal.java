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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class WidgetCompositor_Internal {
  public static final Interface.Manager<WidgetCompositor, WidgetCompositor.Proxy> MANAGER =
      new Interface.Manager<WidgetCompositor, WidgetCompositor.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.WidgetCompositor";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WidgetCompositor.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WidgetCompositor impl) {
          return new Stub(core, impl);
        }

        @Override
        public WidgetCompositor[] buildArray(int size) {
          return new WidgetCompositor[size];
        }
      };
  private static final int VISUAL_STATE_REQUEST_ORDINAL = 0;

  WidgetCompositor_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WidgetCompositor.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void visualStateRequest(VisualStateRequest_Response callback) {
      WidgetCompositorVisualStateRequestParams _message =
          new WidgetCompositorVisualStateRequestParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new WidgetCompositorVisualStateRequestResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<WidgetCompositor> {
    Stub(Core core, WidgetCompositor impl) {
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
                WidgetCompositor_Internal.MANAGER, messageWithHeader);
          default:
            return false;
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
                getCore(), WidgetCompositor_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            WidgetCompositorVisualStateRequestParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .visualStateRequest(
                    new WidgetCompositorVisualStateRequestResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WidgetCompositorVisualStateRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetCompositorVisualStateRequestParams(int version) {
      super(8, version);
    }

    public WidgetCompositorVisualStateRequestParams() {
      this(0);
    }

    public static WidgetCompositorVisualStateRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetCompositorVisualStateRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetCompositorVisualStateRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetCompositorVisualStateRequestParams result =
            new WidgetCompositorVisualStateRequestParams(elementsOrVersion);
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

  static final class WidgetCompositorVisualStateRequestResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetCompositorVisualStateRequestResponseParams(int version) {
      super(8, version);
    }

    public WidgetCompositorVisualStateRequestResponseParams() {
      this(0);
    }

    public static WidgetCompositorVisualStateRequestResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetCompositorVisualStateRequestResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetCompositorVisualStateRequestResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetCompositorVisualStateRequestResponseParams result =
            new WidgetCompositorVisualStateRequestResponseParams(elementsOrVersion);
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

  static class WidgetCompositorVisualStateRequestResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WidgetCompositor.VisualStateRequest_Response mCallback;

    WidgetCompositorVisualStateRequestResponseParamsForwardToCallback(
        WidgetCompositor.VisualStateRequest_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WidgetCompositorVisualStateRequestResponseParamsProxyToResponder
      implements WidgetCompositor.VisualStateRequest_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WidgetCompositorVisualStateRequestResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      WidgetCompositorVisualStateRequestResponseParams _response =
          new WidgetCompositorVisualStateRequestResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
