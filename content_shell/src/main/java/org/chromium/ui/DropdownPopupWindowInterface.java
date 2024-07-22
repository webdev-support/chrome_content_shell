package org.chromium.ui;

import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

public interface DropdownPopupWindowInterface {
  void disableHideOnOutsideTap();

  void dismiss();

  ListView getListView();

  boolean isShowing();

  void postShow();

  void setAdapter(ListAdapter listAdapter);

  void setContentDescriptionForAccessibility(CharSequence charSequence);

  void setInitialSelection(int i);

  void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener);

  void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener);

  void setRtl(boolean z);

  void show();
}
