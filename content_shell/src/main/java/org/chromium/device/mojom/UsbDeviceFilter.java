package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class UsbDeviceFilter extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public byte classCode;
  public boolean hasClassCode;
  public boolean hasProductId;
  public boolean hasProtocolCode;
  public boolean hasSubclassCode;
  public boolean hasVendorId;
  public short productId;
  public byte protocolCode;
  public String16 serialNumber;
  public byte subclassCode;
  public short vendorId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UsbDeviceFilter(int version) {
    super(24, version);
  }

  public UsbDeviceFilter() {
    this(0);
  }

  public static UsbDeviceFilter deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UsbDeviceFilter deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UsbDeviceFilter decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UsbDeviceFilter result = new UsbDeviceFilter(elementsOrVersion);
      result.hasVendorId = decoder0.readBoolean(8, 0);
      result.hasProductId = decoder0.readBoolean(8, 1);
      result.hasClassCode = decoder0.readBoolean(8, 2);
      result.hasSubclassCode = decoder0.readBoolean(8, 3);
      result.hasProtocolCode = decoder0.readBoolean(8, 4);
      result.classCode = decoder0.readByte(9);
      result.vendorId = decoder0.readShort(10);
      result.productId = decoder0.readShort(12);
      result.subclassCode = decoder0.readByte(14);
      result.protocolCode = decoder0.readByte(15);
      Decoder decoder1 = decoder0.readPointer(16, true);
      result.serialNumber = String16.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.hasVendorId, 8, 0);
    encoder0.encode(this.hasProductId, 8, 1);
    encoder0.encode(this.hasClassCode, 8, 2);
    encoder0.encode(this.hasSubclassCode, 8, 3);
    encoder0.encode(this.hasProtocolCode, 8, 4);
    encoder0.encode(this.classCode, 9);
    encoder0.encode(this.vendorId, 10);
    encoder0.encode(this.productId, 12);
    encoder0.encode(this.subclassCode, 14);
    encoder0.encode(this.protocolCode, 15);
    encoder0.encode((Struct) this.serialNumber, 16, true);
  }
}
