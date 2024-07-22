package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class HttpBody extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean containsPasswords;
  public String16 httpContentType;
  public RequestBody requestBody;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HttpBody(int version) {
    super(32, version);
    this.containsPasswords = false;
  }

  public HttpBody() {
    this(0);
  }

  public static HttpBody deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HttpBody deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HttpBody decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HttpBody result = new HttpBody(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.httpContentType = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.requestBody = RequestBody.decode(decoder12);
      result.containsPasswords = decoder0.readBoolean(24, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.httpContentType, 8, true);
    encoder0.encode((Struct) this.requestBody, 16, true);
    encoder0.encode(this.containsPasswords, 24, 0);
  }
}
