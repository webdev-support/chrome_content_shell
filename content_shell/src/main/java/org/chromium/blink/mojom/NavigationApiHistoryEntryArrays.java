package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class NavigationApiHistoryEntryArrays extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public NavigationApiHistoryEntry[] backEntries;
  public NavigationApiHistoryEntry[] forwardEntries;
  public NavigationApiHistoryEntry previousEntry;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NavigationApiHistoryEntryArrays(int version) {
    super(32, version);
  }

  public NavigationApiHistoryEntryArrays() {
    this(0);
  }

  public static NavigationApiHistoryEntryArrays deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NavigationApiHistoryEntryArrays deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NavigationApiHistoryEntryArrays decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NavigationApiHistoryEntryArrays result =
          new NavigationApiHistoryEntryArrays(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.backEntries = new NavigationApiHistoryEntry[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.backEntries[i1] = NavigationApiHistoryEntry.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.forwardEntries = new NavigationApiHistoryEntry[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.forwardEntries[i12] = NavigationApiHistoryEntry.decode(decoder22);
      }
      result.previousEntry = NavigationApiHistoryEntry.decode(decoder0.readPointer(24, true));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    NavigationApiHistoryEntry[] navigationApiHistoryEntryArr = this.backEntries;
    if (navigationApiHistoryEntryArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(navigationApiHistoryEntryArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        NavigationApiHistoryEntry[] navigationApiHistoryEntryArr2 = this.backEntries;
        if (i0 >= navigationApiHistoryEntryArr2.length) {
          break;
        }
        encoder1.encode((Struct) navigationApiHistoryEntryArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    NavigationApiHistoryEntry[] navigationApiHistoryEntryArr3 = this.forwardEntries;
    if (navigationApiHistoryEntryArr3 == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(navigationApiHistoryEntryArr3.length, 16, -1);
      int i02 = 0;
      while (true) {
        NavigationApiHistoryEntry[] navigationApiHistoryEntryArr4 = this.forwardEntries;
        if (i02 >= navigationApiHistoryEntryArr4.length) {
          break;
        }
        encoder12.encode((Struct) navigationApiHistoryEntryArr4[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode((Struct) this.previousEntry, 24, true);
  }
}
