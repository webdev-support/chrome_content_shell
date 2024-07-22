package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TouchPoint extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public PointerData pointerData;
  public float radiusX;
  public float radiusY;
  public float rotationAngle;
  public int state;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TouchPoint(int version) {
    super(32, version);
  }

  public TouchPoint() {
    this(0);
  }

  public static TouchPoint deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TouchPoint deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TouchPoint decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TouchPoint result = new TouchPoint(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.state = readInt;
      TouchState.validate(readInt);
      result.state = TouchState.toKnownValue(result.state);
      result.radiusX = decoder0.readFloat(12);
      result.radiusY = decoder0.readFloat(16);
      result.rotationAngle = decoder0.readFloat(20);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.pointerData = PointerData.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.state, 8);
    encoder0.encode(this.radiusX, 12);
    encoder0.encode(this.radiusY, 16);
    encoder0.encode(this.rotationAngle, 20);
    encoder0.encode((Struct) this.pointerData, 24, false);
  }
}
