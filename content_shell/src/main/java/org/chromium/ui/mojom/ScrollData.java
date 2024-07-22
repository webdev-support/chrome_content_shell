package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ScrollData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int fingerCount;
  public LocationData location;
  public int momentumPhase;
  public int scrollEventPhase;
  public float xOffset;
  public float xOffsetOrdinal;
  public float yOffset;
  public float yOffsetOrdinal;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ScrollData(int version) {
    super(48, version);
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
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.location = LocationData.decode(decoder1);
      result.xOffset = decoder0.readFloat(16);
      result.yOffset = decoder0.readFloat(20);
      result.xOffsetOrdinal = decoder0.readFloat(24);
      result.yOffsetOrdinal = decoder0.readFloat(28);
      result.fingerCount = decoder0.readInt(32);
      int readInt = decoder0.readInt(36);
      result.momentumPhase = readInt;
      EventMomentumPhase.validate(readInt);
      result.momentumPhase = EventMomentumPhase.toKnownValue(result.momentumPhase);
      int readInt2 = decoder0.readInt(40);
      result.scrollEventPhase = readInt2;
      ScrollEventPhase.validate(readInt2);
      result.scrollEventPhase = ScrollEventPhase.toKnownValue(result.scrollEventPhase);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.location, 8, false);
    encoder0.encode(this.xOffset, 16);
    encoder0.encode(this.yOffset, 20);
    encoder0.encode(this.xOffsetOrdinal, 24);
    encoder0.encode(this.yOffsetOrdinal, 28);
    encoder0.encode(this.fingerCount, 32);
    encoder0.encode(this.momentumPhase, 36);
    encoder0.encode(this.scrollEventPhase, 40);
  }
}
