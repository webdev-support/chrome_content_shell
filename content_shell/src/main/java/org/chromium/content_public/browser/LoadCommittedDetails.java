package org.chromium.content_public.browser;

import org.chromium.url.GURL;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
public class LoadCommittedDetails {
  private final boolean mDidReplaceEntry;
  private final int mHttpStatusCode;
  private final boolean mIsMainFrame;
  private final boolean mIsSameDocument;
  private final int mPreviousEntryIndex;
  private final GURL mPreviousMainFrameUrl;

  public LoadCommittedDetails(
      int previousEntryIndex,
      GURL previousMainFrameUrl,
      boolean didReplaceEntry,
      boolean isSameDocument,
      boolean isMainFrame,
      int httpStatusCode) {
    this.mPreviousEntryIndex = previousEntryIndex;
    this.mPreviousMainFrameUrl = previousMainFrameUrl;
    this.mDidReplaceEntry = didReplaceEntry;
    this.mIsSameDocument = isSameDocument;
    this.mIsMainFrame = isMainFrame;
    this.mHttpStatusCode = httpStatusCode;
  }

  public boolean didReplaceEntry() {
    return this.mDidReplaceEntry;
  }

  public int getPreviousEntryIndex() {
    return this.mPreviousEntryIndex;
  }

  public GURL getPreviousMainFrameUrl() {
    return this.mPreviousMainFrameUrl;
  }

  public boolean isSameDocument() {
    return this.mIsSameDocument;
  }

  public boolean isMainFrame() {
    return this.mIsMainFrame;
  }

  public int getHttpStatusCode() {
    return this.mHttpStatusCode;
  }
}
