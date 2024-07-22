package org.chromium.ui.listmenu;

import org.chromium.ui.modelutil.PropertyKey;
import org.chromium.ui.modelutil.PropertyModel;

public class ListSectionDividerProperties {
  public static final PropertyKey[] ALL_KEYS;
  public static final PropertyModel.WritableIntPropertyKey LEFT_PADDING_DIMEN_ID;
  public static final PropertyModel.WritableIntPropertyKey RIGHT_PADDING_DIMEN_ID;

  static {
    PropertyModel.WritableIntPropertyKey writableIntPropertyKey =
        new PropertyModel.WritableIntPropertyKey();
    LEFT_PADDING_DIMEN_ID = writableIntPropertyKey;
    PropertyModel.WritableIntPropertyKey writableIntPropertyKey2 =
        new PropertyModel.WritableIntPropertyKey();
    RIGHT_PADDING_DIMEN_ID = writableIntPropertyKey2;
    ALL_KEYS = new PropertyKey[] {writableIntPropertyKey, writableIntPropertyKey2};
  }
}
