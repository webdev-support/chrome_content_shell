package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class UsbInterfaceInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public UsbAlternateInterfaceInfo[] alternates;
  public byte firstInterface;
  public byte interfaceNumber;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UsbInterfaceInfo(int version) {
    super(24, version);
  }

  public UsbInterfaceInfo() {
    this(0);
  }

  public static UsbInterfaceInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UsbInterfaceInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UsbInterfaceInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UsbInterfaceInfo result = new UsbInterfaceInfo(elementsOrVersion);
      result.interfaceNumber = decoder0.readByte(8);
      result.firstInterface = decoder0.readByte(9);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.alternates = new UsbAlternateInterfaceInfo[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.alternates[i1] = UsbAlternateInterfaceInfo.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.interfaceNumber, 8);
    encoder0.encode(this.firstInterface, 9);
    UsbAlternateInterfaceInfo[] usbAlternateInterfaceInfoArr = this.alternates;
    if (usbAlternateInterfaceInfoArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(usbAlternateInterfaceInfoArr.length, 16, -1);
    int i0 = 0;
    while (true) {
      UsbAlternateInterfaceInfo[] usbAlternateInterfaceInfoArr2 = this.alternates;
      if (i0 < usbAlternateInterfaceInfoArr2.length) {
        encoder1.encode((Struct) usbAlternateInterfaceInfoArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}