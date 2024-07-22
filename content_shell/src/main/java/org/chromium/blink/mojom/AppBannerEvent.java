package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AppBannerEvent extends Interface {
  public static final Interface.Manager<AppBannerEvent, Proxy> MANAGER =
      AppBannerEvent_Internal.MANAGER;

  public interface Proxy extends AppBannerEvent, Interface.Proxy {}

  void bannerAccepted(String str);

  void bannerDismissed();
}
