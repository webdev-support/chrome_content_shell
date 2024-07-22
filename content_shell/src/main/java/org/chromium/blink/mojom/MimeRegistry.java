package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface MimeRegistry extends Interface {
  public static final Interface.Manager<MimeRegistry, Proxy> MANAGER =
      MimeRegistry_Internal.MANAGER;

  public interface GetMimeTypeFromExtension_Response {
    void call(String str);
  }

  public interface Proxy extends MimeRegistry, Interface.Proxy {}

  void getMimeTypeFromExtension(
      String str, GetMimeTypeFromExtension_Response getMimeTypeFromExtension_Response);
}
