package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DocumentMetadata extends Interface {
  public static final Interface.Manager<DocumentMetadata, Proxy> MANAGER =
      DocumentMetadata_Internal.MANAGER;

  public interface GetEntities_Response {
    void call(WebPage webPage);
  }

  public interface Proxy extends DocumentMetadata, Interface.Proxy {}

  void getEntities(GetEntities_Response getEntities_Response);
}
