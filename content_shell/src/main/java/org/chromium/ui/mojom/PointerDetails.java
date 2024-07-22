package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PointerDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public float force;
  public int id;
  public int offsetX;
  public int offsetY;
  public int pointerType;
  public float radiusX;
  public float radiusY;
  public float tangentialPressure;
  public float tiltX;
  public float tiltY;
  public float twist;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PointerDetails(int version) {
    super(56, version);
  }

  public PointerDetails() {
    this(0);
  }

  public static PointerDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PointerDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PointerDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PointerDetails result = new PointerDetails(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.pointerType = readInt;
      EventPointerType.validate(readInt);
      result.pointerType = EventPointerType.toKnownValue(result.pointerType);
      result.radiusX = decoder0.readFloat(12);
      result.radiusY = decoder0.readFloat(16);
      result.force = decoder0.readFloat(20);
      result.tiltX = decoder0.readFloat(24);
      result.tiltY = decoder0.readFloat(28);
      result.tangentialPressure = decoder0.readFloat(32);
      result.twist = decoder0.readFloat(36);
      result.id = decoder0.readInt(40);
      result.offsetX = decoder0.readInt(44);
      result.offsetY = decoder0.readInt(48);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.pointerType, 8);
    encoder0.encode(this.radiusX, 12);
    encoder0.encode(this.radiusY, 16);
    encoder0.encode(this.force, 20);
    encoder0.encode(this.tiltX, 24);
    encoder0.encode(this.tiltY, 28);
    encoder0.encode(this.tangentialPressure, 32);
    encoder0.encode(this.twist, 36);
    encoder0.encode(this.id, 40);
    encoder0.encode(this.offsetX, 44);
    encoder0.encode(this.offsetY, 48);
  }
}
