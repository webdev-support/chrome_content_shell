package org.chromium.base;

import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public abstract class Features {
  private final String mName;

  public interface Natives {
    boolean getFieldTrialParamByFeatureAsBoolean(long j, String str, boolean z);

    String getFieldTrialParamByFeatureAsString(long j, String str);

    boolean isEnabled(long j);
  }

  protected abstract long getFeaturePointer();

  protected Features(String name) {
    this.mName = name;
  }

  public String getName() {
    return this.mName;
  }

  public boolean isEnabled() {
    Boolean testValue = FeatureList.getTestValueForFeature(getName());
    return testValue != null
        ? testValue.booleanValue()
        : FeaturesJni.get().isEnabled(getFeaturePointer());
  }

  public boolean getFieldTrialParamByFeatureAsBoolean(String paramName, boolean defaultValue) {
    return FeaturesJni.get()
        .getFieldTrialParamByFeatureAsBoolean(getFeaturePointer(), paramName, defaultValue);
  }

  public String getFieldTrialParamByFeatureAsString(String paramName) {
    return FeaturesJni.get().getFieldTrialParamByFeatureAsString(getFeaturePointer(), paramName);
  }
}
