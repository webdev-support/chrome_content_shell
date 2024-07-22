package org.chromium.base.cached_flags;

import java.util.List;

public class CachedFlagUtils {
  public static void cacheNativeFlags(List<CachedFlag> featuresToCache) {
    for (CachedFlag feature : featuresToCache) {
      feature.cacheFeature();
    }
  }

  public static void cacheFieldTrialParameters(List<CachedFieldTrialParameter> parameters) {
    for (CachedFieldTrialParameter parameter : parameters) {
      parameter.cacheToDisk();
    }
  }

  public static void resetFlagsForTesting() {
    ValuesReturned.clearForTesting();
    ValuesOverridden.removeOverrides();
  }
}
