package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;

public final class AdAuctionData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public String interestGroupName;
  public Origin interestGroupOwner;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AdAuctionData(int version) {
    super(24, version);
  }

  public AdAuctionData() {
    this(0);
  }

  public static AdAuctionData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AdAuctionData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AdAuctionData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AdAuctionData result = new AdAuctionData(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.interestGroupOwner = Origin.decode(decoder1);
      result.interestGroupName = decoder0.readString(16, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.interestGroupOwner, 8, false);
    encoder0.encode(this.interestGroupName, 16, false);
  }
}