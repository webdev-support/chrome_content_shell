package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ScrollIntoViewParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public ScrollAlignment alignX;
  public ScrollAlignment alignY;
  public int behavior;
  public boolean crossOriginBoundaries;
  public FocusedEditableParams forFocusedEditable;
  public boolean isForScrollSequence;
  public boolean makeVisibleInVisualViewport;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ScrollIntoViewParams(int version) {
    super(48, version);
    this.type = 1;
    this.makeVisibleInVisualViewport = true;
    this.behavior = 0;
    this.isForScrollSequence = false;
    this.crossOriginBoundaries = true;
  }

  public ScrollIntoViewParams() {
    this(0);
  }

  public static ScrollIntoViewParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ScrollIntoViewParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ScrollIntoViewParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ScrollIntoViewParams result = new ScrollIntoViewParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.alignX = ScrollAlignment.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.alignY = ScrollAlignment.decode(decoder12);
      int readInt = decoder0.readInt(24);
      result.type = readInt;
      ScrollType.validate(readInt);
      result.type = ScrollType.toKnownValue(result.type);
      result.makeVisibleInVisualViewport = decoder0.readBoolean(28, 0);
      result.isForScrollSequence = decoder0.readBoolean(28, 1);
      result.crossOriginBoundaries = decoder0.readBoolean(28, 2);
      int readInt2 = decoder0.readInt(32);
      result.behavior = readInt2;
      ScrollBehavior.validate(readInt2);
      result.behavior = ScrollBehavior.toKnownValue(result.behavior);
      Decoder decoder13 = decoder0.readPointer(40, true);
      result.forFocusedEditable = FocusedEditableParams.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.alignX, 8, false);
    encoder0.encode((Struct) this.alignY, 16, false);
    encoder0.encode(this.type, 24);
    encoder0.encode(this.makeVisibleInVisualViewport, 28, 0);
    encoder0.encode(this.isForScrollSequence, 28, 1);
    encoder0.encode(this.crossOriginBoundaries, 28, 2);
    encoder0.encode(this.behavior, 32);
    encoder0.encode((Struct) this.forFocusedEditable, 40, true);
  }
}
