package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VulkanYCbCrInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public long externalFormat;
  public int formatFeatures;
  public int imageFormat;
  public int suggestedXchromaOffset;
  public int suggestedYcbcrModel;
  public int suggestedYcbcrRange;
  public int suggestedYchromaOffset;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VulkanYCbCrInfo(int version) {
    super(40, version);
  }

  public VulkanYCbCrInfo() {
    this(0);
  }

  public static VulkanYCbCrInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VulkanYCbCrInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VulkanYCbCrInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VulkanYCbCrInfo result = new VulkanYCbCrInfo(elementsOrVersion);
      result.imageFormat = decoder0.readInt(8);
      result.suggestedYcbcrModel = decoder0.readInt(12);
      result.externalFormat = decoder0.readLong(16);
      result.suggestedYcbcrRange = decoder0.readInt(24);
      result.suggestedXchromaOffset = decoder0.readInt(28);
      result.suggestedYchromaOffset = decoder0.readInt(32);
      result.formatFeatures = decoder0.readInt(36);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.imageFormat, 8);
    encoder0.encode(this.suggestedYcbcrModel, 12);
    encoder0.encode(this.externalFormat, 16);
    encoder0.encode(this.suggestedYcbcrRange, 24);
    encoder0.encode(this.suggestedXchromaOffset, 28);
    encoder0.encode(this.suggestedYchromaOffset, 32);
    encoder0.encode(this.formatFeatures, 36);
  }
}
