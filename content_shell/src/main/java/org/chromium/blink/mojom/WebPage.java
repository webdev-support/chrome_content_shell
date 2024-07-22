package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.schema_org.mojom.Entity;
import org.chromium.url.mojom.Url;

public final class WebPage extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public Entity[] entities;
  public String title;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WebPage(int version) {
    super(32, version);
  }

  public WebPage() {
    this(0);
  }

  public static WebPage deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WebPage deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WebPage decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WebPage result = new WebPage(elementsOrVersion);
      result.url = Url.decode(decoder0.readPointer(8, false));
      result.title = decoder0.readString(16, false);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.entities = new Entity[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.entities[i1] = Entity.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode(this.title, 16, false);
    Entity[] entityArr = this.entities;
    if (entityArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(entityArr.length, 24, -1);
    int i0 = 0;
    while (true) {
      Entity[] entityArr2 = this.entities;
      if (i0 < entityArr2.length) {
        encoder1.encode((Struct) entityArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
