package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DelegatedInkPointRenderer extends Interface {
  public static final Interface.Manager<DelegatedInkPointRenderer, Proxy> MANAGER =
      DelegatedInkPointRenderer_Internal.MANAGER;

  public interface Proxy extends DelegatedInkPointRenderer, Interface.Proxy {}

  void resetPrediction();

  void storeDelegatedInkPoint(DelegatedInkPoint delegatedInkPoint);
}
