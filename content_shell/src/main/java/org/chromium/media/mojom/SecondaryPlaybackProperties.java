package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SecondaryPlaybackProperties extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int audioCodec;
  public int audioCodecProfile;
  public int audioDecoder;
  public int audioEncryptionScheme;
  public Size naturalSize;
  public int videoCodec;
  public int videoCodecProfile;
  public int videoDecoder;
  public int videoEncryptionScheme;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SecondaryPlaybackProperties(int version) {
    super(48, version);
  }

  public SecondaryPlaybackProperties() {
    this(0);
  }

  public static SecondaryPlaybackProperties deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SecondaryPlaybackProperties deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SecondaryPlaybackProperties decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SecondaryPlaybackProperties result = new SecondaryPlaybackProperties(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.audioCodec = readInt;
      AudioCodec.validate(readInt);
      result.audioCodec = AudioCodec.toKnownValue(result.audioCodec);
      int readInt2 = decoder0.readInt(12);
      result.videoCodec = readInt2;
      VideoCodec.validate(readInt2);
      result.videoCodec = VideoCodec.toKnownValue(result.videoCodec);
      int readInt3 = decoder0.readInt(16);
      result.audioCodecProfile = readInt3;
      AudioCodecProfile.validate(readInt3);
      result.audioCodecProfile = AudioCodecProfile.toKnownValue(result.audioCodecProfile);
      int readInt4 = decoder0.readInt(20);
      result.videoCodecProfile = readInt4;
      VideoCodecProfile.validate(readInt4);
      result.videoCodecProfile = VideoCodecProfile.toKnownValue(result.videoCodecProfile);
      int readInt5 = decoder0.readInt(24);
      result.audioDecoder = readInt5;
      AudioDecoderType.validate(readInt5);
      result.audioDecoder = AudioDecoderType.toKnownValue(result.audioDecoder);
      int readInt6 = decoder0.readInt(28);
      result.videoDecoder = readInt6;
      VideoDecoderType.validate(readInt6);
      result.videoDecoder = VideoDecoderType.toKnownValue(result.videoDecoder);
      int readInt7 = decoder0.readInt(32);
      result.audioEncryptionScheme = readInt7;
      EncryptionScheme.validate(readInt7);
      result.audioEncryptionScheme = EncryptionScheme.toKnownValue(result.audioEncryptionScheme);
      int readInt8 = decoder0.readInt(36);
      result.videoEncryptionScheme = readInt8;
      EncryptionScheme.validate(readInt8);
      result.videoEncryptionScheme = EncryptionScheme.toKnownValue(result.videoEncryptionScheme);
      Decoder decoder1 = decoder0.readPointer(40, false);
      result.naturalSize = Size.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.audioCodec, 8);
    encoder0.encode(this.videoCodec, 12);
    encoder0.encode(this.audioCodecProfile, 16);
    encoder0.encode(this.videoCodecProfile, 20);
    encoder0.encode(this.audioDecoder, 24);
    encoder0.encode(this.videoDecoder, 28);
    encoder0.encode(this.audioEncryptionScheme, 32);
    encoder0.encode(this.videoEncryptionScheme, 36);
    encoder0.encode((Struct) this.naturalSize, 40, false);
  }
}
