package org.chromium.media.stable.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DecoderBufferSideData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] alphaData;
  public long secureHandle;
  public int[] spatialLayers;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DecoderBufferSideData(int version) {
    super(32, version);
  }

  public DecoderBufferSideData() {
    this(0);
  }

  public static DecoderBufferSideData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DecoderBufferSideData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DecoderBufferSideData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DecoderBufferSideData result = new DecoderBufferSideData(elementsOrVersion);
      result.spatialLayers = decoder0.readInts(8, 0, -1);
      result.alphaData = decoder0.readBytes(16, 0, -1);
      result.secureHandle = decoder0.readLong(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.spatialLayers, 8, 0, -1);
    encoder0.encode(this.alphaData, 16, 0, -1);
    encoder0.encode(this.secureHandle, 24);
  }
}
