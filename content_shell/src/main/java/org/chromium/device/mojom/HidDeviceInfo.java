package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HidDeviceInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 128;
  private static final DataHeader[] VERSION_ARRAY;
  public int busType;
  public HidCollectionInfo[] collections;
  public String deviceNode;
  public String guid;
  public boolean hasReportId;
  public boolean isExcludedByBlocklist;
  public long maxFeatureReportSize;
  public long maxInputReportSize;
  public long maxOutputReportSize;
  public String physicalDeviceId;
  public short productId;
  public String productName;
  public byte[] protectedFeatureReportIds;
  public byte[] protectedInputReportIds;
  public byte[] protectedOutputReportIds;
  public byte[] reportDescriptor;
  public String serialNumber;
  public short vendorId;

  static {
    DataHeader[] dataHeaderArr = {
      new DataHeader(104, 0), new DataHeader(128, 1), new DataHeader(128, 3)
    };
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[2];
  }

  private HidDeviceInfo(int version) {
    super(128, version);
  }

  public HidDeviceInfo() {
    this(3);
  }

  public static HidDeviceInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HidDeviceInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HidDeviceInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HidDeviceInfo result = new HidDeviceInfo(elementsOrVersion);
      result.guid = decoder0.readString(8, false);
      result.physicalDeviceId = decoder0.readString(16, false);
      result.vendorId = decoder0.readShort(24);
      result.productId = decoder0.readShort(26);
      int readInt = decoder0.readInt(28);
      result.busType = readInt;
      HidBusType.validate(readInt);
      result.busType = HidBusType.toKnownValue(result.busType);
      result.productName = decoder0.readString(32, false);
      result.serialNumber = decoder0.readString(40, false);
      result.reportDescriptor = decoder0.readBytes(48, 0, -1);
      Decoder decoder1 = decoder0.readPointer(56, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.collections = new HidCollectionInfo[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.collections[i1] = HidCollectionInfo.decode(decoder2);
      }
      result.hasReportId = decoder0.readBoolean(64, 0);
      if (elementsOrVersion >= 3) {
        result.isExcludedByBlocklist = decoder0.readBoolean(64, 1);
      }
      result.maxInputReportSize = decoder0.readLong(72);
      result.maxOutputReportSize = decoder0.readLong(80);
      result.maxFeatureReportSize = decoder0.readLong(88);
      result.deviceNode = decoder0.readString(96, false);
      if (elementsOrVersion >= 1) {
        result.protectedInputReportIds = decoder0.readBytes(104, 1, -1);
        result.protectedOutputReportIds = decoder0.readBytes(112, 1, -1);
        result.protectedFeatureReportIds = decoder0.readBytes(120, 1, -1);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.guid, 8, false);
    encoder0.encode(this.physicalDeviceId, 16, false);
    encoder0.encode(this.vendorId, 24);
    encoder0.encode(this.productId, 26);
    encoder0.encode(this.busType, 28);
    encoder0.encode(this.productName, 32, false);
    encoder0.encode(this.serialNumber, 40, false);
    encoder0.encode(this.reportDescriptor, 48, 0, -1);
    HidCollectionInfo[] hidCollectionInfoArr = this.collections;
    if (hidCollectionInfoArr == null) {
      encoder0.encodeNullPointer(56, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(hidCollectionInfoArr.length, 56, -1);
      int i0 = 0;
      while (true) {
        HidCollectionInfo[] hidCollectionInfoArr2 = this.collections;
        if (i0 >= hidCollectionInfoArr2.length) {
          break;
        }
        encoder1.encode((Struct) hidCollectionInfoArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.hasReportId, 64, 0);
    encoder0.encode(this.isExcludedByBlocklist, 64, 1);
    encoder0.encode(this.maxInputReportSize, 72);
    encoder0.encode(this.maxOutputReportSize, 80);
    encoder0.encode(this.maxFeatureReportSize, 88);
    encoder0.encode(this.deviceNode, 96, false);
    encoder0.encode(this.protectedInputReportIds, 104, 1, -1);
    encoder0.encode(this.protectedOutputReportIds, 112, 1, -1);
    encoder0.encode(this.protectedFeatureReportIds, 120, 1, -1);
  }
}
