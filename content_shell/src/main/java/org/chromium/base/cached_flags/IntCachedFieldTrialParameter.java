package org.chromium.base.cached_flags;

import org.chromium.base.FeatureMap;

public class IntCachedFieldTrialParameter extends CachedFieldTrialParameter {
  private int mDefaultValue;

  public IntCachedFieldTrialParameter(
      FeatureMap featureMap, String featureName, String variationName, int defaultValue) {
    super(featureMap, featureName, variationName, 2);
    this.mDefaultValue = defaultValue;
  }

  public int getValue() {
    CachedFlagsSafeMode.getInstance().onFlagChecked();
    String preferenceName = getSharedPreferenceKey();
    int defaultValue = getDefaultValue();
    Integer value = ValuesOverridden.getInt(preferenceName);
    if (value != null) {
      return value.intValue();
    }
    synchronized (ValuesReturned.sIntValues) {
      Integer value2 = ValuesReturned.sIntValues.get(preferenceName);
      if (value2 != null) {
        return value2.intValue();
      }
      Integer value3 =
          CachedFlagsSafeMode.getInstance().getIntFieldTrialParam(preferenceName, defaultValue);
      if (value3 == null) {
        value3 =
            Integer.valueOf(
                CachedFlagsSharedPreferences.getInstance().readInt(preferenceName, defaultValue));
      }
      ValuesReturned.sIntValues.put(preferenceName, value3);
      return value3.intValue();
    }
  }

  public int getDefaultValue() {
    return this.mDefaultValue;
  }

  @Override
  public void cacheToDisk() {
    int value =
        this.mFeatureMap.getFieldTrialParamByFeatureAsInt(
            getFeatureName(), getParameterName(), getDefaultValue());
    CachedFlagsSharedPreferences.getInstance().writeInt(getSharedPreferenceKey(), value);
  }

  public void setForTesting(int overrideValue) {
    ValuesOverridden.setOverrideForTesting(getSharedPreferenceKey(), String.valueOf(overrideValue));
  }
}
