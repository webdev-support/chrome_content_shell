package org.chromium.device.mojom;

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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

class Geolocation_Internal {
  public static final Interface.Manager<Geolocation, Geolocation.Proxy> MANAGER =
      new Interface.Manager<Geolocation, Geolocation.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.Geolocation";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Geolocation.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, Geolocation impl) {
          return new Stub(core, impl);
        }

        @Override
        public Geolocation[] buildArray(int size) {
          return new Geolocation[size];
        }
      };
  private static final int QUERY_NEXT_POSITION_ORDINAL = 1;
  private static final int SET_HIGH_ACCURACY_ORDINAL = 0;

  Geolocation_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements Geolocation.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setHighAccuracy(boolean highAccuracy) {
      GeolocationSetHighAccuracyParams _message = new GeolocationSetHighAccuracyParams();
      _message.highAccuracy = highAccuracy;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void queryNextPosition(QueryNextPosition_Response callback) {
      GeolocationQueryNextPositionParams _message = new GeolocationQueryNextPositionParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new GeolocationQueryNextPositionResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<Geolocation> {
    Stub(Core core, Geolocation impl) {
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
                Geolocation_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            GeolocationSetHighAccuracyParams data =
                GeolocationSetHighAccuracyParams.deserialize(messageWithHeader.getPayload());
            getImpl().setHighAccuracy(data.highAccuracy);
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
                getCore(), Geolocation_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
          default:
            return false;
          case 1:
            GeolocationQueryNextPositionParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .queryNextPosition(
                    new GeolocationQueryNextPositionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class GeolocationSetHighAccuracyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean highAccuracy;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GeolocationSetHighAccuracyParams(int version) {
      super(16, version);
    }

    public GeolocationSetHighAccuracyParams() {
      this(0);
    }

    public static GeolocationSetHighAccuracyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GeolocationSetHighAccuracyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GeolocationSetHighAccuracyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GeolocationSetHighAccuracyParams result =
            new GeolocationSetHighAccuracyParams(elementsOrVersion);
        result.highAccuracy = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.highAccuracy, 8, 0);
    }
  }

  static final class GeolocationQueryNextPositionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GeolocationQueryNextPositionParams(int version) {
      super(8, version);
    }

    public GeolocationQueryNextPositionParams() {
      this(0);
    }

    public static GeolocationQueryNextPositionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GeolocationQueryNextPositionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GeolocationQueryNextPositionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GeolocationQueryNextPositionParams result =
            new GeolocationQueryNextPositionParams(elementsOrVersion);
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

  static final class GeolocationQueryNextPositionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public GeopositionResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private GeolocationQueryNextPositionResponseParams(int version) {
      super(24, version);
    }

    public GeolocationQueryNextPositionResponseParams() {
      this(0);
    }

    public static GeolocationQueryNextPositionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static GeolocationQueryNextPositionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static GeolocationQueryNextPositionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        GeolocationQueryNextPositionResponseParams result =
            new GeolocationQueryNextPositionResponseParams(elementsOrVersion);
        result.result = GeopositionResult.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.result, 8, false);
    }
  }

  static class GeolocationQueryNextPositionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final Geolocation.QueryNextPosition_Response mCallback;

    GeolocationQueryNextPositionResponseParamsForwardToCallback(
        Geolocation.QueryNextPosition_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        GeolocationQueryNextPositionResponseParams response =
            GeolocationQueryNextPositionResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class GeolocationQueryNextPositionResponseParamsProxyToResponder
      implements Geolocation.QueryNextPosition_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    GeolocationQueryNextPositionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(GeopositionResult result) {
      GeolocationQueryNextPositionResponseParams _response =
          new GeolocationQueryNextPositionResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
