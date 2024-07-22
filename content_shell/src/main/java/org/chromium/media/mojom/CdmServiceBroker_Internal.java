package org.chromium.media.mojom;

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
import org.chromium.mojo_base.mojom.FilePath;

class CdmServiceBroker_Internal {
  private static final int GET_SERVICE_ORDINAL = 0;
  public static final Interface.Manager<CdmServiceBroker, CdmServiceBroker.Proxy> MANAGER =
      new Interface.Manager<CdmServiceBroker, CdmServiceBroker.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.CdmServiceBroker";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CdmServiceBroker.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CdmServiceBroker impl) {
          return new Stub(core, impl);
        }

        @Override
        public CdmServiceBroker[] buildArray(int size) {
          return new CdmServiceBroker[size];
        }
      };

  CdmServiceBroker_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements CdmServiceBroker.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getService(FilePath cdmPath, InterfaceRequest<CdmService> receiver) {
      CdmServiceBrokerGetServiceParams _message = new CdmServiceBrokerGetServiceParams();
      _message.cdmPath = cdmPath;
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<CdmServiceBroker> {
    Stub(Core core, CdmServiceBroker impl) {
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
                CdmServiceBroker_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            CdmServiceBrokerGetServiceParams data =
                CdmServiceBrokerGetServiceParams.deserialize(messageWithHeader.getPayload());
            getImpl().getService(data.cdmPath, data.receiver);
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
                getCore(), CdmServiceBroker_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class CdmServiceBrokerGetServiceParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FilePath cdmPath;
    public InterfaceRequest<CdmService> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CdmServiceBrokerGetServiceParams(int version) {
      super(24, version);
    }

    public CdmServiceBrokerGetServiceParams() {
      this(0);
    }

    public static CdmServiceBrokerGetServiceParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CdmServiceBrokerGetServiceParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CdmServiceBrokerGetServiceParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CdmServiceBrokerGetServiceParams result =
            new CdmServiceBrokerGetServiceParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.cdmPath = FilePath.decode(decoder1);
        result.receiver = decoder0.readInterfaceRequest(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.cdmPath, 8, false);
      encoder0.encode((InterfaceRequest) this.receiver, 16, false);
    }
  }
}
