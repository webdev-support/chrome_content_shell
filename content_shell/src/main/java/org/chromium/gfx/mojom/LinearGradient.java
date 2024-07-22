package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class LinearGradient extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public short angle;
  public byte stepCount;
  public Step[] steps;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private LinearGradient(int version) {
    super(24, version);
    this.angle = (short) 0;
    this.stepCount = (byte) 0;
  }

  public LinearGradient() {
    this(0);
  }

  public static LinearGradient deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static LinearGradient deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static LinearGradient decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      LinearGradient result = new LinearGradient(elementsOrVersion);
      result.angle = decoder0.readShort(8);
      result.stepCount = decoder0.readByte(10);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(8);
      result.steps = new Step[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.steps[i1] = Step.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.angle, 8);
    encoder0.encode(this.stepCount, 10);
    Step[] stepArr = this.steps;
    if (stepArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(stepArr.length, 16, 8);
    int i0 = 0;
    while (true) {
      Step[] stepArr2 = this.steps;
      if (i0 < stepArr2.length) {
        encoder1.encode((Struct) stepArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
