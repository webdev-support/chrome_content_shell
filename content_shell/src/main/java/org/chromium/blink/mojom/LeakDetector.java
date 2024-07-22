package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface LeakDetector extends Interface {
  public static final Interface.Manager<LeakDetector, Proxy> MANAGER =
      LeakDetector_Internal.MANAGER;

  public interface PerformLeakDetection_Response {
    void call(LeakDetectionResult leakDetectionResult);
  }

  public interface Proxy extends LeakDetector, Interface.Proxy {}

  void performLeakDetection(PerformLeakDetection_Response performLeakDetection_Response);
}
