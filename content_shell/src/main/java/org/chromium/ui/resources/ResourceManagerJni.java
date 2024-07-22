package org.chromium.ui.resources;

import android.graphics.Bitmap;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ResourceManagerJni implements ResourceManager.Natives {

  public static final JniStaticTestMocker<ResourceManager.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ResourceManager.Natives>() {
        @Override
        public void setInstanceForTesting(ResourceManager.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ResourceManagerJni.testInstance = instance;
        }
      };
  private static ResourceManager.Natives testInstance;

  ResourceManagerJni() {}

  @Override
  public void clearTintedResourceCache(long nativeResourceManagerImpl, ResourceManager caller) {
    if (nativeResourceManagerImpl == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_resources_ResourceManager_clearTintedResourceCache(
        nativeResourceManagerImpl, caller);
  }

  @Override
  public void onResourceReady(
      long nativeResourceManagerImpl,
      ResourceManager caller,
      int resType,
      int resId,
      Bitmap bitmap,
      int width,
      int height,
      long nativeResource) {
    if (nativeResourceManagerImpl == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_resources_ResourceManager_onResourceReady(
        nativeResourceManagerImpl, caller, resType, resId, bitmap, width, height, nativeResource);
  }

  @Override
  public void removeResource(
      long nativeResourceManagerImpl, ResourceManager caller, int resType, int resId) {
    if (nativeResourceManagerImpl == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_ui_resources_ResourceManager_removeResource(
        nativeResourceManagerImpl, caller, resType, resId);
  }

  public static ResourceManager.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ResourceManager.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ResourceManager.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ResourceManagerJni();
  }
}
