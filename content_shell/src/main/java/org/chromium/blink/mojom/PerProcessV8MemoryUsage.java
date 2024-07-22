package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PerProcessV8MemoryUsage extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public PerIsolateV8MemoryUsage[] isolates;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PerProcessV8MemoryUsage(int version) {
    super(16, version);
  }

  public PerProcessV8MemoryUsage() {
    this(0);
  }

  public static PerProcessV8MemoryUsage deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PerProcessV8MemoryUsage deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PerProcessV8MemoryUsage decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PerProcessV8MemoryUsage result = new PerProcessV8MemoryUsage(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.isolates = new PerIsolateV8MemoryUsage[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.isolates[i1] = PerIsolateV8MemoryUsage.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    PerIsolateV8MemoryUsage[] perIsolateV8MemoryUsageArr = this.isolates;
    if (perIsolateV8MemoryUsageArr == null) {
      encoder0.encodeNullPointer(8, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(perIsolateV8MemoryUsageArr.length, 8, -1);
    int i0 = 0;
    while (true) {
      PerIsolateV8MemoryUsage[] perIsolateV8MemoryUsageArr2 = this.isolates;
      if (i0 < perIsolateV8MemoryUsageArr2.length) {
        encoder1.encode((Struct) perIsolateV8MemoryUsageArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}