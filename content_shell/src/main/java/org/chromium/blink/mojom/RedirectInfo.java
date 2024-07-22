package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;

public final class RedirectInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public CommonNetworkInfo networkInfo;
  public Origin originOfNewUrl;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RedirectInfo(int version) {
    super(24, version);
  }

  public RedirectInfo() {
    this(0);
  }

  public static RedirectInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RedirectInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RedirectInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RedirectInfo result = new RedirectInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.originOfNewUrl = Origin.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.networkInfo = CommonNetworkInfo.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.originOfNewUrl, 8, false);
    encoder0.encode((Struct) this.networkInfo, 16, false);
  }
}
