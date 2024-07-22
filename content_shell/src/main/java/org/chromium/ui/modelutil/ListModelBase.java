package org.chromium.ui.modelutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListModelBase<T, P> extends ListObservableImpl<P> implements SimpleList<T> {
  private final List<T> mItems = new ArrayList();

  @Override
  public T get(int index) {
    return this.mItems.get(index);
  }

  @Override
  public int size() {
    return this.mItems.size();
  }

  @Override
  public Iterator<T> iterator() {
    return this.mItems.iterator();
  }

  public void add(T item) {
    this.mItems.add(item);
    notifyItemInserted(this.mItems.size() - 1);
  }

  public void add(int position, T item) {
    this.mItems.add(position, item);
    notifyItemInserted(position);
  }

  /* JADX WARN: Multi-variable type inference failed */
  public void addAll(Collection<T> items) {
    addAll(items, this.mItems.size());
  }

  public void addAll(Collection<? extends T> items, int insertionIndex) {
    this.mItems.addAll(insertionIndex, items);
    notifyItemRangeInserted(insertionIndex, items.size());
  }

  public void addAll(SimpleList<T> items) {
    addAll(items, this.mItems.size());
  }

  public void addAll(SimpleList<T> items, int insertionIndex) {
    int currentIndex = insertionIndex;
    for (T item : items) {
      this.mItems.add(currentIndex, item);
      currentIndex++;
    }
    notifyItemRangeInserted(insertionIndex, items.size());
  }

  public void remove(T item) {
    int position = this.mItems.indexOf(item);
    removeAt(position);
  }

  public T removeAt(int position) {
    T item = this.mItems.remove(position);
    notifyItemRemoved(position);
    return item;
  }

  public void removeRange(int startPosition, int count) {
    this.mItems.subList(startPosition, startPosition + count).clear();
    notifyItemRangeRemoved(startPosition, count);
  }

  public void set(T[] newItems) {
    set(Arrays.asList(newItems));
  }

  public void set(Collection<T> newItems) {
    int oldSize = this.mItems.size();
    int newSize = newItems.size();
    this.mItems.clear();
    this.mItems.addAll(newItems);
    int min = Math.min(oldSize, newSize);
    if (min > 0) {
      notifyItemRangeChanged(0, min);
    }
    if (newSize > oldSize) {
      notifyItemRangeInserted(min, newSize - oldSize);
    } else if (newSize < oldSize) {
      notifyItemRangeRemoved(min, oldSize - newSize);
    }
  }

  public void update(int index, T item) {
    this.mItems.set(index, item);
    notifyItemRangeChanged(index, 1);
  }

  public int indexOf(Object item) {
    return this.mItems.indexOf(item);
  }

  public void move(int curIndex, int newIndex) {
    T item = this.mItems.remove(curIndex);
    if (newIndex == this.mItems.size()) {
      this.mItems.add(item);
    } else {
      this.mItems.add(newIndex, item);
    }
    notifyItemMoved(curIndex, newIndex);
  }

  public void clear() {
    if (size() > 0) {
      removeRange(0, size());
    }
  }
}
