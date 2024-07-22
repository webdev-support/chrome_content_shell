package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class NetworkConditions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public double downloadThroughput;
  public TimeDelta latency;
  public boolean offline;
  public double uploadThroughput;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NetworkConditions(int version) {
    super(40, version);
  }

  public NetworkConditions() {
    this(0);
  }

  public static NetworkConditions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NetworkConditions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NetworkConditions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NetworkConditions result = new NetworkConditions(elementsOrVersion);
      result.offline = decoder0.readBoolean(8, 0);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.latency = TimeDelta.decode(decoder1);
      result.downloadThroughput = decoder0.readDouble(24);
      result.uploadThroughput = decoder0.readDouble(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.offline, 8, 0);
    encoder0.encode((Struct) this.latency, 16, false);
    encoder0.encode(this.downloadThroughput, 24);
    encoder0.encode(this.uploadThroughput, 32);
  }
}
