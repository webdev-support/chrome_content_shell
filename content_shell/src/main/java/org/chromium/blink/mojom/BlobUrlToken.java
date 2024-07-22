package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface BlobUrlToken extends Interface {
  public static final Interface.Manager<BlobUrlToken, Proxy> MANAGER =
      BlobUrlToken_Internal.MANAGER;

  public interface GetToken_Response {
    void call(UnguessableToken unguessableToken);
  }

  public interface Proxy extends BlobUrlToken, Interface.Proxy {}

  void clone(InterfaceRequest<BlobUrlToken> interfaceRequest);

  void getToken(GetToken_Response getToken_Response);
}
