package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class UrlLoaderClientEndpoints extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public UrlLoader urlLoader;
  public InterfaceRequest<UrlLoaderClient> urlLoaderClient;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UrlLoaderClientEndpoints(int version) {
    super(24, version);
  }

  public UrlLoaderClientEndpoints() {
    this(0);
  }

  public static UrlLoaderClientEndpoints deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UrlLoaderClientEndpoints deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UrlLoaderClientEndpoints decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UrlLoaderClientEndpoints result = new UrlLoaderClientEndpoints(elementsOrVersion);
      result.urlLoader = (UrlLoader) decoder0.readServiceInterface(8, false, UrlLoader.MANAGER);
      result.urlLoaderClient = decoder0.readInterfaceRequest(16, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.urlLoader, 8, false, UrlLoader.MANAGER);
    encoder0.encode((InterfaceRequest) this.urlLoaderClient, 16, false);
  }
}
