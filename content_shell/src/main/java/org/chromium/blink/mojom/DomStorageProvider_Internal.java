package org.chromium.blink.mojom;

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

class DomStorageProvider_Internal {
  private static final int BIND_DOM_STORAGE_ORDINAL = 0;
  public static final Interface.Manager<DomStorageProvider, DomStorageProvider.Proxy> MANAGER =
      new Interface.Manager<DomStorageProvider, DomStorageProvider.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.DomStorageProvider";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public DomStorageProvider.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, DomStorageProvider impl) {
          return new Stub(core, impl);
        }

        @Override
        public DomStorageProvider[] buildArray(int size) {
          return new DomStorageProvider[size];
        }
      };

  DomStorageProvider_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements DomStorageProvider.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void bindDomStorage(InterfaceRequest<DomStorage> receiver, DomStorageClient client) {
      DomStorageProviderBindDomStorageParams _message =
          new DomStorageProviderBindDomStorageParams();
      _message.receiver = receiver;
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<DomStorageProvider> {
    Stub(Core core, DomStorageProvider impl) {
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
                DomStorageProvider_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            DomStorageProviderBindDomStorageParams data =
                DomStorageProviderBindDomStorageParams.deserialize(messageWithHeader.getPayload());
            getImpl().bindDomStorage(data.receiver, data.client);
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
                getCore(), DomStorageProvider_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class DomStorageProviderBindDomStorageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public DomStorageClient client;
    public InterfaceRequest<DomStorage> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DomStorageProviderBindDomStorageParams(int version) {
      super(24, version);
    }

    public DomStorageProviderBindDomStorageParams() {
      this(0);
    }

    public static DomStorageProviderBindDomStorageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DomStorageProviderBindDomStorageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DomStorageProviderBindDomStorageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DomStorageProviderBindDomStorageParams result =
            new DomStorageProviderBindDomStorageParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        result.client =
            (DomStorageClient) decoder0.readServiceInterface(12, false, DomStorageClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
      encoder0.encode(this.client, 12, false, DomStorageClient.MANAGER);
    }
  }
}
