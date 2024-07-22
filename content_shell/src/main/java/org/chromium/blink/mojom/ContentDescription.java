package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ContentDescription extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public int category;
  public String description;
  public ContentIconDefinition[] icons;

  public String f412id;
  public String launchUrl;
  public String title;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ContentDescription(int version) {
    super(56, version);
  }

  public ContentDescription() {
    this(0);
  }

  public static ContentDescription deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ContentDescription deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ContentDescription decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ContentDescription result = new ContentDescription(elementsOrVersion);
      result.f412id = decoder0.readString(8, false);
      result.title = decoder0.readString(16, false);
      result.description = decoder0.readString(24, false);
      int readInt = decoder0.readInt(32);
      result.category = readInt;
      ContentCategory.validate(readInt);
      result.category = ContentCategory.toKnownValue(result.category);
      Decoder decoder1 = decoder0.readPointer(40, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.icons = new ContentIconDefinition[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.icons[i1] = ContentIconDefinition.decode(decoder2);
      }
      result.launchUrl = decoder0.readString(48, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f412id, 8, false);
    encoder0.encode(this.title, 16, false);
    encoder0.encode(this.description, 24, false);
    encoder0.encode(this.category, 32);
    ContentIconDefinition[] contentIconDefinitionArr = this.icons;
    if (contentIconDefinitionArr == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(contentIconDefinitionArr.length, 40, -1);
      int i0 = 0;
      while (true) {
        ContentIconDefinition[] contentIconDefinitionArr2 = this.icons;
        if (i0 >= contentIconDefinitionArr2.length) {
          break;
        }
        encoder1.encode((Struct) contentIconDefinitionArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.launchUrl, 48, false);
  }
}
