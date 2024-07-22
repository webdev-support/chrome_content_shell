package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VkPhysicalDeviceSparseProperties extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean residencyAlignedMipSize;
  public boolean residencyNonResidentStrict;
  public boolean residencyStandard2DBlockShape;
  public boolean residencyStandard2DMultisampleBlockShape;
  public boolean residencyStandard3DBlockShape;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VkPhysicalDeviceSparseProperties(int version) {
    super(16, version);
  }

  public VkPhysicalDeviceSparseProperties() {
    this(0);
  }

  public static VkPhysicalDeviceSparseProperties deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VkPhysicalDeviceSparseProperties deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VkPhysicalDeviceSparseProperties decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VkPhysicalDeviceSparseProperties result =
          new VkPhysicalDeviceSparseProperties(elementsOrVersion);
      result.residencyStandard2DBlockShape = decoder0.readBoolean(8, 0);
      result.residencyStandard2DMultisampleBlockShape = decoder0.readBoolean(8, 1);
      result.residencyStandard3DBlockShape = decoder0.readBoolean(8, 2);
      result.residencyAlignedMipSize = decoder0.readBoolean(8, 3);
      result.residencyNonResidentStrict = decoder0.readBoolean(8, 4);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.residencyStandard2DBlockShape, 8, 0);
    encoder0.encode(this.residencyStandard2DMultisampleBlockShape, 8, 1);
    encoder0.encode(this.residencyStandard3DBlockShape, 8, 2);
    encoder0.encode(this.residencyAlignedMipSize, 8, 3);
    encoder0.encode(this.residencyNonResidentStrict, 8, 4);
  }
}
