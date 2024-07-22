package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

public final class ManifestShortcutItem extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public String16 description;
  public ManifestImageResource[] icons;
  public String16 name;
  public String16 shortName;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ManifestShortcutItem(int version) {
    super(48, version);
  }

  public ManifestShortcutItem() {
    this(0);
  }

  public static ManifestShortcutItem deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ManifestShortcutItem deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ManifestShortcutItem decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ManifestShortcutItem result = new ManifestShortcutItem(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.name = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.shortName = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.description = String16.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.url = Url.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(40, false);
      DataHeader si1 = decoder15.readDataHeaderForPointerArray(-1);
      result.icons = new ManifestImageResource[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder15.readPointer((i1 * 8) + 8, false);
        result.icons[i1] = ManifestImageResource.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.name, 8, false);
    encoder0.encode((Struct) this.shortName, 16, true);
    encoder0.encode((Struct) this.description, 24, true);
    encoder0.encode((Struct) this.url, 32, false);
    ManifestImageResource[] manifestImageResourceArr = this.icons;
    if (manifestImageResourceArr == null) {
      encoder0.encodeNullPointer(40, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(manifestImageResourceArr.length, 40, -1);
    int i0 = 0;
    while (true) {
      ManifestImageResource[] manifestImageResourceArr2 = this.icons;
      if (i0 < manifestImageResourceArr2.length) {
        encoder1.encode((Struct) manifestImageResourceArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
