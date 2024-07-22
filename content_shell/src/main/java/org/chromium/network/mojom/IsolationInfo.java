package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;

public final class IsolationInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public Origin frameOrigin;
  public UnguessableToken nonce;
  public int requestType;
  public SiteForCookies siteForCookies;
  public Origin topFrameOrigin;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private IsolationInfo(int version) {
    super(48, version);
  }

  public IsolationInfo() {
    this(0);
  }

  public static IsolationInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static IsolationInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static IsolationInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      IsolationInfo result = new IsolationInfo(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.requestType = readInt;
      IsolationInfoRequestType.validate(readInt);
      result.requestType = IsolationInfoRequestType.toKnownValue(result.requestType);
      Decoder decoder1 = decoder0.readPointer(16, true);
      result.topFrameOrigin = Origin.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.frameOrigin = Origin.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, true);
      result.nonce = UnguessableToken.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.siteForCookies = SiteForCookies.decode(decoder14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.requestType, 8);
    encoder0.encode((Struct) this.topFrameOrigin, 16, true);
    encoder0.encode((Struct) this.frameOrigin, 24, true);
    encoder0.encode((Struct) this.nonce, 32, true);
    encoder0.encode((Struct) this.siteForCookies, 40, false);
  }
}
