package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ServiceWorkerClientQueryOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public int clientType;
  public boolean includeUncontrolled;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ServiceWorkerClientQueryOptions(int version) {
    super(16, version);
    this.includeUncontrolled = false;
    this.clientType = 0;
  }

  public ServiceWorkerClientQueryOptions() {
    this(0);
  }

  public static ServiceWorkerClientQueryOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ServiceWorkerClientQueryOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ServiceWorkerClientQueryOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ServiceWorkerClientQueryOptions result =
          new ServiceWorkerClientQueryOptions(elementsOrVersion);
      result.includeUncontrolled = decoder0.readBoolean(8, 0);
      int readInt = decoder0.readInt(12);
      result.clientType = readInt;
      ServiceWorkerClientType.validate(readInt);
      result.clientType = ServiceWorkerClientType.toKnownValue(result.clientType);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.includeUncontrolled, 8, 0);
    encoder0.encode(this.clientType, 12);
  }
}
