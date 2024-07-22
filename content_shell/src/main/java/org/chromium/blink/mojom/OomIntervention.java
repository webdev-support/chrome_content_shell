package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface OomIntervention extends Interface {
  public static final Interface.Manager<OomIntervention, Proxy> MANAGER =
      OomIntervention_Internal.MANAGER;

  public interface Proxy extends OomIntervention, Interface.Proxy {}

  void startDetection(
      OomInterventionHost oomInterventionHost,
      DetectionArgs detectionArgs,
      boolean z,
      boolean z2,
      boolean z3);
}
