package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface HidConnectionClient extends Interface {
  public static final Interface.Manager<HidConnectionClient, Proxy> MANAGER =
      HidConnectionClient_Internal.MANAGER;

  public interface Proxy extends HidConnectionClient, Interface.Proxy {}

  void onInputReport(byte b, byte[] bArr);
}
