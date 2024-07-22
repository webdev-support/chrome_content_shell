package org.chromium.ui.listmenu;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.ImageViewCompat;
import com.example.chromium_content_view.R;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.ui.modelutil.PropertyKey;
import org.chromium.ui.modelutil.PropertyModel;

public class ListMenuItemViewBinder {

  public static void binder(PropertyModel model, View view, PropertyKey propertyKey) {
    TextView textView = (TextView) view.findViewById(R.id.menu_item_text);
    ImageView startIcon = (ImageView) view.findViewById(R.id.menu_item_icon);
    ImageView endIcon = (ImageView) view.findViewById(R.id.menu_item_end_icon);
    if (propertyKey == ListMenuItemProperties.TITLE_ID) {
      int titleId = model.get(ListMenuItemProperties.TITLE_ID);
      if (titleId != 0) {
        textView.setText(titleId);
      }
    } else if (propertyKey == ListMenuItemProperties.TITLE) {
      CharSequence title = (CharSequence) model.get(ListMenuItemProperties.TITLE);
      if (title != null) {
        textView.setText(title);
      }
    } else if (propertyKey == ListMenuItemProperties.CONTENT_DESCRIPTION) {
      textView.setContentDescription(
          (CharSequence) model.get(ListMenuItemProperties.CONTENT_DESCRIPTION));
    } else {
      if (propertyKey == ListMenuItemProperties.START_ICON_ID
          || propertyKey == ListMenuItemProperties.END_ICON_ID) {
        int id = model.get((PropertyModel.ReadableIntPropertyKey) propertyKey);
        Drawable drawable = id != 0 ? AppCompatResources.getDrawable(view.getContext(), id) : null;
        boolean keepStartIconSpacing =
            model.get(ListMenuItemProperties.KEEP_START_ICON_SPACING_WHEN_HIDDEN);
        if (propertyKey == ListMenuItemProperties.START_ICON_ID) {
          setStartIcon(startIcon, endIcon, drawable, keepStartIconSpacing);
        } else {
          setEndIcon(startIcon, endIcon, drawable, keepStartIconSpacing);
        }
      } else if (propertyKey == ListMenuItemProperties.START_ICON_DRAWABLE) {
        setStartIcon(
            startIcon,
            endIcon,
            (Drawable) model.get(ListMenuItemProperties.START_ICON_DRAWABLE),
            model.get(ListMenuItemProperties.KEEP_START_ICON_SPACING_WHEN_HIDDEN));
      } else if (propertyKey != ListMenuItemProperties.GROUP_ID
          && propertyKey != ListMenuItemProperties.MENU_ITEM_ID
          && propertyKey != ListMenuItemProperties.CLICK_LISTENER
          && propertyKey != ListMenuItemProperties.INTENT) {
        if (propertyKey == ListMenuItemProperties.KEEP_START_ICON_SPACING_WHEN_HIDDEN) {
          if (startIcon.getVisibility() != 0) {
            hideStartIcon(
                startIcon, model.get(ListMenuItemProperties.KEEP_START_ICON_SPACING_WHEN_HIDDEN));
          }
        } else if (propertyKey == ListMenuItemProperties.ENABLED) {
          textView.setEnabled(model.get(ListMenuItemProperties.ENABLED));
          startIcon.setEnabled(model.get(ListMenuItemProperties.ENABLED));
          endIcon.setEnabled(model.get(ListMenuItemProperties.ENABLED));
        } else if (propertyKey == ListMenuItemProperties.ICON_TINT_COLOR_STATE_LIST_ID) {
          int tintColorId = model.get(ListMenuItemProperties.ICON_TINT_COLOR_STATE_LIST_ID);
          if (tintColorId != 0) {
            ImageViewCompat.setImageTintList(
                startIcon,
                AppCompatResources.getColorStateList(
                    view.getContext(),
                    model.get(ListMenuItemProperties.ICON_TINT_COLOR_STATE_LIST_ID)));
            ImageViewCompat.setImageTintList(
                endIcon,
                AppCompatResources.getColorStateList(
                    view.getContext(),
                    model.get(ListMenuItemProperties.ICON_TINT_COLOR_STATE_LIST_ID)));
            return;
          }
          ImageViewCompat.setImageTintList(startIcon, null);
          ImageViewCompat.setImageTintList(endIcon, null);
        } else if (propertyKey == ListMenuItemProperties.TEXT_APPEARANCE_ID) {
          ApiCompatibilityUtils.setTextAppearance(
              textView, model.get(ListMenuItemProperties.TEXT_APPEARANCE_ID));
        } else if (propertyKey == ListMenuItemProperties.IS_TEXT_ELLIPSIZED_AT_END) {
          if (model.get(ListMenuItemProperties.IS_TEXT_ELLIPSIZED_AT_END)) {
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            return;
          }
          textView.setEllipsize(null);
        } else {
          throw new AssertionError(
              "Supplied propertyKey not implemented in ListMenuItemProperties.");
        }
      }
    }
  }

  private static void setStartIcon(
      ImageView startIcon, ImageView endIcon, Drawable drawable, boolean keepStartIconSpacing) {
    if (drawable != null) {
      startIcon.setImageDrawable(drawable);
      startIcon.setVisibility(0);
      hideEndIcon(endIcon);
      return;
    }
    hideStartIcon(startIcon, keepStartIconSpacing);
  }

  private static void setEndIcon(
      ImageView startIcon, ImageView endIcon, Drawable drawable, boolean keepStartIconSpacing) {
    if (drawable != null) {
      endIcon.setImageDrawable(drawable);
      endIcon.setVisibility(0);
      hideStartIcon(startIcon, keepStartIconSpacing);
      return;
    }
    hideEndIcon(endIcon);
  }

  private static void hideStartIcon(ImageView startIcon, boolean keepIconSpacing) {
    startIcon.setImageDrawable(null);
    startIcon.setVisibility(keepIconSpacing ? 4 : 8);
  }

  private static void hideEndIcon(ImageView endIcon) {
    endIcon.setImageDrawable(null);
    endIcon.setVisibility(8);
  }
}
