package org.chromium.cert_verifier.mojom;

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
import org.chromium.network.mojom.NetLogSource;
import org.chromium.network.mojom.UrlLoaderFactory;

class CertVerifierService_Internal {
  private static final int ENABLE_NETWORK_ACCESS_ORDINAL = 0;
  public static final Interface.Manager<CertVerifierService, CertVerifierService.Proxy> MANAGER =
      new Interface.Manager<CertVerifierService, CertVerifierService.Proxy>() {
        @Override
        public String getName() {
          return "cert_verifier.mojom.CertVerifierService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CertVerifierService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CertVerifierService impl) {
          return new Stub(core, impl);
        }

        @Override
        public CertVerifierService[] buildArray(int size) {
          return new CertVerifierService[size];
        }
      };
  private static final int SET_CONFIG_ORDINAL = 2;
  private static final int VERIFY_ORDINAL = 1;

  CertVerifierService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CertVerifierService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void enableNetworkAccess(
        UrlLoaderFactory urlLoaderFactory, UrlLoaderFactoryConnector reconnector) {
      CertVerifierServiceEnableNetworkAccessParams _message =
          new CertVerifierServiceEnableNetworkAccessParams();
      _message.urlLoaderFactory = urlLoaderFactory;
      _message.reconnector = reconnector;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void verify(
        RequestParams params, NetLogSource netLogSource, CertVerifierRequest certVerifierRequest) {
      CertVerifierServiceVerifyParams _message = new CertVerifierServiceVerifyParams();
      _message.params = params;
      _message.netLogSource = netLogSource;
      _message.certVerifierRequest = certVerifierRequest;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setConfig(CertVerifierConfig config) {
      CertVerifierServiceSetConfigParams _message = new CertVerifierServiceSetConfigParams();
      _message.config = config;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<CertVerifierService> {
    Stub(Core core, CertVerifierService impl) {
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
                CertVerifierService_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            CertVerifierServiceEnableNetworkAccessParams data =
                CertVerifierServiceEnableNetworkAccessParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().enableNetworkAccess(data.urlLoaderFactory, data.reconnector);
            return true;
          case 1:
            CertVerifierServiceVerifyParams data2 =
                CertVerifierServiceVerifyParams.deserialize(messageWithHeader.getPayload());
            getImpl().verify(data2.params, data2.netLogSource, data2.certVerifierRequest);
            return true;
          case 2:
            getImpl()
                .setConfig(
                    CertVerifierServiceSetConfigParams.deserialize(messageWithHeader.getPayload())
                        .config);
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
                getCore(), CertVerifierService_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class CertVerifierServiceEnableNetworkAccessParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public UrlLoaderFactoryConnector reconnector;
    public UrlLoaderFactory urlLoaderFactory;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CertVerifierServiceEnableNetworkAccessParams(int version) {
      super(24, version);
    }

    public CertVerifierServiceEnableNetworkAccessParams() {
      this(0);
    }

    public static CertVerifierServiceEnableNetworkAccessParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CertVerifierServiceEnableNetworkAccessParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CertVerifierServiceEnableNetworkAccessParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CertVerifierServiceEnableNetworkAccessParams result =
            new CertVerifierServiceEnableNetworkAccessParams(elementsOrVersion);
        result.urlLoaderFactory =
            (UrlLoaderFactory) decoder0.readServiceInterface(8, false, UrlLoaderFactory.MANAGER);
        result.reconnector =
            (UrlLoaderFactoryConnector)
                decoder0.readServiceInterface(16, true, UrlLoaderFactoryConnector.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.urlLoaderFactory, 8, false, UrlLoaderFactory.MANAGER);
      encoder0.encode(this.reconnector, 16, true, UrlLoaderFactoryConnector.MANAGER);
    }
  }

  static final class CertVerifierServiceVerifyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public CertVerifierRequest certVerifierRequest;
    public NetLogSource netLogSource;
    public RequestParams params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CertVerifierServiceVerifyParams(int version) {
      super(32, version);
    }

    public CertVerifierServiceVerifyParams() {
      this(0);
    }

    public static CertVerifierServiceVerifyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CertVerifierServiceVerifyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CertVerifierServiceVerifyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CertVerifierServiceVerifyParams result =
            new CertVerifierServiceVerifyParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = RequestParams.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.netLogSource = NetLogSource.decode(decoder12);
        result.certVerifierRequest =
            (CertVerifierRequest)
                decoder0.readServiceInterface(24, false, CertVerifierRequest.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.params, 8, false);
      encoder0.encode((Struct) this.netLogSource, 16, false);
      encoder0.encode(this.certVerifierRequest, 24, false, CertVerifierRequest.MANAGER);
    }
  }

  static final class CertVerifierServiceSetConfigParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CertVerifierConfig config;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CertVerifierServiceSetConfigParams(int version) {
      super(16, version);
    }

    public CertVerifierServiceSetConfigParams() {
      this(0);
    }

    public static CertVerifierServiceSetConfigParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CertVerifierServiceSetConfigParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CertVerifierServiceSetConfigParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CertVerifierServiceSetConfigParams result =
            new CertVerifierServiceSetConfigParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.config = CertVerifierConfig.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.config, 8, false);
    }
  }
}
