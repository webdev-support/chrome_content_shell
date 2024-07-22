package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ProxyRules extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public ProxyBypassRules bypassRules;
  public ProxyList fallbackProxies;
  public ProxyList proxiesForFtp;
  public ProxyList proxiesForHttp;
  public ProxyList proxiesForHttps;
  public boolean reverseBypass;
  public ProxyList singleProxies;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ProxyRules(int version) {
    super(64, version);
  }

  public ProxyRules() {
    this(0);
  }

  public static ProxyRules deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ProxyRules deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ProxyRules decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ProxyRules result = new ProxyRules(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.bypassRules = ProxyBypassRules.decode(decoder1);
      result.reverseBypass = decoder0.readBoolean(16, 0);
      int readInt = decoder0.readInt(20);
      result.type = readInt;
      ProxyRulesType.validate(readInt);
      result.type = ProxyRulesType.toKnownValue(result.type);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.singleProxies = ProxyList.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.proxiesForHttp = ProxyList.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.proxiesForHttps = ProxyList.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.proxiesForFtp = ProxyList.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(56, false);
      result.fallbackProxies = ProxyList.decode(decoder16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.bypassRules, 8, false);
    encoder0.encode(this.reverseBypass, 16, 0);
    encoder0.encode(this.type, 20);
    encoder0.encode((Struct) this.singleProxies, 24, false);
    encoder0.encode((Struct) this.proxiesForHttp, 32, false);
    encoder0.encode((Struct) this.proxiesForHttps, 40, false);
    encoder0.encode((Struct) this.proxiesForFtp, 48, false);
    encoder0.encode((Struct) this.fallbackProxies, 56, false);
  }
}
