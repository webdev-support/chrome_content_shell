package org.chromium.content.browser.input;

import org.chromium.ui.DropdownItemBase;

public class SelectPopupItem extends DropdownItemBase {
  private final String mLabel;
  private final int mType;

  public SelectPopupItem(String label, int type) {
    this.mLabel = label;
    this.mType = type;
  }

  @Override
  public String getLabel() {
    return this.mLabel;
  }

  @Override
  public boolean isEnabled() {
    int i = this.mType;
    return i == 2 || i == 0;
  }

  @Override
  public boolean isGroupHeader() {
    return this.mType == 0;
  }

  public int getType() {
    return this.mType;
  }
}
