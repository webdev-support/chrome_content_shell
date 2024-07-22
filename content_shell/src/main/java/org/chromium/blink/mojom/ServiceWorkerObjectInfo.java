package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class ServiceWorkerObjectInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public AssociatedInterfaceNotSupported hostRemote;
  public AssociatedInterfaceRequestNotSupported receiver;
  public int state;
  public Url url;
  public long versionId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ServiceWorkerObjectInfo(int version) {
    super(40, version);
    this.versionId = -1L;
    this.state = 0;
  }

  public ServiceWorkerObjectInfo() {
    this(0);
  }

  public static ServiceWorkerObjectInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ServiceWorkerObjectInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ServiceWorkerObjectInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ServiceWorkerObjectInfo result = new ServiceWorkerObjectInfo(elementsOrVersion);
      result.versionId = decoder0.readLong(8);
      int readInt = decoder0.readInt(16);
      result.state = readInt;
      ServiceWorkerState.validate(readInt);
      result.state = ServiceWorkerState.toKnownValue(result.state);
      result.receiver = decoder0.readAssociatedInterfaceRequestNotSupported(20, false);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.url = Url.decode(decoder1);
      result.hostRemote = decoder0.readAssociatedServiceInterfaceNotSupported(32, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.versionId, 8);
    encoder0.encode(this.state, 16);
    encoder0.encode(this.receiver, 20, false);
    encoder0.encode((Struct) this.url, 24, false);
    encoder0.encode(this.hostRemote, 32, false);
  }
}
