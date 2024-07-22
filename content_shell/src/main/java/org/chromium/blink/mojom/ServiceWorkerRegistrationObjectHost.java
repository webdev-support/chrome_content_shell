package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ServiceWorkerRegistrationObjectHost extends Interface {
  public static final Interface.Manager<ServiceWorkerRegistrationObjectHost, Proxy> MANAGER =
      ServiceWorkerRegistrationObjectHost_Internal.MANAGER;

  public interface EnableNavigationPreload_Response {
    void call(int i, String str);
  }

  public interface GetNavigationPreloadState_Response {
    void call(int i, String str, NavigationPreloadState navigationPreloadState);
  }

  public interface Proxy extends ServiceWorkerRegistrationObjectHost, Interface.Proxy {}

  public interface SetNavigationPreloadHeader_Response {
    void call(int i, String str);
  }

  public interface Unregister_Response {
    void call(int i, String str);
  }

  public interface Update_Response {
    void call(int i, String str);
  }

  void enableNavigationPreload(
      boolean z, EnableNavigationPreload_Response enableNavigationPreload_Response);

  void getNavigationPreloadState(
      GetNavigationPreloadState_Response getNavigationPreloadState_Response);

  void setNavigationPreloadHeader(
      String str, SetNavigationPreloadHeader_Response setNavigationPreloadHeader_Response);

  void unregister(Unregister_Response unregister_Response);

  void update(FetchClientSettingsObject fetchClientSettingsObject, Update_Response update_Response);
}
