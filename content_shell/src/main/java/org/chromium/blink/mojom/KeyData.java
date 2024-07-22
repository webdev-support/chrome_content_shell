package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class KeyData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int domCode;
  public int domKey;
  public boolean isBrowserShortcut;
  public boolean isSystemKey;
  public int nativeKeyCode;
  public String16 text;
  public String16 unmodifiedText;
  public int windowsKeyCode;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private KeyData(int version) {
    super(48, version);
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
      result.domKey = decoder0.readInt(8);
      result.domCode = decoder0.readInt(12);
      result.windowsKeyCode = decoder0.readInt(16);
      result.nativeKeyCode = decoder0.readInt(20);
      result.isSystemKey = decoder0.readBoolean(24, 0);
      result.isBrowserShortcut = decoder0.readBoolean(24, 1);
      Decoder decoder1 = decoder0.readPointer(32, false);
      result.text = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(40, false);
      result.unmodifiedText = String16.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.domKey, 8);
    encoder0.encode(this.domCode, 12);
    encoder0.encode(this.windowsKeyCode, 16);
    encoder0.encode(this.nativeKeyCode, 20);
    encoder0.encode(this.isSystemKey, 24, 0);
    encoder0.encode(this.isBrowserShortcut, 24, 1);
    encoder0.encode((Struct) this.text, 32, false);
    encoder0.encode((Struct) this.unmodifiedText, 40, false);
  }
}
