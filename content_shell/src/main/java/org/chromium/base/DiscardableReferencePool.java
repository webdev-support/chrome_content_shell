package org.chromium.base;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class DiscardableReferencePool {

  private final Set<DiscardableReference<?>> mPool;

  public DiscardableReferencePool() {
    WeakHashMap<DiscardableReference<?>, Boolean> map = new WeakHashMap<>();
    this.mPool = Collections.newSetFromMap(map);
  }

  public static class DiscardableReference<T> {

    private T mPayload;

    private DiscardableReference(T payload) {
      if (payload == null) {
        throw new AssertionError();
      }
      this.mPayload = payload;
    }

    public T get() {
      return this.mPayload;
    }

    public void discard() {
      if (this.mPayload == null) {
        throw new AssertionError();
      }
      this.mPayload = null;
    }
  }

  public <T> DiscardableReference<T> put(T payload) {
    if (payload == null) {
      throw new AssertionError();
    }
    DiscardableReference<T> reference = new DiscardableReference<>(payload);
    this.mPool.add(reference);
    return reference;
  }

  public void remove(DiscardableReference<?> ref) {
    if (ref == null) {
      throw new AssertionError();
    }
    if (this.mPool.contains(ref)) {
      if (ref.get() == null) {
        throw new AssertionError();
      }
      ref.discard();
      this.mPool.remove(ref);
    }
  }

  public void drain() {
    for (DiscardableReference<?> ref : this.mPool) {
      ref.discard();
    }
    this.mPool.clear();
  }
}
