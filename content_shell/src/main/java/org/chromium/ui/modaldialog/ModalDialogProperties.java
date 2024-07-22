package org.chromium.ui.modaldialog;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.ui.modelutil.PropertyKey;
import org.chromium.ui.modelutil.PropertyModel;

public class ModalDialogProperties {
  public static final PropertyKey[] ALL_KEYS;
  public static final PropertyModel.WritableObjectPropertyKey<OnBackPressedCallback>
      APP_MODAL_DIALOG_BACK_PRESS_HANDLER;
  public static final PropertyModel.ReadableObjectPropertyKey<ModalDialogButtonSpec[]>
      BUTTON_GROUP_BUTTON_SPEC_LIST;
  public static final PropertyModel.ReadableIntPropertyKey BUTTON_STYLES;
  public static final PropertyModel.WritableLongPropertyKey BUTTON_TAP_PROTECTION_PERIOD_MS;
  public static final PropertyModel.WritableBooleanPropertyKey CANCEL_ON_TOUCH_OUTSIDE;
  public static final PropertyModel.ReadableObjectPropertyKey<String> CONTENT_DESCRIPTION;
  public static final PropertyModel.ReadableObjectPropertyKey<Controller> CONTROLLER;
  public static final PropertyModel.WritableObjectPropertyKey<View> CUSTOM_BUTTON_BAR_VIEW;
  public static final PropertyModel.WritableObjectPropertyKey<View> CUSTOM_VIEW;
  public static final PropertyModel.ReadableIntPropertyKey DIALOG_STYLES;
  public static final PropertyModel.ReadableBooleanPropertyKey FILTER_TOUCH_FOR_SECURITY;
  public static final PropertyModel.WritableBooleanPropertyKey FOCUS_DIALOG;
  public static final PropertyModel.WritableObjectPropertyKey<CharSequence> FOOTER_MESSAGE;
  public static final PropertyModel.WritableObjectPropertyKey<CharSequence> MESSAGE_PARAGRAPH_1;
  public static final PropertyModel.WritableObjectPropertyKey<CharSequence> MESSAGE_PARAGRAPH_2;
  public static final PropertyModel.WritableObjectPropertyKey<String>
      NEGATIVE_BUTTON_CONTENT_DESCRIPTION;
  public static final PropertyModel.WritableBooleanPropertyKey NEGATIVE_BUTTON_DISABLED;
  public static final PropertyModel.WritableObjectPropertyKey<String> NEGATIVE_BUTTON_TEXT;
  public static final PropertyModel.WritableObjectPropertyKey<String>
      POSITIVE_BUTTON_CONTENT_DESCRIPTION;
  public static final PropertyModel.WritableBooleanPropertyKey POSITIVE_BUTTON_DISABLED;
  public static final PropertyModel.WritableObjectPropertyKey<String> POSITIVE_BUTTON_TEXT;
  public static final PropertyModel.WritableObjectPropertyKey<String> TITLE;
  public static final PropertyModel.WritableObjectPropertyKey<Drawable> TITLE_ICON;
  public static final PropertyModel.WritableIntPropertyKey TITLE_MAX_LINES;
  public static final PropertyModel.WritableBooleanPropertyKey TITLE_SCROLLABLE;
  public static final PropertyModel.ReadableObjectPropertyKey<Runnable> TOUCH_FILTERED_CALLBACK;

  @Retention(RetentionPolicy.SOURCE)
  public @interface ButtonStyles {
    public static final int PRIMARY_FILLED_NEGATIVE_OUTLINE = 1;
    public static final int PRIMARY_OUTLINE_NEGATIVE_FILLED = 2;
    public static final int PRIMARY_OUTLINE_NEGATIVE_OUTLINE = 0;
  }

  @Retention(RetentionPolicy.SOURCE)
  public @interface ButtonType {
    public static final int NEGATIVE = 1;
    public static final int POSITIVE = 0;
    public static final int POSITIVE_EPHEMERAL = 3;
    public static final int TITLE_ICON = 2;
  }

  public interface Controller {
    void onClick(PropertyModel propertyModel, int i);

    void onDismiss(PropertyModel propertyModel, int i);
  }

