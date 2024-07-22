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

class WebOtpService_Internal {
  private static final int ABORT_ORDINAL = 1;
  public static final Interface.Manager<WebOtpService, WebOtpService.Proxy> MANAGER =
      new Interface.Manager<WebOtpService, WebOtpService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.WebOTPService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WebOtpService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WebOtpService impl) {
          return new Stub(core, impl);
        }

        @Override
        public WebOtpService[] buildArray(int size) {
          return new WebOtpService[size];
        }
      };
  private static final int RECEIVE_ORDINAL = 0;

  WebOtpService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements WebOtpService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void receive(Receive_Response callback) {
      WebOtpServiceReceiveParams _message = new WebOtpServiceReceiveParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new WebOtpServiceReceiveResponseParamsForwardToCallback(callback));
    }

    @Override
    public void abort() {
      WebOtpServiceAbortParams _message = new WebOtpServiceAbortParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<WebOtpService> {
    Stub(Core core, WebOtpService impl) {
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
                WebOtpService_Internal.MANAGER, messageWithHeader);
          case 1:
            WebOtpServiceAbortParams.deserialize(messageWithHeader.getPayload());
            getImpl().abort();
            return true;
          default:
            return false;
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
                getCore(), WebOtpService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            WebOtpServiceReceiveParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .receive(
                    new WebOtpServiceReceiveResponseParamsProxyToResponder(
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

  static final class WebOtpServiceReceiveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebOtpServiceReceiveParams(int version) {
      super(8, version);
    }

    public WebOtpServiceReceiveParams() {
      this(0);
    }

    public static WebOtpServiceReceiveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebOtpServiceReceiveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebOtpServiceReceiveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebOtpServiceReceiveParams result = new WebOtpServiceReceiveParams(elementsOrVersion);
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

  static final class WebOtpServiceReceiveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String otp;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebOtpServiceReceiveResponseParams(int version) {
      super(24, version);
    }

    public WebOtpServiceReceiveResponseParams() {
      this(0);
    }

    public static WebOtpServiceReceiveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebOtpServiceReceiveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebOtpServiceReceiveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebOtpServiceReceiveResponseParams result =
            new WebOtpServiceReceiveResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        SmsStatus.validate(readInt);
        result.status = SmsStatus.toKnownValue(result.status);
        result.otp = decoder0.readString(16, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode(this.otp, 16, true);
    }
  }

  static class WebOtpServiceReceiveResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final WebOtpService.Receive_Response mCallback;

    WebOtpServiceReceiveResponseParamsForwardToCallback(WebOtpService.Receive_Response callback) {
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
        WebOtpServiceReceiveResponseParams response =
            WebOtpServiceReceiveResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status, response.otp);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WebOtpServiceReceiveResponseParamsProxyToResponder
      implements WebOtpService.Receive_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WebOtpServiceReceiveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status, String otp) {
      WebOtpServiceReceiveResponseParams _response = new WebOtpServiceReceiveResponseParams();
      _response.status = status;
      _response.otp = otp;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WebOtpServiceAbortParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebOtpServiceAbortParams(int version) {
      super(8, version);
    }

    public WebOtpServiceAbortParams() {
      this(0);
    }

    public static WebOtpServiceAbortParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebOtpServiceAbortParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebOtpServiceAbortParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebOtpServiceAbortParams result = new WebOtpServiceAbortParams(elementsOrVersion);
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
