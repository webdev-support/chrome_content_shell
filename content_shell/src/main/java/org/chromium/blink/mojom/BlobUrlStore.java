package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.network.mojom.SchemefulSite;
import org.chromium.network.mojom.UrlLoaderFactory;
import org.chromium.url.mojom.Url;

public interface BlobUrlStore extends Interface {
  public static final Interface.Manager<BlobUrlStore, Proxy> MANAGER =
      BlobUrlStore_Internal.MANAGER;

  public interface Proxy extends BlobUrlStore, Interface.Proxy {}

  public interface Register_Response {
    void call();
  }

  public interface ResolveAsUrlLoaderFactory_Response {
    void call(UnguessableToken unguessableToken, SchemefulSite schemefulSite);
  }

  public interface ResolveForNavigation_Response {
    void call(UnguessableToken unguessableToken);
  }

  public interface Resolve_Response {
    void call(Blob blob, UnguessableToken unguessableToken);
  }

  void register(
      Blob blob,
      Url url,
      UnguessableToken unguessableToken,
      SchemefulSite schemefulSite,
      Register_Response register_Response);

  void resolve(Url url, Resolve_Response resolve_Response);

  void resolveAsUrlLoaderFactory(
      Url url,
      InterfaceRequest<UrlLoaderFactory> interfaceRequest,
      ResolveAsUrlLoaderFactory_Response resolveAsUrlLoaderFactory_Response);

  void resolveForNavigation(
      Url url,
      InterfaceRequest<BlobUrlToken> interfaceRequest,
      ResolveForNavigation_Response resolveForNavigation_Response);

  void revoke(Url url);
}
