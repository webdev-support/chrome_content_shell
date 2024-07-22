package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface GpuDataManager extends Interface {
  public static final Interface.Manager<GpuDataManager, Proxy> MANAGER =
      GpuDataManager_Internal.MANAGER;

  public interface Are3DapIsBlockedForUrl_Response {
    void call(boolean z);
  }

  public interface Proxy extends GpuDataManager, Interface.Proxy {}

  void are3DapIsBlockedForUrl(
      Url url, Are3DapIsBlockedForUrl_Response are3DapIsBlockedForUrl_Response);
}
