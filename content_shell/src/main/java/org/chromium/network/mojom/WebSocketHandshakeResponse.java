package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class WebSocketHandshakeResponse extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public String extensions;
  public HttpHeader[] headers;
  public String headersText;
  public HttpVersion httpVersion;
  public IpEndPoint remoteEndpoint;
  public String selectedProtocol;
  public int statusCode;
  public String statusText;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WebSocketHandshakeResponse(int version) {
    super(80, version);
  }

  public WebSocketHandshakeResponse() {
    this(0);
  }

  public static WebSocketHandshakeResponse deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WebSocketHandshakeResponse deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WebSocketHandshakeResponse decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WebSocketHandshakeResponse result = new WebSocketHandshakeResponse(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.httpVersion = HttpVersion.decode(decoder12);
      result.statusCode = decoder0.readInt(24);
      result.statusText = decoder0.readString(32, false);
      Decoder decoder13 = decoder0.readPointer(40, false);
      result.remoteEndpoint = IpEndPoint.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(48, false);
      DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
      result.headers = new HttpHeader[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder14.readPointer((i1 * 8) + 8, false);
        result.headers[i1] = HttpHeader.decode(decoder2);
      }
      result.headersText = decoder0.readString(56, false);
      result.selectedProtocol = decoder0.readString(64, false);
      result.extensions = decoder0.readString(72, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode((Struct) this.httpVersion, 16, false);
    encoder0.encode(this.statusCode, 24);
    encoder0.encode(this.statusText, 32, false);
    encoder0.encode((Struct) this.remoteEndpoint, 40, false);
    HttpHeader[] httpHeaderArr = this.headers;
    if (httpHeaderArr == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(httpHeaderArr.length, 48, -1);
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
    encoder0.encode(this.headersText, 56, false);
    encoder0.encode(this.selectedProtocol, 64, false);
    encoder0.encode(this.extensions, 72, false);
  }
}
