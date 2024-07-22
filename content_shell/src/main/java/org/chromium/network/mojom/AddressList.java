package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AddressList extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public IpEndPoint[] addresses;
  public String[] dnsAliases;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AddressList(int version) {
    super(24, version);
  }

  public AddressList() {
    this(0);
  }

  public static AddressList deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AddressList deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AddressList decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AddressList result = new AddressList(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.addresses = new IpEndPoint[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.addresses[i1] = IpEndPoint.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.dnsAliases = new String[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.dnsAliases[i12] = decoder12.readString((i12 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    IpEndPoint[] ipEndPointArr = this.addresses;
    if (ipEndPointArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(ipEndPointArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        IpEndPoint[] ipEndPointArr2 = this.addresses;
        if (i0 >= ipEndPointArr2.length) {
          break;
        }
        encoder1.encode((Struct) ipEndPointArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    String[] strArr = this.dnsAliases;
    if (strArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(strArr.length, 16, -1);
    int i02 = 0;
    while (true) {
      String[] strArr2 = this.dnsAliases;
      if (i02 < strArr2.length) {
        encoder12.encode(strArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
