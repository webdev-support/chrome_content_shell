package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.BigString;

public final class ProxyConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean autoDetect;
  public boolean fromSystem;
  public boolean pacMandatory;
  public BigString pacUrl;
  public ProxyRules proxyRules;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ProxyConfig(int version) {
    super(32, version);
  }

  public ProxyConfig() {
    this(0);
  }

  public static ProxyConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ProxyConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ProxyConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ProxyConfig result = new ProxyConfig(elementsOrVersion);
      result.autoDetect = decoder0.readBoolean(8, 0);
      result.fromSystem = decoder0.readBoolean(8, 1);
      result.pacMandatory = decoder0.readBoolean(8, 2);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.pacUrl = BigString.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.proxyRules = ProxyRules.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.autoDetect, 8, 0);
    encoder0.encode(this.fromSystem, 8, 1);
    encoder0.encode(this.pacMandatory, 8, 2);
    encoder0.encode((Struct) this.pacUrl, 16, false);
    encoder0.encode((Struct) this.proxyRules, 24, false);
  }
}
