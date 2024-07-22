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

class CdmService_Internal {
  private static final int CREATE_CDM_FACTORY_ORDINAL = 0;
  public static final Interface.Manager<CdmService, CdmService.Proxy> MANAGER =
      new Interface.Manager<CdmService, CdmService.Proxy>() {
        @Override
        public String getName() {
          return "media.mojom.CdmService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public CdmService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, CdmService impl) {
          return new Stub(core, impl);
        }

        @Override
        public CdmService[] buildArray(int size) {
          return new CdmService[size];
        }
      };

  CdmService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements CdmService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createCdmFactory(
        InterfaceRequest<CdmFactory> factory, FrameInterfaceFactory frameInterfaces) {
      CdmServiceCreateCdmFactoryParams _message = new CdmServiceCreateCdmFactoryParams();
      _message.factory = factory;
      _message.frameInterfaces = frameInterfaces;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<CdmService> {
    Stub(Core core, CdmService impl) {
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
                CdmService_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            CdmServiceCreateCdmFactoryParams data =
                CdmServiceCreateCdmFactoryParams.deserialize(messageWithHeader.getPayload());
            getImpl().createCdmFactory(data.factory, data.frameInterfaces);
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
                getCore(), CdmService_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class CdmServiceCreateCdmFactoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<CdmFactory> factory;
    public FrameInterfaceFactory frameInterfaces;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private CdmServiceCreateCdmFactoryParams(int version) {
      super(24, version);
    }

    public CdmServiceCreateCdmFactoryParams() {
      this(0);
    }

    public static CdmServiceCreateCdmFactoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static CdmServiceCreateCdmFactoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static CdmServiceCreateCdmFactoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        CdmServiceCreateCdmFactoryParams result =
            new CdmServiceCreateCdmFactoryParams(elementsOrVersion);
        result.factory = decoder0.readInterfaceRequest(8, false);
        result.frameInterfaces =
            (FrameInterfaceFactory)
                decoder0.readServiceInterface(12, false, FrameInterfaceFactory.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.factory, 8, false);
      encoder0.encode(this.frameInterfaces, 12, false, FrameInterfaceFactory.MANAGER);
    }
  }
}
