package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ServiceWorkerRouterData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int initialRunningStatus;
  public CacheStorage remoteCacheStorage;
  public ServiceWorkerRouterRules routerRules;
  public InterfaceRequest<ServiceWorkerRunningStatusCallback> runningStatusReceiver;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ServiceWorkerRouterData(int version) {
    super(32, version);
  }

  public ServiceWorkerRouterData() {
    this(0);
  }

  public static ServiceWorkerRouterData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ServiceWorkerRouterData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ServiceWorkerRouterData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ServiceWorkerRouterData result = new ServiceWorkerRouterData(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.routerRules = ServiceWorkerRouterRules.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.initialRunningStatus = readInt;
      ServiceWorkerEmbeddedWorkerStatus.validate(readInt);
      result.initialRunningStatus =
          ServiceWorkerEmbeddedWorkerStatus.toKnownValue(result.initialRunningStatus);
      result.runningStatusReceiver = decoder0.readInterfaceRequest(20, true);
      result.remoteCacheStorage =
          (CacheStorage) decoder0.readServiceInterface(24, false, CacheStorage.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.routerRules, 8, false);
    encoder0.encode(this.initialRunningStatus, 16);
    encoder0.encode((InterfaceRequest) this.runningStatusReceiver, 20, true);
    encoder0.encode(this.remoteCacheStorage, 24, false, CacheStorage.MANAGER);
  }
}
