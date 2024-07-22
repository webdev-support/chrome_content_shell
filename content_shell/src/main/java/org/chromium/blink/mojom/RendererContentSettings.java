package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class RendererContentSettings extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowImage;
  public boolean allowMixedContent;
  public boolean allowPopup;
  public boolean allowScript;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RendererContentSettings(int version) {
    super(16, version);
  }

  public RendererContentSettings() {
    this(0);
  }

  public static RendererContentSettings deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RendererContentSettings deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RendererContentSettings decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RendererContentSettings result = new RendererContentSettings(elementsOrVersion);
      result.allowScript = decoder0.readBoolean(8, 0);
      result.allowImage = decoder0.readBoolean(8, 1);
      result.allowPopup = decoder0.readBoolean(8, 2);
      result.allowMixedContent = decoder0.readBoolean(8, 3);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.allowScript, 8, 0);
    encoder0.encode(this.allowImage, 8, 1);
    encoder0.encode(this.allowPopup, 8, 2);
    encoder0.encode(this.allowMixedContent, 8, 3);
  }
}
