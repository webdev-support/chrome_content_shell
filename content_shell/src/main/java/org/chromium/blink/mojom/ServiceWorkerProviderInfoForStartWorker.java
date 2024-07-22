package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.UrlLoaderFactory;

public final class ServiceWorkerProviderInfoForStartWorker extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public BrowserInterfaceBroker browserInterfaceBroker;
  public CacheStorage cacheStorage;
  public AssociatedInterfaceNotSupported hostRemote;
  public UrlLoaderFactory scriptLoaderFactoryRemote;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ServiceWorkerProviderInfoForStartWorker(int version) {
    super(40, version);
  }

  public ServiceWorkerProviderInfoForStartWorker() {
    this(0);
  }

  public static ServiceWorkerProviderInfoForStartWorker deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ServiceWorkerProviderInfoForStartWorker deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ServiceWorkerProviderInfoForStartWorker decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ServiceWorkerProviderInfoForStartWorker result =
          new ServiceWorkerProviderInfoForStartWorker(elementsOrVersion);
      result.hostRemote = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
      result.scriptLoaderFactoryRemote =
          (UrlLoaderFactory) decoder0.readServiceInterface(16, true, UrlLoaderFactory.MANAGER);
      result.cacheStorage =
          (CacheStorage) decoder0.readServiceInterface(24, true, CacheStorage.MANAGER);
      result.browserInterfaceBroker =
          (BrowserInterfaceBroker)
              decoder0.readServiceInterface(32, false, BrowserInterfaceBroker.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.hostRemote, 8, false);
    encoder0.encode(this.scriptLoaderFactoryRemote, 16, true, UrlLoaderFactory.MANAGER);
    encoder0.encode(this.cacheStorage, 24, true, CacheStorage.MANAGER);
    encoder0.encode(this.browserInterfaceBroker, 32, false, BrowserInterfaceBroker.MANAGER);
  }
}
