package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ManifestUserPreferenceOverrides extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int backgroundColor;
  public boolean hasBackgroundColor;
  public boolean hasThemeColor;
  public int themeColor;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ManifestUserPreferenceOverrides(int version) {
    super(24, version);
  }

  public ManifestUserPreferenceOverrides() {
    this(0);
  }

  public static ManifestUserPreferenceOverrides deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ManifestUserPreferenceOverrides deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ManifestUserPreferenceOverrides decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ManifestUserPreferenceOverrides result =
          new ManifestUserPreferenceOverrides(elementsOrVersion);
      result.hasThemeColor = decoder0.readBoolean(8, 0);
      result.hasBackgroundColor = decoder0.readBoolean(8, 1);
      result.themeColor = decoder0.readInt(12);
      result.backgroundColor = decoder0.readInt(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.hasThemeColor, 8, 0);
    encoder0.encode(this.hasBackgroundColor, 8, 1);
    encoder0.encode(this.themeColor, 12);
    encoder0.encode(this.backgroundColor, 16);
  }
}
