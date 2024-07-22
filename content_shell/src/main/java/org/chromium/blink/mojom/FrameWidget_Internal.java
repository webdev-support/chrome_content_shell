package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.cc.mojom.TouchAction;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.PointF;
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
import org.chromium.mojo_base.mojom.TextDirection;
import org.chromium.ui.mojom.DragOperation;
import org.chromium.ui.mojom.MenuSourceType;
import org.chromium.viz.mojom.InputTargetClient;

class FrameWidget_Internal {
  private static final int BIND_INPUT_TARGET_CLIENT_ORDINAL = 17;
  private static final int BIND_WIDGET_COMPOSITOR_ORDINAL = 16;
  private static final int DISABLE_DEVICE_EMULATION_ORDINAL = 15;
  private static final int DRAG_SOURCE_ENDED_AT_ORDINAL = 4;
  private static final int DRAG_SOURCE_SYSTEM_DRAG_ENDED_ORDINAL = 5;
  private static final int DRAG_TARGET_DRAG_ENTER_ORDINAL = 0;
  private static final int DRAG_TARGET_DRAG_LEAVE_ORDINAL = 2;
  private static final int DRAG_TARGET_DRAG_OVER_ORDINAL = 1;
  private static final int DRAG_TARGET_DROP_ORDINAL = 3;
  private static final int ENABLE_DEVICE_EMULATION_ORDINAL = 14;
  public static final Interface.Manager<FrameWidget, FrameWidget.Proxy> MANAGER =
      new Interface.Manager<FrameWidget, FrameWidget.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.FrameWidget";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FrameWidget.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FrameWidget impl) {
          return new Stub(core, impl);
        }

        @Override
        public FrameWidget[] buildArray(int size) {
          return new FrameWidget[size];
        }
      };
  private static final int ON_START_STYLUS_WRITING_ORDINAL = 6;
  private static final int SET_ACTIVE_ORDINAL = 9;
  private static final int SET_BACKGROUND_OPAQUE_ORDINAL = 7;
  private static final int SET_INHERITED_EFFECTIVE_TOUCH_ACTION_FOR_SUB_FRAME_ORDINAL = 10;
  private static final int SET_IS_INERT_FOR_SUB_FRAME_ORDINAL = 12;
  private static final int SET_TEXT_DIRECTION_ORDINAL = 8;
  private static final int SET_VIEWPORT_INTERSECTION_ORDINAL = 18;
  private static final int SHOW_CONTEXT_MENU_ORDINAL = 13;
  private static final int UPDATE_RENDER_THROTTLING_STATUS_FOR_SUB_FRAME_ORDINAL = 11;

  FrameWidget_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements FrameWidget.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void dragTargetDragEnter(
        DragData dragData,
        PointF pointInViewport,
        PointF screenPoint,
        AllowedDragOperations operationsAllowed,
        int keyModifiers,
        DragTargetDragEnter_Response callback) {
      FrameWidgetDragTargetDragEnterParams _message = new FrameWidgetDragTargetDragEnterParams();
      _message.dragData = dragData;
      _message.pointInViewport = pointInViewport;
      _message.screenPoint = screenPoint;
      _message.operationsAllowed = operationsAllowed;
      _message.keyModifiers = keyModifiers;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FrameWidgetDragTargetDragEnterResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dragTargetDragOver(
        PointF pointInViewport,
        PointF screenPoint,
        AllowedDragOperations operationsAllowed,
        int keyModifiers,
        DragTargetDragOver_Response callback) {
      FrameWidgetDragTargetDragOverParams _message = new FrameWidgetDragTargetDragOverParams();
      _message.pointInViewport = pointInViewport;
      _message.screenPoint = screenPoint;
      _message.operationsAllowed = operationsAllowed;
      _message.keyModifiers = keyModifiers;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FrameWidgetDragTargetDragOverResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dragTargetDragLeave(PointF pointInViewport, PointF screenPoint) {
      FrameWidgetDragTargetDragLeaveParams _message = new FrameWidgetDragTargetDragLeaveParams();
      _message.pointInViewport = pointInViewport;
      _message.screenPoint = screenPoint;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void dragTargetDrop(
        DragData dragData,
        PointF pointInViewport,
        PointF screenPoint,
        int keyModifiers,
        DragTargetDrop_Response callback) {
      FrameWidgetDragTargetDropParams _message = new FrameWidgetDragTargetDropParams();
      _message.dragData = dragData;
      _message.pointInViewport = pointInViewport;
      _message.screenPoint = screenPoint;
      _message.keyModifiers = keyModifiers;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new FrameWidgetDragTargetDropResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dragSourceEndedAt(
        PointF pointInViewport,
        PointF screenPoint,
        int dragOperation,
        DragSourceEndedAt_Response callback) {
      FrameWidgetDragSourceEndedAtParams _message = new FrameWidgetDragSourceEndedAtParams();
      _message.pointInViewport = pointInViewport;
      _message.screenPoint = screenPoint;
      _message.dragOperation = dragOperation;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new FrameWidgetDragSourceEndedAtResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dragSourceSystemDragEnded() {
      FrameWidgetDragSourceSystemDragEndedParams _message =
          new FrameWidgetDragSourceSystemDragEndedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void onStartStylusWriting(OnStartStylusWriting_Response callback) {
      FrameWidgetOnStartStylusWritingParams _message = new FrameWidgetOnStartStylusWritingParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new FrameWidgetOnStartStylusWritingResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setBackgroundOpaque(boolean opaque) {
      FrameWidgetSetBackgroundOpaqueParams _message = new FrameWidgetSetBackgroundOpaqueParams();
      _message.opaque = opaque;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void setTextDirection(int direction) {
      FrameWidgetSetTextDirectionParams _message = new FrameWidgetSetTextDirectionParams();
      _message.direction = direction;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void setActive(boolean active) {
      FrameWidgetSetActiveParams _message = new FrameWidgetSetActiveParams();
      _message.active = active;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void setInheritedEffectiveTouchActionForSubFrame(int touchAction) {
      FrameWidgetSetInheritedEffectiveTouchActionForSubFrameParams _message =
          new FrameWidgetSetInheritedEffectiveTouchActionForSubFrameParams();
      _message.touchAction = touchAction;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void updateRenderThrottlingStatusForSubFrame(
        boolean isThrottled, boolean subtreeThrottled, boolean displayLocked) {
      FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams _message =
          new FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams();
      _message.isThrottled = isThrottled;
      _message.subtreeThrottled = subtreeThrottled;
      _message.displayLocked = displayLocked;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }

    @Override
    public void setIsInertForSubFrame(boolean inert) {
      FrameWidgetSetIsInertForSubFrameParams _message =
          new FrameWidgetSetIsInertForSubFrameParams();
      _message.inert = inert;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }

    @Override
    public void showContextMenu(int sourceType, Point location) {
      FrameWidgetShowContextMenuParams _message = new FrameWidgetShowContextMenuParams();
      _message.sourceType = sourceType;
      _message.location = location;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
    }

    @Override
    public void enableDeviceEmulation(DeviceEmulationParams parameters) {
      FrameWidgetEnableDeviceEmulationParams _message =
          new FrameWidgetEnableDeviceEmulationParams();
      _message.parameters = parameters;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14)));
    }

    @Override
    public void disableDeviceEmulation() {
      FrameWidgetDisableDeviceEmulationParams _message =
          new FrameWidgetDisableDeviceEmulationParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(15)));
    }

    @Override
    public void bindWidgetCompositor(InterfaceRequest<WidgetCompositor> host) {
      FrameWidgetBindWidgetCompositorParams _message = new FrameWidgetBindWidgetCompositorParams();
      _message.host = host;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(16)));
    }

    @Override
    public void bindInputTargetClient(InterfaceRequest<InputTargetClient> host) {
      FrameWidgetBindInputTargetClientParams _message =
          new FrameWidgetBindInputTargetClientParams();
      _message.host = host;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(17)));
    }

    @Override
    public void setViewportIntersection(
        ViewportIntersectionState intersectionState, VisualProperties visualProperties) {
      FrameWidgetSetViewportIntersectionParams _message =
          new FrameWidgetSetViewportIntersectionParams();
      _message.intersectionState = intersectionState;
      _message.visualProperties = visualProperties;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(18)));
    }
  }

  public static final class Stub extends Interface.Stub<FrameWidget> {
    Stub(Core core, FrameWidget impl) {
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
                FrameWidget_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          case 1:
          case 3:
          case 4:
          case 6:
          default:
            return false;
          case 2:
            FrameWidgetDragTargetDragLeaveParams data =
                FrameWidgetDragTargetDragLeaveParams.deserialize(messageWithHeader.getPayload());
            getImpl().dragTargetDragLeave(data.pointInViewport, data.screenPoint);
            return true;
          case 5:
            FrameWidgetDragSourceSystemDragEndedParams.deserialize(messageWithHeader.getPayload());
            getImpl().dragSourceSystemDragEnded();
            return true;
          case 7:
            getImpl()
                .setBackgroundOpaque(
                    FrameWidgetSetBackgroundOpaqueParams.deserialize(messageWithHeader.getPayload())
                        .opaque);
            return true;
          case 8:
            getImpl()
                .setTextDirection(
                    FrameWidgetSetTextDirectionParams.deserialize(messageWithHeader.getPayload())
                        .direction);
            return true;
          case 9:
            getImpl()
                .setActive(
                    FrameWidgetSetActiveParams.deserialize(messageWithHeader.getPayload()).active);
            return true;
          case 10:
            getImpl()
                .setInheritedEffectiveTouchActionForSubFrame(
                    FrameWidgetSetInheritedEffectiveTouchActionForSubFrameParams.deserialize(
                            messageWithHeader.getPayload())
                        .touchAction);
            return true;
          case 11:
            FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams data2 =
                FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .updateRenderThrottlingStatusForSubFrame(
                    data2.isThrottled, data2.subtreeThrottled, data2.displayLocked);
            return true;
          case 12:
            getImpl()
                .setIsInertForSubFrame(
                    FrameWidgetSetIsInertForSubFrameParams.deserialize(
                            messageWithHeader.getPayload())
                        .inert);
            return true;
          case 13:
            FrameWidgetShowContextMenuParams data3 =
                FrameWidgetShowContextMenuParams.deserialize(messageWithHeader.getPayload());
            getImpl().showContextMenu(data3.sourceType, data3.location);
            return true;
          case 14:
            getImpl()
                .enableDeviceEmulation(
                    FrameWidgetEnableDeviceEmulationParams.deserialize(
                            messageWithHeader.getPayload())
                        .parameters);
            return true;
          case 15:
            FrameWidgetDisableDeviceEmulationParams.deserialize(messageWithHeader.getPayload());
            getImpl().disableDeviceEmulation();
            return true;
          case 16:
            getImpl()
                .bindWidgetCompositor(
                    FrameWidgetBindWidgetCompositorParams.deserialize(
                            messageWithHeader.getPayload())
                        .host);
            return true;
          case 17:
            getImpl()
                .bindInputTargetClient(
                    FrameWidgetBindInputTargetClientParams.deserialize(
                            messageWithHeader.getPayload())
                        .host);
            return true;
          case 18:
            FrameWidgetSetViewportIntersectionParams data4 =
                FrameWidgetSetViewportIntersectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setViewportIntersection(data4.intersectionState, data4.visualProperties);
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
                getCore(), FrameWidget_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            FrameWidgetDragTargetDragEnterParams data =
                FrameWidgetDragTargetDragEnterParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .dragTargetDragEnter(
                    data.dragData,
                    data.pointInViewport,
                    data.screenPoint,
                    data.operationsAllowed,
                    data.keyModifiers,
                    new FrameWidgetDragTargetDragEnterResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            FrameWidgetDragTargetDragOverParams data2 =
                FrameWidgetDragTargetDragOverParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .dragTargetDragOver(
                    data2.pointInViewport,
                    data2.screenPoint,
                    data2.operationsAllowed,
                    data2.keyModifiers,
                    new FrameWidgetDragTargetDragOverResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
          case 5:
          default:
            return false;
          case 3:
            FrameWidgetDragTargetDropParams data3 =
                FrameWidgetDragTargetDropParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .dragTargetDrop(
                    data3.dragData,
                    data3.pointInViewport,
                    data3.screenPoint,
                    data3.keyModifiers,
                    new FrameWidgetDragTargetDropResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            FrameWidgetDragSourceEndedAtParams data4 =
                FrameWidgetDragSourceEndedAtParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .dragSourceEndedAt(
                    data4.pointInViewport,
                    data4.screenPoint,
                    data4.dragOperation,
                    new FrameWidgetDragSourceEndedAtResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            FrameWidgetOnStartStylusWritingParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .onStartStylusWriting(
                    new FrameWidgetOnStartStylusWritingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FrameWidgetDragTargetDragEnterParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public DragData dragData;
    public int keyModifiers;
    public AllowedDragOperations operationsAllowed;
    public PointF pointInViewport;
    public PointF screenPoint;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetDragTargetDragEnterParams(int version) {
      super(48, version);
    }

    public FrameWidgetDragTargetDragEnterParams() {
      this(0);
    }

    public static FrameWidgetDragTargetDragEnterParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetDragTargetDragEnterParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetDragTargetDragEnterParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetDragTargetDragEnterParams result =
            new FrameWidgetDragTargetDragEnterParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.dragData = DragData.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.pointInViewport = PointF.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.screenPoint = PointF.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(32, false);
        result.operationsAllowed = AllowedDragOperations.decode(decoder14);
        result.keyModifiers = decoder0.readInt(40);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.dragData, 8, false);
      encoder0.encode((Struct) this.pointInViewport, 16, false);
      encoder0.encode((Struct) this.screenPoint, 24, false);
      encoder0.encode((Struct) this.operationsAllowed, 32, false);
      encoder0.encode(this.keyModifiers, 40);
    }
  }

  static final class FrameWidgetDragTargetDragEnterResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean documentIsHandlingDrag;
    public int operation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetDragTargetDragEnterResponseParams(int version) {
      super(16, version);
    }

    public FrameWidgetDragTargetDragEnterResponseParams() {
      this(0);
    }

    public static FrameWidgetDragTargetDragEnterResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetDragTargetDragEnterResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetDragTargetDragEnterResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetDragTargetDragEnterResponseParams result =
            new FrameWidgetDragTargetDragEnterResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.operation = readInt;
        DragOperation.validate(readInt);
        result.operation = DragOperation.toKnownValue(result.operation);
        result.documentIsHandlingDrag = decoder0.readBoolean(12, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.operation, 8);
      encoder0.encode(this.documentIsHandlingDrag, 12, 0);
    }
  }

  static class FrameWidgetDragTargetDragEnterResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FrameWidget.DragTargetDragEnter_Response mCallback;

    FrameWidgetDragTargetDragEnterResponseParamsForwardToCallback(
        FrameWidget.DragTargetDragEnter_Response callback) {
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
        FrameWidgetDragTargetDragEnterResponseParams response =
            FrameWidgetDragTargetDragEnterResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.operation, response.documentIsHandlingDrag);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FrameWidgetDragTargetDragEnterResponseParamsProxyToResponder
      implements FrameWidget.DragTargetDragEnter_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FrameWidgetDragTargetDragEnterResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int operation, boolean documentIsHandlingDrag) {
      FrameWidgetDragTargetDragEnterResponseParams _response =
          new FrameWidgetDragTargetDragEnterResponseParams();
      _response.operation = operation;
      _response.documentIsHandlingDrag = documentIsHandlingDrag;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FrameWidgetDragTargetDragOverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public int keyModifiers;
    public AllowedDragOperations operationsAllowed;
    public PointF pointInViewport;
    public PointF screenPoint;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetDragTargetDragOverParams(int version) {
      super(40, version);
    }

    public FrameWidgetDragTargetDragOverParams() {
      this(0);
    }

    public static FrameWidgetDragTargetDragOverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetDragTargetDragOverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetDragTargetDragOverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetDragTargetDragOverParams result =
            new FrameWidgetDragTargetDragOverParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.pointInViewport = PointF.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.screenPoint = PointF.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.operationsAllowed = AllowedDragOperations.decode(decoder13);
        result.keyModifiers = decoder0.readInt(32);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.pointInViewport, 8, false);
      encoder0.encode((Struct) this.screenPoint, 16, false);
      encoder0.encode((Struct) this.operationsAllowed, 24, false);
      encoder0.encode(this.keyModifiers, 32);
    }
  }

  static final class FrameWidgetDragTargetDragOverResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean documentIsHandlingDrag;
    public int operation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetDragTargetDragOverResponseParams(int version) {
      super(16, version);
    }

    public FrameWidgetDragTargetDragOverResponseParams() {
      this(0);
    }

    public static FrameWidgetDragTargetDragOverResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetDragTargetDragOverResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetDragTargetDragOverResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetDragTargetDragOverResponseParams result =
            new FrameWidgetDragTargetDragOverResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.operation = readInt;
        DragOperation.validate(readInt);
        result.operation = DragOperation.toKnownValue(result.operation);
        result.documentIsHandlingDrag = decoder0.readBoolean(12, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.operation, 8);
      encoder0.encode(this.documentIsHandlingDrag, 12, 0);
    }
  }

  static class FrameWidgetDragTargetDragOverResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FrameWidget.DragTargetDragOver_Response mCallback;

    FrameWidgetDragTargetDragOverResponseParamsForwardToCallback(
        FrameWidget.DragTargetDragOver_Response callback) {
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
        FrameWidgetDragTargetDragOverResponseParams response =
            FrameWidgetDragTargetDragOverResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.operation, response.documentIsHandlingDrag);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FrameWidgetDragTargetDragOverResponseParamsProxyToResponder
      implements FrameWidget.DragTargetDragOver_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FrameWidgetDragTargetDragOverResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int operation, boolean documentIsHandlingDrag) {
      FrameWidgetDragTargetDragOverResponseParams _response =
          new FrameWidgetDragTargetDragOverResponseParams();
      _response.operation = operation;
      _response.documentIsHandlingDrag = documentIsHandlingDrag;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FrameWidgetDragTargetDragLeaveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public PointF pointInViewport;
    public PointF screenPoint;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetDragTargetDragLeaveParams(int version) {
      super(24, version);
    }

    public FrameWidgetDragTargetDragLeaveParams() {
      this(0);
    }

    public static FrameWidgetDragTargetDragLeaveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetDragTargetDragLeaveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetDragTargetDragLeaveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetDragTargetDragLeaveParams result =
            new FrameWidgetDragTargetDragLeaveParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.pointInViewport = PointF.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.screenPoint = PointF.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.pointInViewport, 8, false);
      encoder0.encode((Struct) this.screenPoint, 16, false);
    }
  }

  static final class FrameWidgetDragTargetDropParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public DragData dragData;
    public int keyModifiers;
    public PointF pointInViewport;
    public PointF screenPoint;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetDragTargetDropParams(int version) {
      super(40, version);
    }

    public FrameWidgetDragTargetDropParams() {
      this(0);
    }

    public static FrameWidgetDragTargetDropParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetDragTargetDropParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetDragTargetDropParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetDragTargetDropParams result =
            new FrameWidgetDragTargetDropParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.dragData = DragData.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.pointInViewport = PointF.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.screenPoint = PointF.decode(decoder13);
        result.keyModifiers = decoder0.readInt(32);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.dragData, 8, false);
      encoder0.encode((Struct) this.pointInViewport, 16, false);
      encoder0.encode((Struct) this.screenPoint, 24, false);
      encoder0.encode(this.keyModifiers, 32);
    }
  }

  static final class FrameWidgetDragTargetDropResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetDragTargetDropResponseParams(int version) {
      super(8, version);
    }

    public FrameWidgetDragTargetDropResponseParams() {
      this(0);
    }

    public static FrameWidgetDragTargetDropResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetDragTargetDropResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetDragTargetDropResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetDragTargetDropResponseParams result =
            new FrameWidgetDragTargetDropResponseParams(elementsOrVersion);
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

  static class FrameWidgetDragTargetDropResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FrameWidget.DragTargetDrop_Response mCallback;

    FrameWidgetDragTargetDropResponseParamsForwardToCallback(
        FrameWidget.DragTargetDrop_Response callback) {
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

  static class FrameWidgetDragTargetDropResponseParamsProxyToResponder
      implements FrameWidget.DragTargetDrop_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FrameWidgetDragTargetDropResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      FrameWidgetDragTargetDropResponseParams _response =
          new FrameWidgetDragTargetDropResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FrameWidgetDragSourceEndedAtParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int dragOperation;
    public PointF pointInViewport;
    public PointF screenPoint;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetDragSourceEndedAtParams(int version) {
      super(32, version);
    }

    public FrameWidgetDragSourceEndedAtParams() {
      this(0);
    }

    public static FrameWidgetDragSourceEndedAtParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetDragSourceEndedAtParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetDragSourceEndedAtParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetDragSourceEndedAtParams result =
            new FrameWidgetDragSourceEndedAtParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.pointInViewport = PointF.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.screenPoint = PointF.decode(decoder12);
        int readInt = decoder0.readInt(24);
        result.dragOperation = readInt;
        DragOperation.validate(readInt);
        result.dragOperation = DragOperation.toKnownValue(result.dragOperation);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.pointInViewport, 8, false);
      encoder0.encode((Struct) this.screenPoint, 16, false);
      encoder0.encode(this.dragOperation, 24);
    }
  }

  static final class FrameWidgetDragSourceEndedAtResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetDragSourceEndedAtResponseParams(int version) {
      super(8, version);
    }

    public FrameWidgetDragSourceEndedAtResponseParams() {
      this(0);
    }

    public static FrameWidgetDragSourceEndedAtResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetDragSourceEndedAtResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetDragSourceEndedAtResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetDragSourceEndedAtResponseParams result =
            new FrameWidgetDragSourceEndedAtResponseParams(elementsOrVersion);
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

  static class FrameWidgetDragSourceEndedAtResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FrameWidget.DragSourceEndedAt_Response mCallback;

    FrameWidgetDragSourceEndedAtResponseParamsForwardToCallback(
        FrameWidget.DragSourceEndedAt_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FrameWidgetDragSourceEndedAtResponseParamsProxyToResponder
      implements FrameWidget.DragSourceEndedAt_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FrameWidgetDragSourceEndedAtResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      FrameWidgetDragSourceEndedAtResponseParams _response =
          new FrameWidgetDragSourceEndedAtResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FrameWidgetDragSourceSystemDragEndedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetDragSourceSystemDragEndedParams(int version) {
      super(8, version);
    }

    public FrameWidgetDragSourceSystemDragEndedParams() {
      this(0);
    }

    public static FrameWidgetDragSourceSystemDragEndedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetDragSourceSystemDragEndedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetDragSourceSystemDragEndedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetDragSourceSystemDragEndedParams result =
            new FrameWidgetDragSourceSystemDragEndedParams(elementsOrVersion);
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

  static final class FrameWidgetOnStartStylusWritingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetOnStartStylusWritingParams(int version) {
      super(8, version);
    }

    public FrameWidgetOnStartStylusWritingParams() {
      this(0);
    }

    public static FrameWidgetOnStartStylusWritingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetOnStartStylusWritingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetOnStartStylusWritingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetOnStartStylusWritingParams result =
            new FrameWidgetOnStartStylusWritingParams(elementsOrVersion);
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

  static final class FrameWidgetOnStartStylusWritingResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect caretBounds;
    public Rect focusedEditBounds;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetOnStartStylusWritingResponseParams(int version) {
      super(24, version);
    }

    public FrameWidgetOnStartStylusWritingResponseParams() {
      this(0);
    }

    public static FrameWidgetOnStartStylusWritingResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetOnStartStylusWritingResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetOnStartStylusWritingResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetOnStartStylusWritingResponseParams result =
            new FrameWidgetOnStartStylusWritingResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.focusedEditBounds = Rect.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.caretBounds = Rect.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.focusedEditBounds, 8, true);
      encoder0.encode((Struct) this.caretBounds, 16, true);
    }
  }

  static class FrameWidgetOnStartStylusWritingResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FrameWidget.OnStartStylusWriting_Response mCallback;

    FrameWidgetOnStartStylusWritingResponseParamsForwardToCallback(
        FrameWidget.OnStartStylusWriting_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 2)) {
          return false;
        }
        FrameWidgetOnStartStylusWritingResponseParams response =
            FrameWidgetOnStartStylusWritingResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.focusedEditBounds, response.caretBounds);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FrameWidgetOnStartStylusWritingResponseParamsProxyToResponder
      implements FrameWidget.OnStartStylusWriting_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FrameWidgetOnStartStylusWritingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Rect focusedEditBounds, Rect caretBounds) {
      FrameWidgetOnStartStylusWritingResponseParams _response =
          new FrameWidgetOnStartStylusWritingResponseParams();
      _response.focusedEditBounds = focusedEditBounds;
      _response.caretBounds = caretBounds;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FrameWidgetSetBackgroundOpaqueParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean opaque;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetSetBackgroundOpaqueParams(int version) {
      super(16, version);
    }

    public FrameWidgetSetBackgroundOpaqueParams() {
      this(0);
    }

    public static FrameWidgetSetBackgroundOpaqueParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetSetBackgroundOpaqueParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetSetBackgroundOpaqueParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetSetBackgroundOpaqueParams result =
            new FrameWidgetSetBackgroundOpaqueParams(elementsOrVersion);
        result.opaque = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.opaque, 8, 0);
    }
  }

  static final class FrameWidgetSetTextDirectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int direction;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetSetTextDirectionParams(int version) {
      super(16, version);
    }

    public FrameWidgetSetTextDirectionParams() {
      this(0);
    }

    public static FrameWidgetSetTextDirectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetSetTextDirectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetSetTextDirectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetSetTextDirectionParams result =
            new FrameWidgetSetTextDirectionParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.direction = readInt;
        TextDirection.validate(readInt);
        result.direction = TextDirection.toKnownValue(result.direction);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.direction, 8);
    }
  }

  static final class FrameWidgetSetActiveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean active;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetSetActiveParams(int version) {
      super(16, version);
    }

    public FrameWidgetSetActiveParams() {
      this(0);
    }

    public static FrameWidgetSetActiveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetSetActiveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetSetActiveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetSetActiveParams result = new FrameWidgetSetActiveParams(elementsOrVersion);
        result.active = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.active, 8, 0);
    }
  }

  static final class FrameWidgetSetInheritedEffectiveTouchActionForSubFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int touchAction;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetSetInheritedEffectiveTouchActionForSubFrameParams(int version) {
      super(16, version);
    }

    public FrameWidgetSetInheritedEffectiveTouchActionForSubFrameParams() {
      this(0);
    }

    public static FrameWidgetSetInheritedEffectiveTouchActionForSubFrameParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetSetInheritedEffectiveTouchActionForSubFrameParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetSetInheritedEffectiveTouchActionForSubFrameParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetSetInheritedEffectiveTouchActionForSubFrameParams result =
            new FrameWidgetSetInheritedEffectiveTouchActionForSubFrameParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.touchAction = readInt;
        TouchAction.validate(readInt);
        result.touchAction = TouchAction.toKnownValue(result.touchAction);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.touchAction, 8);
    }
  }

  static final class FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean displayLocked;
    public boolean isThrottled;
    public boolean subtreeThrottled;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams(int version) {
      super(16, version);
    }

    public FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams() {
      this(0);
    }

    public static FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams result =
            new FrameWidgetUpdateRenderThrottlingStatusForSubFrameParams(elementsOrVersion);
        result.isThrottled = decoder0.readBoolean(8, 0);
        result.subtreeThrottled = decoder0.readBoolean(8, 1);
        result.displayLocked = decoder0.readBoolean(8, 2);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isThrottled, 8, 0);
      encoder0.encode(this.subtreeThrottled, 8, 1);
      encoder0.encode(this.displayLocked, 8, 2);
    }
  }

  static final class FrameWidgetSetIsInertForSubFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean inert;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetSetIsInertForSubFrameParams(int version) {
      super(16, version);
    }

    public FrameWidgetSetIsInertForSubFrameParams() {
      this(0);
    }

    public static FrameWidgetSetIsInertForSubFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetSetIsInertForSubFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetSetIsInertForSubFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetSetIsInertForSubFrameParams result =
            new FrameWidgetSetIsInertForSubFrameParams(elementsOrVersion);
        result.inert = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.inert, 8, 0);
    }
  }

  static final class FrameWidgetShowContextMenuParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Point location;
    public int sourceType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetShowContextMenuParams(int version) {
      super(24, version);
    }

    public FrameWidgetShowContextMenuParams() {
      this(0);
    }

    public static FrameWidgetShowContextMenuParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetShowContextMenuParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetShowContextMenuParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetShowContextMenuParams result =
            new FrameWidgetShowContextMenuParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.sourceType = readInt;
        MenuSourceType.validate(readInt);
        result.sourceType = MenuSourceType.toKnownValue(result.sourceType);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.location = Point.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sourceType, 8);
      encoder0.encode((Struct) this.location, 16, false);
    }
  }

  static final class FrameWidgetEnableDeviceEmulationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DeviceEmulationParams parameters;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetEnableDeviceEmulationParams(int version) {
      super(16, version);
    }

    public FrameWidgetEnableDeviceEmulationParams() {
      this(0);
    }

    public static FrameWidgetEnableDeviceEmulationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetEnableDeviceEmulationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetEnableDeviceEmulationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetEnableDeviceEmulationParams result =
            new FrameWidgetEnableDeviceEmulationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.parameters = DeviceEmulationParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.parameters, 8, false);
    }
  }

  static final class FrameWidgetDisableDeviceEmulationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetDisableDeviceEmulationParams(int version) {
      super(8, version);
    }

    public FrameWidgetDisableDeviceEmulationParams() {
      this(0);
    }

    public static FrameWidgetDisableDeviceEmulationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetDisableDeviceEmulationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetDisableDeviceEmulationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetDisableDeviceEmulationParams result =
            new FrameWidgetDisableDeviceEmulationParams(elementsOrVersion);
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

  static final class FrameWidgetBindWidgetCompositorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<WidgetCompositor> host;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetBindWidgetCompositorParams(int version) {
      super(16, version);
    }

    public FrameWidgetBindWidgetCompositorParams() {
      this(0);
    }

    public static FrameWidgetBindWidgetCompositorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetBindWidgetCompositorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetBindWidgetCompositorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetBindWidgetCompositorParams result =
            new FrameWidgetBindWidgetCompositorParams(elementsOrVersion);
        result.host = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.host, 8, false);
    }
  }

  static final class FrameWidgetBindInputTargetClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<InputTargetClient> host;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetBindInputTargetClientParams(int version) {
      super(16, version);
    }

    public FrameWidgetBindInputTargetClientParams() {
      this(0);
    }

    public static FrameWidgetBindInputTargetClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetBindInputTargetClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetBindInputTargetClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetBindInputTargetClientParams result =
            new FrameWidgetBindInputTargetClientParams(elementsOrVersion);
        result.host = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.host, 8, false);
    }
  }

  static final class FrameWidgetSetViewportIntersectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ViewportIntersectionState intersectionState;
    public VisualProperties visualProperties;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetSetViewportIntersectionParams(int version) {
      super(24, version);
    }

    public FrameWidgetSetViewportIntersectionParams() {
      this(0);
    }

    public static FrameWidgetSetViewportIntersectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetSetViewportIntersectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetSetViewportIntersectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetSetViewportIntersectionParams result =
            new FrameWidgetSetViewportIntersectionParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.intersectionState = ViewportIntersectionState.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.visualProperties = VisualProperties.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.intersectionState, 8, false);
      encoder0.encode((Struct) this.visualProperties, 16, true);
    }
  }
}
