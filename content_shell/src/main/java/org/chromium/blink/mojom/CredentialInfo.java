package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class CredentialInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public Origin federation;
  public Url icon;

  public String16 f414id;
  public String16 name;
  public String16 password;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CredentialInfo(int version) {
    super(56, version);
  }

  public CredentialInfo() {
    this(0);
  }

  public static CredentialInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CredentialInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CredentialInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CredentialInfo result = new CredentialInfo(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      CredentialType.validate(readInt);
      result.type = CredentialType.toKnownValue(result.type);
      Decoder decoder1 = decoder0.readPointer(16, true);
      result.f414id = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.name = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.icon = Url.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, true);
      result.password = String16.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.federation = Origin.decode(decoder15);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode((Struct) this.f414id, 16, true);
    encoder0.encode((Struct) this.name, 24, true);
    encoder0.encode((Struct) this.icon, 32, false);
    encoder0.encode((Struct) this.password, 40, true);
    encoder0.encode((Struct) this.federation, 48, false);
  }
}
