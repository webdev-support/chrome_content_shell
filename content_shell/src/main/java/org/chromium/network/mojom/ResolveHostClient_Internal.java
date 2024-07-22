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

class ResolveHostClient_Internal {
  public static final Interface.Manager<ResolveHostClient, ResolveHostClient.Proxy> MANAGER =
      new Interface.Manager<ResolveHostClient, ResolveHostClient.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.ResolveHostClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ResolveHostClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ResolveHostClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public ResolveHostClient[] buildArray(int size) {
          return new ResolveHostClient[size];
        }
      };
  private static final int ON_COMPLETE_ORDINAL = 0;
  private static final int ON_HOSTNAME_RESULTS_ORDINAL = 2;
  private static final int ON_TEXT_RESULTS_ORDINAL = 1;

  ResolveHostClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ResolveHostClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onComplete(
        int result,
        ResolveErrorInfo resolveErrorInfo,
        AddressList resolvedAddresses,
        HostResolverEndpointResult[] endpointResultsWithMetadata) {
      ResolveHostClientOnCompleteParams _message = new ResolveHostClientOnCompleteParams();
      _message.result = result;
      _message.resolveErrorInfo = resolveErrorInfo;
      _message.resolvedAddresses = resolvedAddresses;
      _message.endpointResultsWithMetadata = endpointResultsWithMetadata;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onTextResults(String[] textResults) {
      ResolveHostClientOnTextResultsParams _message = new ResolveHostClientOnTextResultsParams();
      _message.textResults = textResults;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onHostnameResults(HostPortPair[] hosts) {
      ResolveHostClientOnHostnameResultsParams _message =
          new ResolveHostClientOnHostnameResultsParams();
      _message.hosts = hosts;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }
  }

  public static final class Stub extends Interface.Stub<ResolveHostClient> {
    Stub(Core core, ResolveHostClient impl) {
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
                ResolveHostClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ResolveHostClientOnCompleteParams data =
                ResolveHostClientOnCompleteParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .onComplete(
                    data.result,
                    data.resolveErrorInfo,
                    data.resolvedAddresses,
                    data.endpointResultsWithMetadata);
            return true;
          case 1:
            getImpl()
                .onTextResults(
                    ResolveHostClientOnTextResultsParams.deserialize(messageWithHeader.getPayload())
                        .textResults);
            return true;
          case 2:
            getImpl()
                .onHostnameResults(
                    ResolveHostClientOnHostnameResultsParams.deserialize(
                            messageWithHeader.getPayload())
                        .hosts);
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
                getCore(), ResolveHostClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ResolveHostClientOnCompleteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public HostResolverEndpointResult[] endpointResultsWithMetadata;
    public ResolveErrorInfo resolveErrorInfo;
    public AddressList resolvedAddresses;
    public int result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ResolveHostClientOnCompleteParams(int version) {
      super(40, version);
    }

    public ResolveHostClientOnCompleteParams() {
      this(0);
    }

    public static ResolveHostClientOnCompleteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ResolveHostClientOnCompleteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ResolveHostClientOnCompleteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ResolveHostClientOnCompleteParams result =
            new ResolveHostClientOnCompleteParams(elementsOrVersion);
        result.result = decoder0.readInt(8);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.resolveErrorInfo = ResolveErrorInfo.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.resolvedAddresses = AddressList.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, true);
        if (decoder13 == null) {
          result.endpointResultsWithMetadata = null;
        } else {
          DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
          result.endpointResultsWithMetadata =
              new HostResolverEndpointResult[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
            Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
            result.endpointResultsWithMetadata[i1] = HostResolverEndpointResult.decode(decoder2);
          }
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8);
      encoder0.encode((Struct) this.resolveErrorInfo, 16, false);
      encoder0.encode((Struct) this.resolvedAddresses, 24, true);
      HostResolverEndpointResult[] hostResolverEndpointResultArr = this.endpointResultsWithMetadata;
      if (hostResolverEndpointResultArr == null) {
        encoder0.encodeNullPointer(32, true);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(hostResolverEndpointResultArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        HostResolverEndpointResult[] hostResolverEndpointResultArr2 =
            this.endpointResultsWithMetadata;
        if (i0 < hostResolverEndpointResultArr2.length) {
          encoder1.encode((Struct) hostResolverEndpointResultArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class ResolveHostClientOnTextResultsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] textResults;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ResolveHostClientOnTextResultsParams(int version) {
      super(16, version);
    }

    public ResolveHostClientOnTextResultsParams() {
      this(0);
    }

    public static ResolveHostClientOnTextResultsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ResolveHostClientOnTextResultsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ResolveHostClientOnTextResultsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ResolveHostClientOnTextResultsParams result =
            new ResolveHostClientOnTextResultsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.textResults = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.textResults[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.textResults;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.textResults;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class ResolveHostClientOnHostnameResultsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public HostPortPair[] hosts;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ResolveHostClientOnHostnameResultsParams(int version) {
      super(16, version);
    }

    public ResolveHostClientOnHostnameResultsParams() {
      this(0);
    }

    public static ResolveHostClientOnHostnameResultsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ResolveHostClientOnHostnameResultsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ResolveHostClientOnHostnameResultsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ResolveHostClientOnHostnameResultsParams result =
            new ResolveHostClientOnHostnameResultsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.hosts = new HostPortPair[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.hosts[i1] = HostPortPair.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      HostPortPair[] hostPortPairArr = this.hosts;
      if (hostPortPairArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(hostPortPairArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        HostPortPair[] hostPortPairArr2 = this.hosts;
        if (i0 < hostPortPairArr2.length) {
          encoder1.encode((Struct) hostPortPairArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }
}
