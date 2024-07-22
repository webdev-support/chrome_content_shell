package org.chromium.media.mojom;

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
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean isSoftwareCodec;
  public int maxFramerateDenominator;
  public int maxFramerateNumerator;
  public Size maxResolution;
  public Size minResolution;
  public int profile;
  public int[] rateControlModes;
  public int[] scalabilityModes;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoEncodeAcceleratorSupportedProfile(int version) {
    super(56, version);
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
      result.isSoftwareCodec = decoder0.readBoolean(36, 0);
      result.rateControlModes = decoder0.readInts(40, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.rateControlModes;
        if (i1 >= iArr.length) {
          break;
        }
        VideoEncodeAcceleratorSupportedRateControlMode.validate(iArr[i1]);
        i1++;
      }
      result.scalabilityModes = decoder0.readInts(48, 0, -1);
      int i12 = 0;
      while (true) {
        int[] iArr2 = result.scalabilityModes;
        if (i12 < iArr2.length) {
          SvcScalabilityMode.validate(iArr2[i12]);
          i12++;
        } else {
          return result;
        }
      }
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
    encoder0.encode(this.isSoftwareCodec, 36, 0);
    encoder0.encode(this.rateControlModes, 40, 0, -1);
    encoder0.encode(this.scalabilityModes, 48, 0, -1);
  }
}
