package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class ChooseFileSystemEntryAcceptsOption extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String16 description;
  public String[] extensions;
  public String[] mimeTypes;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ChooseFileSystemEntryAcceptsOption(int version) {
    super(32, version);
  }

  public ChooseFileSystemEntryAcceptsOption() {
    this(0);
  }

  public static ChooseFileSystemEntryAcceptsOption deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ChooseFileSystemEntryAcceptsOption deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ChooseFileSystemEntryAcceptsOption decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ChooseFileSystemEntryAcceptsOption result =
          new ChooseFileSystemEntryAcceptsOption(elementsOrVersion);
      result.description = String16.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.mimeTypes = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.mimeTypes[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      Decoder decoder12 = decoder0.readPointer(24, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.extensions = new String[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.extensions[i12] = decoder12.readString((i12 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.description, 8, false);
    String[] strArr = this.mimeTypes;
    if (strArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.mimeTypes;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    String[] strArr3 = this.extensions;
    if (strArr3 == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(strArr3.length, 24, -1);
    int i02 = 0;
    while (true) {
      String[] strArr4 = this.extensions;
      if (i02 < strArr4.length) {
        encoder12.encode(strArr4[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
