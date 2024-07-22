package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface NotificationService extends Interface {
  public static final Interface.Manager<NotificationService, Proxy> MANAGER =
      NotificationService_Internal.MANAGER;

  public interface DisplayPersistentNotification_Response {
    void call(int i);
  }

  public interface GetNotifications_Response {
    void call(String[] strArr, NotificationData[] notificationDataArr);
  }

  public interface GetPermissionStatus_Response {
    void call(int i);
  }

  public interface Proxy extends NotificationService, Interface.Proxy {}

  void closeNonPersistentNotification(String str);

  void closePersistentNotification(String str);

  void displayNonPersistentNotification(
      String str,
      NotificationData notificationData,
      NotificationResources notificationResources,
      NonPersistentNotificationListener nonPersistentNotificationListener);

  void displayPersistentNotification(
      long j,
      NotificationData notificationData,
      NotificationResources notificationResources,
      DisplayPersistentNotification_Response displayPersistentNotification_Response);

  void getNotifications(
      long j, String str, boolean z, GetNotifications_Response getNotifications_Response);

  void getPermissionStatus(GetPermissionStatus_Response getPermissionStatus_Response);
}
