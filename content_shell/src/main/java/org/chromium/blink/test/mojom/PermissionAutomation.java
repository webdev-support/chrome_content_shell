package org.chromium.blink.test.mojom;

import org.chromium.blink.mojom.PermissionDescriptor;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface PermissionAutomation extends Interface {
  public static final Interface.Manager<PermissionAutomation, Proxy> MANAGER =
      PermissionAutomation_Internal.MANAGER;

  public interface Proxy extends PermissionAutomation, Interface.Proxy {}

  public interface SetPermission_Response {
    void call(boolean z);
  }

  void setPermission(
      PermissionDescriptor permissionDescriptor,
      int i,
      Url url,
      Url url2,
      SetPermission_Response setPermission_Response);
}
