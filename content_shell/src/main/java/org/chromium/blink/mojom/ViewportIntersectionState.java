package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.gfx.mojom.Transform;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ViewportIntersectionState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public Rect compositorVisibleRect;
  public Rect mainFrameIntersection;
  public Transform mainFrameTransform;
  public int occlusionState;
  public Point outermostMainFrameScrollPosition;
  public Size outermostMainFrameSize;
  public Rect viewportIntersection;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ViewportIntersectionState(int version) {
    super(64, version);
    this.occlusionState = 0;
  }

  public ViewportIntersectionState() {
    this(0);
  }

  public static ViewportIntersectionState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ViewportIntersectionState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ViewportIntersectionState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ViewportIntersectionState result = new ViewportIntersectionState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.viewportIntersection = Rect.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.mainFrameIntersection = Rect.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.compositorVisibleRect = Rect.decode(decoder13);
      int readInt = decoder0.readInt(32);
      result.occlusionState = readInt;
      FrameOcclusionState.validate(readInt);
      result.occlusionState = FrameOcclusionState.toKnownValue(result.occlusionState);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.outermostMainFrameSize = Size.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.outermostMainFrameScrollPosition = Point.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(56, false);
      result.mainFrameTransform = Transform.decode(decoder16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.viewportIntersection, 8, false);
    encoder0.encode((Struct) this.mainFrameIntersection, 16, false);
    encoder0.encode((Struct) this.compositorVisibleRect, 24, false);
    encoder0.encode(this.occlusionState, 32);
    encoder0.encode((Struct) this.outermostMainFrameSize, 40, false);
    encoder0.encode((Struct) this.outermostMainFrameScrollPosition, 48, false);
    encoder0.encode((Struct) this.mainFrameTransform, 56, false);
  }
}
