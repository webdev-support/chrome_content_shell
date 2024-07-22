package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;

public interface MediaPlayerHost extends Interface {
  public static final Interface.Manager<MediaPlayerHost, Proxy> MANAGER =
      MediaPlayerHost_Internal.MANAGER;

  public interface Proxy extends MediaPlayerHost, Interface.Proxy {}

  void onMediaPlayerAdded(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported,
      int i);
}
