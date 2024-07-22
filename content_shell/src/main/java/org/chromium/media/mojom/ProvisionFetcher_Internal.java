package org.chromium.media.mojom;

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

class ProvisionFetcher_Internal {
  public static final Interface.Manager<ProvisionFetcher, ProvisionFetcher.Proxy> MANAGER =
      new Interface.Manager<ProvisionFetcher, ProvisionFetcher.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.ProvisionFetcher";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ProvisionFetcher.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ProvisionFetcher impl) {
          return new Stub(core, impl);
        }

        @Override
        public ProvisionFetcher[] buildArray(int size) {
          return new ProvisionFetcher[size];
        }
      };
  private static final int RETRIEVE_ORDINAL = 0;

  ProvisionFetcher_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ProvisionFetcher.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void retrieve(Url defaultUrl, String requestData, Retrieve_Response callback) {
      ProvisionFetcherRetrieveParams _message = new ProvisionFetcherRetrieveParams();
      _message.defaultUrl = defaultUrl;
      _message.requestData = requestData;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ProvisionFetcherRetrieveResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<ProvisionFetcher> {
    Stub(Core core, ProvisionFetcher impl) {
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
                ProvisionFetcher_Internal.MANAGER, messageWithHeader);
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
                getCore(), ProvisionFetcher_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            ProvisionFetcherRetrieveParams data =
                ProvisionFetcherRetrieveParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .retrieve(
                    data.defaultUrl,
                    data.requestData,
                    new ProvisionFetcherRetrieveResponseParamsProxyToResponder(
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

  static final class ProvisionFetcherRetrieveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Url defaultUrl;
    public String requestData;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProvisionFetcherRetrieveParams(int version) {
      super(24, version);
    }

    public ProvisionFetcherRetrieveParams() {
      this(0);
    }

    public static ProvisionFetcherRetrieveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProvisionFetcherRetrieveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProvisionFetcherRetrieveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProvisionFetcherRetrieveParams result =
            new ProvisionFetcherRetrieveParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.defaultUrl = Url.decode(decoder1);
        result.requestData = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.defaultUrl, 8, false);
      encoder0.encode(this.requestData, 16, false);
    }
  }

  static final class ProvisionFetcherRetrieveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String response;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProvisionFetcherRetrieveResponseParams(int version) {
      super(24, version);
    }

    public ProvisionFetcherRetrieveResponseParams() {
      this(0);
    }

    public static ProvisionFetcherRetrieveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProvisionFetcherRetrieveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProvisionFetcherRetrieveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProvisionFetcherRetrieveResponseParams result =
            new ProvisionFetcherRetrieveResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        result.response = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
      encoder0.encode(this.response, 16, false);
    }
  }

  static class ProvisionFetcherRetrieveResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ProvisionFetcher.Retrieve_Response mCallback;

    ProvisionFetcherRetrieveResponseParamsForwardToCallback(
        ProvisionFetcher.Retrieve_Response callback) {
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
        ProvisionFetcherRetrieveResponseParams response =
            ProvisionFetcherRetrieveResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result, response.response);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ProvisionFetcherRetrieveResponseParamsProxyToResponder
      implements ProvisionFetcher.Retrieve_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ProvisionFetcherRetrieveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result, String response) {
      ProvisionFetcherRetrieveResponseParams _response =
          new ProvisionFetcherRetrieveResponseParams();
      _response.result = result;
      _response.response = response;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
