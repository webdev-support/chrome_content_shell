package org.chromium.ui;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import org.chromium.ui.widget.RectProvider;

public class DropdownPopupWindow {
  private DropdownPopupWindowInterface mPopup;

  public DropdownPopupWindow(Context context, View anchorView) {
    this(context, anchorView, null);
  }

  public DropdownPopupWindow(
      Context context, View anchorView, RectProvider visibleWebContentsRectProvider) {
    this.mPopup = new DropdownPopupWindowImpl(context, anchorView, visibleWebContentsRectProvider);
  }

  public void setAdapter(ListAdapter adapter) {
    this.mPopup.setAdapter(adapter);
  }

  public void setInitialSelection(int initialSelection) {
    this.mPopup.setInitialSelection(initialSelection);
  }

  public void show() {
    this.mPopup.show();
  }

  public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
    this.mPopup.setOnDismissListener(listener);
  }

  public void setRtl(boolean isRtl) {
    this.mPopup.setRtl(isRtl);
  }

  public void disableHideOnOutsideTap() {
    this.mPopup.disableHideOnOutsideTap();
  }

  public void setContentDescriptionForAccessibility(CharSequence description) {
    this.mPopup.setContentDescriptionForAccessibility(description);
  }

  public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
    this.mPopup.setOnItemClickListener(clickListener);
  }

  public void postShow() {
    this.mPopup.postShow();
  }

  public void dismiss() {
    this.mPopup.dismiss();
  }

  public ListView getListView() {
    return this.mPopup.getListView();
  }

  public boolean isShowing() {
    return this.mPopup.isShowing();
  }
}
