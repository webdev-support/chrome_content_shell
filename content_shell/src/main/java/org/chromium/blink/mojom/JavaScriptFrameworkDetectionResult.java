package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class JavaScriptFrameworkDetectionResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public Map<Integer, Short> detectedVersions;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private JavaScriptFrameworkDetectionResult(int version) {
    super(16, version);
  }

  public JavaScriptFrameworkDetectionResult() {
    this(0);
  }

  public static JavaScriptFrameworkDetectionResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static JavaScriptFrameworkDetectionResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static JavaScriptFrameworkDetectionResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      JavaScriptFrameworkDetectionResult result =
          new JavaScriptFrameworkDetectionResult(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      decoder1.readDataHeaderForMap();
      int[] keys0 = decoder1.readInts(8, 0, -1);
      for (int i : keys0) {
        JavaScriptFramework.validate(i);
      }
      int i2 = keys0.length;
      short[] values0 = decoder1.readShorts(16, 0, i2);
      result.detectedVersions = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.detectedVersions.put(Integer.valueOf(keys0[index0]), Short.valueOf(values0[index0]));
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    if (this.detectedVersions == null) {
      encoder0.encodeNullPointer(8, false);
      return;
    }
    Encoder encoder1 = encoder0.encoderForMap(8);
    int size0 = this.detectedVersions.size();
    int[] keys0 = new int[size0];
    short[] values0 = new short[size0];
    int index0 = 0;
    for (Map.Entry<Integer, Short> entry0 : this.detectedVersions.entrySet()) {
      keys0[index0] = entry0.getKey().intValue();
      values0[index0] = entry0.getValue().shortValue();
      index0++;
    }
    encoder1.encode(keys0, 8, 0, -1);
    encoder1.encode(values0, 16, 0, -1);
  }
}
