package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.MutableNetworkTrafficAnnotationTag;
import org.chromium.network.mojom.UrlRequest;

public interface FetchLaterLoaderFactory extends Interface {
  public static final Interface.Manager<FetchLaterLoaderFactory, Proxy> MANAGER =
      FetchLaterLoaderFactory_Internal.MANAGER;

  public interface Proxy extends FetchLaterLoaderFactory, Interface.Proxy {}

  void clone(AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);

  void createLoader(
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported,
      int i,
      int i2,
      UrlRequest urlRequest,
      MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag);
}
