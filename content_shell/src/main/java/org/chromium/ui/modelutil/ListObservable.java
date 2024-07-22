package org.chromium.ui.modelutil;

public interface ListObservable<P> {
  void addObserver(ListObserver<P> listObserver);

  void removeObserver(ListObserver<P> listObserver);

  public interface ListObserver<P> {
    default void onItemRangeInserted(ListObservable source, int index, int count) {}

    default void onItemRangeRemoved(ListObservable source, int index, int count) {}

    default void onItemRangeChanged(ListObservable<P> source, int index, int count, P payload) {}

    default void onItemMoved(ListObservable source, int curIndex, int newIndex) {}
  }
}
