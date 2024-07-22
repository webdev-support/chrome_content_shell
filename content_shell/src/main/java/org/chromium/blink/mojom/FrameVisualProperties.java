package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.display.mojom.ScreenInfos;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.viz.mojom.LocalSurfaceId;

public final class FrameVisualProperties extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 112;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean autoResizeEnabled;
  public int captureSequenceNumber;
  public float compositingScaleFactor;
  public Rect compositorViewport;
  public float cursorAccessibilityScaleFactor;
  public boolean isPinchGestureActive;
  public Size localFrameSize;
  public LocalSurfaceId localSurfaceId;
  public Size maxSizeForAutoResize;
  public Size minSizeForAutoResize;
  public float pageScaleFactor;
  public Rect rectInLocalRoot;
  public Rect[] rootWidgetWindowSegments;
  public ScreenInfos screenInfos;
  public Size visibleViewportSize;
  public double zoomLevel;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(112, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FrameVisualProperties(int version) {
    super(112, version);
    this.pageScaleFactor = 1.0f;
    this.compositingScaleFactor = 1.0f;
    this.cursorAccessibilityScaleFactor = 1.0f;
  }

  public FrameVisualProperties() {
    this(0);
  }

  public static FrameVisualProperties deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FrameVisualProperties deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FrameVisualProperties decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FrameVisualProperties result = new FrameVisualProperties(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.screenInfos = ScreenInfos.decode(decoder1);
      result.autoResizeEnabled = decoder0.readBoolean(16, 0);
      result.isPinchGestureActive = decoder0.readBoolean(16, 1);
      result.captureSequenceNumber = decoder0.readInt(20);
      result.zoomLevel = decoder0.readDouble(24);
      result.pageScaleFactor = decoder0.readFloat(32);
      result.compositingScaleFactor = decoder0.readFloat(36);
      result.cursorAccessibilityScaleFactor = decoder0.readFloat(40);
      Decoder decoder12 = decoder0.readPointer(48, false);
      result.visibleViewportSize = Size.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(56, false);
      result.minSizeForAutoResize = Size.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(64, false);
      result.maxSizeForAutoResize = Size.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(72, false);
      DataHeader si1 = decoder15.readDataHeaderForPointerArray(-1);
      result.rootWidgetWindowSegments = new Rect[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder15.readPointer((i1 * 8) + 8, false);
        result.rootWidgetWindowSegments[i1] = Rect.decode(decoder2);
      }
      Decoder decoder16 = decoder0.readPointer(80, false);
      result.compositorViewport = Rect.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(88, false);
      result.rectInLocalRoot = Rect.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(96, false);
      result.localFrameSize = Size.decode(decoder18);
      Decoder decoder19 = decoder0.readPointer(104, false);
      result.localSurfaceId = LocalSurfaceId.decode(decoder19);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.screenInfos, 8, false);
    encoder0.encode(this.autoResizeEnabled, 16, 0);
    encoder0.encode(this.isPinchGestureActive, 16, 1);
    encoder0.encode(this.captureSequenceNumber, 20);
    encoder0.encode(this.zoomLevel, 24);
    encoder0.encode(this.pageScaleFactor, 32);
    encoder0.encode(this.compositingScaleFactor, 36);
    encoder0.encode(this.cursorAccessibilityScaleFactor, 40);
    encoder0.encode((Struct) this.visibleViewportSize, 48, false);
    encoder0.encode((Struct) this.minSizeForAutoResize, 56, false);
    encoder0.encode((Struct) this.maxSizeForAutoResize, 64, false);
    Rect[] rectArr = this.rootWidgetWindowSegments;
    if (rectArr == null) {
      encoder0.encodeNullPointer(72, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(rectArr.length, 72, -1);
      int i0 = 0;
      while (true) {
        Rect[] rectArr2 = this.rootWidgetWindowSegments;
        if (i0 >= rectArr2.length) {
          break;
        }
        encoder1.encode((Struct) rectArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.compositorViewport, 80, false);
    encoder0.encode((Struct) this.rectInLocalRoot, 88, false);
    encoder0.encode((Struct) this.localFrameSize, 96, false);
    encoder0.encode((Struct) this.localSurfaceId, 104, false);
  }
}
