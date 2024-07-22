package org.chromium.content.browser.accessibility.captioning;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;

public class CaptioningStyle {
  private Integer mBackgroundColor;
  private Integer mEdgeColor;
  private Integer mEdgeType;
  private Integer mForegroundColor;
  private Typeface mTypeface;
  private Integer mWindowColor;

  public CaptioningStyle(
      Integer backgroundColor,
      Integer edgeColor,
      Integer edgeType,
      Integer foregroundColor,
      Integer windowColor,
      Typeface typeface) {
    this.mBackgroundColor = backgroundColor;
    this.mEdgeColor = edgeColor;
    this.mEdgeType = edgeType;
    this.mForegroundColor = foregroundColor;
    this.mWindowColor = windowColor;
    this.mTypeface = typeface;
  }

  public Integer getBackgroundColor() {
    return this.mBackgroundColor;
  }

  public Integer getEdgeColor() {
    return this.mEdgeColor;
  }

  public Integer getEdgeType() {
    return this.mEdgeType;
  }

  public Integer getForegroundColor() {
    return this.mForegroundColor;
  }

  public Integer getWindowColor() {
    return this.mWindowColor;
  }

  public Typeface getTypeface() {
    return this.mTypeface;
  }

  public static CaptioningStyle createFrom(CaptioningManager.CaptionStyle captionStyle) {
    if (captionStyle == null) {
      return new CaptioningStyle(null, null, null, null, null, null);
    }
    Integer backgroundColor = null;
    Integer edgeColor = null;
    Integer edgeType = null;
    Integer foregroundColor = null;
    Integer windowColor = null;
    if (captionStyle.hasBackgroundColor()) {
      backgroundColor = Integer.valueOf(captionStyle.backgroundColor);
    }
    if (captionStyle.hasEdgeColor()) {
      edgeColor = Integer.valueOf(captionStyle.edgeColor);
    }
    if (captionStyle.hasEdgeType()) {
      edgeType = Integer.valueOf(captionStyle.edgeType);
    }
    if (captionStyle.hasForegroundColor()) {
      foregroundColor = Integer.valueOf(captionStyle.foregroundColor);
    }
    if (captionStyle.hasWindowColor()) {
      windowColor = Integer.valueOf(captionStyle.windowColor);
    }
    return new CaptioningStyle(
        backgroundColor,
        edgeColor,
        edgeType,
        foregroundColor,
        windowColor,
        captionStyle.getTypeface());
  }
}
