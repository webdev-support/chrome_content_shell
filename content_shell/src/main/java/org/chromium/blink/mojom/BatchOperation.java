package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BatchOperation extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public CacheQueryOptions matchOptions;
  public int operationType;
  public FetchApiRequest request;
  public FetchApiResponse response;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BatchOperation(int version) {
    super(40, version);
  }

  public BatchOperation() {
    this(0);
  }

  public static BatchOperation deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BatchOperation deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BatchOperation decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BatchOperation result = new BatchOperation(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.operationType = readInt;
      OperationType.validate(readInt);
      result.operationType = OperationType.toKnownValue(result.operationType);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.request = FetchApiRequest.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.response = FetchApiResponse.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, true);
      result.matchOptions = CacheQueryOptions.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.operationType, 8);
    encoder0.encode((Struct) this.request, 16, false);
    encoder0.encode((Struct) this.response, 24, true);
    encoder0.encode((Struct) this.matchOptions, 32, true);
  }
}
