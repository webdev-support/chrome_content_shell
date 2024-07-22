package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FetchLaterLoader extends Interface {
  public static final Interface.Manager<FetchLaterLoader, Proxy> MANAGER =
      FetchLaterLoader_Internal.MANAGER;

  public interface Proxy extends FetchLaterLoader, Interface.Proxy {}

  void cancel();

  void sendNow();
}
