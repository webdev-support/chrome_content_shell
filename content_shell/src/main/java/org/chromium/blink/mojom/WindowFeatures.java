package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class WindowFeatures extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public Rect bounds;
  public boolean hasHeight;
  public boolean hasWidth;
  public boolean hasX;
  public boolean hasY;
  public boolean isFullscreen;
  public boolean isPopup;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WindowFeatures(int version) {
    super(24, version);
    this.hasX = false;
    this.hasY = false;
    this.hasWidth = false;
    this.hasHeight = false;
    this.isPopup = false;
    this.isFullscreen = false;
  }

  public WindowFeatures() {
    this(0);
  }

  public static WindowFeatures deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WindowFeatures deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WindowFeatures decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WindowFeatures result = new WindowFeatures(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.bounds = Rect.decode(decoder1);
      result.hasX = decoder0.readBoolean(16, 0);
      result.hasY = decoder0.readBoolean(16, 1);
      result.hasWidth = decoder0.readBoolean(16, 2);
      result.hasHeight = decoder0.readBoolean(16, 3);
      result.isPopup = decoder0.readBoolean(16, 4);
      result.isFullscreen = decoder0.readBoolean(16, 5);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.bounds, 8, false);
    encoder0.encode(this.hasX, 16, 0);
    encoder0.encode(this.hasY, 16, 1);
    encoder0.encode(this.hasWidth, 16, 2);
    encoder0.encode(this.hasHeight, 16, 3);
    encoder0.encode(this.isPopup, 16, 4);
    encoder0.encode(this.isFullscreen, 16, 5);
  }
}
