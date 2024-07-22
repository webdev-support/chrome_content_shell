package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SerialHostControlSignals extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean brk;
  public boolean dtr;
  public boolean hasBrk;
  public boolean hasDtr;
  public boolean hasRts;
  public boolean rts;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SerialHostControlSignals(int version) {
    super(16, version);
    this.hasDtr = false;
    this.hasRts = false;
    this.hasBrk = false;
  }

  public SerialHostControlSignals() {
    this(0);
  }

  public static SerialHostControlSignals deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SerialHostControlSignals deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SerialHostControlSignals decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SerialHostControlSignals result = new SerialHostControlSignals(elementsOrVersion);
      result.dtr = decoder0.readBoolean(8, 0);
      result.hasDtr = decoder0.readBoolean(8, 1);
      result.rts = decoder0.readBoolean(8, 2);
      result.hasRts = decoder0.readBoolean(8, 3);
      result.brk = decoder0.readBoolean(8, 4);
      result.hasBrk = decoder0.readBoolean(8, 5);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.dtr, 8, 0);
    encoder0.encode(this.hasDtr, 8, 1);
    encoder0.encode(this.rts, 8, 2);
    encoder0.encode(this.hasRts, 8, 3);
    encoder0.encode(this.brk, 8, 4);
    encoder0.encode(this.hasBrk, 8, 5);
  }
}
