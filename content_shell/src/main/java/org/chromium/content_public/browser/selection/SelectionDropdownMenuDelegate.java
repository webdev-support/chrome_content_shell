package org.chromium.content_public.browser.selection;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import org.chromium.ui.modelutil.MVCListAdapter;
import org.chromium.ui.modelutil.PropertyModel;

public interface SelectionDropdownMenuDelegate {

  @FunctionalInterface
  public interface ItemClickListener {
    void onItemClick(PropertyModel propertyModel);
  }

  void dismiss();

  View.OnClickListener getClickListener(PropertyModel propertyModel);

  MVCListAdapter.ListItem getDivider();

  int getGroupId(PropertyModel propertyModel);

  int getItemId(PropertyModel propertyModel);

  Intent getItemIntent(PropertyModel propertyModel);

  MVCListAdapter.ListItem getMenuItem(
      String str,
      String str2,
      int i,
      int i2,
      Drawable drawable,
      boolean z,
      boolean z2,
      boolean z3,
      View.OnClickListener onClickListener,
      Intent intent);

  void show(
      Context context,
      View view,
      MVCListAdapter.ModelList modelList,
      ItemClickListener itemClickListener,
      int i,
      int i2);
}
