package org.chromium.ui.base;

import org.chromium.base.FeatureMap;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class UiAndroidFeatureMap extends FeatureMap {
  private static final UiAndroidFeatureMap sInstance = new UiAndroidFeatureMap();

  public interface Natives {
    long getNativeMap();
  }

  private UiAndroidFeatureMap() {}

  public static UiAndroidFeatureMap getInstance() {
    return sInstance;
  }

  public static boolean isEnabled(String featureName) {
    return getInstance().isEnabledInNative(featureName);
  }

  @Override
  protected long getNativeMap() {
    return UiAndroidFeatureMapJni.get().getNativeMap();
  }
}
