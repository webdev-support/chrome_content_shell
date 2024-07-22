package org.chromium.ui.listmenu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import org.chromium.ui.modelutil.PropertyKey;
import org.chromium.ui.modelutil.PropertyModel;

public class ListMenuItemProperties {
  public static final PropertyKey[] ALL_KEYS;
  public static final PropertyModel.WritableObjectPropertyKey<View.OnClickListener> CLICK_LISTENER;
  public static final PropertyModel.WritableObjectPropertyKey<String> CONTENT_DESCRIPTION;
  public static final PropertyModel.WritableBooleanPropertyKey ENABLED;
  public static final PropertyModel.WritableIntPropertyKey END_ICON_ID;
  public static final PropertyModel.WritableIntPropertyKey GROUP_ID;
  public static final PropertyModel.WritableIntPropertyKey ICON_TINT_COLOR_STATE_LIST_ID;
  public static final PropertyModel.WritableObjectPropertyKey<Intent> INTENT;
  public static final PropertyModel.ReadableBooleanPropertyKey IS_TEXT_ELLIPSIZED_AT_END;
  public static final PropertyModel.ReadableBooleanPropertyKey KEEP_START_ICON_SPACING_WHEN_HIDDEN;
  public static final PropertyModel.WritableIntPropertyKey MENU_ITEM_ID;
  public static final PropertyModel.WritableObjectPropertyKey<Drawable> START_ICON_DRAWABLE;
  public static final PropertyModel.WritableIntPropertyKey START_ICON_ID;
  public static final PropertyModel.ReadableIntPropertyKey TEXT_APPEARANCE_ID;
  public static final PropertyModel.WritableObjectPropertyKey<String> TITLE;
  public static final PropertyModel.WritableIntPropertyKey TITLE_ID;

  static {
    PropertyModel.WritableIntPropertyKey writableIntPropertyKey =
        new PropertyModel.WritableIntPropertyKey();
    TITLE_ID = writableIntPropertyKey;
    PropertyModel.WritableObjectPropertyKey<String> writableObjectPropertyKey =
        new PropertyModel.WritableObjectPropertyKey<>();
    TITLE = writableObjectPropertyKey;
    PropertyModel.WritableObjectPropertyKey<String> writableObjectPropertyKey2 =
        new PropertyModel.WritableObjectPropertyKey<>();
    CONTENT_DESCRIPTION = writableObjectPropertyKey2;
    PropertyModel.WritableIntPropertyKey writableIntPropertyKey2 =
        new PropertyModel.WritableIntPropertyKey();
    START_ICON_ID = writableIntPropertyKey2;
    PropertyModel.WritableObjectPropertyKey<Drawable> writableObjectPropertyKey3 =
        new PropertyModel.WritableObjectPropertyKey<>();
    START_ICON_DRAWABLE = writableObjectPropertyKey3;
    PropertyModel.WritableIntPropertyKey writableIntPropertyKey3 =
        new PropertyModel.WritableIntPropertyKey();
    END_ICON_ID = writableIntPropertyKey3;
    PropertyModel.WritableIntPropertyKey writableIntPropertyKey4 =
        new PropertyModel.WritableIntPropertyKey();
    GROUP_ID = writableIntPropertyKey4;
    PropertyModel.WritableIntPropertyKey writableIntPropertyKey5 =
        new PropertyModel.WritableIntPropertyKey();
    MENU_ITEM_ID = writableIntPropertyKey5;
    PropertyModel.WritableObjectPropertyKey<View.OnClickListener> writableObjectPropertyKey4 =
        new PropertyModel.WritableObjectPropertyKey<>();
    CLICK_LISTENER = writableObjectPropertyKey4;
    PropertyModel.WritableObjectPropertyKey<Intent> writableObjectPropertyKey5 =
        new PropertyModel.WritableObjectPropertyKey<>();
    INTENT = writableObjectPropertyKey5;
    PropertyModel.WritableBooleanPropertyKey writableBooleanPropertyKey =
        new PropertyModel.WritableBooleanPropertyKey();
    ENABLED = writableBooleanPropertyKey;
    PropertyModel.WritableIntPropertyKey writableIntPropertyKey6 =
        new PropertyModel.WritableIntPropertyKey();
    ICON_TINT_COLOR_STATE_LIST_ID = writableIntPropertyKey6;
    PropertyModel.ReadableIntPropertyKey readableIntPropertyKey =
        new PropertyModel.ReadableIntPropertyKey();
    TEXT_APPEARANCE_ID = readableIntPropertyKey;
    PropertyModel.ReadableBooleanPropertyKey readableBooleanPropertyKey =
        new PropertyModel.ReadableBooleanPropertyKey();
    IS_TEXT_ELLIPSIZED_AT_END = readableBooleanPropertyKey;
    PropertyModel.ReadableBooleanPropertyKey readableBooleanPropertyKey2 =
        new PropertyModel.ReadableBooleanPropertyKey();
    KEEP_START_ICON_SPACING_WHEN_HIDDEN = readableBooleanPropertyKey2;
    ALL_KEYS =
        new PropertyKey[] {
          writableIntPropertyKey,
          writableObjectPropertyKey,
          writableObjectPropertyKey2,
          writableIntPropertyKey2,
          writableObjectPropertyKey3,
          writableIntPropertyKey3,
          writableIntPropertyKey4,
          writableIntPropertyKey5,
          writableObjectPropertyKey4,
          writableObjectPropertyKey5,
          writableBooleanPropertyKey,
          writableIntPropertyKey6,
          readableIntPropertyKey,
          readableBooleanPropertyKey,
          readableBooleanPropertyKey2
        };
  }
}
