package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DnsOverHttpsServerConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public IpAddress[][] endpoints;
  public String serverTemplate;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DnsOverHttpsServerConfig(int version) {
    super(24, version);
  }

  public DnsOverHttpsServerConfig() {
    this(0);
  }

  public static DnsOverHttpsServerConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DnsOverHttpsServerConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DnsOverHttpsServerConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DnsOverHttpsServerConfig result = new DnsOverHttpsServerConfig(elementsOrVersion);
      result.serverTemplate = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.endpoints = new IpAddress[si1.elementsOrVersion][];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
        result.endpoints[i1] = new IpAddress[si2.elementsOrVersion];
        for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
          Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
          result.endpoints[i1][i2] = IpAddress.decode(decoder3);
        }
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.serverTemplate, 8, false);
    IpAddress[][] ipAddressArr = this.endpoints;
    if (ipAddressArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(ipAddressArr.length, 16, -1);
    int i0 = 0;
    while (true) {
      IpAddress[][] ipAddressArr2 = this.endpoints;
      if (i0 < ipAddressArr2.length) {
        IpAddress[] ipAddressArr3 = ipAddressArr2[i0];
        if (ipAddressArr3 == null) {
          encoder1.encodeNullPointer((i0 * 8) + 8, false);
        } else {
          Encoder encoder2 = encoder1.encodePointerArray(ipAddressArr3.length, (i0 * 8) + 8, -1);
          int i1 = 0;
          while (true) {
            IpAddress[] ipAddressArr4 = this.endpoints[i0];
            if (i1 < ipAddressArr4.length) {
              encoder2.encode((Struct) ipAddressArr4[i1], (i1 * 8) + 8, false);
              i1++;
            }
          }
        }
        i0++;
      } else {
        return;
      }
    }
  }
}
