package org.chromium.blink.mojom;

import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.url.internal.mojom.Origin;

public final class AuctionAdConfigMaybePromisePerBuyerSignals extends Union {

  private int mPromise;
  private Map<Origin, String> mValue;

  public static final class Tag {
    public static final int Promise = 0;
    public static final int Value = 1;
  }

  public void setPromise(int promise) {
    this.mTag = 0;
    this.mPromise = promise;
  }

  public int getPromise() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mPromise;
  }

  public void setValue(Map<Origin, String> value) {
    this.mTag = 1;
    this.mValue = value;
  }

  public Map<Origin, String> getValue() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mValue;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mPromise, offset + 8);
        return;
      case 1:
        if (this.mValue == null) {
          encoder0.encodeNullPointer(offset + 8, true);
          return;
        }
        Encoder encoder1 = encoder0.encoderForMap(offset + 8);
        int size0 = this.mValue.size();
        Origin[] keys0 = new Origin[size0];
        String[] values0 = new String[size0];
        int index0 = 0;
        for (Map.Entry<Origin, String> entry0 : this.mValue.entrySet()) {
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
        return;
      default:
        return;
    }
  }

  public static AuctionAdConfigMaybePromisePerBuyerSignals deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final AuctionAdConfigMaybePromisePerBuyerSignals decode(
      Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    AuctionAdConfigMaybePromisePerBuyerSignals result =
        new AuctionAdConfigMaybePromisePerBuyerSignals();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mPromise = decoder0.readInt(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder1 = decoder0.readPointer(offset + 8, true);
        if (decoder1 == null) {
          result.mValue = null;
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
          result.mValue = new HashMap();
          for (int index0 = 0; index0 < keys0.length; index0++) {
            result.mValue.put(keys0[index0], values0[index0]);
          }
        }
        result.mTag = 1;
        break;
    }
    return result;
  }
}
