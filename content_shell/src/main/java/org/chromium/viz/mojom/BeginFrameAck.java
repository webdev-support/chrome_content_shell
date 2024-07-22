package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BeginFrameAck extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean hasDamage;
  public long sequenceNumber;
  public long sourceId;
  public long traceId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BeginFrameAck(int version) {
    super(40, version);
  }

  public BeginFrameAck() {
    this(0);
  }

  public static BeginFrameAck deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BeginFrameAck deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BeginFrameAck decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BeginFrameAck result = new BeginFrameAck(elementsOrVersion);
      result.sourceId = decoder0.readLong(8);
      result.sequenceNumber = decoder0.readLong(16);
      result.traceId = decoder0.readLong(24);
      result.hasDamage = decoder0.readBoolean(32, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.sourceId, 8);
    encoder0.encode(this.sequenceNumber, 16);
    encoder0.encode(this.traceId, 24);
    encoder0.encode(this.hasDamage, 32, 0);
  }
}
