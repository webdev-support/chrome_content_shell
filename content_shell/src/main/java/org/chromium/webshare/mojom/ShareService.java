package org.chromium.webshare.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface ShareService extends Interface {
  public static final Interface.Manager<ShareService, Proxy> MANAGER =
      ShareService_Internal.MANAGER;

  public interface Proxy extends ShareService, Interface.Proxy {}

  public interface Share_Response {
    void call(int i);
  }

  void share(
      String str, String str2, Url url, SharedFile[] sharedFileArr, Share_Response share_Response);
}
