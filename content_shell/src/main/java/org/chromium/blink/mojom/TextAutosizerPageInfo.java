package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TextAutosizerPageInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public float deviceScaleAdjustment;
  public int mainFrameLayoutWidth;
  public int mainFrameWidth;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TextAutosizerPageInfo(int version) {
    super(24, version);
  }

  public TextAutosizerPageInfo() {
    this(0);
  }

  public static TextAutosizerPageInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TextAutosizerPageInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TextAutosizerPageInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TextAutosizerPageInfo result = new TextAutosizerPageInfo(elementsOrVersion);
      result.mainFrameWidth = decoder0.readInt(8);
      result.mainFrameLayoutWidth = decoder0.readInt(12);
      result.deviceScaleAdjustment = decoder0.readFloat(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.mainFrameWidth, 8);
    encoder0.encode(this.mainFrameLayoutWidth, 12);
    encoder0.encode(this.deviceScaleAdjustment, 16);
  }
}
