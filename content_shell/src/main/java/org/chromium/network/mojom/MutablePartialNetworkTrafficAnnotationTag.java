package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class MutablePartialNetworkTrafficAnnotationTag extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public int completingIdHashCode;
  public int uniqueIdHashCode;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private MutablePartialNetworkTrafficAnnotationTag(int version) {
    super(16, version);
  }

  public MutablePartialNetworkTrafficAnnotationTag() {
    this(0);
  }

  public static MutablePartialNetworkTrafficAnnotationTag deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MutablePartialNetworkTrafficAnnotationTag deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MutablePartialNetworkTrafficAnnotationTag decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MutablePartialNetworkTrafficAnnotationTag result =
          new MutablePartialNetworkTrafficAnnotationTag(elementsOrVersion);
      result.uniqueIdHashCode = decoder0.readInt(8);
      result.completingIdHashCode = decoder0.readInt(12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.uniqueIdHashCode, 8);
    encoder0.encode(this.completingIdHashCode, 12);
  }
}
