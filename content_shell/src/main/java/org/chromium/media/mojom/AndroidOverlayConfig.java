package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class AndroidOverlayConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean powerEfficient;
  public Rect rect;
  public UnguessableToken routingToken;
  public boolean secure;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AndroidOverlayConfig(int version) {
    super(32, version);
  }

  public AndroidOverlayConfig() {
    this(0);
  }

  public static AndroidOverlayConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AndroidOverlayConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AndroidOverlayConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AndroidOverlayConfig result = new AndroidOverlayConfig(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.routingToken = UnguessableToken.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.rect = Rect.decode(decoder12);
      result.secure = decoder0.readBoolean(24, 0);
      result.powerEfficient = decoder0.readBoolean(24, 1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.routingToken, 8, false);
    encoder0.encode((Struct) this.rect, 16, false);
    encoder0.encode(this.secure, 24, 0);
    encoder0.encode(this.powerEfficient, 24, 1);
  }
}
