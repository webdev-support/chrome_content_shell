package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class HidReportItem extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public int designatorMaximum;
  public int designatorMinimum;
  public boolean hasNullPosition;
  public boolean isBufferedBytes;
  public boolean isConstant;
  public boolean isNonLinear;
  public boolean isRange;
  public boolean isRelative;
  public boolean isVariable;
  public boolean isVolatile;
  public int logicalMaximum;
  public int logicalMinimum;
  public boolean noPreferredState;
  public int physicalMaximum;
  public int physicalMinimum;
  public int reportCount;
  public int reportSize;
  public int stringMaximum;
  public int stringMinimum;
  public int unit;
  public int unitExponent;
  public HidUsageAndPage usageMaximum;
  public HidUsageAndPage usageMinimum;
  public HidUsageAndPage[] usages;
  public boolean wrap;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(88, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private HidReportItem(int version) {
    super(88, version);
  }

  public HidReportItem() {
    this(0);
  }

  public static HidReportItem deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static HidReportItem deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static HidReportItem decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      HidReportItem result = new HidReportItem(elementsOrVersion);
      result.isRange = decoder0.readBoolean(8, 0);
      result.isConstant = decoder0.readBoolean(8, 1);
      result.isVariable = decoder0.readBoolean(8, 2);
      result.isRelative = decoder0.readBoolean(8, 3);
      result.wrap = decoder0.readBoolean(8, 4);
      result.isNonLinear = decoder0.readBoolean(8, 5);
      result.noPreferredState = decoder0.readBoolean(8, 6);
      result.hasNullPosition = decoder0.readBoolean(8, 7);
      result.isVolatile = decoder0.readBoolean(9, 0);
      result.isBufferedBytes = decoder0.readBoolean(9, 1);
      result.designatorMinimum = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.usages = new HidUsageAndPage[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.usages[i1] = HidUsageAndPage.decode(decoder2);
      }
      result.usageMinimum = HidUsageAndPage.decode(decoder0.readPointer(24, false));
      result.usageMaximum = HidUsageAndPage.decode(decoder0.readPointer(32, false));
      result.designatorMaximum = decoder0.readInt(40);
      result.stringMinimum = decoder0.readInt(44);
      result.stringMaximum = decoder0.readInt(48);
      result.logicalMinimum = decoder0.readInt(52);
      result.logicalMaximum = decoder0.readInt(56);
      result.physicalMinimum = decoder0.readInt(60);
      result.physicalMaximum = decoder0.readInt(64);
      result.unitExponent = decoder0.readInt(68);
      result.unit = decoder0.readInt(72);
      result.reportSize = decoder0.readInt(76);
      result.reportCount = decoder0.readInt(80);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.isRange, 8, 0);
    encoder0.encode(this.isConstant, 8, 1);
    encoder0.encode(this.isVariable, 8, 2);
    encoder0.encode(this.isRelative, 8, 3);
    encoder0.encode(this.wrap, 8, 4);
    encoder0.encode(this.isNonLinear, 8, 5);
    encoder0.encode(this.noPreferredState, 8, 6);
    encoder0.encode(this.hasNullPosition, 8, 7);
    encoder0.encode(this.isVolatile, 9, 0);
    encoder0.encode(this.isBufferedBytes, 9, 1);
    encoder0.encode(this.designatorMinimum, 12);
    HidUsageAndPage[] hidUsageAndPageArr = this.usages;
    if (hidUsageAndPageArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(hidUsageAndPageArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        HidUsageAndPage[] hidUsageAndPageArr2 = this.usages;
        if (i0 >= hidUsageAndPageArr2.length) {
          break;
        }
        encoder1.encode((Struct) hidUsageAndPageArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.usageMinimum, 24, false);
    encoder0.encode((Struct) this.usageMaximum, 32, false);
    encoder0.encode(this.designatorMaximum, 40);
    encoder0.encode(this.stringMinimum, 44);
    encoder0.encode(this.stringMaximum, 48);
    encoder0.encode(this.logicalMinimum, 52);
    encoder0.encode(this.logicalMaximum, 56);
    encoder0.encode(this.physicalMinimum, 60);
    encoder0.encode(this.physicalMaximum, 64);
    encoder0.encode(this.unitExponent, 68);
    encoder0.encode(this.unit, 72);
    encoder0.encode(this.reportSize, 76);
    encoder0.encode(this.reportCount, 80);
  }
}
