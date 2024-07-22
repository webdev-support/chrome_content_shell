package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
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

class FindInPageClient_Internal {
  public static final Interface.Manager<FindInPageClient, FindInPageClient.Proxy> MANAGER =
      new Interface.Manager<FindInPageClient, FindInPageClient.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.FindInPageClient";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public FindInPageClient.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, FindInPageClient impl) {
          return new Stub(core, impl);
        }

        @Override
        public FindInPageClient[] buildArray(int size) {
          return new FindInPageClient[size];
        }
      };
  private static final int SET_ACTIVE_MATCH_ORDINAL = 1;
  private static final int SET_NUMBER_OF_MATCHES_ORDINAL = 0;

  FindInPageClient_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FindInPageClient.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void setNumberOfMatches(int requestId, int numberOfMatches, int updateType) {
      FindInPageClientSetNumberOfMatchesParams _message =
          new FindInPageClientSetNumberOfMatchesParams();
      _message.requestId = requestId;
      _message.numberOfMatches = numberOfMatches;
      _message.updateType = updateType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void setActiveMatch(
        int requestId, Rect activeMatchRect, int activeMatchOrdinal, int updateType) {
      FindInPageClientSetActiveMatchParams _message = new FindInPageClientSetActiveMatchParams();
      _message.requestId = requestId;
      _message.activeMatchRect = activeMatchRect;
      _message.activeMatchOrdinal = activeMatchOrdinal;
      _message.updateType = updateType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<FindInPageClient> {
    Stub(Core core, FindInPageClient impl) {
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
                FindInPageClient_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            FindInPageClientSetNumberOfMatchesParams data =
                FindInPageClientSetNumberOfMatchesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().setNumberOfMatches(data.requestId, data.numberOfMatches, data.updateType);
            return true;
          case 1:
            FindInPageClientSetActiveMatchParams data2 =
                FindInPageClientSetActiveMatchParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .setActiveMatch(
                    data2.requestId,
                    data2.activeMatchRect,
                    data2.activeMatchOrdinal,
                    data2.updateType);
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
                getCore(), FindInPageClient_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class FindInPageClientSetNumberOfMatchesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int numberOfMatches;
    public int requestId;
    public int updateType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FindInPageClientSetNumberOfMatchesParams(int version) {
      super(24, version);
    }

    public FindInPageClientSetNumberOfMatchesParams() {
      this(0);
    }

    public static FindInPageClientSetNumberOfMatchesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FindInPageClientSetNumberOfMatchesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FindInPageClientSetNumberOfMatchesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FindInPageClientSetNumberOfMatchesParams result =
            new FindInPageClientSetNumberOfMatchesParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        result.numberOfMatches = decoder0.readInt(12);
        int readInt = decoder0.readInt(16);
        result.updateType = readInt;
        FindMatchUpdateType.validate(readInt);
        result.updateType = FindMatchUpdateType.toKnownValue(result.updateType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.numberOfMatches, 12);
      encoder0.encode(this.updateType, 16);
    }
  }

  static final class FindInPageClientSetActiveMatchParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int activeMatchOrdinal;
    public Rect activeMatchRect;
    public int requestId;
    public int updateType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FindInPageClientSetActiveMatchParams(int version) {
      super(32, version);
    }

    public FindInPageClientSetActiveMatchParams() {
      this(0);
    }

    public static FindInPageClientSetActiveMatchParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FindInPageClientSetActiveMatchParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FindInPageClientSetActiveMatchParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FindInPageClientSetActiveMatchParams result =
            new FindInPageClientSetActiveMatchParams(elementsOrVersion);
        result.requestId = decoder0.readInt(8);
        result.activeMatchOrdinal = decoder0.readInt(12);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.activeMatchRect = Rect.decode(decoder1);
        int readInt = decoder0.readInt(24);
        result.updateType = readInt;
        FindMatchUpdateType.validate(readInt);
        result.updateType = FindMatchUpdateType.toKnownValue(result.updateType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.requestId, 8);
      encoder0.encode(this.activeMatchOrdinal, 12);
      encoder0.encode((Struct) this.activeMatchRect, 16, false);
      encoder0.encode(this.updateType, 24);
    }
  }
}
