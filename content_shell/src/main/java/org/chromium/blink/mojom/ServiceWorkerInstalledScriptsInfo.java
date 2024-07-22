package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class ServiceWorkerInstalledScriptsInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public Url[] installedUrls;
  public ServiceWorkerInstalledScriptsManagerHost managerHostRemote;
  public InterfaceRequest<ServiceWorkerInstalledScriptsManager> managerReceiver;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ServiceWorkerInstalledScriptsInfo(int version) {
    super(32, version);
  }

  public ServiceWorkerInstalledScriptsInfo() {
    this(0);
  }

  public static ServiceWorkerInstalledScriptsInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ServiceWorkerInstalledScriptsInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ServiceWorkerInstalledScriptsInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ServiceWorkerInstalledScriptsInfo result =
          new ServiceWorkerInstalledScriptsInfo(elementsOrVersion);
      result.managerReceiver = decoder0.readInterfaceRequest(8, false);
      result.managerHostRemote =
          (ServiceWorkerInstalledScriptsManagerHost)
              decoder0.readServiceInterface(
                  12, false, ServiceWorkerInstalledScriptsManagerHost.MANAGER);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.installedUrls = new Url[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.installedUrls[i1] = Url.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((InterfaceRequest) this.managerReceiver, 8, false);
    encoder0.encode(
        this.managerHostRemote, 12, false, ServiceWorkerInstalledScriptsManagerHost.MANAGER);
    Url[] urlArr = this.installedUrls;
    if (urlArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 24, -1);
    int i0 = 0;
    while (true) {
      Url[] urlArr2 = this.installedUrls;
      if (i0 < urlArr2.length) {
        encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
