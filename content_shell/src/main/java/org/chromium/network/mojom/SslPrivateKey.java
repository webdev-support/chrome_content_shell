package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SslPrivateKey extends Interface {
  public static final Interface.Manager<SslPrivateKey, Proxy> MANAGER =
      SslPrivateKey_Internal.MANAGER;

  public interface Proxy extends SslPrivateKey, Interface.Proxy {}

  public interface Sign_Response {
    void call(int i, byte[] bArr);
  }

  void sign(short s, byte[] bArr, Sign_Response sign_Response);
}
