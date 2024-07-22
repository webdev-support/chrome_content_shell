package org.chromium.proxy_resolver.mojom;

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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.NetworkAnonymizationKey;
import org.chromium.url.mojom.Url;

class ProxyResolver_Internal {
  private static final int GET_PROXY_FOR_URL_ORDINAL = 0;
  public static final Interface.Manager<ProxyResolver, ProxyResolver.Proxy> MANAGER =
      new Interface.Manager<ProxyResolver, ProxyResolver.Proxy>() {
        @Override
        public String getName() {
          return "proxy_resolver.mojom.ProxyResolver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ProxyResolver.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ProxyResolver impl) {
          return new Stub(core, impl);
        }

        @Override
        public ProxyResolver[] buildArray(int size) {
          return new ProxyResolver[size];
        }
      };

  ProxyResolver_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements ProxyResolver.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getProxyForUrl(
        Url url,
        NetworkAnonymizationKey networkAnonymizationKey,
        ProxyResolverRequestClient client) {
      ProxyResolverGetProxyForUrlParams _message = new ProxyResolverGetProxyForUrlParams();
      _message.url = url;
      _message.networkAnonymizationKey = networkAnonymizationKey;
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<ProxyResolver> {
    Stub(Core core, ProxyResolver impl) {
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
                ProxyResolver_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ProxyResolverGetProxyForUrlParams data =
                ProxyResolverGetProxyForUrlParams.deserialize(messageWithHeader.getPayload());
            getImpl().getProxyForUrl(data.url, data.networkAnonymizationKey, data.client);
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
                getCore(), ProxyResolver_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ProxyResolverGetProxyForUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public ProxyResolverRequestClient client;
    public NetworkAnonymizationKey networkAnonymizationKey;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProxyResolverGetProxyForUrlParams(int version) {
      super(40, version);
    }

    public ProxyResolverGetProxyForUrlParams() {
      this(0);
    }

    public static ProxyResolverGetProxyForUrlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProxyResolverGetProxyForUrlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProxyResolverGetProxyForUrlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProxyResolverGetProxyForUrlParams result =
            new ProxyResolverGetProxyForUrlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 16);
        result.client =
            (ProxyResolverRequestClient)
                decoder0.readServiceInterface(32, false, ProxyResolverRequestClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Union) this.networkAnonymizationKey, 16, false);
      encoder0.encode(this.client, 32, false, ProxyResolverRequestClient.MANAGER);
    }
  }
}
