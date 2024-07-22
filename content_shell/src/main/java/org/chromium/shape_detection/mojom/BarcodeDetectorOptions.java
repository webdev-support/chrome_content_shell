package org.chromium.shape_detection.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BarcodeDetectorOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public int[] formats;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BarcodeDetectorOptions(int version) {
    super(16, version);
  }

  public BarcodeDetectorOptions() {
    this(0);
  }

  public static BarcodeDetectorOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BarcodeDetectorOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BarcodeDetectorOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BarcodeDetectorOptions result = new BarcodeDetectorOptions(elementsOrVersion);
      result.formats = decoder0.readInts(8, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.formats;
        if (i1 < iArr.length) {
          BarcodeFormat.validate(iArr[i1]);
          i1++;
        } else {
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.formats, 8, 0, -1);
  }
}
