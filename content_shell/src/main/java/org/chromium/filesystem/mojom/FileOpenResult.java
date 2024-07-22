package org.chromium.filesystem.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.FileError;

public final class FileOpenResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int error;
  public File fileHandle;
  public String path;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FileOpenResult(int version) {
    super(32, version);
  }

  public FileOpenResult() {
    this(0);
  }

  public static FileOpenResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FileOpenResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FileOpenResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FileOpenResult result = new FileOpenResult(elementsOrVersion);
      result.path = decoder0.readString(8, false);
      int readInt = decoder0.readInt(16);
      result.error = readInt;
      FileError.validate(readInt);
      result.error = FileError.toKnownValue(result.error);
      Decoder decoder1 = decoder0.readPointer(24, true);
      result.fileHandle = File.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.path, 8, false);
    encoder0.encode(this.error, 16);
    encoder0.encode((Struct) this.fileHandle, 24, true);
  }
}
