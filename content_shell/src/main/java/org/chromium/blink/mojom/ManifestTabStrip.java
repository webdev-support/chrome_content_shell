package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class ManifestTabStrip extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public HomeTabUnion homeTab;
  public NewTabButtonParams newTabButton;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ManifestTabStrip(int version) {
    super(32, version);
  }

  public ManifestTabStrip() {
    this(0);
  }

  public static ManifestTabStrip deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ManifestTabStrip deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ManifestTabStrip decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ManifestTabStrip result = new ManifestTabStrip(elementsOrVersion);
      result.homeTab = HomeTabUnion.decode(decoder0, 8);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.newTabButton = NewTabButtonParams.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.homeTab, 8, false);
    encoder0.encode((Struct) this.newTabButton, 24, false);
  }
}
