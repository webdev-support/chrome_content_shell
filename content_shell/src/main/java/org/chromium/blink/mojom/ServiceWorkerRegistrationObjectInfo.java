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

public final class ServiceWorkerRegistrationObjectInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public ServiceWorkerObjectInfo active;
  public AssociatedInterfaceNotSupported hostRemote;
  public ServiceWorkerObjectInfo installing;
  public AssociatedInterfaceRequestNotSupported receiver;
  public long registrationId;
  public Url scope;
  public int updateViaCache;
  public ServiceWorkerObjectInfo waiting;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ServiceWorkerRegistrationObjectInfo(int version) {
    super(64, version);
    this.registrationId = -1L;
  }

  public ServiceWorkerRegistrationObjectInfo() {
    this(0);
  }

  public static ServiceWorkerRegistrationObjectInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ServiceWorkerRegistrationObjectInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ServiceWorkerRegistrationObjectInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ServiceWorkerRegistrationObjectInfo result =
          new ServiceWorkerRegistrationObjectInfo(elementsOrVersion);
      result.registrationId = decoder0.readLong(8);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.scope = Url.decode(decoder1);
      int readInt = decoder0.readInt(24);
      result.updateViaCache = readInt;
      ServiceWorkerUpdateViaCache.validate(readInt);
      result.updateViaCache = ServiceWorkerUpdateViaCache.toKnownValue(result.updateViaCache);
      result.hostRemote = decoder0.readAssociatedServiceInterfaceNotSupported(28, false);
      result.receiver = decoder0.readAssociatedInterfaceRequestNotSupported(36, false);
      Decoder decoder12 = decoder0.readPointer(40, true);
      result.installing = ServiceWorkerObjectInfo.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(48, true);
      result.waiting = ServiceWorkerObjectInfo.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(56, true);
      result.active = ServiceWorkerObjectInfo.decode(decoder14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.registrationId, 8);
    encoder0.encode((Struct) this.scope, 16, false);
    encoder0.encode(this.updateViaCache, 24);
    encoder0.encode(this.hostRemote, 28, false);
    encoder0.encode(this.receiver, 36, false);
    encoder0.encode((Struct) this.installing, 40, true);
    encoder0.encode((Struct) this.waiting, 48, true);
    encoder0.encode((Struct) this.active, 56, true);
  }
}
