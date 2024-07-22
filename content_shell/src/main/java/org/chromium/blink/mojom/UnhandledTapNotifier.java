package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface UnhandledTapNotifier extends Interface {
  public static final Interface.Manager<UnhandledTapNotifier, Proxy> MANAGER =
      UnhandledTapNotifier_Internal.MANAGER;

  public interface Proxy extends UnhandledTapNotifier, Interface.Proxy {}

  void showUnhandledTapUiIfNeeded(UnhandledTapInfo unhandledTapInfo);
}
