package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class StructuredHeadersParameterizedItem extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public StructuredHeadersItem item;
  public StructuredHeadersParameter[] parameters;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private StructuredHeadersParameterizedItem(int version) {
    super(32, version);
  }

  public StructuredHeadersParameterizedItem() {
    this(0);
  }

  public static StructuredHeadersParameterizedItem deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static StructuredHeadersParameterizedItem deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static StructuredHeadersParameterizedItem decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      StructuredHeadersParameterizedItem result =
          new StructuredHeadersParameterizedItem(elementsOrVersion);
      result.item = StructuredHeadersItem.decode(decoder0, 8);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.parameters = new StructuredHeadersParameter[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.parameters[i1] = StructuredHeadersParameter.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.item, 8, false);
    StructuredHeadersParameter[] structuredHeadersParameterArr = this.parameters;
    if (structuredHeadersParameterArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(structuredHeadersParameterArr.length, 24, -1);
    int i0 = 0;
    while (true) {
      StructuredHeadersParameter[] structuredHeadersParameterArr2 = this.parameters;
      if (i0 < structuredHeadersParameterArr2.length) {
        encoder1.encode((Struct) structuredHeadersParameterArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
