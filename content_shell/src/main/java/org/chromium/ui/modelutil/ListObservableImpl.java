package org.chromium.ui.modelutil;

import java.util.Iterator;
import org.chromium.base.ObserverList;

public abstract class ListObservableImpl<P> implements ListObservable<P> {

  private final ObserverList<ListObserver<P>> mObservers = new ObserverList<>();

  @Override
  public void addObserver(ListObserver<P> observer) {
    boolean success = this.mObservers.addObserver(observer);
    if (!success) {
      throw new AssertionError();
    }
  }

  @Override
  public void removeObserver(ListObserver<P> observer) {
    boolean success = this.mObservers.removeObserver(observer);
    if (!success) {
      throw new AssertionError();
    }
  }

  protected final void notifyItemChanged(int index) {
    notifyItemRangeChanged(index, 1, null);
  }

  public final void notifyItemRangeChanged(int index, int count) {
    notifyItemRangeChanged(index, count, null);
  }

  public final void notifyItemChanged(int index, P payload) {
    notifyItemRangeChanged(index, 1, payload);
  }

  public final void notifyItemInserted(int index) {
    notifyItemRangeInserted(index, 1);
  }

  public final void notifyItemRemoved(int index) {
    notifyItemRangeRemoved(index, 1);
  }

  public void notifyItemRangeInserted(int index, int count) {
    if (count <= 0) {
      throw new AssertionError();
    }
    Iterator<ListObserver<P>> it = this.mObservers.iterator();
    while (it.hasNext()) {
      ListObserver observer = it.next();
      observer.onItemRangeInserted(this, index, count);
    }
  }

  public void notifyItemRangeRemoved(int index, int count) {
    if (count <= 0) {
      throw new AssertionError();
    }
    Iterator<ListObserver<P>> it = this.mObservers.iterator();
    while (it.hasNext()) {
      ListObserver observer = it.next();
      observer.onItemRangeRemoved(this, index, count);
    }
  }

  public void notifyItemRangeChanged(int index, int count, P payload) {
    if (count <= 0) {
      throw new AssertionError();
    }
    Iterator<ListObserver<P>> it = this.mObservers.iterator();
    while (it.hasNext()) {
      ListObserver<P> observer = it.next();
      observer.onItemRangeChanged(this, index, count, payload);
    }
  }

  public void notifyItemMoved(int curIndex, int newIndex) {
    Iterator<ListObserver<P>> it = this.mObservers.iterator();
    while (it.hasNext()) {
      ListObserver observer = it.next();
      observer.onItemMoved(this, curIndex, newIndex);
    }
  }
}
