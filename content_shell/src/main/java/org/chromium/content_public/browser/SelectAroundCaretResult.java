package org.chromium.content_public.browser;

public class SelectAroundCaretResult {
  private final int mExtendedEndAdjust;
  private final int mExtendedStartAdjust;
  private final int mWordEndAdjust;
  private final int mWordStartAdjust;

  public int getExtendedStartAdjust() {
    return this.mExtendedStartAdjust;
  }

  public int getExtendedEndAdjust() {
    return this.mExtendedEndAdjust;
  }

  public int getWordStartAdjust() {
    return this.mWordStartAdjust;
  }

  public int getWordEndAdjust() {
    return this.mWordEndAdjust;
  }

  public SelectAroundCaretResult(
      int extendedStartAdjust, int extendedEndAdjust, int wordStartAdjust, int wordEndAdjust) {
    this.mExtendedStartAdjust = extendedStartAdjust;
    this.mExtendedEndAdjust = extendedEndAdjust;
    this.mWordStartAdjust = wordStartAdjust;
    this.mWordEndAdjust = wordEndAdjust;
  }
}
