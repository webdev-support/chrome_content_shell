package org.chromium.content_public.browser;

import android.content.Intent;
import android.view.ActionMode;
import android.view.View;

public abstract class ActionModeCallback extends ActionMode.Callback2 {
  public abstract boolean onDropdownItemClicked(
      int i, int i2, Intent intent, View.OnClickListener onClickListener);
}
