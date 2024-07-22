package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class FetchApiRequestBody extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean containsSensitiveInfo;
  public org.chromium.network.mojom.DataElement[] elements;
  public long identifier;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FetchApiRequestBody(int version) {
    super(32, version);
  }

  public FetchApiRequestBody() {
    this(0);
  }

  public static FetchApiRequestBody deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FetchApiRequestBody deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FetchApiRequestBody decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FetchApiRequestBody result = new FetchApiRequestBody(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.elements = new org.chromium.network.mojom.DataElement[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.elements[i1] =
            org.chromium.network.mojom.DataElement.decode(decoder1, (i1 * 16) + 8);
      }
      result.identifier = decoder0.readLong(16);
      result.containsSensitiveInfo = decoder0.readBoolean(24, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    org.chromium.network.mojom.DataElement[] dataElementArr = this.elements;
    if (dataElementArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodeUnionArray(dataElementArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        org.chromium.network.mojom.DataElement[] dataElementArr2 = this.elements;
        if (i0 >= dataElementArr2.length) {
          break;
        }
        encoder1.encode((Union) dataElementArr2[i0], (i0 * 16) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.identifier, 16);
    encoder0.encode(this.containsSensitiveInfo, 24, 0);
  }
}
