package org.chromium.services.media_session;

import android.graphics.Rect;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.chromium.url.GURL;
import org.jni_zero.JNINamespace;

@JNINamespace("media_session")
public final class MediaImage {
  private List<Rect> mSizes;
  private GURL mSrc;
  private String mType;

  public MediaImage(GURL src, String type, List<Rect> sizes) {
    this.mSizes = new ArrayList();
    this.mSrc = src;
    this.mType = type;
    this.mSizes = sizes;
  }

  public GURL getSrc() {
    return this.mSrc;
  }

  public String getType() {
    return this.mType;
  }

  public List<Rect> getSizes() {
    return this.mSizes;
  }

  public void setSrc(GURL src) {
    this.mSrc = src;
  }

  public void setType(String type) {
    this.mType = type;
  }

  public void setSizes(List<Rect> sizes) {
    this.mSizes = sizes;
  }

  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj instanceof MediaImage) {
      MediaImage other = (MediaImage) obj;
      return this.mSrc.equals(other.mSrc)
          && TextUtils.equals(this.mType, other.mType)
          && this.mSizes.equals(other.mSizes);
    }
    return false;
  }

  public int hashCode() {
    int result = this.mSrc.hashCode();
    return (((result * 31) + this.mType.hashCode()) * 31) + this.mSizes.hashCode();
  }

  private static MediaImage create(GURL src, String type, Rect[] sizes) {
    return new MediaImage(src, type, Arrays.asList(sizes));
  }

  private static Rect createRect(int width, int height) {
    return new Rect(0, 0, width, height);
  }
}
