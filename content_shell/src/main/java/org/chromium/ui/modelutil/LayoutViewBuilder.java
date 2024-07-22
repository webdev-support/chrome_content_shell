package org.chromium.ui.modelutil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LayoutViewBuilder<T extends View> implements MVCListAdapter.ViewBuilder<T> {
  private LayoutInflater mInflater;
  private final int mLayoutResId;

  public LayoutViewBuilder(int res) {
    this.mLayoutResId = res;
  }

  @Override
  public final T buildView(ViewGroup parent) {
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(parent.getContext());
    }
    T view = (T) this.mInflater.inflate(this.mLayoutResId, parent, false);
    return view;
  }
}
