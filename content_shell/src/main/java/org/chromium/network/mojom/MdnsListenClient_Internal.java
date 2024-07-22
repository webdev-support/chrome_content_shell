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

class MdnsListenClient_Internal {
  public static final Interface.Manager<MdnsListenClient, MdnsListenClient.Proxy> MANAGER =
      new Interface.Manager<MdnsListenClient, MdnsListenClient.Proxy>() {
        @Override
        public String getName() {
          return "network.mojom.MdnsListenClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public MdnsListenClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, MdnsListenClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public MdnsListenClient[] buildArray(int size) {
          return new MdnsListenClient[size];
        }
      };
  private static final int ON_ADDRESS_RESULT_ORDINAL = 0;
  private static final int ON_HOSTNAME_RESULT_ORDINAL = 2;
  private static final int ON_TEXT_RESULT_ORDINAL = 1;
  private static final int ON_UNHANDLED_RESULT_ORDINAL = 3;

  MdnsListenClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements MdnsListenClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onAddressResult(int updateType, int queryType, IpEndPoint endpoint) {
      MdnsListenClientOnAddressResultParams _message = new MdnsListenClientOnAddressResultParams();
      _message.updateType = updateType;
      _message.queryType = queryType;
      _message.endpoint = endpoint;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onTextResult(int updateType, int queryType, String[] textRecords) {
      MdnsListenClientOnTextResultParams _message = new MdnsListenClientOnTextResultParams();
      _message.updateType = updateType;
      _message.queryType = queryType;
      _message.textRecords = textRecords;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onHostnameResult(int updateType, int queryType, HostPortPair host) {
      MdnsListenClientOnHostnameResultParams _message =
          new MdnsListenClientOnHostnameResultParams();
      _message.updateType = updateType;
      _message.queryType = queryType;
      _message.host = host;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onUnhandledResult(int updateType, int queryType) {
      MdnsListenClientOnUnhandledResultParams _message =
          new MdnsListenClientOnUnhandledResultParams();
      _message.updateType = updateType;
      _message.queryType = queryType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<MdnsListenClient> {
    Stub(Core core, MdnsListenClient impl) {
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
                MdnsListenClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            MdnsListenClientOnAddressResultParams data =
                MdnsListenClientOnAddressResultParams.deserialize(messageWithHeader.getPayload());
            getImpl().onAddressResult(data.updateType, data.queryType, data.endpoint);
            return true;
          case 1:
            MdnsListenClientOnTextResultParams data2 =
                MdnsListenClientOnTextResultParams.deserialize(messageWithHeader.getPayload());
            getImpl().onTextResult(data2.updateType, data2.queryType, data2.textRecords);
            return true;
          case 2:
            MdnsListenClientOnHostnameResultParams data3 =
                MdnsListenClientOnHostnameResultParams.deserialize(messageWithHeader.getPayload());
            getImpl().onHostnameResult(data3.updateType, data3.queryType, data3.host);
            return true;
          case 3:
            MdnsListenClientOnUnhandledResultParams data4 =
                MdnsListenClientOnUnhandledResultParams.deserialize(messageWithHeader.getPayload());
            getImpl().onUnhandledResult(data4.updateType, data4.queryType);
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
                getCore(), MdnsListenClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class MdnsListenClientOnAddressResultParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public IpEndPoint endpoint;
    public int queryType;
    public int updateType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MdnsListenClientOnAddressResultParams(int version) {
      super(24, version);
    }

    public MdnsListenClientOnAddressResultParams() {
      this(0);
    }

    public static MdnsListenClientOnAddressResultParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MdnsListenClientOnAddressResultParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MdnsListenClientOnAddressResultParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MdnsListenClientOnAddressResultParams result =
            new MdnsListenClientOnAddressResultParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.updateType = readInt;
        MdnsListenClient.UpdateType.validate(readInt);
        result.updateType = MdnsListenClient.UpdateType.toKnownValue(result.updateType);
        int readInt2 = decoder0.readInt(12);
        result.queryType = readInt2;
        DnsQueryType.validate(readInt2);
        result.queryType = DnsQueryType.toKnownValue(result.queryType);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.endpoint = IpEndPoint.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.updateType, 8);
      encoder0.encode(this.queryType, 12);
      encoder0.encode((Struct) this.endpoint, 16, false);
    }
  }

  static final class MdnsListenClientOnTextResultParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int queryType;
    public String[] textRecords;
    public int updateType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MdnsListenClientOnTextResultParams(int version) {
      super(24, version);
    }

    public MdnsListenClientOnTextResultParams() {
      this(0);
    }

    public static MdnsListenClientOnTextResultParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MdnsListenClientOnTextResultParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MdnsListenClientOnTextResultParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MdnsListenClientOnTextResultParams result =
            new MdnsListenClientOnTextResultParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.updateType = readInt;
        MdnsListenClient.UpdateType.validate(readInt);
        result.updateType = MdnsListenClient.UpdateType.toKnownValue(result.updateType);
        int readInt2 = decoder0.readInt(12);
        result.queryType = readInt2;
        DnsQueryType.validate(readInt2);
        result.queryType = DnsQueryType.toKnownValue(result.queryType);
        Decoder decoder1 = decoder0.readPointer(16, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.textRecords = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.textRecords[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.updateType, 8);
      encoder0.encode(this.queryType, 12);
      String[] strArr = this.textRecords;
      if (strArr == null) {
        encoder0.encodeNullPointer(16, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.textRecords;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class MdnsListenClientOnHostnameResultParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public HostPortPair host;
    public int queryType;
    public int updateType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MdnsListenClientOnHostnameResultParams(int version) {
      super(24, version);
    }

    public MdnsListenClientOnHostnameResultParams() {
      this(0);
    }

    public static MdnsListenClientOnHostnameResultParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MdnsListenClientOnHostnameResultParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MdnsListenClientOnHostnameResultParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MdnsListenClientOnHostnameResultParams result =
            new MdnsListenClientOnHostnameResultParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.updateType = readInt;
        MdnsListenClient.UpdateType.validate(readInt);
        result.updateType = MdnsListenClient.UpdateType.toKnownValue(result.updateType);
        int readInt2 = decoder0.readInt(12);
        result.queryType = readInt2;
        DnsQueryType.validate(readInt2);
        result.queryType = DnsQueryType.toKnownValue(result.queryType);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.host = HostPortPair.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.updateType, 8);
      encoder0.encode(this.queryType, 12);
      encoder0.encode((Struct) this.host, 16, false);
    }
  }

  static final class MdnsListenClientOnUnhandledResultParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int queryType;
    public int updateType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private MdnsListenClientOnUnhandledResultParams(int version) {
      super(16, version);
    }

    public MdnsListenClientOnUnhandledResultParams() {
      this(0);
    }

    public static MdnsListenClientOnUnhandledResultParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static MdnsListenClientOnUnhandledResultParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static MdnsListenClientOnUnhandledResultParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        MdnsListenClientOnUnhandledResultParams result =
            new MdnsListenClientOnUnhandledResultParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.updateType = readInt;
        MdnsListenClient.UpdateType.validate(readInt);
        result.updateType = MdnsListenClient.UpdateType.toKnownValue(result.updateType);
        int readInt2 = decoder0.readInt(12);
        result.queryType = readInt2;
        DnsQueryType.validate(readInt2);
        result.queryType = DnsQueryType.toKnownValue(result.queryType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.updateType, 8);
      encoder0.encode(this.queryType, 12);
    }
  }
}
