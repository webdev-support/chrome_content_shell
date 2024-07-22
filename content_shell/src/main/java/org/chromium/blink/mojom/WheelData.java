package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class WheelData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public float accelerationRatioX;
  public float accelerationRatioY;
  public int cancelable;
  public byte deltaUnits;
  public float deltaX;
  public float deltaY;
  public byte eventAction;
  public byte momentumPhase;
  public byte phase;
  public float wheelTicksX;
  public float wheelTicksY;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WheelData(int version) {
    super(40, version);
  }

  public WheelData() {
    this(0);
  }

  public static WheelData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WheelData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WheelData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WheelData result = new WheelData(elementsOrVersion);
      result.deltaX = decoder0.readFloat(8);
      result.deltaY = decoder0.readFloat(12);
      result.wheelTicksX = decoder0.readFloat(16);
      result.wheelTicksY = decoder0.readFloat(20);
      result.accelerationRatioX = decoder0.readFloat(24);
      result.accelerationRatioY = decoder0.readFloat(28);
      result.phase = decoder0.readByte(32);
      result.momentumPhase = decoder0.readByte(33);
      result.eventAction = decoder0.readByte(34);
      result.deltaUnits = decoder0.readByte(35);
      int readInt = decoder0.readInt(36);
      result.cancelable = readInt;
      DispatchType.validate(readInt);
      result.cancelable = DispatchType.toKnownValue(result.cancelable);
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
    encoder0.encode(this.wheelTicksX, 16);
    encoder0.encode(this.wheelTicksY, 20);
    encoder0.encode(this.accelerationRatioX, 24);
    encoder0.encode(this.accelerationRatioY, 28);
    encoder0.encode(this.phase, 32);
    encoder0.encode(this.momentumPhase, 33);
    encoder0.encode(this.eventAction, 34);
    encoder0.encode(this.deltaUnits, 35);
    encoder0.encode(this.cancelable, 36);
  }
}
