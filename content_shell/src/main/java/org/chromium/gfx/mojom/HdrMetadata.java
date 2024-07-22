package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HdrMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public HdrMetadataCta8613 cta8613;
  public HdrMetadataExtendedRange extendedRange;
  public HdrMetadataNdwl ndwl;
  public HdrMetadataSmpteSt2086 smpteSt2086;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HdrMetadata(int version) {
    super(40, version);
  }

  public HdrMetadata() {
    this(0);
  }

  public static HdrMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HdrMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HdrMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HdrMetadata result = new HdrMetadata(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.smpteSt2086 = HdrMetadataSmpteSt2086.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.cta8613 = HdrMetadataCta8613.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.ndwl = HdrMetadataNdwl.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, true);
      result.extendedRange = HdrMetadataExtendedRange.decode(decoder14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.smpteSt2086, 8, true);
    encoder0.encode((Struct) this.cta8613, 16, true);
    encoder0.encode((Struct) this.ndwl, 24, true);
    encoder0.encode((Struct) this.extendedRange, 32, true);
  }
}
