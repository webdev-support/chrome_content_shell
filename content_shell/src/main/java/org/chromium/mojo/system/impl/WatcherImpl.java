package org.chromium.mojo.system.impl;

import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.Watcher;
import org.jni_zero.JNINamespace;

@JNINamespace("mojo::android")
class WatcherImpl implements Watcher {
  private Watcher.Callback mCallback;
  private long mImplPtr = WatcherImplJni.get().createWatcher(this);

  public interface Natives {
    void cancel(WatcherImpl watcherImpl, long j);

    long createWatcher(WatcherImpl watcherImpl);

    void delete(WatcherImpl watcherImpl, long j);

    int start(WatcherImpl watcherImpl, long j, long j2, int i);
  }

  @Override
  public int start(Handle handle, Core.HandleSignals signals, Watcher.Callback callback) {
    if (this.mImplPtr != 0 && (handle instanceof HandleBase)) {
      int result =
          WatcherImplJni.get()
              .start(
                  this, this.mImplPtr, ((HandleBase) handle).getMojoHandle(), signals.getFlags());
      if (result == 0) {
        this.mCallback = callback;
      }
      return result;
    }
    return 3;
  }

  @Override
  public void cancel() {
    if (this.mImplPtr == 0) {
      return;
    }
    this.mCallback = null;
    WatcherImplJni.get().cancel(this, this.mImplPtr);
  }

  @Override
  public void destroy() {
    if (this.mImplPtr == 0) {
      return;
    }
    WatcherImplJni.get().delete(this, this.mImplPtr);
    this.mImplPtr = 0L;
  }

  private void onHandleReady(int result) {
    this.mCallback.onResult(result);
  }
}
