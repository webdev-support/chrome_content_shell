package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.url.mojom.Url;

public interface ServiceWorkerContainerHost extends Interface {
  public static final Interface.Manager<ServiceWorkerContainerHost, Proxy> MANAGER =
      ServiceWorkerContainerHost_Internal.MANAGER;

  public interface EnsureFileAccess_Response {
    void call();
  }

  public interface GetRegistrationForReady_Response {
    void call(ServiceWorkerRegistrationObjectInfo serviceWorkerRegistrationObjectInfo);
  }

  public interface GetRegistration_Response {
    void call(
        int i, String str, ServiceWorkerRegistrationObjectInfo serviceWorkerRegistrationObjectInfo);
  }

  public interface GetRegistrations_Response {
    void call(
        int i,
        String str,
        ServiceWorkerRegistrationObjectInfo[] serviceWorkerRegistrationObjectInfoArr);
  }

  public interface Proxy extends ServiceWorkerContainerHost, Interface.Proxy {}

  public interface Register_Response {
    void call(
        int i, String str, ServiceWorkerRegistrationObjectInfo serviceWorkerRegistrationObjectInfo);
  }

  void cloneContainerHost(InterfaceRequest<ServiceWorkerContainerHost> interfaceRequest);

  void ensureControllerServiceWorker(
      InterfaceRequest<ControllerServiceWorker> interfaceRequest, int i);

  void ensureFileAccess(
      FilePath[] filePathArr, EnsureFileAccess_Response ensureFileAccess_Response);

  void getRegistration(Url url, GetRegistration_Response getRegistration_Response);

  void getRegistrationForReady(GetRegistrationForReady_Response getRegistrationForReady_Response);

  void getRegistrations(GetRegistrations_Response getRegistrations_Response);

  void hintToUpdateServiceWorker();

  void onExecutionReady();

  void register(
      Url url,
      ServiceWorkerRegistrationOptions serviceWorkerRegistrationOptions,
      FetchClientSettingsObject fetchClientSettingsObject,
      Register_Response register_Response);
}
