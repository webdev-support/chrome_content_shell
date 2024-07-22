package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.ui.mojom.ScrollGranularity;

public final class ScrollData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean cursorControl;
  public int deltaUnits;
  public float deltaX;
  public float deltaY;
  public int inertialPhase;
  public int pointerCount;
  public boolean synthetic;
  public boolean targetViewport;
  public ScrollUpdate updateDetails;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ScrollData(int version) {
    super(40, version);
  }

  public ScrollData() {
    this(0);
  }

  public static ScrollData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ScrollData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ScrollData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ScrollData result = new ScrollData(elementsOrVersion);
      result.deltaX = decoder0.readFloat(8);
      result.deltaY = decoder0.readFloat(12);
      int readInt = decoder0.readInt(16);
      result.deltaUnits = readInt;
      ScrollGranularity.validate(readInt);
      result.deltaUnits = ScrollGranularity.toKnownValue(result.deltaUnits);
      result.targetViewport = decoder0.readBoolean(20, 0);
      result.synthetic = decoder0.readBoolean(20, 1);
      result.cursorControl = decoder0.readBoolean(20, 2);
      int readInt2 = decoder0.readInt(24);
      result.inertialPhase = readInt2;
      InertialPhaseState.validate(readInt2);
      result.inertialPhase = InertialPhaseState.toKnownValue(result.inertialPhase);
      result.pointerCount = decoder0.readInt(28);
      Decoder decoder1 = decoder0.readPointer(32, true);
      result.updateDetails = ScrollUpdate.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.deltaX, 8);
    encoder0.encode(this.deltaY, 12);
    encoder0.encode(this.deltaUnits, 16);
    encoder0.encode(this.targetViewport, 20, 0);
    encoder0.encode(this.synthetic, 20, 1);
    encoder0.encode(this.cursorControl, 20, 2);
    encoder0.encode(this.inertialPhase, 24);
    encoder0.encode(this.pointerCount, 28);
    encoder0.encode((Struct) this.updateDetails, 32, true);
  }
}
