package org.chromium.base.cached_flags;

import org.chromium.base.FeatureMap;

public class BooleanCachedFieldTrialParameter extends CachedFieldTrialParameter {
  private boolean mDefaultValue;

  public BooleanCachedFieldTrialParameter(
      FeatureMap featureMap, String featureName, String variationName, boolean defaultValue) {
    super(featureMap, featureName, variationName, 1);
    this.mDefaultValue = defaultValue;
  }

  public boolean getValue() {
    CachedFlagsSafeMode.getInstance().onFlagChecked();
    String preferenceName = getSharedPreferenceKey();
    boolean defaultValue = getDefaultValue();
    Boolean value = ValuesOverridden.getBool(preferenceName);
    if (value != null) {
      return value.booleanValue();
    }
    synchronized (ValuesReturned.sBoolValues) {
      Boolean value2 = ValuesReturned.sBoolValues.get(preferenceName);
      if (value2 != null) {
        return value2.booleanValue();
      }
      Boolean value3 =
          CachedFlagsSafeMode.getInstance().getBooleanFieldTrialParam(preferenceName, defaultValue);
      if (value3 == null) {
        value3 =
            Boolean.valueOf(
                CachedFlagsSharedPreferences.getInstance()
                    .readBoolean(preferenceName, defaultValue));
      }
      ValuesReturned.sBoolValues.put(preferenceName, value3);
      return value3.booleanValue();
    }
  }

  public boolean getDefaultValue() {
    return this.mDefaultValue;
  }

  @Override
  public void cacheToDisk() {
    boolean value =
        this.mFeatureMap.getFieldTrialParamByFeatureAsBoolean(
            getFeatureName(), getParameterName(), getDefaultValue());
    CachedFlagsSharedPreferences.getInstance().writeBoolean(getSharedPreferenceKey(), value);
  }

  public void setForTesting(boolean overrideValue) {
    ValuesOverridden.setOverrideForTesting(getSharedPreferenceKey(), String.valueOf(overrideValue));
  }
}
