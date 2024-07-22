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

class DigitalIdentityRequest_Internal {
  private static final int ABORT_ORDINAL = 1;
  public static final Interface.Manager<DigitalIdentityRequest, DigitalIdentityRequest.Proxy>
      MANAGER =
          new Interface.Manager<DigitalIdentityRequest, DigitalIdentityRequest.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.DigitalIdentityRequest";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public DigitalIdentityRequest.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, DigitalIdentityRequest impl) {
              return new Stub(core, impl);
            }

            @Override
            public DigitalIdentityRequest[] buildArray(int size) {
              return new DigitalIdentityRequest[size];
            }
          };
  private static final int REQUEST_ORDINAL = 0;

  DigitalIdentityRequest_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements DigitalIdentityRequest.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void request(
        DigitalCredentialProvider digitalCredentialProvider, Request_Response callback) {
      DigitalIdentityRequestRequestParams _message = new DigitalIdentityRequestRequestParams();
      _message.digitalCredentialProvider = digitalCredentialProvider;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new DigitalIdentityRequestRequestResponseParamsForwardToCallback(callback));
    }

    @Override
    public void abort() {
      DigitalIdentityRequestAbortParams _message = new DigitalIdentityRequestAbortParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<DigitalIdentityRequest> {
    Stub(Core core, DigitalIdentityRequest impl) {
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
                DigitalIdentityRequest_Internal.MANAGER, messageWithHeader);
          case 1:
            DigitalIdentityRequestAbortParams.deserialize(messageWithHeader.getPayload());
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
                getCore(), DigitalIdentityRequest_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            DigitalIdentityRequestRequestParams data =
                DigitalIdentityRequestRequestParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .request(
                    data.digitalCredentialProvider,
                    new DigitalIdentityRequestRequestResponseParamsProxyToResponder(
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

  static final class DigitalIdentityRequestRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DigitalCredentialProvider digitalCredentialProvider;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalIdentityRequestRequestParams(int version) {
      super(16, version);
    }

    public DigitalIdentityRequestRequestParams() {
      this(0);
    }

    public static DigitalIdentityRequestRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalIdentityRequestRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalIdentityRequestRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalIdentityRequestRequestParams result =
            new DigitalIdentityRequestRequestParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.digitalCredentialProvider = DigitalCredentialProvider.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.digitalCredentialProvider, 8, false);
    }
  }

  static final class DigitalIdentityRequestRequestResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;
    public String token;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalIdentityRequestRequestResponseParams(int version) {
      super(24, version);
    }

    public DigitalIdentityRequestRequestResponseParams() {
      this(0);
    }

    public static DigitalIdentityRequestRequestResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalIdentityRequestRequestResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalIdentityRequestRequestResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalIdentityRequestRequestResponseParams result =
            new DigitalIdentityRequestRequestResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        RequestDigitalIdentityStatus.validate(readInt);
        result.status = RequestDigitalIdentityStatus.toKnownValue(result.status);
        result.token = decoder0.readString(16, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
      encoder0.encode(this.token, 16, true);
    }
  }

  static class DigitalIdentityRequestRequestResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final DigitalIdentityRequest.Request_Response mCallback;

    DigitalIdentityRequestRequestResponseParamsForwardToCallback(
        DigitalIdentityRequest.Request_Response callback) {
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
        DigitalIdentityRequestRequestResponseParams response =
            DigitalIdentityRequestRequestResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.status, response.token);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DigitalIdentityRequestRequestResponseParamsProxyToResponder
      implements DigitalIdentityRequest.Request_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DigitalIdentityRequestRequestResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status, String token) {
      DigitalIdentityRequestRequestResponseParams _response =
          new DigitalIdentityRequestRequestResponseParams();
      _response.status = status;
      _response.token = token;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DigitalIdentityRequestAbortParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DigitalIdentityRequestAbortParams(int version) {
      super(8, version);
    }

    public DigitalIdentityRequestAbortParams() {
      this(0);
    }

    public static DigitalIdentityRequestAbortParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DigitalIdentityRequestAbortParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DigitalIdentityRequestAbortParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DigitalIdentityRequestAbortParams result =
            new DigitalIdentityRequestAbortParams(elementsOrVersion);
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
