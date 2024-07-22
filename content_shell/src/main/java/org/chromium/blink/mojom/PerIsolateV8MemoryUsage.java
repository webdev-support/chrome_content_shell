package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PerIsolateV8MemoryUsage extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public long blinkBytesUsed;
  public PerContextCanvasMemoryUsage[] canvasContexts;
  public PerContextV8MemoryUsage[] contexts;
  public long detachedBytesUsed;
  public long numDetachedContexts;
  public long sharedBytesUsed;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PerIsolateV8MemoryUsage(int version) {
    super(56, version);
  }

  public PerIsolateV8MemoryUsage() {
    this(0);
  }

  public static PerIsolateV8MemoryUsage deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PerIsolateV8MemoryUsage deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PerIsolateV8MemoryUsage decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PerIsolateV8MemoryUsage result = new PerIsolateV8MemoryUsage(elementsOrVersion);
      result.numDetachedContexts = decoder0.readLong(8);
      result.detachedBytesUsed = decoder0.readLong(16);
      result.sharedBytesUsed = decoder0.readLong(24);
      result.blinkBytesUsed = decoder0.readLong(32);
      Decoder decoder1 = decoder0.readPointer(40, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.contexts = new PerContextV8MemoryUsage[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.contexts[i1] = PerContextV8MemoryUsage.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(48, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.canvasContexts = new PerContextCanvasMemoryUsage[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.canvasContexts[i12] = PerContextCanvasMemoryUsage.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.numDetachedContexts, 8);
    encoder0.encode(this.detachedBytesUsed, 16);
    encoder0.encode(this.sharedBytesUsed, 24);
    encoder0.encode(this.blinkBytesUsed, 32);
    PerContextV8MemoryUsage[] perContextV8MemoryUsageArr = this.contexts;
    if (perContextV8MemoryUsageArr == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(perContextV8MemoryUsageArr.length, 40, -1);
      int i0 = 0;
      while (true) {
        PerContextV8MemoryUsage[] perContextV8MemoryUsageArr2 = this.contexts;
        if (i0 >= perContextV8MemoryUsageArr2.length) {
          break;
        }
        encoder1.encode((Struct) perContextV8MemoryUsageArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    PerContextCanvasMemoryUsage[] perContextCanvasMemoryUsageArr = this.canvasContexts;
    if (perContextCanvasMemoryUsageArr == null) {
      encoder0.encodeNullPointer(48, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(perContextCanvasMemoryUsageArr.length, 48, -1);
    int i02 = 0;
    while (true) {
      PerContextCanvasMemoryUsage[] perContextCanvasMemoryUsageArr2 = this.canvasContexts;
      if (i02 < perContextCanvasMemoryUsageArr2.length) {
        encoder12.encode((Struct) perContextCanvasMemoryUsageArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
