package org.chromium.network.mojom;

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

class ClientCertificateResponder_Internal {
  private static final int CANCEL_REQUEST_ORDINAL = 2;
  private static final int CONTINUE_WITHOUT_CERTIFICATE_ORDINAL = 1;
  private static final int CONTINUE_WITH_CERTIFICATE_ORDINAL = 0;
  public static final Interface.Manager<
          ClientCertificateResponder, ClientCertificateResponder.Proxy>
      MANAGER =
          new Interface.Manager<ClientCertificateResponder, ClientCertificateResponder.Proxy>() {
            @Override
            public String getName() {
              return "network.mojom.ClientCertificateResponder";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ClientCertificateResponder.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ClientCertificateResponder impl) {
              return new Stub(core, impl);
            }

            @Override
            public ClientCertificateResponder[] buildArray(int size) {
              return new ClientCertificateResponder[size];
            }
          };

  ClientCertificateResponder_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ClientCertificateResponder.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void continueWithCertificate(
        X509Certificate x509Certificate,
        String providerName,
        short[] algorithmPreferences,
        SslPrivateKey sslPrivateKey) {
      ClientCertificateResponderContinueWithCertificateParams _message =
          new ClientCertificateResponderContinueWithCertificateParams();
      _message.x509Certificate = x509Certificate;
      _message.providerName = providerName;
      _message.algorithmPreferences = algorithmPreferences;
      _message.sslPrivateKey = sslPrivateKey;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void continueWithoutCertificate() {
      ClientCertificateResponderContinueWithoutCertificateParams _message =
          new ClientCertificateResponderContinueWithoutCertificateParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void cancelRequest() {
      ClientCertificateResponderCancelRequestParams _message =
          new ClientCertificateResponderCancelRequestParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<ClientCertificateResponder> {
    Stub(Core core, ClientCertificateResponder impl) {
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
                ClientCertificateResponder_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ClientCertificateResponderContinueWithCertificateParams data =
                ClientCertificateResponderContinueWithCertificateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .continueWithCertificate(
                    data.x509Certificate,
                    data.providerName,
                    data.algorithmPreferences,
                    data.sslPrivateKey);
            return true;
          case 1:
            ClientCertificateResponderContinueWithoutCertificateParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().continueWithoutCertificate();
            return true;
          case 2:
            ClientCertificateResponderCancelRequestParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().cancelRequest();
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
                ClientCertificateResponder_Internal.MANAGER,
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

  static final class ClientCertificateResponderContinueWithCertificateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public short[] algorithmPreferences;
    public String providerName;
    public SslPrivateKey sslPrivateKey;
    public X509Certificate x509Certificate;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClientCertificateResponderContinueWithCertificateParams(int version) {
      super(40, version);
    }

    public ClientCertificateResponderContinueWithCertificateParams() {
      this(0);
    }

    public static ClientCertificateResponderContinueWithCertificateParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ClientCertificateResponderContinueWithCertificateParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClientCertificateResponderContinueWithCertificateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClientCertificateResponderContinueWithCertificateParams result =
            new ClientCertificateResponderContinueWithCertificateParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.x509Certificate = X509Certificate.decode(decoder1);
        result.providerName = decoder0.readString(16, false);
        result.algorithmPreferences = decoder0.readShorts(24, 0, -1);
        result.sslPrivateKey =
            (SslPrivateKey) decoder0.readServiceInterface(32, false, SslPrivateKey.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.x509Certificate, 8, false);
      encoder0.encode(this.providerName, 16, false);
      encoder0.encode(this.algorithmPreferences, 24, 0, -1);
      encoder0.encode(this.sslPrivateKey, 32, false, SslPrivateKey.MANAGER);
    }
  }

  static final class ClientCertificateResponderContinueWithoutCertificateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClientCertificateResponderContinueWithoutCertificateParams(int version) {
      super(8, version);
    }

    public ClientCertificateResponderContinueWithoutCertificateParams() {
      this(0);
    }

    public static ClientCertificateResponderContinueWithoutCertificateParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ClientCertificateResponderContinueWithoutCertificateParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClientCertificateResponderContinueWithoutCertificateParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClientCertificateResponderContinueWithoutCertificateParams result =
            new ClientCertificateResponderContinueWithoutCertificateParams(elementsOrVersion);
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

  static final class ClientCertificateResponderCancelRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClientCertificateResponderCancelRequestParams(int version) {
      super(8, version);
    }

    public ClientCertificateResponderCancelRequestParams() {
      this(0);
    }

    public static ClientCertificateResponderCancelRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClientCertificateResponderCancelRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClientCertificateResponderCancelRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClientCertificateResponderCancelRequestParams result =
            new ClientCertificateResponderCancelRequestParams(elementsOrVersion);
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
