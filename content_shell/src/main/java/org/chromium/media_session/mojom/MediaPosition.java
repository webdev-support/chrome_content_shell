package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class MediaPosition extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public TimeDelta duration;
  public boolean endOfMedia;
  public TimeTicks lastUpdatedTime;
  public double playbackRate;
  public TimeDelta position;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0), new DataHeader(48, 13)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[1];
  }

  private MediaPosition(int version) {
    super(48, version);
  }

  public MediaPosition() {
    this(13);
  }

  public static MediaPosition deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MediaPosition deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MediaPosition decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MediaPosition result = new MediaPosition(elementsOrVersion);
      result.playbackRate = decoder0.readDouble(8);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.duration = TimeDelta.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.position = TimeDelta.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.lastUpdatedTime = TimeTicks.decode(decoder13);
      if (elementsOrVersion >= 13) {
        result.endOfMedia = decoder0.readBoolean(40, 0);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.playbackRate, 8);
    encoder0.encode((Struct) this.duration, 16, false);
    encoder0.encode((Struct) this.position, 24, false);
    encoder0.encode((Struct) this.lastUpdatedTime, 32, false);
    encoder0.encode(this.endOfMedia, 40, 0);
  }
}
