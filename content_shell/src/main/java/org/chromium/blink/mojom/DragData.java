package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.network.mojom.ReferrerPolicy;

public final class DragData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String fileSystemId;
  public boolean forceDefaultAction;
  public DragItem[] items;
  public int referrerPolicy;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DragData(int version) {
    super(32, version);
    this.referrerPolicy = 1;
  }

  public DragData() {
    this(0);
  }

  public static DragData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DragData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DragData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DragData result = new DragData(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.items = new DragItem[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.items[i1] = DragItem.decode(decoder1, (i1 * 16) + 8);
      }
      result.fileSystemId = decoder0.readString(16, true);
      result.forceDefaultAction = decoder0.readBoolean(24, 0);
      int readInt = decoder0.readInt(28);
      result.referrerPolicy = readInt;
      ReferrerPolicy.validate(readInt);
      result.referrerPolicy = ReferrerPolicy.toKnownValue(result.referrerPolicy);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    DragItem[] dragItemArr = this.items;
    if (dragItemArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodeUnionArray(dragItemArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        DragItem[] dragItemArr2 = this.items;
        if (i0 >= dragItemArr2.length) {
          break;
        }
        encoder1.encode((Union) dragItemArr2[i0], (i0 * 16) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.fileSystemId, 16, true);
    encoder0.encode(this.forceDefaultAction, 24, 0);
    encoder0.encode(this.referrerPolicy, 28);
  }
}
