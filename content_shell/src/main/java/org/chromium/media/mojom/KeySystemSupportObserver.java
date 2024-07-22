package org.chromium.media.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;

public interface KeySystemSupportObserver extends Interface {
  public static final Interface.Manager<KeySystemSupportObserver, Proxy> MANAGER =
      KeySystemSupportObserver_Internal.MANAGER;

  public interface Proxy extends KeySystemSupportObserver, Interface.Proxy {}

  void onKeySystemSupportUpdated(Map<String, KeySystemCapability> map);
}
