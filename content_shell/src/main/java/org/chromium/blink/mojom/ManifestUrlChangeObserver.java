package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface ManifestUrlChangeObserver extends Interface {
  public static final Interface.Manager<ManifestUrlChangeObserver, Proxy> MANAGER =
      ManifestUrlChangeObserver_Internal.MANAGER;

  public interface Proxy extends ManifestUrlChangeObserver, Interface.Proxy {}

  void manifestUrlChanged(Url url);
}
