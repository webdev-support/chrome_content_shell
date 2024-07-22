package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CapturedWheelAction extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public double relativeX;
  public double relativeY;
  public int wheelDeltaX;
  public int wheelDeltaY;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CapturedWheelAction(int version) {
    super(32, version);
  }

  public CapturedWheelAction() {
    this(0);
  }

  public static CapturedWheelAction deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CapturedWheelAction deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CapturedWheelAction decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CapturedWheelAction result = new CapturedWheelAction(elementsOrVersion);
      result.relativeX = decoder0.readDouble(8);
      result.relativeY = decoder0.readDouble(16);
      result.wheelDeltaX = decoder0.readInt(24);
      result.wheelDeltaY = decoder0.readInt(28);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.relativeX, 8);
    encoder0.encode(this.relativeY, 16);
    encoder0.encode(this.wheelDeltaX, 24);
    encoder0.encode(this.wheelDeltaY, 28);
  }
}
