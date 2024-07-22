package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SubAppsServiceListResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int resultCode;
  public SubAppsServiceListResultEntry[] subAppsList;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SubAppsServiceListResult(int version) {
    super(24, version);
  }

  public SubAppsServiceListResult() {
    this(0);
  }

  public static SubAppsServiceListResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SubAppsServiceListResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SubAppsServiceListResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SubAppsServiceListResult result = new SubAppsServiceListResult(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.resultCode = readInt;
      SubAppsServiceResultCode.validate(readInt);
      result.resultCode = SubAppsServiceResultCode.toKnownValue(result.resultCode);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.subAppsList = new SubAppsServiceListResultEntry[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.subAppsList[i1] = SubAppsServiceListResultEntry.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.resultCode, 8);
    SubAppsServiceListResultEntry[] subAppsServiceListResultEntryArr = this.subAppsList;
    if (subAppsServiceListResultEntryArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(subAppsServiceListResultEntryArr.length, 16, -1);
    int i0 = 0;
    while (true) {
      SubAppsServiceListResultEntry[] subAppsServiceListResultEntryArr2 = this.subAppsList;
      if (i0 < subAppsServiceListResultEntryArr2.length) {
        encoder1.encode((Struct) subAppsServiceListResultEntryArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
