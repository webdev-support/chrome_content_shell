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

class ProxyResolverRequestClient_Internal {
  private static final int ALERT_ORDINAL = 1;
  public static final Interface.Manager<
          ProxyResolverRequestClient, ProxyResolverRequestClient.Proxy>
      MANAGER =
          new Interface.Manager<ProxyResolverRequestClient, ProxyResolverRequestClient.Proxy>() {
            @Override
            public String getName() {
              return "proxy_resolver.mojom.ProxyResolverRequestClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ProxyResolverRequestClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ProxyResolverRequestClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public ProxyResolverRequestClient[] buildArray(int size) {
              return new ProxyResolverRequestClient[size];
            }
          };
  private static final int ON_ERROR_ORDINAL = 2;
  private static final int REPORT_RESULT_ORDINAL = 0;
  private static final int RESOLVE_DNS_ORDINAL = 3;

  ProxyResolverRequestClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ProxyResolverRequestClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void reportResult(int error, ProxyInfo proxyInfo) {
      ProxyResolverRequestClientReportResultParams _message =
          new ProxyResolverRequestClientReportResultParams();
      _message.error = error;
      _message.proxyInfo = proxyInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void alert(String error) {
      ProxyResolverRequestClientAlertParams _message = new ProxyResolverRequestClientAlertParams();
      _message.error = error;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onError(int lineNumber, String error) {
      ProxyResolverRequestClientOnErrorParams _message =
          new ProxyResolverRequestClientOnErrorParams();
      _message.lineNumber = lineNumber;
      _message.error = error;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void resolveDns(
        String host,
        int operation,
        NetworkAnonymizationKey networkAnonymizationKey,
        HostResolverRequestClient client) {
      ProxyResolverRequestClientResolveDnsParams _message =
          new ProxyResolverRequestClientResolveDnsParams();
      _message.host = host;
      _message.operation = operation;
      _message.networkAnonymizationKey = networkAnonymizationKey;
      _message.client = client;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<ProxyResolverRequestClient> {
    Stub(Core core, ProxyResolverRequestClient impl) {
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
                ProxyResolverRequestClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ProxyResolverRequestClientReportResultParams data =
                ProxyResolverRequestClientReportResultParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().reportResult(data.error, data.proxyInfo);
            return true;
          case 1:
            getImpl()
                .alert(
                    ProxyResolverRequestClientAlertParams.deserialize(
                            messageWithHeader.getPayload())
                        .error);
            return true;
          case 2:
            ProxyResolverRequestClientOnErrorParams data2 =
                ProxyResolverRequestClientOnErrorParams.deserialize(messageWithHeader.getPayload());
            getImpl().onError(data2.lineNumber, data2.error);
            return true;
          case 3:
            ProxyResolverRequestClientResolveDnsParams data3 =
                ProxyResolverRequestClientResolveDnsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .resolveDns(
                    data3.host, data3.operation, data3.networkAnonymizationKey, data3.client);
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
                ProxyResolverRequestClient_Internal.MANAGER,
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

  static final class ProxyResolverRequestClientReportResultParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int error;
    public ProxyInfo proxyInfo;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProxyResolverRequestClientReportResultParams(int version) {
      super(24, version);
    }

    public ProxyResolverRequestClientReportResultParams() {
      this(0);
    }

    public static ProxyResolverRequestClientReportResultParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProxyResolverRequestClientReportResultParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProxyResolverRequestClientReportResultParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProxyResolverRequestClientReportResultParams result =
            new ProxyResolverRequestClientReportResultParams(elementsOrVersion);
        result.error = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.proxyInfo = ProxyInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8);
      encoder0.encode((Struct) this.proxyInfo, 16, false);
    }
  }

  static final class ProxyResolverRequestClientAlertParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String error;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProxyResolverRequestClientAlertParams(int version) {
      super(16, version);
    }

    public ProxyResolverRequestClientAlertParams() {
      this(0);
    }

    public static ProxyResolverRequestClientAlertParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProxyResolverRequestClientAlertParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProxyResolverRequestClientAlertParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProxyResolverRequestClientAlertParams result =
            new ProxyResolverRequestClientAlertParams(elementsOrVersion);
        result.error = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.error, 8, false);
    }
  }

  static final class ProxyResolverRequestClientOnErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String error;
    public int lineNumber;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProxyResolverRequestClientOnErrorParams(int version) {
      super(24, version);
    }

    public ProxyResolverRequestClientOnErrorParams() {
      this(0);
    }

    public static ProxyResolverRequestClientOnErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProxyResolverRequestClientOnErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProxyResolverRequestClientOnErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProxyResolverRequestClientOnErrorParams result =
            new ProxyResolverRequestClientOnErrorParams(elementsOrVersion);
        result.lineNumber = decoder0.readInt(8);
        result.error = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.lineNumber, 8);
      encoder0.encode(this.error, 16, false);
    }
  }

  static final class ProxyResolverRequestClientResolveDnsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public HostResolverRequestClient client;
    public String host;
    public NetworkAnonymizationKey networkAnonymizationKey;
    public int operation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ProxyResolverRequestClientResolveDnsParams(int version) {
      super(48, version);
    }

    public ProxyResolverRequestClientResolveDnsParams() {
      this(0);
    }

    public static ProxyResolverRequestClientResolveDnsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ProxyResolverRequestClientResolveDnsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ProxyResolverRequestClientResolveDnsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ProxyResolverRequestClientResolveDnsParams result =
            new ProxyResolverRequestClientResolveDnsParams(elementsOrVersion);
        result.host = decoder0.readString(8, false);
        int readInt = decoder0.readInt(16);
        result.operation = readInt;
        HostResolveOperation.validate(readInt);
        result.operation = HostResolveOperation.toKnownValue(result.operation);
        result.networkAnonymizationKey = NetworkAnonymizationKey.decode(decoder0, 24);
        result.client =
            (HostResolverRequestClient)
                decoder0.readServiceInterface(40, false, HostResolverRequestClient.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.host, 8, false);
      encoder0.encode(this.operation, 16);
      encoder0.encode((Union) this.networkAnonymizationKey, 24, false);
      encoder0.encode(this.client, 40, false, HostResolverRequestClient.MANAGER);
    }
  }
}
