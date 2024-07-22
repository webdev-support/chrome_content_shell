package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BackgroundFetchOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public long downloadTotal;
  public ManifestImageResource[] icons;
  public String title;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BackgroundFetchOptions(int version) {
    super(32, version);
  }

  public BackgroundFetchOptions() {
    this(0);
  }

  public static BackgroundFetchOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BackgroundFetchOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BackgroundFetchOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BackgroundFetchOptions result = new BackgroundFetchOptions(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.icons = new ManifestImageResource[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.icons[i1] = ManifestImageResource.decode(decoder2);
      }
      result.downloadTotal = decoder0.readLong(16);
      result.title = decoder0.readString(24, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    ManifestImageResource[] manifestImageResourceArr = this.icons;
    if (manifestImageResourceArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(manifestImageResourceArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ManifestImageResource[] manifestImageResourceArr2 = this.icons;
        if (i0 >= manifestImageResourceArr2.length) {
          break;
        }
        encoder1.encode((Struct) manifestImageResourceArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.downloadTotal, 16);
    encoder0.encode(this.title, 24, false);
  }
}
