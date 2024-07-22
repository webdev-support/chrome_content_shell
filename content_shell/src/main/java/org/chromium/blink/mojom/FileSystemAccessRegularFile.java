package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FileSystemAccessRegularFile extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public FileSystemAccessCapacityAllocationHost capacityAllocationHost;
  public long fileSize;
  public org.chromium.mojo_base.mojom.File osFile;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FileSystemAccessRegularFile(int version) {
    super(32, version);
  }

  public FileSystemAccessRegularFile() {
    this(0);
  }

  public static FileSystemAccessRegularFile deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FileSystemAccessRegularFile deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FileSystemAccessRegularFile decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FileSystemAccessRegularFile result = new FileSystemAccessRegularFile(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.osFile = org.chromium.mojo_base.mojom.File.decode(decoder1);
      result.fileSize = decoder0.readLong(16);
      result.capacityAllocationHost =
          (FileSystemAccessCapacityAllocationHost)
              decoder0.readServiceInterface(
                  24, false, FileSystemAccessCapacityAllocationHost.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.osFile, 8, false);
    encoder0.encode(this.fileSize, 16);
    encoder0.encode(
        this.capacityAllocationHost, 24, false, FileSystemAccessCapacityAllocationHost.MANAGER);
  }
}
