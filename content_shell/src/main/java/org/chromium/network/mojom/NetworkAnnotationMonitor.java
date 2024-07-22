package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface NetworkAnnotationMonitor extends Interface {
  public static final Interface.Manager<NetworkAnnotationMonitor, Proxy> MANAGER =
      NetworkAnnotationMonitor_Internal.MANAGER;

  public interface Proxy extends NetworkAnnotationMonitor, Interface.Proxy {}

  void report(int i);
}
