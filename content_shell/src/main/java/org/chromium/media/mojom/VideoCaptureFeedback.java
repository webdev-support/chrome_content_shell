package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoCaptureFeedback extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public Size[] deprecatedMappedSizes;
  public int frameId;
  public boolean hasFrameId;
  public float maxFramerateFps;
  public int maxPixels;
  public boolean requireMappedFrame;
  public double resourceUtilization;

  static {
    DataHeader[] dataHeaderArr = {
      new DataHeader(32, 0), new DataHeader(40, 1), new DataHeader(40, 2)
    };
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[2];
  }

  private VideoCaptureFeedback(int version) {
    super(40, version);
    this.frameId = 0;
    this.hasFrameId = false;
  }

  public VideoCaptureFeedback() {
    this(2);
  }

  public static VideoCaptureFeedback deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoCaptureFeedback deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoCaptureFeedback decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoCaptureFeedback result = new VideoCaptureFeedback(elementsOrVersion);
      result.resourceUtilization = decoder0.readDouble(8);
      result.maxFramerateFps = decoder0.readFloat(16);
      result.maxPixels = decoder0.readInt(20);
      result.requireMappedFrame = decoder0.readBoolean(24, 0);
      if (elementsOrVersion >= 2) {
        result.hasFrameId = decoder0.readBoolean(24, 1);
        result.frameId = decoder0.readInt(28);
      }
      if (elementsOrVersion >= 1) {
        Decoder decoder1 = decoder0.readPointer(32, true);
        if (decoder1 == null) {
          result.deprecatedMappedSizes = null;
        } else {
          DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
          result.deprecatedMappedSizes = new Size[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
            Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
            result.deprecatedMappedSizes[i1] = Size.decode(decoder2);
          }
        }
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.resourceUtilization, 8);
    encoder0.encode(this.maxFramerateFps, 16);
    encoder0.encode(this.maxPixels, 20);
    encoder0.encode(this.requireMappedFrame, 24, 0);
    encoder0.encode(this.hasFrameId, 24, 1);
    encoder0.encode(this.frameId, 28);
    Size[] sizeArr = this.deprecatedMappedSizes;
    if (sizeArr == null) {
      encoder0.encodeNullPointer(32, true);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(sizeArr.length, 32, -1);
    int i0 = 0;
    while (true) {
      Size[] sizeArr2 = this.deprecatedMappedSizes;
      if (i0 < sizeArr2.length) {
        encoder1.encode((Struct) sizeArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
