package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ObliviousHttpResponse extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public HttpResponseHeaders headers;
  public String responseBody;
  public int responseCode;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ObliviousHttpResponse(int version) {
    super(32, version);
  }

  public ObliviousHttpResponse() {
    this(0);
  }

  public static ObliviousHttpResponse deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ObliviousHttpResponse deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ObliviousHttpResponse decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ObliviousHttpResponse result = new ObliviousHttpResponse(elementsOrVersion);
      result.responseCode = decoder0.readInt(8);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.headers = HttpResponseHeaders.decode(decoder1);
      result.responseBody = decoder0.readString(24, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.responseCode, 8);
    encoder0.encode((Struct) this.headers, 16, false);
    encoder0.encode(this.responseBody, 24, false);
  }
}
