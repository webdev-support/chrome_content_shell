package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FilePath;

public final class DataTransferFile extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public FilePath displayName;
  public FileSystemAccessDataTransferToken fileSystemAccessToken;
  public FilePath path;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DataTransferFile(int version) {
    super(32, version);
  }

  public DataTransferFile() {
    this(0);
  }

  public static DataTransferFile deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DataTransferFile deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DataTransferFile decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DataTransferFile result = new DataTransferFile(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.path = FilePath.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.displayName = FilePath.decode(decoder12);
      result.fileSystemAccessToken =
          (FileSystemAccessDataTransferToken)
              decoder0.readServiceInterface(24, true, FileSystemAccessDataTransferToken.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.path, 8, false);
    encoder0.encode((Struct) this.displayName, 16, false);
    encoder0.encode(
        this.fileSystemAccessToken, 24, true, FileSystemAccessDataTransferToken.MANAGER);
  }
}
