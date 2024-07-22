package org.chromium.content_settings.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class RendererContentSettingRules extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public ContentSettingPatternSource[] autoDarkContentRules;
  public ContentSettingPatternSource[] imageRules;
  public ContentSettingPatternSource[] mixedContentRules;
  public ContentSettingPatternSource[] popupRedirectRules;
  public ContentSettingPatternSource[] scriptRules;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RendererContentSettingRules(int version) {
    super(48, version);
  }

  public RendererContentSettingRules() {
    this(0);
  }

  public static RendererContentSettingRules deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RendererContentSettingRules deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RendererContentSettingRules decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RendererContentSettingRules result = new RendererContentSettingRules(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.imageRules = new ContentSettingPatternSource[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.imageRules[i1] = ContentSettingPatternSource.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.scriptRules = new ContentSettingPatternSource[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.scriptRules[i12] = ContentSettingPatternSource.decode(decoder22);
      }
      Decoder decoder13 = decoder0.readPointer(24, false);
      DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
      result.popupRedirectRules = new ContentSettingPatternSource[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        Decoder decoder23 = decoder13.readPointer((i13 * 8) + 8, false);
        result.popupRedirectRules[i13] = ContentSettingPatternSource.decode(decoder23);
      }
      Decoder decoder14 = decoder0.readPointer(32, false);
      DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
      result.mixedContentRules = new ContentSettingPatternSource[si14.elementsOrVersion];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        Decoder decoder24 = decoder14.readPointer((i14 * 8) + 8, false);
        result.mixedContentRules[i14] = ContentSettingPatternSource.decode(decoder24);
      }
      Decoder decoder15 = decoder0.readPointer(40, false);
      DataHeader si15 = decoder15.readDataHeaderForPointerArray(-1);
      result.autoDarkContentRules = new ContentSettingPatternSource[si15.elementsOrVersion];
      for (int i15 = 0; i15 < si15.elementsOrVersion; i15++) {
        Decoder decoder25 = decoder15.readPointer((i15 * 8) + 8, false);
        result.autoDarkContentRules[i15] = ContentSettingPatternSource.decode(decoder25);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    ContentSettingPatternSource[] contentSettingPatternSourceArr = this.imageRules;
    if (contentSettingPatternSourceArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(contentSettingPatternSourceArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ContentSettingPatternSource[] contentSettingPatternSourceArr2 = this.imageRules;
        if (i0 >= contentSettingPatternSourceArr2.length) {
          break;
        }
        encoder1.encode((Struct) contentSettingPatternSourceArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    ContentSettingPatternSource[] contentSettingPatternSourceArr3 = this.scriptRules;
    if (contentSettingPatternSourceArr3 == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder12 =
          encoder0.encodePointerArray(contentSettingPatternSourceArr3.length, 16, -1);
      int i02 = 0;
      while (true) {
        ContentSettingPatternSource[] contentSettingPatternSourceArr4 = this.scriptRules;
        if (i02 >= contentSettingPatternSourceArr4.length) {
          break;
        }
        encoder12.encode((Struct) contentSettingPatternSourceArr4[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    ContentSettingPatternSource[] contentSettingPatternSourceArr5 = this.popupRedirectRules;
    if (contentSettingPatternSourceArr5 == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder13 =
          encoder0.encodePointerArray(contentSettingPatternSourceArr5.length, 24, -1);
      int i03 = 0;
      while (true) {
        ContentSettingPatternSource[] contentSettingPatternSourceArr6 = this.popupRedirectRules;
        if (i03 >= contentSettingPatternSourceArr6.length) {
          break;
        }
        encoder13.encode((Struct) contentSettingPatternSourceArr6[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    ContentSettingPatternSource[] contentSettingPatternSourceArr7 = this.mixedContentRules;
    if (contentSettingPatternSourceArr7 == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder14 =
          encoder0.encodePointerArray(contentSettingPatternSourceArr7.length, 32, -1);
      int i04 = 0;
      while (true) {
        ContentSettingPatternSource[] contentSettingPatternSourceArr8 = this.mixedContentRules;
        if (i04 >= contentSettingPatternSourceArr8.length) {
          break;
        }
        encoder14.encode((Struct) contentSettingPatternSourceArr8[i04], (i04 * 8) + 8, false);
        i04++;
      }
    }
    ContentSettingPatternSource[] contentSettingPatternSourceArr9 = this.autoDarkContentRules;
    if (contentSettingPatternSourceArr9 == null) {
      encoder0.encodeNullPointer(40, false);
      return;
    }
    Encoder encoder15 = encoder0.encodePointerArray(contentSettingPatternSourceArr9.length, 40, -1);
    int i05 = 0;
    while (true) {
      ContentSettingPatternSource[] contentSettingPatternSourceArr10 = this.autoDarkContentRules;
      if (i05 < contentSettingPatternSourceArr10.length) {
        encoder15.encode((Struct) contentSettingPatternSourceArr10[i05], (i05 * 8) + 8, false);
        i05++;
      } else {
        return;
      }
    }
  }
}
