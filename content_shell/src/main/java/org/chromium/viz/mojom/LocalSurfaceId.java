package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class LocalSurfaceId extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int childSequenceNumber;
  public UnguessableToken embedToken;
  public int parentSequenceNumber;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private LocalSurfaceId(int version) {
    super(24, version);
  }

  public LocalSurfaceId() {
    this(0);
  }

  public static LocalSurfaceId deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static LocalSurfaceId deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static LocalSurfaceId decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      LocalSurfaceId result = new LocalSurfaceId(elementsOrVersion);
      result.parentSequenceNumber = decoder0.readInt(8);
      result.childSequenceNumber = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.embedToken = UnguessableToken.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.parentSequenceNumber, 8);
    encoder0.encode(this.childSequenceNumber, 12);
    encoder0.encode((Struct) this.embedToken, 16, false);
  }
}
