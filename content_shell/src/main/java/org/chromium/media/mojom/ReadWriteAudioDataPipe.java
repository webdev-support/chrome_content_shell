package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.UntypedHandle;
import org.chromium.mojo_base.mojom.UnsafeSharedMemoryRegion;

public final class ReadWriteAudioDataPipe extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public UnsafeSharedMemoryRegion sharedMemory;
  public UntypedHandle socket;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ReadWriteAudioDataPipe(int version) {
    super(24, version);
    this.socket = InvalidHandle.INSTANCE;
  }

  public ReadWriteAudioDataPipe() {
    this(0);
  }

  public static ReadWriteAudioDataPipe deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ReadWriteAudioDataPipe deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ReadWriteAudioDataPipe decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ReadWriteAudioDataPipe result = new ReadWriteAudioDataPipe(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.sharedMemory = UnsafeSharedMemoryRegion.decode(decoder1);
      result.socket = decoder0.readUntypedHandle(16, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.sharedMemory, 8, false);
    encoder0.encode((Handle) this.socket, 16, false);
  }
}
