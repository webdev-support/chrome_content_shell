package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.cc.mojom.TouchAction;
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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.UnguessableToken;

class RemoteFrameHost_Internal {
  private static final int ADVANCE_FOCUS_ORDINAL = 8;
  private static final int CAPTURE_PAINT_PREVIEW_OF_CROSS_PROCESS_SUBFRAME_ORDINAL = 5;
  private static final int CHECK_COMPLETED_ORDINAL = 4;
  private static final int DETACH_ORDINAL = 11;
  private static final int DID_CHANGE_OPENER_ORDINAL = 7;
  private static final int DID_FOCUS_FRAME_ORDINAL = 3;
  public static final Interface.Manager<RemoteFrameHost, RemoteFrameHost.Proxy> MANAGER =
      new Interface.Manager<RemoteFrameHost, RemoteFrameHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.RemoteFrameHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public RemoteFrameHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, RemoteFrameHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public RemoteFrameHost[] buildArray(int size) {
          return new RemoteFrameHost[size];
        }
      };
  private static final int OPEN_URL_ORDINAL = 14;
  private static final int PRINT_CROSS_PROCESS_SUBFRAME_ORDINAL = 10;
  private static final int ROUTE_MESSAGE_EVENT_ORDINAL = 9;
  private static final int SET_INHERITED_EFFECTIVE_TOUCH_ACTION_ORDINAL = 0;
  private static final int SET_IS_INERT_ORDINAL = 6;
  private static final int SYNCHRONIZE_VISUAL_PROPERTIES_ORDINAL = 13;
  private static final int UPDATE_RENDER_THROTTLING_STATUS_ORDINAL = 1;
  private static final int UPDATE_VIEWPORT_INTERSECTION_ORDINAL = 12;
  private static final int VISIBILITY_CHANGED_ORDINAL = 2;

  RemoteFrameHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements RemoteFrameHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setInheritedEffectiveTouchAction(int touchAction) {
      RemoteFrameHostSetInheritedEffectiveTouchActionParams _message =
          new RemoteFrameHostSetInheritedEffectiveTouchActionParams();
      _message.touchAction = touchAction;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void updateRenderThrottlingStatus(
        boolean isThrottled, boolean subtreeThrottled, boolean displayLocked) {
      RemoteFrameHostUpdateRenderThrottlingStatusParams _message =
          new RemoteFrameHostUpdateRenderThrottlingStatusParams();
      _message.isThrottled = isThrottled;
      _message.subtreeThrottled = subtreeThrottled;
      _message.displayLocked = displayLocked;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void visibilityChanged(int visibility) {
      RemoteFrameHostVisibilityChangedParams _message =
          new RemoteFrameHostVisibilityChangedParams();
      _message.visibility = visibility;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void didFocusFrame() {
      RemoteFrameHostDidFocusFrameParams _message = new RemoteFrameHostDidFocusFrameParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void checkCompleted() {
      RemoteFrameHostCheckCompletedParams _message = new RemoteFrameHostCheckCompletedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void capturePaintPreviewOfCrossProcessSubframe(Rect clipRect, UnguessableToken guid) {
      RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams _message =
          new RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams();
      _message.clipRect = clipRect;
      _message.guid = guid;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void setIsInert(boolean inert) {
      RemoteFrameHostSetIsInertParams _message = new RemoteFrameHostSetIsInertParams();
      _message.inert = inert;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void didChangeOpener(LocalFrameToken openerFrame) {
      RemoteFrameHostDidChangeOpenerParams _message = new RemoteFrameHostDidChangeOpenerParams();
      _message.openerFrame = openerFrame;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void advanceFocus(int focusType, LocalFrameToken sourceFrameToken) {
      RemoteFrameHostAdvanceFocusParams _message = new RemoteFrameHostAdvanceFocusParams();
      _message.focusType = focusType;
      _message.sourceFrameToken = sourceFrameToken;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void routeMessageEvent(
        LocalFrameToken sourceFrameToken,
        String16 sourceOrigin,
        String16 targetOrigin,
        TransferableMessage message) {
      RemoteFrameHostRouteMessageEventParams _message =
          new RemoteFrameHostRouteMessageEventParams();
      _message.sourceFrameToken = sourceFrameToken;
      _message.sourceOrigin = sourceOrigin;
      _message.targetOrigin = targetOrigin;
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void printCrossProcessSubframe(Rect frameContentRect, int documentCookie) {
      RemoteFrameHostPrintCrossProcessSubframeParams _message =
          new RemoteFrameHostPrintCrossProcessSubframeParams();
      _message.frameContentRect = frameContentRect;
      _message.documentCookie = documentCookie;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void detach() {
      RemoteFrameHostDetachParams _message = new RemoteFrameHostDetachParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }

    @Override
    public void updateViewportIntersection(
        ViewportIntersectionState intersectionState, FrameVisualProperties visualProperties) {
      RemoteFrameHostUpdateViewportIntersectionParams _message =
          new RemoteFrameHostUpdateViewportIntersectionParams();
      _message.intersectionState = intersectionState;
      _message.visualProperties = visualProperties;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }

    @Override
    public void synchronizeVisualProperties(FrameVisualProperties properties) {
      RemoteFrameHostSynchronizeVisualPropertiesParams _message =
          new RemoteFrameHostSynchronizeVisualPropertiesParams();
      _message.properties = properties;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
    }

    @Override
    public void openUrl(OpenUrlParams params) {
      RemoteFrameHostOpenUrlParams _message = new RemoteFrameHostOpenUrlParams();
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14)));
    }
  }

  public static final class Stub extends Interface.Stub<RemoteFrameHost> {
    Stub(Core core, RemoteFrameHost impl) {
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
                RemoteFrameHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .setInheritedEffectiveTouchAction(
                    RemoteFrameHostSetInheritedEffectiveTouchActionParams.deserialize(
                            messageWithHeader.getPayload())
                        .touchAction);
            return true;
          case 1:
            RemoteFrameHostUpdateRenderThrottlingStatusParams data =
                RemoteFrameHostUpdateRenderThrottlingStatusParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .updateRenderThrottlingStatus(
                    data.isThrottled, data.subtreeThrottled, data.displayLocked);
            return true;
          case 2:
            RemoteFrameHostVisibilityChangedParams data2 =
                RemoteFrameHostVisibilityChangedParams.deserialize(messageWithHeader.getPayload());
            getImpl().visibilityChanged(data2.visibility);
            return true;
          case 3:
            RemoteFrameHostDidFocusFrameParams.deserialize(messageWithHeader.getPayload());
            getImpl().didFocusFrame();
            return true;
          case 4:
            RemoteFrameHostCheckCompletedParams.deserialize(messageWithHeader.getPayload());
            getImpl().checkCompleted();
            return true;
          case 5:
            RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams data3 =
                RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().capturePaintPreviewOfCrossProcessSubframe(data3.clipRect, data3.guid);
            return true;
          case 6:
            RemoteFrameHostSetIsInertParams data4 =
                RemoteFrameHostSetIsInertParams.deserialize(messageWithHeader.getPayload());
            getImpl().setIsInert(data4.inert);
            return true;
          case 7:
            RemoteFrameHostDidChangeOpenerParams data5 =
                RemoteFrameHostDidChangeOpenerParams.deserialize(messageWithHeader.getPayload());
            getImpl().didChangeOpener(data5.openerFrame);
            return true;
          case 8:
            RemoteFrameHostAdvanceFocusParams data6 =
                RemoteFrameHostAdvanceFocusParams.deserialize(messageWithHeader.getPayload());
            getImpl().advanceFocus(data6.focusType, data6.sourceFrameToken);
            return true;
          case 9:
            RemoteFrameHostRouteMessageEventParams data7 =
                RemoteFrameHostRouteMessageEventParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .routeMessageEvent(
                    data7.sourceFrameToken, data7.sourceOrigin, data7.targetOrigin, data7.message);
            return true;
          case 10:
            RemoteFrameHostPrintCrossProcessSubframeParams data8 =
                RemoteFrameHostPrintCrossProcessSubframeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().printCrossProcessSubframe(data8.frameContentRect, data8.documentCookie);
            return true;
          case 11:
            RemoteFrameHostDetachParams.deserialize(messageWithHeader.getPayload());
            getImpl().detach();
            return true;
          case 12:
            RemoteFrameHostUpdateViewportIntersectionParams data9 =
                RemoteFrameHostUpdateViewportIntersectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateViewportIntersection(data9.intersectionState, data9.visualProperties);
            return true;
          case 13:
            RemoteFrameHostSynchronizeVisualPropertiesParams data10 =
                RemoteFrameHostSynchronizeVisualPropertiesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().synchronizeVisualProperties(data10.properties);
            return true;
          case 14:
            RemoteFrameHostOpenUrlParams data11 =
                RemoteFrameHostOpenUrlParams.deserialize(messageWithHeader.getPayload());
            getImpl().openUrl(data11.params);
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
                getCore(), RemoteFrameHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class RemoteFrameHostSetInheritedEffectiveTouchActionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int touchAction;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostSetInheritedEffectiveTouchActionParams(int version) {
      super(16, version);
    }

    public RemoteFrameHostSetInheritedEffectiveTouchActionParams() {
      this(0);
    }

    public static RemoteFrameHostSetInheritedEffectiveTouchActionParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostSetInheritedEffectiveTouchActionParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostSetInheritedEffectiveTouchActionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostSetInheritedEffectiveTouchActionParams result =
            new RemoteFrameHostSetInheritedEffectiveTouchActionParams(elementsOrVersion);
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

  static final class RemoteFrameHostUpdateRenderThrottlingStatusParams extends Struct {
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

    private RemoteFrameHostUpdateRenderThrottlingStatusParams(int version) {
      super(16, version);
    }

    public RemoteFrameHostUpdateRenderThrottlingStatusParams() {
      this(0);
    }

    public static RemoteFrameHostUpdateRenderThrottlingStatusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostUpdateRenderThrottlingStatusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostUpdateRenderThrottlingStatusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostUpdateRenderThrottlingStatusParams result =
            new RemoteFrameHostUpdateRenderThrottlingStatusParams(elementsOrVersion);
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

  static final class RemoteFrameHostVisibilityChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int visibility;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostVisibilityChangedParams(int version) {
      super(16, version);
    }

    public RemoteFrameHostVisibilityChangedParams() {
      this(0);
    }

    public static RemoteFrameHostVisibilityChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostVisibilityChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostVisibilityChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostVisibilityChangedParams result =
            new RemoteFrameHostVisibilityChangedParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.visibility = readInt;
        FrameVisibility.validate(readInt);
        result.visibility = FrameVisibility.toKnownValue(result.visibility);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.visibility, 8);
    }
  }

  static final class RemoteFrameHostDidFocusFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostDidFocusFrameParams(int version) {
      super(8, version);
    }

    public RemoteFrameHostDidFocusFrameParams() {
      this(0);
    }

    public static RemoteFrameHostDidFocusFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostDidFocusFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostDidFocusFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostDidFocusFrameParams result =
            new RemoteFrameHostDidFocusFrameParams(elementsOrVersion);
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

  static final class RemoteFrameHostCheckCompletedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostCheckCompletedParams(int version) {
      super(8, version);
    }

    public RemoteFrameHostCheckCompletedParams() {
      this(0);
    }

    public static RemoteFrameHostCheckCompletedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostCheckCompletedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostCheckCompletedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostCheckCompletedParams result =
            new RemoteFrameHostCheckCompletedParams(elementsOrVersion);
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

  static final class RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect clipRect;
    public UnguessableToken guid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams(int version) {
      super(24, version);
    }

    public RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams() {
      this(0);
    }

    public static RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams result =
            new RemoteFrameHostCapturePaintPreviewOfCrossProcessSubframeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.clipRect = Rect.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.guid = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.clipRect, 8, false);
      encoder0.encode((Struct) this.guid, 16, false);
    }
  }

  static final class RemoteFrameHostSetIsInertParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean inert;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostSetIsInertParams(int version) {
      super(16, version);
    }

    public RemoteFrameHostSetIsInertParams() {
      this(0);
    }

    public static RemoteFrameHostSetIsInertParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostSetIsInertParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostSetIsInertParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostSetIsInertParams result =
            new RemoteFrameHostSetIsInertParams(elementsOrVersion);
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

  static final class RemoteFrameHostDidChangeOpenerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public LocalFrameToken openerFrame;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostDidChangeOpenerParams(int version) {
      super(16, version);
    }

    public RemoteFrameHostDidChangeOpenerParams() {
      this(0);
    }

    public static RemoteFrameHostDidChangeOpenerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostDidChangeOpenerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostDidChangeOpenerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostDidChangeOpenerParams result =
            new RemoteFrameHostDidChangeOpenerParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.openerFrame = LocalFrameToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.openerFrame, 8, true);
    }
  }

  static final class RemoteFrameHostAdvanceFocusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int focusType;
    public LocalFrameToken sourceFrameToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostAdvanceFocusParams(int version) {
      super(24, version);
    }

    public RemoteFrameHostAdvanceFocusParams() {
      this(0);
    }

    public static RemoteFrameHostAdvanceFocusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostAdvanceFocusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostAdvanceFocusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostAdvanceFocusParams result =
            new RemoteFrameHostAdvanceFocusParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.focusType = readInt;
        FocusType.validate(readInt);
        result.focusType = FocusType.toKnownValue(result.focusType);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.sourceFrameToken = LocalFrameToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.focusType, 8);
      encoder0.encode((Struct) this.sourceFrameToken, 16, false);
    }
  }

  static final class RemoteFrameHostRouteMessageEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public TransferableMessage message;
    public LocalFrameToken sourceFrameToken;
    public String16 sourceOrigin;
    public String16 targetOrigin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostRouteMessageEventParams(int version) {
      super(40, version);
    }

    public RemoteFrameHostRouteMessageEventParams() {
      this(0);
    }

    public static RemoteFrameHostRouteMessageEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostRouteMessageEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostRouteMessageEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostRouteMessageEventParams result =
            new RemoteFrameHostRouteMessageEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.sourceFrameToken = LocalFrameToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.sourceOrigin = String16.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.targetOrigin = String16.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(32, false);
        result.message = TransferableMessage.decode(decoder14);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sourceFrameToken, 8, true);
      encoder0.encode((Struct) this.sourceOrigin, 16, false);
      encoder0.encode((Struct) this.targetOrigin, 24, false);
      encoder0.encode((Struct) this.message, 32, false);
    }
  }

  static final class RemoteFrameHostPrintCrossProcessSubframeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int documentCookie;
    public Rect frameContentRect;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostPrintCrossProcessSubframeParams(int version) {
      super(24, version);
    }

    public RemoteFrameHostPrintCrossProcessSubframeParams() {
      this(0);
    }

    public static RemoteFrameHostPrintCrossProcessSubframeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostPrintCrossProcessSubframeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostPrintCrossProcessSubframeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostPrintCrossProcessSubframeParams result =
            new RemoteFrameHostPrintCrossProcessSubframeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.frameContentRect = Rect.decode(decoder1);
        result.documentCookie = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.frameContentRect, 8, false);
      encoder0.encode(this.documentCookie, 16);
    }
  }

  static final class RemoteFrameHostDetachParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostDetachParams(int version) {
      super(8, version);
    }

    public RemoteFrameHostDetachParams() {
      this(0);
    }

    public static RemoteFrameHostDetachParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostDetachParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostDetachParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostDetachParams result = new RemoteFrameHostDetachParams(elementsOrVersion);
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

  static final class RemoteFrameHostUpdateViewportIntersectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ViewportIntersectionState intersectionState;
    public FrameVisualProperties visualProperties;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostUpdateViewportIntersectionParams(int version) {
      super(24, version);
    }

    public RemoteFrameHostUpdateViewportIntersectionParams() {
      this(0);
    }

    public static RemoteFrameHostUpdateViewportIntersectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostUpdateViewportIntersectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostUpdateViewportIntersectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostUpdateViewportIntersectionParams result =
            new RemoteFrameHostUpdateViewportIntersectionParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.intersectionState = ViewportIntersectionState.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, true);
        result.visualProperties = FrameVisualProperties.decode(decoder12);
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

  static final class RemoteFrameHostSynchronizeVisualPropertiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FrameVisualProperties properties;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostSynchronizeVisualPropertiesParams(int version) {
      super(16, version);
    }

    public RemoteFrameHostSynchronizeVisualPropertiesParams() {
      this(0);
    }

    public static RemoteFrameHostSynchronizeVisualPropertiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostSynchronizeVisualPropertiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostSynchronizeVisualPropertiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostSynchronizeVisualPropertiesParams result =
            new RemoteFrameHostSynchronizeVisualPropertiesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.properties = FrameVisualProperties.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.properties, 8, false);
    }
  }

  static final class RemoteFrameHostOpenUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public OpenUrlParams params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteFrameHostOpenUrlParams(int version) {
      super(16, version);
    }

    public RemoteFrameHostOpenUrlParams() {
      this(0);
    }

    public static RemoteFrameHostOpenUrlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteFrameHostOpenUrlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteFrameHostOpenUrlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteFrameHostOpenUrlParams result = new RemoteFrameHostOpenUrlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = OpenUrlParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.params, 8, false);
    }
  }
}
