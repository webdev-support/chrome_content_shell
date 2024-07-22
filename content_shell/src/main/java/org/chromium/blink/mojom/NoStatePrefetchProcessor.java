package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface NoStatePrefetchProcessor extends Interface {
  public static final Interface.Manager<NoStatePrefetchProcessor, Proxy> MANAGER =
      NoStatePrefetchProcessor_Internal.MANAGER;

  public interface Proxy extends NoStatePrefetchProcessor, Interface.Proxy {}

  void cancel();

  void start(PrerenderAttributes prerenderAttributes);
}
