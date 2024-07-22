package org.chromium.installedapp.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class RelatedApplication extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;

  public String f655id;
  public String platform;
  public String url;
  public String version;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RelatedApplication(int version) {
    super(40, version);
  }

  public RelatedApplication() {
    this(0);
  }

  public static RelatedApplication deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RelatedApplication deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RelatedApplication decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RelatedApplication result = new RelatedApplication(elementsOrVersion);
      result.platform = decoder0.readString(8, false);
      result.url = decoder0.readString(16, true);
      result.f655id = decoder0.readString(24, true);
      result.version = decoder0.readString(32, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.platform, 8, false);
    encoder0.encode(this.url, 16, true);
    encoder0.encode(this.f655id, 24, true);
    encoder0.encode(this.version, 32, true);
  }
}
