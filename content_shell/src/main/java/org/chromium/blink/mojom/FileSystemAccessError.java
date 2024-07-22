package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FileError;

public final class FileSystemAccessError extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int fileError;
  public String message;
  public int status;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FileSystemAccessError(int version) {
    super(24, version);
  }

  public FileSystemAccessError() {
    this(0);
  }

  public static FileSystemAccessError deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FileSystemAccessError deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FileSystemAccessError decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FileSystemAccessError result = new FileSystemAccessError(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.status = readInt;
      FileSystemAccessStatus.validate(readInt);
      result.status = FileSystemAccessStatus.toKnownValue(result.status);
      int readInt2 = decoder0.readInt(12);
      result.fileError = readInt2;
      FileError.validate(readInt2);
      result.fileError = FileError.toKnownValue(result.fileError);
      result.message = decoder0.readString(16, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.status, 8);
    encoder0.encode(this.fileError, 12);
    encoder0.encode(this.message, 16, false);
  }
}
