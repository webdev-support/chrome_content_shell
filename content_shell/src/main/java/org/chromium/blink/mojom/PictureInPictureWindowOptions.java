package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PictureInPictureWindowOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public long height;
  public double initialAspectRatio;
  public boolean lockAspectRatio;
  public long width;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PictureInPictureWindowOptions(int version) {
    super(40, version);
  }

  public PictureInPictureWindowOptions() {
    this(0);
  }

  public static PictureInPictureWindowOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PictureInPictureWindowOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PictureInPictureWindowOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PictureInPictureWindowOptions result = new PictureInPictureWindowOptions(elementsOrVersion);
      result.width = decoder0.readLong(8);
      result.height = decoder0.readLong(16);
      result.initialAspectRatio = decoder0.readDouble(24);
      result.lockAspectRatio = decoder0.readBoolean(32, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.width, 8);
    encoder0.encode(this.height, 16);
    encoder0.encode(this.initialAspectRatio, 24);
    encoder0.encode(this.lockAspectRatio, 32, 0);
  }
}
