package org.chromium.ui.accessibility;

import org.chromium.base.FeatureMap;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class UiAccessibilityFeatureMap extends FeatureMap {
  private static final UiAccessibilityFeatureMap sInstance = new UiAccessibilityFeatureMap();

  public interface Natives {
    long getNativeMap();
  }

  private UiAccessibilityFeatureMap() {}

  public static UiAccessibilityFeatureMap getInstance() {
    return sInstance;
  }

  public static boolean isEnabled(String featureName) {
    return getInstance().isEnabledInNative(featureName);
  }

  @Override
  protected long getNativeMap() {
    return UiAccessibilityFeatureMapJni.get().getNativeMap();
  }
}
