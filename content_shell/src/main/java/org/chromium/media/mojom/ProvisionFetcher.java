package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface ProvisionFetcher extends Interface {
  public static final Interface.Manager<ProvisionFetcher, Proxy> MANAGER =
      ProvisionFetcher_Internal.MANAGER;

  public interface Proxy extends ProvisionFetcher, Interface.Proxy {}

  public interface Retrieve_Response {
    void call(boolean z, String str);
  }

  void retrieve(Url url, String str, Retrieve_Response retrieve_Response);
}
