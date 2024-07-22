package org.chromium.blink.test.mojom;

import org.chromium.mojo.bindings.Interface;

public interface VirtualAuthenticatorManager extends Interface {
  public static final Interface.Manager<VirtualAuthenticatorManager, Proxy> MANAGER =
      VirtualAuthenticatorManager_Internal.MANAGER;

  public interface ClearAuthenticators_Response {
    void call();
  }

  public interface CreateAuthenticator_Response {
    void call(VirtualAuthenticator virtualAuthenticator);
  }

  public interface GetAuthenticators_Response {
    void call(VirtualAuthenticator[] virtualAuthenticatorArr);
  }

  public interface Proxy extends VirtualAuthenticatorManager, Interface.Proxy {}

  public interface RemoveAuthenticator_Response {
    void call(boolean z);
  }

  void clearAuthenticators(ClearAuthenticators_Response clearAuthenticators_Response);

  void createAuthenticator(
      VirtualAuthenticatorOptions virtualAuthenticatorOptions,
      CreateAuthenticator_Response createAuthenticator_Response);

  void getAuthenticators(GetAuthenticators_Response getAuthenticators_Response);

  void removeAuthenticator(String str, RemoveAuthenticator_Response removeAuthenticator_Response);
}
