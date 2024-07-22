package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class AnchorElementMetrics extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public int anchorId;
  public boolean containsImage;
  public int fontSizePx;
  public int fontWeight;
  public boolean hasTextSibling;
  public boolean isInIframe;
  public boolean isSameHost;
  public boolean isUrlIncrementedByOne;
  public float ratioArea;
  public float ratioDistanceRootTop;
  public float ratioDistanceTopToVisibleTop;
  public Url targetUrl;
  public Size viewportSize;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AnchorElementMetrics(int version) {
    super(56, version);
  }

  public AnchorElementMetrics() {
    this(0);
  }

  public static AnchorElementMetrics deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AnchorElementMetrics deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AnchorElementMetrics decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AnchorElementMetrics result = new AnchorElementMetrics(elementsOrVersion);
      result.anchorId = decoder0.readInt(8);
      result.ratioArea = decoder0.readFloat(12);
      result.ratioDistanceTopToVisibleTop = decoder0.readFloat(16);
      result.ratioDistanceRootTop = decoder0.readFloat(20);
      result.isInIframe = decoder0.readBoolean(24, 0);
      result.containsImage = decoder0.readBoolean(24, 1);
      result.isSameHost = decoder0.readBoolean(24, 2);
      result.isUrlIncrementedByOne = decoder0.readBoolean(24, 3);
      result.hasTextSibling = decoder0.readBoolean(24, 4);
      result.fontSizePx = decoder0.readInt(28);
      result.fontWeight = decoder0.readInt(32);
      Decoder decoder1 = decoder0.readPointer(40, false);
      result.targetUrl = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(48, false);
      result.viewportSize = Size.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.anchorId, 8);
    encoder0.encode(this.ratioArea, 12);
    encoder0.encode(this.ratioDistanceTopToVisibleTop, 16);
    encoder0.encode(this.ratioDistanceRootTop, 20);
    encoder0.encode(this.isInIframe, 24, 0);
    encoder0.encode(this.containsImage, 24, 1);
    encoder0.encode(this.isSameHost, 24, 2);
    encoder0.encode(this.isUrlIncrementedByOne, 24, 3);
    encoder0.encode(this.hasTextSibling, 24, 4);
    encoder0.encode(this.fontSizePx, 28);
    encoder0.encode(this.fontWeight, 32);
    encoder0.encode((Struct) this.targetUrl, 40, false);
    encoder0.encode((Struct) this.viewportSize, 48, false);
  }
}
