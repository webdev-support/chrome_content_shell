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
import org.chromium.proxy_resolver.mojom.ProxyInfo;

class ProxyLookupClient_Internal {
  public static final Interface.Manager<ProxyLookupClient, ProxyLookupClient.Proxy> MANAGER =
      new Interface.Manager<ProxyLookupClient, ProxyLookupClient.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.ProxyLookupClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ProxyLookupClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ProxyLookupClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public ProxyLookupClient[] buildArray(int size) {
          return new ProxyLookupClient[size];
        }
      };
  private static final int ON_PROXY_LOOKUP_COMPLETE_ORDINAL = 0;

  ProxyLookupClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ProxyLookupClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onProxyLookupComplete(int netError, ProxyInfo proxyInfo) {
      ProxyLookupClientOnProxyLookupCompleteParams _message =
          new ProxyLookupClientOnProxyLookupCompleteParams();
      _message.netError = netError;
      _message.proxyInfo = proxyInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<ProxyLookupClient> {
    Stub(Core core, ProxyLookupClient impl) {
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
                ProxyLookupClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ProxyLookupClientOnProxyLookupCompleteParams data =
                ProxyLookupClientOnProxyLookupCompleteParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onProxyLookupComplete(data.netError, data.proxyInfo);
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
                getCore(), ProxyLookupClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ProxyLookupClientOnProxyLookupCompleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int netError;
    public ProxyInfo proxyInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProxyLookupClientOnProxyLookupCompleteParams(int version) {
      super(24, version);
    }

    public ProxyLookupClientOnProxyLookupCompleteParams() {
      this(0);
    }

    public static ProxyLookupClientOnProxyLookupCompleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProxyLookupClientOnProxyLookupCompleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProxyLookupClientOnProxyLookupCompleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProxyLookupClientOnProxyLookupCompleteParams result =
            new ProxyLookupClientOnProxyLookupCompleteParams(elementsOrVersion);
        result.netError = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.proxyInfo = ProxyInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.netError, 8);
      encoder0.encode((Struct) this.proxyInfo, 16, true);
    }
  }
}