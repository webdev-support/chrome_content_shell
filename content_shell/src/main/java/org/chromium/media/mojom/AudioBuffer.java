package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class AudioBuffer extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int channelCount;
  public int channelLayout;
  public byte[] data;
  public boolean endOfStream;
  public int frameCount;
  public int sampleFormat;
  public int sampleRate;
  public TimeDelta timestamp;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AudioBuffer(int version) {
    super(48, version);
  }

  public AudioBuffer() {
    this(0);
  }

  public static AudioBuffer deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AudioBuffer deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AudioBuffer decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AudioBuffer result = new AudioBuffer(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.sampleFormat = readInt;
      SampleFormat.validate(readInt);
      result.sampleFormat = SampleFormat.toKnownValue(result.sampleFormat);
      int readInt2 = decoder0.readInt(12);
      result.channelLayout = readInt2;
      ChannelLayout.validate(readInt2);
      result.channelLayout = ChannelLayout.toKnownValue(result.channelLayout);
      result.channelCount = decoder0.readInt(16);
      result.sampleRate = decoder0.readInt(20);
      result.frameCount = decoder0.readInt(24);
      result.endOfStream = decoder0.readBoolean(28, 0);
      Decoder decoder1 = decoder0.readPointer(32, false);
      result.timestamp = TimeDelta.decode(decoder1);
      result.data = decoder0.readBytes(40, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.sampleFormat, 8);
    encoder0.encode(this.channelLayout, 12);
    encoder0.encode(this.channelCount, 16);
    encoder0.encode(this.sampleRate, 20);
    encoder0.encode(this.frameCount, 24);
    encoder0.encode(this.endOfStream, 28, 0);
    encoder0.encode((Struct) this.timestamp, 32, false);
    encoder0.encode(this.data, 40, 0, -1);
  }
}
