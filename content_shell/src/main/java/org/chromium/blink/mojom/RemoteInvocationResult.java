package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class RemoteInvocationResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int error;
  public RemoteInvocationResultValue value;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RemoteInvocationResult(int version) {
    super(32, version);
    this.error = 0;
  }

  public RemoteInvocationResult() {
    this(0);
  }

  public static RemoteInvocationResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RemoteInvocationResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RemoteInvocationResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RemoteInvocationResult result = new RemoteInvocationResult(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.error = readInt;
      RemoteInvocationError.validate(readInt);
      result.error = RemoteInvocationError.toKnownValue(result.error);
      result.value = RemoteInvocationResultValue.decode(decoder0, 16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.error, 8);
    encoder0.encode((Union) this.value, 16, true);
  }
}
