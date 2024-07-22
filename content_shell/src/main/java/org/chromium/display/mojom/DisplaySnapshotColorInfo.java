package org.chromium.display.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.gfx.mojom.HdrStaticMetadata;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.SkColorSpacePrimaries;

public final class DisplaySnapshotColorInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int bitsPerChannel;
  public ColorSpace colorSpace;
  public float edidGamma;
  public SkColorSpacePrimaries edidPrimaries;
  public HdrStaticMetadata hdrStaticMetadata;
  public boolean supportsColorTemperatureAdjustment;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DisplaySnapshotColorInfo(int version) {
    super(48, version);
  }

  public DisplaySnapshotColorInfo() {
    this(0);
  }

  public static DisplaySnapshotColorInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DisplaySnapshotColorInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DisplaySnapshotColorInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DisplaySnapshotColorInfo result = new DisplaySnapshotColorInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.colorSpace = ColorSpace.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.edidPrimaries = SkColorSpacePrimaries.decode(decoder12);
      result.edidGamma = decoder0.readFloat(24);
      result.supportsColorTemperatureAdjustment = decoder0.readBoolean(28, 0);
      Decoder decoder13 = decoder0.readPointer(32, true);
      result.hdrStaticMetadata = HdrStaticMetadata.decode(decoder13);
      result.bitsPerChannel = decoder0.readInt(40);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.colorSpace, 8, false);
    encoder0.encode((Struct) this.edidPrimaries, 16, false);
    encoder0.encode(this.edidGamma, 24);
    encoder0.encode(this.supportsColorTemperatureAdjustment, 28, 0);
    encoder0.encode((Struct) this.hdrStaticMetadata, 32, true);
    encoder0.encode(this.bitsPerChannel, 40);
  }
}
