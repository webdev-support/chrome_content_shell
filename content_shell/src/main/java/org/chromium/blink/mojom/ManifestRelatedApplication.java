package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

public final class ManifestRelatedApplication extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;

  public String16 f437id;
  public String16 platform;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ManifestRelatedApplication(int version) {
    super(32, version);
  }

  public ManifestRelatedApplication() {
    this(0);
  }

  public static ManifestRelatedApplication deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ManifestRelatedApplication deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ManifestRelatedApplication decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ManifestRelatedApplication result = new ManifestRelatedApplication(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.platform = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.url = Url.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.f437id = String16.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.platform, 8, true);
    encoder0.encode((Struct) this.url, 16, true);
    encoder0.encode((Struct) this.f437id, 24, true);
  }
}
