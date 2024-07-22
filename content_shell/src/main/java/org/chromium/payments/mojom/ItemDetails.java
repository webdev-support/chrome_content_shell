package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class ItemDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public String description;
  public String freeTrialPeriod;
  public Url[] iconUrls;
  public PaymentCurrencyAmount introductoryPrice;
  public int introductoryPriceCycles;
  public String introductoryPricePeriod;
  public String itemId;
  public PaymentCurrencyAmount price;
  public String subscriptionPeriod;
  public String title;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0), new DataHeader(88, 1)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[1];
  }

  private ItemDetails(int version) {
    super(88, version);
  }

  public ItemDetails() {
    this(1);
  }

  public static ItemDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ItemDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ItemDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ItemDetails result = new ItemDetails(elementsOrVersion);
      result.itemId = decoder0.readString(8, false);
      result.title = decoder0.readString(16, false);
      result.description = decoder0.readString(24, false);
      Decoder decoder1 = decoder0.readPointer(32, false);
      result.price = PaymentCurrencyAmount.decode(decoder1);
      result.subscriptionPeriod = decoder0.readString(40, true);
      result.freeTrialPeriod = decoder0.readString(48, true);
      Decoder decoder12 = decoder0.readPointer(56, true);
      result.introductoryPrice = PaymentCurrencyAmount.decode(decoder12);
      result.introductoryPricePeriod = decoder0.readString(64, true);
      if (elementsOrVersion >= 1) {
        result.introductoryPriceCycles = decoder0.readInt(72);
        int readInt = decoder0.readInt(76);
        result.type = readInt;
        ItemType.validate(readInt);
        result.type = ItemType.toKnownValue(result.type);
        Decoder decoder13 = decoder0.readPointer(80, true);
        if (decoder13 == null) {
          result.iconUrls = null;
        } else {
          DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
          result.iconUrls = new Url[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
            Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
            result.iconUrls[i1] = Url.decode(decoder2);
          }
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
    encoder0.encode(this.itemId, 8, false);
    encoder0.encode(this.title, 16, false);
    encoder0.encode(this.description, 24, false);
    encoder0.encode((Struct) this.price, 32, false);
    encoder0.encode(this.subscriptionPeriod, 40, true);
    encoder0.encode(this.freeTrialPeriod, 48, true);
    encoder0.encode((Struct) this.introductoryPrice, 56, true);
    encoder0.encode(this.introductoryPricePeriod, 64, true);
    encoder0.encode(this.introductoryPriceCycles, 72);
    encoder0.encode(this.type, 76);
    Url[] urlArr = this.iconUrls;
    if (urlArr == null) {
      encoder0.encodeNullPointer(80, true);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 80, -1);
    int i0 = 0;
    while (true) {
      Url[] urlArr2 = this.iconUrls;
      if (i0 < urlArr2.length) {
        encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
