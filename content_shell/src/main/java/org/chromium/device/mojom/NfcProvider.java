package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface NfcProvider extends Interface {
  public static final Interface.Manager<NfcProvider, Proxy> MANAGER = NfcProvider_Internal.MANAGER;

  public interface Proxy extends NfcProvider, Interface.Proxy {}

  void getNfcForHost(int i, InterfaceRequest<Nfc> interfaceRequest);

  void resumeNfcOperations();

  void suspendNfcOperations();
}
