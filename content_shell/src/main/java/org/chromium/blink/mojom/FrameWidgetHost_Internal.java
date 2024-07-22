package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Vector2dF;
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

class FrameWidgetHost_Internal {
  private static final int ANIMATE_DOUBLE_TAP_ZOOM_IN_MAIN_FRAME_ORDINAL = 0;
  private static final int AUTOSCROLL_END_ORDINAL = 6;
  private static final int AUTOSCROLL_FLING_ORDINAL = 5;
  private static final int AUTOSCROLL_START_ORDINAL = 4;
  private static final int INTRINSIC_SIZING_INFO_CHANGED_ORDINAL = 3;
  public static final Interface.Manager<FrameWidgetHost, FrameWidgetHost.Proxy> MANAGER =
      new Interface.Manager<FrameWidgetHost, FrameWidgetHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.FrameWidgetHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FrameWidgetHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FrameWidgetHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public FrameWidgetHost[] buildArray(int size) {
          return new FrameWidgetHost[size];
        }
      };
  private static final int SET_HAS_TOUCH_EVENT_CONSUMERS_ORDINAL = 2;
  private static final int ZOOM_TO_FIND_IN_PAGE_RECT_IN_MAIN_FRAME_ORDINAL = 1;

  FrameWidgetHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements FrameWidgetHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void animateDoubleTapZoomInMainFrame(Point tapPoint, Rect rectToZoom) {
      FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams _message =
          new FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams();
      _message.tapPoint = tapPoint;
      _message.rectToZoom = rectToZoom;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void zoomToFindInPageRectInMainFrame(Rect rectToZoom) {
      FrameWidgetHostZoomToFindInPageRectInMainFrameParams _message =
          new FrameWidgetHostZoomToFindInPageRectInMainFrameParams();
      _message.rectToZoom = rectToZoom;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setHasTouchEventConsumers(TouchEventConsumers touchEventConsumers) {
      FrameWidgetHostSetHasTouchEventConsumersParams _message =
          new FrameWidgetHostSetHasTouchEventConsumersParams();
      _message.touchEventConsumers = touchEventConsumers;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void intrinsicSizingInfoChanged(IntrinsicSizingInfo sizingInfo) {
      FrameWidgetHostIntrinsicSizingInfoChangedParams _message =
          new FrameWidgetHostIntrinsicSizingInfoChangedParams();
      _message.sizingInfo = sizingInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void autoscrollStart(PointF position) {
      FrameWidgetHostAutoscrollStartParams _message = new FrameWidgetHostAutoscrollStartParams();
      _message.position = position;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void autoscrollFling(Vector2dF velocity) {
      FrameWidgetHostAutoscrollFlingParams _message = new FrameWidgetHostAutoscrollFlingParams();
      _message.velocity = velocity;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void autoscrollEnd() {
      FrameWidgetHostAutoscrollEndParams _message = new FrameWidgetHostAutoscrollEndParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }
  }

  public static final class Stub extends Interface.Stub<FrameWidgetHost> {
    Stub(Core core, FrameWidgetHost impl) {
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
                FrameWidgetHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams data =
                FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().animateDoubleTapZoomInMainFrame(data.tapPoint, data.rectToZoom);
            return true;
          case 1:
            getImpl()
                .zoomToFindInPageRectInMainFrame(
                    FrameWidgetHostZoomToFindInPageRectInMainFrameParams.deserialize(
                            messageWithHeader.getPayload())
                        .rectToZoom);
            return true;
          case 2:
            getImpl()
                .setHasTouchEventConsumers(
                    FrameWidgetHostSetHasTouchEventConsumersParams.deserialize(
                            messageWithHeader.getPayload())
                        .touchEventConsumers);
            return true;
          case 3:
            getImpl()
                .intrinsicSizingInfoChanged(
                    FrameWidgetHostIntrinsicSizingInfoChangedParams.deserialize(
                            messageWithHeader.getPayload())
                        .sizingInfo);
            return true;
          case 4:
            getImpl()
                .autoscrollStart(
                    FrameWidgetHostAutoscrollStartParams.deserialize(messageWithHeader.getPayload())
                        .position);
            return true;
          case 5:
            getImpl()
                .autoscrollFling(
                    FrameWidgetHostAutoscrollFlingParams.deserialize(messageWithHeader.getPayload())
                        .velocity);
            return true;
          case 6:
            FrameWidgetHostAutoscrollEndParams.deserialize(messageWithHeader.getPayload());
            getImpl().autoscrollEnd();
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
                getCore(), FrameWidgetHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect rectToZoom;
    public Point tapPoint;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams(int version) {
      super(24, version);
    }

    public FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams() {
      this(0);
    }

    public static FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams result =
            new FrameWidgetHostAnimateDoubleTapZoomInMainFrameParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.tapPoint = Point.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.rectToZoom = Rect.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.tapPoint, 8, false);
      encoder0.encode((Struct) this.rectToZoom, 16, false);
    }
  }

  static final class FrameWidgetHostZoomToFindInPageRectInMainFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect rectToZoom;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetHostZoomToFindInPageRectInMainFrameParams(int version) {
      super(16, version);
    }

    public FrameWidgetHostZoomToFindInPageRectInMainFrameParams() {
      this(0);
    }

    public static FrameWidgetHostZoomToFindInPageRectInMainFrameParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetHostZoomToFindInPageRectInMainFrameParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetHostZoomToFindInPageRectInMainFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetHostZoomToFindInPageRectInMainFrameParams result =
            new FrameWidgetHostZoomToFindInPageRectInMainFrameParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.rectToZoom = Rect.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.rectToZoom, 8, false);
    }
  }

  static final class FrameWidgetHostSetHasTouchEventConsumersParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TouchEventConsumers touchEventConsumers;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetHostSetHasTouchEventConsumersParams(int version) {
      super(16, version);
    }

    public FrameWidgetHostSetHasTouchEventConsumersParams() {
      this(0);
    }

    public static FrameWidgetHostSetHasTouchEventConsumersParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetHostSetHasTouchEventConsumersParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetHostSetHasTouchEventConsumersParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetHostSetHasTouchEventConsumersParams result =
            new FrameWidgetHostSetHasTouchEventConsumersParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.touchEventConsumers = TouchEventConsumers.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.touchEventConsumers, 8, false);
    }
  }

  static final class FrameWidgetHostIntrinsicSizingInfoChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public IntrinsicSizingInfo sizingInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetHostIntrinsicSizingInfoChangedParams(int version) {
      super(16, version);
    }

    public FrameWidgetHostIntrinsicSizingInfoChangedParams() {
      this(0);
    }

    public static FrameWidgetHostIntrinsicSizingInfoChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetHostIntrinsicSizingInfoChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetHostIntrinsicSizingInfoChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetHostIntrinsicSizingInfoChangedParams result =
            new FrameWidgetHostIntrinsicSizingInfoChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.sizingInfo = IntrinsicSizingInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sizingInfo, 8, false);
    }
  }

  static final class FrameWidgetHostAutoscrollStartParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PointF position;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetHostAutoscrollStartParams(int version) {
      super(16, version);
    }

    public FrameWidgetHostAutoscrollStartParams() {
      this(0);
    }

    public static FrameWidgetHostAutoscrollStartParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetHostAutoscrollStartParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetHostAutoscrollStartParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetHostAutoscrollStartParams result =
            new FrameWidgetHostAutoscrollStartParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.position = PointF.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.position, 8, false);
    }
  }

  static final class FrameWidgetHostAutoscrollFlingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Vector2dF velocity;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetHostAutoscrollFlingParams(int version) {
      super(16, version);
    }

    public FrameWidgetHostAutoscrollFlingParams() {
      this(0);
    }

    public static FrameWidgetHostAutoscrollFlingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetHostAutoscrollFlingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetHostAutoscrollFlingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetHostAutoscrollFlingParams result =
            new FrameWidgetHostAutoscrollFlingParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.velocity = Vector2dF.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.velocity, 8, false);
    }
  }

  static final class FrameWidgetHostAutoscrollEndParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FrameWidgetHostAutoscrollEndParams(int version) {
      super(8, version);
    }

    public FrameWidgetHostAutoscrollEndParams() {
      this(0);
    }

    public static FrameWidgetHostAutoscrollEndParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FrameWidgetHostAutoscrollEndParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FrameWidgetHostAutoscrollEndParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FrameWidgetHostAutoscrollEndParams result =
            new FrameWidgetHostAutoscrollEndParams(elementsOrVersion);
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
