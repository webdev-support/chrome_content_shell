package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AudioDataS16 extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int channelCount;
  public short[] data;
  public int frameCount;
  public int sampleRate;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AudioDataS16(int version) {
    super(32, version);
  }

  public AudioDataS16() {
    this(0);
  }

  public static AudioDataS16 deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AudioDataS16 deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AudioDataS16 decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AudioDataS16 result = new AudioDataS16(elementsOrVersion);
      result.channelCount = decoder0.readInt(8);
      result.sampleRate = decoder0.readInt(12);
      result.frameCount = decoder0.readInt(16);
      result.data = decoder0.readShorts(24, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.channelCount, 8);
    encoder0.encode(this.sampleRate, 12);
    encoder0.encode(this.frameCount, 16);
    encoder0.encode(this.data, 24, 0, -1);
  }
}
