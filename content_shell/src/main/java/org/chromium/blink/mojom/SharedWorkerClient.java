package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SharedWorkerClient extends Interface {
  public static final Interface.Manager<SharedWorkerClient, Proxy> MANAGER =
      SharedWorkerClient_Internal.MANAGER;

  public interface Proxy extends SharedWorkerClient, Interface.Proxy {}

  void onConnected(int[] iArr);

  void onCreated(int i);

  void onFeatureUsed(int i);

  void onScriptLoadFailed(String str);
}
