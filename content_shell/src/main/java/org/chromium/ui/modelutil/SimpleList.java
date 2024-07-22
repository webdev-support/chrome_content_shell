package org.chromium.ui.modelutil;

import java.util.Iterator;

public interface SimpleList<T> extends Iterable<T> {
  T get(int i);

  int size();

  @Override   default Iterator<T> iterator() {
    return new Iterator<T>() {
      private int mI;

      @Override       public boolean hasNext() {
        return this.mI < SimpleList.this.size();
      }

      @Override       public T next() {
        SimpleList simpleList = SimpleList.this;
        int i = this.mI;
        this.mI = i + 1;
        return (T) simpleList.get(i);
      }
    };
  }
}
