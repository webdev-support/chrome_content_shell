package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.Interface;

public interface AnnotationAgentHost extends Interface {
  public static final Interface.Manager<AnnotationAgentHost, Proxy> MANAGER =
      AnnotationAgentHost_Internal.MANAGER;

  public interface Proxy extends AnnotationAgentHost, Interface.Proxy {}

  void didFinishAttachment(Rect rect);
}
