package org.chromium.base.lifetime;

public class DestroyChecker implements Destroyable {

  private boolean mIsDestroyed;

  @Override
  public void destroy() {
    checkNotDestroyed();
    this.mIsDestroyed = true;
  }

  public boolean isDestroyed() {
    return this.mIsDestroyed;
  }

  public void checkNotDestroyed() {
    if (this.mIsDestroyed) {
      throw new AssertionError("Object is already destroyed.");
    }
  }
}
