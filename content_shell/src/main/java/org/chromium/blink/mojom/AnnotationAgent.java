package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AnnotationAgent extends Interface {
  public static final Interface.Manager<AnnotationAgent, Proxy> MANAGER =
      AnnotationAgent_Internal.MANAGER;

  public interface Proxy extends AnnotationAgent, Interface.Proxy {}

  void scrollIntoView();
}
