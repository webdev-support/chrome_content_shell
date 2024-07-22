package org.chromium.cert_verifier.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.ByteString;
import org.chromium.network.mojom.X509Certificate;

public final class RequestParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public X509Certificate certificate;
  public int flags;
  public String hostname;
  public ByteString ocspResponse;
  public ByteString sctList;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RequestParams(int version) {
    super(48, version);
  }

  public RequestParams() {
    this(0);
  }

  public static RequestParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RequestParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RequestParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RequestParams result = new RequestParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.certificate = X509Certificate.decode(decoder1);
      result.hostname = decoder0.readString(16, false);
      result.flags = decoder0.readInt(24);
      Decoder decoder12 = decoder0.readPointer(32, false);
      result.ocspResponse = ByteString.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(40, false);
      result.sctList = ByteString.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.certificate, 8, false);
    encoder0.encode(this.hostname, 16, false);
    encoder0.encode(this.flags, 24);
    encoder0.encode((Struct) this.ocspResponse, 32, false);
    encoder0.encode((Struct) this.sctList, 40, false);
  }
}
