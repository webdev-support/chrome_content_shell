package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
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

class PopupWidgetHost_Internal {
  public static final Interface.Manager<PopupWidgetHost, PopupWidgetHost.Proxy> MANAGER =
      new Interface.Manager<PopupWidgetHost, PopupWidgetHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.PopupWidgetHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PopupWidgetHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PopupWidgetHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public PopupWidgetHost[] buildArray(int size) {
          return new PopupWidgetHost[size];
        }
      };
  private static final int REQUEST_CLOSE_POPUP_ORDINAL = 0;
  private static final int SET_POPUP_BOUNDS_ORDINAL = 2;
  private static final int SHOW_POPUP_ORDINAL = 1;

  PopupWidgetHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements PopupWidgetHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestClosePopup() {
      PopupWidgetHostRequestClosePopupParams _message =
          new PopupWidgetHostRequestClosePopupParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void showPopup(Rect initialRect, Rect anchorRect, ShowPopup_Response callback) {
      PopupWidgetHostShowPopupParams _message = new PopupWidgetHostShowPopupParams();
      _message.initialRect = initialRect;
      _message.anchorRect = anchorRect;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new PopupWidgetHostShowPopupResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setPopupBounds(Rect bounds, SetPopupBounds_Response callback) {
      PopupWidgetHostSetPopupBoundsParams _message = new PopupWidgetHostSetPopupBoundsParams();
      _message.bounds = bounds;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new PopupWidgetHostSetPopupBoundsResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<PopupWidgetHost> {
    Stub(Core core, PopupWidgetHost impl) {
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
                PopupWidgetHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PopupWidgetHostRequestClosePopupParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestClosePopup();
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
                getCore(), PopupWidgetHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            PopupWidgetHostShowPopupParams data =
                PopupWidgetHostShowPopupParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .showPopup(
                    data.initialRect,
                    data.anchorRect,
                    new PopupWidgetHostShowPopupResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            getImpl()
                .setPopupBounds(
                    PopupWidgetHostSetPopupBoundsParams.deserialize(messageWithHeader.getPayload())
                        .bounds,
                    new PopupWidgetHostSetPopupBoundsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PopupWidgetHostRequestClosePopupParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PopupWidgetHostRequestClosePopupParams(int version) {
      super(8, version);
    }

    public PopupWidgetHostRequestClosePopupParams() {
      this(0);
    }

    public static PopupWidgetHostRequestClosePopupParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PopupWidgetHostRequestClosePopupParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PopupWidgetHostRequestClosePopupParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PopupWidgetHostRequestClosePopupParams result =
            new PopupWidgetHostRequestClosePopupParams(elementsOrVersion);
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

  static final class PopupWidgetHostShowPopupParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect anchorRect;
    public Rect initialRect;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PopupWidgetHostShowPopupParams(int version) {
      super(24, version);
    }

    public PopupWidgetHostShowPopupParams() {
      this(0);
    }

    public static PopupWidgetHostShowPopupParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PopupWidgetHostShowPopupParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PopupWidgetHostShowPopupParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PopupWidgetHostShowPopupParams result =
            new PopupWidgetHostShowPopupParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.initialRect = Rect.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.anchorRect = Rect.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.initialRect, 8, false);
      encoder0.encode((Struct) this.anchorRect, 16, false);
    }
  }

  static final class PopupWidgetHostShowPopupResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PopupWidgetHostShowPopupResponseParams(int version) {
      super(8, version);
    }

    public PopupWidgetHostShowPopupResponseParams() {
      this(0);
    }

    public static PopupWidgetHostShowPopupResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PopupWidgetHostShowPopupResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PopupWidgetHostShowPopupResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PopupWidgetHostShowPopupResponseParams result =
            new PopupWidgetHostShowPopupResponseParams(elementsOrVersion);
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

  static class PopupWidgetHostShowPopupResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PopupWidgetHost.ShowPopup_Response mCallback;

    PopupWidgetHostShowPopupResponseParamsForwardToCallback(
        PopupWidgetHost.ShowPopup_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PopupWidgetHostShowPopupResponseParamsProxyToResponder
      implements PopupWidgetHost.ShowPopup_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PopupWidgetHostShowPopupResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      PopupWidgetHostShowPopupResponseParams _response =
          new PopupWidgetHostShowPopupResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class PopupWidgetHostSetPopupBoundsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect bounds;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PopupWidgetHostSetPopupBoundsParams(int version) {
      super(16, version);
    }

    public PopupWidgetHostSetPopupBoundsParams() {
      this(0);
    }

    public static PopupWidgetHostSetPopupBoundsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PopupWidgetHostSetPopupBoundsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PopupWidgetHostSetPopupBoundsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PopupWidgetHostSetPopupBoundsParams result =
            new PopupWidgetHostSetPopupBoundsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.bounds = Rect.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.bounds, 8, false);
    }
  }

  static final class PopupWidgetHostSetPopupBoundsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PopupWidgetHostSetPopupBoundsResponseParams(int version) {
      super(8, version);
    }

    public PopupWidgetHostSetPopupBoundsResponseParams() {
      this(0);
    }

    public static PopupWidgetHostSetPopupBoundsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PopupWidgetHostSetPopupBoundsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PopupWidgetHostSetPopupBoundsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PopupWidgetHostSetPopupBoundsResponseParams result =
            new PopupWidgetHostSetPopupBoundsResponseParams(elementsOrVersion);
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

  static class PopupWidgetHostSetPopupBoundsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final PopupWidgetHost.SetPopupBounds_Response mCallback;

    PopupWidgetHostSetPopupBoundsResponseParamsForwardToCallback(
        PopupWidgetHost.SetPopupBounds_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class PopupWidgetHostSetPopupBoundsResponseParamsProxyToResponder
      implements PopupWidgetHost.SetPopupBounds_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    PopupWidgetHostSetPopupBoundsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      PopupWidgetHostSetPopupBoundsResponseParams _response =
          new PopupWidgetHostSetPopupBoundsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
