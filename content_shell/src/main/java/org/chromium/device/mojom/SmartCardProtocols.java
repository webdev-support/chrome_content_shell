package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SmartCardProtocols extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean raw;

  public boolean f604t0;

  public boolean f605t1;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SmartCardProtocols(int version) {
    super(16, version);
  }

  public SmartCardProtocols() {
    this(0);
  }

  public static SmartCardProtocols deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SmartCardProtocols deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SmartCardProtocols decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SmartCardProtocols result = new SmartCardProtocols(elementsOrVersion);
      result.f604t0 = decoder0.readBoolean(8, 0);
      result.f605t1 = decoder0.readBoolean(8, 1);
      result.raw = decoder0.readBoolean(8, 2);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f604t0, 8, 0);
    encoder0.encode(this.f605t1, 8, 1);
    encoder0.encode(this.raw, 8, 2);
  }
}
