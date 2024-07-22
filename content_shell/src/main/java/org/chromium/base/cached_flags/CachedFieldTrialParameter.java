package org.chromium.base.cached_flags;

import com.example.chromium_content_view.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import org.chromium.base.FeatureMap;

public abstract class CachedFieldTrialParameter {

  private static Set<CachedFieldTrialParameter> sAllInstances;
  protected final FeatureMap mFeatureMap;
  private final String mFeatureName;
  private final String mParameterName;
  private final int mType;

  @Retention(RetentionPolicy.SOURCE)
  public @interface FieldTrialParameterType {
    public static final int ALL = 4;
    public static final int BOOLEAN = 1;
    public static final int DOUBLE = 3;
    public static final int INT = 2;
    public static final int STRING = 0;
  }

  public abstract void cacheToDisk();

  public CachedFieldTrialParameter(
      FeatureMap featureMap, String featureName, String parameterName, int type) {
    this.mFeatureMap = featureMap;
    this.mFeatureName = featureName;
    if (type == 4 && !parameterName.isEmpty()) {
      throw new AssertionError();
    }
    this.mParameterName = parameterName;
    this.mType = type;
    registerInstance();
  }

  private void registerInstance() {
    if (BuildConfig.ENABLE_ASSERTS) {
      if (sAllInstances == null) {
        sAllInstances = new HashSet();
      }
      sAllInstances.add(this);
    }
  }

  public static Set<CachedFieldTrialParameter> getAllInstances() {
    return sAllInstances;
  }

  public String getFeatureName() {
    return this.mFeatureName;
  }

  public String getParameterName() {
    return this.mParameterName;
  }

  public int getType() {
    return this.mType;
  }

  private static String generateFullName(String featureName, String parameterName) {
    return featureName + ":" + parameterName;
  }

  public static String generateSharedPreferenceKey(String featureName, String parameterName) {
    return CachedFlagsSharedPreferences.FLAGS_FIELD_TRIAL_PARAM_CACHED.createKey(
        generateFullName(featureName, parameterName));
  }

  public String getSharedPreferenceKey() {
    return generateSharedPreferenceKey(getFeatureName(), getParameterName());
  }

  public static void setForTesting(
      String featureName, String variationName, String stringVariationValue) {
    String preferenceKey = generateSharedPreferenceKey(featureName, variationName);
    ValuesOverridden.setOverrideForTesting(preferenceKey, stringVariationValue);
  }
}
