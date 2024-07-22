package org.chromium.base.cached_flags;

import java.util.HashMap;
import java.util.Map;

class ValuesOverridden {
  private static Map<String, String> sOverridesTestFeatures;

  ValuesOverridden() {}

  public static void setOverrideForTesting(String preferenceKey, String overrideValue) {
    if (sOverridesTestFeatures == null) {
      sOverridesTestFeatures = new HashMap();
    }
    sOverridesTestFeatures.put(preferenceKey, overrideValue);
  }

  public static Boolean getBool(String preferenceName) {
    String stringValue;
    Map<String, String> map = sOverridesTestFeatures;
    if (map == null || (stringValue = map.get(preferenceName)) == null) {
      return null;
    }
    return Boolean.valueOf(stringValue);
  }

  public static String getString(String preferenceName) {
    Map<String, String> map = sOverridesTestFeatures;
    if (map == null) {
      return null;
    }
    return map.get(preferenceName);
  }

  public static Integer getInt(String preferenceName) {
    String stringValue;
    Map<String, String> map = sOverridesTestFeatures;
    if (map == null || (stringValue = map.get(preferenceName)) == null) {
      return null;
    }
    return Integer.valueOf(stringValue);
  }

  public static Double getDouble(String preferenceName) {
    String stringValue;
    Map<String, String> map = sOverridesTestFeatures;
    if (map == null || (stringValue = map.get(preferenceName)) == null) {
      return null;
    }
    return Double.valueOf(stringValue);
  }

  public static void removeOverrides() {
    sOverridesTestFeatures = null;
  }
}
