package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CspHashSource extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int algorithm;
  public byte[] value;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CspHashSource(int version) {
    super(24, version);
  }

  public CspHashSource() {
    this(0);
  }

  public static CspHashSource deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CspHashSource deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CspHashSource decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CspHashSource result = new CspHashSource(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.algorithm = readInt;
      CspHashAlgorithm.validate(readInt);
      result.algorithm = CspHashAlgorithm.toKnownValue(result.algorithm);
      result.value = decoder0.readBytes(16, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.algorithm, 8);
    encoder0.encode(this.value, 16, 0, -1);
  }
}
