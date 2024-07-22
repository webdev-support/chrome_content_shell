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

class CertVerifierServiceClient_Internal {
  public static final Interface.Manager<CertVerifierServiceClient, CertVerifierServiceClient.Proxy>
      MANAGER =
          new Interface.Manager<CertVerifierServiceClient, CertVerifierServiceClient.Proxy>() {
            @Override
            public String getName() {
              return "cert_verifier.mojom.CertVerifierServiceClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public CertVerifierServiceClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, CertVerifierServiceClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public CertVerifierServiceClient[] buildArray(int size) {
              return new CertVerifierServiceClient[size];
            }
          };
  private static final int ON_CERT_VERIFIER_CHANGED_ORDINAL = 0;

  CertVerifierServiceClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CertVerifierServiceClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onCertVerifierChanged() {
      CertVerifierServiceClientOnCertVerifierChangedParams _message =
          new CertVerifierServiceClientOnCertVerifierChangedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<CertVerifierServiceClient> {
    Stub(Core core, CertVerifierServiceClient impl) {
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
                CertVerifierServiceClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            CertVerifierServiceClientOnCertVerifierChangedParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().onCertVerifierChanged();
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
                getCore(), CertVerifierServiceClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class CertVerifierServiceClientOnCertVerifierChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CertVerifierServiceClientOnCertVerifierChangedParams(int version) {
      super(8, version);
    }

    public CertVerifierServiceClientOnCertVerifierChangedParams() {
      this(0);
    }

    public static CertVerifierServiceClientOnCertVerifierChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static CertVerifierServiceClientOnCertVerifierChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CertVerifierServiceClientOnCertVerifierChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CertVerifierServiceClientOnCertVerifierChangedParams result =
            new CertVerifierServiceClientOnCertVerifierChangedParams(elementsOrVersion);
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
