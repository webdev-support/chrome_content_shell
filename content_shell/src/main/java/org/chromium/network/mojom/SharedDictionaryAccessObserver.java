package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface SharedDictionaryAccessObserver extends Interface {
  public static final Interface.Manager<SharedDictionaryAccessObserver, Proxy> MANAGER =
      SharedDictionaryAccessObserver_Internal.MANAGER;

  public interface Proxy extends SharedDictionaryAccessObserver, Interface.Proxy {}

  void clone(InterfaceRequest<SharedDictionaryAccessObserver> interfaceRequest);

  void onSharedDictionaryAccessed(SharedDictionaryAccessDetails sharedDictionaryAccessDetails);
}
