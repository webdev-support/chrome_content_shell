package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class InnerTextParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public Integer nodeId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private InnerTextParams(int version) {
    super(16, version);
  }

  public InnerTextParams() {
    this(0);
  }

  public static InnerTextParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static InnerTextParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static InnerTextParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      InnerTextParams result = new InnerTextParams(elementsOrVersion);
      if (decoder0.readBoolean(8, 0)) {
        result.nodeId = new Integer(decoder0.readInt(12));
      } else {
        result.nodeId = null;
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    int nodeId$value;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    Integer num = this.nodeId;
    boolean nodeId$flag = num != null;
    if (nodeId$flag) {
      nodeId$value = num.intValue();
    } else {
      nodeId$value = 0;
    }
    encoder0.encode(nodeId$flag, 8, 0);
    encoder0.encode(nodeId$value, 12);
  }
}
