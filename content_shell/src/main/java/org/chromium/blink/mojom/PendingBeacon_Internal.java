package org.chromium.blink.mojom;

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
import org.chromium.network.mojom.UrlRequestBody;
import org.chromium.url.mojom.Url;

class PendingBeacon_Internal {
  private static final int DEACTIVATE_ORDINAL = 0;
  public static final Interface.Manager<PendingBeacon, PendingBeacon.Proxy> MANAGER =
      new Interface.Manager<PendingBeacon, PendingBeacon.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.PendingBeacon";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public PendingBeacon.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, PendingBeacon impl) {
          return new Stub(core, impl);
        }

        @Override
        public PendingBeacon[] buildArray(int size) {
          return new PendingBeacon[size];
        }
      };
  private static final int SEND_NOW_ORDINAL = 3;
  private static final int SET_REQUEST_DATA_ORDINAL = 1;
  private static final int SET_REQUEST_URL_ORDINAL = 2;

  PendingBeacon_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements PendingBeacon.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void deactivate() {
      PendingBeaconDeactivateParams _message = new PendingBeaconDeactivateParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setRequestData(UrlRequestBody requestBody, String contentType) {
      PendingBeaconSetRequestDataParams _message = new PendingBeaconSetRequestDataParams();
      _message.requestBody = requestBody;
      _message.contentType = contentType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setRequestUrl(Url url) {
      PendingBeaconSetRequestUrlParams _message = new PendingBeaconSetRequestUrlParams();
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void sendNow() {
      PendingBeaconSendNowParams _message = new PendingBeaconSendNowParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<PendingBeacon> {
    Stub(Core core, PendingBeacon impl) {
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
                PendingBeacon_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            PendingBeaconDeactivateParams.deserialize(messageWithHeader.getPayload());
            getImpl().deactivate();
            return true;
          case 1:
            PendingBeaconSetRequestDataParams data =
                PendingBeaconSetRequestDataParams.deserialize(messageWithHeader.getPayload());
            getImpl().setRequestData(data.requestBody, data.contentType);
            return true;
          case 2:
            getImpl()
                .setRequestUrl(
                    PendingBeaconSetRequestUrlParams.deserialize(messageWithHeader.getPayload())
                        .url);
            return true;
          case 3:
            PendingBeaconSendNowParams.deserialize(messageWithHeader.getPayload());
            getImpl().sendNow();
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
                getCore(), PendingBeacon_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class PendingBeaconDeactivateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PendingBeaconDeactivateParams(int version) {
      super(8, version);
    }

    public PendingBeaconDeactivateParams() {
      this(0);
    }

    public static PendingBeaconDeactivateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PendingBeaconDeactivateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PendingBeaconDeactivateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PendingBeaconDeactivateParams result = new PendingBeaconDeactivateParams(elementsOrVersion);
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

  static final class PendingBeaconSetRequestDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String contentType;
    public UrlRequestBody requestBody;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PendingBeaconSetRequestDataParams(int version) {
      super(24, version);
    }

    public PendingBeaconSetRequestDataParams() {
      this(0);
    }

    public static PendingBeaconSetRequestDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PendingBeaconSetRequestDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PendingBeaconSetRequestDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PendingBeaconSetRequestDataParams result =
            new PendingBeaconSetRequestDataParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.requestBody = UrlRequestBody.decode(decoder1);
        result.contentType = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.requestBody, 8, false);
      encoder0.encode(this.contentType, 16, false);
    }
  }

  static final class PendingBeaconSetRequestUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PendingBeaconSetRequestUrlParams(int version) {
      super(16, version);
    }

    public PendingBeaconSetRequestUrlParams() {
      this(0);
    }

    public static PendingBeaconSetRequestUrlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PendingBeaconSetRequestUrlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PendingBeaconSetRequestUrlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PendingBeaconSetRequestUrlParams result =
            new PendingBeaconSetRequestUrlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
    }
  }

  static final class PendingBeaconSendNowParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private PendingBeaconSendNowParams(int version) {
      super(8, version);
    }

    public PendingBeaconSendNowParams() {
      this(0);
    }

    public static PendingBeaconSendNowParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static PendingBeaconSendNowParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static PendingBeaconSendNowParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        PendingBeaconSendNowParams result = new PendingBeaconSendNowParams(elementsOrVersion);
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
