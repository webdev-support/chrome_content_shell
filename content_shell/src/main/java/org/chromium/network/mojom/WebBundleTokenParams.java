package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Url;

public final class WebBundleTokenParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public Url bundleUrl;
  public int renderProcessId;
  public UnguessableToken token;
  public WebBundleHandle webBundleHandle;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WebBundleTokenParams(int version) {
    super(40, version);
  }

  public WebBundleTokenParams() {
    this(0);
  }

  public static WebBundleTokenParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WebBundleTokenParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WebBundleTokenParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WebBundleTokenParams result = new WebBundleTokenParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.bundleUrl = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.token = UnguessableToken.decode(decoder12);
      result.webBundleHandle =
          (WebBundleHandle) decoder0.readServiceInterface(24, true, WebBundleHandle.MANAGER);
      result.renderProcessId = decoder0.readInt(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.bundleUrl, 8, false);
    encoder0.encode((Struct) this.token, 16, false);
    encoder0.encode(this.webBundleHandle, 24, true, WebBundleHandle.MANAGER);
    encoder0.encode(this.renderProcessId, 32);
  }
}
