package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;
import org.chromium.url.mojom.Url;

public interface ServiceWorkerHost extends Interface {
  public static final Interface.Manager<ServiceWorkerHost, Proxy> MANAGER =
      ServiceWorkerHost_Internal.MANAGER;

  public interface AddRoutes_Response {
    void call();
  }

  public interface ClaimClients_Response {
    void call(int i, String str);
  }

  public interface FocusClient_Response {
    void call(ServiceWorkerClientInfo serviceWorkerClientInfo);
  }

  public interface GetClient_Response {
    void call(ServiceWorkerClientInfo serviceWorkerClientInfo);
  }

  public interface GetClients_Response {
    void call(ServiceWorkerClientInfo[] serviceWorkerClientInfoArr);
  }

  public interface NavigateClient_Response {
    void call(boolean z, ServiceWorkerClientInfo serviceWorkerClientInfo, String str);
  }

  public interface OpenNewTab_Response {
    void call(boolean z, ServiceWorkerClientInfo serviceWorkerClientInfo, String str);
  }

  public interface OpenPaymentHandlerWindow_Response {
    void call(boolean z, ServiceWorkerClientInfo serviceWorkerClientInfo, String str);
  }

  public interface Proxy extends ServiceWorkerHost, Interface.Proxy {}

  public interface RegisterRouter_Response {
    void call();
  }

  public interface SkipWaiting_Response {
    void call(boolean z);
  }

  void addRoutes(
      ServiceWorkerRouterRules serviceWorkerRouterRules, AddRoutes_Response addRoutes_Response);

  void claimClients(ClaimClients_Response claimClients_Response);

  void clearCachedMetadata(Url url);

  void focusClient(String str, FocusClient_Response focusClient_Response);

  void getClient(String str, GetClient_Response getClient_Response);

  void getClients(
      ServiceWorkerClientQueryOptions serviceWorkerClientQueryOptions,
      GetClients_Response getClients_Response);

  void navigateClient(String str, Url url, NavigateClient_Response navigateClient_Response);

  void openNewTab(Url url, OpenNewTab_Response openNewTab_Response);

  void openPaymentHandlerWindow(
      Url url, OpenPaymentHandlerWindow_Response openPaymentHandlerWindow_Response);

  void postMessageToClient(String str, TransferableMessage transferableMessage);

  void registerRouter(
      ServiceWorkerRouterRules serviceWorkerRouterRules,
      RegisterRouter_Response registerRouter_Response);

  void setCachedMetadata(Url url, ReadOnlyBuffer readOnlyBuffer);

  void skipWaiting(SkipWaiting_Response skipWaiting_Response);
}
