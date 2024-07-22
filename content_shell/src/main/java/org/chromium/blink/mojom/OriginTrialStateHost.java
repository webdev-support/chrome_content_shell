package org.chromium.blink.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.internal.mojom.Origin;

public interface OriginTrialStateHost extends Interface {
  public static final Interface.Manager<OriginTrialStateHost, Proxy> MANAGER =
      OriginTrialStateHost_Internal.MANAGER;

  public interface Proxy extends OriginTrialStateHost, Interface.Proxy {}

  void applyFeatureDiffForOriginTrial(Map<Integer, OriginTrialFeatureState> map);

  void enablePersistentTrial(String str, Origin[] originArr);
}
