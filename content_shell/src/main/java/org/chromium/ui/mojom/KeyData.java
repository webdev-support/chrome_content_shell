package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class KeyData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int domCode;
  public int domKey;
  public boolean isChar;
  public int keyCode;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private KeyData(int version) {
    super(24, version);
  }

  public KeyData() {
    this(0);
  }

  public static KeyData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static KeyData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static KeyData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      KeyData result = new KeyData(elementsOrVersion);
      result.keyCode = decoder0.readInt(8);
      result.domCode = decoder0.readInt(12);
      result.domKey = decoder0.readInt(16);
      result.isChar = decoder0.readBoolean(20, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.keyCode, 8);
    encoder0.encode(this.domCode, 12);
    encoder0.encode(this.domKey, 16);
    encoder0.encode(this.isChar, 20, 0);
  }
}
