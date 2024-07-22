package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class P2pSendPacketMetrics extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 8;
  private static final DataHeader[] VERSION_ARRAY;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private P2pSendPacketMetrics(int version) {
    super(8, version);
  }

  public P2pSendPacketMetrics() {
    this(0);
  }

  public static P2pSendPacketMetrics deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static P2pSendPacketMetrics deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static P2pSendPacketMetrics decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      P2pSendPacketMetrics result = new P2pSendPacketMetrics(elementsOrVersion);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
  }
}
