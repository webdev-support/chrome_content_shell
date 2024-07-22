package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class CaLayerParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public CaLayerContent content;
  public boolean isEmpty;
  public Size pixelSize;
  public float scaleFactor;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CaLayerParams(int version) {
    super(40, version);
  }

  public CaLayerParams() {
    this(0);
  }

  public static CaLayerParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CaLayerParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CaLayerParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CaLayerParams result = new CaLayerParams(elementsOrVersion);
      result.isEmpty = decoder0.readBoolean(8, 0);
      result.scaleFactor = decoder0.readFloat(12);
      result.content = CaLayerContent.decode(decoder0, 16);
      Decoder decoder1 = decoder0.readPointer(32, false);
      result.pixelSize = Size.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.isEmpty, 8, 0);
    encoder0.encode(this.scaleFactor, 12);
    encoder0.encode((Union) this.content, 16, false);
    encoder0.encode((Struct) this.pixelSize, 32, false);
  }
}
