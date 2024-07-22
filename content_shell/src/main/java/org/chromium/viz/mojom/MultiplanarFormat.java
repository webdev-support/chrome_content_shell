package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class MultiplanarFormat extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int channelFormat;
  public int planeConfig;
  public int subsampling;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private MultiplanarFormat(int version) {
    super(24, version);
  }

  public MultiplanarFormat() {
    this(0);
  }

  public static MultiplanarFormat deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MultiplanarFormat deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MultiplanarFormat decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MultiplanarFormat result = new MultiplanarFormat(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.planeConfig = readInt;
      PlaneConfig.validate(readInt);
      result.planeConfig = PlaneConfig.toKnownValue(result.planeConfig);
      int readInt2 = decoder0.readInt(12);
      result.subsampling = readInt2;
      Subsampling.validate(readInt2);
      result.subsampling = Subsampling.toKnownValue(result.subsampling);
      int readInt3 = decoder0.readInt(16);
      result.channelFormat = readInt3;
      ChannelFormat.validate(readInt3);
      result.channelFormat = ChannelFormat.toKnownValue(result.channelFormat);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.planeConfig, 8);
    encoder0.encode(this.subsampling, 12);
    encoder0.encode(this.channelFormat, 16);
  }
}