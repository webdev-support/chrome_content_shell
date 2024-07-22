package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface DomStorage extends Interface {
  public static final Interface.Manager<DomStorage, Proxy> MANAGER = DomStorage_Internal.MANAGER;

  public interface Proxy extends DomStorage, Interface.Proxy {}

  void bindSessionStorageArea(
      StorageKey storageKey,
      LocalFrameToken localFrameToken,
      String str,
      InterfaceRequest<StorageArea> interfaceRequest);

  void bindSessionStorageNamespace(
      String str, InterfaceRequest<SessionStorageNamespace> interfaceRequest);

  void openLocalStorage(
      StorageKey storageKey,
      LocalFrameToken localFrameToken,
      InterfaceRequest<StorageArea> interfaceRequest);
}
