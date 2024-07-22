package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.Uint128;
import org.chromium.mojo_base.mojom.Uuid;
import org.chromium.url.internal.mojom.Origin;

public final class AuctionAdConfigNonSharedParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 232;
  private static final DataHeader[] VERSION_ARRAY;
  public short allBuyersGroupLimit;
  public short allBuyersMultiBidLimit;
  public Map<String, Double> allBuyersPrioritySignals;
  public AdSize[] allSlotsRequestedSizes;
  public Uuid auctionNonce;
  public AuctionReportBuyerDebugModeConfig auctionReportBuyerDebugModeConfig;
  public Uint128[] auctionReportBuyerKeys;
  public Map<Integer, AuctionReportBuyersConfig> auctionReportBuyers;
  public AuctionAdConfigMaybePromiseJson auctionSignals;
  public AuctionAdConfigMaybePromiseBuyerTimeouts buyerCumulativeTimeouts;
  public AuctionAdConfigMaybePromiseBuyerCurrencies buyerCurrencies;
  public AuctionAdConfigMaybePromiseBuyerTimeouts buyerTimeouts;
  public AuctionAdConfig[] componentAuctions;
  public Origin[] interestGroupBuyers;
  public int maxTrustedScoringSignalsUrlLength;
  public Map<Origin, Short> perBuyerGroupLimits;
  public Map<Origin, Short> perBuyerMultiBidLimits;
  public Map<Origin, Map<String, Double>> perBuyerPrioritySignals;
  public AuctionAdConfigMaybePromisePerBuyerSignals perBuyerSignals;
  public AdSize requestedSize;
  public SellerCapabilities requiredSellerCapabilities;
  public AdCurrency sellerCurrency;
  public AuctionAdConfigMaybePromiseJson sellerSignals;
  public TimeDelta sellerTimeout;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(232, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class BuyerReportType {
    public static final int BID_COUNT = 1;
    public static final int INTEREST_GROUP_COUNT = 0;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 3;
    public static final int MIN_VALUE = 0;
    public static final int TOTAL_GENERATE_BID_LATENCY = 2;
    public static final int TOTAL_SIGNALS_FETCH_LATENCY = 3;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private BuyerReportType() {}
  }

  private AuctionAdConfigNonSharedParams(int version) {
    super(232, version);
    this.allBuyersGroupLimit = (short) -1;
    this.maxTrustedScoringSignalsUrlLength = 0;
  }

  public AuctionAdConfigNonSharedParams() {
    this(0);
  }

  public static AuctionAdConfigNonSharedParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AuctionAdConfigNonSharedParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AuctionAdConfigNonSharedParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AuctionAdConfigNonSharedParams result = new AuctionAdConfigNonSharedParams(elementsOrVersion);
      int i = 8;
      Decoder decoder1 = decoder0.readPointer(8, true);
      int i2 = -1;
      boolean z = false;
      if (decoder1 == null) {
        result.interestGroupBuyers = null;
      } else {
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.interestGroupBuyers = new Origin[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.interestGroupBuyers[i1] = Origin.decode(decoder1.readPointer((i1 * 8) + 8, false));
        }
      }
      result.auctionSignals = AuctionAdConfigMaybePromiseJson.decode(decoder0, 16);
      result.sellerSignals = AuctionAdConfigMaybePromiseJson.decode(decoder0, 32);
      result.sellerTimeout = TimeDelta.decode(decoder0.readPointer(48, true));
      result.perBuyerSignals = AuctionAdConfigMaybePromisePerBuyerSignals.decode(decoder0, 56);
      result.buyerTimeouts = AuctionAdConfigMaybePromiseBuyerTimeouts.decode(decoder0, 72);
      result.sellerCurrency = AdCurrency.decode(decoder0.readPointer(88, true));
      result.buyerCurrencies = AuctionAdConfigMaybePromiseBuyerCurrencies.decode(decoder0, 96);
      result.buyerCumulativeTimeouts =
          AuctionAdConfigMaybePromiseBuyerTimeouts.decode(decoder0, 112);
      Decoder decoder12 = decoder0.readPointer(128, false);
      decoder12.readDataHeaderForMap();
      Decoder decoder2 = decoder12.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      Origin[] keys0 = new Origin[si2.elementsOrVersion];
      for (int i22 = 0; i22 < si2.elementsOrVersion; i22++) {
        keys0[i22] = Origin.decode(decoder2.readPointer((i22 * 8) + 8, false));
      }
      short[] values0 = decoder12.readShorts(16, 0, keys0.length);
      result.perBuyerGroupLimits = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.perBuyerGroupLimits.put(keys0[index0], Short.valueOf(values0[index0]));
      }
      Decoder decoder13 = decoder0.readPointer(136, true);
      if (decoder13 == null) {
        result.perBuyerPrioritySignals = null;
      } else {
        decoder13.readDataHeaderForMap();
        Decoder decoder22 = decoder13.readPointer(8, false);
        DataHeader si22 = decoder22.readDataHeaderForPointerArray(-1);
        Origin[] keys02 = new Origin[si22.elementsOrVersion];
        for (int i23 = 0; i23 < si22.elementsOrVersion; i23++) {
          keys02[i23] = Origin.decode(decoder22.readPointer((i23 * 8) + 8, false));
        }
        Decoder decoder23 = decoder13.readPointer(16, false);
        DataHeader si23 = decoder23.readDataHeaderForPointerArray(keys02.length);
        Map<String, Double>[] values02 = new Map[si23.elementsOrVersion];
        int i24 = 0;
        while (i24 < si23.elementsOrVersion) {
          Decoder decoder3 = decoder23.readPointer((i24 * 8) + i, z);
          decoder3.readDataHeaderForMap();
          Decoder decoder4 = decoder3.readPointer(i, z);
          DataHeader si4 = decoder4.readDataHeaderForPointerArray(i2);
          String[] keys2 = new String[si4.elementsOrVersion];
          int i4 = 0;
          while (i4 < si4.elementsOrVersion) {
            keys2[i4] = decoder4.readString((i4 * 8) + 8, false);
            i4++;
            mainDataHeader = mainDataHeader;
          }
          DataHeader mainDataHeader2 = mainDataHeader;
          double[] values2 = decoder3.readDoubles(16, 0, keys2.length);
          values02[i24] = new HashMap();
          for (int index2 = 0; index2 < keys2.length; index2++) {
            values02[i24].put(keys2[index2], Double.valueOf(values2[index2]));
          }
          i24++;
          mainDataHeader = mainDataHeader2;
          i = 8;
          i2 = -1;
          z = false;
        }
        result.perBuyerPrioritySignals = new HashMap();
        for (int index02 = 0; index02 < keys02.length; index02++) {
          result.perBuyerPrioritySignals.put(keys02[index02], values02[index02]);
        }
      }
      Decoder decoder14 = decoder0.readPointer(144, true);
      if (decoder14 == null) {
        result.allBuyersPrioritySignals = null;
      } else {
        decoder14.readDataHeaderForMap();
        Decoder decoder24 = decoder14.readPointer(8, false);
        DataHeader si24 = decoder24.readDataHeaderForPointerArray(-1);
        String[] keys03 = new String[si24.elementsOrVersion];
        for (int i25 = 0; i25 < si24.elementsOrVersion; i25++) {
          keys03[i25] = decoder24.readString((i25 * 8) + 8, false);
        }
        double[] values03 = decoder14.readDoubles(16, 0, keys03.length);
        result.allBuyersPrioritySignals = new HashMap();
        for (int index03 = 0; index03 < keys03.length; index03++) {
          result.allBuyersPrioritySignals.put(keys03[index03], Double.valueOf(values03[index03]));
        }
      }
      result.allBuyersGroupLimit = decoder0.readShort(152);
      result.allBuyersMultiBidLimit = decoder0.readShort(154);
      result.maxTrustedScoringSignalsUrlLength = decoder0.readInt(156);
      Decoder decoder15 = decoder0.readPointer(160, true);
      if (decoder15 == null) {
        result.auctionReportBuyerKeys = null;
      } else {
        DataHeader si12 = decoder15.readDataHeaderForPointerArray(-1);
        result.auctionReportBuyerKeys = new Uint128[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          result.auctionReportBuyerKeys[i12] =
              Uint128.decode(decoder15.readPointer((i12 * 8) + 8, false));
        }
      }
      Decoder decoder16 = decoder0.readPointer(168, true);
      if (decoder16 == null) {
        result.auctionReportBuyers = null;
      } else {
        decoder16.readDataHeaderForMap();
        int[] keys04 = decoder16.readInts(8, 0, -1);
        for (int i3 : keys04) {
          BuyerReportType.validate(i3);
        }
        Decoder decoder25 = decoder16.readPointer(16, false);
        DataHeader si25 = decoder25.readDataHeaderForPointerArray(keys04.length);
        AuctionReportBuyersConfig[] values04 =
            new AuctionReportBuyersConfig[si25.elementsOrVersion];
        for (int i26 = 0; i26 < si25.elementsOrVersion; i26++) {
          values04[i26] =
              AuctionReportBuyersConfig.decode(decoder25.readPointer((i26 * 8) + 8, false));
        }
        result.auctionReportBuyers = new HashMap();
        for (int index04 = 0; index04 < keys04.length; index04++) {
          result.auctionReportBuyers.put(Integer.valueOf(keys04[index04]), values04[index04]);
        }
      }
      result.auctionReportBuyerDebugModeConfig =
          AuctionReportBuyerDebugModeConfig.decode(decoder0.readPointer(176, true));
      result.requiredSellerCapabilities =
          SellerCapabilities.decode(decoder0.readPointer(184, false));
      result.requestedSize = AdSize.decode(decoder0.readPointer(192, true));
      Decoder decoder17 = decoder0.readPointer(200, true);
      if (decoder17 == null) {
        result.allSlotsRequestedSizes = null;
      } else {
        DataHeader si13 = decoder17.readDataHeaderForPointerArray(-1);
        result.allSlotsRequestedSizes = new AdSize[si13.elementsOrVersion];
        for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
          result.allSlotsRequestedSizes[i13] =
              AdSize.decode(decoder17.readPointer((i13 * 8) + 8, false));
        }
      }
      Decoder decoder18 = decoder0.readPointer(208, false);
      decoder18.readDataHeaderForMap();
      Decoder decoder26 = decoder18.readPointer(8, false);
      DataHeader si26 = decoder26.readDataHeaderForPointerArray(-1);
      Origin[] keys05 = new Origin[si26.elementsOrVersion];
      for (int i27 = 0; i27 < si26.elementsOrVersion; i27++) {
        keys05[i27] = Origin.decode(decoder26.readPointer((i27 * 8) + 8, false));
      }
      short[] values05 = decoder18.readShorts(16, 0, keys05.length);
      result.perBuyerMultiBidLimits = new HashMap();
      for (int index05 = 0; index05 < keys05.length; index05++) {
        result.perBuyerMultiBidLimits.put(keys05[index05], Short.valueOf(values05[index05]));
      }
      result.auctionNonce = Uuid.decode(decoder0.readPointer(216, true));
      Decoder decoder19 = decoder0.readPointer(CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, false);
      DataHeader si14 = decoder19.readDataHeaderForPointerArray(-1);
      result.componentAuctions = new AuctionAdConfig[si14.elementsOrVersion];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        result.componentAuctions[i14] =
            AuctionAdConfig.decode(decoder19.readPointer((i14 * 8) + 8, false));
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder1;
    int size0;
    boolean z;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    Origin[] originArr = this.interestGroupBuyers;
    int i = -1;
    boolean z2 = false;
    int i2 = 8;
    if (originArr == null) {
      encoder0.encodeNullPointer(8, true);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(originArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Origin[] originArr2 = this.interestGroupBuyers;
        if (i0 >= originArr2.length) {
          break;
        }
        encoder12.encode((Struct) originArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Union) this.auctionSignals, 16, false);
    encoder0.encode((Union) this.sellerSignals, 32, false);
    encoder0.encode((Struct) this.sellerTimeout, 48, true);
    encoder0.encode((Union) this.perBuyerSignals, 56, false);
    encoder0.encode((Union) this.buyerTimeouts, 72, false);
    encoder0.encode((Struct) this.sellerCurrency, 88, true);
    encoder0.encode((Union) this.buyerCurrencies, 96, false);
    encoder0.encode((Union) this.buyerCumulativeTimeouts, 112, false);
    if (this.perBuyerGroupLimits == null) {
      encoder0.encodeNullPointer(128, false);
    } else {
      Encoder encoder13 = encoder0.encoderForMap(128);
      int size02 = this.perBuyerGroupLimits.size();
      Origin[] keys0 = new Origin[size02];
      short[] values0 = new short[size02];
      int index0 = 0;
      for (Map.Entry<Origin, Short> entry0 : this.perBuyerGroupLimits.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue().shortValue();
        index0++;
      }
      Encoder encoder2 = encoder13.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode((Struct) keys0[i1], (i1 * 8) + 8, false);
      }
      encoder13.encode(values0, 16, 0, -1);
    }
    if (this.perBuyerPrioritySignals == null) {
      encoder0.encodeNullPointer(136, true);
    } else {
      Encoder encoder14 = encoder0.encoderForMap(136);
      int size03 = this.perBuyerPrioritySignals.size();
      Origin[] keys02 = new Origin[size03];
      Map<String, Double>[] values02 = new Map[size03];
      int index02 = 0;
      for (Map.Entry<Origin, Map<String, Double>> entry02 :
          this.perBuyerPrioritySignals.entrySet()) {
        keys02[index02] = entry02.getKey();
        values02[index02] = entry02.getValue();
        index02++;
      }
      Encoder encoder22 = encoder14.encodePointerArray(keys02.length, 8, -1);
      for (int i12 = 0; i12 < keys02.length; i12++) {
        encoder22.encode((Struct) keys02[i12], (i12 * 8) + 8, false);
      }
      Encoder encoder23 = encoder14.encodePointerArray(values02.length, 16, -1);
      int i13 = 0;
      while (i13 < values02.length) {
        if (values02[i13] == null) {
          encoder23.encodeNullPointer((i13 * 8) + i2, z2);
          encoder1 = encoder14;
          size0 = size03;
        } else {
          Encoder encoder3 = encoder23.encoderForMap((i13 * 8) + i2);
          int size2 = values02[i13].size();
          String[] keys2 = new String[size2];
          double[] values2 = new double[size2];
          int index2 = 0;
          for (Map.Entry<String, Double> entry2 : values02[i13].entrySet()) {
            keys2[index2] = entry2.getKey();
            values2[index2] = entry2.getValue().doubleValue();
            index2++;
          }
          Encoder encoder4 = encoder3.encodePointerArray(keys2.length, i2, i);
          int i3 = 0;
          while (i3 < keys2.length) {
            encoder4.encode(keys2[i3], (i3 * 8) + 8, false);
            i3++;
            size03 = size03;
            encoder14 = encoder14;
          }
          encoder1 = encoder14;
          size0 = size03;
          encoder3.encode(values2, 16, 0, -1);
        }
        i13++;
        size03 = size0;
        encoder14 = encoder1;
        i = -1;
        z2 = false;
        i2 = 8;
      }
    }
    if (this.allBuyersPrioritySignals == null) {
      encoder0.encodeNullPointer(144, true);
    } else {
      Encoder encoder15 = encoder0.encoderForMap(144);
      int size04 = this.allBuyersPrioritySignals.size();
      String[] keys03 = new String[size04];
      double[] values03 = new double[size04];
      int index03 = 0;
      for (Map.Entry<String, Double> entry03 : this.allBuyersPrioritySignals.entrySet()) {
        keys03[index03] = entry03.getKey();
        values03[index03] = entry03.getValue().doubleValue();
        index03++;
      }
      int i4 = 8;
      Encoder encoder24 = encoder15.encodePointerArray(keys03.length, 8, -1);
      int i14 = 0;
      while (i14 < keys03.length) {
        encoder24.encode(keys03[i14], (i14 * 8) + i4, false);
        i14++;
        i4 = 8;
      }
      encoder15.encode(values03, 16, 0, -1);
    }
    encoder0.encode(this.allBuyersGroupLimit, 152);
    encoder0.encode(this.allBuyersMultiBidLimit, 154);
    encoder0.encode(this.maxTrustedScoringSignalsUrlLength, 156);
    Uint128[] uint128Arr = this.auctionReportBuyerKeys;
    if (uint128Arr == null) {
      encoder0.encodeNullPointer(160, true);
    } else {
      Encoder encoder16 = encoder0.encodePointerArray(uint128Arr.length, 160, -1);
      int i02 = 0;
      while (true) {
        Uint128[] uint128Arr2 = this.auctionReportBuyerKeys;
        if (i02 >= uint128Arr2.length) {
          break;
        }
        encoder16.encode((Struct) uint128Arr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    if (this.auctionReportBuyers == null) {
      encoder0.encodeNullPointer(168, true);
    } else {
      Encoder encoder17 = encoder0.encoderForMap(168);
      int size05 = this.auctionReportBuyers.size();
      int[] keys04 = new int[size05];
      AuctionReportBuyersConfig[] values04 = new AuctionReportBuyersConfig[size05];
      int index04 = 0;
      for (Map.Entry<Integer, AuctionReportBuyersConfig> entry04 :
          this.auctionReportBuyers.entrySet()) {
        keys04[index04] = entry04.getKey().intValue();
        values04[index04] = entry04.getValue();
        index04++;
      }
      encoder17.encode(keys04, 8, 0, -1);
      Encoder encoder25 = encoder17.encodePointerArray(values04.length, 16, -1);
      for (int i15 = 0; i15 < values04.length; i15++) {
        encoder25.encode((Struct) values04[i15], (i15 * 8) + 8, false);
      }
    }
    encoder0.encode((Struct) this.auctionReportBuyerDebugModeConfig, 176, true);
    encoder0.encode((Struct) this.requiredSellerCapabilities, 184, false);
    encoder0.encode((Struct) this.requestedSize, 192, true);
    AdSize[] adSizeArr = this.allSlotsRequestedSizes;
    if (adSizeArr == null) {
      encoder0.encodeNullPointer(200, true);
    } else {
      Encoder encoder18 = encoder0.encodePointerArray(adSizeArr.length, 200, -1);
      int i03 = 0;
      while (true) {
        AdSize[] adSizeArr2 = this.allSlotsRequestedSizes;
        if (i03 >= adSizeArr2.length) {
          break;
        }
        encoder18.encode((Struct) adSizeArr2[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    if (this.perBuyerMultiBidLimits == null) {
      encoder0.encodeNullPointer(208, false);
      z = false;
    } else {
      Encoder encoder19 = encoder0.encoderForMap(208);
      int size06 = this.perBuyerMultiBidLimits.size();
      Origin[] keys05 = new Origin[size06];
      short[] values05 = new short[size06];
      int index05 = 0;
      for (Map.Entry<Origin, Short> entry05 : this.perBuyerMultiBidLimits.entrySet()) {
        keys05[index05] = entry05.getKey();
        values05[index05] = entry05.getValue().shortValue();
        index05++;
      }
      int i5 = 8;
      Encoder encoder26 = encoder19.encodePointerArray(keys05.length, 8, -1);
      int i16 = 0;
      while (i16 < keys05.length) {
        encoder26.encode((Struct) keys05[i16], (i16 * 8) + i5, false);
        i16++;
        i5 = 8;
      }
      z = false;
      encoder19.encode(values05, 16, 0, -1);
    }
    encoder0.encode((Struct) this.auctionNonce, 216, true);
    AuctionAdConfig[] auctionAdConfigArr = this.componentAuctions;
    if (auctionAdConfigArr == null) {
      encoder0.encodeNullPointer(CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, z);
      return;
    }
    Encoder encoder110 =
        encoder0.encodePointerArray(
            auctionAdConfigArr.length, CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, -1);
    int i04 = 0;
    while (true) {
      AuctionAdConfig[] auctionAdConfigArr2 = this.componentAuctions;
      if (i04 < auctionAdConfigArr2.length) {
        encoder110.encode((Struct) auctionAdConfigArr2[i04], (i04 * 8) + 8, false);
        i04++;
      } else {
        return;
      }
    }
  }
}
