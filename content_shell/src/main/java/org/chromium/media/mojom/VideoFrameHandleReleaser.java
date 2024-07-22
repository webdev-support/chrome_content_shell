package org.chromium.media.mojom;

import org.chromium.gpu.mojom.SyncToken;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface VideoFrameHandleReleaser extends Interface {
  public static final Interface.Manager<VideoFrameHandleReleaser, Proxy> MANAGER =
      VideoFrameHandleReleaser_Internal.MANAGER;

  public interface Proxy extends VideoFrameHandleReleaser, Interface.Proxy {}

  void releaseVideoFrame(UnguessableToken unguessableToken, SyncToken syncToken);
}
