package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.url.mojom.Url;

public final class AnchorElementClick extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int anchorId;
  public TimeDelta navigationStartToClick;
  public Url targetUrl;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AnchorElementClick(int version) {
    super(32, version);
  }

  public AnchorElementClick() {
    this(0);
  }

  public static AnchorElementClick deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AnchorElementClick deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AnchorElementClick decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AnchorElementClick result = new AnchorElementClick(elementsOrVersion);
      result.anchorId = decoder0.readInt(8);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.targetUrl = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.navigationStartToClick = TimeDelta.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.anchorId, 8);
    encoder0.encode((Struct) this.targetUrl, 16, false);
    encoder0.encode((Struct) this.navigationStartToClick, 24, false);
  }
}
