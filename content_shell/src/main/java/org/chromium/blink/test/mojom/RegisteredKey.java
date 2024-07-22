package org.chromium.blink.test.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class RegisteredKey extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int counter;
  public byte[] keyHandle;
  public byte[] privateKey;
  public String rpId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RegisteredKey(int version) {
    super(40, version);
  }

  public RegisteredKey() {
    this(0);
  }

  public static RegisteredKey deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RegisteredKey deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RegisteredKey decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RegisteredKey result = new RegisteredKey(elementsOrVersion);
      result.keyHandle = decoder0.readBytes(8, 0, -1);
      result.rpId = decoder0.readString(16, false);
      result.privateKey = decoder0.readBytes(24, 0, -1);
      result.counter = decoder0.readInt(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.keyHandle, 8, 0, -1);
    encoder0.encode(this.rpId, 16, false);
    encoder0.encode(this.privateKey, 24, 0, -1);
    encoder0.encode(this.counter, 32);
  }
}
