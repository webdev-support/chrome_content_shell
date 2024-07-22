package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TouchData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int cancelable;
  public boolean hovering;
  public boolean movedBeyondSlopRegion;
  public boolean touchStartOrFirstMove;
  public TouchPoint[] touches;
  public int uniqueTouchEventId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TouchData(int version) {
    super(32, version);
  }

  public TouchData() {
    this(0);
  }

  public static TouchData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TouchData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TouchData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TouchData result = new TouchData(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.cancelable = readInt;
      DispatchType.validate(readInt);
      result.cancelable = DispatchType.toKnownValue(result.cancelable);
      result.movedBeyondSlopRegion = decoder0.readBoolean(12, 0);
      result.touchStartOrFirstMove = decoder0.readBoolean(12, 1);
      result.hovering = decoder0.readBoolean(12, 2);
      result.uniqueTouchEventId = decoder0.readInt(16);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.touches = new TouchPoint[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.touches[i1] = TouchPoint.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.cancelable, 8);
    encoder0.encode(this.movedBeyondSlopRegion, 12, 0);
    encoder0.encode(this.touchStartOrFirstMove, 12, 1);
    encoder0.encode(this.hovering, 12, 2);
    encoder0.encode(this.uniqueTouchEventId, 16);
    TouchPoint[] touchPointArr = this.touches;
    if (touchPointArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(touchPointArr.length, 24, -1);
    int i0 = 0;
    while (true) {
      TouchPoint[] touchPointArr2 = this.touches;
      if (i0 < touchPointArr2.length) {
        encoder1.encode((Struct) touchPointArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
