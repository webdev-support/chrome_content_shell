package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DataElementChunkedDataPipe extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public ChunkedDataPipeGetter dataPipeGetter;
  public boolean readOnlyOnce;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DataElementChunkedDataPipe(int version) {
    super(24, version);
  }

  public DataElementChunkedDataPipe() {
    this(0);
  }

  public static DataElementChunkedDataPipe deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DataElementChunkedDataPipe deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DataElementChunkedDataPipe decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DataElementChunkedDataPipe result = new DataElementChunkedDataPipe(elementsOrVersion);
      result.dataPipeGetter =
          (ChunkedDataPipeGetter)
              decoder0.readServiceInterface(8, false, ChunkedDataPipeGetter.MANAGER);
      result.readOnlyOnce = decoder0.readBoolean(16, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.dataPipeGetter, 8, false, ChunkedDataPipeGetter.MANAGER);
    encoder0.encode(this.readOnlyOnce, 16, 0);
  }
}
