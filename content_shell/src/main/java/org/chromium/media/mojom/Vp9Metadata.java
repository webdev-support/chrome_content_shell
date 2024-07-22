package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class Vp9Metadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public byte beginActiveSpatialLayerIndex;
  public byte endActiveSpatialLayerIndex;
  public boolean interPicPredicted;
  public byte[] pDiffs;
  public boolean referenceLowerSpatialLayers;
  public boolean referencedByUpperSpatialLayers;
  public byte spatialIdx;
  public Size[] spatialLayerResolutions;
  public byte temporalIdx;
  public boolean temporalUpSwitch;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Vp9Metadata(int version) {
    super(32, version);
  }

  public Vp9Metadata() {
    this(0);
  }

  public static Vp9Metadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Vp9Metadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Vp9Metadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Vp9Metadata result = new Vp9Metadata(elementsOrVersion);
      result.interPicPredicted = decoder0.readBoolean(8, 0);
      result.temporalUpSwitch = decoder0.readBoolean(8, 1);
      result.referencedByUpperSpatialLayers = decoder0.readBoolean(8, 2);
      result.referenceLowerSpatialLayers = decoder0.readBoolean(8, 3);
      result.temporalIdx = decoder0.readByte(9);
      result.spatialIdx = decoder0.readByte(10);
      result.beginActiveSpatialLayerIndex = decoder0.readByte(11);
      result.endActiveSpatialLayerIndex = decoder0.readByte(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.spatialLayerResolutions = new Size[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.spatialLayerResolutions[i1] = Size.decode(decoder2);
      }
      result.pDiffs = decoder0.readBytes(24, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.interPicPredicted, 8, 0);
    encoder0.encode(this.temporalUpSwitch, 8, 1);
    encoder0.encode(this.referencedByUpperSpatialLayers, 8, 2);
    encoder0.encode(this.referenceLowerSpatialLayers, 8, 3);
    encoder0.encode(this.temporalIdx, 9);
    encoder0.encode(this.spatialIdx, 10);
    encoder0.encode(this.beginActiveSpatialLayerIndex, 11);
    encoder0.encode(this.endActiveSpatialLayerIndex, 12);
    Size[] sizeArr = this.spatialLayerResolutions;
    if (sizeArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(sizeArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        Size[] sizeArr2 = this.spatialLayerResolutions;
        if (i0 >= sizeArr2.length) {
          break;
        }
        encoder1.encode((Struct) sizeArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.pDiffs, 24, 0, -1);
  }
}
