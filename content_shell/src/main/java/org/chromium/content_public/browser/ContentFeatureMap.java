package org.chromium.content_public.browser;

import org.chromium.base.FeatureMap;
import org.jni_zero.JNINamespace;

@JNINamespace("content::android")
public class ContentFeatureMap extends FeatureMap {
  private static final ContentFeatureMap sInstance = new ContentFeatureMap();

  public interface Natives {
    long getNativeMap();
  }

  private ContentFeatureMap() {}

  public static ContentFeatureMap getInstance() {
    return sInstance;
  }

  public static boolean isEnabled(String featureName) {
    return getInstance().isEnabledInNative(featureName);
  }

  @Override
  protected long getNativeMap() {
    return ContentFeatureMapJni.get().getNativeMap();
  }
}
