package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.url.mojom.Url;

public interface FencedFrameOwnerHost extends Interface {
  public static final Interface.Manager<FencedFrameOwnerHost, Proxy> MANAGER =
      FencedFrameOwnerHost_Internal.MANAGER;

  public interface Proxy extends FencedFrameOwnerHost, Interface.Proxy {}

  void didChangeFramePolicy(FramePolicy framePolicy);

  void navigate(Url url, TimeTicks timeTicks, String16 string16);
}
