package org.chromium.ui.modelutil;

import android.view.View;
import android.view.ViewGroup;

public interface MVCListAdapter {

  public static class ModelList extends ListModelBase<ListItem, Void> {}

  public interface ViewBuilder<T extends View> {
    T buildView(ViewGroup viewGroup);
  }

  <T extends View> void registerType(
      int i,
      ViewBuilder<T> viewBuilder,
      PropertyModelChangeProcessor.ViewBinder<PropertyModel, T, PropertyKey> viewBinder);

  public static class ListItem {
    public final PropertyModel model;
    public final int type;

    public ListItem(int type, PropertyModel model) {
      this.type = type;
      this.model = model;
    }
  }
}
