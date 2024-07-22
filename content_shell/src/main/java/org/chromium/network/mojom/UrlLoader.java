package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface UrlLoader extends Interface {
  public static final int CLIENT_DISCONNECT_REASON = 1;
  public static final Interface.Manager<UrlLoader, Proxy> MANAGER = UrlLoader_Internal.MANAGER;

  public interface Proxy extends UrlLoader, Interface.Proxy {}

  void followRedirect(
      String[] strArr,
      HttpRequestHeaders httpRequestHeaders,
      HttpRequestHeaders httpRequestHeaders2,
      Url url);

  void pauseReadingBodyFromNet();

  void resumeReadingBodyFromNet();

  void setPriority(int i, int i2);
}
