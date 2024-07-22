package org.chromium.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public abstract class FeatureMap {

  private long mNativeMapPtr;

  public interface Natives {
    String getFieldTrialParamByFeature(long j, String str, String str2);

    boolean getFieldTrialParamByFeatureAsBoolean(long j, String str, String str2, boolean z);

    double getFieldTrialParamByFeatureAsDouble(long j, String str, String str2, double d);

    int getFieldTrialParamByFeatureAsInt(long j, String str, String str2, int i);

    String[] getFlattedFieldTrialParamsForFeature(long j, String str);

    boolean isEnabled(long j, String str);
  }

  protected abstract long getNativeMap();

  public boolean isEnabledInNative(String featureName) {
    Boolean testValue = FeatureList.getTestValueForFeature(featureName);
    if (testValue != null) {
      return testValue.booleanValue();
    }
    ensureNativeMapInit();
    return FeatureMapJni.get().isEnabled(this.mNativeMapPtr, featureName);
  }

  public String getFieldTrialParamByFeature(String featureName, String paramName) {
    String testValue = FeatureList.getTestValueForFieldTrialParam(featureName, paramName);
    if (testValue != null) {
      return testValue;
    }
    if (FeatureList.hasTestFeatures()) {
      return "";
    }
    ensureNativeMapInit();
    return FeatureMapJni.get()
        .getFieldTrialParamByFeature(this.mNativeMapPtr, featureName, paramName);
  }

  public boolean getFieldTrialParamByFeatureAsBoolean(
      String featureName, String paramName, boolean defaultValue) {
    String testValue = FeatureList.getTestValueForFieldTrialParam(featureName, paramName);
    if (testValue != null) {
      return Boolean.valueOf(testValue).booleanValue();
    }
    if (FeatureList.hasTestFeatures()) {
      return defaultValue;
    }
    ensureNativeMapInit();
    return FeatureMapJni.get()
        .getFieldTrialParamByFeatureAsBoolean(
            this.mNativeMapPtr, featureName, paramName, defaultValue);
  }

  public int getFieldTrialParamByFeatureAsInt(
      String featureName, String paramName, int defaultValue) {
    String testValue = FeatureList.getTestValueForFieldTrialParam(featureName, paramName);
    if (testValue != null) {
      return Integer.valueOf(testValue).intValue();
    }
    if (FeatureList.hasTestFeatures()) {
      return defaultValue;
    }
    ensureNativeMapInit();
    return FeatureMapJni.get()
        .getFieldTrialParamByFeatureAsInt(this.mNativeMapPtr, featureName, paramName, defaultValue);
  }

  public double getFieldTrialParamByFeatureAsDouble(
      String featureName, String paramName, double defaultValue) {
    String testValue = FeatureList.getTestValueForFieldTrialParam(featureName, paramName);
    if (testValue != null) {
      return Double.valueOf(testValue).doubleValue();
    }
    if (FeatureList.hasTestFeatures()) {
      return defaultValue;
    }
    ensureNativeMapInit();
    return FeatureMapJni.get()
        .getFieldTrialParamByFeatureAsDouble(
            this.mNativeMapPtr, featureName, paramName, defaultValue);
  }

  public Map<String, String> getFieldTrialParamsForFeature(String featureName) {
    Map<String, String> testValues =
        FeatureList.getTestValuesForAllFieldTrialParamsForFeature(featureName);
    if (testValues != null) {
      return testValues;
    }
    if (FeatureList.hasTestFeatures()) {
      return Collections.emptyMap();
    }
    ensureNativeMapInit();
    Map<String, String> result = new HashMap<>();
    String[] flattenedParams =
        FeatureMapJni.get().getFlattedFieldTrialParamsForFeature(this.mNativeMapPtr, featureName);
    for (int i = 0; i < flattenedParams.length; i += 2) {
      result.put(flattenedParams[i], flattenedParams[i + 1]);
    }
    return result;
  }

  public MutableFlagWithSafeDefault mutableFlagWithSafeDefault(
      String featureName, boolean defaultValue) {
    return new MutableFlagWithSafeDefault(this, featureName, defaultValue);
  }

  private void ensureNativeMapInit() {
    if (!FeatureList.isNativeInitialized()) {
      throw new AssertionError();
    }
    if (this.mNativeMapPtr == 0) {
      long nativeMap = getNativeMap();
      this.mNativeMapPtr = nativeMap;
      if (nativeMap == 0) {
        throw new AssertionError();
      }
    }
  }
}
