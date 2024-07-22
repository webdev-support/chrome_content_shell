package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.network.mojom.UrlLoader;
import org.chromium.network.mojom.UrlLoaderClient;
import org.chromium.network.mojom.UrlResponseHead;
import org.chromium.url.mojom.Url;

public final class TransferrableUrlLoader extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public DataPipe.ConsumerHandle body;
  public UrlResponseHead head;
  public Url url;
  public UrlLoader urlLoader;
  public InterfaceRequest<UrlLoaderClient> urlLoaderClient;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TransferrableUrlLoader(int version) {
    super(40, version);
    this.body = InvalidHandle.INSTANCE;
  }

  public TransferrableUrlLoader() {
    this(0);
  }

  public static TransferrableUrlLoader deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TransferrableUrlLoader deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TransferrableUrlLoader decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TransferrableUrlLoader result = new TransferrableUrlLoader(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      result.urlLoader = (UrlLoader) decoder0.readServiceInterface(16, false, UrlLoader.MANAGER);
      result.urlLoaderClient = decoder0.readInterfaceRequest(24, false);
      result.body = decoder0.readConsumerHandle(28, true);
      Decoder decoder12 = decoder0.readPointer(32, false);
      result.head = UrlResponseHead.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode(this.urlLoader, 16, false, UrlLoader.MANAGER);
    encoder0.encode((InterfaceRequest) this.urlLoaderClient, 24, false);
    encoder0.encode((Handle) this.body, 28, true);
    encoder0.encode((Struct) this.head, 32, false);
  }
}
