package org.chromium.display.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DisplayPlacement extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public long displayId;
  public int offset;
  public int offsetReference;
  public long parentDisplayId;
  public int position;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DisplayPlacement(int version) {
    super(40, version);
  }

  public DisplayPlacement() {
    this(0);
  }

  public static DisplayPlacement deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DisplayPlacement deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DisplayPlacement decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DisplayPlacement result = new DisplayPlacement(elementsOrVersion);
      result.displayId = decoder0.readLong(8);
      result.parentDisplayId = decoder0.readLong(16);
      int readInt = decoder0.readInt(24);
      result.position = readInt;
      Position.validate(readInt);
      result.position = Position.toKnownValue(result.position);
      result.offset = decoder0.readInt(28);
      int readInt2 = decoder0.readInt(32);
      result.offsetReference = readInt2;
      OffsetReference.validate(readInt2);
      result.offsetReference = OffsetReference.toKnownValue(result.offsetReference);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.displayId, 8);
    encoder0.encode(this.parentDisplayId, 16);
    encoder0.encode(this.position, 24);
    encoder0.encode(this.offset, 28);
    encoder0.encode(this.offsetReference, 32);
  }
}
