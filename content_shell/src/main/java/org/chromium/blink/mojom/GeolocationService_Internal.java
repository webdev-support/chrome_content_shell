package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.Geolocation;
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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class GeolocationService_Internal {
  private static final int CREATE_GEOLOCATION_ORDINAL = 0;
  public static final Interface.Manager<GeolocationService, GeolocationService.Proxy> MANAGER =
      new Interface.Manager<GeolocationService, GeolocationService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.GeolocationService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public GeolocationService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, GeolocationService impl) {
          return new Stub(core, impl);
        }

        @Override
        public GeolocationService[] buildArray(int size) {
          return new GeolocationService[size];
        }
      };

  GeolocationService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements GeolocationService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createGeolocation(
        InterfaceRequest<Geolocation> receiver,
        boolean userGesture,
        CreateGeolocation_Response callback) {
      GeolocationServiceCreateGeolocationParams _message =
          new GeolocationServiceCreateGeolocationParams();
      _message.receiver = receiver;
      _message.userGesture = userGesture;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new GeolocationServiceCreateGeolocationResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<GeolocationService> {
    Stub(Core core, GeolocationService impl) {
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
                GeolocationService_Internal.MANAGER, messageWithHeader);
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
                getCore(), GeolocationService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            GeolocationServiceCreateGeolocationParams data =
                GeolocationServiceCreateGeolocationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createGeolocation(
                    data.receiver,
                    data.userGesture,
                    new GeolocationServiceCreateGeolocationResponseParamsProxyToResponder(
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

  static final class GeolocationServiceCreateGeolocationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<Geolocation> receiver;
    public boolean userGesture;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GeolocationServiceCreateGeolocationParams(int version) {
      super(16, version);
    }

    public GeolocationServiceCreateGeolocationParams() {
      this(0);
    }

    public static GeolocationServiceCreateGeolocationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GeolocationServiceCreateGeolocationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GeolocationServiceCreateGeolocationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GeolocationServiceCreateGeolocationParams result =
            new GeolocationServiceCreateGeolocationParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        result.userGesture = decoder0.readBoolean(12, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
      encoder0.encode(this.userGesture, 12, 0);
    }
  }

  static final class GeolocationServiceCreateGeolocationResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int status;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GeolocationServiceCreateGeolocationResponseParams(int version) {
      super(16, version);
    }

    public GeolocationServiceCreateGeolocationResponseParams() {
      this(0);
    }

    public static GeolocationServiceCreateGeolocationResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GeolocationServiceCreateGeolocationResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GeolocationServiceCreateGeolocationResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GeolocationServiceCreateGeolocationResponseParams result =
            new GeolocationServiceCreateGeolocationResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.status = readInt;
        PermissionStatus.validate(readInt);
        result.status = PermissionStatus.toKnownValue(result.status);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.status, 8);
    }
  }

  static class GeolocationServiceCreateGeolocationResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final GeolocationService.CreateGeolocation_Response mCallback;

    GeolocationServiceCreateGeolocationResponseParamsForwardToCallback(
        GeolocationService.CreateGeolocation_Response callback) {
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
        GeolocationServiceCreateGeolocationResponseParams response =
            GeolocationServiceCreateGeolocationResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.status);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class GeolocationServiceCreateGeolocationResponseParamsProxyToResponder
      implements GeolocationService.CreateGeolocation_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    GeolocationServiceCreateGeolocationResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int status) {
      GeolocationServiceCreateGeolocationResponseParams _response =
          new GeolocationServiceCreateGeolocationResponseParams();
      _response.status = status;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
