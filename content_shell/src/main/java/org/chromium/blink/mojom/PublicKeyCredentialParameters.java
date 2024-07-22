package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PublicKeyCredentialParameters extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public int algorithmIdentifier;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PublicKeyCredentialParameters(int version) {
    super(16, version);
  }

  public PublicKeyCredentialParameters() {
    this(0);
  }

  public static PublicKeyCredentialParameters deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PublicKeyCredentialParameters deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PublicKeyCredentialParameters decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PublicKeyCredentialParameters result = new PublicKeyCredentialParameters(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      PublicKeyCredentialType.validate(readInt);
      result.type = PublicKeyCredentialType.toKnownValue(result.type);
      result.algorithmIdentifier = decoder0.readInt(12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.algorithmIdentifier, 12);
  }
}
