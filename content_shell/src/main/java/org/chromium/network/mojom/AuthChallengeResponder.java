package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AuthChallengeResponder extends Interface {
  public static final Interface.Manager<AuthChallengeResponder, Proxy> MANAGER =
      AuthChallengeResponder_Internal.MANAGER;

  public interface Proxy extends AuthChallengeResponder, Interface.Proxy {}

  void onAuthCredentials(AuthCredentials authCredentials);
}
