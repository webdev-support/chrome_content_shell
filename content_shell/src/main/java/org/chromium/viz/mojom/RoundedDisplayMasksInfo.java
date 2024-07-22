package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class RoundedDisplayMasksInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean isHorizontallyPositioned;
  public byte[] radii;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RoundedDisplayMasksInfo(int version) {
    super(24, version);
  }

  public RoundedDisplayMasksInfo() {
    this(0);
  }

  public static RoundedDisplayMasksInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RoundedDisplayMasksInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RoundedDisplayMasksInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RoundedDisplayMasksInfo result = new RoundedDisplayMasksInfo(elementsOrVersion);
      result.isHorizontallyPositioned = decoder0.readBoolean(8, 0);
      result.radii = decoder0.readBytes(16, 0, 2);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.isHorizontallyPositioned, 8, 0);
    encoder0.encode(this.radii, 16, 0, 2);
  }
}
