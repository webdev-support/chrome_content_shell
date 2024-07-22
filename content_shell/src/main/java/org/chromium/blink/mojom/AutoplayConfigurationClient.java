package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.internal.mojom.Origin;

public interface AutoplayConfigurationClient extends Interface {
  public static final Interface.Manager<AutoplayConfigurationClient, Proxy> MANAGER =
      AutoplayConfigurationClient_Internal.MANAGER;

  public interface Proxy extends AutoplayConfigurationClient, Interface.Proxy {}

  void addAutoplayFlags(Origin origin, int i);
}
