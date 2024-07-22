package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.BigString16;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.Value;
import org.chromium.network.mojom.CookieChangeInfo;
import org.chromium.payments.mojom.CanMakePaymentEventData;
import org.chromium.payments.mojom.PaymentHandlerResponseCallback;
import org.chromium.payments.mojom.PaymentRequestEventData;

public interface ServiceWorker extends Interface {
  public static final Interface.Manager<ServiceWorker, Proxy> MANAGER =
      ServiceWorker_Internal.MANAGER;

  public interface DispatchAbortPaymentEvent_Response {
    void call(int i);
  }

  public interface DispatchActivateEvent_Response {
    void call(int i);
  }

  public interface DispatchBackgroundFetchAbortEvent_Response {
    void call(int i);
  }

  public interface DispatchBackgroundFetchClickEvent_Response {
    void call(int i);
  }

  public interface DispatchBackgroundFetchFailEvent_Response {
    void call(int i);
  }

  public interface DispatchBackgroundFetchSuccessEvent_Response {
    void call(int i);
  }

  public interface DispatchCanMakePaymentEvent_Response {
    void call(int i);
  }

  public interface DispatchContentDeleteEvent_Response {
    void call(int i);
  }

  public interface DispatchCookieChangeEvent_Response {
    void call(int i);
  }

  public interface DispatchExtendableMessageEvent_Response {
    void call(int i);
  }

  public interface DispatchFetchEventForMainResource_Response {
    void call(int i);
  }

  public interface DispatchInstallEvent_Response {
    void call(int i, int i2);
  }

  public interface DispatchNotificationClickEvent_Response {
    void call(int i);
  }

  public interface DispatchNotificationCloseEvent_Response {
    void call(int i);
  }

  public interface DispatchPaymentRequestEvent_Response {
    void call(int i);
  }

  public interface DispatchPeriodicSyncEvent_Response {
    void call(int i);
  }

  public interface DispatchPushEvent_Response {
    void call(int i);
  }

  public interface DispatchPushSubscriptionChangeEvent_Response {
    void call(int i);
  }

  public interface DispatchSyncEvent_Response {
    void call(int i);
  }

  public interface ExecuteScriptForTest_Response {
    void call(Value value, String str);
  }

  public interface Ping_Response {
    void call();
  }

  public interface Proxy extends ServiceWorker, Interface.Proxy {}

  void addKeepAlive();

  void addMessageToConsole(int i, String str);

  void clearKeepAlive();

  void dispatchAbortPaymentEvent(
      PaymentHandlerResponseCallback paymentHandlerResponseCallback,
      DispatchAbortPaymentEvent_Response dispatchAbortPaymentEvent_Response);

  void dispatchActivateEvent(DispatchActivateEvent_Response dispatchActivateEvent_Response);

  void dispatchBackgroundFetchAbortEvent(
      BackgroundFetchRegistration backgroundFetchRegistration,
      DispatchBackgroundFetchAbortEvent_Response dispatchBackgroundFetchAbortEvent_Response);

  void dispatchBackgroundFetchClickEvent(
      BackgroundFetchRegistration backgroundFetchRegistration,
      DispatchBackgroundFetchClickEvent_Response dispatchBackgroundFetchClickEvent_Response);

  void dispatchBackgroundFetchFailEvent(
      BackgroundFetchRegistration backgroundFetchRegistration,
      DispatchBackgroundFetchFailEvent_Response dispatchBackgroundFetchFailEvent_Response);

  void dispatchBackgroundFetchSuccessEvent(
      BackgroundFetchRegistration backgroundFetchRegistration,
      DispatchBackgroundFetchSuccessEvent_Response dispatchBackgroundFetchSuccessEvent_Response);

  void dispatchCanMakePaymentEvent(
      CanMakePaymentEventData canMakePaymentEventData,
      PaymentHandlerResponseCallback paymentHandlerResponseCallback,
      DispatchCanMakePaymentEvent_Response dispatchCanMakePaymentEvent_Response);

  void dispatchContentDeleteEvent(
      String str, DispatchContentDeleteEvent_Response dispatchContentDeleteEvent_Response);

  void dispatchCookieChangeEvent(
      CookieChangeInfo cookieChangeInfo,
      DispatchCookieChangeEvent_Response dispatchCookieChangeEvent_Response);

  void dispatchExtendableMessageEvent(
      ExtendableMessageEvent extendableMessageEvent,
      DispatchExtendableMessageEvent_Response dispatchExtendableMessageEvent_Response);

  void dispatchFetchEventForMainResource(
      DispatchFetchEventParams dispatchFetchEventParams,
      ServiceWorkerFetchResponseCallback serviceWorkerFetchResponseCallback,
      DispatchFetchEventForMainResource_Response dispatchFetchEventForMainResource_Response);

  void dispatchInstallEvent(DispatchInstallEvent_Response dispatchInstallEvent_Response);

  void dispatchNotificationClickEvent(
      String str,
      NotificationData notificationData,
      int i,
      String16 string16,
      DispatchNotificationClickEvent_Response dispatchNotificationClickEvent_Response);

  void dispatchNotificationCloseEvent(
      String str,
      NotificationData notificationData,
      DispatchNotificationCloseEvent_Response dispatchNotificationCloseEvent_Response);

  void dispatchPaymentRequestEvent(
      PaymentRequestEventData paymentRequestEventData,
      PaymentHandlerResponseCallback paymentHandlerResponseCallback,
      DispatchPaymentRequestEvent_Response dispatchPaymentRequestEvent_Response);

  void dispatchPeriodicSyncEvent(
      String str,
      TimeDelta timeDelta,
      DispatchPeriodicSyncEvent_Response dispatchPeriodicSyncEvent_Response);

  void dispatchPushEvent(String str, DispatchPushEvent_Response dispatchPushEvent_Response);

  void dispatchPushSubscriptionChangeEvent(
      PushSubscription pushSubscription,
      PushSubscription pushSubscription2,
      DispatchPushSubscriptionChangeEvent_Response dispatchPushSubscriptionChangeEvent_Response);

  void dispatchSyncEvent(
      String str,
      boolean z,
      TimeDelta timeDelta,
      DispatchSyncEvent_Response dispatchSyncEvent_Response);

  void executeScriptForTest(
      BigString16 bigString16,
      boolean z,
      ExecuteScriptForTest_Response executeScriptForTest_Response);

  void initializeGlobalScope(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported2,
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported,
      ServiceWorkerRegistrationObjectInfo serviceWorkerRegistrationObjectInfo,
      ServiceWorkerObjectInfo serviceWorkerObjectInfo,
      int i,
      InterfaceRequest<ReportingObserver> interfaceRequest,
      int i2,
      StorageKey storageKey);

  void ping(Ping_Response ping_Response);

  void setIdleDelay(TimeDelta timeDelta);
}
