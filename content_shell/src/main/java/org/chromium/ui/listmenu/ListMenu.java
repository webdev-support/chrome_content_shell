package org.chromium.ui.listmenu;

import android.view.View;
import org.chromium.ui.modelutil.PropertyModel;

public interface ListMenu {

  @FunctionalInterface
  public interface Delegate {
    void onItemSelected(PropertyModel propertyModel);
  }

  void addContentViewClickRunnable(Runnable runnable);

  View getContentView();

  int getMaxItemWidth();
}
