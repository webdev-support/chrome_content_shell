package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.SkColorSpacePrimaries;

public final class HdrMetadataSmpteSt2086 extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public float luminanceMax;
  public float luminanceMin;
  public SkColorSpacePrimaries primaries;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HdrMetadataSmpteSt2086(int version) {
    super(24, version);
  }

  public HdrMetadataSmpteSt2086() {
    this(0);
  }

  public static HdrMetadataSmpteSt2086 deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HdrMetadataSmpteSt2086 deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HdrMetadataSmpteSt2086 decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HdrMetadataSmpteSt2086 result = new HdrMetadataSmpteSt2086(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.primaries = SkColorSpacePrimaries.decode(decoder1);
      result.luminanceMax = decoder0.readFloat(16);
      result.luminanceMin = decoder0.readFloat(20);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.primaries, 8, false);
    encoder0.encode(this.luminanceMax, 16);
    encoder0.encode(this.luminanceMin, 20);
  }
}
