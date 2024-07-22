package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FrameOwnerProperties extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowFullscreen;
  public boolean allowPaymentRequest;
  public int colorScheme;
  public boolean isDisplayNone;
  public int marginHeight;
  public int marginWidth;
  public String name;
  public int scrollbarMode;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FrameOwnerProperties(int version) {
    super(40, version);
    this.colorScheme = 0;
  }

  public FrameOwnerProperties() {
    this(0);
  }

  public static FrameOwnerProperties deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FrameOwnerProperties deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FrameOwnerProperties decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FrameOwnerProperties result = new FrameOwnerProperties(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      int readInt = decoder0.readInt(16);
      result.scrollbarMode = readInt;
      ScrollbarMode.validate(readInt);
      result.scrollbarMode = ScrollbarMode.toKnownValue(result.scrollbarMode);
      result.marginWidth = decoder0.readInt(20);
      result.marginHeight = decoder0.readInt(24);
      result.allowFullscreen = decoder0.readBoolean(28, 0);
      result.allowPaymentRequest = decoder0.readBoolean(28, 1);
      result.isDisplayNone = decoder0.readBoolean(28, 2);
      int readInt2 = decoder0.readInt(32);
      result.colorScheme = readInt2;
      ColorScheme.validate(readInt2);
      result.colorScheme = ColorScheme.toKnownValue(result.colorScheme);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    encoder0.encode(this.scrollbarMode, 16);
    encoder0.encode(this.marginWidth, 20);
    encoder0.encode(this.marginHeight, 24);
    encoder0.encode(this.allowFullscreen, 28, 0);
    encoder0.encode(this.allowPaymentRequest, 28, 1);
    encoder0.encode(this.isDisplayNone, 28, 2);
    encoder0.encode(this.colorScheme, 32);
  }
}
