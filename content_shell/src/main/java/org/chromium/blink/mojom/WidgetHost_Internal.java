package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.cc.mojom.RenderFrameMetadataObserver;
import org.chromium.cc.mojom.RenderFrameMetadataObserverClient;
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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.TextDirection;
import org.chromium.ui.mojom.Cursor;
import org.chromium.ui.mojom.TextInputState;
import org.chromium.viz.mojom.CompositorFrameSink;
import org.chromium.viz.mojom.CompositorFrameSinkClient;

class WidgetHost_Internal {
  private static final int CLEAR_KEYBOARD_TRIGGERED_TOOLTIP_ORDINAL = 3;
  private static final int CREATE_FRAME_SINK_ORDINAL = 6;
  public static final Interface.Manager<WidgetHost, WidgetHost.Proxy> MANAGER =
      new Interface.Manager<WidgetHost, WidgetHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.WidgetHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WidgetHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WidgetHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public WidgetHost[] buildArray(int size) {
          return new WidgetHost[size];
        }
      };
  private static final int REGISTER_RENDER_FRAME_METADATA_OBSERVER_ORDINAL = 7;
  private static final int SELECTION_BOUNDS_CHANGED_ORDINAL = 5;
  private static final int SET_CURSOR_ORDINAL = 0;
  private static final int TEXT_INPUT_STATE_CHANGED_ORDINAL = 4;
  private static final int UPDATE_TOOLTIP_FROM_KEYBOARD_ORDINAL = 2;
  private static final int UPDATE_TOOLTIP_UNDER_CURSOR_ORDINAL = 1;

  WidgetHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements WidgetHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setCursor(Cursor cursor) {
      WidgetHostSetCursorParams _message = new WidgetHostSetCursorParams();
      _message.cursor = cursor;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void updateTooltipUnderCursor(String16 tooltipText, int textDirectionHint) {
      WidgetHostUpdateTooltipUnderCursorParams _message =
          new WidgetHostUpdateTooltipUnderCursorParams();
      _message.tooltipText = tooltipText;
      _message.textDirectionHint = textDirectionHint;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void updateTooltipFromKeyboard(
        String16 tooltipText, int textDirectionHint, Rect bounds) {
      WidgetHostUpdateTooltipFromKeyboardParams _message =
          new WidgetHostUpdateTooltipFromKeyboardParams();
      _message.tooltipText = tooltipText;
      _message.textDirectionHint = textDirectionHint;
      _message.bounds = bounds;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void clearKeyboardTriggeredTooltip() {
      WidgetHostClearKeyboardTriggeredTooltipParams _message =
          new WidgetHostClearKeyboardTriggeredTooltipParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void textInputStateChanged(TextInputState state) {
      WidgetHostTextInputStateChangedParams _message = new WidgetHostTextInputStateChangedParams();
      _message.state = state;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void selectionBoundsChanged(
        Rect anchorRect,
        int anchorDir,
        Rect focusRect,
        int focusDir,
        Rect boundingBoxRect,
        boolean isAnchorFirst) {
      WidgetHostSelectionBoundsChangedParams _message =
          new WidgetHostSelectionBoundsChangedParams();
      _message.anchorRect = anchorRect;
      _message.anchorDir = anchorDir;
      _message.focusRect = focusRect;
      _message.focusDir = focusDir;
      _message.boundingBoxRect = boundingBoxRect;
      _message.isAnchorFirst = isAnchorFirst;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void createFrameSink(
        InterfaceRequest<CompositorFrameSink> compositorFrameSinkReceiver,
        CompositorFrameSinkClient compositorFrameSinkClient) {
      WidgetHostCreateFrameSinkParams _message = new WidgetHostCreateFrameSinkParams();
      _message.compositorFrameSinkReceiver = compositorFrameSinkReceiver;
      _message.compositorFrameSinkClient = compositorFrameSinkClient;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void registerRenderFrameMetadataObserver(
        InterfaceRequest<RenderFrameMetadataObserverClient>
            renderFrameMetadataObserverClientReceiver,
        RenderFrameMetadataObserver renderFrameMetadataObserver) {
      WidgetHostRegisterRenderFrameMetadataObserverParams _message =
          new WidgetHostRegisterRenderFrameMetadataObserverParams();
      _message.renderFrameMetadataObserverClientReceiver =
          renderFrameMetadataObserverClientReceiver;
      _message.renderFrameMetadataObserver = renderFrameMetadataObserver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }
  }

  public static final class Stub extends Interface.Stub<WidgetHost> {
    Stub(Core core, WidgetHost impl) {
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
                WidgetHost_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .setCursor(
                    WidgetHostSetCursorParams.deserialize(messageWithHeader.getPayload()).cursor);
            return true;
          case 1:
            WidgetHostUpdateTooltipUnderCursorParams data =
                WidgetHostUpdateTooltipUnderCursorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateTooltipUnderCursor(data.tooltipText, data.textDirectionHint);
            return true;
          case 2:
            WidgetHostUpdateTooltipFromKeyboardParams data2 =
                WidgetHostUpdateTooltipFromKeyboardParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .updateTooltipFromKeyboard(
                    data2.tooltipText, data2.textDirectionHint, data2.bounds);
            return true;
          case 3:
            WidgetHostClearKeyboardTriggeredTooltipParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().clearKeyboardTriggeredTooltip();
            return true;
          case 4:
            WidgetHostTextInputStateChangedParams data3 =
                WidgetHostTextInputStateChangedParams.deserialize(messageWithHeader.getPayload());
            getImpl().textInputStateChanged(data3.state);
            return true;
          case 5:
            WidgetHostSelectionBoundsChangedParams data4 =
                WidgetHostSelectionBoundsChangedParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .selectionBoundsChanged(
                    data4.anchorRect,
                    data4.anchorDir,
                    data4.focusRect,
                    data4.focusDir,
                    data4.boundingBoxRect,
                    data4.isAnchorFirst);
            return true;
          case 6:
            WidgetHostCreateFrameSinkParams data5 =
                WidgetHostCreateFrameSinkParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createFrameSink(
                    data5.compositorFrameSinkReceiver, data5.compositorFrameSinkClient);
            return true;
          case 7:
            WidgetHostRegisterRenderFrameMetadataObserverParams data6 =
                WidgetHostRegisterRenderFrameMetadataObserverParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .registerRenderFrameMetadataObserver(
                    data6.renderFrameMetadataObserverClientReceiver,
                    data6.renderFrameMetadataObserver);
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
                getCore(), WidgetHost_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WidgetHostSetCursorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Cursor cursor;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetHostSetCursorParams(int version) {
      super(16, version);
    }

    public WidgetHostSetCursorParams() {
      this(0);
    }

    public static WidgetHostSetCursorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetHostSetCursorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetHostSetCursorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetHostSetCursorParams result = new WidgetHostSetCursorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cursor = Cursor.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cursor, 8, false);
    }
  }

  static final class WidgetHostUpdateTooltipUnderCursorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int textDirectionHint;
    public String16 tooltipText;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetHostUpdateTooltipUnderCursorParams(int version) {
      super(24, version);
    }

    public WidgetHostUpdateTooltipUnderCursorParams() {
      this(0);
    }

    public static WidgetHostUpdateTooltipUnderCursorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetHostUpdateTooltipUnderCursorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetHostUpdateTooltipUnderCursorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetHostUpdateTooltipUnderCursorParams result =
            new WidgetHostUpdateTooltipUnderCursorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.tooltipText = String16.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.textDirectionHint = readInt;
        TextDirection.validate(readInt);
        result.textDirectionHint = TextDirection.toKnownValue(result.textDirectionHint);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.tooltipText, 8, false);
      encoder0.encode(this.textDirectionHint, 16);
    }
  }

  static final class WidgetHostUpdateTooltipFromKeyboardParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect bounds;
    public int textDirectionHint;
    public String16 tooltipText;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetHostUpdateTooltipFromKeyboardParams(int version) {
      super(32, version);
    }

    public WidgetHostUpdateTooltipFromKeyboardParams() {
      this(0);
    }

    public static WidgetHostUpdateTooltipFromKeyboardParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetHostUpdateTooltipFromKeyboardParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetHostUpdateTooltipFromKeyboardParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetHostUpdateTooltipFromKeyboardParams result =
            new WidgetHostUpdateTooltipFromKeyboardParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.tooltipText = String16.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.textDirectionHint = readInt;
        TextDirection.validate(readInt);
        result.textDirectionHint = TextDirection.toKnownValue(result.textDirectionHint);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.bounds = Rect.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.tooltipText, 8, false);
      encoder0.encode(this.textDirectionHint, 16);
      encoder0.encode((Struct) this.bounds, 24, false);
    }
  }

  static final class WidgetHostClearKeyboardTriggeredTooltipParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetHostClearKeyboardTriggeredTooltipParams(int version) {
      super(8, version);
    }

    public WidgetHostClearKeyboardTriggeredTooltipParams() {
      this(0);
    }

    public static WidgetHostClearKeyboardTriggeredTooltipParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetHostClearKeyboardTriggeredTooltipParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetHostClearKeyboardTriggeredTooltipParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetHostClearKeyboardTriggeredTooltipParams result =
            new WidgetHostClearKeyboardTriggeredTooltipParams(elementsOrVersion);
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

  static final class WidgetHostTextInputStateChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TextInputState state;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetHostTextInputStateChangedParams(int version) {
      super(16, version);
    }

    public WidgetHostTextInputStateChangedParams() {
      this(0);
    }

    public static WidgetHostTextInputStateChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetHostTextInputStateChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetHostTextInputStateChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetHostTextInputStateChangedParams result =
            new WidgetHostTextInputStateChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.state = TextInputState.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.state, 8, false);
    }
  }

  static final class WidgetHostSelectionBoundsChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public int anchorDir;
    public Rect anchorRect;
    public Rect boundingBoxRect;
    public int focusDir;
    public Rect focusRect;
    public boolean isAnchorFirst;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetHostSelectionBoundsChangedParams(int version) {
      super(48, version);
    }

    public WidgetHostSelectionBoundsChangedParams() {
      this(0);
    }

    public static WidgetHostSelectionBoundsChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetHostSelectionBoundsChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetHostSelectionBoundsChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetHostSelectionBoundsChangedParams result =
            new WidgetHostSelectionBoundsChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.anchorRect = Rect.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.anchorDir = readInt;
        TextDirection.validate(readInt);
        result.anchorDir = TextDirection.toKnownValue(result.anchorDir);
        int readInt2 = decoder0.readInt(20);
        result.focusDir = readInt2;
        TextDirection.validate(readInt2);
        result.focusDir = TextDirection.toKnownValue(result.focusDir);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.focusRect = Rect.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, false);
        result.boundingBoxRect = Rect.decode(decoder13);
        result.isAnchorFirst = decoder0.readBoolean(40, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.anchorRect, 8, false);
      encoder0.encode(this.anchorDir, 16);
      encoder0.encode(this.focusDir, 20);
      encoder0.encode((Struct) this.focusRect, 24, false);
      encoder0.encode((Struct) this.boundingBoxRect, 32, false);
      encoder0.encode(this.isAnchorFirst, 40, 0);
    }
  }

  static final class WidgetHostCreateFrameSinkParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public CompositorFrameSinkClient compositorFrameSinkClient;
    public InterfaceRequest<CompositorFrameSink> compositorFrameSinkReceiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetHostCreateFrameSinkParams(int version) {
      super(24, version);
    }

    public WidgetHostCreateFrameSinkParams() {
      this(0);
    }

    public static WidgetHostCreateFrameSinkParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetHostCreateFrameSinkParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetHostCreateFrameSinkParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetHostCreateFrameSinkParams result =
            new WidgetHostCreateFrameSinkParams(elementsOrVersion);
        result.compositorFrameSinkReceiver = decoder0.readInterfaceRequest(8, false);
        result.compositorFrameSinkClient =
            (CompositorFrameSinkClient)
                decoder0.readServiceInterface(12, false, CompositorFrameSinkClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.compositorFrameSinkReceiver, 8, false);
      encoder0.encode(this.compositorFrameSinkClient, 12, false, CompositorFrameSinkClient.MANAGER);
    }
  }

  static final class WidgetHostRegisterRenderFrameMetadataObserverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public RenderFrameMetadataObserver renderFrameMetadataObserver;
    public InterfaceRequest<RenderFrameMetadataObserverClient>
        renderFrameMetadataObserverClientReceiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetHostRegisterRenderFrameMetadataObserverParams(int version) {
      super(24, version);
    }

    public WidgetHostRegisterRenderFrameMetadataObserverParams() {
      this(0);
    }

    public static WidgetHostRegisterRenderFrameMetadataObserverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetHostRegisterRenderFrameMetadataObserverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetHostRegisterRenderFrameMetadataObserverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetHostRegisterRenderFrameMetadataObserverParams result =
            new WidgetHostRegisterRenderFrameMetadataObserverParams(elementsOrVersion);
        result.renderFrameMetadataObserverClientReceiver = decoder0.readInterfaceRequest(8, false);
        result.renderFrameMetadataObserver =
            (RenderFrameMetadataObserver)
                decoder0.readServiceInterface(12, false, RenderFrameMetadataObserver.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.renderFrameMetadataObserverClientReceiver, 8, false);
      encoder0.encode(
          this.renderFrameMetadataObserver, 12, false, RenderFrameMetadataObserver.MANAGER);
    }
  }
}
