package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AuctionReportBuyerDebugModeConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public Long debugKey;
  public boolean isEnabled;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AuctionReportBuyerDebugModeConfig(int version) {
    super(24, version);
    this.isEnabled = false;
  }

  public AuctionReportBuyerDebugModeConfig() {
    this(0);
  }

  public static AuctionReportBuyerDebugModeConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AuctionReportBuyerDebugModeConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AuctionReportBuyerDebugModeConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AuctionReportBuyerDebugModeConfig result =
          new AuctionReportBuyerDebugModeConfig(elementsOrVersion);
      result.isEnabled = decoder0.readBoolean(8, 0);
      if (decoder0.readBoolean(8, 1)) {
        result.debugKey = new Long(decoder0.readLong(16));
      } else {
        result.debugKey = null;
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    long debugKey$value;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.isEnabled, 8, 0);
    Long l = this.debugKey;
    boolean debugKey$flag = l != null;
    if (debugKey$flag) {
      debugKey$value = l.longValue();
    } else {
      debugKey$value = 0;
    }
    encoder0.encode(debugKey$flag, 8, 1);
    encoder0.encode(debugKey$value, 16);
  }
}
