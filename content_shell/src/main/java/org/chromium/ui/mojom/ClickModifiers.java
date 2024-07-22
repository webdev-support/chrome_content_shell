package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ClickModifiers extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean altKey;
  public boolean ctrlKey;
  public boolean metaKey;
  public boolean middleButton;
  public boolean shiftKey;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ClickModifiers(int version) {
    super(16, version);
  }

  public ClickModifiers() {
    this(0);
  }

  public static ClickModifiers deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ClickModifiers deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ClickModifiers decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ClickModifiers result = new ClickModifiers(elementsOrVersion);
      result.middleButton = decoder0.readBoolean(8, 0);
      result.altKey = decoder0.readBoolean(8, 1);
      result.ctrlKey = decoder0.readBoolean(8, 2);
      result.metaKey = decoder0.readBoolean(8, 3);
      result.shiftKey = decoder0.readBoolean(8, 4);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.middleButton, 8, 0);
    encoder0.encode(this.altKey, 8, 1);
    encoder0.encode(this.ctrlKey, 8, 2);
    encoder0.encode(this.metaKey, 8, 3);
    encoder0.encode(this.shiftKey, 8, 4);
  }
}
