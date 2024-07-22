package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface QuotaChangeListener extends Interface {
  public static final Interface.Manager<QuotaChangeListener, Proxy> MANAGER =
      QuotaChangeListener_Internal.MANAGER;

  public interface Proxy extends QuotaChangeListener, Interface.Proxy {}

  void onQuotaChange();
}
