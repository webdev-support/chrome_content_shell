package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BfCacheBlockingDetailedReason extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public String name;
  public BlockingReasonSourceLocation source;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BfCacheBlockingDetailedReason(int version) {
    super(24, version);
  }

  public BfCacheBlockingDetailedReason() {
    this(0);
  }

  public static BfCacheBlockingDetailedReason deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BfCacheBlockingDetailedReason deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BfCacheBlockingDetailedReason decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BfCacheBlockingDetailedReason result = new BfCacheBlockingDetailedReason(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, true);
      result.source = BlockingReasonSourceLocation.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    encoder0.encode((Struct) this.source, 16, true);
  }
}
