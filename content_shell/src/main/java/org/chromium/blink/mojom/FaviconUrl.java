package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class FaviconUrl extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public Size[] iconSizes;
  public int iconType;
  public Url iconUrl;
  public boolean isDefaultIcon;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FaviconUrl(int version) {
    super(32, version);
  }

  public FaviconUrl() {
    this(0);
  }

  public static FaviconUrl deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FaviconUrl deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FaviconUrl decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FaviconUrl result = new FaviconUrl(elementsOrVersion);
      result.iconUrl = Url.decode(decoder0.readPointer(8, false));
      int readInt = decoder0.readInt(16);
      result.iconType = readInt;
      FaviconIconType.validate(readInt);
      result.iconType = FaviconIconType.toKnownValue(result.iconType);
      result.isDefaultIcon = decoder0.readBoolean(20, 0);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.iconSizes = new Size[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.iconSizes[i1] = Size.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.iconUrl, 8, false);
    encoder0.encode(this.iconType, 16);
    encoder0.encode(this.isDefaultIcon, 20, 0);
    Size[] sizeArr = this.iconSizes;
    if (sizeArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(sizeArr.length, 24, -1);
    int i0 = 0;
    while (true) {
      Size[] sizeArr2 = this.iconSizes;
      if (i0 < sizeArr2.length) {
        encoder1.encode((Struct) sizeArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
