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

public final class PrerenderAttributes extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public Referrer referrer;
  public int triggerType;
  public Url url;
  public Size viewSize;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PrerenderAttributes(int version) {
    super(40, version);
  }

  public PrerenderAttributes() {
    this(0);
  }

  public static PrerenderAttributes deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PrerenderAttributes deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PrerenderAttributes decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PrerenderAttributes result = new PrerenderAttributes(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.triggerType = readInt;
      PrerenderTriggerType.validate(readInt);
      result.triggerType = PrerenderTriggerType.toKnownValue(result.triggerType);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.referrer = Referrer.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.viewSize = Size.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode(this.triggerType, 16);
    encoder0.encode((Struct) this.referrer, 24, false);
    encoder0.encode((Struct) this.viewSize, 32, false);
  }
}
