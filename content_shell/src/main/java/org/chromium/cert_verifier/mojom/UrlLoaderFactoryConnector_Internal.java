package org.chromium.cert_verifier.mojom;

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
import org.chromium.network.mojom.UrlLoaderFactory;

class UrlLoaderFactoryConnector_Internal {
  private static final int CREATE_URL_LOADER_FACTORY_ORDINAL = 0;
  public static final Interface.Manager<UrlLoaderFactoryConnector, UrlLoaderFactoryConnector.Proxy>
      MANAGER =
          new Interface.Manager<UrlLoaderFactoryConnector, UrlLoaderFactoryConnector.Proxy>() {
            @Override
            public String getName() {
              return "cert_verifier.mojom.URLLoaderFactoryConnector";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public UrlLoaderFactoryConnector.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, UrlLoaderFactoryConnector impl) {
              return new Stub(core, impl);
            }

            @Override
            public UrlLoaderFactoryConnector[] buildArray(int size) {
              return new UrlLoaderFactoryConnector[size];
            }
          };

  UrlLoaderFactoryConnector_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements UrlLoaderFactoryConnector.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createUrlLoaderFactory(InterfaceRequest<UrlLoaderFactory> urlLoaderFactory) {
      UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams _message =
          new UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams();
      _message.urlLoaderFactory = urlLoaderFactory;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<UrlLoaderFactoryConnector> {
    Stub(Core core, UrlLoaderFactoryConnector impl) {
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
                UrlLoaderFactoryConnector_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams data =
                UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().createUrlLoaderFactory(data.urlLoaderFactory);
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
                getCore(), UrlLoaderFactoryConnector_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<UrlLoaderFactory> urlLoaderFactory;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams(int version) {
      super(16, version);
    }

    public UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams() {
      this(0);
    }

    public static UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams result =
            new UrlLoaderFactoryConnectorCreateUrlLoaderFactoryParams(elementsOrVersion);
        result.urlLoaderFactory = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.urlLoaderFactory, 8, false);
    }
  }
}
