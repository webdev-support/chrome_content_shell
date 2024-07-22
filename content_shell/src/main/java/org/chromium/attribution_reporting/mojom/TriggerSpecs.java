package org.chromium.attribution_reporting.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TriggerSpecs extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public TriggerSpec[] specs;
  public Map<Integer, Byte> triggerDataIndices;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TriggerSpecs(int version) {
    super(24, version);
  }

  public TriggerSpecs() {
    this(0);
  }

  public static TriggerSpecs deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TriggerSpecs deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TriggerSpecs decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TriggerSpecs result = new TriggerSpecs(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.specs = new TriggerSpec[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.specs[i1] = TriggerSpec.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      decoder12.readDataHeaderForMap();
      int[] keys0 = decoder12.readInts(8, 0, -1);
      byte[] values0 = decoder12.readBytes(16, 0, keys0.length);
      result.triggerDataIndices = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.triggerDataIndices.put(
            Integer.valueOf(keys0[index0]), Byte.valueOf(values0[index0]));
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    TriggerSpec[] triggerSpecArr = this.specs;
    if (triggerSpecArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(triggerSpecArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        TriggerSpec[] triggerSpecArr2 = this.specs;
        if (i0 >= triggerSpecArr2.length) {
          break;
        }
        encoder1.encode((Struct) triggerSpecArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    if (this.triggerDataIndices == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder12 = encoder0.encoderForMap(16);
    int size0 = this.triggerDataIndices.size();
    int[] keys0 = new int[size0];
    byte[] values0 = new byte[size0];
    int index0 = 0;
    for (Map.Entry<Integer, Byte> entry0 : this.triggerDataIndices.entrySet()) {
      keys0[index0] = entry0.getKey().intValue();
      values0[index0] = entry0.getValue().byteValue();
      index0++;
    }
    encoder12.encode(keys0, 8, 0, -1);
    encoder12.encode(values0, 16, 0, -1);
  }
}
