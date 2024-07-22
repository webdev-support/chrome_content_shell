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
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class DirectFromSellerSignals extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public DirectFromSellerSignalsSubresource auctionSignals;
  public Map<Origin, DirectFromSellerSignalsSubresource> perBuyerSignals;
  public Url prefix;
  public DirectFromSellerSignalsSubresource sellerSignals;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DirectFromSellerSignals(int version) {
    super(40, version);
  }

  public DirectFromSellerSignals() {
    this(0);
  }

  public static DirectFromSellerSignals deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DirectFromSellerSignals deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DirectFromSellerSignals decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DirectFromSellerSignals result = new DirectFromSellerSignals(elementsOrVersion);
      result.prefix = Url.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
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
      DirectFromSellerSignalsSubresource[] values0 =
          new DirectFromSellerSignalsSubresource[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        Decoder decoder32 = decoder22.readPointer((i22 * 8) + 8, false);
        values0[i22] = DirectFromSellerSignalsSubresource.decode(decoder32);
      }
      result.perBuyerSignals = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.perBuyerSignals.put(keys0[index0], values0[index0]);
      }
      result.sellerSignals =
          DirectFromSellerSignalsSubresource.decode(decoder0.readPointer(24, true));
      result.auctionSignals =
          DirectFromSellerSignalsSubresource.decode(decoder0.readPointer(32, true));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.prefix, 8, false);
    if (this.perBuyerSignals == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(16);
      int size0 = this.perBuyerSignals.size();
      Origin[] keys0 = new Origin[size0];
      DirectFromSellerSignalsSubresource[] values0 = new DirectFromSellerSignalsSubresource[size0];
      int index0 = 0;
      for (Map.Entry<Origin, DirectFromSellerSignalsSubresource> entry0 :
          this.perBuyerSignals.entrySet()) {
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
        encoder22.encode((Struct) values0[i12], (i12 * 8) + 8, false);
      }
    }
    encoder0.encode((Struct) this.sellerSignals, 24, true);
    encoder0.encode((Struct) this.auctionSignals, 32, true);
  }
}
