package org.chromium.base;

import java.util.HashMap;

public abstract class Flag {

  private static HashMap<String, Flag> sFlagsCreated = new HashMap<>();
  protected final FeatureMap mFeatureMap;
  protected final String mFeatureName;

  protected abstract void clearInMemoryCachedValueForTesting();

  public abstract boolean isEnabled();

  public Flag(FeatureMap featureMap, String featureName) {
    if (sFlagsCreated.containsKey(featureName)) {
      throw new AssertionError("Duplicate flag creation for feature: " + featureName);
    }
    this.mFeatureMap = featureMap;
    this.mFeatureName = featureName;
    sFlagsCreated.put(featureName, this);
  }

  public String getFeatureName() {
    return this.mFeatureName;
  }

  public static void resetFlagsForTesting() {
    resetAllInMemoryCachedValuesForTesting();
    sFlagsCreated.clear();
  }

  public static void resetAllInMemoryCachedValuesForTesting() {
    for (Flag flag : sFlagsCreated.values()) {
      flag.clearInMemoryCachedValueForTesting();
    }
  }
}
