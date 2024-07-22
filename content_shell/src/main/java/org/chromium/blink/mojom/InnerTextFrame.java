package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class InnerTextFrame extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public InnerTextSegment[] segments;
  public LocalFrameToken token;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private InnerTextFrame(int version) {
    super(24, version);
  }

  public InnerTextFrame() {
    this(0);
  }

  public static InnerTextFrame deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static InnerTextFrame deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static InnerTextFrame decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      InnerTextFrame result = new InnerTextFrame(elementsOrVersion);
      result.token = LocalFrameToken.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.segments = new InnerTextSegment[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.segments[i1] = InnerTextSegment.decode(decoder1, (i1 * 16) + 8);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.token, 8, false);
    InnerTextSegment[] innerTextSegmentArr = this.segments;
    if (innerTextSegmentArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder1 = encoder0.encodeUnionArray(innerTextSegmentArr.length, 16, -1);
    int i0 = 0;
    while (true) {
      InnerTextSegment[] innerTextSegmentArr2 = this.segments;
      if (i0 < innerTextSegmentArr2.length) {
        encoder1.encode((Union) innerTextSegmentArr2[i0], (i0 * 16) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
