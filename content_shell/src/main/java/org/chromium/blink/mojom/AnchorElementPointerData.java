package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AnchorElementPointerData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean isMousePointer;
  public double mouseAcceleration;
  public double mouseVelocity;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AnchorElementPointerData(int version) {
    super(32, version);
  }

  public AnchorElementPointerData() {
    this(0);
  }

  public static AnchorElementPointerData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AnchorElementPointerData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AnchorElementPointerData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AnchorElementPointerData result = new AnchorElementPointerData(elementsOrVersion);
      result.isMousePointer = decoder0.readBoolean(8, 0);
      result.mouseVelocity = decoder0.readDouble(16);
      result.mouseAcceleration = decoder0.readDouble(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.isMousePointer, 8, 0);
    encoder0.encode(this.mouseVelocity, 16);
    encoder0.encode(this.mouseAcceleration, 24);
  }
}
