package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.skia.mojom.BitmapN32;

public final class SerializedStaticBitmapImage extends Union {

  private AcceleratedStaticBitmapImage mAcceleratedImage;
  private BitmapN32 mBitmap;

  public static final class Tag {
    public static final int AcceleratedImage = 1;
    public static final int Bitmap = 0;
  }

  public void setBitmap(BitmapN32 bitmap) {
    this.mTag = 0;
    this.mBitmap = bitmap;
  }

  public BitmapN32 getBitmap() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mBitmap;
  }

  public void setAcceleratedImage(AcceleratedStaticBitmapImage acceleratedImage) {
    this.mTag = 1;
    this.mAcceleratedImage = acceleratedImage;
  }

  public AcceleratedStaticBitmapImage getAcceleratedImage() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mAcceleratedImage;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mBitmap, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mAcceleratedImage, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static SerializedStaticBitmapImage deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final SerializedStaticBitmapImage decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    SerializedStaticBitmapImage result = new SerializedStaticBitmapImage();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mBitmap = BitmapN32.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mAcceleratedImage = AcceleratedStaticBitmapImage.decode(decoder12);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
