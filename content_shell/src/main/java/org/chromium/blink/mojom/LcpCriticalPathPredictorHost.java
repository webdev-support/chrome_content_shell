package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ByteString;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.url.mojom.Url;

public interface LcpCriticalPathPredictorHost extends Interface {
  public static final Interface.Manager<LcpCriticalPathPredictorHost, Proxy> MANAGER =
      LcpCriticalPathPredictorHost_Internal.MANAGER;

  public interface Proxy extends LcpCriticalPathPredictorHost, Interface.Proxy {}

  void notifyFetchedFont(Url url);

  void notifyFetchedSubresource(Url url, TimeDelta timeDelta);

  void setLcpElementLocator(ByteString byteString, Integer num);

  void setLcpInfluencerScriptUrls(Url[] urlArr);

  void setPreconnectOrigins(Url[] urlArr);
}
