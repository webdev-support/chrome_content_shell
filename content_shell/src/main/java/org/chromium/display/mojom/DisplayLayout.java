package org.chromium.display.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DisplayLayout extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean defaultUnified;
  public DisplayPlacement[] placementList;
  public long primaryDisplayId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DisplayLayout(int version) {
    super(32, version);
  }

  public DisplayLayout() {
    this(0);
  }

  public static DisplayLayout deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DisplayLayout deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DisplayLayout decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DisplayLayout result = new DisplayLayout(elementsOrVersion);
      result.defaultUnified = decoder0.readBoolean(8, 0);
      result.primaryDisplayId = decoder0.readLong(16);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.placementList = new DisplayPlacement[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.placementList[i1] = DisplayPlacement.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.defaultUnified, 8, 0);
    encoder0.encode(this.primaryDisplayId, 16);
    DisplayPlacement[] displayPlacementArr = this.placementList;
    if (displayPlacementArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(displayPlacementArr.length, 24, -1);
    int i0 = 0;
    while (true) {
      DisplayPlacement[] displayPlacementArr2 = this.placementList;
      if (i0 < displayPlacementArr2.length) {
        encoder1.encode((Struct) displayPlacementArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
