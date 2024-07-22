package org.chromium.ui.listmenu;

import android.view.View;
import org.chromium.ui.widget.RectProvider;
import org.chromium.ui.widget.ViewRectProvider;

public interface ListMenuButtonDelegate {
  ListMenu getListMenu();

  default RectProvider getRectProvider(View listMenuButton) {
    ViewRectProvider provider = new ViewRectProvider(listMenuButton);
    provider.setIncludePadding(true);
    return provider;
  }
}
