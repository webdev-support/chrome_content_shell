package org.chromium.display.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.DisplayColorSpaces;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class Display extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 104;
  private static final DataHeader[] VERSION_ARRAY;
  public int accelerometerSupport;
  public Rect bounds;
  public int colorDepth;
  public DisplayColorSpaces colorSpaces;
  public int depthPerComponent;
  public float deviceScaleFactor;
  public float displayFrequency;

  public long f608id;
  public boolean isMonochrome;
  public String label;
  public Size maximumCursorSize;
  public Point nativeOrigin;
  public int rotation;
  public Size sizeInPixels;
  public int touchSupport;
  public Rect workArea;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(104, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Display(int version) {
    super(104, version);
  }

  public Display() {
    this(0);
  }

  public static Display deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Display deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Display decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Display result = new Display(elementsOrVersion);
      result.f608id = decoder0.readLong(8);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.bounds = Rect.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.sizeInPixels = Size.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.nativeOrigin = Point.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.workArea = Rect.decode(decoder14);
      result.deviceScaleFactor = decoder0.readFloat(48);
      int readInt = decoder0.readInt(52);
      result.rotation = readInt;
      Rotation.validate(readInt);
      result.rotation = Rotation.toKnownValue(result.rotation);
      int readInt2 = decoder0.readInt(56);
      result.touchSupport = readInt2;
      TouchSupport.validate(readInt2);
      result.touchSupport = TouchSupport.toKnownValue(result.touchSupport);
      int readInt3 = decoder0.readInt(60);
      result.accelerometerSupport = readInt3;
      AccelerometerSupport.validate(readInt3);
      result.accelerometerSupport = AccelerometerSupport.toKnownValue(result.accelerometerSupport);
      Decoder decoder15 = decoder0.readPointer(64, false);
      result.maximumCursorSize = Size.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(72, false);
      result.colorSpaces = DisplayColorSpaces.decode(decoder16);
      result.colorDepth = decoder0.readInt(80);
      result.depthPerComponent = decoder0.readInt(84);
      result.isMonochrome = decoder0.readBoolean(88, 0);
      result.displayFrequency = decoder0.readFloat(92);
      result.label = decoder0.readString(96, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f608id, 8);
    encoder0.encode((Struct) this.bounds, 16, false);
    encoder0.encode((Struct) this.sizeInPixels, 24, false);
    encoder0.encode((Struct) this.nativeOrigin, 32, false);
    encoder0.encode((Struct) this.workArea, 40, false);
    encoder0.encode(this.deviceScaleFactor, 48);
    encoder0.encode(this.rotation, 52);
    encoder0.encode(this.touchSupport, 56);
    encoder0.encode(this.accelerometerSupport, 60);
    encoder0.encode((Struct) this.maximumCursorSize, 64, false);
    encoder0.encode((Struct) this.colorSpaces, 72, false);
    encoder0.encode(this.colorDepth, 80);
    encoder0.encode(this.depthPerComponent, 84);
    encoder0.encode(this.isMonochrome, 88, 0);
    encoder0.encode(this.displayFrequency, 92);
    encoder0.encode(this.label, 96, false);
  }
}
