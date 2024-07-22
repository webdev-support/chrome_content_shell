package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gpu.mojom.MailboxHolder;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.ImageInfo;

public final class AcceleratedStaticBitmapImage extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public ImageInfo imageInfo;
  public boolean isOriginTopLeft;
  public boolean isOverlayCandidate;
  public MailboxHolder mailboxHolder;
  public ImageReleaseCallback releaseCallback;
  public boolean supportsDisplayCompositing;
  public int usage;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AcceleratedStaticBitmapImage(int version) {
    super(40, version);
  }

  public AcceleratedStaticBitmapImage() {
    this(0);
  }

  public static AcceleratedStaticBitmapImage deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AcceleratedStaticBitmapImage deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AcceleratedStaticBitmapImage decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AcceleratedStaticBitmapImage result = new AcceleratedStaticBitmapImage(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.mailboxHolder = MailboxHolder.decode(decoder1);
      result.usage = decoder0.readInt(16);
      result.isOriginTopLeft = decoder0.readBoolean(20, 0);
      result.supportsDisplayCompositing = decoder0.readBoolean(20, 1);
      result.isOverlayCandidate = decoder0.readBoolean(20, 2);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.imageInfo = ImageInfo.decode(decoder12);
      result.releaseCallback =
          (ImageReleaseCallback)
              decoder0.readServiceInterface(32, false, ImageReleaseCallback.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.mailboxHolder, 8, false);
    encoder0.encode(this.usage, 16);
    encoder0.encode(this.isOriginTopLeft, 20, 0);
    encoder0.encode(this.supportsDisplayCompositing, 20, 1);
    encoder0.encode(this.isOverlayCandidate, 20, 2);
    encoder0.encode((Struct) this.imageInfo, 24, false);
    encoder0.encode(this.releaseCallback, 32, false, ImageReleaseCallback.MANAGER);
  }
}
