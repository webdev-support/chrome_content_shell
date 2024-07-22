package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FileSystemAccessChangeMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public FileSystemAccessEntry changedEntry;
  public String[] relativePath;
  public FileSystemAccessEntry root;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FileSystemAccessChangeMetadata(int version) {
    super(32, version);
  }

  public FileSystemAccessChangeMetadata() {
    this(0);
  }

  public static FileSystemAccessChangeMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FileSystemAccessChangeMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FileSystemAccessChangeMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FileSystemAccessChangeMetadata result = new FileSystemAccessChangeMetadata(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.root = FileSystemAccessEntry.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.changedEntry = FileSystemAccessEntry.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
      result.relativePath = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.relativePath[i1] = decoder13.readString((i1 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.root, 8, false);
    encoder0.encode((Struct) this.changedEntry, 16, false);
    String[] strArr = this.relativePath;
    if (strArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 24, -1);
    int i0 = 0;
    while (true) {
      String[] strArr2 = this.relativePath;
      if (i0 < strArr2.length) {
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
