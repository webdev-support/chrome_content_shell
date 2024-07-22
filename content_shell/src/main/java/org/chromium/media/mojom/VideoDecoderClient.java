package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface VideoDecoderClient extends Interface {
  public static final Interface.Manager<VideoDecoderClient, Proxy> MANAGER =
      VideoDecoderClient_Internal.MANAGER;

  public interface Proxy extends VideoDecoderClient, Interface.Proxy {}

  void onVideoFrameDecoded(VideoFrame videoFrame, boolean z, UnguessableToken unguessableToken);

  void onWaiting(int i);

  void requestOverlayInfo(boolean z);
}
