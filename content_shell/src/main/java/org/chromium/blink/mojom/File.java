package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.Time;

public final class File extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public long length;
  public Time modificationTime;
  public long offset;
  public String16 path;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private File(int version) {
    super(40, version);
  }

  public File() {
    this(0);
  }

  public static File deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static File deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static File decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      File result = new File(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.path = String16.decode(decoder1);
      result.offset = decoder0.readLong(16);
      result.length = decoder0.readLong(24);
      Decoder decoder12 = decoder0.readPointer(32, false);
      result.modificationTime = Time.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.path, 8, false);
    encoder0.encode(this.offset, 16);
    encoder0.encode(this.length, 24);
    encoder0.encode((Struct) this.modificationTime, 32, false);
  }
}
