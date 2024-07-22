package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.RRectF;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.gfx.mojom.Transform;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CompositorRenderPass extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 112;
  private static final DataHeader[] VERSION_ARRAY;
  public RRectF backdropFilterBounds;
  public FilterOperations backdropFilters;
  public boolean cacheRenderPass;
  public CopyOutputRequest[] copyRequests;
  public Rect damageRect;
  public FilterOperations filters;
  public boolean generateMipmap;
  public boolean hasDamageFromContributingContent;
  public boolean hasPerQuadDamage;
  public boolean hasTransparentBackground;

  public CompositorRenderPassId f781id;
  public Rect outputRect;
  public DrawQuad[] quadList;
  public SubtreeCaptureId subtreeCaptureId;
  public Size subtreeSize;
  public Transform transformToRootTarget;
  public ViewTransitionElementResourceId viewTransitionElementResourceId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(112, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CompositorRenderPass(int version) {
    super(112, version);
    this.cacheRenderPass = false;
    this.hasDamageFromContributingContent = false;
    this.generateMipmap = false;
  }

  public CompositorRenderPass() {
    this(0);
  }

  public static CompositorRenderPass deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CompositorRenderPass deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CompositorRenderPass decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CompositorRenderPass result = new CompositorRenderPass(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.f781id = CompositorRenderPassId.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.outputRect = Rect.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.damageRect = Rect.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.transformToRootTarget = Transform.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(40, false);
      result.filters = FilterOperations.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(48, false);
      result.backdropFilters = FilterOperations.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(56, true);
      result.backdropFilterBounds = RRectF.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(64, false);
      result.subtreeCaptureId = SubtreeCaptureId.decode(decoder18);
      Decoder decoder19 = decoder0.readPointer(72, false);
      result.subtreeSize = Size.decode(decoder19);
      Decoder decoder110 = decoder0.readPointer(80, false);
      result.viewTransitionElementResourceId = ViewTransitionElementResourceId.decode(decoder110);
      result.hasTransparentBackground = decoder0.readBoolean(88, 0);
      result.cacheRenderPass = decoder0.readBoolean(88, 1);
      result.hasDamageFromContributingContent = decoder0.readBoolean(88, 2);
      result.generateMipmap = decoder0.readBoolean(88, 3);
      result.hasPerQuadDamage = decoder0.readBoolean(88, 4);
      Decoder decoder111 = decoder0.readPointer(96, false);
      DataHeader si1 = decoder111.readDataHeaderForPointerArray(-1);
      result.copyRequests = new CopyOutputRequest[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder111.readPointer((i1 * 8) + 8, false);
        result.copyRequests[i1] = CopyOutputRequest.decode(decoder2);
      }
      Decoder decoder112 = decoder0.readPointer(104, false);
      DataHeader si12 = decoder112.readDataHeaderForPointerArray(-1);
      result.quadList = new DrawQuad[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder112.readPointer((i12 * 8) + 8, false);
        result.quadList[i12] = DrawQuad.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.f781id, 8, false);
    encoder0.encode((Struct) this.outputRect, 16, false);
    encoder0.encode((Struct) this.damageRect, 24, false);
    encoder0.encode((Struct) this.transformToRootTarget, 32, false);
    encoder0.encode((Struct) this.filters, 40, false);
    encoder0.encode((Struct) this.backdropFilters, 48, false);
    encoder0.encode((Struct) this.backdropFilterBounds, 56, true);
    encoder0.encode((Struct) this.subtreeCaptureId, 64, false);
    encoder0.encode((Struct) this.subtreeSize, 72, false);
    encoder0.encode((Struct) this.viewTransitionElementResourceId, 80, false);
    encoder0.encode(this.hasTransparentBackground, 88, 0);
    encoder0.encode(this.cacheRenderPass, 88, 1);
    encoder0.encode(this.hasDamageFromContributingContent, 88, 2);
    encoder0.encode(this.generateMipmap, 88, 3);
    encoder0.encode(this.hasPerQuadDamage, 88, 4);
    CopyOutputRequest[] copyOutputRequestArr = this.copyRequests;
    if (copyOutputRequestArr == null) {
      encoder0.encodeNullPointer(96, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(copyOutputRequestArr.length, 96, -1);
      int i0 = 0;
      while (true) {
        CopyOutputRequest[] copyOutputRequestArr2 = this.copyRequests;
        if (i0 >= copyOutputRequestArr2.length) {
          break;
        }
        encoder1.encode((Struct) copyOutputRequestArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    DrawQuad[] drawQuadArr = this.quadList;
    if (drawQuadArr == null) {
      encoder0.encodeNullPointer(104, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(drawQuadArr.length, 104, -1);
    int i02 = 0;
    while (true) {
      DrawQuad[] drawQuadArr2 = this.quadList;
      if (i02 < drawQuadArr2.length) {
        encoder12.encode((Struct) drawQuadArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
