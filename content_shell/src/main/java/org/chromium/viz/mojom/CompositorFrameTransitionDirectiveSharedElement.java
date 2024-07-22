package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CompositorFrameTransitionDirectiveSharedElement extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public CompositorRenderPassId renderPassId;
  public ViewTransitionElementResourceId viewTransitionElementResourceId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CompositorFrameTransitionDirectiveSharedElement(int version) {
    super(24, version);
  }

  public CompositorFrameTransitionDirectiveSharedElement() {
    this(0);
  }

  public static CompositorFrameTransitionDirectiveSharedElement deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CompositorFrameTransitionDirectiveSharedElement deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CompositorFrameTransitionDirectiveSharedElement decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CompositorFrameTransitionDirectiveSharedElement result =
          new CompositorFrameTransitionDirectiveSharedElement(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.renderPassId = CompositorRenderPassId.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.viewTransitionElementResourceId = ViewTransitionElementResourceId.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.renderPassId, 8, false);
    encoder0.encode((Struct) this.viewTransitionElementResourceId, 16, false);
  }
}
