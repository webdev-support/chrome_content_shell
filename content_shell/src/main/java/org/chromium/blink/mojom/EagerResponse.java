package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

public final class EagerResponse extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public InterfaceRequest<BlobReaderClient> clientReceiver;
  public DataPipe.ConsumerHandle pipe;
  public FetchApiResponse response;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private EagerResponse(int version) {
    super(24, version);
    this.pipe = InvalidHandle.INSTANCE;
  }

  public EagerResponse() {
    this(0);
  }

  public static EagerResponse deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static EagerResponse deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static EagerResponse decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      EagerResponse result = new EagerResponse(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.response = FetchApiResponse.decode(decoder1);
      result.pipe = decoder0.readConsumerHandle(16, false);
      result.clientReceiver = decoder0.readInterfaceRequest(20, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.response, 8, false);
    encoder0.encode((Handle) this.pipe, 16, false);
    encoder0.encode((InterfaceRequest) this.clientReceiver, 20, false);
  }
}
