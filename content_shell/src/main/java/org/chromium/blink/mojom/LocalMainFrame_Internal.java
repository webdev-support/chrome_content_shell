package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.cc.mojom.BrowserControlsState;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;
import org.chromium.network.mojom.CrossOriginOpenerPolicyReporterParams;

class LocalMainFrame_Internal {
  private static final int ANIMATE_DOUBLE_TAP_ZOOM_ORDINAL = 0;
  private static final int CLOSE_PAGE_ORDINAL = 2;
  private static final int ENABLE_PREFERRED_SIZE_CHANGED_MODE_ORDINAL = 5;
  private static final int GET_FULL_PAGE_SIZE_ORDINAL = 3;
  private static final int INSTALL_COOP_ACCESS_MONITOR_ORDINAL = 7;
  public static final Interface.Manager<LocalMainFrame, LocalMainFrame.Proxy> MANAGER =
      new Interface.Manager<LocalMainFrame, LocalMainFrame.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.LocalMainFrame";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public LocalMainFrame.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, LocalMainFrame impl) {
          return new Stub(core, impl);
        }

        @Override
        public LocalMainFrame[] buildArray(int size) {
          return new LocalMainFrame[size];
        }
      };
  private static final int SET_INITIAL_FOCUS_ORDINAL = 4;
  private static final int SET_SCALE_FACTOR_ORDINAL = 1;
  private static final int SET_V8_COMPILE_HINTS_ORDINAL = 9;
  private static final int UPDATE_BROWSER_CONTROLS_STATE_ORDINAL = 8;
  private static final int ZOOM_TO_FIND_IN_PAGE_RECT_ORDINAL = 6;

  LocalMainFrame_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements LocalMainFrame.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void animateDoubleTapZoom(Point point, Rect rect) {
      LocalMainFrameAnimateDoubleTapZoomParams _message =
          new LocalMainFrameAnimateDoubleTapZoomParams();
      _message.point = point;
      _message.rect = rect;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setScaleFactor(float scale) {
      LocalMainFrameSetScaleFactorParams _message = new LocalMainFrameSetScaleFactorParams();
      _message.scale = scale;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void closePage(ClosePage_Response callback) {
      LocalMainFrameClosePageParams _message = new LocalMainFrameClosePageParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new LocalMainFrameClosePageResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getFullPageSize(GetFullPageSize_Response callback) {
      LocalMainFrameGetFullPageSizeParams _message = new LocalMainFrameGetFullPageSizeParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new LocalMainFrameGetFullPageSizeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setInitialFocus(boolean reverse) {
      LocalMainFrameSetInitialFocusParams _message = new LocalMainFrameSetInitialFocusParams();
      _message.reverse = reverse;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void enablePreferredSizeChangedMode() {
      LocalMainFrameEnablePreferredSizeChangedModeParams _message =
          new LocalMainFrameEnablePreferredSizeChangedModeParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void zoomToFindInPageRect(Rect rectInRootFrame) {
      LocalMainFrameZoomToFindInPageRectParams _message =
          new LocalMainFrameZoomToFindInPageRectParams();
      _message.rectInRootFrame = rectInRootFrame;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void installCoopAccessMonitor(
        FrameToken accessedWindow,
        CrossOriginOpenerPolicyReporterParams coopReporterInfo,
        boolean isInSameVirtualCoopRelatedGroup) {
      LocalMainFrameInstallCoopAccessMonitorParams _message =
          new LocalMainFrameInstallCoopAccessMonitorParams();
      _message.accessedWindow = accessedWindow;
      _message.coopReporterInfo = coopReporterInfo;
      _message.isInSameVirtualCoopRelatedGroup = isInSameVirtualCoopRelatedGroup;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void updateBrowserControlsState(int constraints, int current, boolean animate) {
      LocalMainFrameUpdateBrowserControlsStateParams _message =
          new LocalMainFrameUpdateBrowserControlsStateParams();
      _message.constraints = constraints;
      _message.current = current;
      _message.animate = animate;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void setV8CompileHints(ReadOnlySharedMemoryRegion data) {
      LocalMainFrameSetV8CompileHintsParams _message = new LocalMainFrameSetV8CompileHintsParams();
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }
  }

  public static final class Stub extends Interface.Stub<LocalMainFrame> {
    Stub(Core core, LocalMainFrame impl) {
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
                LocalMainFrame_Internal.MANAGER, messageWithHeader);
          case -1:
          case 2:
          case 3:
          default:
            return false;
          case 0:
            LocalMainFrameAnimateDoubleTapZoomParams data =
                LocalMainFrameAnimateDoubleTapZoomParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().animateDoubleTapZoom(data.point, data.rect);
            return true;
          case 1:
            getImpl()
                .setScaleFactor(
                    LocalMainFrameSetScaleFactorParams.deserialize(messageWithHeader.getPayload())
                        .scale);
            return true;
          case 4:
            getImpl()
                .setInitialFocus(
                    LocalMainFrameSetInitialFocusParams.deserialize(messageWithHeader.getPayload())
                        .reverse);
            return true;
          case 5:
            LocalMainFrameEnablePreferredSizeChangedModeParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().enablePreferredSizeChangedMode();
            return true;
          case 6:
            getImpl()
                .zoomToFindInPageRect(
                    LocalMainFrameZoomToFindInPageRectParams.deserialize(
                            messageWithHeader.getPayload())
                        .rectInRootFrame);
            return true;
          case 7:
            LocalMainFrameInstallCoopAccessMonitorParams data2 =
                LocalMainFrameInstallCoopAccessMonitorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .installCoopAccessMonitor(
                    data2.accessedWindow,
                    data2.coopReporterInfo,
                    data2.isInSameVirtualCoopRelatedGroup);
            return true;
          case 8:
            LocalMainFrameUpdateBrowserControlsStateParams data3 =
                LocalMainFrameUpdateBrowserControlsStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateBrowserControlsState(data3.constraints, data3.current, data3.animate);
            return true;
          case 9:
            getImpl()
                .setV8CompileHints(
                    LocalMainFrameSetV8CompileHintsParams.deserialize(
                            messageWithHeader.getPayload())
                        .data);
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
                getCore(), LocalMainFrame_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          case 1:
          default:
            return false;
          case 2:
            LocalMainFrameClosePageParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .closePage(
                    new LocalMainFrameClosePageResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            LocalMainFrameGetFullPageSizeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getFullPageSize(
                    new LocalMainFrameGetFullPageSizeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class LocalMainFrameAnimateDoubleTapZoomParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Point point;
    public Rect rect;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameAnimateDoubleTapZoomParams(int version) {
      super(24, version);
    }

    public LocalMainFrameAnimateDoubleTapZoomParams() {
      this(0);
    }

    public static LocalMainFrameAnimateDoubleTapZoomParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameAnimateDoubleTapZoomParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameAnimateDoubleTapZoomParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameAnimateDoubleTapZoomParams result =
            new LocalMainFrameAnimateDoubleTapZoomParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.point = Point.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.rect = Rect.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.point, 8, false);
      encoder0.encode((Struct) this.rect, 16, false);
    }
  }

  static final class LocalMainFrameSetScaleFactorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public float scale;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameSetScaleFactorParams(int version) {
      super(16, version);
    }

    public LocalMainFrameSetScaleFactorParams() {
      this(0);
    }

    public static LocalMainFrameSetScaleFactorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameSetScaleFactorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameSetScaleFactorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameSetScaleFactorParams result =
            new LocalMainFrameSetScaleFactorParams(elementsOrVersion);
        result.scale = decoder0.readFloat(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.scale, 8);
    }
  }

  static final class LocalMainFrameClosePageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameClosePageParams(int version) {
      super(8, version);
    }

    public LocalMainFrameClosePageParams() {
      this(0);
    }

    public static LocalMainFrameClosePageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameClosePageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameClosePageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameClosePageParams result = new LocalMainFrameClosePageParams(elementsOrVersion);
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

  static final class LocalMainFrameClosePageResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameClosePageResponseParams(int version) {
      super(8, version);
    }

    public LocalMainFrameClosePageResponseParams() {
      this(0);
    }

    public static LocalMainFrameClosePageResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameClosePageResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameClosePageResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameClosePageResponseParams result =
            new LocalMainFrameClosePageResponseParams(elementsOrVersion);
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

  static class LocalMainFrameClosePageResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalMainFrame.ClosePage_Response mCallback;

    LocalMainFrameClosePageResponseParamsForwardToCallback(
        LocalMainFrame.ClosePage_Response callback) {
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

  static class LocalMainFrameClosePageResponseParamsProxyToResponder
      implements LocalMainFrame.ClosePage_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalMainFrameClosePageResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      LocalMainFrameClosePageResponseParams _response = new LocalMainFrameClosePageResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalMainFrameGetFullPageSizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameGetFullPageSizeParams(int version) {
      super(8, version);
    }

    public LocalMainFrameGetFullPageSizeParams() {
      this(0);
    }

    public static LocalMainFrameGetFullPageSizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameGetFullPageSizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameGetFullPageSizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameGetFullPageSizeParams result =
            new LocalMainFrameGetFullPageSizeParams(elementsOrVersion);
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

  static final class LocalMainFrameGetFullPageSizeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Size fullPageSize;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameGetFullPageSizeResponseParams(int version) {
      super(16, version);
    }

    public LocalMainFrameGetFullPageSizeResponseParams() {
      this(0);
    }

    public static LocalMainFrameGetFullPageSizeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameGetFullPageSizeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameGetFullPageSizeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameGetFullPageSizeResponseParams result =
            new LocalMainFrameGetFullPageSizeResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.fullPageSize = Size.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.fullPageSize, 8, false);
    }
  }

  static class LocalMainFrameGetFullPageSizeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalMainFrame.GetFullPageSize_Response mCallback;

    LocalMainFrameGetFullPageSizeResponseParamsForwardToCallback(
        LocalMainFrame.GetFullPageSize_Response callback) {
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
        LocalMainFrameGetFullPageSizeResponseParams response =
            LocalMainFrameGetFullPageSizeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.fullPageSize);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalMainFrameGetFullPageSizeResponseParamsProxyToResponder
      implements LocalMainFrame.GetFullPageSize_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalMainFrameGetFullPageSizeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Size fullPageSize) {
      LocalMainFrameGetFullPageSizeResponseParams _response =
          new LocalMainFrameGetFullPageSizeResponseParams();
      _response.fullPageSize = fullPageSize;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalMainFrameSetInitialFocusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean reverse;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameSetInitialFocusParams(int version) {
      super(16, version);
    }

    public LocalMainFrameSetInitialFocusParams() {
      this(0);
    }

    public static LocalMainFrameSetInitialFocusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameSetInitialFocusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameSetInitialFocusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameSetInitialFocusParams result =
            new LocalMainFrameSetInitialFocusParams(elementsOrVersion);
        result.reverse = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.reverse, 8, 0);
    }
  }

  static final class LocalMainFrameEnablePreferredSizeChangedModeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameEnablePreferredSizeChangedModeParams(int version) {
      super(8, version);
    }

    public LocalMainFrameEnablePreferredSizeChangedModeParams() {
      this(0);
    }

    public static LocalMainFrameEnablePreferredSizeChangedModeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameEnablePreferredSizeChangedModeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameEnablePreferredSizeChangedModeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameEnablePreferredSizeChangedModeParams result =
            new LocalMainFrameEnablePreferredSizeChangedModeParams(elementsOrVersion);
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

  static final class LocalMainFrameZoomToFindInPageRectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect rectInRootFrame;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameZoomToFindInPageRectParams(int version) {
      super(16, version);
    }

    public LocalMainFrameZoomToFindInPageRectParams() {
      this(0);
    }

    public static LocalMainFrameZoomToFindInPageRectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameZoomToFindInPageRectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameZoomToFindInPageRectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameZoomToFindInPageRectParams result =
            new LocalMainFrameZoomToFindInPageRectParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.rectInRootFrame = Rect.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.rectInRootFrame, 8, false);
    }
  }

  static final class LocalMainFrameInstallCoopAccessMonitorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public FrameToken accessedWindow;
    public CrossOriginOpenerPolicyReporterParams coopReporterInfo;
    public boolean isInSameVirtualCoopRelatedGroup;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameInstallCoopAccessMonitorParams(int version) {
      super(40, version);
    }

    public LocalMainFrameInstallCoopAccessMonitorParams() {
      this(0);
    }

    public static LocalMainFrameInstallCoopAccessMonitorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameInstallCoopAccessMonitorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameInstallCoopAccessMonitorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameInstallCoopAccessMonitorParams result =
            new LocalMainFrameInstallCoopAccessMonitorParams(elementsOrVersion);
        result.accessedWindow = FrameToken.decode(decoder0, 8);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.coopReporterInfo = CrossOriginOpenerPolicyReporterParams.decode(decoder1);
        result.isInSameVirtualCoopRelatedGroup = decoder0.readBoolean(32, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.accessedWindow, 8, false);
      encoder0.encode((Struct) this.coopReporterInfo, 24, false);
      encoder0.encode(this.isInSameVirtualCoopRelatedGroup, 32, 0);
    }
  }

  static final class LocalMainFrameUpdateBrowserControlsStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean animate;
    public int constraints;
    public int current;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameUpdateBrowserControlsStateParams(int version) {
      super(24, version);
    }

    public LocalMainFrameUpdateBrowserControlsStateParams() {
      this(0);
    }

    public static LocalMainFrameUpdateBrowserControlsStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameUpdateBrowserControlsStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameUpdateBrowserControlsStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameUpdateBrowserControlsStateParams result =
            new LocalMainFrameUpdateBrowserControlsStateParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.constraints = readInt;
        BrowserControlsState.validate(readInt);
        result.constraints = BrowserControlsState.toKnownValue(result.constraints);
        int readInt2 = decoder0.readInt(12);
        result.current = readInt2;
        BrowserControlsState.validate(readInt2);
        result.current = BrowserControlsState.toKnownValue(result.current);
        result.animate = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.constraints, 8);
      encoder0.encode(this.current, 12);
      encoder0.encode(this.animate, 16, 0);
    }
  }

  static final class LocalMainFrameSetV8CompileHintsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ReadOnlySharedMemoryRegion data;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameSetV8CompileHintsParams(int version) {
      super(16, version);
    }

    public LocalMainFrameSetV8CompileHintsParams() {
      this(0);
    }

    public static LocalMainFrameSetV8CompileHintsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameSetV8CompileHintsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameSetV8CompileHintsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameSetV8CompileHintsParams result =
            new LocalMainFrameSetV8CompileHintsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.data = ReadOnlySharedMemoryRegion.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.data, 8, false);
    }
  }
}
