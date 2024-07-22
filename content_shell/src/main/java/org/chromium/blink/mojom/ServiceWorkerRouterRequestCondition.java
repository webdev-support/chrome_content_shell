package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.RequestDestination;
import org.chromium.network.mojom.RequestMode;

public final class ServiceWorkerRouterRequestCondition extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int destination;
  public boolean hasDestination;
  public boolean hasMode;
  public String method;
  public int mode;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ServiceWorkerRouterRequestCondition(int version) {
    super(32, version);
    this.hasMode = false;
    this.hasDestination = false;
  }

  public ServiceWorkerRouterRequestCondition() {
    this(0);
  }

  public static ServiceWorkerRouterRequestCondition deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ServiceWorkerRouterRequestCondition deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ServiceWorkerRouterRequestCondition decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ServiceWorkerRouterRequestCondition result =
          new ServiceWorkerRouterRequestCondition(elementsOrVersion);
      result.method = decoder0.readString(8, true);
      result.hasMode = decoder0.readBoolean(16, 0);
      result.hasDestination = decoder0.readBoolean(16, 1);
      int readInt = decoder0.readInt(20);
      result.mode = readInt;
      RequestMode.validate(readInt);
      result.mode = RequestMode.toKnownValue(result.mode);
      int readInt2 = decoder0.readInt(24);
      result.destination = readInt2;
      RequestDestination.validate(readInt2);
      result.destination = RequestDestination.toKnownValue(result.destination);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.method, 8, true);
    encoder0.encode(this.hasMode, 16, 0);
    encoder0.encode(this.hasDestination, 16, 1);
    encoder0.encode(this.mode, 20);
    encoder0.encode(this.destination, 24);
  }
}
