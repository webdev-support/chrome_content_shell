package org.chromium.base.cached_flags;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.chromium.base.FeatureMap;
import org.json.JSONException;
import org.json.JSONObject;

public class AllCachedFieldTrialParameters extends CachedFieldTrialParameter {
  private static Map<String, String> decodeJsonEncodedMap(String value) {
    Map<String, String> resultingMap = new HashMap<>();
    try {
      JSONObject json = new JSONObject(value);
      Iterator<String> keys = json.keys();
      while (keys.hasNext()) {
        String key = keys.next();
        resultingMap.put(key, json.getString(key));
      }
      return resultingMap;
    } catch (JSONException e) {
      return new HashMap();
    }
  }

  private static String encodeParams(Map<String, String> params) {
    return new JSONObject(params).toString();
  }

  public AllCachedFieldTrialParameters(FeatureMap featureMap, String featureName) {
    super(featureMap, featureName, "", 4);
  }

  public Map<String, String> getParams() {
    return decodeJsonEncodedMap(getConsistentStringValue());
  }

  private String getConsistentStringValue() {
    CachedFlagsSafeMode.getInstance().onFlagChecked();
    String preferenceName = getSharedPreferenceKey();
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
          CachedFlagsSafeMode.getInstance().getStringFieldTrialParam(preferenceName, "");
      if (value3 == null) {
        value3 = CachedFlagsSharedPreferences.getInstance().readString(preferenceName, "");
      }
      ValuesReturned.sStringValues.put(preferenceName, value3);
      return value3;
    }
  }

  @Override
  public void cacheToDisk() {
    Map<String, String> params = this.mFeatureMap.getFieldTrialParamsForFeature(getFeatureName());
    CachedFlagsSharedPreferences.getInstance()
        .writeString(getSharedPreferenceKey(), encodeParams(params));
  }

  public static void setForTesting(String featureName, Map<String, String> params) {
    String preferenceKey = generateSharedPreferenceKey(featureName, "");
    String overrideValue = encodeParams(params);
    ValuesOverridden.setOverrideForTesting(preferenceKey, overrideValue);
  }
}
