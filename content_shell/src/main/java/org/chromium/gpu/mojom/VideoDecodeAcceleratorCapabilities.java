package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoDecodeAcceleratorCapabilities extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int flags;
  public VideoDecodeAcceleratorSupportedProfile[] supportedProfiles;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoDecodeAcceleratorCapabilities(int version) {
    super(24, version);
  }

  public VideoDecodeAcceleratorCapabilities() {
    this(0);
  }

  public static VideoDecodeAcceleratorCapabilities deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoDecodeAcceleratorCapabilities deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoDecodeAcceleratorCapabilities decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoDecodeAcceleratorCapabilities result =
          new VideoDecodeAcceleratorCapabilities(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.supportedProfiles = new VideoDecodeAcceleratorSupportedProfile[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.supportedProfiles[i1] = VideoDecodeAcceleratorSupportedProfile.decode(decoder2);
      }
      result.flags = decoder0.readInt(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    VideoDecodeAcceleratorSupportedProfile[] videoDecodeAcceleratorSupportedProfileArr =
        this.supportedProfiles;
    if (videoDecodeAcceleratorSupportedProfileArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 =
          encoder0.encodePointerArray(videoDecodeAcceleratorSupportedProfileArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        VideoDecodeAcceleratorSupportedProfile[] videoDecodeAcceleratorSupportedProfileArr2 =
            this.supportedProfiles;
        if (i0 >= videoDecodeAcceleratorSupportedProfileArr2.length) {
          break;
        }
        encoder1.encode(
            (Struct) videoDecodeAcceleratorSupportedProfileArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.flags, 16);
  }
}
