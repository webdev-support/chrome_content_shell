package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.Time;

public final class FileEnumerationEntry extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public Time lastAccessed;
  public Time lastModified;
  public FilePath path;
  public long size;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FileEnumerationEntry(int version) {
    super(40, version);
  }

  public FileEnumerationEntry() {
    this(0);
  }

  public static FileEnumerationEntry deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FileEnumerationEntry deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FileEnumerationEntry decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FileEnumerationEntry result = new FileEnumerationEntry(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.path = FilePath.decode(decoder1);
      result.size = decoder0.readLong(16);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.lastAccessed = Time.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.lastModified = Time.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.path, 8, false);
    encoder0.encode(this.size, 16);
    encoder0.encode((Struct) this.lastAccessed, 24, false);
    encoder0.encode((Struct) this.lastModified, 32, false);
  }
}
