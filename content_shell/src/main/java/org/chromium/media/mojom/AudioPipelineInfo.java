package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AudioPipelineInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int decoderType;
  public int encryptionType;
  public boolean hasDecryptingDemuxerStream;
  public boolean isPlatformDecoder;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AudioPipelineInfo(int version) {
    super(24, version);
    this.isPlatformDecoder = false;
    this.hasDecryptingDemuxerStream = false;
  }

  public AudioPipelineInfo() {
    this(0);
  }

  public static AudioPipelineInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AudioPipelineInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AudioPipelineInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AudioPipelineInfo result = new AudioPipelineInfo(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.decoderType = readInt;
      AudioDecoderType.validate(readInt);
      result.decoderType = AudioDecoderType.toKnownValue(result.decoderType);
      result.isPlatformDecoder = decoder0.readBoolean(12, 0);
      result.hasDecryptingDemuxerStream = decoder0.readBoolean(12, 1);
      int readInt2 = decoder0.readInt(16);
      result.encryptionType = readInt2;
      EncryptionType.validate(readInt2);
      result.encryptionType = EncryptionType.toKnownValue(result.encryptionType);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.decoderType, 8);
    encoder0.encode(this.isPlatformDecoder, 12, 0);
    encoder0.encode(this.hasDecryptingDemuxerStream, 12, 1);
    encoder0.encode(this.encryptionType, 16);
  }
}
