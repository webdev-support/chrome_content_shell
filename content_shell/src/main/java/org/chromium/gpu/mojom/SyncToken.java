package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SyncToken extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public long commandBufferId;
  public int namespaceId;
  public long releaseCount;
  public boolean verifiedFlush;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SyncToken(int version) {
    super(32, version);
  }

  public SyncToken() {
    this(0);
  }

  public static SyncToken deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SyncToken deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SyncToken decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SyncToken result = new SyncToken(elementsOrVersion);
      result.verifiedFlush = decoder0.readBoolean(8, 0);
      int readInt = decoder0.readInt(12);
      result.namespaceId = readInt;
      CommandBufferNamespace.validate(readInt);
      result.namespaceId = CommandBufferNamespace.toKnownValue(result.namespaceId);
      result.commandBufferId = decoder0.readLong(16);
      result.releaseCount = decoder0.readLong(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.verifiedFlush, 8, 0);
    encoder0.encode(this.namespaceId, 12);
    encoder0.encode(this.commandBufferId, 16);
    encoder0.encode(this.releaseCount, 24);
  }
}
