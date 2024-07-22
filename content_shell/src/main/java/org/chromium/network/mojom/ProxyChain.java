package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ProxyChain extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int ipProtectionChainId;
  public ProxyServer[] proxyServers;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ProxyChain(int version) {
    super(24, version);
  }

  public ProxyChain() {
    this(0);
  }

  public static ProxyChain deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ProxyChain deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ProxyChain decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ProxyChain result = new ProxyChain(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      if (decoder1 == null) {
        result.proxyServers = null;
      } else {
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.proxyServers = new ProxyServer[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.proxyServers[i1] = ProxyServer.decode(decoder2);
        }
      }
      result.ipProtectionChainId = decoder0.readInt(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    ProxyServer[] proxyServerArr = this.proxyServers;
    if (proxyServerArr == null) {
      encoder0.encodeNullPointer(8, true);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(proxyServerArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ProxyServer[] proxyServerArr2 = this.proxyServers;
        if (i0 >= proxyServerArr2.length) {
          break;
        }
        encoder1.encode((Struct) proxyServerArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.ipProtectionChainId, 16);
  }
}
