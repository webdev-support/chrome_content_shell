package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CompositorFrame extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public CompositorFrameMetadata metadata;
  public CompositorRenderPass[] passes;
  public TransferableResource[] resources;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CompositorFrame(int version) {
    super(32, version);
  }

  public CompositorFrame() {
    this(0);
  }

  public static CompositorFrame deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CompositorFrame deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CompositorFrame decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CompositorFrame result = new CompositorFrame(elementsOrVersion);
      result.metadata = CompositorFrameMetadata.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.resources = new TransferableResource[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.resources[i1] = TransferableResource.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(24, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.passes = new CompositorRenderPass[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.passes[i12] = CompositorRenderPass.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.metadata, 8, false);
    TransferableResource[] transferableResourceArr = this.resources;
    if (transferableResourceArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(transferableResourceArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        TransferableResource[] transferableResourceArr2 = this.resources;
        if (i0 >= transferableResourceArr2.length) {
          break;
        }
        encoder1.encode((Struct) transferableResourceArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    CompositorRenderPass[] compositorRenderPassArr = this.passes;
    if (compositorRenderPassArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(compositorRenderPassArr.length, 24, -1);
    int i02 = 0;
    while (true) {
      CompositorRenderPass[] compositorRenderPassArr2 = this.passes;
      if (i02 < compositorRenderPassArr2.length) {
        encoder12.encode((Struct) compositorRenderPassArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
