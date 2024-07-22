package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class EncryptionPattern extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public int cryptByteBlock;
  public int skipByteBlock;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private EncryptionPattern(int version) {
    super(16, version);
  }

  public EncryptionPattern() {
    this(0);
  }

  public static EncryptionPattern deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static EncryptionPattern deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static EncryptionPattern decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      EncryptionPattern result = new EncryptionPattern(elementsOrVersion);
      result.cryptByteBlock = decoder0.readInt(8);
      result.skipByteBlock = decoder0.readInt(12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.cryptByteBlock, 8);
    encoder0.encode(this.skipByteBlock, 12);
  }
}
