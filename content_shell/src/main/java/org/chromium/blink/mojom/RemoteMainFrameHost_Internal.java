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
import org.chromium.url.mojom.Url;

class RemoteMainFrameHost_Internal {
  private static final int FOCUS_PAGE_ORDINAL = 0;
  public static final Interface.Manager<RemoteMainFrameHost, RemoteMainFrameHost.Proxy> MANAGER =
      new Interface.Manager<RemoteMainFrameHost, RemoteMainFrameHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.RemoteMainFrameHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public RemoteMainFrameHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, RemoteMainFrameHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public RemoteMainFrameHost[] buildArray(int size) {
          return new RemoteMainFrameHost[size];
        }
      };
  private static final int ROUTE_CLOSE_EVENT_ORDINAL = 3;
  private static final int TAKE_FOCUS_ORDINAL = 1;
  private static final int UPDATE_TARGET_URL_ORDINAL = 2;

  RemoteMainFrameHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements RemoteMainFrameHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void focusPage() {
      RemoteMainFrameHostFocusPageParams _message = new RemoteMainFrameHostFocusPageParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void takeFocus(boolean reverse) {
      RemoteMainFrameHostTakeFocusParams _message = new RemoteMainFrameHostTakeFocusParams();
      _message.reverse = reverse;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void updateTargetUrl(Url url, UpdateTargetUrl_Response callback) {
      RemoteMainFrameHostUpdateTargetUrlParams _message =
          new RemoteMainFrameHostUpdateTargetUrlParams();
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new RemoteMainFrameHostUpdateTargetUrlResponseParamsForwardToCallback(callback));
    }

    @Override
    public void routeCloseEvent() {
      RemoteMainFrameHostRouteCloseEventParams _message =
          new RemoteMainFrameHostRouteCloseEventParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<RemoteMainFrameHost> {
    Stub(Core core, RemoteMainFrameHost impl) {
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
                RemoteMainFrameHost_Internal.MANAGER, messageWithHeader);
          case -1:
          case 2:
          default:
            return false;
          case 0:
            RemoteMainFrameHostFocusPageParams.deserialize(messageWithHeader.getPayload());
            getImpl().focusPage();
            return true;
          case 1:
            RemoteMainFrameHostTakeFocusParams data =
                RemoteMainFrameHostTakeFocusParams.deserialize(messageWithHeader.getPayload());
            getImpl().takeFocus(data.reverse);
            return true;
          case 3:
            RemoteMainFrameHostRouteCloseEventParams.deserialize(messageWithHeader.getPayload());
            getImpl().routeCloseEvent();
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
                getCore(), RemoteMainFrameHost_Internal.MANAGER, messageWithHeader, receiver);
          case 2:
            RemoteMainFrameHostUpdateTargetUrlParams data =
                RemoteMainFrameHostUpdateTargetUrlParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .updateTargetUrl(
                    data.url,
                    new RemoteMainFrameHostUpdateTargetUrlResponseParamsProxyToResponder(
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

  static final class RemoteMainFrameHostFocusPageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteMainFrameHostFocusPageParams(int version) {
      super(8, version);
    }

    public RemoteMainFrameHostFocusPageParams() {
      this(0);
    }

    public static RemoteMainFrameHostFocusPageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteMainFrameHostFocusPageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteMainFrameHostFocusPageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteMainFrameHostFocusPageParams result =
            new RemoteMainFrameHostFocusPageParams(elementsOrVersion);
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

  static final class RemoteMainFrameHostTakeFocusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean reverse;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteMainFrameHostTakeFocusParams(int version) {
      super(16, version);
    }

    public RemoteMainFrameHostTakeFocusParams() {
      this(0);
    }

    public static RemoteMainFrameHostTakeFocusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteMainFrameHostTakeFocusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteMainFrameHostTakeFocusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteMainFrameHostTakeFocusParams result =
            new RemoteMainFrameHostTakeFocusParams(elementsOrVersion);
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

  static final class RemoteMainFrameHostUpdateTargetUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteMainFrameHostUpdateTargetUrlParams(int version) {
      super(16, version);
    }

    public RemoteMainFrameHostUpdateTargetUrlParams() {
      this(0);
    }

    public static RemoteMainFrameHostUpdateTargetUrlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteMainFrameHostUpdateTargetUrlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteMainFrameHostUpdateTargetUrlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteMainFrameHostUpdateTargetUrlParams result =
            new RemoteMainFrameHostUpdateTargetUrlParams(elementsOrVersion);
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

  static final class RemoteMainFrameHostUpdateTargetUrlResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteMainFrameHostUpdateTargetUrlResponseParams(int version) {
      super(8, version);
    }

    public RemoteMainFrameHostUpdateTargetUrlResponseParams() {
      this(0);
    }

    public static RemoteMainFrameHostUpdateTargetUrlResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteMainFrameHostUpdateTargetUrlResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteMainFrameHostUpdateTargetUrlResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteMainFrameHostUpdateTargetUrlResponseParams result =
            new RemoteMainFrameHostUpdateTargetUrlResponseParams(elementsOrVersion);
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

  static class RemoteMainFrameHostUpdateTargetUrlResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final RemoteMainFrameHost.UpdateTargetUrl_Response mCallback;

    RemoteMainFrameHostUpdateTargetUrlResponseParamsForwardToCallback(
        RemoteMainFrameHost.UpdateTargetUrl_Response callback) {
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

  static class RemoteMainFrameHostUpdateTargetUrlResponseParamsProxyToResponder
      implements RemoteMainFrameHost.UpdateTargetUrl_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    RemoteMainFrameHostUpdateTargetUrlResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      RemoteMainFrameHostUpdateTargetUrlResponseParams _response =
          new RemoteMainFrameHostUpdateTargetUrlResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class RemoteMainFrameHostRouteCloseEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private RemoteMainFrameHostRouteCloseEventParams(int version) {
      super(8, version);
    }

    public RemoteMainFrameHostRouteCloseEventParams() {
      this(0);
    }

    public static RemoteMainFrameHostRouteCloseEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static RemoteMainFrameHostRouteCloseEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static RemoteMainFrameHostRouteCloseEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        RemoteMainFrameHostRouteCloseEventParams result =
            new RemoteMainFrameHostRouteCloseEventParams(elementsOrVersion);
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
