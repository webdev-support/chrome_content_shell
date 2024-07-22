package org.chromium.base;

public class MutableFlagWithSafeDefault extends Flag {
  private final boolean mDefaultValue;
  private Boolean mInMemoryCachedValue;

  public MutableFlagWithSafeDefault(
      FeatureMap featureMap, String featureName, boolean defaultValue) {
    super(featureMap, featureName);
    this.mDefaultValue = defaultValue;
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
    if (FeatureList.isNativeInitialized()) {
      Boolean valueOf = Boolean.valueOf(this.mFeatureMap.isEnabledInNative(this.mFeatureName));
      this.mInMemoryCachedValue = valueOf;
      return valueOf.booleanValue();
    }
    return this.mDefaultValue;
  }

  @Override
  protected void clearInMemoryCachedValueForTesting() {
    this.mInMemoryCachedValue = null;
  }
}
