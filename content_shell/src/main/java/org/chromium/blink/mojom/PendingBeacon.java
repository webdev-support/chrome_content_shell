package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.UrlRequestBody;
import org.chromium.url.mojom.Url;

public interface PendingBeacon extends Interface {
  public static final Interface.Manager<PendingBeacon, Proxy> MANAGER =
      PendingBeacon_Internal.MANAGER;

  public interface Proxy extends PendingBeacon, Interface.Proxy {}

  void deactivate();

  void sendNow();

  void setRequestData(UrlRequestBody urlRequestBody, String str);

  void setRequestUrl(Url url);
}
