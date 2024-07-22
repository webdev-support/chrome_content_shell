package org.chromium.ui.accessibility;

import org.chromium.base.FeatureMap;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class AccessibilityFeaturesMap extends FeatureMap {
  private static final AccessibilityFeaturesMap sInstance = new AccessibilityFeaturesMap();

  public interface Natives {
    long getNativeMap();
  }

  private AccessibilityFeaturesMap() {}

  public static AccessibilityFeaturesMap getInstance() {
    return sInstance;
  }

  public static boolean isEnabled(String featureName) {
    return getInstance().isEnabledInNative(featureName);
  }

  @Override
  protected long getNativeMap() {
    return AccessibilityFeaturesMapJni.get().getNativeMap();
  }
}
