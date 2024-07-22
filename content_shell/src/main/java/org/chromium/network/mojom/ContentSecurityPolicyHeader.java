package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ContentSecurityPolicyHeader extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public String headerValue;
  public int source;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ContentSecurityPolicyHeader(int version) {
    super(24, version);
    this.type = 1;
    this.source = 0;
  }

  public ContentSecurityPolicyHeader() {
    this(0);
  }

  public static ContentSecurityPolicyHeader deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ContentSecurityPolicyHeader deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ContentSecurityPolicyHeader decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ContentSecurityPolicyHeader result = new ContentSecurityPolicyHeader(elementsOrVersion);
      result.headerValue = decoder0.readString(8, false);
      int readInt = decoder0.readInt(16);
      result.type = readInt;
      ContentSecurityPolicyType.validate(readInt);
      result.type = ContentSecurityPolicyType.toKnownValue(result.type);
      int readInt2 = decoder0.readInt(20);
      result.source = readInt2;
      ContentSecurityPolicySource.validate(readInt2);
      result.source = ContentSecurityPolicySource.toKnownValue(result.source);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.headerValue, 8, false);
    encoder0.encode(this.type, 16);
    encoder0.encode(this.source, 20);
  }
}
