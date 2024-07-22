package org.chromium.ui.base;

import java.lang.ref.WeakReference;

public class ImmutableWeakReference<T> extends WeakReference<T> {
  public ImmutableWeakReference(T referent) {
    super(referent);
  }

  @Override   public final void clear() {
    throw new UnsupportedOperationException("clear WeakReference banned");
  }
}
