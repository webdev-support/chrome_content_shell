package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class StructuredHeadersParameterizedMember extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public StructuredHeadersParameterizedItem[] member;
  public boolean memberIsInnerList;
  public StructuredHeadersParameter[] parameters;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private StructuredHeadersParameterizedMember(int version) {
    super(32, version);
  }

  public StructuredHeadersParameterizedMember() {
    this(0);
  }

  public static StructuredHeadersParameterizedMember deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static StructuredHeadersParameterizedMember deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static StructuredHeadersParameterizedMember decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      StructuredHeadersParameterizedMember result =
          new StructuredHeadersParameterizedMember(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.member = new StructuredHeadersParameterizedItem[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.member[i1] = StructuredHeadersParameterizedItem.decode(decoder2);
      }
      result.memberIsInnerList = decoder0.readBoolean(16, 0);
      Decoder decoder12 = decoder0.readPointer(24, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.parameters = new StructuredHeadersParameter[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.parameters[i12] = StructuredHeadersParameter.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    StructuredHeadersParameterizedItem[] structuredHeadersParameterizedItemArr = this.member;
    if (structuredHeadersParameterizedItemArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 =
          encoder0.encodePointerArray(structuredHeadersParameterizedItemArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        StructuredHeadersParameterizedItem[] structuredHeadersParameterizedItemArr2 = this.member;
        if (i0 >= structuredHeadersParameterizedItemArr2.length) {
          break;
        }
        encoder1.encode((Struct) structuredHeadersParameterizedItemArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.memberIsInnerList, 16, 0);
    StructuredHeadersParameter[] structuredHeadersParameterArr = this.parameters;
    if (structuredHeadersParameterArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(structuredHeadersParameterArr.length, 24, -1);
    int i02 = 0;
    while (true) {
      StructuredHeadersParameter[] structuredHeadersParameterArr2 = this.parameters;
      if (i02 < structuredHeadersParameterArr2.length) {
        encoder12.encode((Struct) structuredHeadersParameterArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
