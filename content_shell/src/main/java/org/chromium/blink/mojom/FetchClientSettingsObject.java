package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.ReferrerPolicy;
import org.chromium.url.mojom.Url;

public final class FetchClientSettingsObject extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int insecureRequestsPolicy;
  public Url outgoingReferrer;
  public int referrerPolicy;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FetchClientSettingsObject(int version) {
    super(24, version);
  }

  public FetchClientSettingsObject() {
    this(0);
  }

  public static FetchClientSettingsObject deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FetchClientSettingsObject deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FetchClientSettingsObject decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FetchClientSettingsObject result = new FetchClientSettingsObject(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.referrerPolicy = readInt;
      ReferrerPolicy.validate(readInt);
      result.referrerPolicy = ReferrerPolicy.toKnownValue(result.referrerPolicy);
      int readInt2 = decoder0.readInt(12);
      result.insecureRequestsPolicy = readInt2;
      InsecureRequestsPolicy.validate(readInt2);
      result.insecureRequestsPolicy =
          InsecureRequestsPolicy.toKnownValue(result.insecureRequestsPolicy);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.outgoingReferrer = Url.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.referrerPolicy, 8);
    encoder0.encode(this.insecureRequestsPolicy, 12);
    encoder0.encode((Struct) this.outgoingReferrer, 16, false);
  }
}
