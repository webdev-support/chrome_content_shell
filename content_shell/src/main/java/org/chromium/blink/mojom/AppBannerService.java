package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AppBannerService extends Interface {
  public static final Interface.Manager<AppBannerService, Proxy> MANAGER =
      AppBannerService_Internal.MANAGER;

  public interface Proxy extends AppBannerService, Interface.Proxy {}

  void displayAppBanner();
}
