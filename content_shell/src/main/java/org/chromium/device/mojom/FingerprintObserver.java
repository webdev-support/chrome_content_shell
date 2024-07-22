package org.chromium.device.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;

public interface FingerprintObserver extends Interface {
  public static final Interface.Manager<FingerprintObserver, Proxy> MANAGER =
      FingerprintObserver_Internal.MANAGER;

  public interface Proxy extends FingerprintObserver, Interface.Proxy {}

  void onAuthScanDone(FingerprintMessage fingerprintMessage, Map<String, String[]> map);

  void onEnrollScanDone(int i, boolean z, int i2);

  void onRestarted();

  void onSessionFailed();

  void onStatusChanged(int i);
}
