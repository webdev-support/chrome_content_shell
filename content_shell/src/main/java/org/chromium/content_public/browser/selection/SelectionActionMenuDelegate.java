package org.chromium.content_public.browser.selection;

import android.content.pm.ResolveInfo;
import java.util.List;
import org.chromium.content_public.browser.SelectionMenuItem;

public interface SelectionActionMenuDelegate {
  List<ResolveInfo> filterTextProcessingActivities(List<ResolveInfo> list);

  List<SelectionMenuItem> getAdditionalNonSelectionItems();

  List<SelectionMenuItem> getAdditionalTextProcessingItems();

  void modifyDefaultMenuItems(List<SelectionMenuItem.Builder> list, boolean z, String str);
}
