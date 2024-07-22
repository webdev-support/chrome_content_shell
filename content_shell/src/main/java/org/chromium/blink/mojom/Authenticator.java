package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface Authenticator extends Interface {
  public static final Interface.Manager<Authenticator, Proxy> MANAGER =
      Authenticator_Internal.MANAGER;

  public interface GetAssertion_Response {
    void call(
        int i,
        GetAssertionAuthenticatorResponse getAssertionAuthenticatorResponse,
        WebAuthnDomExceptionDetails webAuthnDomExceptionDetails);
  }

  public interface IsConditionalMediationAvailable_Response {
    void call(boolean z);
  }

  public interface IsUserVerifyingPlatformAuthenticatorAvailable_Response {
    void call(boolean z);
  }

  public interface MakeCredential_Response {
    void call(
        int i,
        MakeCredentialAuthenticatorResponse makeCredentialAuthenticatorResponse,
        WebAuthnDomExceptionDetails webAuthnDomExceptionDetails);
  }

  public interface Proxy extends Authenticator, Interface.Proxy {}

  void cancel();

  void getAssertion(
      PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions,
      GetAssertion_Response getAssertion_Response);

  void isConditionalMediationAvailable(
      IsConditionalMediationAvailable_Response isConditionalMediationAvailable_Response);

  void isUserVerifyingPlatformAuthenticatorAvailable(
      IsUserVerifyingPlatformAuthenticatorAvailable_Response
          isUserVerifyingPlatformAuthenticatorAvailable_Response);

  void makeCredential(
      PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions,
      MakeCredential_Response makeCredential_Response);
}
