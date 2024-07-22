package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.SelectionBound;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class Selection extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public SelectionBound end;
  public SelectionBound start;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Selection(int version) {
    super(24, version);
  }

  public Selection() {
    this(0);
  }

  public static Selection deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Selection deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Selection decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Selection result = new Selection(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.start = SelectionBound.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.end = SelectionBound.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.start, 8, false);
    encoder0.encode((Struct) this.end, 16, false);
  }
}