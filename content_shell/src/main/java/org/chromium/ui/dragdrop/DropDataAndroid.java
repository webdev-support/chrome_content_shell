package org.chromium.ui.dragdrop;

import android.text.TextUtils;
import org.chromium.url.GURL;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class DropDataAndroid {
  public final GURL gurl;
  public final byte[] imageContent;
  public final String imageContentExtension;
  public final String imageFilename;
  public final String text;

  protected DropDataAndroid(
      String text,
      GURL gurl,
      byte[] imageContent,
      String imageContentExtension,
      String imageFilename) {
    this.text = text;
    this.gurl = gurl;
    this.imageContent = imageContent;
    this.imageContentExtension = imageContentExtension;
    this.imageFilename = imageFilename;
  }

  static DropDataAndroid create(
      String text,
      GURL gurl,
      byte[] imageContent,
      String imageContentExtension,
      String imageFilename) {
    return new DropDataAndroid(text, gurl, imageContent, imageContentExtension, imageFilename);
  }

  public boolean isPlainText() {
    return GURL.isEmptyOrInvalid(this.gurl) && !TextUtils.isEmpty(this.text);
  }

  public boolean hasLink() {
    return !GURL.isEmptyOrInvalid(this.gurl);
  }

  public boolean hasImage() {
    return (this.imageContent == null
            || TextUtils.isEmpty(this.imageContentExtension)
            || TextUtils.isEmpty(this.imageFilename))
        ? false
        : true;
  }

  public boolean hasBrowserContent() {
    return false;
  }
}
