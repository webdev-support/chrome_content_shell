package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.HdrMetadata;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoDecoderConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public int codec;
  public Size codedSize;
  public VideoColorSpace colorSpaceInfo;
  public int encryptionScheme;
  public byte[] extraData;
  public boolean hasAlpha;
  public HdrMetadata hdrMetadata;
  public int level;
  public Size naturalSize;
  public int profile;
  public VideoTransformation transformation;
  public Rect visibleRect;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(88, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoDecoderConfig(int version) {
    super(88, version);
  }

  public VideoDecoderConfig() {
    this(0);
  }

  public static VideoDecoderConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoDecoderConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoDecoderConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoDecoderConfig result = new VideoDecoderConfig(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.codec = readInt;
      VideoCodec.validate(readInt);
      result.codec = VideoCodec.toKnownValue(result.codec);
      int readInt2 = decoder0.readInt(12);
      result.profile = readInt2;
      VideoCodecProfile.validate(readInt2);
      result.profile = VideoCodecProfile.toKnownValue(result.profile);
      result.level = decoder0.readInt(16);
      result.hasAlpha = decoder0.readBoolean(20, 0);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.transformation = VideoTransformation.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(32, false);
      result.codedSize = Size.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(40, false);
      result.visibleRect = Rect.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(48, false);
      result.naturalSize = Size.decode(decoder14);
      result.extraData = decoder0.readBytes(56, 0, -1);
      int readInt3 = decoder0.readInt(64);
      result.encryptionScheme = readInt3;
      EncryptionScheme.validate(readInt3);
      result.encryptionScheme = EncryptionScheme.toKnownValue(result.encryptionScheme);
      Decoder decoder15 = decoder0.readPointer(72, false);
      result.colorSpaceInfo = VideoColorSpace.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(80, true);
      result.hdrMetadata = HdrMetadata.decode(decoder16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.codec, 8);
    encoder0.encode(this.profile, 12);
    encoder0.encode(this.level, 16);
    encoder0.encode(this.hasAlpha, 20, 0);
    encoder0.encode((Struct) this.transformation, 24, false);
    encoder0.encode((Struct) this.codedSize, 32, false);
    encoder0.encode((Struct) this.visibleRect, 40, false);
    encoder0.encode((Struct) this.naturalSize, 48, false);
    encoder0.encode(this.extraData, 56, 0, -1);
    encoder0.encode(this.encryptionScheme, 64);
    encoder0.encode((Struct) this.colorSpaceInfo, 72, false);
    encoder0.encode((Struct) this.hdrMetadata, 80, true);
  }
}
