package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface KeySystemSupport extends Interface {
  public static final Interface.Manager<KeySystemSupport, Proxy> MANAGER =
      KeySystemSupport_Internal.MANAGER;

  public interface Proxy extends KeySystemSupport, Interface.Proxy {}

  void addObserver(KeySystemSupportObserver keySystemSupportObserver);
}
