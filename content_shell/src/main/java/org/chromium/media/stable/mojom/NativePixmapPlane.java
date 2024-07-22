package org.chromium.media.stable.mojom;

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

public final class NativePixmapPlane extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public UntypedHandle bufferHandle;
  public long offset;
  public long size;
  public int stride;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NativePixmapPlane(int version) {
    super(32, version);
    this.bufferHandle = InvalidHandle.INSTANCE;
  }

  public NativePixmapPlane() {
    this(0);
  }

  public static NativePixmapPlane deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NativePixmapPlane deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NativePixmapPlane decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NativePixmapPlane result = new NativePixmapPlane(elementsOrVersion);
      result.stride = decoder0.readInt(8);
      result.bufferHandle = decoder0.readUntypedHandle(12, false);
      result.offset = decoder0.readLong(16);
      result.size = decoder0.readLong(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.stride, 8);
    encoder0.encode((Handle) this.bufferHandle, 12, false);
    encoder0.encode(this.offset, 16);
    encoder0.encode(this.size, 24);
  }
}
