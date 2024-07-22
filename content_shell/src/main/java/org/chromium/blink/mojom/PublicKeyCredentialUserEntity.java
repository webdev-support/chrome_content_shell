package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PublicKeyCredentialUserEntity extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String displayName;

  public byte[] f452id;
  public String name;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PublicKeyCredentialUserEntity(int version) {
    super(32, version);
  }

  public PublicKeyCredentialUserEntity() {
    this(0);
  }

  public static PublicKeyCredentialUserEntity deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PublicKeyCredentialUserEntity deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PublicKeyCredentialUserEntity decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PublicKeyCredentialUserEntity result = new PublicKeyCredentialUserEntity(elementsOrVersion);
      result.f452id = decoder0.readBytes(8, 0, -1);
      result.name = decoder0.readString(16, false);
      result.displayName = decoder0.readString(24, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f452id, 8, 0, -1);
    encoder0.encode(this.name, 16, false);
    encoder0.encode(this.displayName, 24, false);
  }
}
