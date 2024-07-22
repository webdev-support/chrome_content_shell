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
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class Widget_Internal {
  private static final int CANCEL_SUCCESSFUL_PRESENTATION_TIME_REQUEST_ORDINAL = 7;
  private static final int FORCE_REDRAW_ORDINAL = 0;
  private static final int GET_WIDGET_INPUT_HANDLER_ORDINAL = 1;
  public static final Interface.Manager<Widget, Widget.Proxy> MANAGER =
      new Interface.Manager<Widget, Widget.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.Widget";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Widget.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, Widget impl) {
          return new Stub(core, impl);
        }

        @Override
        public Widget[] buildArray(int size) {
          return new Widget[size];
        }
      };
  private static final int REQUEST_SUCCESSFUL_PRESENTATION_TIME_FOR_NEXT_FRAME_ORDINAL = 6;
  private static final int UPDATE_SCREEN_RECTS_ORDINAL = 3;
  private static final int UPDATE_VISUAL_PROPERTIES_ORDINAL = 2;
  private static final int WAS_HIDDEN_ORDINAL = 4;
  private static final int WAS_SHOWN_ORDINAL = 5;

  Widget_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements Widget.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void forceRedraw(ForceRedraw_Response callback) {
      WidgetForceRedrawParams _message = new WidgetForceRedrawParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new WidgetForceRedrawResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getWidgetInputHandler(
        InterfaceRequest<WidgetInputHandler> request, WidgetInputHandlerHost host) {
      WidgetGetWidgetInputHandlerParams _message = new WidgetGetWidgetInputHandlerParams();
      _message.request = request;
      _message.host = host;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void updateVisualProperties(VisualProperties visualProperties) {
      WidgetUpdateVisualPropertiesParams _message = new WidgetUpdateVisualPropertiesParams();
      _message.visualProperties = visualProperties;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void updateScreenRects(
        Rect widgetScreenRect, Rect windowScreenRect, UpdateScreenRects_Response callback) {
      WidgetUpdateScreenRectsParams _message = new WidgetUpdateScreenRectsParams();
      _message.widgetScreenRect = widgetScreenRect;
      _message.windowScreenRect = windowScreenRect;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new WidgetUpdateScreenRectsResponseParamsForwardToCallback(callback));
    }

    @Override
    public void wasHidden() {
      WidgetWasHiddenParams _message = new WidgetWasHiddenParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void wasShown(
        boolean wasEvicted, RecordContentToVisibleTimeRequest recordTabSwitchTimeRequest) {
      WidgetWasShownParams _message = new WidgetWasShownParams();
      _message.wasEvicted = wasEvicted;
      _message.recordTabSwitchTimeRequest = recordTabSwitchTimeRequest;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void requestSuccessfulPresentationTimeForNextFrame(
        RecordContentToVisibleTimeRequest visibleTimeRequest) {
      WidgetRequestSuccessfulPresentationTimeForNextFrameParams _message =
          new WidgetRequestSuccessfulPresentationTimeForNextFrameParams();
      _message.visibleTimeRequest = visibleTimeRequest;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void cancelSuccessfulPresentationTimeRequest() {
      WidgetCancelSuccessfulPresentationTimeRequestParams _message =
          new WidgetCancelSuccessfulPresentationTimeRequestParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }
  }

  public static final class Stub extends Interface.Stub<Widget> {
    Stub(Core core, Widget impl) {
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
                Widget_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          case 3:
          default:
            return false;
          case 1:
            WidgetGetWidgetInputHandlerParams data =
                WidgetGetWidgetInputHandlerParams.deserialize(messageWithHeader.getPayload());
            getImpl().getWidgetInputHandler(data.request, data.host);
            return true;
          case 2:
            getImpl()
                .updateVisualProperties(
                    WidgetUpdateVisualPropertiesParams.deserialize(messageWithHeader.getPayload())
                        .visualProperties);
            return true;
          case 4:
            WidgetWasHiddenParams.deserialize(messageWithHeader.getPayload());
            getImpl().wasHidden();
            return true;
          case 5:
            WidgetWasShownParams data2 =
                WidgetWasShownParams.deserialize(messageWithHeader.getPayload());
            getImpl().wasShown(data2.wasEvicted, data2.recordTabSwitchTimeRequest);
            return true;
          case 6:
            getImpl()
                .requestSuccessfulPresentationTimeForNextFrame(
                    WidgetRequestSuccessfulPresentationTimeForNextFrameParams.deserialize(
                            messageWithHeader.getPayload())
                        .visibleTimeRequest);
            return true;
          case 7:
            WidgetCancelSuccessfulPresentationTimeRequestParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().cancelSuccessfulPresentationTimeRequest();
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
                getCore(), Widget_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            WidgetForceRedrawParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .forceRedraw(
                    new WidgetForceRedrawResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
          case 2:
          default:
            return false;
          case 3:
            WidgetUpdateScreenRectsParams data =
                WidgetUpdateScreenRectsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .updateScreenRects(
                    data.widgetScreenRect,
                    data.windowScreenRect,
                    new WidgetUpdateScreenRectsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WidgetForceRedrawParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetForceRedrawParams(int version) {
      super(8, version);
    }

    public WidgetForceRedrawParams() {
      this(0);
    }

    public static WidgetForceRedrawParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetForceRedrawParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetForceRedrawParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetForceRedrawParams result = new WidgetForceRedrawParams(elementsOrVersion);
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

  static final class WidgetForceRedrawResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetForceRedrawResponseParams(int version) {
      super(8, version);
    }

    public WidgetForceRedrawResponseParams() {
      this(0);
    }

    public static WidgetForceRedrawResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetForceRedrawResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetForceRedrawResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetForceRedrawResponseParams result =
            new WidgetForceRedrawResponseParams(elementsOrVersion);
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

  static class WidgetForceRedrawResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final Widget.ForceRedraw_Response mCallback;

    WidgetForceRedrawResponseParamsForwardToCallback(Widget.ForceRedraw_Response callback) {
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

  static class WidgetForceRedrawResponseParamsProxyToResponder
      implements Widget.ForceRedraw_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WidgetForceRedrawResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      WidgetForceRedrawResponseParams _response = new WidgetForceRedrawResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WidgetGetWidgetInputHandlerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public WidgetInputHandlerHost host;
    public InterfaceRequest<WidgetInputHandler> request;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetGetWidgetInputHandlerParams(int version) {
      super(24, version);
    }

    public WidgetGetWidgetInputHandlerParams() {
      this(0);
    }

    public static WidgetGetWidgetInputHandlerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetGetWidgetInputHandlerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetGetWidgetInputHandlerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetGetWidgetInputHandlerParams result =
            new WidgetGetWidgetInputHandlerParams(elementsOrVersion);
        result.request = decoder0.readInterfaceRequest(8, false);
        result.host =
            (WidgetInputHandlerHost)
                decoder0.readServiceInterface(12, false, WidgetInputHandlerHost.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.request, 8, false);
      encoder0.encode(this.host, 12, false, WidgetInputHandlerHost.MANAGER);
    }
  }

  static final class WidgetUpdateVisualPropertiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public VisualProperties visualProperties;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetUpdateVisualPropertiesParams(int version) {
      super(16, version);
    }

    public WidgetUpdateVisualPropertiesParams() {
      this(0);
    }

    public static WidgetUpdateVisualPropertiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetUpdateVisualPropertiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetUpdateVisualPropertiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetUpdateVisualPropertiesParams result =
            new WidgetUpdateVisualPropertiesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.visualProperties = VisualProperties.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.visualProperties, 8, false);
    }
  }

  static final class WidgetUpdateScreenRectsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect widgetScreenRect;
    public Rect windowScreenRect;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetUpdateScreenRectsParams(int version) {
      super(24, version);
    }

    public WidgetUpdateScreenRectsParams() {
      this(0);
    }

    public static WidgetUpdateScreenRectsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetUpdateScreenRectsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetUpdateScreenRectsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetUpdateScreenRectsParams result = new WidgetUpdateScreenRectsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.widgetScreenRect = Rect.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.windowScreenRect = Rect.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.widgetScreenRect, 8, false);
      encoder0.encode((Struct) this.windowScreenRect, 16, false);
    }
  }

  static final class WidgetUpdateScreenRectsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetUpdateScreenRectsResponseParams(int version) {
      super(8, version);
    }

    public WidgetUpdateScreenRectsResponseParams() {
      this(0);
    }

    public static WidgetUpdateScreenRectsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetUpdateScreenRectsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetUpdateScreenRectsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetUpdateScreenRectsResponseParams result =
            new WidgetUpdateScreenRectsResponseParams(elementsOrVersion);
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

  static class WidgetUpdateScreenRectsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Widget.UpdateScreenRects_Response mCallback;

    WidgetUpdateScreenRectsResponseParamsForwardToCallback(
        Widget.UpdateScreenRects_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WidgetUpdateScreenRectsResponseParamsProxyToResponder
      implements Widget.UpdateScreenRects_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WidgetUpdateScreenRectsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      WidgetUpdateScreenRectsResponseParams _response = new WidgetUpdateScreenRectsResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WidgetWasHiddenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetWasHiddenParams(int version) {
      super(8, version);
    }

    public WidgetWasHiddenParams() {
      this(0);
    }

    public static WidgetWasHiddenParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetWasHiddenParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetWasHiddenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetWasHiddenParams result = new WidgetWasHiddenParams(elementsOrVersion);
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

  static final class WidgetWasShownParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public RecordContentToVisibleTimeRequest recordTabSwitchTimeRequest;
    public boolean wasEvicted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetWasShownParams(int version) {
      super(24, version);
    }

    public WidgetWasShownParams() {
      this(0);
    }

    public static WidgetWasShownParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetWasShownParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetWasShownParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetWasShownParams result = new WidgetWasShownParams(elementsOrVersion);
        result.wasEvicted = decoder0.readBoolean(8, 0);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.recordTabSwitchTimeRequest = RecordContentToVisibleTimeRequest.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.wasEvicted, 8, 0);
      encoder0.encode((Struct) this.recordTabSwitchTimeRequest, 16, true);
    }
  }

  static final class WidgetRequestSuccessfulPresentationTimeForNextFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public RecordContentToVisibleTimeRequest visibleTimeRequest;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetRequestSuccessfulPresentationTimeForNextFrameParams(int version) {
      super(16, version);
    }

    public WidgetRequestSuccessfulPresentationTimeForNextFrameParams() {
      this(0);
    }

    public static WidgetRequestSuccessfulPresentationTimeForNextFrameParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetRequestSuccessfulPresentationTimeForNextFrameParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetRequestSuccessfulPresentationTimeForNextFrameParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetRequestSuccessfulPresentationTimeForNextFrameParams result =
            new WidgetRequestSuccessfulPresentationTimeForNextFrameParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.visibleTimeRequest = RecordContentToVisibleTimeRequest.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.visibleTimeRequest, 8, false);
    }
  }

  static final class WidgetCancelSuccessfulPresentationTimeRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetCancelSuccessfulPresentationTimeRequestParams(int version) {
      super(8, version);
    }

    public WidgetCancelSuccessfulPresentationTimeRequestParams() {
      this(0);
    }

    public static WidgetCancelSuccessfulPresentationTimeRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetCancelSuccessfulPresentationTimeRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetCancelSuccessfulPresentationTimeRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetCancelSuccessfulPresentationTimeRequestParams result =
            new WidgetCancelSuccessfulPresentationTimeRequestParams(elementsOrVersion);
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
