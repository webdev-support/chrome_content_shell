package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.BigString16;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

public final class DragItemString extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public Url baseUrl;
  public BigString16 stringData;
  public String stringType;
  public String16 title;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DragItemString(int version) {
    super(40, version);
  }

  public DragItemString() {
    this(0);
  }

  public static DragItemString deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DragItemString deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DragItemString decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DragItemString result = new DragItemString(elementsOrVersion);
      result.stringType = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.stringData = BigString16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.title = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, true);
      result.baseUrl = Url.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.stringType, 8, false);
    encoder0.encode((Struct) this.stringData, 16, false);
    encoder0.encode((Struct) this.title, 24, true);
    encoder0.encode((Struct) this.baseUrl, 32, true);
  }
}
