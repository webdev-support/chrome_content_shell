package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.SizeF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class IntrinsicSizingInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public SizeF aspectRatio;
  public boolean hasHeight;
  public boolean hasWidth;
  public SizeF size;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private IntrinsicSizingInfo(int version) {
    super(32, version);
  }

  public IntrinsicSizingInfo() {
    this(0);
  }

  public static IntrinsicSizingInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static IntrinsicSizingInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static IntrinsicSizingInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      IntrinsicSizingInfo result = new IntrinsicSizingInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.size = SizeF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.aspectRatio = SizeF.decode(decoder12);
      result.hasWidth = decoder0.readBoolean(24, 0);
      result.hasHeight = decoder0.readBoolean(24, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.size, 8, false);
    encoder0.encode((Struct) this.aspectRatio, 16, false);
    encoder0.encode(this.hasWidth, 24, 0);
    encoder0.encode(this.hasHeight, 24, 1);
  }
}
