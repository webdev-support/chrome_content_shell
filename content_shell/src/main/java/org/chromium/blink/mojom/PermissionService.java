package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PermissionService extends Interface {
  public static final Interface.Manager<PermissionService, Proxy> MANAGER =
      PermissionService_Internal.MANAGER;

  public interface HasPermission_Response {
    void call(int i);
  }

  public interface Proxy extends PermissionService, Interface.Proxy {}

  public interface RequestPageEmbeddedPermission_Response {
    void call(int i);
  }

  public interface RequestPermission_Response {
    void call(int i);
  }

  public interface RequestPermissions_Response {
    void call(int[] iArr);
  }

  public interface RevokePermission_Response {
    void call(int i);
  }

  void addPermissionObserver(
      PermissionDescriptor permissionDescriptor, int i, PermissionObserver permissionObserver);

  void hasPermission(
      PermissionDescriptor permissionDescriptor, HasPermission_Response hasPermission_Response);

  void notifyEventListener(PermissionDescriptor permissionDescriptor, String str, boolean z);

  void registerPageEmbeddedPermissionControl(
      PermissionDescriptor[] permissionDescriptorArr,
      EmbeddedPermissionControlClient embeddedPermissionControlClient);

  void requestPageEmbeddedPermission(
      EmbeddedPermissionRequestDescriptor embeddedPermissionRequestDescriptor,
      RequestPageEmbeddedPermission_Response requestPageEmbeddedPermission_Response);

  void requestPermission(
      PermissionDescriptor permissionDescriptor,
      boolean z,
      RequestPermission_Response requestPermission_Response);

  void requestPermissions(
      PermissionDescriptor[] permissionDescriptorArr,
      boolean z,
      RequestPermissions_Response requestPermissions_Response);

  void revokePermission(
      PermissionDescriptor permissionDescriptor,
      RevokePermission_Response revokePermission_Response);
}
