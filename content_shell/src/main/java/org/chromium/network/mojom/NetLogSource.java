package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class NetLogSource extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int sourceId;
  public int sourceType;
  public TimeTicks startTime;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NetLogSource(int version) {
    super(24, version);
  }

  public NetLogSource() {
    this(0);
  }

  public static NetLogSource deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NetLogSource deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NetLogSource decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NetLogSource result = new NetLogSource(elementsOrVersion);
      result.sourceType = decoder0.readInt(8);
      result.sourceId = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.startTime = TimeTicks.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.sourceType, 8);
    encoder0.encode(this.sourceId, 12);
    encoder0.encode((Struct) this.startTime, 16, false);
  }
}
