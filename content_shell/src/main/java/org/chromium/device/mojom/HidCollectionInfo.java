package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HidCollectionInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public HidCollectionInfo[] children;
  public int collectionType;
  public HidReportDescription[] featureReports;
  public HidReportDescription[] inputReports;
  public HidReportDescription[] outputReports;
  public byte[] reportIds;
  public HidUsageAndPage usage;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HidCollectionInfo(int version) {
    super(64, version);
  }

  public HidCollectionInfo() {
    this(0);
  }

  public static HidCollectionInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HidCollectionInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HidCollectionInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HidCollectionInfo result = new HidCollectionInfo(elementsOrVersion);
      result.usage = HidUsageAndPage.decode(decoder0.readPointer(8, false));
      result.reportIds = decoder0.readBytes(16, 0, -1);
      result.collectionType = decoder0.readInt(24);
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.inputReports = new HidReportDescription[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.inputReports[i1] = HidReportDescription.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(40, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.outputReports = new HidReportDescription[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.outputReports[i12] = HidReportDescription.decode(decoder22);
      }
      Decoder decoder13 = decoder0.readPointer(48, false);
      DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
      result.featureReports = new HidReportDescription[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        Decoder decoder23 = decoder13.readPointer((i13 * 8) + 8, false);
        result.featureReports[i13] = HidReportDescription.decode(decoder23);
      }
      Decoder decoder14 = decoder0.readPointer(56, false);
      DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
      result.children = new HidCollectionInfo[si14.elementsOrVersion];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        Decoder decoder24 = decoder14.readPointer((i14 * 8) + 8, false);
        result.children[i14] = decode(decoder24);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.usage, 8, false);
    encoder0.encode(this.reportIds, 16, 0, -1);
    encoder0.encode(this.collectionType, 24);
    HidReportDescription[] hidReportDescriptionArr = this.inputReports;
    if (hidReportDescriptionArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(hidReportDescriptionArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        HidReportDescription[] hidReportDescriptionArr2 = this.inputReports;
        if (i0 >= hidReportDescriptionArr2.length) {
          break;
        }
        encoder1.encode((Struct) hidReportDescriptionArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    HidReportDescription[] hidReportDescriptionArr3 = this.outputReports;
    if (hidReportDescriptionArr3 == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(hidReportDescriptionArr3.length, 40, -1);
      int i02 = 0;
      while (true) {
        HidReportDescription[] hidReportDescriptionArr4 = this.outputReports;
        if (i02 >= hidReportDescriptionArr4.length) {
          break;
        }
        encoder12.encode((Struct) hidReportDescriptionArr4[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    HidReportDescription[] hidReportDescriptionArr5 = this.featureReports;
    if (hidReportDescriptionArr5 == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(hidReportDescriptionArr5.length, 48, -1);
      int i03 = 0;
      while (true) {
        HidReportDescription[] hidReportDescriptionArr6 = this.featureReports;
        if (i03 >= hidReportDescriptionArr6.length) {
          break;
        }
        encoder13.encode((Struct) hidReportDescriptionArr6[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    HidCollectionInfo[] hidCollectionInfoArr = this.children;
    if (hidCollectionInfoArr == null) {
      encoder0.encodeNullPointer(56, false);
      return;
    }
    Encoder encoder14 = encoder0.encodePointerArray(hidCollectionInfoArr.length, 56, -1);
    int i04 = 0;
    while (true) {
      HidCollectionInfo[] hidCollectionInfoArr2 = this.children;
      if (i04 < hidCollectionInfoArr2.length) {
        encoder14.encode((Struct) hidCollectionInfoArr2[i04], (i04 * 8) + 8, false);
        i04++;
      } else {
        return;
      }
    }
  }
}
