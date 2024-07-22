package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public interface FederatedAuthRequest extends Interface {
  public static final Interface.Manager<FederatedAuthRequest, Proxy> MANAGER =
      FederatedAuthRequest_Internal.MANAGER;

  public interface Disconnect_Response {
    void call(int i);
  }

  public interface PreventSilentAccess_Response {
    void call();
  }

  public interface Proxy extends FederatedAuthRequest, Interface.Proxy {}

  public interface RegisterIdP_Response {
    void call(boolean z);
  }

  public interface RequestToken_Response {
    void call(int i, Url url, String str, TokenError tokenError, boolean z);
  }

  public interface RequestUserInfo_Response {
    void call(int i, IdentityUserInfo[] identityUserInfoArr);
  }

  public interface ResolveTokenRequest_Response {
    void call(boolean z);
  }

  public interface UnregisterIdP_Response {
    void call(boolean z);
  }

  void cancelTokenRequest();

  void closeModalDialogView();

  void disconnect(
      IdentityCredentialDisconnectOptions identityCredentialDisconnectOptions,
      Disconnect_Response disconnect_Response);

  void preventSilentAccess(PreventSilentAccess_Response preventSilentAccess_Response);

  void registerIdP(Url url, RegisterIdP_Response registerIdP_Response);

  void requestToken(
      IdentityProviderGetParameters[] identityProviderGetParametersArr,
      int i,
      RequestToken_Response requestToken_Response);

  void requestUserInfo(
      IdentityProviderConfig identityProviderConfig,
      RequestUserInfo_Response requestUserInfo_Response);

  void resolveTokenRequest(String str, ResolveTokenRequest_Response resolveTokenRequest_Response);

  void setIdpSigninStatus(Origin origin, int i);

  void unregisterIdP(Url url, UnregisterIdP_Response unregisterIdP_Response);
}
