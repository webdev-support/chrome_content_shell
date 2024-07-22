package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ProxyResolvingSocketOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean fakeTlsHandshake;
  public boolean useTls;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ProxyResolvingSocketOptions(int version) {
    super(16, version);
    this.useTls = false;
    this.fakeTlsHandshake = false;
  }

  public ProxyResolvingSocketOptions() {
    this(0);
  }

  public static ProxyResolvingSocketOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ProxyResolvingSocketOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ProxyResolvingSocketOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ProxyResolvingSocketOptions result = new ProxyResolvingSocketOptions(elementsOrVersion);
      result.useTls = decoder0.readBoolean(8, 0);
      result.fakeTlsHandshake = decoder0.readBoolean(8, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.useTls, 8, 0);
    encoder0.encode(this.fakeTlsHandshake, 8, 1);
  }
}
