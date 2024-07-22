package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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
import org.chromium.mojo.system.Core;
import org.chromium.ui.mojom.WindowOpenDisposition;
import org.chromium.url.mojom.Url;

class LocalMainFrameHost_Internal {
  private static final int CONTENTS_PREFERRED_SIZE_CHANGED_ORDINAL = 1;
  private static final int DID_ACCESS_INITIAL_MAIN_DOCUMENT_ORDINAL = 10;
  private static final int DID_FIRST_VISUALLY_NON_EMPTY_PAINT_ORDINAL = 9;
  private static final int FOCUS_PAGE_ORDINAL = 3;
  public static final Interface.Manager<LocalMainFrameHost, LocalMainFrameHost.Proxy> MANAGER =
      new Interface.Manager<LocalMainFrameHost, LocalMainFrameHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.LocalMainFrameHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public LocalMainFrameHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, LocalMainFrameHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public LocalMainFrameHost[] buildArray(int size) {
          return new LocalMainFrameHost[size];
        }
      };
  private static final int MAXIMIZE_ORDINAL = 11;
  private static final int MINIMIZE_ORDINAL = 12;
  private static final int REQUEST_CLOSE_ORDINAL = 6;
  private static final int RESTORE_ORDINAL = 13;
  private static final int SCALE_FACTOR_CHANGED_ORDINAL = 0;
  private static final int SET_RESIZABLE_ORDINAL = 14;
  private static final int SET_WINDOW_RECT_ORDINAL = 8;
  private static final int SHOW_CREATED_WINDOW_ORDINAL = 7;
  private static final int TAKE_FOCUS_ORDINAL = 4;
  private static final int TEXT_AUTOSIZER_PAGE_INFO_CHANGED_ORDINAL = 2;
  private static final int UPDATE_TARGET_URL_ORDINAL = 5;

  LocalMainFrameHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements LocalMainFrameHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void scaleFactorChanged(float scale) {
      LocalMainFrameHostScaleFactorChangedParams _message =
          new LocalMainFrameHostScaleFactorChangedParams();
      _message.scale = scale;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void contentsPreferredSizeChanged(Size prefSize) {
      LocalMainFrameHostContentsPreferredSizeChangedParams _message =
          new LocalMainFrameHostContentsPreferredSizeChangedParams();
      _message.prefSize = prefSize;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void textAutosizerPageInfoChanged(TextAutosizerPageInfo pageInfo) {
      LocalMainFrameHostTextAutosizerPageInfoChangedParams _message =
          new LocalMainFrameHostTextAutosizerPageInfoChangedParams();
      _message.pageInfo = pageInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void focusPage() {
      LocalMainFrameHostFocusPageParams _message = new LocalMainFrameHostFocusPageParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void takeFocus(boolean reverse) {
      LocalMainFrameHostTakeFocusParams _message = new LocalMainFrameHostTakeFocusParams();
      _message.reverse = reverse;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void updateTargetUrl(Url url, UpdateTargetUrl_Response callback) {
      LocalMainFrameHostUpdateTargetUrlParams _message =
          new LocalMainFrameHostUpdateTargetUrlParams();
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new LocalMainFrameHostUpdateTargetUrlResponseParamsForwardToCallback(callback));
    }

    @Override
    public void requestClose() {
      LocalMainFrameHostRequestCloseParams _message = new LocalMainFrameHostRequestCloseParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void showCreatedWindow(
        LocalFrameToken openerFrameToken,
        int disposition,
        WindowFeatures windowFeatures,
        boolean openedByUserGesture,
        ShowCreatedWindow_Response callback) {
      LocalMainFrameHostShowCreatedWindowParams _message =
          new LocalMainFrameHostShowCreatedWindowParams();
      _message.openerFrameToken = openerFrameToken;
      _message.disposition = disposition;
      _message.windowFeatures = windowFeatures;
      _message.openedByUserGesture = openedByUserGesture;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new LocalMainFrameHostShowCreatedWindowResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setWindowRect(Rect bounds, SetWindowRect_Response callback) {
      LocalMainFrameHostSetWindowRectParams _message = new LocalMainFrameHostSetWindowRectParams();
      _message.bounds = bounds;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new LocalMainFrameHostSetWindowRectResponseParamsForwardToCallback(callback));
    }

    @Override
    public void didFirstVisuallyNonEmptyPaint() {
      LocalMainFrameHostDidFirstVisuallyNonEmptyPaintParams _message =
          new LocalMainFrameHostDidFirstVisuallyNonEmptyPaintParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void didAccessInitialMainDocument() {
      LocalMainFrameHostDidAccessInitialMainDocumentParams _message =
          new LocalMainFrameHostDidAccessInitialMainDocumentParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void maximize() {
      LocalMainFrameHostMaximizeParams _message = new LocalMainFrameHostMaximizeParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }

    @Override
    public void minimize() {
      LocalMainFrameHostMinimizeParams _message = new LocalMainFrameHostMinimizeParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }

    @Override
    public void restore() {
      LocalMainFrameHostRestoreParams _message = new LocalMainFrameHostRestoreParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
    }

    @Override
    public void setResizable(boolean resizable) {
      LocalMainFrameHostSetResizableParams _message = new LocalMainFrameHostSetResizableParams();
      _message.resizable = resizable;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14)));
    }
  }

  public static final class Stub extends Interface.Stub<LocalMainFrameHost> {
    Stub(Core core, LocalMainFrameHost impl) {
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
                LocalMainFrameHost_Internal.MANAGER, messageWithHeader);
          case -1:
          case 5:
          case 7:
          case 8:
          default:
            return false;
          case 0:
            LocalMainFrameHostScaleFactorChangedParams data =
                LocalMainFrameHostScaleFactorChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().scaleFactorChanged(data.scale);
            return true;
          case 1:
            LocalMainFrameHostContentsPreferredSizeChangedParams data2 =
                LocalMainFrameHostContentsPreferredSizeChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().contentsPreferredSizeChanged(data2.prefSize);
            return true;
          case 2:
            LocalMainFrameHostTextAutosizerPageInfoChangedParams data3 =
                LocalMainFrameHostTextAutosizerPageInfoChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().textAutosizerPageInfoChanged(data3.pageInfo);
            return true;
          case 3:
            LocalMainFrameHostFocusPageParams.deserialize(messageWithHeader.getPayload());
            getImpl().focusPage();
            return true;
          case 4:
            LocalMainFrameHostTakeFocusParams data4 =
                LocalMainFrameHostTakeFocusParams.deserialize(messageWithHeader.getPayload());
            getImpl().takeFocus(data4.reverse);
            return true;
          case 6:
            LocalMainFrameHostRequestCloseParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestClose();
            return true;
          case 9:
            LocalMainFrameHostDidFirstVisuallyNonEmptyPaintParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().didFirstVisuallyNonEmptyPaint();
            return true;
          case 10:
            LocalMainFrameHostDidAccessInitialMainDocumentParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().didAccessInitialMainDocument();
            return true;
          case 11:
            LocalMainFrameHostMaximizeParams.deserialize(messageWithHeader.getPayload());
            getImpl().maximize();
            return true;
          case 12:
            LocalMainFrameHostMinimizeParams.deserialize(messageWithHeader.getPayload());
            getImpl().minimize();
            return true;
          case 13:
            LocalMainFrameHostRestoreParams.deserialize(messageWithHeader.getPayload());
            getImpl().restore();
            return true;
          case 14:
            LocalMainFrameHostSetResizableParams data5 =
                LocalMainFrameHostSetResizableParams.deserialize(messageWithHeader.getPayload());
            getImpl().setResizable(data5.resizable);
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
                getCore(), LocalMainFrameHost_Internal.MANAGER, messageWithHeader, receiver);
          case 5:
            getImpl()
                .updateTargetUrl(
                    LocalMainFrameHostUpdateTargetUrlParams.deserialize(
                            messageWithHeader.getPayload())
                        .url,
                    new LocalMainFrameHostUpdateTargetUrlResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            LocalMainFrameHostShowCreatedWindowParams data =
                LocalMainFrameHostShowCreatedWindowParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .showCreatedWindow(
                    data.openerFrameToken,
                    data.disposition,
                    data.windowFeatures,
                    data.openedByUserGesture,
                    new LocalMainFrameHostShowCreatedWindowResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            LocalMainFrameHostSetWindowRectParams data2 =
                LocalMainFrameHostSetWindowRectParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .setWindowRect(
                    data2.bounds,
                    new LocalMainFrameHostSetWindowRectResponseParamsProxyToResponder(
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

  static final class LocalMainFrameHostScaleFactorChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public float scale;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostScaleFactorChangedParams(int version) {
      super(16, version);
    }

    public LocalMainFrameHostScaleFactorChangedParams() {
      this(0);
    }

    public static LocalMainFrameHostScaleFactorChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostScaleFactorChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostScaleFactorChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostScaleFactorChangedParams result =
            new LocalMainFrameHostScaleFactorChangedParams(elementsOrVersion);
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

  static final class LocalMainFrameHostContentsPreferredSizeChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Size prefSize;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostContentsPreferredSizeChangedParams(int version) {
      super(16, version);
    }

    public LocalMainFrameHostContentsPreferredSizeChangedParams() {
      this(0);
    }

    public static LocalMainFrameHostContentsPreferredSizeChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostContentsPreferredSizeChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostContentsPreferredSizeChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostContentsPreferredSizeChangedParams result =
            new LocalMainFrameHostContentsPreferredSizeChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.prefSize = Size.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.prefSize, 8, false);
    }
  }

  static final class LocalMainFrameHostTextAutosizerPageInfoChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public TextAutosizerPageInfo pageInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostTextAutosizerPageInfoChangedParams(int version) {
      super(16, version);
    }

    public LocalMainFrameHostTextAutosizerPageInfoChangedParams() {
      this(0);
    }

    public static LocalMainFrameHostTextAutosizerPageInfoChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostTextAutosizerPageInfoChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostTextAutosizerPageInfoChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostTextAutosizerPageInfoChangedParams result =
            new LocalMainFrameHostTextAutosizerPageInfoChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.pageInfo = TextAutosizerPageInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.pageInfo, 8, false);
    }
  }

  static final class LocalMainFrameHostFocusPageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostFocusPageParams(int version) {
      super(8, version);
    }

    public LocalMainFrameHostFocusPageParams() {
      this(0);
    }

    public static LocalMainFrameHostFocusPageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostFocusPageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostFocusPageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostFocusPageParams result =
            new LocalMainFrameHostFocusPageParams(elementsOrVersion);
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

  static final class LocalMainFrameHostTakeFocusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean reverse;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostTakeFocusParams(int version) {
      super(16, version);
    }

    public LocalMainFrameHostTakeFocusParams() {
      this(0);
    }

    public static LocalMainFrameHostTakeFocusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostTakeFocusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostTakeFocusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostTakeFocusParams result =
            new LocalMainFrameHostTakeFocusParams(elementsOrVersion);
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

  static final class LocalMainFrameHostUpdateTargetUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostUpdateTargetUrlParams(int version) {
      super(16, version);
    }

    public LocalMainFrameHostUpdateTargetUrlParams() {
      this(0);
    }

    public static LocalMainFrameHostUpdateTargetUrlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostUpdateTargetUrlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostUpdateTargetUrlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostUpdateTargetUrlParams result =
            new LocalMainFrameHostUpdateTargetUrlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
    }
  }

  static final class LocalMainFrameHostUpdateTargetUrlResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostUpdateTargetUrlResponseParams(int version) {
      super(8, version);
    }

    public LocalMainFrameHostUpdateTargetUrlResponseParams() {
      this(0);
    }

    public static LocalMainFrameHostUpdateTargetUrlResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostUpdateTargetUrlResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostUpdateTargetUrlResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostUpdateTargetUrlResponseParams result =
            new LocalMainFrameHostUpdateTargetUrlResponseParams(elementsOrVersion);
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

  static class LocalMainFrameHostUpdateTargetUrlResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalMainFrameHost.UpdateTargetUrl_Response mCallback;

    LocalMainFrameHostUpdateTargetUrlResponseParamsForwardToCallback(
        LocalMainFrameHost.UpdateTargetUrl_Response callback) {
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

  static class LocalMainFrameHostUpdateTargetUrlResponseParamsProxyToResponder
      implements LocalMainFrameHost.UpdateTargetUrl_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalMainFrameHostUpdateTargetUrlResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      LocalMainFrameHostUpdateTargetUrlResponseParams _response =
          new LocalMainFrameHostUpdateTargetUrlResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalMainFrameHostRequestCloseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostRequestCloseParams(int version) {
      super(8, version);
    }

    public LocalMainFrameHostRequestCloseParams() {
      this(0);
    }

    public static LocalMainFrameHostRequestCloseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostRequestCloseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostRequestCloseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostRequestCloseParams result =
            new LocalMainFrameHostRequestCloseParams(elementsOrVersion);
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

  static final class LocalMainFrameHostShowCreatedWindowParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int disposition;
    public boolean openedByUserGesture;
    public LocalFrameToken openerFrameToken;
    public WindowFeatures windowFeatures;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostShowCreatedWindowParams(int version) {
      super(32, version);
    }

    public LocalMainFrameHostShowCreatedWindowParams() {
      this(0);
    }

    public static LocalMainFrameHostShowCreatedWindowParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostShowCreatedWindowParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostShowCreatedWindowParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostShowCreatedWindowParams result =
            new LocalMainFrameHostShowCreatedWindowParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.openerFrameToken = LocalFrameToken.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.disposition = readInt;
        WindowOpenDisposition.validate(readInt);
        result.disposition = WindowOpenDisposition.toKnownValue(result.disposition);
        result.openedByUserGesture = decoder0.readBoolean(20, 0);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.windowFeatures = WindowFeatures.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.openerFrameToken, 8, false);
      encoder0.encode(this.disposition, 16);
      encoder0.encode(this.openedByUserGesture, 20, 0);
      encoder0.encode((Struct) this.windowFeatures, 24, false);
    }
  }

  static final class LocalMainFrameHostShowCreatedWindowResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostShowCreatedWindowResponseParams(int version) {
      super(8, version);
    }

    public LocalMainFrameHostShowCreatedWindowResponseParams() {
      this(0);
    }

    public static LocalMainFrameHostShowCreatedWindowResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostShowCreatedWindowResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostShowCreatedWindowResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostShowCreatedWindowResponseParams result =
            new LocalMainFrameHostShowCreatedWindowResponseParams(elementsOrVersion);
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

  static class LocalMainFrameHostShowCreatedWindowResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalMainFrameHost.ShowCreatedWindow_Response mCallback;

    LocalMainFrameHostShowCreatedWindowResponseParamsForwardToCallback(
        LocalMainFrameHost.ShowCreatedWindow_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(7, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalMainFrameHostShowCreatedWindowResponseParamsProxyToResponder
      implements LocalMainFrameHost.ShowCreatedWindow_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalMainFrameHostShowCreatedWindowResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      LocalMainFrameHostShowCreatedWindowResponseParams _response =
          new LocalMainFrameHostShowCreatedWindowResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalMainFrameHostSetWindowRectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect bounds;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostSetWindowRectParams(int version) {
      super(16, version);
    }

    public LocalMainFrameHostSetWindowRectParams() {
      this(0);
    }

    public static LocalMainFrameHostSetWindowRectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostSetWindowRectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostSetWindowRectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostSetWindowRectParams result =
            new LocalMainFrameHostSetWindowRectParams(elementsOrVersion);
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

  static final class LocalMainFrameHostSetWindowRectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostSetWindowRectResponseParams(int version) {
      super(8, version);
    }

    public LocalMainFrameHostSetWindowRectResponseParams() {
      this(0);
    }

    public static LocalMainFrameHostSetWindowRectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostSetWindowRectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostSetWindowRectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostSetWindowRectResponseParams result =
            new LocalMainFrameHostSetWindowRectResponseParams(elementsOrVersion);
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

  static class LocalMainFrameHostSetWindowRectResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalMainFrameHost.SetWindowRect_Response mCallback;

    LocalMainFrameHostSetWindowRectResponseParamsForwardToCallback(
        LocalMainFrameHost.SetWindowRect_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(8, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalMainFrameHostSetWindowRectResponseParamsProxyToResponder
      implements LocalMainFrameHost.SetWindowRect_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalMainFrameHostSetWindowRectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      LocalMainFrameHostSetWindowRectResponseParams _response =
          new LocalMainFrameHostSetWindowRectResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalMainFrameHostDidFirstVisuallyNonEmptyPaintParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostDidFirstVisuallyNonEmptyPaintParams(int version) {
      super(8, version);
    }

    public LocalMainFrameHostDidFirstVisuallyNonEmptyPaintParams() {
      this(0);
    }

    public static LocalMainFrameHostDidFirstVisuallyNonEmptyPaintParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostDidFirstVisuallyNonEmptyPaintParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostDidFirstVisuallyNonEmptyPaintParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostDidFirstVisuallyNonEmptyPaintParams result =
            new LocalMainFrameHostDidFirstVisuallyNonEmptyPaintParams(elementsOrVersion);
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

  static final class LocalMainFrameHostDidAccessInitialMainDocumentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostDidAccessInitialMainDocumentParams(int version) {
      super(8, version);
    }

    public LocalMainFrameHostDidAccessInitialMainDocumentParams() {
      this(0);
    }

    public static LocalMainFrameHostDidAccessInitialMainDocumentParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostDidAccessInitialMainDocumentParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostDidAccessInitialMainDocumentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostDidAccessInitialMainDocumentParams result =
            new LocalMainFrameHostDidAccessInitialMainDocumentParams(elementsOrVersion);
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

  static final class LocalMainFrameHostMaximizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostMaximizeParams(int version) {
      super(8, version);
    }

    public LocalMainFrameHostMaximizeParams() {
      this(0);
    }

    public static LocalMainFrameHostMaximizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostMaximizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostMaximizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostMaximizeParams result =
            new LocalMainFrameHostMaximizeParams(elementsOrVersion);
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

  static final class LocalMainFrameHostMinimizeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostMinimizeParams(int version) {
      super(8, version);
    }

    public LocalMainFrameHostMinimizeParams() {
      this(0);
    }

    public static LocalMainFrameHostMinimizeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostMinimizeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostMinimizeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostMinimizeParams result =
            new LocalMainFrameHostMinimizeParams(elementsOrVersion);
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

  static final class LocalMainFrameHostRestoreParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostRestoreParams(int version) {
      super(8, version);
    }

    public LocalMainFrameHostRestoreParams() {
      this(0);
    }

    public static LocalMainFrameHostRestoreParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostRestoreParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostRestoreParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostRestoreParams result =
            new LocalMainFrameHostRestoreParams(elementsOrVersion);
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

  static final class LocalMainFrameHostSetResizableParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean resizable;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalMainFrameHostSetResizableParams(int version) {
      super(16, version);
    }

    public LocalMainFrameHostSetResizableParams() {
      this(0);
    }

    public static LocalMainFrameHostSetResizableParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalMainFrameHostSetResizableParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalMainFrameHostSetResizableParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalMainFrameHostSetResizableParams result =
            new LocalMainFrameHostSetResizableParams(elementsOrVersion);
        result.resizable = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.resizable, 8, 0);
    }
  }
}
