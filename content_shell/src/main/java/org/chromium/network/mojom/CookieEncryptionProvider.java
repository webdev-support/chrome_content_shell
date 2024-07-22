package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.os_crypt_async.mojom.Encryptor;

public interface CookieEncryptionProvider extends Interface {
  public static final Interface.Manager<CookieEncryptionProvider, Proxy> MANAGER =
      CookieEncryptionProvider_Internal.MANAGER;

  public interface GetEncryptor_Response {
    void call(Encryptor encryptor);
  }

  public interface Proxy extends CookieEncryptionProvider, Interface.Proxy {}

  void getEncryptor(GetEncryptor_Response getEncryptor_Response);
}
