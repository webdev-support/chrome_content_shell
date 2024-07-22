package org.chromium.shape_detection;

import android.graphics.Bitmap;
import com.google.android.gms.vision.Frame;
import java.nio.ByteBuffer;
import org.chromium.mojo_base.BigBufferUtil;
import org.chromium.skia.mojom.BitmapN32;

public class BitmapUtils {
  public static Bitmap convertToBitmap(BitmapN32 bitmapData) {
    if (bitmapData.pixelData == null) {
      return null;
    }
    int width = bitmapData.imageInfo.width;
    int height = bitmapData.imageInfo.height;
    long numPixels = width * height;
    if (width <= 0 || height <= 0 || numPixels > 2305843009213693951L) {
      return null;
    }
    BigBufferUtil.Mapping mapping = BigBufferUtil.map(bitmapData.pixelData);
    try {
      ByteBuffer imageBuffer = mapping.getBuffer();
      if (imageBuffer.capacity() > 0) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.copyPixelsFromBuffer(imageBuffer);
        if (mapping != null) {
          mapping.close();
        }
        return bitmap;
      }
      if (mapping != null) {
        mapping.close();
      }
      return null;
    } catch (Throwable th) {
      if (mapping != null) {
        try {
          mapping.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  public static Frame convertToFrame(BitmapN32 bitmapData) {
    Bitmap bitmap = convertToBitmap(bitmapData);
    if (bitmap == null) {
      return null;
    }
    return new Frame.Builder().setBitmap(bitmap).build();
  }
}
