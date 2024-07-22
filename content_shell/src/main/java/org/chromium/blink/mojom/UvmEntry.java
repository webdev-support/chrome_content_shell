package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class UvmEntry extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public short keyProtectionType;
  public short matcherProtectionType;
  public int userVerificationMethod;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UvmEntry(int version) {
    super(16, version);
  }

  public UvmEntry() {
    this(0);
  }

  public static UvmEntry deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UvmEntry deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UvmEntry decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UvmEntry result = new UvmEntry(elementsOrVersion);
      result.userVerificationMethod = decoder0.readInt(8);
      result.keyProtectionType = decoder0.readShort(12);
      result.matcherProtectionType = decoder0.readShort(14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.userVerificationMethod, 8);
    encoder0.encode(this.keyProtectionType, 12);
    encoder0.encode(this.matcherProtectionType, 14);
  }
}
