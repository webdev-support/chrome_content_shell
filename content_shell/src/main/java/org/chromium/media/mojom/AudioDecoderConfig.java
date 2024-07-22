package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class AudioDecoderConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] aacExtraData;
  public int channelLayout;
  public int codec;
  public int codecDelay;
  public int encryptionScheme;
  public byte[] extraData;
  public int profile;
  public int sampleFormat;
  public int samplesPerSecond;
  public TimeDelta seekPreroll;
  public boolean shouldDiscardDecoderDelay;
  public int targetOutputChannelLayout;
  public int targetOutputSampleFormat;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AudioDecoderConfig(int version) {
    super(72, version);
  }

  public AudioDecoderConfig() {
    this(0);
  }

  public static AudioDecoderConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AudioDecoderConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AudioDecoderConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AudioDecoderConfig result = new AudioDecoderConfig(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.codec = readInt;
      AudioCodec.validate(readInt);
      result.codec = AudioCodec.toKnownValue(result.codec);
      int readInt2 = decoder0.readInt(12);
      result.sampleFormat = readInt2;
      SampleFormat.validate(readInt2);
      result.sampleFormat = SampleFormat.toKnownValue(result.sampleFormat);
      int readInt3 = decoder0.readInt(16);
      result.channelLayout = readInt3;
      ChannelLayout.validate(readInt3);
      result.channelLayout = ChannelLayout.toKnownValue(result.channelLayout);
      result.samplesPerSecond = decoder0.readInt(20);
      result.extraData = decoder0.readBytes(24, 0, -1);
      int readInt4 = decoder0.readInt(32);
      result.encryptionScheme = readInt4;
      EncryptionScheme.validate(readInt4);
      result.encryptionScheme = EncryptionScheme.toKnownValue(result.encryptionScheme);
      result.codecDelay = decoder0.readInt(36);
      Decoder decoder1 = decoder0.readPointer(40, false);
      result.seekPreroll = TimeDelta.decode(decoder1);
      int readInt5 = decoder0.readInt(48);
      result.profile = readInt5;
      AudioCodecProfile.validate(readInt5);
      result.profile = AudioCodecProfile.toKnownValue(result.profile);
      int readInt6 = decoder0.readInt(52);
      result.targetOutputChannelLayout = readInt6;
      ChannelLayout.validate(readInt6);
      result.targetOutputChannelLayout =
          ChannelLayout.toKnownValue(result.targetOutputChannelLayout);
      int readInt7 = decoder0.readInt(56);
      result.targetOutputSampleFormat = readInt7;
      SampleFormat.validate(readInt7);
      result.targetOutputSampleFormat = SampleFormat.toKnownValue(result.targetOutputSampleFormat);
      result.shouldDiscardDecoderDelay = decoder0.readBoolean(60, 0);
      result.aacExtraData = decoder0.readBytes(64, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.codec, 8);
    encoder0.encode(this.sampleFormat, 12);
    encoder0.encode(this.channelLayout, 16);
    encoder0.encode(this.samplesPerSecond, 20);
    encoder0.encode(this.extraData, 24, 0, -1);
    encoder0.encode(this.encryptionScheme, 32);
    encoder0.encode(this.codecDelay, 36);
    encoder0.encode((Struct) this.seekPreroll, 40, false);
    encoder0.encode(this.profile, 48);
    encoder0.encode(this.targetOutputChannelLayout, 52);
    encoder0.encode(this.targetOutputSampleFormat, 56);
    encoder0.encode(this.shouldDiscardDecoderDelay, 60, 0);
    encoder0.encode(this.aacExtraData, 64, 0, -1);
  }
}
