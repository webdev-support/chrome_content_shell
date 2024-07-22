package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class IdentityUserInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public String email;
  public String givenName;
  public String name;
  public String picture;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private IdentityUserInfo(int version) {
    super(40, version);
  }

  public IdentityUserInfo() {
    this(0);
  }

  public static IdentityUserInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static IdentityUserInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static IdentityUserInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      IdentityUserInfo result = new IdentityUserInfo(elementsOrVersion);
      result.email = decoder0.readString(8, false);
      result.givenName = decoder0.readString(16, false);
      result.name = decoder0.readString(24, false);
      result.picture = decoder0.readString(32, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.email, 8, false);
    encoder0.encode(this.givenName, 16, false);
    encoder0.encode(this.name, 24, false);
    encoder0.encode(this.picture, 32, false);
  }
}
