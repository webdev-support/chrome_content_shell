package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.IpEndPoint;

public final class CommonNetworkInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean alwaysAccessNetwork;
  public boolean networkAccessed;
  public IpEndPoint remoteEndpoint;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CommonNetworkInfo(int version) {
    super(24, version);
  }

  public CommonNetworkInfo() {
    this(0);
  }

  public static CommonNetworkInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CommonNetworkInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CommonNetworkInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CommonNetworkInfo result = new CommonNetworkInfo(elementsOrVersion);
      result.networkAccessed = decoder0.readBoolean(8, 0);
      result.alwaysAccessNetwork = decoder0.readBoolean(8, 1);
      Decoder decoder1 = decoder0.readPointer(16, true);
      result.remoteEndpoint = IpEndPoint.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.networkAccessed, 8, 0);
    encoder0.encode(this.alwaysAccessNetwork, 8, 1);
    encoder0.encode((Struct) this.remoteEndpoint, 16, true);
  }
}
