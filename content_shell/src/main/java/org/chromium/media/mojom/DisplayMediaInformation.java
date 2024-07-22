package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DisplayMediaInformation extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public CaptureHandle captureHandle;
  public int cursor;
  public int displaySurface;
  public int initialZoomLevel;
  public boolean logicalSurface;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DisplayMediaInformation(int version) {
    super(32, version);
  }

  public DisplayMediaInformation() {
    this(0);
  }

  public static DisplayMediaInformation deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DisplayMediaInformation deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DisplayMediaInformation decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DisplayMediaInformation result = new DisplayMediaInformation(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.displaySurface = readInt;
      DisplayCaptureSurfaceType.validate(readInt);
      result.displaySurface = DisplayCaptureSurfaceType.toKnownValue(result.displaySurface);
      result.logicalSurface = decoder0.readBoolean(12, 0);
      int readInt2 = decoder0.readInt(16);
      result.cursor = readInt2;
      CursorCaptureType.validate(readInt2);
      result.cursor = CursorCaptureType.toKnownValue(result.cursor);
      result.initialZoomLevel = decoder0.readInt(20);
      Decoder decoder1 = decoder0.readPointer(24, true);
      result.captureHandle = CaptureHandle.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.displaySurface, 8);
    encoder0.encode(this.logicalSurface, 12, 0);
    encoder0.encode(this.cursor, 16);
    encoder0.encode(this.initialZoomLevel, 20);
    encoder0.encode((Struct) this.captureHandle, 24, true);
  }
}
