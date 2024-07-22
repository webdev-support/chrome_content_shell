package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AcceptsTypesInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public ChooseFileSystemEntryAcceptsOption[] accepts;
  public boolean includeAcceptsAll;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AcceptsTypesInfo(int version) {
    super(24, version);
  }

  public AcceptsTypesInfo() {
    this(0);
  }

  public static AcceptsTypesInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AcceptsTypesInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AcceptsTypesInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AcceptsTypesInfo result = new AcceptsTypesInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.accepts = new ChooseFileSystemEntryAcceptsOption[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.accepts[i1] = ChooseFileSystemEntryAcceptsOption.decode(decoder2);
      }
      result.includeAcceptsAll = decoder0.readBoolean(16, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    ChooseFileSystemEntryAcceptsOption[] chooseFileSystemEntryAcceptsOptionArr = this.accepts;
    if (chooseFileSystemEntryAcceptsOptionArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 =
          encoder0.encodePointerArray(chooseFileSystemEntryAcceptsOptionArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ChooseFileSystemEntryAcceptsOption[] chooseFileSystemEntryAcceptsOptionArr2 = this.accepts;
        if (i0 >= chooseFileSystemEntryAcceptsOptionArr2.length) {
          break;
        }
        encoder1.encode((Struct) chooseFileSystemEntryAcceptsOptionArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.includeAcceptsAll, 16, 0);
  }
}
