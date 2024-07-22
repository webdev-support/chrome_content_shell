package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.SizeF;
import org.chromium.gfx.mojom.Vector2dF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FocusedEditableParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean canZoom;
  public Vector2dF relativeLocation;
  public SizeF size;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FocusedEditableParams(int version) {
    super(32, version);
    this.canZoom = true;
  }

  public FocusedEditableParams() {
    this(0);
  }

  public static FocusedEditableParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FocusedEditableParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FocusedEditableParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FocusedEditableParams result = new FocusedEditableParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.relativeLocation = Vector2dF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.size = SizeF.decode(decoder12);
      result.canZoom = decoder0.readBoolean(24, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.relativeLocation, 8, false);
    encoder0.encode((Struct) this.size, 16, false);
    encoder0.encode(this.canZoom, 24, 0);
  }
}