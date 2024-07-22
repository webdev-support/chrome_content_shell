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
import org.chromium.network.mojom.WebTransportCertificateFingerprint;
import org.chromium.network.mojom.WebTransportHandshakeClient;
import org.chromium.url.mojom.Url;

class WebTransportConnector_Internal {
  private static final int CONNECT_ORDINAL = 0;
  public static final Interface.Manager<WebTransportConnector, WebTransportConnector.Proxy>
      MANAGER =
          new Interface.Manager<WebTransportConnector, WebTransportConnector.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.WebTransportConnector";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public WebTransportConnector.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, WebTransportConnector impl) {
              return new Stub(core, impl);
            }

            @Override
            public WebTransportConnector[] buildArray(int size) {
              return new WebTransportConnector[size];
            }
          };

  WebTransportConnector_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements WebTransportConnector.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void connect(
        Url url,
        WebTransportCertificateFingerprint[] fingerprints,
        WebTransportHandshakeClient client) {
      WebTransportConnectorConnectParams _message = new WebTransportConnectorConnectParams();
      _message.url = url;
      _message.fingerprints = fingerprints;
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<WebTransportConnector> {
    Stub(Core core, WebTransportConnector impl) {
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
                WebTransportConnector_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WebTransportConnectorConnectParams data =
                WebTransportConnectorConnectParams.deserialize(messageWithHeader.getPayload());
            getImpl().connect(data.url, data.fingerprints, data.client);
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
                getCore(), WebTransportConnector_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WebTransportConnectorConnectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public WebTransportHandshakeClient client;
    public WebTransportCertificateFingerprint[] fingerprints;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WebTransportConnectorConnectParams(int version) {
      super(32, version);
    }

    public WebTransportConnectorConnectParams() {
      this(0);
    }

    public static WebTransportConnectorConnectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WebTransportConnectorConnectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WebTransportConnectorConnectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WebTransportConnectorConnectParams result =
            new WebTransportConnectorConnectParams(elementsOrVersion);
        result.url = Url.decode(decoder0.readPointer(8, false));
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.fingerprints = new WebTransportCertificateFingerprint[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.fingerprints[i1] = WebTransportCertificateFingerprint.decode(decoder2);
        }
        result.client =
            (WebTransportHandshakeClient)
                decoder0.readServiceInterface(24, false, WebTransportHandshakeClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      WebTransportCertificateFingerprint[] webTransportCertificateFingerprintArr =
          this.fingerprints;
      if (webTransportCertificateFingerprintArr == null) {
        encoder0.encodeNullPointer(16, false);
      } else {
        Encoder encoder1 =
            encoder0.encodePointerArray(webTransportCertificateFingerprintArr.length, 16, -1);
        int i0 = 0;
        while (true) {
          WebTransportCertificateFingerprint[] webTransportCertificateFingerprintArr2 =
              this.fingerprints;
          if (i0 >= webTransportCertificateFingerprintArr2.length) {
            break;
          }
          encoder1.encode((Struct) webTransportCertificateFingerprintArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.client, 24, false, WebTransportHandshakeClient.MANAGER);
    }
  }
}
