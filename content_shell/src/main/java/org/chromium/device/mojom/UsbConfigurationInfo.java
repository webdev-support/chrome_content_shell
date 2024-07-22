package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class UsbConfigurationInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public String16 configurationName;
  public byte configurationValue;
  public byte[] extraData;
  public UsbInterfaceInfo[] interfaces;
  public byte maximumPower;
  public boolean remoteWakeup;
  public boolean selfPowered;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UsbConfigurationInfo(int version) {
    super(40, version);
  }

  public UsbConfigurationInfo() {
    this(0);
  }

  public static UsbConfigurationInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UsbConfigurationInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UsbConfigurationInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UsbConfigurationInfo result = new UsbConfigurationInfo(elementsOrVersion);
      result.configurationValue = decoder0.readByte(8);
      result.selfPowered = decoder0.readBoolean(9, 0);
      result.remoteWakeup = decoder0.readBoolean(9, 1);
      result.maximumPower = decoder0.readByte(10);
      result.configurationName = String16.decode(decoder0.readPointer(16, true));
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.interfaces = new UsbInterfaceInfo[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.interfaces[i1] = UsbInterfaceInfo.decode(decoder2);
      }
      result.extraData = decoder0.readBytes(32, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.configurationValue, 8);
    encoder0.encode(this.selfPowered, 9, 0);
    encoder0.encode(this.remoteWakeup, 9, 1);
    encoder0.encode(this.maximumPower, 10);
    encoder0.encode((Struct) this.configurationName, 16, true);
    UsbInterfaceInfo[] usbInterfaceInfoArr = this.interfaces;
    if (usbInterfaceInfoArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(usbInterfaceInfoArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        UsbInterfaceInfo[] usbInterfaceInfoArr2 = this.interfaces;
        if (i0 >= usbInterfaceInfoArr2.length) {
          break;
        }
        encoder1.encode((Struct) usbInterfaceInfoArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.extraData, 32, 0, -1);
  }
}
