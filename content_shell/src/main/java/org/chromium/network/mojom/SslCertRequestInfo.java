package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SslCertRequestInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public String[] certAuthorities;
  public HostPortPair hostAndPort;
  public boolean isProxy;
  public short[] signatureAlgorithms;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SslCertRequestInfo(int version) {
    super(40, version);
    this.isProxy = false;
  }

  public SslCertRequestInfo() {
    this(0);
  }

  public static SslCertRequestInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SslCertRequestInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SslCertRequestInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SslCertRequestInfo result = new SslCertRequestInfo(elementsOrVersion);
      result.hostAndPort = HostPortPair.decode(decoder0.readPointer(8, false));
      result.isProxy = decoder0.readBoolean(16, 0);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.certAuthorities = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.certAuthorities[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      result.signatureAlgorithms = decoder0.readShorts(32, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.hostAndPort, 8, false);
    encoder0.encode(this.isProxy, 16, 0);
    String[] strArr = this.certAuthorities;
    if (strArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.certAuthorities;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.signatureAlgorithms, 32, 0, -1);
  }
}
