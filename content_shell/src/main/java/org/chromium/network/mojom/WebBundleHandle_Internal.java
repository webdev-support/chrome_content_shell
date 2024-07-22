package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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

class WebBundleHandle_Internal {
  private static final int CLONE_ORDINAL = 0;
  public static final Interface.Manager<WebBundleHandle, WebBundleHandle.Proxy> MANAGER =
      new Interface.Manager<WebBundleHandle, WebBundleHandle.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.WebBundleHandle";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WebBundleHandle.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WebBundleHandle impl) {
          return new Stub(core, impl);
        }

        @Override
        public WebBundleHandle[] buildArray(int size) {
          return new WebBundleHandle[size];
        }
      };
  private static final int ON_WEB_BUNDLE_ERROR_ORDINAL = 1;
  private static final int ON_WEB_BUNDLE_LOAD_FINISHED_ORDINAL = 2;

  WebBundleHandle_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements WebBundleHandle.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void clone(InterfaceRequest<WebBundleHandle> receiver) {
      WebBundleHandleCloneParams _message = new WebBundleHandleCloneParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onWebBundleError(int type, String message) {
      WebBundleHandleOnWebBundleErrorParams _message = new WebBundleHandleOnWebBundleErrorParams();
      _message.type = type;
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onWebBundleLoadFinished(boolean success) {
      WebBundleHandleOnWebBundleLoadFinishedParams _message =
          new WebBundleHandleOnWebBundleLoadFinishedParams();
      _message.success = success;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<WebBundleHandle> {
    Stub(Core core, WebBundleHandle impl) {
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
                WebBundleHandle_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            getImpl()
                .clone(
                    WebBundleHandleCloneParams.deserialize(messageWithHeader.getPayload())
                        .receiver);
            return true;
          case 1:
            WebBundleHandleOnWebBundleErrorParams data =
                WebBundleHandleOnWebBundleErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().onWebBundleError(data.type, data.message);
            return true;
          case 2:
            WebBundleHandleOnWebBundleLoadFinishedParams data2 =
                WebBundleHandleOnWebBundleLoadFinishedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onWebBundleLoadFinished(data2.success);
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
                getCore(), WebBundleHandle_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WebBundleHandleCloneParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<WebBundleHandle> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebBundleHandleCloneParams(int version) {
      super(16, version);
    }

    public WebBundleHandleCloneParams() {
      this(0);
    }

    public static WebBundleHandleCloneParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebBundleHandleCloneParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebBundleHandleCloneParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebBundleHandleCloneParams result = new WebBundleHandleCloneParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }

  static final class WebBundleHandleOnWebBundleErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String message;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebBundleHandleOnWebBundleErrorParams(int version) {
      super(24, version);
    }

    public WebBundleHandleOnWebBundleErrorParams() {
      this(0);
    }

    public static WebBundleHandleOnWebBundleErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebBundleHandleOnWebBundleErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebBundleHandleOnWebBundleErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebBundleHandleOnWebBundleErrorParams result =
            new WebBundleHandleOnWebBundleErrorParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        WebBundleErrorType.validate(readInt);
        result.type = WebBundleErrorType.toKnownValue(result.type);
        result.message = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
      encoder0.encode(this.message, 16, false);
    }
  }

  static final class WebBundleHandleOnWebBundleLoadFinishedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebBundleHandleOnWebBundleLoadFinishedParams(int version) {
      super(16, version);
    }

    public WebBundleHandleOnWebBundleLoadFinishedParams() {
      this(0);
    }

    public static WebBundleHandleOnWebBundleLoadFinishedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebBundleHandleOnWebBundleLoadFinishedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebBundleHandleOnWebBundleLoadFinishedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebBundleHandleOnWebBundleLoadFinishedParams result =
            new WebBundleHandleOnWebBundleLoadFinishedParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }
}
