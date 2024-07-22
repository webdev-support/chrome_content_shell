package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PinList extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public PinSetInfo[] hostPins;
  public PinSet[] pinsets;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PinList(int version) {
    super(24, version);
  }

  public PinList() {
    this(0);
  }

  public static PinList deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PinList deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PinList decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PinList result = new PinList(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.pinsets = new PinSet[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.pinsets[i1] = PinSet.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.hostPins = new PinSetInfo[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.hostPins[i12] = PinSetInfo.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    PinSet[] pinSetArr = this.pinsets;
    if (pinSetArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(pinSetArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        PinSet[] pinSetArr2 = this.pinsets;
        if (i0 >= pinSetArr2.length) {
          break;
        }
        encoder1.encode((Struct) pinSetArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    PinSetInfo[] pinSetInfoArr = this.hostPins;
    if (pinSetInfoArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(pinSetInfoArr.length, 16, -1);
    int i02 = 0;
    while (true) {
      PinSetInfo[] pinSetInfoArr2 = this.hostPins;
      if (i02 < pinSetInfoArr2.length) {
        encoder12.encode((Struct) pinSetInfoArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
