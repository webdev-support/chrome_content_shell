package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.UrlLoaderFactory;
import org.chromium.network.mojom.UrlResponseHead;
import org.chromium.url.mojom.Url;

public final class PrefetchedSignedExchangeInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public Sha256HashValue headerIntegrity;
  public UrlResponseHead innerResponse;
  public Url innerUrl;
  public UrlLoaderFactory loaderFactoryHandle;
  public Url outerUrl;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PrefetchedSignedExchangeInfo(int version) {
    super(48, version);
  }

  public PrefetchedSignedExchangeInfo() {
    this(0);
  }

  public static PrefetchedSignedExchangeInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PrefetchedSignedExchangeInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PrefetchedSignedExchangeInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PrefetchedSignedExchangeInfo result = new PrefetchedSignedExchangeInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.outerUrl = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.headerIntegrity = Sha256HashValue.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.innerUrl = Url.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.innerResponse = UrlResponseHead.decode(decoder14);
      result.loaderFactoryHandle =
          (UrlLoaderFactory) decoder0.readServiceInterface(40, false, UrlLoaderFactory.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.outerUrl, 8, false);
    encoder0.encode((Struct) this.headerIntegrity, 16, false);
    encoder0.encode((Struct) this.innerUrl, 24, false);
    encoder0.encode((Struct) this.innerResponse, 32, false);
    encoder0.encode(this.loaderFactoryHandle, 40, false, UrlLoaderFactory.MANAGER);
  }
}
