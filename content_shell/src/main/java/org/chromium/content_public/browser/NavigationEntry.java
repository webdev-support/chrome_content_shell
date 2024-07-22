package org.chromium.content_public.browser;

import android.graphics.Bitmap;
import org.chromium.url.GURL;

public class NavigationEntry {
  private Bitmap mFavicon;
  private final int mIndex;
  private final boolean mIsInitialEntry;
  private final GURL mOriginalUrl;
  private long mTimestamp;
  private final String mTitle;
  private int mTransition;
  private final GURL mUrl;
  private final GURL mVirtualUrl;

  public NavigationEntry(
      int index,
      GURL url,
      GURL virtualUrl,
      GURL originalUrl,
      String title,
      Bitmap favicon,
      int transition,
      long timestamp,
      boolean isInitialEntry) {
    this.mIndex = index;
    this.mUrl = url;
    this.mVirtualUrl = virtualUrl;
    this.mOriginalUrl = originalUrl;
    this.mTitle = title;
    this.mFavicon = favicon;
    this.mTransition = transition;
    this.mTimestamp = timestamp;
    this.mIsInitialEntry = isInitialEntry;
  }

  public int getIndex() {
    return this.mIndex;
  }

  public GURL getUrl() {
    return this.mUrl;
  }

  public GURL getVirtualUrl() {
    return this.mVirtualUrl;
  }

  public GURL getOriginalUrl() {
    return this.mOriginalUrl;
  }

  public String getTitle() {
    return this.mTitle;
  }

  public Bitmap getFavicon() {
    return this.mFavicon;
  }

  public void updateFavicon(Bitmap favicon) {
    this.mFavicon = favicon;
  }

  public int getTransition() {
    return this.mTransition;
  }

  public long getTimestamp() {
    return this.mTimestamp;
  }

  public boolean isInitialEntry() {
    return this.mIsInitialEntry;
  }
}
