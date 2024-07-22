package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.UrlLoaderClient;
import org.chromium.network.mojom.UrlLoaderFactory;

public final class DispatchFetchEventParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public String clientId;
  public boolean isOfflineCapabilityCheck;
  public InterfaceRequest<UrlLoaderClient> preloadUrlLoaderClientReceiver;
  public UrlLoaderFactory raceNetworkRequestLoaderFactory;
  public FetchApiRequest request;
  public String resultingClientId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DispatchFetchEventParams(int version) {
    super(48, version);
    this.isOfflineCapabilityCheck = false;
  }

  public DispatchFetchEventParams() {
    this(0);
  }

  public static DispatchFetchEventParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DispatchFetchEventParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DispatchFetchEventParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DispatchFetchEventParams result = new DispatchFetchEventParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.request = FetchApiRequest.decode(decoder1);
      result.clientId = decoder0.readString(16, false);
      result.resultingClientId = decoder0.readString(24, false);
      result.preloadUrlLoaderClientReceiver = decoder0.readInterfaceRequest(32, true);
      result.isOfflineCapabilityCheck = decoder0.readBoolean(36, 0);
      result.raceNetworkRequestLoaderFactory =
          (UrlLoaderFactory) decoder0.readServiceInterface(40, true, UrlLoaderFactory.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.request, 8, false);
    encoder0.encode(this.clientId, 16, false);
    encoder0.encode(this.resultingClientId, 24, false);
    encoder0.encode((InterfaceRequest) this.preloadUrlLoaderClientReceiver, 32, true);
    encoder0.encode(this.isOfflineCapabilityCheck, 36, 0);
    encoder0.encode(this.raceNetworkRequestLoaderFactory, 40, true, UrlLoaderFactory.MANAGER);
  }
}
