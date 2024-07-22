package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface BadgeService extends Interface {
  public static final Interface.Manager<BadgeService, Proxy> MANAGER =
      BadgeService_Internal.MANAGER;

  public interface Proxy extends BadgeService, Interface.Proxy {}

  void clearBadge();

  void setBadge(BadgeValue badgeValue);
}
