package org.chromium.base.cached_flags;

import org.chromium.base.FeatureList;
import org.chromium.base.FeatureMap;
import org.chromium.base.Flag;

public class PostNativeFlag extends Flag {
  private Boolean mInMemoryCachedValue;

  public PostNativeFlag(FeatureMap featureMap, String featureName) {
    super(featureMap, featureName);
  }

  @Override
  public boolean isEnabled() {
    Boolean bool = this.mInMemoryCachedValue;
    if (bool != null) {
      return bool.booleanValue();
    }
    if (FeatureList.hasTestFeature(this.mFeatureName)) {
      return this.mFeatureMap.isEnabledInNative(this.mFeatureName);
    }
    Boolean valueOf = Boolean.valueOf(this.mFeatureMap.isEnabledInNative(this.mFeatureName));
    this.mInMemoryCachedValue = valueOf;
    return valueOf.booleanValue();
  }

  @Override
  protected void clearInMemoryCachedValueForTesting() {
    this.mInMemoryCachedValue = null;
  }
}
