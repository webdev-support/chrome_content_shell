package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.ui.mojom.EventPointerType;

public final class PointerData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public int button;
  public int deviceId;
  public float force;
  public boolean isRawMovementEvent;
  public MouseData mouseData;
  public int movementX;
  public int movementY;
  public int pointerId;
  public int pointerType;
  public PointF screenPosition;
  public float tangentialPressure;
  public double tiltX;
  public double tiltY;
  public int twist;
  public PointF widgetPosition;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(88, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PointerData(int version) {
    super(88, version);
  }

  public PointerData() {
    this(0);
  }

  public static PointerData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PointerData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PointerData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PointerData result = new PointerData(elementsOrVersion);
      result.pointerId = decoder0.readInt(8);
      result.force = decoder0.readFloat(12);
      result.tiltX = decoder0.readDouble(16);
      result.tiltY = decoder0.readDouble(24);
      result.tangentialPressure = decoder0.readFloat(32);
      result.twist = decoder0.readInt(36);
      int readInt = decoder0.readInt(40);
      result.button = readInt;
      Button.validate(readInt);
      result.button = Button.toKnownValue(result.button);
      int readInt2 = decoder0.readInt(44);
      result.pointerType = readInt2;
      EventPointerType.validate(readInt2);
      result.pointerType = EventPointerType.toKnownValue(result.pointerType);
      result.movementX = decoder0.readInt(48);
      result.movementY = decoder0.readInt(52);
      result.isRawMovementEvent = decoder0.readBoolean(56, 0);
      result.deviceId = decoder0.readInt(60);
      Decoder decoder1 = decoder0.readPointer(64, false);
      result.widgetPosition = PointF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(72, false);
      result.screenPosition = PointF.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(80, true);
      result.mouseData = MouseData.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.pointerId, 8);
    encoder0.encode(this.force, 12);
    encoder0.encode(this.tiltX, 16);
    encoder0.encode(this.tiltY, 24);
    encoder0.encode(this.tangentialPressure, 32);
    encoder0.encode(this.twist, 36);
    encoder0.encode(this.button, 40);
    encoder0.encode(this.pointerType, 44);
    encoder0.encode(this.movementX, 48);
    encoder0.encode(this.movementY, 52);
    encoder0.encode(this.isRawMovementEvent, 56, 0);
    encoder0.encode(this.deviceId, 60);
    encoder0.encode((Struct) this.widgetPosition, 64, false);
    encoder0.encode((Struct) this.screenPosition, 72, false);
    encoder0.encode((Struct) this.mouseData, 80, true);
  }
}
