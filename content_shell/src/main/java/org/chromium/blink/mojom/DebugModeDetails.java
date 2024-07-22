package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DebugModeDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public DebugKey debugKey;
  public boolean isEnabled;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DebugModeDetails(int version) {
    super(24, version);
    this.isEnabled = false;
  }

  public DebugModeDetails() {
    this(0);
  }

  public static DebugModeDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DebugModeDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DebugModeDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DebugModeDetails result = new DebugModeDetails(elementsOrVersion);
      result.isEnabled = decoder0.readBoolean(8, 0);
      Decoder decoder1 = decoder0.readPointer(16, true);
      result.debugKey = DebugKey.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.isEnabled, 8, 0);
    encoder0.encode((Struct) this.debugKey, 16, true);
  }
}
