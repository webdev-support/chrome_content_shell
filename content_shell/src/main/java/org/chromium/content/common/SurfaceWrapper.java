package org.chromium.content.common;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Surface;
import android.view.SurfaceControl;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
public class SurfaceWrapper implements Parcelable {

  public static final Parcelable.Creator<SurfaceWrapper> CREATOR =
      new Parcelable.Creator<SurfaceWrapper>() {
        @Override
        public SurfaceWrapper createFromParcel(Parcel in) {
          boolean wrapsSurface = in.readInt() == 1;
          if (wrapsSurface) {
            Surface surface = (Surface) Surface.CREATOR.createFromParcel(in);
            boolean canBeUsedWithSurfaceControl = in.readInt() == 1;
            return new SurfaceWrapper(surface, canBeUsedWithSurfaceControl);
          } else if (Build.VERSION.SDK_INT >= 29) {
            SurfaceControl surfaceControl =
                (SurfaceControl) SurfaceControl.CREATOR.createFromParcel(in);
            return new SurfaceWrapper(surfaceControl);
          } else {
            throw new RuntimeException("not reached");
          }
        }

        @Override
        public SurfaceWrapper[] newArray(int size) {
          return new SurfaceWrapper[size];
        }
      };
  private final boolean mCanBeUsedWithSurfaceControl;
  private Surface mSurface;
  private SurfaceControl mSurfaceControl;
  private final boolean mWrapsSurface;

  private SurfaceWrapper(Surface surface, boolean canBeUsedWithSurfaceControl) {
    this.mWrapsSurface = true;
    this.mSurface = surface;
    this.mCanBeUsedWithSurfaceControl = canBeUsedWithSurfaceControl;
    this.mSurfaceControl = null;
  }

  private SurfaceWrapper(SurfaceControl surfaceControl) {
    this.mWrapsSurface = false;
    this.mSurface = null;
    this.mCanBeUsedWithSurfaceControl = true;
    this.mSurfaceControl = surfaceControl;
  }

  private boolean getWrapsSurface() {
    return this.mWrapsSurface;
  }

  private Surface takeSurface() {
    if (!this.mWrapsSurface) {
      throw new AssertionError();
    }
    Surface surface = this.mSurface;
    this.mSurface = null;
    return surface;
  }

  private boolean canBeUsedWithSurfaceControl() {
    return this.mCanBeUsedWithSurfaceControl;
  }

  private SurfaceControl takeSurfaceControl() {
    if (this.mWrapsSurface) {
      throw new AssertionError();
    }
    SurfaceControl sc = this.mSurfaceControl;
    this.mSurfaceControl = null;
    return sc;
  }

  @Override // android.os.Parcelable
  public int describeContents() {
    return 0;
  }

  @Override // android.os.Parcelable
  public void writeToParcel(Parcel out, int flags) {
    out.writeInt(this.mWrapsSurface ? 1 : 0);
    if (this.mWrapsSurface) {
      this.mSurface.writeToParcel(out, 0);
      out.writeInt(this.mCanBeUsedWithSurfaceControl ? 1 : 0);
      return;
    }
    this.mSurfaceControl.writeToParcel(out, 0);
  }

  private static SurfaceWrapper create(Surface surface, boolean canBeUsedWithSurfaceControl) {
    return new SurfaceWrapper(surface, canBeUsedWithSurfaceControl);
  }

  private static SurfaceWrapper createFromSurfaceControl(SurfaceControl surfaceControl) {
    return new SurfaceWrapper(surfaceControl);
  }
}
