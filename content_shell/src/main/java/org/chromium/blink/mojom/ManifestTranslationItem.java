package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class ManifestTranslationItem extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String16 description;
  public String16 name;
  public String16 shortName;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ManifestTranslationItem(int version) {
    super(32, version);
  }

  public ManifestTranslationItem() {
    this(0);
  }

  public static ManifestTranslationItem deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ManifestTranslationItem deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ManifestTranslationItem decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ManifestTranslationItem result = new ManifestTranslationItem(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.name = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.shortName = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.description = String16.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.name, 8, true);
    encoder0.encode((Struct) this.shortName, 16, true);
    encoder0.encode((Struct) this.description, 24, true);
  }
}
