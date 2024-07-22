package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class GetSavableResourceLinksReply extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public Referrer referrer;
  public Url[] resourcesList;
  public SavableSubframe[] subframes;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GetSavableResourceLinksReply(int version) {
    super(32, version);
  }

  public GetSavableResourceLinksReply() {
    this(0);
  }

  public static GetSavableResourceLinksReply deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GetSavableResourceLinksReply deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GetSavableResourceLinksReply decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GetSavableResourceLinksReply result = new GetSavableResourceLinksReply(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.resourcesList = new Url[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.resourcesList[i1] = Url.decode(decoder2);
      }
      result.referrer = Referrer.decode(decoder0.readPointer(16, false));
      Decoder decoder12 = decoder0.readPointer(24, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.subframes = new SavableSubframe[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.subframes[i12] = SavableSubframe.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    Url[] urlArr = this.resourcesList;
    if (urlArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Url[] urlArr2 = this.resourcesList;
        if (i0 >= urlArr2.length) {
          break;
        }
        encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.referrer, 16, false);
    SavableSubframe[] savableSubframeArr = this.subframes;
    if (savableSubframeArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(savableSubframeArr.length, 24, -1);
    int i02 = 0;
    while (true) {
      SavableSubframe[] savableSubframeArr2 = this.subframes;
      if (i02 < savableSubframeArr2.length) {
        encoder12.encode((Struct) savableSubframeArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
