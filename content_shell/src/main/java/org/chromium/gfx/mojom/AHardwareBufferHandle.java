package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.UntypedHandle;

public final class AHardwareBufferHandle extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public UntypedHandle bufferHandle;
  public MessagePipeHandle trackingPipe;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AHardwareBufferHandle(int version) {
    super(16, version);
    this.bufferHandle = InvalidHandle.INSTANCE;
    this.trackingPipe = InvalidHandle.INSTANCE;
  }

  public AHardwareBufferHandle() {
    this(0);
  }

  public static AHardwareBufferHandle deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AHardwareBufferHandle deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AHardwareBufferHandle decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AHardwareBufferHandle result = new AHardwareBufferHandle(elementsOrVersion);
      result.bufferHandle = decoder0.readUntypedHandle(8, false);
      result.trackingPipe = decoder0.readMessagePipeHandle(12, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Handle) this.bufferHandle, 8, false);
    encoder0.encode((Handle) this.trackingPipe, 12, false);
  }
}