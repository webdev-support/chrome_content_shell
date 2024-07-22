package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Vector2d;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class MouseData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int changedButtonFlags;
  public LocationData location;
  public PointerDetails pointerDetails;
  public Vector2d tick120ths;
  public Vector2d wheelOffset;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private MouseData(int version) {
    super(48, version);
  }

  public MouseData() {
    this(0);
  }

  public static MouseData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MouseData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MouseData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MouseData result = new MouseData(elementsOrVersion);
      result.changedButtonFlags = decoder0.readInt(8);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.location = LocationData.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.pointerDetails = PointerDetails.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.wheelOffset = Vector2d.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.tick120ths = Vector2d.decode(decoder14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.changedButtonFlags, 8);
    encoder0.encode((Struct) this.location, 16, false);
    encoder0.encode((Struct) this.pointerDetails, 24, false);
    encoder0.encode((Struct) this.wheelOffset, 32, false);
    encoder0.encode((Struct) this.tick120ths, 40, false);
  }
}
