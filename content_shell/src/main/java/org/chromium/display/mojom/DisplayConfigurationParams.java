package org.chromium.display.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DisplayConfigurationParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean enableVrr;

  public long f609id;
  public DisplayMode mode;
  public Point origin;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DisplayConfigurationParams(int version) {
    super(40, version);
  }

  public DisplayConfigurationParams() {
    this(0);
  }

  public static DisplayConfigurationParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DisplayConfigurationParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DisplayConfigurationParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DisplayConfigurationParams result = new DisplayConfigurationParams(elementsOrVersion);
      result.f609id = decoder0.readLong(8);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.origin = Point.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.mode = DisplayMode.decode(decoder12);
      result.enableVrr = decoder0.readBoolean(32, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f609id, 8);
    encoder0.encode((Struct) this.origin, 16, false);
    encoder0.encode((Struct) this.mode, 24, true);
    encoder0.encode(this.enableVrr, 32, 0);
  }
}
