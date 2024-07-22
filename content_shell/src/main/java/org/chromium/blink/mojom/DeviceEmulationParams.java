package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.display.mojom.ScreenOrientation;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DeviceEmulationParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public int devicePosture;
  public float deviceScaleFactor;
  public float scale;
  public int screenOrientationAngle;
  public int screenOrientationType;
  public Size screenSize;
  public int screenType;
  public Point viewPosition;
  public Size viewSize;
  public PointF viewportOffset;
  public float viewportScale;
  public Rect[] windowSegments;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DeviceEmulationParams(int version) {
    super(80, version);
  }

  public DeviceEmulationParams() {
    this(0);
  }

  public static DeviceEmulationParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DeviceEmulationParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DeviceEmulationParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DeviceEmulationParams result = new DeviceEmulationParams(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.screenType = readInt;
      EmulatedScreenType.validate(readInt);
      result.screenType = EmulatedScreenType.toKnownValue(result.screenType);
      result.deviceScaleFactor = decoder0.readFloat(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.screenSize = Size.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.viewPosition = Point.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.viewSize = Size.decode(decoder13);
      result.scale = decoder0.readFloat(40);
      result.viewportScale = decoder0.readFloat(44);
      Decoder decoder14 = decoder0.readPointer(48, false);
      result.viewportOffset = PointF.decode(decoder14);
      int readInt2 = decoder0.readInt(56);
      result.screenOrientationType = readInt2;
      ScreenOrientation.validate(readInt2);
      result.screenOrientationType = ScreenOrientation.toKnownValue(result.screenOrientationType);
      result.screenOrientationAngle = decoder0.readInt(60);
      Decoder decoder15 = decoder0.readPointer(64, false);
      DataHeader si1 = decoder15.readDataHeaderForPointerArray(-1);
      result.windowSegments = new Rect[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder15.readPointer((i1 * 8) + 8, false);
        result.windowSegments[i1] = Rect.decode(decoder2);
      }
      int readInt3 = decoder0.readInt(72);
      result.devicePosture = readInt3;
      DevicePostureType.validate(readInt3);
      result.devicePosture = DevicePostureType.toKnownValue(result.devicePosture);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.screenType, 8);
    encoder0.encode(this.deviceScaleFactor, 12);
    encoder0.encode((Struct) this.screenSize, 16, false);
    encoder0.encode((Struct) this.viewPosition, 24, true);
    encoder0.encode((Struct) this.viewSize, 32, false);
    encoder0.encode(this.scale, 40);
    encoder0.encode(this.viewportScale, 44);
    encoder0.encode((Struct) this.viewportOffset, 48, false);
    encoder0.encode(this.screenOrientationType, 56);
    encoder0.encode(this.screenOrientationAngle, 60);
    Rect[] rectArr = this.windowSegments;
    if (rectArr == null) {
      encoder0.encodeNullPointer(64, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(rectArr.length, 64, -1);
      int i0 = 0;
      while (true) {
        Rect[] rectArr2 = this.windowSegments;
        if (i0 >= rectArr2.length) {
          break;
        }
        encoder1.encode((Struct) rectArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.devicePosture, 72);
  }
}
