package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface StorageAreaObserver extends Interface {
  public static final Interface.Manager<StorageAreaObserver, Proxy> MANAGER =
      StorageAreaObserver_Internal.MANAGER;

  public interface Proxy extends StorageAreaObserver, Interface.Proxy {}

  void allDeleted(boolean z, String str);

  void keyChangeFailed(byte[] bArr, String str);

  void keyChanged(byte[] bArr, byte[] bArr2, byte[] bArr3, String str);

  void keyDeleted(byte[] bArr, byte[] bArr2, String str);

  void shouldSendOldValueOnMutations(boolean z);
}
