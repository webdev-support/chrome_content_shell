package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VkLayerProperties extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String description;
  public int implementationVersion;
  public String layerName;
  public int specVersion;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VkLayerProperties(int version) {
    super(32, version);
  }

  public VkLayerProperties() {
    this(0);
  }

  public static VkLayerProperties deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VkLayerProperties deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VkLayerProperties decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VkLayerProperties result = new VkLayerProperties(elementsOrVersion);
      result.layerName = decoder0.readString(8, false);
      result.specVersion = decoder0.readInt(16);
      result.implementationVersion = decoder0.readInt(20);
      result.description = decoder0.readString(24, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.layerName, 8, false);
    encoder0.encode(this.specVersion, 16);
    encoder0.encode(this.implementationVersion, 20);
    encoder0.encode(this.description, 24, false);
  }
}
