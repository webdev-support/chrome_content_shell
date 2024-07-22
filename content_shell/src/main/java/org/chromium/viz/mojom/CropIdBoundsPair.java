package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Token;

public final class CropIdBoundsPair extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public Rect bounds;
  public Token cropId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CropIdBoundsPair(int version) {
    super(24, version);
  }

  public CropIdBoundsPair() {
    this(0);
  }

  public static CropIdBoundsPair deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CropIdBoundsPair deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CropIdBoundsPair decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CropIdBoundsPair result = new CropIdBoundsPair(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.cropId = Token.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.bounds = Rect.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.cropId, 8, false);
    encoder0.encode((Struct) this.bounds, 16, false);
  }
}
