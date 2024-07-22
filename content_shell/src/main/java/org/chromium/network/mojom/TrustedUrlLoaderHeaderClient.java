package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface TrustedUrlLoaderHeaderClient extends Interface {
  public static final Interface.Manager<TrustedUrlLoaderHeaderClient, Proxy> MANAGER =
      TrustedUrlLoaderHeaderClient_Internal.MANAGER;

  public interface Proxy extends TrustedUrlLoaderHeaderClient, Interface.Proxy {}

  void onLoaderCreated(int i, InterfaceRequest<TrustedHeaderClient> interfaceRequest);

  void onLoaderForCorsPreflightCreated(
      UrlRequest urlRequest, InterfaceRequest<TrustedHeaderClient> interfaceRequest);
}
