package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface LocalMuter extends Interface {
  public static final Interface.Manager<LocalMuter, Proxy> MANAGER = LocalMuter_Internal.MANAGER;

  public interface Proxy extends LocalMuter, Interface.Proxy {}
}
