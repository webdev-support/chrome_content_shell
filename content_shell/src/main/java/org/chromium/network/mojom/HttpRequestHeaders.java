package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HttpRequestHeaders extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public HttpRequestHeaderKeyValuePair[] headers;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HttpRequestHeaders(int version) {
    super(16, version);
  }

  public HttpRequestHeaders() {
    this(0);
  }

  public static HttpRequestHeaders deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HttpRequestHeaders deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HttpRequestHeaders decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HttpRequestHeaders result = new HttpRequestHeaders(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.headers = new HttpRequestHeaderKeyValuePair[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.headers[i1] = HttpRequestHeaderKeyValuePair.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    HttpRequestHeaderKeyValuePair[] httpRequestHeaderKeyValuePairArr = this.headers;
    if (httpRequestHeaderKeyValuePairArr == null) {
      encoder0.encodeNullPointer(8, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(httpRequestHeaderKeyValuePairArr.length, 8, -1);
    int i0 = 0;
    while (true) {
      HttpRequestHeaderKeyValuePair[] httpRequestHeaderKeyValuePairArr2 = this.headers;
      if (i0 < httpRequestHeaderKeyValuePairArr2.length) {
        encoder1.encode((Struct) httpRequestHeaderKeyValuePairArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
