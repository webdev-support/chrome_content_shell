package org.chromium.display.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.DisplayColorSpaces;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ScreenInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public Rect availableRect;
  public int depth;
  public int depthPerComponent;
  public float deviceScaleFactor;
  public DisplayColorSpaces displayColorSpaces;
  public float displayFrequency;
  public long displayId;
  public boolean isExtended;
  public boolean isInternal;
  public boolean isMonochrome;
  public boolean isPrimary;
  public String label;
  public short orientationAngle;
  public int orientationType;
  public Rect rect;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ScreenInfo(int version) {
    super(72, version);
    this.deviceScaleFactor = 1.0f;
    this.isMonochrome = false;
    this.orientationType = 0;
    this.isPrimary = false;
    this.isInternal = false;
  }

  public ScreenInfo() {
    this(0);
  }

  public static ScreenInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ScreenInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ScreenInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ScreenInfo result = new ScreenInfo(elementsOrVersion);
      result.deviceScaleFactor = decoder0.readFloat(8);
      result.depth = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.displayColorSpaces = DisplayColorSpaces.decode(decoder1);
      result.depthPerComponent = decoder0.readInt(24);
      result.isMonochrome = decoder0.readBoolean(28, 0);
      result.isExtended = decoder0.readBoolean(28, 1);
      result.isPrimary = decoder0.readBoolean(28, 2);
      result.isInternal = decoder0.readBoolean(28, 3);
      result.orientationAngle = decoder0.readShort(30);
      result.displayFrequency = decoder0.readFloat(32);
      int readInt = decoder0.readInt(36);
      result.orientationType = readInt;
      ScreenOrientation.validate(readInt);
      result.orientationType = ScreenOrientation.toKnownValue(result.orientationType);
      Decoder decoder12 = decoder0.readPointer(40, false);
      result.rect = Rect.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(48, false);
      result.availableRect = Rect.decode(decoder13);
      result.label = decoder0.readString(56, false);
      result.displayId = decoder0.readLong(64);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.deviceScaleFactor, 8);
    encoder0.encode(this.depth, 12);
    encoder0.encode((Struct) this.displayColorSpaces, 16, false);
    encoder0.encode(this.depthPerComponent, 24);
    encoder0.encode(this.isMonochrome, 28, 0);
    encoder0.encode(this.isExtended, 28, 1);
    encoder0.encode(this.isPrimary, 28, 2);
    encoder0.encode(this.isInternal, 28, 3);
    encoder0.encode(this.orientationAngle, 30);
    encoder0.encode(this.displayFrequency, 32);
    encoder0.encode(this.orientationType, 36);
    encoder0.encode((Struct) this.rect, 40, false);
    encoder0.encode((Struct) this.availableRect, 48, false);
    encoder0.encode(this.label, 56, false);
    encoder0.encode(this.displayId, 64);
  }
}
