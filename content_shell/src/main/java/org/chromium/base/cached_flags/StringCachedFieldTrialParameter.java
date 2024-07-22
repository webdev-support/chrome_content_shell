package org.chromium.base.cached_flags;

import org.chromium.base.FeatureMap;

public class StringCachedFieldTrialParameter extends CachedFieldTrialParameter {
  private final String mDefaultValue;

  public StringCachedFieldTrialParameter(
      FeatureMap featureMap, String featureName, String variationName, String defaultValue) {
    super(featureMap, featureName, variationName, 0);
    this.mDefaultValue = defaultValue;
  }

  public String getValue() {
    CachedFlagsSafeMode.getInstance().onFlagChecked();
    String preferenceName = getSharedPreferenceKey();
    String defaultValue = getDefaultValue();
    String value = ValuesOverridden.getString(preferenceName);
    if (value != null) {
      return value;
    }
    synchronized (ValuesReturned.sStringValues) {
      String value2 = ValuesReturned.sStringValues.get(preferenceName);
      if (value2 != null) {
        return value2;
      }
      String value3 =
          CachedFlagsSafeMode.getInstance().getStringFieldTrialParam(preferenceName, defaultValue);
      if (value3 == null) {
        value3 =
            CachedFlagsSharedPreferences.getInstance().readString(preferenceName, defaultValue);
      }
      ValuesReturned.sStringValues.put(preferenceName, value3);
      return value3;
    }
  }

  public String getDefaultValue() {
    return this.mDefaultValue;
  }

  @Override
  public void cacheToDisk() {
    String value =
        this.mFeatureMap.getFieldTrialParamByFeature(getFeatureName(), getParameterName());
    CachedFlagsSharedPreferences.getInstance()
        .writeString(getSharedPreferenceKey(), value.isEmpty() ? getDefaultValue() : value);
  }

  public void setForTesting(String overrideValue) {
    ValuesOverridden.setOverrideForTesting(getSharedPreferenceKey(), overrideValue);
  }
}
