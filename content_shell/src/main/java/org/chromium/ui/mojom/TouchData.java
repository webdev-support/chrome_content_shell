package org.chromium.ui.mojom;

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
  public boolean hovering;
  public LocationData location;
  public boolean mayCauseScrolling;
  public PointerDetails pointerDetails;

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
      result.mayCauseScrolling = decoder0.readBoolean(8, 0);
      result.hovering = decoder0.readBoolean(8, 1);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.location = LocationData.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.pointerDetails = PointerDetails.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.mayCauseScrolling, 8, 0);
    encoder0.encode(this.hovering, 8, 1);
    encoder0.encode((Struct) this.location, 16, false);
    encoder0.encode((Struct) this.pointerDetails, 24, false);
  }
}
