package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ObservedFeature extends Interface {
  public static final Interface.Manager<ObservedFeature, Proxy> MANAGER =
      ObservedFeature_Internal.MANAGER;

  public interface Proxy extends ObservedFeature, Interface.Proxy {}
}
