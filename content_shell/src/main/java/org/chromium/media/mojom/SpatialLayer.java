package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SpatialLayer extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int bitrateBps;
  public int framerate;
  public int height;
  public byte maxQp;
  public byte numOfTemporalLayers;
  public int width;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SpatialLayer(int version) {
    super(32, version);
  }

  public SpatialLayer() {
    this(0);
  }

  public static SpatialLayer deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SpatialLayer deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SpatialLayer decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SpatialLayer result = new SpatialLayer(elementsOrVersion);
      result.width = decoder0.readInt(8);
      result.height = decoder0.readInt(12);
      result.bitrateBps = decoder0.readInt(16);
      result.framerate = decoder0.readInt(20);
      result.maxQp = decoder0.readByte(24);
      result.numOfTemporalLayers = decoder0.readByte(25);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.width, 8);
    encoder0.encode(this.height, 12);
    encoder0.encode(this.bitrateBps, 16);
    encoder0.encode(this.framerate, 20);
    encoder0.encode(this.maxQp, 24);
    encoder0.encode(this.numOfTemporalLayers, 25);
  }
}