  @Retention(RetentionPolicy.SOURCE)
  public @interface DialogStyles {
    public static final int DIALOG_WHEN_LARGE = 3;
    public static final int FULLSCREEN_DARK_DIALOG = 2;
    public static final int FULLSCREEN_DIALOG = 1;
    public static final int NORMAL = 0;
  }

  public static class ModalDialogButtonSpec {
    private final int mButtonType;
    private final String mContentDescription;
    private final String mText;

    public ModalDialogButtonSpec(int buttonType, String buttonText) {
      this(buttonType, buttonText, buttonText);
    }

    public ModalDialogButtonSpec(
        int buttonType, String buttonText, String buttonContentDescription) {
      this.mButtonType = buttonType;
      this.mText = buttonText;
      this.mContentDescription = buttonContentDescription;
    }

    public int getButtonType() {
      return this.mButtonType;
    }

    public String getText() {
      return this.mText;
    }

    public String getContentDescription() {
      return this.mContentDescription;
    }
  }

  static {
    PropertyModel.ReadableObjectPropertyKey<Controller> readableObjectPropertyKey =
        new PropertyModel.ReadableObjectPropertyKey<>();
    CONTROLLER = readableObjectPropertyKey;
    PropertyModel.ReadableObjectPropertyKey<String> readableObjectPropertyKey2 =
        new PropertyModel.ReadableObjectPropertyKey<>();
    CONTENT_DESCRIPTION = readableObjectPropertyKey2;
    PropertyModel.WritableObjectPropertyKey<String> writableObjectPropertyKey =
        new PropertyModel.WritableObjectPropertyKey<>();
    TITLE = writableObjectPropertyKey;
    PropertyModel.WritableIntPropertyKey writableIntPropertyKey =
        new PropertyModel.WritableIntPropertyKey();
    TITLE_MAX_LINES = writableIntPropertyKey;
    PropertyModel.WritableObjectPropertyKey<Drawable> writableObjectPropertyKey2 =
        new PropertyModel.WritableObjectPropertyKey<>();
    TITLE_ICON = writableObjectPropertyKey2;
    PropertyModel.WritableObjectPropertyKey<CharSequence> writableObjectPropertyKey3 =
        new PropertyModel.WritableObjectPropertyKey<>();
    MESSAGE_PARAGRAPH_1 = writableObjectPropertyKey3;
    PropertyModel.WritableObjectPropertyKey<CharSequence> writableObjectPropertyKey4 =
        new PropertyModel.WritableObjectPropertyKey<>();
    MESSAGE_PARAGRAPH_2 = writableObjectPropertyKey4;
    PropertyModel.WritableObjectPropertyKey<View> writableObjectPropertyKey5 =
        new PropertyModel.WritableObjectPropertyKey<>();
    CUSTOM_VIEW = writableObjectPropertyKey5;
    PropertyModel.WritableObjectPropertyKey<View> writableObjectPropertyKey6 =
        new PropertyModel.WritableObjectPropertyKey<>();
    CUSTOM_BUTTON_BAR_VIEW = writableObjectPropertyKey6;
    PropertyModel.WritableObjectPropertyKey<String> writableObjectPropertyKey7 =
        new PropertyModel.WritableObjectPropertyKey<>();
    POSITIVE_BUTTON_TEXT = writableObjectPropertyKey7;
    PropertyModel.WritableObjectPropertyKey<String> writableObjectPropertyKey8 =
        new PropertyModel.WritableObjectPropertyKey<>();
    POSITIVE_BUTTON_CONTENT_DESCRIPTION = writableObjectPropertyKey8;
    PropertyModel.WritableBooleanPropertyKey writableBooleanPropertyKey =
        new PropertyModel.WritableBooleanPropertyKey();
    POSITIVE_BUTTON_DISABLED = writableBooleanPropertyKey;
    PropertyModel.WritableObjectPropertyKey<String> writableObjectPropertyKey9 =
        new PropertyModel.WritableObjectPropertyKey<>();
    NEGATIVE_BUTTON_TEXT = writableObjectPropertyKey9;
    PropertyModel.WritableObjectPropertyKey<String> writableObjectPropertyKey10 =
        new PropertyModel.WritableObjectPropertyKey<>();
    NEGATIVE_BUTTON_CONTENT_DESCRIPTION = writableObjectPropertyKey10;
    PropertyModel.WritableBooleanPropertyKey writableBooleanPropertyKey2 =
        new PropertyModel.WritableBooleanPropertyKey();
    NEGATIVE_BUTTON_DISABLED = writableBooleanPropertyKey2;
    PropertyModel.WritableObjectPropertyKey<CharSequence> writableObjectPropertyKey11 =
        new PropertyModel.WritableObjectPropertyKey<>();
    FOOTER_MESSAGE = writableObjectPropertyKey11;
    PropertyModel.WritableBooleanPropertyKey writableBooleanPropertyKey3 =
        new PropertyModel.WritableBooleanPropertyKey();
    CANCEL_ON_TOUCH_OUTSIDE = writableBooleanPropertyKey3;
    PropertyModel.ReadableBooleanPropertyKey readableBooleanPropertyKey =
        new PropertyModel.ReadableBooleanPropertyKey();
    FILTER_TOUCH_FOR_SECURITY = readableBooleanPropertyKey;
    PropertyModel.ReadableObjectPropertyKey<Runnable> readableObjectPropertyKey3 =
        new PropertyModel.ReadableObjectPropertyKey<>();
    TOUCH_FILTERED_CALLBACK = readableObjectPropertyKey3;
    PropertyModel.ReadableObjectPropertyKey<ModalDialogButtonSpec[]> readableObjectPropertyKey4 =
        new PropertyModel.ReadableObjectPropertyKey<>();
    BUTTON_GROUP_BUTTON_SPEC_LIST = readableObjectPropertyKey4;
    PropertyModel.WritableBooleanPropertyKey writableBooleanPropertyKey4 =
        new PropertyModel.WritableBooleanPropertyKey();
    TITLE_SCROLLABLE = writableBooleanPropertyKey4;
    PropertyModel.ReadableIntPropertyKey readableIntPropertyKey =
        new PropertyModel.ReadableIntPropertyKey();
    BUTTON_STYLES = readableIntPropertyKey;
    PropertyModel.ReadableIntPropertyKey readableIntPropertyKey2 =
        new PropertyModel.ReadableIntPropertyKey();
    DIALOG_STYLES = readableIntPropertyKey2;
    PropertyModel.WritableBooleanPropertyKey writableBooleanPropertyKey5 =
        new PropertyModel.WritableBooleanPropertyKey();
    FOCUS_DIALOG = writableBooleanPropertyKey5;
    PropertyModel.WritableObjectPropertyKey<OnBackPressedCallback> writableObjectPropertyKey12 =
        new PropertyModel.WritableObjectPropertyKey<>();
    APP_MODAL_DIALOG_BACK_PRESS_HANDLER = writableObjectPropertyKey12;
    PropertyModel.WritableLongPropertyKey writableLongPropertyKey =
        new PropertyModel.WritableLongPropertyKey();
    BUTTON_TAP_PROTECTION_PERIOD_MS = writableLongPropertyKey;
    ALL_KEYS =
        new PropertyKey[] {
          readableObjectPropertyKey,
          readableObjectPropertyKey2,
          writableObjectPropertyKey,
          writableIntPropertyKey,
          writableObjectPropertyKey2,
          writableObjectPropertyKey3,
          writableObjectPropertyKey4,
          writableObjectPropertyKey5,
          writableObjectPropertyKey6,
          writableObjectPropertyKey7,
          writableObjectPropertyKey8,
          writableBooleanPropertyKey,
          writableObjectPropertyKey9,
          writableObjectPropertyKey10,
          writableBooleanPropertyKey2,
          writableObjectPropertyKey11,
          writableBooleanPropertyKey3,
          readableObjectPropertyKey4,
          readableObjectPropertyKey3,
          readableBooleanPropertyKey,
          writableBooleanPropertyKey4,
          readableIntPropertyKey,
          readableIntPropertyKey2,
          writableBooleanPropertyKey5,
          writableObjectPropertyKey12,
          writableLongPropertyKey
        };
  }
}
