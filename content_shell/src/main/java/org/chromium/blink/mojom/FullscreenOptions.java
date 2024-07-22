package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FullscreenOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public long displayId;
  public boolean isPrefixed;
  public boolean isXrOverlay;
  public boolean prefersNavigationBar;
  public boolean prefersStatusBar;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FullscreenOptions(int version) {
    super(24, version);
    this.prefersNavigationBar = false;
    this.prefersStatusBar = false;
    this.displayId = -1L;
    this.isPrefixed = false;
    this.isXrOverlay = false;
  }

  public FullscreenOptions() {
    this(0);
  }

  public static FullscreenOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FullscreenOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FullscreenOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FullscreenOptions result = new FullscreenOptions(elementsOrVersion);
      result.prefersNavigationBar = decoder0.readBoolean(8, 0);
      result.prefersStatusBar = decoder0.readBoolean(8, 1);
      result.isPrefixed = decoder0.readBoolean(8, 2);
      result.isXrOverlay = decoder0.readBoolean(8, 3);
      result.displayId = decoder0.readLong(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.prefersNavigationBar, 8, 0);
    encoder0.encode(this.prefersStatusBar, 8, 1);
    encoder0.encode(this.isPrefixed, 8, 2);
    encoder0.encode(this.isXrOverlay, 8, 3);
    encoder0.encode(this.displayId, 16);
  }
}
