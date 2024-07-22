package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class GestureSwipeData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean down;
  public boolean left;
  public boolean right;
  public boolean up;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GestureSwipeData(int version) {
    super(16, version);
  }

  public GestureSwipeData() {
    this(0);
  }

  public static GestureSwipeData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GestureSwipeData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GestureSwipeData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GestureSwipeData result = new GestureSwipeData(elementsOrVersion);
      result.left = decoder0.readBoolean(8, 0);
      result.right = decoder0.readBoolean(8, 1);
      result.up = decoder0.readBoolean(8, 2);
      result.down = decoder0.readBoolean(8, 3);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.left, 8, 0);
    encoder0.encode(this.right, 8, 1);
    encoder0.encode(this.up, 8, 2);
    encoder0.encode(this.down, 8, 3);
  }
}
