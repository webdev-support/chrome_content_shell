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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.DataElementChunkedDataPipe;

class ServiceWorkerFetchResponseCallback_Internal {
  public static final Interface.Manager<
          ServiceWorkerFetchResponseCallback, ServiceWorkerFetchResponseCallback.Proxy>
      MANAGER =
          new Interface.Manager<
              ServiceWorkerFetchResponseCallback, ServiceWorkerFetchResponseCallback.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ServiceWorkerFetchResponseCallback";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ServiceWorkerFetchResponseCallback.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ServiceWorkerFetchResponseCallback impl) {
              return new Stub(core, impl);
            }

            @Override
            public ServiceWorkerFetchResponseCallback[] buildArray(int size) {
              return new ServiceWorkerFetchResponseCallback[size];
            }
          };
  private static final int ON_FALLBACK_ORDINAL = 2;
  private static final int ON_RESPONSE_ORDINAL = 0;
  private static final int ON_RESPONSE_STREAM_ORDINAL = 1;

  ServiceWorkerFetchResponseCallback_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ServiceWorkerFetchResponseCallback.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onResponse(FetchApiResponse response, ServiceWorkerFetchEventTiming timing) {
      ServiceWorkerFetchResponseCallbackOnResponseParams _message =
          new ServiceWorkerFetchResponseCallbackOnResponseParams();
      _message.response = response;
      _message.timing = timing;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onResponseStream(
        FetchApiResponse response,
        ServiceWorkerStreamHandle bodyAsStream,
        ServiceWorkerFetchEventTiming timing) {
      ServiceWorkerFetchResponseCallbackOnResponseStreamParams _message =
          new ServiceWorkerFetchResponseCallbackOnResponseStreamParams();
      _message.response = response;
      _message.bodyAsStream = bodyAsStream;
      _message.timing = timing;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onFallback(
        DataElementChunkedDataPipe requestBody, ServiceWorkerFetchEventTiming timing) {
      ServiceWorkerFetchResponseCallbackOnFallbackParams _message =
          new ServiceWorkerFetchResponseCallbackOnFallbackParams();
      _message.requestBody = requestBody;
      _message.timing = timing;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<ServiceWorkerFetchResponseCallback> {
    Stub(Core core, ServiceWorkerFetchResponseCallback impl) {
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
                ServiceWorkerFetchResponseCallback_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ServiceWorkerFetchResponseCallbackOnResponseParams data =
                ServiceWorkerFetchResponseCallbackOnResponseParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onResponse(data.response, data.timing);
            return true;
          case 1:
            ServiceWorkerFetchResponseCallbackOnResponseStreamParams data2 =
                ServiceWorkerFetchResponseCallbackOnResponseStreamParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onResponseStream(data2.response, data2.bodyAsStream, data2.timing);
            return true;
          case 2:
            ServiceWorkerFetchResponseCallbackOnFallbackParams data3 =
                ServiceWorkerFetchResponseCallbackOnFallbackParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onFallback(data3.requestBody, data3.timing);
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
                getCore(),
                ServiceWorkerFetchResponseCallback_Internal.MANAGER,
                messageWithHeader,
                receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ServiceWorkerFetchResponseCallbackOnResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FetchApiResponse response;
    public ServiceWorkerFetchEventTiming timing;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerFetchResponseCallbackOnResponseParams(int version) {
      super(24, version);
    }

    public ServiceWorkerFetchResponseCallbackOnResponseParams() {
      this(0);
    }

    public static ServiceWorkerFetchResponseCallbackOnResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerFetchResponseCallbackOnResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerFetchResponseCallbackOnResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerFetchResponseCallbackOnResponseParams result =
            new ServiceWorkerFetchResponseCallbackOnResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.response = FetchApiResponse.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.timing = ServiceWorkerFetchEventTiming.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.response, 8, false);
      encoder0.encode((Struct) this.timing, 16, false);
    }
  }

  static final class ServiceWorkerFetchResponseCallbackOnResponseStreamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public ServiceWorkerStreamHandle bodyAsStream;
    public FetchApiResponse response;
    public ServiceWorkerFetchEventTiming timing;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerFetchResponseCallbackOnResponseStreamParams(int version) {
      super(32, version);
    }

    public ServiceWorkerFetchResponseCallbackOnResponseStreamParams() {
      this(0);
    }

    public static ServiceWorkerFetchResponseCallbackOnResponseStreamParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerFetchResponseCallbackOnResponseStreamParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerFetchResponseCallbackOnResponseStreamParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerFetchResponseCallbackOnResponseStreamParams result =
            new ServiceWorkerFetchResponseCallbackOnResponseStreamParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.response = FetchApiResponse.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.bodyAsStream = ServiceWorkerStreamHandle.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.timing = ServiceWorkerFetchEventTiming.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.response, 8, false);
      encoder0.encode((Struct) this.bodyAsStream, 16, false);
      encoder0.encode((Struct) this.timing, 24, false);
    }
  }

  static final class ServiceWorkerFetchResponseCallbackOnFallbackParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DataElementChunkedDataPipe requestBody;
    public ServiceWorkerFetchEventTiming timing;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ServiceWorkerFetchResponseCallbackOnFallbackParams(int version) {
      super(24, version);
    }

    public ServiceWorkerFetchResponseCallbackOnFallbackParams() {
      this(0);
    }

    public static ServiceWorkerFetchResponseCallbackOnFallbackParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ServiceWorkerFetchResponseCallbackOnFallbackParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerFetchResponseCallbackOnFallbackParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ServiceWorkerFetchResponseCallbackOnFallbackParams result =
            new ServiceWorkerFetchResponseCallbackOnFallbackParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.requestBody = DataElementChunkedDataPipe.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.timing = ServiceWorkerFetchEventTiming.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.requestBody, 8, true);
      encoder0.encode((Struct) this.timing, 16, false);
    }
  }
}
