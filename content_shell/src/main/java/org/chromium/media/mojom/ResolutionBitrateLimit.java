package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ResolutionBitrateLimit extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public Size frameSize;
  public int maxBitrateBps;
  public int minBitrateBps;
  public int minStartBitrateBps;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ResolutionBitrateLimit(int version) {
    super(32, version);
  }

  public ResolutionBitrateLimit() {
    this(0);
  }

  public static ResolutionBitrateLimit deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ResolutionBitrateLimit deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ResolutionBitrateLimit decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ResolutionBitrateLimit result = new ResolutionBitrateLimit(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.frameSize = Size.decode(decoder1);
      result.minStartBitrateBps = decoder0.readInt(16);
      result.minBitrateBps = decoder0.readInt(20);
      result.maxBitrateBps = decoder0.readInt(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.frameSize, 8, false);
    encoder0.encode(this.minStartBitrateBps, 16);
    encoder0.encode(this.minBitrateBps, 20);
    encoder0.encode(this.maxBitrateBps, 24);
  }
}
