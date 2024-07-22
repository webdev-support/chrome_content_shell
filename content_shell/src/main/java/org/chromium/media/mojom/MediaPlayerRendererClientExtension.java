package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

public interface MediaPlayerRendererClientExtension extends Interface {
  public static final Interface.Manager<MediaPlayerRendererClientExtension, Proxy> MANAGER =
      MediaPlayerRendererClientExtension_Internal.MANAGER;

  public interface Proxy extends MediaPlayerRendererClientExtension, Interface.Proxy {}

  void onDurationChange(TimeDelta timeDelta);

  void onVideoSizeChange(Size size);
}
