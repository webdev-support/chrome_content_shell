package org.chromium.filesystem.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FilePath;

public final class DirectoryEntry extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public FilePath name;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DirectoryEntry(int version) {
    super(24, version);
  }

  public DirectoryEntry() {
    this(0);
  }

  public static DirectoryEntry deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DirectoryEntry deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DirectoryEntry decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DirectoryEntry result = new DirectoryEntry(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.name = FilePath.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.type = readInt;
      FsFileType.validate(readInt);
      result.type = FsFileType.toKnownValue(result.type);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.name, 8, false);
    encoder0.encode(this.type, 16);
  }
}
