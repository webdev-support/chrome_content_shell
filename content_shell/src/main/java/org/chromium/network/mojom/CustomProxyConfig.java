package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CustomProxyConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowNonIdempotentMethods;
  public HttpRequestHeaders connectTunnelHeaders;
  public ProxyRules rules;
  public boolean shouldOverrideExistingConfig;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CustomProxyConfig(int version) {
    super(32, version);
    this.shouldOverrideExistingConfig = false;
    this.allowNonIdempotentMethods = false;
  }

  public CustomProxyConfig() {
    this(0);
  }

  public static CustomProxyConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CustomProxyConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CustomProxyConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CustomProxyConfig result = new CustomProxyConfig(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.rules = ProxyRules.decode(decoder1);
      result.shouldOverrideExistingConfig = decoder0.readBoolean(16, 0);
      result.allowNonIdempotentMethods = decoder0.readBoolean(16, 1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.connectTunnelHeaders = HttpRequestHeaders.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.rules, 8, false);
    encoder0.encode(this.shouldOverrideExistingConfig, 16, 0);
    encoder0.encode(this.allowNonIdempotentMethods, 16, 1);
    encoder0.encode((Struct) this.connectTunnelHeaders, 24, false);
  }
}
