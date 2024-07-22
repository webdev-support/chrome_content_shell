package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class AuctionAdConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 104;
  private static final DataHeader[] VERSION_ARRAY;
  public Origin aggregationCoordinatorOrigin;
  public Short allBuyerExperimentGroupId;
  public AuctionAdConfigNonSharedParams auctionAdConfigNonSharedParams;
  public Url decisionLogicUrl;
  public AuctionAdConfigMaybePromiseDeprecatedRenderUrlReplacements deprecatedRenderUrlReplacements;
  public AuctionAdConfigMaybePromiseDirectFromSellerSignals directFromSellerSignals;
  public boolean expectsAdditionalBids;
  public boolean expectsDirectFromSellerSignalsHeaderAdSlot;
  public Map<Origin, Short> perBuyerExperimentGroupIds;
  public Origin seller;
  public Short sellerExperimentGroupId;
  public AuctionAdServerResponseConfig serverResponse;
  public Url trustedScoringSignalsUrl;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(104, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AuctionAdConfig(int version) {
    super(104, version);
    this.expectsDirectFromSellerSignalsHeaderAdSlot = false;
    this.expectsAdditionalBids = false;
  }

  public AuctionAdConfig() {
    this(0);
  }

  public static AuctionAdConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AuctionAdConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AuctionAdConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AuctionAdConfig result = new AuctionAdConfig(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.seller = Origin.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.serverResponse = AuctionAdServerResponseConfig.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.decisionLogicUrl = Url.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, true);
      result.trustedScoringSignalsUrl = Url.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(40, false);
      result.auctionAdConfigNonSharedParams = AuctionAdConfigNonSharedParams.decode(decoder15);
      result.directFromSellerSignals =
          AuctionAdConfigMaybePromiseDirectFromSellerSignals.decode(decoder0, 48);
      result.deprecatedRenderUrlReplacements =
          AuctionAdConfigMaybePromiseDeprecatedRenderUrlReplacements.decode(decoder0, 64);
      result.expectsDirectFromSellerSignalsHeaderAdSlot = decoder0.readBoolean(80, 0);
      if (decoder0.readBoolean(80, 1)) {
        result.sellerExperimentGroupId = new Short(decoder0.readShort(82));
      } else {
        result.sellerExperimentGroupId = null;
      }
      if (decoder0.readBoolean(80, 2)) {
        result.allBuyerExperimentGroupId = new Short(decoder0.readShort(84));
      } else {
        result.allBuyerExperimentGroupId = null;
      }
      result.expectsAdditionalBids = decoder0.readBoolean(80, 3);
      Decoder decoder16 = decoder0.readPointer(88, false);
      decoder16.readDataHeaderForMap();
      Decoder decoder2 = decoder16.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      Origin[] keys0 = new Origin[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
        keys0[i2] = Origin.decode(decoder3);
      }
      short[] values0 = decoder16.readShorts(16, 0, keys0.length);
      result.perBuyerExperimentGroupIds = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.perBuyerExperimentGroupIds.put(keys0[index0], Short.valueOf(values0[index0]));
      }
      Decoder decoder17 = decoder0.readPointer(96, true);
      result.aggregationCoordinatorOrigin = Origin.decode(decoder17);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    short sellerExperimentGroupId$value;
    short allBuyerExperimentGroupId$value;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.seller, 8, false);
    encoder0.encode((Struct) this.serverResponse, 16, true);
    encoder0.encode((Struct) this.decisionLogicUrl, 24, true);
    encoder0.encode((Struct) this.trustedScoringSignalsUrl, 32, true);
    encoder0.encode((Struct) this.auctionAdConfigNonSharedParams, 40, false);
    encoder0.encode((Union) this.directFromSellerSignals, 48, false);
    encoder0.encode((Union) this.deprecatedRenderUrlReplacements, 64, false);
    encoder0.encode(this.expectsDirectFromSellerSignalsHeaderAdSlot, 80, 0);
    Short sh = this.sellerExperimentGroupId;
    boolean sellerExperimentGroupId$flag = sh != null;
    if (sellerExperimentGroupId$flag) {
      sellerExperimentGroupId$value = sh.shortValue();
    } else {
      sellerExperimentGroupId$value = 0;
    }
    encoder0.encode(sellerExperimentGroupId$flag, 80, 1);
    encoder0.encode(sellerExperimentGroupId$value, 82);
    Short sh2 = this.allBuyerExperimentGroupId;
    boolean allBuyerExperimentGroupId$flag = sh2 != null;
    if (allBuyerExperimentGroupId$flag) {
      allBuyerExperimentGroupId$value = sh2.shortValue();
    } else {
      allBuyerExperimentGroupId$value = 0;
    }
    encoder0.encode(allBuyerExperimentGroupId$flag, 80, 2);
    encoder0.encode(allBuyerExperimentGroupId$value, 84);
    encoder0.encode(this.expectsAdditionalBids, 80, 3);
    if (this.perBuyerExperimentGroupIds == null) {
      encoder0.encodeNullPointer(88, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(88);
      int size0 = this.perBuyerExperimentGroupIds.size();
      Origin[] keys0 = new Origin[size0];
      short[] values0 = new short[size0];
      int index0 = 0;
      for (Map.Entry<Origin, Short> entry0 : this.perBuyerExperimentGroupIds.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue().shortValue();
        index0++;
      }
      Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode((Struct) keys0[i1], (i1 * 8) + 8, false);
      }
      encoder1.encode(values0, 16, 0, -1);
    }
    encoder0.encode((Struct) this.aggregationCoordinatorOrigin, 96, true);
  }
}
