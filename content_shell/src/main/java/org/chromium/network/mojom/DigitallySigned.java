package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DigitallySigned extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int hashAlgorithm;
  public byte[] signature;
  public int signatureAlgorithm;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DigitallySigned(int version) {
    super(24, version);
  }

  public DigitallySigned() {
    this(0);
  }

  public static DigitallySigned deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DigitallySigned deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DigitallySigned decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DigitallySigned result = new DigitallySigned(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.hashAlgorithm = readInt;
      HashAlgorithm.validate(readInt);
      result.hashAlgorithm = HashAlgorithm.toKnownValue(result.hashAlgorithm);
      int readInt2 = decoder0.readInt(12);
      result.signatureAlgorithm = readInt2;
      SignatureAlgorithm.validate(readInt2);
      result.signatureAlgorithm = SignatureAlgorithm.toKnownValue(result.signatureAlgorithm);
      result.signature = decoder0.readBytes(16, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.hashAlgorithm, 8);
    encoder0.encode(this.signatureAlgorithm, 12);
    encoder0.encode(this.signature, 16, 0, -1);
  }
}
