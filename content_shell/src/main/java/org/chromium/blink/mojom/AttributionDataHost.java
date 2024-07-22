package org.chromium.blink.mojom;

import org.chromium.attribution_reporting.mojom.OsRegistration;
import org.chromium.attribution_reporting.mojom.SourceRegistration;
import org.chromium.attribution_reporting.mojom.SuitableOrigin;
import org.chromium.attribution_reporting.mojom.TriggerRegistration;
import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.TriggerVerification;

public interface AttributionDataHost extends Interface {
  public static final Interface.Manager<AttributionDataHost, Proxy> MANAGER =
      AttributionDataHost_Internal.MANAGER;

  public interface Proxy extends AttributionDataHost, Interface.Proxy {}

  void osSourceDataAvailable(OsRegistration osRegistration);

  void osTriggerDataAvailable(OsRegistration osRegistration);

  void sourceDataAvailable(SuitableOrigin suitableOrigin, SourceRegistration sourceRegistration);

  void triggerDataAvailable(
      SuitableOrigin suitableOrigin,
      TriggerRegistration triggerRegistration,
      TriggerVerification[] triggerVerificationArr);
}
