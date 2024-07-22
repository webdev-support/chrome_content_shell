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

class TrustedUrlLoaderHeaderClient_Internal {
  public static final Interface.Manager<
          TrustedUrlLoaderHeaderClient, TrustedUrlLoaderHeaderClient.Proxy>
      MANAGER =
          new Interface.Manager<
              TrustedUrlLoaderHeaderClient, TrustedUrlLoaderHeaderClient.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.TrustedURLLoaderHeaderClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public TrustedUrlLoaderHeaderClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, TrustedUrlLoaderHeaderClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public TrustedUrlLoaderHeaderClient[] buildArray(int size) {
              return new TrustedUrlLoaderHeaderClient[size];
            }
          };
  private static final int ON_LOADER_CREATED_ORDINAL = 0;
  private static final int ON_LOADER_FOR_CORS_PREFLIGHT_CREATED_ORDINAL = 1;

  TrustedUrlLoaderHeaderClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements TrustedUrlLoaderHeaderClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onLoaderCreated(int requestId, InterfaceRequest<TrustedHeaderClient> headerClient) {
      TrustedUrlLoaderHeaderClientOnLoaderCreatedParams _message =
          new TrustedUrlLoaderHeaderClientOnLoaderCreatedParams();
      _message.requestId = requestId;
      _message.headerClient = headerClient;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onLoaderForCorsPreflightCreated(
        UrlRequest request, InterfaceRequest<TrustedHeaderClient> headerClient) {
      TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams _message =
          new TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams();
      _message.request = request;
      _message.headerClient = headerClient;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<TrustedUrlLoaderHeaderClient> {
    Stub(Core core, TrustedUrlLoaderHeaderClient impl) {
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
                TrustedUrlLoaderHeaderClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            TrustedUrlLoaderHeaderClientOnLoaderCreatedParams data =
                TrustedUrlLoaderHeaderClientOnLoaderCreatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onLoaderCreated(data.requestId, data.headerClient);
            return true;
          case 1:
            TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams data2 =
                TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onLoaderForCorsPreflightCreated(data2.request, data2.headerClient);
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
                TrustedUrlLoaderHeaderClient_Internal.MANAGER,
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

  static final class TrustedUrlLoaderHeaderClientOnLoaderCreatedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<TrustedHeaderClient> headerClient;
    public int requestId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustedUrlLoaderHeaderClientOnLoaderCreatedParams(int version) {
      super(16, version);
    }

    public TrustedUrlLoaderHeaderClientOnLoaderCreatedParams() {
      this(0);
    }

    public static TrustedUrlLoaderHeaderClientOnLoaderCreatedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static TrustedUrlLoaderHeaderClientOnLoaderCreatedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustedUrlLoaderHeaderClientOnLoaderCreatedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustedUrlLoaderHeaderClientOnLoaderCreatedParams result =
            new TrustedUrlLoaderHeaderClientOnLoaderCreatedParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        result.headerClient = decoder0.readInterfaceRequest(12, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode((InterfaceRequest) this.headerClient, 12, false);
    }
  }

  static final class TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<TrustedHeaderClient> headerClient;
    public UrlRequest request;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams(int version) {
      super(24, version);
    }

    public TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams() {
      this(0);
    }

    public static TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams result =
            new TrustedUrlLoaderHeaderClientOnLoaderForCorsPreflightCreatedParams(
                elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.request = UrlRequest.decode(decoder1);
        result.headerClient = decoder0.readInterfaceRequest(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.request, 8, false);
      encoder0.encode((InterfaceRequest) this.headerClient, 16, false);
    }
  }
}
