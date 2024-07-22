package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.url.internal.mojom.Origin;

class AbortableAdAuction_Internal {
  private static final int ABORT_ORDINAL = 9;
  public static final Interface.Manager<AbortableAdAuction, AbortableAdAuction.Proxy> MANAGER =
      new Interface.Manager<AbortableAdAuction, AbortableAdAuction.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.AbortableAdAuction";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public AbortableAdAuction.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, AbortableAdAuction impl) {
          return new Stub(core, impl);
        }

        @Override
        public AbortableAdAuction[] buildArray(int size) {
          return new AbortableAdAuction[size];
        }
      };
  private static final int RESOLVED_ADDITIONAL_BIDS_ORDINAL = 8;
  private static final int RESOLVED_AUCTION_AD_RESPONSE_PROMISE_ORDINAL = 7;
  private static final int RESOLVED_BUYER_CURRENCIES_PROMISE_ORDINAL = 3;
  private static final int RESOLVED_BUYER_TIMEOUTS_PROMISE_ORDINAL = 2;
  private static final int RESOLVED_DEPRECATED_RENDER_URL_REPLACEMENTS_PROMISE_ORDINAL = 6;
  private static final int RESOLVED_DIRECT_FROM_SELLER_SIGNALS_HEADER_AD_SLOT_PROMISE_ORDINAL = 5;
  private static final int RESOLVED_DIRECT_FROM_SELLER_SIGNALS_PROMISE_ORDINAL = 4;
  private static final int RESOLVED_PER_BUYER_SIGNALS_PROMISE_ORDINAL = 1;
  private static final int RESOLVED_PROMISE_PARAM_ORDINAL = 0;

  AbortableAdAuction_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements AbortableAdAuction.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void resolvedPromiseParam(
        AuctionAdConfigAuctionId auction, int field, String jsonValue) {
      AbortableAdAuctionResolvedPromiseParamParams _message =
          new AbortableAdAuctionResolvedPromiseParamParams();
      _message.auction = auction;
      _message.field = field;
      _message.jsonValue = jsonValue;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void resolvedPerBuyerSignalsPromise(
        AuctionAdConfigAuctionId auction, Map<Origin, String> perBuyerSignals) {
      AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams _message =
          new AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams();
      _message.auction = auction;
      _message.perBuyerSignals = perBuyerSignals;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void resolvedBuyerTimeoutsPromise(
        AuctionAdConfigAuctionId auction, int field, AuctionAdConfigBuyerTimeouts buyerTimeouts) {
      AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams _message =
          new AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams();
      _message.auction = auction;
      _message.field = field;
      _message.buyerTimeouts = buyerTimeouts;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void resolvedBuyerCurrenciesPromise(
        AuctionAdConfigAuctionId auction, AuctionAdConfigBuyerCurrencies perBuyerCurrencies) {
      AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams _message =
          new AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams();
      _message.auction = auction;
      _message.perBuyerCurrencies = perBuyerCurrencies;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void resolvedDirectFromSellerSignalsPromise(
        AuctionAdConfigAuctionId auction, DirectFromSellerSignals directFromSellerSignals) {
      AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams _message =
          new AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams();
      _message.auction = auction;
      _message.directFromSellerSignals = directFromSellerSignals;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void resolvedDirectFromSellerSignalsHeaderAdSlotPromise(
        AuctionAdConfigAuctionId auction, String directFromSellerSignalsHeaderAdSlot) {
      AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams _message =
          new AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams();
      _message.auction = auction;
      _message.directFromSellerSignalsHeaderAdSlot = directFromSellerSignalsHeaderAdSlot;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void resolvedDeprecatedRenderUrlReplacementsPromise(
        AuctionAdConfigAuctionId auction, AdKeywordReplacement[] deprecatedRenderUrlReplacements) {
      AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams _message =
          new AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams();
      _message.auction = auction;
      _message.deprecatedRenderUrlReplacements = deprecatedRenderUrlReplacements;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void resolvedAuctionAdResponsePromise(
        AuctionAdConfigAuctionId auction, BigBuffer result) {
      AbortableAdAuctionResolvedAuctionAdResponsePromiseParams _message =
          new AbortableAdAuctionResolvedAuctionAdResponsePromiseParams();
      _message.auction = auction;
      _message.result = result;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void resolvedAdditionalBids(AuctionAdConfigAuctionId auction) {
      AbortableAdAuctionResolvedAdditionalBidsParams _message =
          new AbortableAdAuctionResolvedAdditionalBidsParams();
      _message.auction = auction;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void abort() {
      AbortableAdAuctionAbortParams _message = new AbortableAdAuctionAbortParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }
  }

  public static final class Stub extends Interface.Stub<AbortableAdAuction> {
    Stub(Core core, AbortableAdAuction impl) {
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
                AbortableAdAuction_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            AbortableAdAuctionResolvedPromiseParamParams data =
                AbortableAdAuctionResolvedPromiseParamParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().resolvedPromiseParam(data.auction, data.field, data.jsonValue);
            return true;
          case 1:
            AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams data2 =
                AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().resolvedPerBuyerSignalsPromise(data2.auction, data2.perBuyerSignals);
            return true;
          case 2:
            AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams data3 =
                AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().resolvedBuyerTimeoutsPromise(data3.auction, data3.field, data3.buyerTimeouts);
            return true;
          case 3:
            AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams data4 =
                AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().resolvedBuyerCurrenciesPromise(data4.auction, data4.perBuyerCurrencies);
            return true;
          case 4:
            AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams data5 =
                AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .resolvedDirectFromSellerSignalsPromise(
                    data5.auction, data5.directFromSellerSignals);
            return true;
          case 5:
            AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams data6 =
                AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams
                    .deserialize(messageWithHeader.getPayload());
            getImpl()
                .resolvedDirectFromSellerSignalsHeaderAdSlotPromise(
                    data6.auction, data6.directFromSellerSignalsHeaderAdSlot);
            return true;
          case 6:
            AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams data7 =
                AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .resolvedDeprecatedRenderUrlReplacementsPromise(
                    data7.auction, data7.deprecatedRenderUrlReplacements);
            return true;
          case 7:
            AbortableAdAuctionResolvedAuctionAdResponsePromiseParams data8 =
                AbortableAdAuctionResolvedAuctionAdResponsePromiseParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().resolvedAuctionAdResponsePromise(data8.auction, data8.result);
            return true;
          case 8:
            getImpl()
                .resolvedAdditionalBids(
                    AbortableAdAuctionResolvedAdditionalBidsParams.deserialize(
                            messageWithHeader.getPayload())
                        .auction);
            return true;
          case 9:
            AbortableAdAuctionAbortParams.deserialize(messageWithHeader.getPayload());
            getImpl().abort();
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
                getCore(), AbortableAdAuction_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class AbortableAdAuctionResolvedPromiseParamParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public AuctionAdConfigAuctionId auction;
    public int field;
    public String jsonValue;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AbortableAdAuctionResolvedPromiseParamParams(int version) {
      super(40, version);
    }

    public AbortableAdAuctionResolvedPromiseParamParams() {
      this(0);
    }

    public static AbortableAdAuctionResolvedPromiseParamParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AbortableAdAuctionResolvedPromiseParamParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AbortableAdAuctionResolvedPromiseParamParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AbortableAdAuctionResolvedPromiseParamParams result =
            new AbortableAdAuctionResolvedPromiseParamParams(elementsOrVersion);
        result.auction = AuctionAdConfigAuctionId.decode(decoder0, 8);
        int readInt = decoder0.readInt(24);
        result.field = readInt;
        AuctionAdConfigField.validate(readInt);
        result.field = AuctionAdConfigField.toKnownValue(result.field);
        result.jsonValue = decoder0.readString(32, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.auction, 8, false);
      encoder0.encode(this.field, 24);
      encoder0.encode(this.jsonValue, 32, true);
    }
  }

  static final class AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public AuctionAdConfigAuctionId auction;
    public Map<Origin, String> perBuyerSignals;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams(int version) {
      super(32, version);
    }

    public AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams() {
      this(0);
    }

    public static AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams result =
            new AbortableAdAuctionResolvedPerBuyerSignalsPromiseParams(elementsOrVersion);
        result.auction = AuctionAdConfigAuctionId.decode(decoder0, 8);
        Decoder decoder1 = decoder0.readPointer(24, true);
        if (decoder1 == null) {
          result.perBuyerSignals = null;
        } else {
          decoder1.readDataHeaderForMap();
          Decoder decoder2 = decoder1.readPointer(8, false);
          DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
          Origin[] keys0 = new Origin[si2.elementsOrVersion];
          for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
            Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
            keys0[i2] = Origin.decode(decoder3);
          }
          Decoder decoder22 = decoder1.readPointer(16, false);
          DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
          String[] values0 = new String[si22.elementsOrVersion];
          for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
            values0[i22] = decoder22.readString((i22 * 8) + 8, false);
          }
          result.perBuyerSignals = new HashMap();
          for (int index0 = 0; index0 < keys0.length; index0++) {
            result.perBuyerSignals.put(keys0[index0], values0[index0]);
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
      encoder0.encode((Union) this.auction, 8, false);
      if (this.perBuyerSignals == null) {
        encoder0.encodeNullPointer(24, true);
        return;
      }
      Encoder encoder1 = encoder0.encoderForMap(24);
      int size0 = this.perBuyerSignals.size();
      Origin[] keys0 = new Origin[size0];
      String[] values0 = new String[size0];
      int index0 = 0;
      for (Map.Entry<Origin, String> entry0 : this.perBuyerSignals.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode((Struct) keys0[i1], (i1 * 8) + 8, false);
      }
      Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i12 = 0; i12 < values0.length; i12++) {
        encoder22.encode(values0[i12], (i12 * 8) + 8, false);
      }
    }
  }

  static final class AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public AuctionAdConfigAuctionId auction;
    public AuctionAdConfigBuyerTimeouts buyerTimeouts;
    public int field;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams(int version) {
      super(40, version);
    }

    public AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams() {
      this(0);
    }

    public static AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams result =
            new AbortableAdAuctionResolvedBuyerTimeoutsPromiseParams(elementsOrVersion);
        result.auction = AuctionAdConfigAuctionId.decode(decoder0, 8);
        int readInt = decoder0.readInt(24);
        result.field = readInt;
        AuctionAdConfigBuyerTimeoutField.validate(readInt);
        result.field = AuctionAdConfigBuyerTimeoutField.toKnownValue(result.field);
        Decoder decoder1 = decoder0.readPointer(32, false);
        result.buyerTimeouts = AuctionAdConfigBuyerTimeouts.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.auction, 8, false);
      encoder0.encode(this.field, 24);
      encoder0.encode((Struct) this.buyerTimeouts, 32, false);
    }
  }

  static final class AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public AuctionAdConfigAuctionId auction;
    public AuctionAdConfigBuyerCurrencies perBuyerCurrencies;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams(int version) {
      super(32, version);
    }

    public AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams() {
      this(0);
    }

    public static AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams result =
            new AbortableAdAuctionResolvedBuyerCurrenciesPromiseParams(elementsOrVersion);
        result.auction = AuctionAdConfigAuctionId.decode(decoder0, 8);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.perBuyerCurrencies = AuctionAdConfigBuyerCurrencies.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.auction, 8, false);
      encoder0.encode((Struct) this.perBuyerCurrencies, 24, false);
    }
  }

  static final class AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public AuctionAdConfigAuctionId auction;
    public DirectFromSellerSignals directFromSellerSignals;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams(int version) {
      super(32, version);
    }

    public AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams() {
      this(0);
    }

    public static AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams result =
            new AbortableAdAuctionResolvedDirectFromSellerSignalsPromiseParams(elementsOrVersion);
        result.auction = AuctionAdConfigAuctionId.decode(decoder0, 8);
        Decoder decoder1 = decoder0.readPointer(24, true);
        result.directFromSellerSignals = DirectFromSellerSignals.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.auction, 8, false);
      encoder0.encode((Struct) this.directFromSellerSignals, 24, true);
    }
  }

  static final class AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public AuctionAdConfigAuctionId auction;
    public String directFromSellerSignalsHeaderAdSlot;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams(
        int version) {
      super(32, version);
    }

    public AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams() {
      this(0);
    }

    public static AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams result =
            new AbortableAdAuctionResolvedDirectFromSellerSignalsHeaderAdSlotPromiseParams(
                elementsOrVersion);
        result.auction = AuctionAdConfigAuctionId.decode(decoder0, 8);
        result.directFromSellerSignalsHeaderAdSlot = decoder0.readString(24, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.auction, 8, false);
      encoder0.encode(this.directFromSellerSignalsHeaderAdSlot, 24, true);
    }
  }

  static final class AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public AuctionAdConfigAuctionId auction;
    public AdKeywordReplacement[] deprecatedRenderUrlReplacements;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams(int version) {
      super(32, version);
    }

    public AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams() {
      this(0);
    }

    public static AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams
        deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams
        deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams result =
            new AbortableAdAuctionResolvedDeprecatedRenderUrlReplacementsPromiseParams(
                elementsOrVersion);
        result.auction = AuctionAdConfigAuctionId.decode(decoder0, 8);
        Decoder decoder1 = decoder0.readPointer(24, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.deprecatedRenderUrlReplacements = new AdKeywordReplacement[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.deprecatedRenderUrlReplacements[i1] = AdKeywordReplacement.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.auction, 8, false);
      AdKeywordReplacement[] adKeywordReplacementArr = this.deprecatedRenderUrlReplacements;
      if (adKeywordReplacementArr == null) {
        encoder0.encodeNullPointer(24, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(adKeywordReplacementArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        AdKeywordReplacement[] adKeywordReplacementArr2 = this.deprecatedRenderUrlReplacements;
        if (i0 < adKeywordReplacementArr2.length) {
          encoder1.encode((Struct) adKeywordReplacementArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class AbortableAdAuctionResolvedAuctionAdResponsePromiseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public AuctionAdConfigAuctionId auction;
    public BigBuffer result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AbortableAdAuctionResolvedAuctionAdResponsePromiseParams(int version) {
      super(40, version);
    }

    public AbortableAdAuctionResolvedAuctionAdResponsePromiseParams() {
      this(0);
    }

    public static AbortableAdAuctionResolvedAuctionAdResponsePromiseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static AbortableAdAuctionResolvedAuctionAdResponsePromiseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AbortableAdAuctionResolvedAuctionAdResponsePromiseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AbortableAdAuctionResolvedAuctionAdResponsePromiseParams result =
            new AbortableAdAuctionResolvedAuctionAdResponsePromiseParams(elementsOrVersion);
        result.auction = AuctionAdConfigAuctionId.decode(decoder0, 8);
        result.result = BigBuffer.decode(decoder0, 24);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.auction, 8, false);
      encoder0.encode((Union) this.result, 24, false);
    }
  }

  static final class AbortableAdAuctionResolvedAdditionalBidsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AuctionAdConfigAuctionId auction;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AbortableAdAuctionResolvedAdditionalBidsParams(int version) {
      super(24, version);
    }

    public AbortableAdAuctionResolvedAdditionalBidsParams() {
      this(0);
    }

    public static AbortableAdAuctionResolvedAdditionalBidsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AbortableAdAuctionResolvedAdditionalBidsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AbortableAdAuctionResolvedAdditionalBidsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AbortableAdAuctionResolvedAdditionalBidsParams result =
            new AbortableAdAuctionResolvedAdditionalBidsParams(elementsOrVersion);
        result.auction = AuctionAdConfigAuctionId.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.auction, 8, false);
    }
  }

  static final class AbortableAdAuctionAbortParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private AbortableAdAuctionAbortParams(int version) {
      super(8, version);
    }

    public AbortableAdAuctionAbortParams() {
      this(0);
    }

    public static AbortableAdAuctionAbortParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static AbortableAdAuctionAbortParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static AbortableAdAuctionAbortParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        AbortableAdAuctionAbortParams result = new AbortableAdAuctionAbortParams(elementsOrVersion);
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
