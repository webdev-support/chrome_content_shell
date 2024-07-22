package org.chromium.mojo.system;

public interface Watcher {

  public interface Callback {
    void onResult(int i);
  }

  void cancel();

  void destroy();

  int start(Handle handle, Core.HandleSignals handleSignals, Callback callback);
}
