package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface FeatureObserver extends Interface {
  public static final Interface.Manager<FeatureObserver, Proxy> MANAGER =
      FeatureObserver_Internal.MANAGER;

  public interface Proxy extends FeatureObserver, Interface.Proxy {}

  void register(InterfaceRequest<ObservedFeature> interfaceRequest, int i);
}
