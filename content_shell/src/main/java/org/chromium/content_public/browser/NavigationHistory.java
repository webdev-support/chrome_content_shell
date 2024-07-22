package org.chromium.content_public.browser;

import java.util.ArrayList;

public class NavigationHistory {
  private int mCurrentEntryIndex;
  private final ArrayList<NavigationEntry> mEntries = new ArrayList<>();

  public void addEntry(NavigationEntry entry) {
    this.mEntries.add(entry);
  }

  public void setCurrentEntryIndex(int currentEntryIndex) {
    this.mCurrentEntryIndex = currentEntryIndex;
  }

  public int getEntryCount() {
    return this.mEntries.size();
  }

  public NavigationEntry getEntryAtIndex(int index) {
    return this.mEntries.get(index);
  }

  public int getCurrentEntryIndex() {
    return this.mCurrentEntryIndex;
  }
}
