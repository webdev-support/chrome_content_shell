package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface NfcClient extends Interface {
  public static final Interface.Manager<NfcClient, Proxy> MANAGER = NfcClient_Internal.MANAGER;

  public interface Proxy extends NfcClient, Interface.Proxy {}

  void onError(NdefError ndefError);

  void onWatch(int[] iArr, String str, NdefMessage ndefMessage);
}
