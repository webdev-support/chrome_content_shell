package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CookieSameSiteContext extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int context;
  public CookieSameSiteContextMetadata metadata;
  public int schemefulContext;
  public CookieSameSiteContextMetadata schemefulMetadata;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CookieSameSiteContext(int version) {
    super(32, version);
    this.context = 0;
    this.schemefulContext = 0;
  }

  public CookieSameSiteContext() {
    this(0);
  }

  public static CookieSameSiteContext deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CookieSameSiteContext deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CookieSameSiteContext decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CookieSameSiteContext result = new CookieSameSiteContext(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.context = readInt;
      ContextType.validate(readInt);
      result.context = ContextType.toKnownValue(result.context);
      int readInt2 = decoder0.readInt(12);
      result.schemefulContext = readInt2;
      ContextType.validate(readInt2);
      result.schemefulContext = ContextType.toKnownValue(result.schemefulContext);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.metadata = CookieSameSiteContextMetadata.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.schemefulMetadata = CookieSameSiteContextMetadata.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.context, 8);
    encoder0.encode(this.schemefulContext, 12);
    encoder0.encode((Struct) this.metadata, 16, false);
    encoder0.encode((Struct) this.schemefulMetadata, 24, false);
  }
}
