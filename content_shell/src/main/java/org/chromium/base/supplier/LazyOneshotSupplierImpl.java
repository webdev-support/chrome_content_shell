package org.chromium.base.supplier;

import org.chromium.base.Callback;
import org.chromium.base.Promise;
import org.chromium.base.ThreadUtils;

public abstract class LazyOneshotSupplierImpl<T> implements LazyOneshotSupplier<T> {

  private boolean mDoSetCalled;
  private final Promise<T> mPromise = new Promise<>();
  private final ThreadUtils.ThreadChecker mThreadChecker = new ThreadUtils.ThreadChecker();

  public abstract void doSet();

  @Override
  public void onAvailable(Callback<T> callback) {
    this.mThreadChecker.assertOnValidThread();
    this.mPromise.then(callback);
  }

  @Override
  public T get() {
    this.mThreadChecker.assertOnValidThread();
    if (!hasValue()) {
      tryDoSet();
    }
    if (hasValue()) {
      return this.mPromise.getResult();
    }
    return null;
  }

  @Override
  public boolean hasValue() {
    return this.mPromise.isFulfilled();
  }

  public void set(T object) {
    this.mThreadChecker.assertOnValidThread();
    if (this.mPromise.isFulfilled()) {
      throw new AssertionError();
    }
    this.mPromise.fulfill(object);
  }

  private void tryDoSet() {
    if (this.mDoSetCalled) {
      return;
    }
    doSet();
    this.mDoSetCalled = true;
  }
}
