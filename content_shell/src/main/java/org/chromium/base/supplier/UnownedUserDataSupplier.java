package org.chromium.base.supplier;

import org.chromium.base.UnownedUserData;
import org.chromium.base.UnownedUserDataHost;
import org.chromium.base.UnownedUserDataKey;
import org.chromium.base.lifetime.DestroyChecker;
import org.chromium.base.lifetime.Destroyable;

public abstract class UnownedUserDataSupplier<E> extends ObservableSupplierImpl<E>
    implements Destroyable, UnownedUserData {
  private final DestroyChecker mDestroyChecker = new DestroyChecker();
  private final UnownedUserDataKey<UnownedUserDataSupplier<E>> mUudKey;

  /* JADX WARN: Multi-variable type inference failed */
  protected UnownedUserDataSupplier(
      UnownedUserDataKey<? extends UnownedUserDataSupplier<E>> uudKey) {
    this.mUudKey = (UnownedUserDataKey<UnownedUserDataSupplier<E>>) uudKey;
  }

  public void attach(UnownedUserDataHost host) {
    this.mDestroyChecker.checkNotDestroyed();
    this.mUudKey.attachToHost(host, this);
  }

  @Override
  public void destroy() {
    this.mDestroyChecker.destroy();
    this.mUudKey.detachFromAllHosts(this);
  }
}
