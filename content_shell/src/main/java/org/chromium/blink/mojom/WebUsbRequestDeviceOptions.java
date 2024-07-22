package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.UsbDeviceFilter;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class WebUsbRequestDeviceOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public UsbDeviceFilter[] exclusionFilters;
  public UsbDeviceFilter[] filters;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WebUsbRequestDeviceOptions(int version) {
    super(24, version);
  }

  public WebUsbRequestDeviceOptions() {
    this(0);
  }

  public static WebUsbRequestDeviceOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WebUsbRequestDeviceOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WebUsbRequestDeviceOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WebUsbRequestDeviceOptions result = new WebUsbRequestDeviceOptions(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.filters = new UsbDeviceFilter[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.filters[i1] = UsbDeviceFilter.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.exclusionFilters = new UsbDeviceFilter[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.exclusionFilters[i12] = UsbDeviceFilter.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    UsbDeviceFilter[] usbDeviceFilterArr = this.filters;
    if (usbDeviceFilterArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(usbDeviceFilterArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        UsbDeviceFilter[] usbDeviceFilterArr2 = this.filters;
        if (i0 >= usbDeviceFilterArr2.length) {
          break;
        }
        encoder1.encode((Struct) usbDeviceFilterArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    UsbDeviceFilter[] usbDeviceFilterArr3 = this.exclusionFilters;
    if (usbDeviceFilterArr3 == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(usbDeviceFilterArr3.length, 16, -1);
    int i02 = 0;
    while (true) {
      UsbDeviceFilter[] usbDeviceFilterArr4 = this.exclusionFilters;
      if (i02 < usbDeviceFilterArr4.length) {
        encoder12.encode((Struct) usbDeviceFilterArr4[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
