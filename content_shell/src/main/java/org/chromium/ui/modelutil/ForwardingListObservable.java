package org.chromium.ui.modelutil;

public class ForwardingListObservable<P> extends ListObservableImpl<P>
    implements ListObservable.ListObserver<P> {
  @Override
  public void onItemRangeInserted(ListObservable source, int index, int count) {
    notifyItemRangeInserted(index, count);
  }

  @Override
  public void onItemRangeRemoved(ListObservable source, int index, int count) {
    notifyItemRangeRemoved(index, count);
  }

  @Override
  public void onItemRangeChanged(ListObservable<P> source, int index, int count, P payload) {
    notifyItemRangeChanged(index, count, payload);
  }

  @Override
  public void onItemMoved(ListObservable source, int fromIndex, int toIndex) {
    notifyItemMoved(fromIndex, toIndex);
  }
}
