package org.chromium.base.cached_flags;

import org.chromium.base.FeatureMap;

public class DoubleCachedFieldTrialParameter extends CachedFieldTrialParameter {
  private double mDefaultValue;

  public DoubleCachedFieldTrialParameter(
      FeatureMap featureMap, String featureName, String variationName, double defaultValue) {
    super(featureMap, featureName, variationName, 3);
    this.mDefaultValue = defaultValue;
  }

  public double getValue() {
    CachedFlagsSafeMode.getInstance().onFlagChecked();
    String preferenceName = getSharedPreferenceKey();
    double defaultValue = getDefaultValue();
    Double value = ValuesOverridden.getDouble(preferenceName);
    if (value != null) {
      return value.doubleValue();
    }
    synchronized (ValuesReturned.sDoubleValues) {
      Double value2 = ValuesReturned.sDoubleValues.get(preferenceName);
      if (value2 != null) {
        return value2.doubleValue();
      }
      Double value3 =
          CachedFlagsSafeMode.getInstance().getDoubleFieldTrialParam(preferenceName, defaultValue);
      if (value3 == null) {
        value3 =
            CachedFlagsSharedPreferences.getInstance().readDouble(preferenceName, defaultValue);
      }
      ValuesReturned.sDoubleValues.put(preferenceName, value3);
      return value3.doubleValue();
    }
  }

  public double getDefaultValue() {
    return this.mDefaultValue;
  }

  @Override
  public void cacheToDisk() {
    double value =
        this.mFeatureMap.getFieldTrialParamByFeatureAsDouble(
            getFeatureName(), getParameterName(), getDefaultValue());
    CachedFlagsSharedPreferences.getInstance().writeDouble(getSharedPreferenceKey(), value);
  }

  public void setForTesting(double overrideValue) {
    ValuesOverridden.setOverrideForTesting(getSharedPreferenceKey(), String.valueOf(overrideValue));
  }
}
