package org.chromium.ui.listmenu;

import android.view.View;
import org.chromium.ui.modelutil.PropertyKey;
import org.chromium.ui.modelutil.PropertyModel;

public class ListSectionDividerViewBinder {
  public static void bind(PropertyModel model, View view, PropertyKey propertyKey) {
    int rightPaddingId;
    if (propertyKey == ListSectionDividerProperties.LEFT_PADDING_DIMEN_ID) {
      int leftPaddingId = model.get(ListSectionDividerProperties.LEFT_PADDING_DIMEN_ID);
      if (leftPaddingId != 0) {
        int leftPaddingPx = view.getContext().getResources().getDimensionPixelSize(leftPaddingId);
        view.setPadding(
            leftPaddingPx, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
      }
    } else if (propertyKey == ListSectionDividerProperties.RIGHT_PADDING_DIMEN_ID
        && (rightPaddingId = model.get(ListSectionDividerProperties.RIGHT_PADDING_DIMEN_ID)) != 0) {
      int rightPaddingPx = view.getContext().getResources().getDimensionPixelSize(rightPaddingId);
      view.setPadding(
          view.getPaddingLeft(), view.getPaddingTop(), rightPaddingPx, view.getPaddingBottom());
    }
  }
}
