package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class DragItemFileSystemFile extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public String fileSystemId;
  public SerializedBlob serializedBlob;
  public long size;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DragItemFileSystemFile(int version) {
    super(40, version);
  }

  public DragItemFileSystemFile() {
    this(0);
  }

  public static DragItemFileSystemFile deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DragItemFileSystemFile deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DragItemFileSystemFile decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DragItemFileSystemFile result = new DragItemFileSystemFile(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      result.size = decoder0.readLong(16);
      result.fileSystemId = decoder0.readString(24, true);
      Decoder decoder12 = decoder0.readPointer(32, true);
      result.serializedBlob = SerializedBlob.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode(this.size, 16);
    encoder0.encode(this.fileSystemId, 24, true);
    encoder0.encode((Struct) this.serializedBlob, 32, true);
  }
}
