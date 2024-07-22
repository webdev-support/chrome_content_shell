package org.chromium.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ObserverList<E> implements Iterable<E> {

  private int mCount;
  private int mIterationDepth;
  private boolean mNeedsCompact;
  public final List<E> mObservers = new ArrayList();
  private boolean mEnableThreadAsserts = true;
  private final ThreadUtils.ThreadChecker mThreadChecker = new ThreadUtils.ThreadChecker();

  public interface RewindableIterator<E> extends Iterator<E> {
    void rewind();
  }

  public void disableThreadAsserts() {
    this.mEnableThreadAsserts = false;
  }

  public boolean addObserver(E obs) {
    if (this.mEnableThreadAsserts) {
      this.mThreadChecker.assertOnValidThread();
    }
    if (obs == null || this.mObservers.contains(obs)) {
      return false;
    }
    boolean result = this.mObservers.add(obs);
    if (!result) {
      throw new AssertionError();
    }
    this.mCount++;
    return true;
  }

  public boolean removeObserver(E obs) {
    int index;
    if (this.mEnableThreadAsserts) {
      this.mThreadChecker.assertOnValidThread();
    }
    if (obs == null || (index = this.mObservers.indexOf(obs)) == -1) {
      return false;
    }
    if (this.mIterationDepth == 0) {
      this.mObservers.remove(index);
    } else {
      this.mNeedsCompact = true;
      this.mObservers.set(index, null);
    }
    int i = this.mCount - 1;
    this.mCount = i;
    if (i >= 0) {
      return true;
    }
    throw new AssertionError();
  }

  public boolean hasObserver(E obs) {
    if (this.mEnableThreadAsserts) {
      this.mThreadChecker.assertOnValidThread();
    }
    return this.mObservers.contains(obs);
  }

  public void clear() {
    if (this.mEnableThreadAsserts) {
      this.mThreadChecker.assertOnValidThread();
    }
    this.mCount = 0;
    if (this.mIterationDepth == 0) {
      this.mObservers.clear();
      return;
    }
    int size = this.mObservers.size();
    this.mNeedsCompact = (size != 0) | this.mNeedsCompact;
    for (int i = 0; i < size; i++) {
      this.mObservers.set(i, null);
    }
  }

  @Override   public Iterator<E> iterator() {
    if (this.mEnableThreadAsserts) {
      this.mThreadChecker.assertOnValidThread();
    }
    return new ObserverListIterator();
  }

  public RewindableIterator<E> rewindableIterator() {
    if (this.mEnableThreadAsserts) {
      this.mThreadChecker.assertOnValidThread();
    }
    return new ObserverListIterator();
  }

  public int size() {
    if (this.mEnableThreadAsserts) {
      this.mThreadChecker.assertOnValidThread();
    }
    return this.mCount;
  }

  public boolean isEmpty() {
    if (this.mEnableThreadAsserts) {
      this.mThreadChecker.assertOnValidThread();
    }
    return this.mCount == 0;
  }

  private void compact() {
    if (this.mIterationDepth != 0) {
      throw new AssertionError();
    }
    for (int i = this.mObservers.size() - 1; i >= 0; i--) {
      if (this.mObservers.get(i) == null) {
        this.mObservers.remove(i);
      }
    }
  }

  public void incrementIterationDepth() {
    this.mIterationDepth++;
  }

  public void decrementIterationDepthAndCompactIfNeeded() {
    int i = this.mIterationDepth - 1;
    this.mIterationDepth = i;
    if (i < 0) {
      throw new AssertionError();
    }
    if (i <= 0 && this.mNeedsCompact) {
      this.mNeedsCompact = false;
      compact();
    }
  }

  public int capacity() {
    return this.mObservers.size();
  }

  public E getObserverAt(int index) {
    return this.mObservers.get(index);
  }

  public class ObserverListIterator implements RewindableIterator<E> {
    private int mIndex;
    private boolean mIsExhausted;
    private int mListEndMarker;

    private ObserverListIterator() {
      ObserverList.this.incrementIterationDepth();
      this.mListEndMarker = ObserverList.this.capacity();
    }

    @Override
    public void rewind() {
      if (ObserverList.this.mEnableThreadAsserts) {
        ObserverList.this.mThreadChecker.assertOnValidThread();
      }
      compactListIfNeeded();
      ObserverList.this.incrementIterationDepth();
      this.mListEndMarker = ObserverList.this.capacity();
      this.mIsExhausted = false;
      this.mIndex = 0;
    }

    @Override     public boolean hasNext() {
      if (ObserverList.this.mEnableThreadAsserts) {
        ObserverList.this.mThreadChecker.assertOnValidThread();
      }
      int lookupIndex = this.mIndex;
      while (lookupIndex < this.mListEndMarker
          && ObserverList.this.getObserverAt(lookupIndex) == null) {
        lookupIndex++;
      }
      if (lookupIndex < this.mListEndMarker) {
        return true;
      }
      compactListIfNeeded();
      return false;
    }

    @Override     public E next() {
      if (ObserverList.this.mEnableThreadAsserts) {
        ObserverList.this.mThreadChecker.assertOnValidThread();
      }
      while (true) {
        int i = this.mIndex;
        if (i >= this.mListEndMarker || ObserverList.this.getObserverAt(i) != null) {
          break;
        }
        this.mIndex++;
      }
      int i2 = this.mIndex;
      if (i2 >= this.mListEndMarker) {
        compactListIfNeeded();
        throw new NoSuchElementException();
      }
      ObserverList observerList = ObserverList.this;
      this.mIndex = i2 + 1;
      return (E) observerList.getObserverAt(i2);
    }

    @Override     public void remove() {
      throw new UnsupportedOperationException();
    }

    private void compactListIfNeeded() {
      if (!this.mIsExhausted) {
        this.mIsExhausted = true;
        ObserverList.this.decrementIterationDepthAndCompactIfNeeded();
      }
    }
  }
}
