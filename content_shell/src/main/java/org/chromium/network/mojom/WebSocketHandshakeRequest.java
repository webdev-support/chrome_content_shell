package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class WebSocketHandshakeRequest extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public HttpHeader[] headers;
  public String headersText;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WebSocketHandshakeRequest(int version) {
    super(32, version);
  }

  public WebSocketHandshakeRequest() {
    this(0);
  }

  public static WebSocketHandshakeRequest deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WebSocketHandshakeRequest deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WebSocketHandshakeRequest decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WebSocketHandshakeRequest result = new WebSocketHandshakeRequest(elementsOrVersion);
      result.url = Url.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.headers = new HttpHeader[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.headers[i1] = HttpHeader.decode(decoder2);
      }
      result.headersText = decoder0.readString(24, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    HttpHeader[] httpHeaderArr = this.headers;
    if (httpHeaderArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(httpHeaderArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        HttpHeader[] httpHeaderArr2 = this.headers;
        if (i0 >= httpHeaderArr2.length) {
          break;
        }
        encoder1.encode((Struct) httpHeaderArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.headersText, 24, false);
  }
}
