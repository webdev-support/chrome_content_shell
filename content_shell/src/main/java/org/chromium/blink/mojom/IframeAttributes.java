package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.ContentSecurityPolicy;

public final class IframeAttributes extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean adAuctionHeaders;
  public boolean browsingTopics;
  public boolean credentialless;

  public String f434id;
  public String name;
  public ContentSecurityPolicy parsedCspAttribute;
  public boolean sharedStorageWritableOptedIn;
  public String src;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private IframeAttributes(int version) {
    super(48, version);
  }

  public IframeAttributes() {
    this(0);
  }

  public static IframeAttributes deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static IframeAttributes deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static IframeAttributes decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      IframeAttributes result = new IframeAttributes(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.parsedCspAttribute = ContentSecurityPolicy.decode(decoder1);
      result.credentialless = decoder0.readBoolean(16, 0);
      result.browsingTopics = decoder0.readBoolean(16, 1);
      result.adAuctionHeaders = decoder0.readBoolean(16, 2);
      result.sharedStorageWritableOptedIn = decoder0.readBoolean(16, 3);
      result.f434id = decoder0.readString(24, true);
      result.name = decoder0.readString(32, true);
      result.src = decoder0.readString(40, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.parsedCspAttribute, 8, true);
    encoder0.encode(this.credentialless, 16, 0);
    encoder0.encode(this.browsingTopics, 16, 1);
    encoder0.encode(this.adAuctionHeaders, 16, 2);
    encoder0.encode(this.sharedStorageWritableOptedIn, 16, 3);
    encoder0.encode(this.f434id, 24, true);
    encoder0.encode(this.name, 32, true);
    encoder0.encode(this.src, 40, true);
  }
}
