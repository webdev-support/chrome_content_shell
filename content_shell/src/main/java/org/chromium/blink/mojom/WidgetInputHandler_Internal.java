package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.cc.mojom.BrowserControlsState;
import org.chromium.gfx.mojom.Range;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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
import org.chromium.mojo_base.mojom.String16;
import org.chromium.ui.mojom.ImeTextSpan;
import org.chromium.ui.mojom.LatencyInfo;

class WidgetInputHandler_Internal {
  private static final int ATTACH_SYNCHRONOUS_COMPOSITOR_ORDINAL = 12;
  private static final int CURSOR_VISIBILITY_CHANGED_ORDINAL = 3;
  private static final int DISPATCH_EVENT_ORDINAL = 9;
  private static final int DISPATCH_NON_BLOCKING_EVENT_ORDINAL = 10;
  private static final int GET_FRAME_WIDGET_INPUT_HANDLER_ORDINAL = 13;
  private static final int IME_COMMIT_TEXT_ORDINAL = 5;
  private static final int IME_FINISH_COMPOSING_TEXT_ORDINAL = 6;
  private static final int IME_SET_COMPOSITION_ORDINAL = 4;
  public static final Interface.Manager<WidgetInputHandler, WidgetInputHandler.Proxy> MANAGER =
      new Interface.Manager<WidgetInputHandler, WidgetInputHandler.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.WidgetInputHandler";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WidgetInputHandler.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WidgetInputHandler impl) {
          return new Stub(core, impl);
        }

        @Override
        public WidgetInputHandler[] buildArray(int size) {
          return new WidgetInputHandler[size];
        }
      };
  private static final int MOUSE_CAPTURE_LOST_ORDINAL = 1;
  private static final int REQUEST_COMPOSITION_UPDATES_ORDINAL = 8;
  private static final int REQUEST_TEXT_INPUT_STATE_UPDATE_ORDINAL = 7;
  private static final int SET_EDIT_COMMANDS_FOR_NEXT_KEY_EVENT_ORDINAL = 2;
  private static final int SET_FOCUS_ORDINAL = 0;
  private static final int UPDATE_BROWSER_CONTROLS_STATE_ORDINAL = 14;
  private static final int WAIT_FOR_INPUT_PROCESSED_ORDINAL = 11;

  WidgetInputHandler_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WidgetInputHandler.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setFocus(int state) {
      WidgetInputHandlerSetFocusParams _message = new WidgetInputHandlerSetFocusParams();
      _message.state = state;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void mouseCaptureLost() {
      WidgetInputHandlerMouseCaptureLostParams _message =
          new WidgetInputHandlerMouseCaptureLostParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setEditCommandsForNextKeyEvent(EditCommand[] commands) {
      WidgetInputHandlerSetEditCommandsForNextKeyEventParams _message =
          new WidgetInputHandlerSetEditCommandsForNextKeyEventParams();
      _message.commands = commands;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void cursorVisibilityChanged(boolean visible) {
      WidgetInputHandlerCursorVisibilityChangedParams _message =
          new WidgetInputHandlerCursorVisibilityChangedParams();
      _message.visible = visible;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void imeSetComposition(
        String16 text,
        ImeTextSpan[] imeTextSpans,
        Range range,
        int start,
        int end,
        ImeSetComposition_Response callback) {
      WidgetInputHandlerImeSetCompositionParams _message =
          new WidgetInputHandlerImeSetCompositionParams();
      _message.text = text;
      _message.imeTextSpans = imeTextSpans;
      _message.range = range;
      _message.start = start;
      _message.end = end;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new WidgetInputHandlerImeSetCompositionResponseParamsForwardToCallback(callback));
    }

    @Override
    public void imeCommitText(
        String16 text,
        ImeTextSpan[] imeTextSpans,
        Range range,
        int relativeCursorPosition,
        ImeCommitText_Response callback) {
      WidgetInputHandlerImeCommitTextParams _message = new WidgetInputHandlerImeCommitTextParams();
      _message.text = text;
      _message.imeTextSpans = imeTextSpans;
      _message.range = range;
      _message.relativeCursorPosition = relativeCursorPosition;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new WidgetInputHandlerImeCommitTextResponseParamsForwardToCallback(callback));
    }

    @Override
    public void imeFinishComposingText(boolean keepSelection) {
      WidgetInputHandlerImeFinishComposingTextParams _message =
          new WidgetInputHandlerImeFinishComposingTextParams();
      _message.keepSelection = keepSelection;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void requestTextInputStateUpdate() {
      WidgetInputHandlerRequestTextInputStateUpdateParams _message =
          new WidgetInputHandlerRequestTextInputStateUpdateParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void requestCompositionUpdates(boolean immediateRequest, boolean monitorRequest) {
      WidgetInputHandlerRequestCompositionUpdatesParams _message =
          new WidgetInputHandlerRequestCompositionUpdatesParams();
      _message.immediateRequest = immediateRequest;
      _message.monitorRequest = monitorRequest;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void dispatchEvent(Event event, DispatchEvent_Response callback) {
      WidgetInputHandlerDispatchEventParams _message = new WidgetInputHandlerDispatchEventParams();
      _message.event = event;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new WidgetInputHandlerDispatchEventResponseParamsForwardToCallback(callback));
    }

    @Override
    public void dispatchNonBlockingEvent(Event event) {
      WidgetInputHandlerDispatchNonBlockingEventParams _message =
          new WidgetInputHandlerDispatchNonBlockingEventParams();
      _message.event = event;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void waitForInputProcessed(WaitForInputProcessed_Response callback) {
      WidgetInputHandlerWaitForInputProcessedParams _message =
          new WidgetInputHandlerWaitForInputProcessedParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)),
              new WidgetInputHandlerWaitForInputProcessedResponseParamsForwardToCallback(callback));
    }

    @Override
    public void attachSynchronousCompositor(
        SynchronousCompositorControlHost controlHost,
        AssociatedInterfaceNotSupported host,
        AssociatedInterfaceRequestNotSupported compositorRequest) {
      WidgetInputHandlerAttachSynchronousCompositorParams _message =
          new WidgetInputHandlerAttachSynchronousCompositorParams();
      _message.controlHost = controlHost;
      _message.host = host;
      _message.compositorRequest = compositorRequest;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }

    @Override
    public void getFrameWidgetInputHandler(
        AssociatedInterfaceRequestNotSupported interfaceRequest) {
      WidgetInputHandlerGetFrameWidgetInputHandlerParams _message =
          new WidgetInputHandlerGetFrameWidgetInputHandlerParams();
      _message.interfaceRequest = interfaceRequest;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
    }

    @Override
    public void updateBrowserControlsState(int constraints, int current, boolean animate) {
      WidgetInputHandlerUpdateBrowserControlsStateParams _message =
          new WidgetInputHandlerUpdateBrowserControlsStateParams();
      _message.constraints = constraints;
      _message.current = current;
      _message.animate = animate;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14)));
    }
  }

  public static final class Stub extends Interface.Stub<WidgetInputHandler> {
    Stub(Core core, WidgetInputHandler impl) {
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
                WidgetInputHandler_Internal.MANAGER, messageWithHeader);
          case -1:
          case 4:
          case 5:
          case 9:
          case 11:
          default:
            return false;
          case 0:
            WidgetInputHandlerSetFocusParams data =
                WidgetInputHandlerSetFocusParams.deserialize(messageWithHeader.getPayload());
            getImpl().setFocus(data.state);
            return true;
          case 1:
            WidgetInputHandlerMouseCaptureLostParams.deserialize(messageWithHeader.getPayload());
            getImpl().mouseCaptureLost();
            return true;
          case 2:
            WidgetInputHandlerSetEditCommandsForNextKeyEventParams data2 =
                WidgetInputHandlerSetEditCommandsForNextKeyEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setEditCommandsForNextKeyEvent(data2.commands);
            return true;
          case 3:
            WidgetInputHandlerCursorVisibilityChangedParams data3 =
                WidgetInputHandlerCursorVisibilityChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().cursorVisibilityChanged(data3.visible);
            return true;
          case 6:
            WidgetInputHandlerImeFinishComposingTextParams data4 =
                WidgetInputHandlerImeFinishComposingTextParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().imeFinishComposingText(data4.keepSelection);
            return true;
          case 7:
            WidgetInputHandlerRequestTextInputStateUpdateParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().requestTextInputStateUpdate();
            return true;
          case 8:
            WidgetInputHandlerRequestCompositionUpdatesParams data5 =
                WidgetInputHandlerRequestCompositionUpdatesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().requestCompositionUpdates(data5.immediateRequest, data5.monitorRequest);
            return true;
          case 10:
            WidgetInputHandlerDispatchNonBlockingEventParams data6 =
                WidgetInputHandlerDispatchNonBlockingEventParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().dispatchNonBlockingEvent(data6.event);
            return true;
          case 12:
            WidgetInputHandlerAttachSynchronousCompositorParams data7 =
                WidgetInputHandlerAttachSynchronousCompositorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .attachSynchronousCompositor(
                    data7.controlHost, data7.host, data7.compositorRequest);
            return true;
          case 13:
            WidgetInputHandlerGetFrameWidgetInputHandlerParams data8 =
                WidgetInputHandlerGetFrameWidgetInputHandlerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().getFrameWidgetInputHandler(data8.interfaceRequest);
            return true;
          case 14:
            WidgetInputHandlerUpdateBrowserControlsStateParams data9 =
                WidgetInputHandlerUpdateBrowserControlsStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateBrowserControlsState(data9.constraints, data9.current, data9.animate);
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
                getCore(), WidgetInputHandler_Internal.MANAGER, messageWithHeader, receiver);
          case 4:
            WidgetInputHandlerImeSetCompositionParams data =
                WidgetInputHandlerImeSetCompositionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .imeSetComposition(
                    data.text,
                    data.imeTextSpans,
                    data.range,
                    data.start,
                    data.end,
                    new WidgetInputHandlerImeSetCompositionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            WidgetInputHandlerImeCommitTextParams data2 =
                WidgetInputHandlerImeCommitTextParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .imeCommitText(
                    data2.text,
                    data2.imeTextSpans,
                    data2.range,
                    data2.relativeCursorPosition,
                    new WidgetInputHandlerImeCommitTextResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 9:
            getImpl()
                .dispatchEvent(
                    WidgetInputHandlerDispatchEventParams.deserialize(
                            messageWithHeader.getPayload())
                        .event,
                    new WidgetInputHandlerDispatchEventResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 11:
            WidgetInputHandlerWaitForInputProcessedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .waitForInputProcessed(
                    new WidgetInputHandlerWaitForInputProcessedResponseParamsProxyToResponder(
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

  static final class WidgetInputHandlerSetFocusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int state;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerSetFocusParams(int version) {
      super(16, version);
    }

    public WidgetInputHandlerSetFocusParams() {
      this(0);
    }

    public static WidgetInputHandlerSetFocusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerSetFocusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerSetFocusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerSetFocusParams result =
            new WidgetInputHandlerSetFocusParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.state = readInt;
        FocusState.validate(readInt);
        result.state = FocusState.toKnownValue(result.state);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.state, 8);
    }
  }

  static final class WidgetInputHandlerMouseCaptureLostParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerMouseCaptureLostParams(int version) {
      super(8, version);
    }

    public WidgetInputHandlerMouseCaptureLostParams() {
      this(0);
    }

    public static WidgetInputHandlerMouseCaptureLostParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerMouseCaptureLostParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerMouseCaptureLostParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerMouseCaptureLostParams result =
            new WidgetInputHandlerMouseCaptureLostParams(elementsOrVersion);
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

  static final class WidgetInputHandlerSetEditCommandsForNextKeyEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public EditCommand[] commands;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerSetEditCommandsForNextKeyEventParams(int version) {
      super(16, version);
    }

    public WidgetInputHandlerSetEditCommandsForNextKeyEventParams() {
      this(0);
    }

    public static WidgetInputHandlerSetEditCommandsForNextKeyEventParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerSetEditCommandsForNextKeyEventParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerSetEditCommandsForNextKeyEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerSetEditCommandsForNextKeyEventParams result =
            new WidgetInputHandlerSetEditCommandsForNextKeyEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.commands = new EditCommand[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.commands[i1] = EditCommand.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      EditCommand[] editCommandArr = this.commands;
      if (editCommandArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(editCommandArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        EditCommand[] editCommandArr2 = this.commands;
        if (i0 < editCommandArr2.length) {
          encoder1.encode((Struct) editCommandArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class WidgetInputHandlerCursorVisibilityChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean visible;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerCursorVisibilityChangedParams(int version) {
      super(16, version);
    }

    public WidgetInputHandlerCursorVisibilityChangedParams() {
      this(0);
    }

    public static WidgetInputHandlerCursorVisibilityChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerCursorVisibilityChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerCursorVisibilityChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerCursorVisibilityChangedParams result =
            new WidgetInputHandlerCursorVisibilityChangedParams(elementsOrVersion);
        result.visible = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.visible, 8, 0);
    }
  }

  static final class WidgetInputHandlerImeSetCompositionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public int end;
    public ImeTextSpan[] imeTextSpans;
    public Range range;
    public int start;
    public String16 text;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerImeSetCompositionParams(int version) {
      super(40, version);
    }

    public WidgetInputHandlerImeSetCompositionParams() {
      this(0);
    }

    public static WidgetInputHandlerImeSetCompositionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerImeSetCompositionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerImeSetCompositionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerImeSetCompositionParams result =
            new WidgetInputHandlerImeSetCompositionParams(elementsOrVersion);
        result.text = String16.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.imeTextSpans = new ImeTextSpan[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.imeTextSpans[i1] = ImeTextSpan.decode(decoder2);
        }
        result.range = Range.decode(decoder0.readPointer(24, false));
        result.start = decoder0.readInt(32);
        result.end = decoder0.readInt(36);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.text, 8, false);
      ImeTextSpan[] imeTextSpanArr = this.imeTextSpans;
      if (imeTextSpanArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(imeTextSpanArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          ImeTextSpan[] imeTextSpanArr2 = this.imeTextSpans;
          if (i0 >= imeTextSpanArr2.length) {
            break;
          }
          encoder1.encode((Struct) imeTextSpanArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.range, 24, false);
      encoder0.encode(this.start, 32);
      encoder0.encode(this.end, 36);
    }
  }

  static final class WidgetInputHandlerImeSetCompositionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerImeSetCompositionResponseParams(int version) {
      super(8, version);
    }

    public WidgetInputHandlerImeSetCompositionResponseParams() {
      this(0);
    }

    public static WidgetInputHandlerImeSetCompositionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerImeSetCompositionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerImeSetCompositionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerImeSetCompositionResponseParams result =
            new WidgetInputHandlerImeSetCompositionResponseParams(elementsOrVersion);
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

  static class WidgetInputHandlerImeSetCompositionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WidgetInputHandler.ImeSetComposition_Response mCallback;

    WidgetInputHandlerImeSetCompositionResponseParamsForwardToCallback(
        WidgetInputHandler.ImeSetComposition_Response callback) {
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

  static class WidgetInputHandlerImeSetCompositionResponseParamsProxyToResponder
      implements WidgetInputHandler.ImeSetComposition_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WidgetInputHandlerImeSetCompositionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      WidgetInputHandlerImeSetCompositionResponseParams _response =
          new WidgetInputHandlerImeSetCompositionResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WidgetInputHandlerImeCommitTextParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public ImeTextSpan[] imeTextSpans;
    public Range range;
    public int relativeCursorPosition;
    public String16 text;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerImeCommitTextParams(int version) {
      super(40, version);
    }

    public WidgetInputHandlerImeCommitTextParams() {
      this(0);
    }

    public static WidgetInputHandlerImeCommitTextParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerImeCommitTextParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerImeCommitTextParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerImeCommitTextParams result =
            new WidgetInputHandlerImeCommitTextParams(elementsOrVersion);
        result.text = String16.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.imeTextSpans = new ImeTextSpan[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.imeTextSpans[i1] = ImeTextSpan.decode(decoder2);
        }
        result.range = Range.decode(decoder0.readPointer(24, false));
        result.relativeCursorPosition = decoder0.readInt(32);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.text, 8, false);
      ImeTextSpan[] imeTextSpanArr = this.imeTextSpans;
      if (imeTextSpanArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(imeTextSpanArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          ImeTextSpan[] imeTextSpanArr2 = this.imeTextSpans;
          if (i0 >= imeTextSpanArr2.length) {
            break;
          }
          encoder1.encode((Struct) imeTextSpanArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode((Struct) this.range, 24, false);
      encoder0.encode(this.relativeCursorPosition, 32);
    }
  }

  static final class WidgetInputHandlerImeCommitTextResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerImeCommitTextResponseParams(int version) {
      super(8, version);
    }

    public WidgetInputHandlerImeCommitTextResponseParams() {
      this(0);
    }

    public static WidgetInputHandlerImeCommitTextResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerImeCommitTextResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerImeCommitTextResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerImeCommitTextResponseParams result =
            new WidgetInputHandlerImeCommitTextResponseParams(elementsOrVersion);
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

  static class WidgetInputHandlerImeCommitTextResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WidgetInputHandler.ImeCommitText_Response mCallback;

    WidgetInputHandlerImeCommitTextResponseParamsForwardToCallback(
        WidgetInputHandler.ImeCommitText_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WidgetInputHandlerImeCommitTextResponseParamsProxyToResponder
      implements WidgetInputHandler.ImeCommitText_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WidgetInputHandlerImeCommitTextResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      WidgetInputHandlerImeCommitTextResponseParams _response =
          new WidgetInputHandlerImeCommitTextResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WidgetInputHandlerImeFinishComposingTextParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean keepSelection;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerImeFinishComposingTextParams(int version) {
      super(16, version);
    }

    public WidgetInputHandlerImeFinishComposingTextParams() {
      this(0);
    }

    public static WidgetInputHandlerImeFinishComposingTextParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerImeFinishComposingTextParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerImeFinishComposingTextParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerImeFinishComposingTextParams result =
            new WidgetInputHandlerImeFinishComposingTextParams(elementsOrVersion);
        result.keepSelection = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.keepSelection, 8, 0);
    }
  }

  static final class WidgetInputHandlerRequestTextInputStateUpdateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerRequestTextInputStateUpdateParams(int version) {
      super(8, version);
    }

    public WidgetInputHandlerRequestTextInputStateUpdateParams() {
      this(0);
    }

    public static WidgetInputHandlerRequestTextInputStateUpdateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerRequestTextInputStateUpdateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerRequestTextInputStateUpdateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerRequestTextInputStateUpdateParams result =
            new WidgetInputHandlerRequestTextInputStateUpdateParams(elementsOrVersion);
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

  static final class WidgetInputHandlerRequestCompositionUpdatesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean immediateRequest;
    public boolean monitorRequest;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerRequestCompositionUpdatesParams(int version) {
      super(16, version);
    }

    public WidgetInputHandlerRequestCompositionUpdatesParams() {
      this(0);
    }

    public static WidgetInputHandlerRequestCompositionUpdatesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerRequestCompositionUpdatesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerRequestCompositionUpdatesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerRequestCompositionUpdatesParams result =
            new WidgetInputHandlerRequestCompositionUpdatesParams(elementsOrVersion);
        result.immediateRequest = decoder0.readBoolean(8, 0);
        result.monitorRequest = decoder0.readBoolean(8, 1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.immediateRequest, 8, 0);
      encoder0.encode(this.monitorRequest, 8, 1);
    }
  }

  static final class WidgetInputHandlerDispatchEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Event event;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerDispatchEventParams(int version) {
      super(16, version);
    }

    public WidgetInputHandlerDispatchEventParams() {
      this(0);
    }

    public static WidgetInputHandlerDispatchEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerDispatchEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerDispatchEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerDispatchEventParams result =
            new WidgetInputHandlerDispatchEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.event = Event.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.event, 8, false);
    }
  }

  static final class WidgetInputHandlerDispatchEventResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public DidOverscrollParams overscroll;
    public int source;
    public int state;
    public TouchActionOptional touchAction;
    public LatencyInfo updatedLatency;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerDispatchEventResponseParams(int version) {
      super(40, version);
    }

    public WidgetInputHandlerDispatchEventResponseParams() {
      this(0);
    }

    public static WidgetInputHandlerDispatchEventResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerDispatchEventResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerDispatchEventResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerDispatchEventResponseParams result =
            new WidgetInputHandlerDispatchEventResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.source = readInt;
        InputEventResultSource.validate(readInt);
        result.source = InputEventResultSource.toKnownValue(result.source);
        int readInt2 = decoder0.readInt(12);
        result.state = readInt2;
        InputEventResultState.validate(readInt2);
        result.state = InputEventResultState.toKnownValue(result.state);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.updatedLatency = LatencyInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.overscroll = DidOverscrollParams.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, true);
        result.touchAction = TouchActionOptional.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.source, 8);
      encoder0.encode(this.state, 12);
      encoder0.encode((Struct) this.updatedLatency, 16, false);
      encoder0.encode((Struct) this.overscroll, 24, true);
      encoder0.encode((Struct) this.touchAction, 32, true);
    }
  }

  static class WidgetInputHandlerDispatchEventResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WidgetInputHandler.DispatchEvent_Response mCallback;

    WidgetInputHandlerDispatchEventResponseParamsForwardToCallback(
        WidgetInputHandler.DispatchEvent_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(9, 2)) {
          return false;
        }
        WidgetInputHandlerDispatchEventResponseParams response =
            WidgetInputHandlerDispatchEventResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(
            response.source,
            response.updatedLatency,
            response.state,
            response.overscroll,
            response.touchAction);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WidgetInputHandlerDispatchEventResponseParamsProxyToResponder
      implements WidgetInputHandler.DispatchEvent_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WidgetInputHandlerDispatchEventResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        int source,
        LatencyInfo updatedLatency,
        int state,
        DidOverscrollParams overscroll,
        TouchActionOptional touchAction) {
      WidgetInputHandlerDispatchEventResponseParams _response =
          new WidgetInputHandlerDispatchEventResponseParams();
      _response.source = source;
      _response.updatedLatency = updatedLatency;
      _response.state = state;
      _response.overscroll = overscroll;
      _response.touchAction = touchAction;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WidgetInputHandlerDispatchNonBlockingEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Event event;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerDispatchNonBlockingEventParams(int version) {
      super(16, version);
    }

    public WidgetInputHandlerDispatchNonBlockingEventParams() {
      this(0);
    }

    public static WidgetInputHandlerDispatchNonBlockingEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerDispatchNonBlockingEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerDispatchNonBlockingEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerDispatchNonBlockingEventParams result =
            new WidgetInputHandlerDispatchNonBlockingEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.event = Event.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.event, 8, false);
    }
  }

  static final class WidgetInputHandlerWaitForInputProcessedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerWaitForInputProcessedParams(int version) {
      super(8, version);
    }

    public WidgetInputHandlerWaitForInputProcessedParams() {
      this(0);
    }

    public static WidgetInputHandlerWaitForInputProcessedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerWaitForInputProcessedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerWaitForInputProcessedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerWaitForInputProcessedParams result =
            new WidgetInputHandlerWaitForInputProcessedParams(elementsOrVersion);
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

  static final class WidgetInputHandlerWaitForInputProcessedResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerWaitForInputProcessedResponseParams(int version) {
      super(8, version);
    }

    public WidgetInputHandlerWaitForInputProcessedResponseParams() {
      this(0);
    }

    public static WidgetInputHandlerWaitForInputProcessedResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerWaitForInputProcessedResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerWaitForInputProcessedResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerWaitForInputProcessedResponseParams result =
            new WidgetInputHandlerWaitForInputProcessedResponseParams(elementsOrVersion);
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

  static class WidgetInputHandlerWaitForInputProcessedResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WidgetInputHandler.WaitForInputProcessed_Response mCallback;

    WidgetInputHandlerWaitForInputProcessedResponseParamsForwardToCallback(
        WidgetInputHandler.WaitForInputProcessed_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(11, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WidgetInputHandlerWaitForInputProcessedResponseParamsProxyToResponder
      implements WidgetInputHandler.WaitForInputProcessed_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WidgetInputHandlerWaitForInputProcessedResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      WidgetInputHandlerWaitForInputProcessedResponseParams _response =
          new WidgetInputHandlerWaitForInputProcessedResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WidgetInputHandlerAttachSynchronousCompositorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceRequestNotSupported compositorRequest;
    public SynchronousCompositorControlHost controlHost;
    public AssociatedInterfaceNotSupported host;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerAttachSynchronousCompositorParams(int version) {
      super(32, version);
    }

    public WidgetInputHandlerAttachSynchronousCompositorParams() {
      this(0);
    }

    public static WidgetInputHandlerAttachSynchronousCompositorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerAttachSynchronousCompositorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerAttachSynchronousCompositorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerAttachSynchronousCompositorParams result =
            new WidgetInputHandlerAttachSynchronousCompositorParams(elementsOrVersion);
        result.controlHost =
            (SynchronousCompositorControlHost)
                decoder0.readServiceInterface(8, false, SynchronousCompositorControlHost.MANAGER);
        result.host = decoder0.readAssociatedServiceInterfaceNotSupported(16, false);
        result.compositorRequest = decoder0.readAssociatedInterfaceRequestNotSupported(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.controlHost, 8, false, SynchronousCompositorControlHost.MANAGER);
      encoder0.encode(this.host, 16, false);
      encoder0.encode(this.compositorRequest, 24, false);
    }
  }

  static final class WidgetInputHandlerGetFrameWidgetInputHandlerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceRequestNotSupported interfaceRequest;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WidgetInputHandlerGetFrameWidgetInputHandlerParams(int version) {
      super(16, version);
    }

    public WidgetInputHandlerGetFrameWidgetInputHandlerParams() {
      this(0);
    }

    public static WidgetInputHandlerGetFrameWidgetInputHandlerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerGetFrameWidgetInputHandlerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerGetFrameWidgetInputHandlerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerGetFrameWidgetInputHandlerParams result =
            new WidgetInputHandlerGetFrameWidgetInputHandlerParams(elementsOrVersion);
        result.interfaceRequest = decoder0.readAssociatedInterfaceRequestNotSupported(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.interfaceRequest, 8, false);
    }
  }

  static final class WidgetInputHandlerUpdateBrowserControlsStateParams extends Struct {
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

    private WidgetInputHandlerUpdateBrowserControlsStateParams(int version) {
      super(24, version);
    }

    public WidgetInputHandlerUpdateBrowserControlsStateParams() {
      this(0);
    }

    public static WidgetInputHandlerUpdateBrowserControlsStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WidgetInputHandlerUpdateBrowserControlsStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WidgetInputHandlerUpdateBrowserControlsStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WidgetInputHandlerUpdateBrowserControlsStateParams result =
            new WidgetInputHandlerUpdateBrowserControlsStateParams(elementsOrVersion);
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
}
