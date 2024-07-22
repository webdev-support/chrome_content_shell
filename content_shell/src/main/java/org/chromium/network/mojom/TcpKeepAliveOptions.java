package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TcpKeepAliveOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public short delay;
  public boolean enable;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TcpKeepAliveOptions(int version) {
    super(16, version);
    this.enable = false;
    this.delay = (short) 0;
  }

  public TcpKeepAliveOptions() {
    this(0);
  }

  public static TcpKeepAliveOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TcpKeepAliveOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TcpKeepAliveOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TcpKeepAliveOptions result = new TcpKeepAliveOptions(elementsOrVersion);
      result.enable = decoder0.readBoolean(8, 0);
      result.delay = decoder0.readShort(10);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.enable, 8, 0);
    encoder0.encode(this.delay, 10);
  }
}
