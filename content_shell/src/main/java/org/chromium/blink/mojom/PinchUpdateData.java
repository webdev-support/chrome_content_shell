package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PinchUpdateData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean needsWheelEvent;
  public float scale;
  public boolean zoomDisabled;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PinchUpdateData(int version) {
    super(16, version);
  }

  public PinchUpdateData() {
    this(0);
  }

  public static PinchUpdateData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PinchUpdateData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PinchUpdateData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PinchUpdateData result = new PinchUpdateData(elementsOrVersion);
      result.scale = decoder0.readFloat(8);
      result.zoomDisabled = decoder0.readBoolean(12, 0);
      result.needsWheelEvent = decoder0.readBoolean(12, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.scale, 8);
    encoder0.encode(this.zoomDisabled, 12, 0);
    encoder0.encode(this.needsWheelEvent, 12, 1);
  }
}
