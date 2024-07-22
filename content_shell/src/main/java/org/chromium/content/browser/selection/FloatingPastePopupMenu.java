package org.chromium.content.browser.selection;

import android.content.Context;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.chromium_content_view.R;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import org.chromium.content_public.browser.SelectionMenuGroup;
import org.chromium.content_public.browser.selection.SelectionActionMenuDelegate;
import org.chromium.ui.base.DeviceFormFactor;

public class FloatingPastePopupMenu implements PastePopupMenu {

  private ActionMode mActionMode;
  private final Context mContext;
  private final Map<MenuItem, View.OnClickListener> mCustomMenuItemClickListeners = new HashMap();
  private final PastePopupMenuDelegate mDelegate;
  private final View mParent;
  private final SelectionActionMenuDelegate mSelectionActionMenuDelegate;
  private Rect mSelectionRect;

  public FloatingPastePopupMenu(
      Context context,
      View parent,
      PastePopupMenuDelegate delegate,
      SelectionActionMenuDelegate selectionActionMenuDelegate) {
    this.mParent = parent;
    this.mDelegate = delegate;
    this.mContext = context;
    this.mSelectionActionMenuDelegate = selectionActionMenuDelegate;
  }

  @Override
  public void show(Rect selectionRect) {
    this.mSelectionRect = selectionRect;
    ActionMode actionMode = this.mActionMode;
    if (actionMode != null) {
      actionMode.invalidateContentRect();
    } else {
      ensureActionMode();
    }
  }

  @Override
  public void hide() {
    ActionMode actionMode = this.mActionMode;
    if (actionMode != null) {
      actionMode.finish();
      this.mActionMode = null;
    }
  }

  private void ensureActionMode() {
    ActionMode actionMode;
    if (this.mActionMode == null
        && (actionMode = this.mParent.startActionMode(new ActionModeCallback(), 1)) != null) {
      LGEmailActionModeWorkaroundImpl.runIfNecessary(this.mContext, actionMode);
      if (actionMode.getType() != 1) {
        throw new AssertionError();
      }
      this.mActionMode = actionMode;
    }
  }

  public class ActionModeCallback extends ActionMode.Callback2 {
    private ActionModeCallback() {}

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
      createPasteMenu(mode, menu);
      return true;
    }

    private void createPasteMenu(ActionMode mode, Menu menu) {
      String str;
      if (DeviceFormFactor.isNonMultiDisplayContextOnTablet(FloatingPastePopupMenu.this.mContext)) {
        str =
            FloatingPastePopupMenu.this.mContext.getString(R.string.actionbar_textselection_title);
      } else {
        str = null;
      }
      mode.setTitle(str);
      mode.setSubtitle((CharSequence) null);
      SelectActionMenuHelper.SelectActionMenuDelegate actionMenuDelegate =
          new SelectActionMenuHelper.SelectActionMenuDelegate() {
            @Override
            public boolean canCut() {
              return false;
            }

            @Override
            public boolean canCopy() {
              return false;
            }

            @Override
            public boolean canPaste() {
              return FloatingPastePopupMenu.this.mDelegate.canPaste();
            }

            @Override
            public boolean canShare() {
              return false;
            }

            @Override
            public boolean canSelectAll() {
              return FloatingPastePopupMenu.this.mDelegate.canSelectAll();
            }

            @Override
            public boolean canWebSearch() {
              return false;
            }

            @Override
            public boolean canPasteAsPlainText() {
              return FloatingPastePopupMenu.this.mDelegate.canPasteAsPlainText();
            }
          };
      SortedSet<SelectionMenuGroup> nonSelectionMenuItems =
          SelectActionMenuHelper.getNonSelectionMenuItems(
              FloatingPastePopupMenu.this.mContext,
              actionMenuDelegate,
              FloatingPastePopupMenu.this.mSelectionActionMenuDelegate);
      SelectionPopupControllerImpl.initializeActionMenu(
          FloatingPastePopupMenu.this.mContext,
          nonSelectionMenuItems,
          menu,
          FloatingPastePopupMenu.this.mCustomMenuItemClickListeners,
          null);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
      FloatingPastePopupMenu.this.mCustomMenuItemClickListeners.clear();
      return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
      View.OnClickListener customMenuItemClickListener =
          (View.OnClickListener)
              FloatingPastePopupMenu.this.mCustomMenuItemClickListeners.get(item);
      if (customMenuItemClickListener != null) {
        customMenuItemClickListener.onClick(FloatingPastePopupMenu.this.mParent);
        return true;
      }
      int id = item.getItemId();
      if (id == R.id.select_action_menu_paste) {
        FloatingPastePopupMenu.this.mDelegate.paste();
        mode.finish();
        return true;
      } else if (id == R.id.select_action_menu_paste_as_plain_text) {
        FloatingPastePopupMenu.this.mDelegate.pasteAsPlainText();
        mode.finish();
        return true;
      } else if (id == R.id.select_action_menu_select_all) {
        FloatingPastePopupMenu.this.mDelegate.selectAll();
        mode.finish();
        return true;
      } else {
        return true;
      }
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode mode) {
      FloatingPastePopupMenu.this.mActionMode = null;
    }

    @Override // android.view.ActionMode.Callback2
    public void onGetContentRect(ActionMode mode, View view, Rect outRect) {
      outRect.set(FloatingPastePopupMenu.this.mSelectionRect);
    }
  }
}
