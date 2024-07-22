package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class UrlRequestBody extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowHttp1ForStreamingUpload;
  public boolean containsSensitiveInfo;
  public DataElement[] elements;
  public long identifier;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UrlRequestBody(int version) {
    super(32, version);
  }

  public UrlRequestBody() {
    this(0);
  }

  public static UrlRequestBody deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UrlRequestBody deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UrlRequestBody decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UrlRequestBody result = new UrlRequestBody(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.elements = new DataElement[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.elements[i1] = DataElement.decode(decoder1, (i1 * 16) + 8);
      }
      result.identifier = decoder0.readLong(16);
      result.containsSensitiveInfo = decoder0.readBoolean(24, 0);
      result.allowHttp1ForStreamingUpload = decoder0.readBoolean(24, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    DataElement[] dataElementArr = this.elements;
    if (dataElementArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodeUnionArray(dataElementArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        DataElement[] dataElementArr2 = this.elements;
        if (i0 >= dataElementArr2.length) {
          break;
        }
        encoder1.encode((Union) dataElementArr2[i0], (i0 * 16) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.identifier, 16);
    encoder0.encode(this.containsSensitiveInfo, 24, 0);
    encoder0.encode(this.allowHttp1ForStreamingUpload, 24, 1);
  }
}
