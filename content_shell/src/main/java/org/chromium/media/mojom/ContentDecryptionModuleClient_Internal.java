package org.chromium.media.mojom;

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

class ContentDecryptionModuleClient_Internal {
  public static final Interface.Manager<
          ContentDecryptionModuleClient, ContentDecryptionModuleClient.Proxy>
      MANAGER =
          new Interface.Manager<
              ContentDecryptionModuleClient, ContentDecryptionModuleClient.Proxy>() {
            @Override
            public String getName() {
              return "media.mojom.ContentDecryptionModuleClient";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ContentDecryptionModuleClient.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ContentDecryptionModuleClient impl) {
              return new Stub(core, impl);
            }

            @Override
            public ContentDecryptionModuleClient[] buildArray(int size) {
              return new ContentDecryptionModuleClient[size];
            }
          };
  private static final int ON_SESSION_CLOSED_ORDINAL = 1;
  private static final int ON_SESSION_EXPIRATION_UPDATE_ORDINAL = 3;
  private static final int ON_SESSION_KEYS_CHANGE_ORDINAL = 2;
  private static final int ON_SESSION_MESSAGE_ORDINAL = 0;

  ContentDecryptionModuleClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ContentDecryptionModuleClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void onSessionMessage(String sessionId, int messageType, byte[] message) {
      ContentDecryptionModuleClientOnSessionMessageParams _message =
          new ContentDecryptionModuleClientOnSessionMessageParams();
      _message.sessionId = sessionId;
      _message.messageType = messageType;
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void onSessionClosed(String sessionId, int reason) {
      ContentDecryptionModuleClientOnSessionClosedParams _message =
          new ContentDecryptionModuleClientOnSessionClosedParams();
      _message.sessionId = sessionId;
      _message.reason = reason;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void onSessionKeysChange(
        String sessionId, boolean hasAdditionalUsableKey, CdmKeyInformation[] keysInfo) {
      ContentDecryptionModuleClientOnSessionKeysChangeParams _message =
          new ContentDecryptionModuleClientOnSessionKeysChangeParams();
      _message.sessionId = sessionId;
      _message.hasAdditionalUsableKey = hasAdditionalUsableKey;
      _message.keysInfo = keysInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void onSessionExpirationUpdate(String sessionId, double newExpiryTimeSec) {
      ContentDecryptionModuleClientOnSessionExpirationUpdateParams _message =
          new ContentDecryptionModuleClientOnSessionExpirationUpdateParams();
      _message.sessionId = sessionId;
      _message.newExpiryTimeSec = newExpiryTimeSec;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }
  }

  public static final class Stub extends Interface.Stub<ContentDecryptionModuleClient> {
    Stub(Core core, ContentDecryptionModuleClient impl) {
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
                ContentDecryptionModuleClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ContentDecryptionModuleClientOnSessionMessageParams data =
                ContentDecryptionModuleClientOnSessionMessageParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onSessionMessage(data.sessionId, data.messageType, data.message);
            return true;
          case 1:
            ContentDecryptionModuleClientOnSessionClosedParams data2 =
                ContentDecryptionModuleClientOnSessionClosedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onSessionClosed(data2.sessionId, data2.reason);
            return true;
          case 2:
            ContentDecryptionModuleClientOnSessionKeysChangeParams data3 =
                ContentDecryptionModuleClientOnSessionKeysChangeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .onSessionKeysChange(data3.sessionId, data3.hasAdditionalUsableKey, data3.keysInfo);
            return true;
          case 3:
            ContentDecryptionModuleClientOnSessionExpirationUpdateParams data4 =
                ContentDecryptionModuleClientOnSessionExpirationUpdateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().onSessionExpirationUpdate(data4.sessionId, data4.newExpiryTimeSec);
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
                ContentDecryptionModuleClient_Internal.MANAGER,
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

  static final class ContentDecryptionModuleClientOnSessionMessageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public byte[] message;
    public int messageType;
    public String sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleClientOnSessionMessageParams(int version) {
      super(32, version);
    }

    public ContentDecryptionModuleClientOnSessionMessageParams() {
      this(0);
    }

    public static ContentDecryptionModuleClientOnSessionMessageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleClientOnSessionMessageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleClientOnSessionMessageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleClientOnSessionMessageParams result =
            new ContentDecryptionModuleClientOnSessionMessageParams(elementsOrVersion);
        result.sessionId = decoder0.readString(8, false);
        int readInt = decoder0.readInt(16);
        result.messageType = readInt;
        CdmMessageType.validate(readInt);
        result.messageType = CdmMessageType.toKnownValue(result.messageType);
        result.message = decoder0.readBytes(24, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sessionId, 8, false);
      encoder0.encode(this.messageType, 16);
      encoder0.encode(this.message, 24, 0, -1);
    }
  }

  static final class ContentDecryptionModuleClientOnSessionClosedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int reason;
    public String sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleClientOnSessionClosedParams(int version) {
      super(24, version);
    }

    public ContentDecryptionModuleClientOnSessionClosedParams() {
      this(0);
    }

    public static ContentDecryptionModuleClientOnSessionClosedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleClientOnSessionClosedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleClientOnSessionClosedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleClientOnSessionClosedParams result =
            new ContentDecryptionModuleClientOnSessionClosedParams(elementsOrVersion);
        result.sessionId = decoder0.readString(8, false);
        int readInt = decoder0.readInt(16);
        result.reason = readInt;
        CdmSessionClosedReason.validate(readInt);
        result.reason = CdmSessionClosedReason.toKnownValue(result.reason);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sessionId, 8, false);
      encoder0.encode(this.reason, 16);
    }
  }

  static final class ContentDecryptionModuleClientOnSessionKeysChangeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean hasAdditionalUsableKey;
    public CdmKeyInformation[] keysInfo;
    public String sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleClientOnSessionKeysChangeParams(int version) {
      super(32, version);
    }

    public ContentDecryptionModuleClientOnSessionKeysChangeParams() {
      this(0);
    }

    public static ContentDecryptionModuleClientOnSessionKeysChangeParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleClientOnSessionKeysChangeParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleClientOnSessionKeysChangeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleClientOnSessionKeysChangeParams result =
            new ContentDecryptionModuleClientOnSessionKeysChangeParams(elementsOrVersion);
        result.sessionId = decoder0.readString(8, false);
        result.hasAdditionalUsableKey = decoder0.readBoolean(16, 0);
        Decoder decoder1 = decoder0.readPointer(24, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.keysInfo = new CdmKeyInformation[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.keysInfo[i1] = CdmKeyInformation.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sessionId, 8, false);
      encoder0.encode(this.hasAdditionalUsableKey, 16, 0);
      CdmKeyInformation[] cdmKeyInformationArr = this.keysInfo;
      if (cdmKeyInformationArr == null) {
        encoder0.encodeNullPointer(24, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(cdmKeyInformationArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        CdmKeyInformation[] cdmKeyInformationArr2 = this.keysInfo;
        if (i0 < cdmKeyInformationArr2.length) {
          encoder1.encode((Struct) cdmKeyInformationArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class ContentDecryptionModuleClientOnSessionExpirationUpdateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public double newExpiryTimeSec;
    public String sessionId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContentDecryptionModuleClientOnSessionExpirationUpdateParams(int version) {
      super(24, version);
    }

    public ContentDecryptionModuleClientOnSessionExpirationUpdateParams() {
      this(0);
    }

    public static ContentDecryptionModuleClientOnSessionExpirationUpdateParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ContentDecryptionModuleClientOnSessionExpirationUpdateParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDecryptionModuleClientOnSessionExpirationUpdateParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContentDecryptionModuleClientOnSessionExpirationUpdateParams result =
            new ContentDecryptionModuleClientOnSessionExpirationUpdateParams(elementsOrVersion);
        result.sessionId = decoder0.readString(8, false);
        result.newExpiryTimeSec = decoder0.readDouble(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.sessionId, 8, false);
      encoder0.encode(this.newExpiryTimeSec, 16);
    }
  }
}
