package org.chromium.content_public.browser;

import android.content.Intent;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;

public abstract class ActionModeCallbackHelper {
  public static final EmptyActionCallback EMPTY_CALLBACK = new EmptyActionCallback();
  public static final int MAX_SEARCH_QUERY_LENGTH = 1000;
  public static final int MENU_ITEM_PROCESS_TEXT = 4;
  public static final int MENU_ITEM_SHARE = 1;
  public static final int MENU_ITEM_WEB_SEARCH = 2;
  private static final String TAG = "ActionModeHelper";

  public abstract void dismissMenu();

  public abstract void finishActionMode();

  public abstract int getAllowedMenuItemIfAny(int i, int i2);

  public abstract int getAllowedMenuItemIfAny(ActionMode actionMode, MenuItem menuItem);

  public abstract RenderFrameHost getRenderFrameHost();

  public abstract String getSelectedText();

  public abstract boolean isActionModeValid();

  public abstract boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem);

  public abstract void onCreateActionMode(ActionMode actionMode, Menu menu);

  public abstract void onDestroyActionMode();

  public abstract boolean onDropdownItemClicked(
      int i, int i2, Intent intent, View.OnClickListener onClickListener);

  public abstract void onGetContentRect(ActionMode actionMode, View view, Rect rect);

  public abstract boolean onPrepareActionMode(ActionMode actionMode, Menu menu);

  public abstract void onReceivedProcessTextResult(int i, Intent intent);

  public abstract void setAllowedMenuItems(int i);

  public static String sanitizeQuery(String query, int maxLength) {
    return SelectionPopupControllerImpl.sanitizeQuery(query, maxLength);
  }

  public static class EmptyActionCallback extends ActionModeCallback {
    private EmptyActionCallback() {}

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
      return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
      return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
      return false;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode mode) {}

    @Override // android.view.ActionMode.Callback2
    public void onGetContentRect(ActionMode mode, View view, Rect outRect) {}

    @Override
    public boolean onDropdownItemClicked(
        int groupId, int id, Intent intent, View.OnClickListener clickListener) {
      return false;
    }
  }
}
