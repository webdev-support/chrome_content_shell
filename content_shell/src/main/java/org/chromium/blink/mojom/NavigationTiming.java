package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class NavigationTiming extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public TimeTicks fetchStart;
  public int parentResourceTimingAccess;
  public TimeTicks redirectEnd;
  public TimeTicks redirectStart;
  public int systemEntropyAtNavigationStart;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NavigationTiming(int version) {
    super(40, version);
    this.systemEntropyAtNavigationStart = 0;
    this.parentResourceTimingAccess = 0;
  }

  public NavigationTiming() {
    this(0);
  }

  public static NavigationTiming deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NavigationTiming deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NavigationTiming decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NavigationTiming result = new NavigationTiming(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.redirectStart = TimeTicks.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.redirectEnd = TimeTicks.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.fetchStart = TimeTicks.decode(decoder13);
      int readInt = decoder0.readInt(32);
      result.systemEntropyAtNavigationStart = readInt;
      SystemEntropy.validate(readInt);
      result.systemEntropyAtNavigationStart =
          SystemEntropy.toKnownValue(result.systemEntropyAtNavigationStart);
      int readInt2 = decoder0.readInt(36);
      result.parentResourceTimingAccess = readInt2;
      ParentResourceTimingAccess.validate(readInt2);
      result.parentResourceTimingAccess =
          ParentResourceTimingAccess.toKnownValue(result.parentResourceTimingAccess);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.redirectStart, 8, false);
    encoder0.encode((Struct) this.redirectEnd, 16, false);
    encoder0.encode((Struct) this.fetchStart, 24, false);
    encoder0.encode(this.systemEntropyAtNavigationStart, 32);
    encoder0.encode(this.parentResourceTimingAccess, 36);
  }
}
