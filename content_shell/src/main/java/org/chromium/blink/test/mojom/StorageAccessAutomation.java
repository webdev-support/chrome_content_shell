package org.chromium.blink.test.mojom;

import org.chromium.mojo.bindings.Interface;

public interface StorageAccessAutomation extends Interface {
  public static final Interface.Manager<StorageAccessAutomation, Proxy> MANAGER =
      StorageAccessAutomation_Internal.MANAGER;

  public interface Proxy extends StorageAccessAutomation, Interface.Proxy {}

  public interface SetStorageAccess_Response {
    void call(boolean z);
  }

  void setStorageAccess(
      String str, String str2, boolean z, SetStorageAccess_Response setStorageAccess_Response);
}
