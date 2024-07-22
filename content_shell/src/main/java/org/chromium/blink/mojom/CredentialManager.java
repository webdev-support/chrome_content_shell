package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface CredentialManager extends Interface {
  public static final Interface.Manager<CredentialManager, Proxy> MANAGER =
      CredentialManager_Internal.MANAGER;

  public interface Get_Response {
    void call(int i, CredentialInfo credentialInfo);
  }

  public interface PreventSilentAccess_Response {
    void call();
  }

  public interface Proxy extends CredentialManager, Interface.Proxy {}

  public interface Store_Response {
    void call();
  }

  void get(int i, boolean z, Url[] urlArr, Get_Response get_Response);

  void preventSilentAccess(PreventSilentAccess_Response preventSilentAccess_Response);

  void store(CredentialInfo credentialInfo, Store_Response store_Response);
}
