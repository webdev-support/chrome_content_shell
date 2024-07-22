package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.gfx.mojom.RectF;
import org.chromium.gfx.mojom.SizeF;
import org.chromium.gfx.mojom.Transform;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.viz.mojom.ViewTransitionElementResourceId;

public final class ViewTransitionElement extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public SizeF borderBoxSizeInCssSpace;
  public Map<Integer, String> capturedCssProperties;
  public RectF capturedRectInLayoutSpace;
  public String[] classList;
  public RectF overflowRectInLayoutSpace;
  public int paintOrder;
  public ViewTransitionElementResourceId snapshotId;
  public String tagName;
  public Transform viewportMatrix;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ViewTransitionElement(int version) {
    super(80, version);
  }

  public ViewTransitionElement() {
    this(0);
  }

  public static ViewTransitionElement deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ViewTransitionElement deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ViewTransitionElement decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ViewTransitionElement result = new ViewTransitionElement(elementsOrVersion);
      result.tagName = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.borderBoxSizeInCssSpace = SizeF.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.viewportMatrix = Transform.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.overflowRectInLayoutSpace = RectF.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, true);
      result.capturedRectInLayoutSpace = RectF.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.snapshotId = ViewTransitionElementResourceId.decode(decoder15);
      result.paintOrder = decoder0.readInt(56);
      Decoder decoder16 = decoder0.readPointer(64, false);
      decoder16.readDataHeaderForMap();
      int[] keys0 = decoder16.readInts(8, 0, -1);
      for (int i : keys0) {
        ViewTransitionPropertyId.validate(i);
      }
      Decoder decoder2 = decoder16.readPointer(16, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
      String[] values0 = new String[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        values0[i2] = decoder2.readString((i2 * 8) + 8, false);
      }
      result.capturedCssProperties = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.capturedCssProperties.put(Integer.valueOf(keys0[index0]), values0[index0]);
      }
      Decoder decoder17 = decoder0.readPointer(72, false);
      DataHeader si1 = decoder17.readDataHeaderForPointerArray(-1);
      result.classList = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.classList[i1] = decoder17.readString((i1 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.tagName, 8, false);
    encoder0.encode((Struct) this.borderBoxSizeInCssSpace, 16, false);
    encoder0.encode((Struct) this.viewportMatrix, 24, false);
    encoder0.encode((Struct) this.overflowRectInLayoutSpace, 32, false);
    encoder0.encode((Struct) this.capturedRectInLayoutSpace, 40, true);
    encoder0.encode((Struct) this.snapshotId, 48, false);
    encoder0.encode(this.paintOrder, 56);
    if (this.capturedCssProperties == null) {
      encoder0.encodeNullPointer(64, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(64);
      int size0 = this.capturedCssProperties.size();
      int[] keys0 = new int[size0];
      String[] values0 = new String[size0];
      int index0 = 0;
      for (Map.Entry<Integer, String> entry0 : this.capturedCssProperties.entrySet()) {
        keys0[index0] = entry0.getKey().intValue();
        values0[index0] = entry0.getValue();
        index0++;
      }
      encoder1.encode(keys0, 8, 0, -1);
      Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i1 = 0; i1 < values0.length; i1++) {
        encoder2.encode(values0[i1], (i1 * 8) + 8, false);
      }
    }
    String[] strArr = this.classList;
    if (strArr == null) {
      encoder0.encodeNullPointer(72, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(strArr.length, 72, -1);
    int i0 = 0;
    while (true) {
      String[] strArr2 = this.classList;
      if (i0 < strArr2.length) {
        encoder12.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
