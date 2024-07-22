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
import org.chromium.network.mojom.CertVerifyResult;

class CertVerifierRequest_Internal {
  private static final int COMPLETE_ORDINAL = 0;
  public static final Interface.Manager<CertVerifierRequest, CertVerifierRequest.Proxy> MANAGER =
      new Interface.Manager<CertVerifierRequest, CertVerifierRequest.Proxy>() {
        @Override
        public String getName() {
          return "cert_verifier.mojom.CertVerifierRequest";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CertVerifierRequest.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CertVerifierRequest impl) {
          return new Stub(core, impl);
        }

        @Override
        public CertVerifierRequest[] buildArray(int size) {
          return new CertVerifierRequest[size];
        }
      };

  CertVerifierRequest_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CertVerifierRequest.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void complete(CertVerifyResult result, int netError) {
      CertVerifierRequestCompleteParams _message = new CertVerifierRequestCompleteParams();
      _message.result = result;
      _message.netError = netError;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<CertVerifierRequest> {
    Stub(Core core, CertVerifierRequest impl) {
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
                CertVerifierRequest_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            CertVerifierRequestCompleteParams data =
                CertVerifierRequestCompleteParams.deserialize(messageWithHeader.getPayload());
            getImpl().complete(data.result, data.netError);
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
                getCore(), CertVerifierRequest_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class CertVerifierRequestCompleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int netError;
    public CertVerifyResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CertVerifierRequestCompleteParams(int version) {
      super(24, version);
    }

    public CertVerifierRequestCompleteParams() {
      this(0);
    }

    public static CertVerifierRequestCompleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CertVerifierRequestCompleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CertVerifierRequestCompleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CertVerifierRequestCompleteParams result =
            new CertVerifierRequestCompleteParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = CertVerifyResult.decode(decoder1);
        result.netError = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
      encoder0.encode(this.netError, 16);
    }
  }
}
