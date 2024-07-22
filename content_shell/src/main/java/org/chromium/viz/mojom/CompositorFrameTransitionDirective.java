package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class CompositorFrameTransitionDirective extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public UnguessableToken navigationId;
  public int sequenceId;
  public CompositorFrameTransitionDirectiveSharedElement[] sharedElements;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CompositorFrameTransitionDirective(int version) {
    super(32, version);
  }

  public CompositorFrameTransitionDirective() {
    this(0);
  }

  public static CompositorFrameTransitionDirective deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CompositorFrameTransitionDirective deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CompositorFrameTransitionDirective decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CompositorFrameTransitionDirective result =
          new CompositorFrameTransitionDirective(elementsOrVersion);
      result.navigationId = UnguessableToken.decode(decoder0.readPointer(8, true));
      result.sequenceId = decoder0.readInt(16);
      int readInt = decoder0.readInt(20);
      result.type = readInt;
      CompositorFrameTransitionDirectiveType.validate(readInt);
      result.type = CompositorFrameTransitionDirectiveType.toKnownValue(result.type);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.sharedElements =
          new CompositorFrameTransitionDirectiveSharedElement[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.sharedElements[i1] =
            CompositorFrameTransitionDirectiveSharedElement.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.navigationId, 8, true);
    encoder0.encode(this.sequenceId, 16);
    encoder0.encode(this.type, 20);
    CompositorFrameTransitionDirectiveSharedElement[]
        compositorFrameTransitionDirectiveSharedElementArr = this.sharedElements;
    if (compositorFrameTransitionDirectiveSharedElementArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder1 =
        encoder0.encodePointerArray(
            compositorFrameTransitionDirectiveSharedElementArr.length, 24, -1);
    int i0 = 0;
    while (true) {
      CompositorFrameTransitionDirectiveSharedElement[]
          compositorFrameTransitionDirectiveSharedElementArr2 = this.sharedElements;
      if (i0 < compositorFrameTransitionDirectiveSharedElementArr2.length) {
        encoder1.encode(
            (Struct) compositorFrameTransitionDirectiveSharedElementArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
