package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class UrlRequestDevToolsInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean hasUserGesture;
  public String method;
  public int priority;
  public int referrerPolicy;
  public int resourceType;
  public TrustTokenParams trustTokenParams;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UrlRequestDevToolsInfo(int version) {
    super(48, version);
  }

  public UrlRequestDevToolsInfo() {
    this(0);
  }

  public static UrlRequestDevToolsInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UrlRequestDevToolsInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UrlRequestDevToolsInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UrlRequestDevToolsInfo result = new UrlRequestDevToolsInfo(elementsOrVersion);
      result.method = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.url = Url.decode(decoder1);
      int readInt = decoder0.readInt(24);
      result.priority = readInt;
      RequestPriority.validate(readInt);
      result.priority = RequestPriority.toKnownValue(result.priority);
      int readInt2 = decoder0.readInt(28);
      result.referrerPolicy = readInt2;
      UrlRequestReferrerPolicy.validate(readInt2);
      result.referrerPolicy = UrlRequestReferrerPolicy.toKnownValue(result.referrerPolicy);
      Decoder decoder12 = decoder0.readPointer(32, true);
      result.trustTokenParams = TrustTokenParams.decode(decoder12);
      result.hasUserGesture = decoder0.readBoolean(40, 0);
      result.resourceType = decoder0.readInt(44);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.method, 8, false);
    encoder0.encode((Struct) this.url, 16, false);
    encoder0.encode(this.priority, 24);
    encoder0.encode(this.referrerPolicy, 28);
    encoder0.encode((Struct) this.trustTokenParams, 32, true);
    encoder0.encode(this.hasUserGesture, 40, 0);
    encoder0.encode(this.resourceType, 44);
  }
}
