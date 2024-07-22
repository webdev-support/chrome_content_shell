package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class VideoCaptureFormat {
  final int mFramerate;
  int mHeight;
  final int mPixelFormat;
  int mWidth;

  @Retention(RetentionPolicy.SOURCE)
  public @interface Format {}

  public VideoCaptureFormat(int width, int height, int framerate, int pixelformat) {
    this.mWidth = width;
    this.mHeight = height;
    this.mFramerate = framerate;
    this.mPixelFormat = pixelformat;
  }

  public int getWidth() {
    return this.mWidth;
  }

  public int getHeight() {
    return this.mHeight;
  }

  public int getFramerate() {
    return this.mFramerate;
  }

  public int getPixelFormat() {
    return this.mPixelFormat;
  }
}
