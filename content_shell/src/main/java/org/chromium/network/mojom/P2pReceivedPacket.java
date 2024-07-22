package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class P2pReceivedPacket extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public ReadOnlyBuffer data;
  public IpEndPoint socketAddress;
  public TimeTicks timestamp;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private P2pReceivedPacket(int version) {
    super(32, version);
  }

  public P2pReceivedPacket() {
    this(0);
  }

  public static P2pReceivedPacket deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static P2pReceivedPacket deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static P2pReceivedPacket decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      P2pReceivedPacket result = new P2pReceivedPacket(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.data = ReadOnlyBuffer.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.socketAddress = IpEndPoint.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.timestamp = TimeTicks.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.data, 8, false);
    encoder0.encode((Struct) this.socketAddress, 16, false);
    encoder0.encode((Struct) this.timestamp, 24, false);
  }
}
