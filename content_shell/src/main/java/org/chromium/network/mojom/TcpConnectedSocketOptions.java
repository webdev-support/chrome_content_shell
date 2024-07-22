package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TcpConnectedSocketOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public TcpKeepAliveOptions keepAliveOptions;
  public boolean noDelay;
  public int receiveBufferSize;
  public int sendBufferSize;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TcpConnectedSocketOptions(int version) {
    super(32, version);
    this.sendBufferSize = 0;
    this.receiveBufferSize = 0;
    this.noDelay = true;
  }

  public TcpConnectedSocketOptions() {
    this(0);
  }

  public static TcpConnectedSocketOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TcpConnectedSocketOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TcpConnectedSocketOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TcpConnectedSocketOptions result = new TcpConnectedSocketOptions(elementsOrVersion);
      result.sendBufferSize = decoder0.readInt(8);
      result.receiveBufferSize = decoder0.readInt(12);
      result.noDelay = decoder0.readBoolean(16, 0);
      Decoder decoder1 = decoder0.readPointer(24, true);
      result.keepAliveOptions = TcpKeepAliveOptions.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.sendBufferSize, 8);
    encoder0.encode(this.receiveBufferSize, 12);
    encoder0.encode(this.noDelay, 16, 0);
    encoder0.encode((Struct) this.keepAliveOptions, 24, true);
  }
}
