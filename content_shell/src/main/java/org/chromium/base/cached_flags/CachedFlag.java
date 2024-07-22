package org.chromium.base.cached_flags;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.chromium.base.FeatureMap;
import org.chromium.base.Flag;
import org.chromium.base.shared_preferences.SharedPreferencesManager;

public class CachedFlag extends Flag {
  private final boolean mDefaultValue;
  private String mPreferenceKey;

  public CachedFlag(FeatureMap featureMap, String featureName, boolean defaultValue) {
    super(featureMap, featureName);
    this.mDefaultValue = defaultValue;
  }

  @Override
  public boolean isEnabled() {
    CachedFlagsSafeMode.getInstance().onFlagChecked();
    String preferenceName = getSharedPreferenceKey();
    synchronized (ValuesReturned.sBoolValues) {
      Map<String, Boolean> boolValuesReturned = ValuesReturned.sBoolValues;
      Boolean flag = boolValuesReturned.get(preferenceName);
      if (flag != null) {
        return flag.booleanValue();
      }
      Boolean flag2 =
          CachedFlagsSafeMode.getInstance()
              .isEnabled(this.mFeatureName, preferenceName, this.mDefaultValue);
      if (flag2 == null) {
        SharedPreferencesManager prefs = CachedFlagsSharedPreferences.getInstance();
        if (prefs.contains(preferenceName)) {
          flag2 = Boolean.valueOf(prefs.readBoolean(preferenceName, false));
        } else {
          flag2 = Boolean.valueOf(this.mDefaultValue);
        }
      }
      boolValuesReturned.put(preferenceName, flag2);
      return flag2.booleanValue();
    }
  }

  public boolean getDefaultValue() {
    return this.mDefaultValue;
  }

  @Override
  protected void clearInMemoryCachedValueForTesting() {}

  @Deprecated
  public void setForTesting(Boolean value) {
    synchronized (ValuesReturned.sBoolValues) {
      ValuesReturned.sBoolValues.put(getSharedPreferenceKey(), value);
    }
  }

  public void cacheFeature() {
    boolean isEnabledInNative = this.mFeatureMap.isEnabledInNative(this.mFeatureName);
    CachedFlagsSharedPreferences.getInstance()
        .writeBoolean(getSharedPreferenceKey(), isEnabledInNative);
  }

  String getSharedPreferenceKey() {
    if (this.mPreferenceKey == null) {
      this.mPreferenceKey = CachedFlagsSharedPreferences.FLAGS_CACHED.createKey(this.mFeatureName);
    }
    return this.mPreferenceKey;
  }

  @Deprecated
  public static void setFeaturesForTesting(Map<String, Boolean> features) {
    for (Map.Entry<String, Boolean> entry : features.entrySet()) {
      String featureName = entry.getKey();
      Boolean flagValue = entry.getValue();
      String sharedPreferencesKey =
          CachedFlagsSharedPreferences.FLAGS_CACHED.createKey(featureName);
      synchronized (ValuesReturned.sBoolValues) {
        ValuesReturned.sBoolValues.put(sharedPreferencesKey, flagValue);
      }
    }
  }

  public static void resetDiskForTesting() {
    CachedFlagsSharedPreferences.getInstance()
        .removeKeysWithPrefix(CachedFlagsSharedPreferences.FLAGS_CACHED);
  }

  public static Map<String, CachedFlag> createCachedFlagMap(
      List<List<CachedFlag>> allCachedFlagsLists) {
    HashMap<String, CachedFlag> cachedFlagMap = new HashMap<>();
    for (List<CachedFlag> cachedFlagsList : allCachedFlagsLists) {
      for (CachedFlag cachedFlag : cachedFlagsList) {
        cachedFlagMap.put(cachedFlag.getFeatureName(), cachedFlag);
      }
    }
    return cachedFlagMap;
  }
}
