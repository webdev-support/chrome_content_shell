package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ObliviousHttpClient extends Interface {
  public static final Interface.Manager<ObliviousHttpClient, Proxy> MANAGER =
      ObliviousHttpClient_Internal.MANAGER;

  public interface Proxy extends ObliviousHttpClient, Interface.Proxy {}

  void onCompleted(ObliviousHttpCompletionResult obliviousHttpCompletionResult);
}
