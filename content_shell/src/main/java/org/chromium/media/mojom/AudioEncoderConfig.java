package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AudioEncoderConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public AacAudioEncoderConfig aac;
  public int bitrate;
  public byte channelCount;
  public int codec;
  public int sampleRate;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AudioEncoderConfig(int version) {
    super(32, version);
  }

  public AudioEncoderConfig() {
    this(0);
  }

  public static AudioEncoderConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AudioEncoderConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AudioEncoderConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AudioEncoderConfig result = new AudioEncoderConfig(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.codec = readInt;
      AudioCodec.validate(readInt);
      result.codec = AudioCodec.toKnownValue(result.codec);
      result.channelCount = decoder0.readByte(12);
      result.sampleRate = decoder0.readInt(16);
      result.bitrate = decoder0.readInt(20);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.aac = AacAudioEncoderConfig.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.codec, 8);
    encoder0.encode(this.channelCount, 12);
    encoder0.encode(this.sampleRate, 16);
    encoder0.encode(this.bitrate, 20);
    encoder0.encode((Struct) this.aac, 24, false);
  }
}
