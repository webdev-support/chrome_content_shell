package org.chromium.ui.resources;

import android.graphics.Rect;
import org.chromium.ui.resources.statics.NinePatchData;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class ResourceFactory {

  public interface Natives {
    long createBitmapResource();

    long createNinePatchBitmapResource(
        int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);
  }

  public static long createBitmapResource(NinePatchData ninePatchData) {
    if (ninePatchData == null) {
      return ResourceFactoryJni.get().createBitmapResource();
    }
    return createNinePatchBitmapResource(ninePatchData.getPadding(), ninePatchData.getAperture());
  }

  private static long createNinePatchBitmapResource(Rect padding, Rect aperture) {
    return ResourceFactoryJni.get()
        .createNinePatchBitmapResource(
            padding.left,
            padding.top,
            padding.right,
            padding.bottom,
            aperture.left,
            aperture.top,
            aperture.right,
            aperture.bottom);
  }
}
