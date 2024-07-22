package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface EmbeddedPermissionControlClient extends Interface {
  public static final Interface.Manager<EmbeddedPermissionControlClient, Proxy> MANAGER =
      EmbeddedPermissionControlClient_Internal.MANAGER;

  public interface Proxy extends EmbeddedPermissionControlClient, Interface.Proxy {}

  void onEmbeddedPermissionControlRegistered(boolean z, int[] iArr);
}
