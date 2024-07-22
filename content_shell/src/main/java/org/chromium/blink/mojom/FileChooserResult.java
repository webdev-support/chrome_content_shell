package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.FilePath;

public final class FileChooserResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public FilePath baseDirectory;
  public FileChooserFileInfo[] files;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FileChooserResult(int version) {
    super(24, version);
  }

  public FileChooserResult() {
    this(0);
  }

  public static FileChooserResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FileChooserResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FileChooserResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FileChooserResult result = new FileChooserResult(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.files = new FileChooserFileInfo[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.files[i1] = FileChooserFileInfo.decode(decoder1, (i1 * 16) + 8);
      }
      result.baseDirectory = FilePath.decode(decoder0.readPointer(16, false));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    FileChooserFileInfo[] fileChooserFileInfoArr = this.files;
    if (fileChooserFileInfoArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodeUnionArray(fileChooserFileInfoArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        FileChooserFileInfo[] fileChooserFileInfoArr2 = this.files;
        if (i0 >= fileChooserFileInfoArr2.length) {
          break;
        }
        encoder1.encode((Union) fileChooserFileInfoArr2[i0], (i0 * 16) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.baseDirectory, 16, false);
  }
}