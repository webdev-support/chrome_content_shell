package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoEncodeAcceleratorSupportedProfile extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int maxFramerateDenominator;
  public int maxFramerateNumerator;
  public Size maxResolution;
  public Size minResolution;
  public int profile;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoEncodeAcceleratorSupportedProfile(int version) {
    super(40, version);
  }

  public VideoEncodeAcceleratorSupportedProfile() {
    this(0);
  }

  public static VideoEncodeAcceleratorSupportedProfile deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoEncodeAcceleratorSupportedProfile deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoEncodeAcceleratorSupportedProfile decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoEncodeAcceleratorSupportedProfile result =
          new VideoEncodeAcceleratorSupportedProfile(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.profile = readInt;
      VideoCodecProfile.validate(readInt);
      result.profile = VideoCodecProfile.toKnownValue(result.profile);
      result.maxFramerateNumerator = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.minResolution = Size.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.maxResolution = Size.decode(decoder12);
      result.maxFramerateDenominator = decoder0.readInt(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.profile, 8);
    encoder0.encode(this.maxFramerateNumerator, 12);
    encoder0.encode((Struct) this.minResolution, 16, false);
    encoder0.encode((Struct) this.maxResolution, 24, false);
    encoder0.encode(this.maxFramerateDenominator, 32);
  }
}
