package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HdrMetadataCta8613 extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public int maxContentLightLevel;
  public int maxFrameAverageLightLevel;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HdrMetadataCta8613(int version) {
    super(16, version);
  }

  public HdrMetadataCta8613() {
    this(0);
  }

  public static HdrMetadataCta8613 deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HdrMetadataCta8613 deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HdrMetadataCta8613 decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HdrMetadataCta8613 result = new HdrMetadataCta8613(elementsOrVersion);
      result.maxContentLightLevel = decoder0.readInt(8);
      result.maxFrameAverageLightLevel = decoder0.readInt(12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.maxContentLightLevel, 8);
    encoder0.encode(this.maxFrameAverageLightLevel, 12);
  }
}
