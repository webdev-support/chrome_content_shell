package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface ContentDecryptionModuleClient extends Interface {
  public static final Interface.Manager<ContentDecryptionModuleClient, Proxy> MANAGER =
      ContentDecryptionModuleClient_Internal.MANAGER;

  public interface Proxy extends ContentDecryptionModuleClient, Interface.Proxy {}

  void onSessionClosed(String str, int i);

  void onSessionExpirationUpdate(String str, double d);

  void onSessionKeysChange(String str, boolean z, CdmKeyInformation[] cdmKeyInformationArr);

  void onSessionMessage(String str, int i, byte[] bArr);
}
