package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

public final class P2pSendPacket extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public ReadOnlyBuffer data;
  public P2pPacketInfo packetInfo;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private P2pSendPacket(int version) {
    super(24, version);
  }

  public P2pSendPacket() {
    this(0);
  }

  public static P2pSendPacket deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static P2pSendPacket deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static P2pSendPacket decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      P2pSendPacket result = new P2pSendPacket(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.data = ReadOnlyBuffer.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.packetInfo = P2pPacketInfo.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.data, 8, false);
    encoder0.encode((Struct) this.packetInfo, 16, false);
  }
}
