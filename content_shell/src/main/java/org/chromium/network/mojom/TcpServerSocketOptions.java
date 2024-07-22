package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TcpServerSocketOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public int backlog;
  public int ipv6Only;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TcpServerSocketOptions(int version) {
    super(16, version);
  }

  public TcpServerSocketOptions() {
    this(0);
  }

  public static TcpServerSocketOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TcpServerSocketOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TcpServerSocketOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TcpServerSocketOptions result = new TcpServerSocketOptions(elementsOrVersion);
      result.backlog = decoder0.readInt(8);
      int readInt = decoder0.readInt(12);
      result.ipv6Only = readInt;
      OptionalBool.validate(readInt);
      result.ipv6Only = OptionalBool.toKnownValue(result.ipv6Only);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.backlog, 8);
    encoder0.encode(this.ipv6Only, 12);
  }
}
