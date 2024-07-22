package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PolicyContainerHostKeepAliveHandle extends Interface {
  public static final Interface.Manager<PolicyContainerHostKeepAliveHandle, Proxy> MANAGER =
      PolicyContainerHostKeepAliveHandle_Internal.MANAGER;

  public interface Proxy extends PolicyContainerHostKeepAliveHandle, Interface.Proxy {}
}
